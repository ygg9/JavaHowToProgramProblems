package com.jits.kiosk.desktop;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;
import Week4.XmlManager.DeliveryInformation;
import Week4.XmlManager.DeliveryInformationList;
import com.jits.core.Address;
import com.jits.core.Box;
import com.jits.core.Letter;
import com.jits.transfer.IConfirmation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class KioskRequestHandler {
    private Parcel parcel = null;
    private static ArrayList<DeliveryInformation> shippedParcels = new ArrayList<DeliveryInformation>();

	/**
	 * Called from UI after user has entered all data. UI will display the
	 * returned IConfirmation data via IConfirmation.toString() and prompt user
	 * for whether to proceed or cancel the shipment.
	 */
	public IConfirmation handleRequest(Map request) {
	    String id = request.get("id").toString();
	    String type = request.get("type").toString();
	    String toName = request.get("toName").toString();
	    String toStreet = request.get("toStreet").toString();
	    String toCity = request.get("toCity").toString();
	    String toState = request.get("toState").toString();
	    String toZip = request.get("toZip").toString();

	    Address to = new Address(toName, toStreet, toCity, toState, toZip);

	    String fromName = request.get("fromName").toString();
	    String fromStreet = request.get("fromStreet").toString();
	    String fromCity = request.get("fromCity").toString();
	    String fromState = request.get("fromState").toString();
	    String fromZip = request.get("fromZip").toString();

	    Address from = new Address(fromName, fromStreet, fromCity, fromState, fromZip);

        DeliveryMethod deliveryMethod = null;
        if(type.contains("A")){
            deliveryMethod = DeliveryMethod.AIR;
        } else if (type.contains("G")){
            deliveryMethod = DeliveryMethod.GROUND;
        } else if (type.contains("T")){
            deliveryMethod = DeliveryMethod.RAIL;
        }

	    if(type.contains("B")){ // if box
            double height = Double.parseDouble(request.get("height").toString());
            double width = Double.parseDouble(request.get("width").toString());
            double depth = Double.parseDouble(request.get("depth").toString());

            boolean insured = Boolean.parseBoolean(request.get("insured").toString());

            parcel = new Box(id, from, to, deliveryMethod, height, width, depth, insured);
        }
        else if(type.contains("L")){ // if letter
            String letterType = request.get("ltype").toString();

            Durability durability = null;
            if(letterType.equals("plain")){
                durability = Durability.PLAIN;
            } else if (letterType.equals("fire")){
                durability = Durability.FIREPROOF;
            } else if (letterType.equals("weather")){
                durability = Durability.WEATHERPROOF;
            }

            parcel = new Letter(id, from, to, deliveryMethod, durability);
	    }

	    parcel.setWeight((double)Math.round(parcel.weighParcel() *100d)/100); //weighs parcel
        parcel.prepareForDelivery();
        parcel.setStatus("Ready for delivery");
		return parcel;
	}

	/**
	 * Called from UI after user has chosen to proceed or cancel the shipment.
	 * UI will display the returned IConfirmation data via
	 * IConfirmation.toString(). After this call returns, shipment is now done
	 * or has been cancelled.
	 */
	public IConfirmation handleUserDecision(boolean proceedWithShipment) {
        if(proceedWithShipment){
            shippedParcels.add(parcel.createDeliveryInformation());
            parcel.setStatus("Shipped");
            try{
                xmlParcel(shippedParcels);
            } catch(JAXBException e){
                System.err.println(e);
            }
        }else{
            parcel.setStatus("Canceled");
        }
		return parcel;
	}

    public static void xmlParcel(ArrayList<DeliveryInformation> deliveryInformation) throws JAXBException {
        DeliveryInformationList deliveryInformationList = new DeliveryInformationList();
        deliveryInformationList.setDeliveryInformationArrayList(deliveryInformation);

        JAXBContext context = JAXBContext.newInstance(DeliveryInformationList.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(deliveryInformationList, new File("deliveryInformation.xml"));
    }
}