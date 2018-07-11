package Week4;

import com.jits.core.Box;
import com.jits.core.Letter;

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

        for(Parcel p: parcels){
            displayParcel(p);
        }

    }
    
    public static void displayParcel(Parcel parcel){
        System.out.println(parcel.getDeliveryStatus());
        System.out.println(parcel.getOrigin().getPostalCode());
        System.out.println(parcel.getDestination().getPostalCode());
        System.out.println(parcel.getClass());
        System.out.println(parcel.getDeliveryMethod());
        System.out.println(parcel.getWeight());
        System.out.println(parcel.daysToDeliver());
        System.out.println(parcel.shippingCost());
        System.out.println();
    }

}
