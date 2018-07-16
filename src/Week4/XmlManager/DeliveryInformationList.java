package Week4.XmlManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "allShipments")
public class DeliveryInformationList {

    private ArrayList<DeliveryInformation> deliveryInformationArrayList = new ArrayList<DeliveryInformation>();

    @XmlElement(name = "shipment")
    public void setDeliveryInformationArrayList(ArrayList<DeliveryInformation> deliveryInformationArrayList) {
        this.deliveryInformationArrayList = deliveryInformationArrayList;
    }

    public ArrayList<DeliveryInformation> getDeliveryInformationArrayList() {
        return deliveryInformationArrayList;
    }
}
