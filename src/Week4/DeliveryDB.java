package Week4;

import Week4.XmlManager.DeliveryInformationList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DeliveryDB
{
    public static DeliveryInformationList decodeDeliveries()
    {
        DeliveryInformationList deliveryInformationList = null;

        try{
            File file = new File("deliveryInformation.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DeliveryInformationList.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            deliveryInformationList = (DeliveryInformationList) jaxbUnmarshaller.unmarshal(file);

        } catch(JAXBException e){
            e.printStackTrace();
        }

        return deliveryInformationList;
    }
}