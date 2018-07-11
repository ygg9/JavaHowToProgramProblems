package Tests.Week4;

import Week4.Address;
import Week4.DeliveryMethod;
import Week4.Durability;
import Week4.Parcel;
import com.jits.core.Letter;
import com.thirdParty.calibration.MailScale;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParcelTest {
    Address test = new Address("", "", "", "", "");

    @Mock
    MailScale scale = new MailScale();

    @InjectMocks
    Parcel parcel = new Letter("", test, test, DeliveryMethod.AIR, Durability.FIREPROOF);;

    @Test
    public void weighParcelTest(){
        when(scale.calculateWeight(parcel)).thenReturn(12.0);

        Assert.assertEquals(12.0, parcel.weighParcel(),0);
    }
}
