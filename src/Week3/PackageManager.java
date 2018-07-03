package Week3;

import org.apache.log4j.Logger;

import Week3.Airport.*;
import java.util.ArrayList;
import java.util.Collections;

public class PackageManager {
    private static final Logger LOG = Logger.getLogger(Barcode.class);
    private static ArrayList<Package> packValid = new ArrayList<Package>();
    private static ArrayList<Package> grd = new ArrayList<Package>();
    private static ArrayList<Package> ral = new ArrayList<Package>();
    private static ArrayList<Package> air = new ArrayList<Package>();

    public static void main(String[] args){
        Barcode.createBarcodes();
        Barcode.splitBarcodes();

        Distribution.mapStatesToDist();
        Distribution.openZipCodes();
        Distribution.getZipCodes();

        LOG.debug("Sorting lists");
        sortIntoLists();

        LOG.debug("Printing lists");
        printOutLists();
    }

    public static void sortIntoLists(){
        packValid = Barcode.getPackValid();
        for(Package pack: packValid){
            if(pack.getGRD().equals("GRD")){
                grd.add(pack);
            } else if(pack.getGRD().equals("AIR")){
                air.add(pack);
            } else if(pack.getGRD().equals("RAL")){
                ral.add(pack);
            }
        }
        Collections.sort(grd);
        Collections.sort(air);
        Collections.sort(ral);
    }

    public static void printOutLists(){
        System.out.println("JITS Shipping Package Report");

        for(Package airShipping: air){
            printPackage(airShipping);
            printAirportFrom(airShipping);
            printAirportTo(airShipping);
            Warehouse.trackingString(airShipping);
            AirportRoute.trackingString(airShipping, getAirportCode(airShipping));
            Destination.trackingString(airShipping);
        }
        for(Package groundShipping: grd){
            printPackage(groundShipping);
            printWarehouse(groundShipping);
            Warehouse.trackingString(groundShipping);
            Distribution.trackingString(groundShipping);
            Destination.trackingString(groundShipping);
        }
        for(Package rail: ral){
            printPackage(rail);
            System.out.println();
        }
    }

    public static String getAirportCode(Package airShipping){
        return AirportLocator.findClosestAirport(Integer.toString(airShipping.getToZip())).getCode();
    }

    public static void printAirportTo(Package airShipping){
        Airport airportTo = AirportLocator.findClosestAirport(Integer.toString(airShipping.getToZip()));
        System.out.println(" To Airprt: " + airportTo.getCode() + " " + airportTo.getName());
    }

    public static void printAirportFrom(Package airShipping){
        Airport airportFrom = AirportLocator.findClosestAirport(Integer.toString(airShipping.getFromZip()));
        System.out.print(" From Arprt: " + airportFrom.getCode() + " " + airportFrom.getName());
    }

    public static void printWarehouse(Package groundShipping){
        Dist center = Distribution.getDist(groundShipping.getToZip());
        System.out.println(" Whse DistCtr: " + center.getDC() + " " + center.getCity() +  " Dest: " + groundShipping.getStreet());
    }

    public static void printPackage(Package p){
        System.out.print(p.getId() + " " + p.getGRD().toUpperCase());
    }
}
