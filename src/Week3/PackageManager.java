package Week3;

import org.apache.log4j.Logger;

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
            System.out.println();
        }
        for(Package groundShipping: grd){
            printPackage(groundShipping);
            Dist center = Distribution.getDist(groundShipping.getToZip());

            System.out.println(" Whse DistCtr: " + center.getDC() + " " + center.getCity() +  " Dest: " + groundShipping.getStreet());
            Warehouse.trackingString(groundShipping);
            Distribution.trackingString(groundShipping);
            Destination.trackingString(groundShipping);
        }
        for(Package rail: ral){
            printPackage(rail);
            System.out.println();
        }
    }

    public static void printPackage(Package p){
        System.out.print(p.getId() + " " + p.getGRD().toUpperCase());
    }
}
