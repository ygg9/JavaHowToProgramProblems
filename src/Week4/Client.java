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
            System.out.println(p.getDeliveryStatus());
            System.out.println(p.getOrigin().getPostalCode());
            System.out.println(p.getDestination().getPostalCode());
            System.out.println(p.getClass());
            System.out.println(p.getDeliveryMethod());
            System.out.println(p.getWeight());
            System.out.println(p.daysToDeliver());
            System.out.println(p.shippingCost());
            System.out.println();
        }

    }

}
