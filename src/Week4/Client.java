package Week4;

import com.jits.core.Box;
import com.jits.core.Letter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args){
        Address boxFrom = new Address("Brandon", "cityline", "richardson", "tx", "12345");
        Address boxTo = new Address("Bob", "george bush", "plano", "tx", "5432");

        Address letterFrom = new Address("Mary", "lkdsf", "amarillo", "tx", "123456412");
        Address letterTo = new Address("Dede", "Snake street", "paris", "tx", "9845");

        //create all different kinds of parcels
        Parcel boxGround = new Box("12", boxFrom, boxTo, DeliveryMethod.GROUND, 124, 124, 23);
        Parcel boxAir = new Box("432", boxTo, boxFrom, DeliveryMethod.AIR, 252,234,34);

        Parcel letterGround = new Letter("1235", letterFrom, letterTo, DeliveryMethod.GROUND, Durability.WEATHERPROOF);
        Parcel letterAir = new Letter("53432", letterTo, letterFrom, DeliveryMethod.AIR, Durability.FIREPROOF);

        ArrayList<Parcel> parcels = new ArrayList<Parcel>();

        parcels.add(boxGround);
        parcels.add(boxAir);
        parcels.add(letterGround);
        parcels.add(letterAir);

        ArrayList<DeliveryInformation> deliveryInformations = new ArrayList<DeliveryInformation>();

        for(Parcel p: parcels){
            displayParcel(p);
            deliveryInformations.add(p.createDeliveryInformation());
        }

        try{
            xmlParcel(deliveryInformations);
        } catch(JAXBException e){

        }
    }
    
    public static void displayParcel(Parcel parcel){
        DeliveryInformation deliveryInformation = parcel.createDeliveryInformation();
        System.out.println(deliveryInformation.getDeliveryStatus());
        System.out.println(deliveryInformation.getOriginZip());
        System.out.println(deliveryInformation.getDestinationZip());
        System.out.println(deliveryInformation.getParcelType());
        System.out.println(deliveryInformation.getDeliveryMethod());
        System.out.println(deliveryInformation.getWeight());
        System.out.println(deliveryInformation.getDeliveryTime());
        System.out.println(deliveryInformation.getShippingCost());
        System.out.println();
    }

    public static void xmlParcel(ArrayList<DeliveryInformation> deliveryInformations) throws JAXBException {
        DeliveryInformationList deliveryInformationList = new DeliveryInformationList();
        deliveryInformationList.setDeliveryInformationArrayList(deliveryInformations);

        JAXBContext context = JAXBContext.newInstance(DeliveryInformationList.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(deliveryInformationList, new File("deliveryInformation.xml"));
    }
}
