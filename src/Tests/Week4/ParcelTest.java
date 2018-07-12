package Tests.Week4;

import Week4.*;
import Week4.XmlManager.DeliveryInformation;
import com.jits.core.Address;
import com.jits.core.Letter;
import com.thirdParty.calibration.MailScale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParcelTest {
    Address test = new Address("", "", "", "", "1");

    @Mock
    MailScale scale = new MailScale();

    @InjectMocks
    Parcel parcel = new Letter("", test, test, DeliveryMethod.AIR, Durability.FIREPROOF);;

    @Before
    public void beforeEachTest(){
        when(scale.calculateWeight(parcel)).thenReturn(12.0);
    }

    @Test
    public void weighParcelTest(){
        Assert.assertEquals(12.0, parcel.weighParcel(),0);
    }

    @Test
    public void createDeliveryInformationTest(){
        DeliveryInformation deliveryInformation = new DeliveryInformation();
        deliveryInformation.setDeliveryStatus("Not delivered");
        deliveryInformation.setOriginZip("1");
        deliveryInformation.setDestinationZip("1");
        deliveryInformation.setParcelType("class com.jits.core.Letter");
        deliveryInformation.setDeliveryMethod("AIR");
        deliveryInformation.setWeight("0.0");
        deliveryInformation.setDeliveryTime("0.0");
        deliveryInformation.setShippingCost("0.0");

        Assert.assertThat(deliveryInformation, new ReflectionEquals(parcel.createDeliveryInformation()));
    }
}
