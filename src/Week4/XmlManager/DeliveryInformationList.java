package Week4.XmlManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "allShipments")
public class DeliveryInformationList {

    @XmlElementWrapper(name = "shipmentList")

    @XmlElement(name = "shipment")
    private ArrayList<DeliveryInformation> deliveryInformationArrayList = new ArrayList<DeliveryInformation>();

    public void setDeliveryInformationArrayList(ArrayList<DeliveryInformation> deliveryInformationArrayList) {
        this.deliveryInformationArrayList = deliveryInformationArrayList;
    }
}
