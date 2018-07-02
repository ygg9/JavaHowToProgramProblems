package ReadingBarcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Barcode {
    private static Scanner input = new Scanner(System.in);
    private static String[] codes = new String[9];
    private static String tokens[];
    private static ArrayList<Package> packValid = new ArrayList<Package>();
    private static ArrayList<Package> grd = new ArrayList<Package>();
    private static ArrayList<Package> ral = new ArrayList<Package>();
    private static ArrayList<Package> air = new ArrayList<Package>();

    public static void main(String[] args){
        codes[0] = "11112324|GRD|12345|12345|30.0|5|8|10|Xalkdjf|adc";
        codes[1] = "11321324|AIR|12345|12345|30.0|5|8|10|Xalkdjf|adc";
        codes[2] = "12312324|RAL|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[3] = "23112324|GRD|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[4] = "14112324|RAL|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[5] = "86112324|AIR|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[6] = "34112324|GRD|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[7] = "23112324|RAL|12354|12354|30.0|5|8|10|Xalkdjf|adc";
        codes[8] = "10112324|AIR|12354|12354|30.0|5|8|10|Xalkdjf|adc";

        for(String barcode: codes){
            tokens = splitter(barcode);
            try{
                validatePackage(tokens);
                packValid.add(new Package(idValidate(tokens[0]), tokens[1], zipValidate(tokens[2]), zipValidate(tokens[3]), weightValidate(tokens[4]), dimensionValidate(tokens[5]), dimensionValidate(tokens[6]), dimensionValidate(tokens[7])));
            }catch(IllegalArgumentException e){
                System.out.print("Error with barcode");
            }
        }

        sortIntoLists();

        printOutLists();
    }

    public static void printOutLists(){
        System.out.println("JITS Shipping Package Report");

        for(Package airShipping: air){
            printPackage(airShipping);
        }
        for(Package groundShipping: grd){
            printPackage(groundShipping);
        }
        for(Package rail: ral){
            printPackage(rail);
        }
    }

    public static void printPackage(Package p){
        System.out.println(p.getId() + " " + p.getGRD().toUpperCase());
    }

    public static void sortIntoLists(){
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

    public static String[] splitter(String barcode){
        return barcode.split("[|]");
    }

    public static void validatePackage(String[] tokens) throws IllegalArgumentException{
        try{
            idValidate(tokens[0]);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("id not valid", e);
        }

        try{
            shipValidate(tokens[1]);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException("shipping method not valid", e);
        }

        try{
            zipValidate(tokens[2]);
            zipValidate(tokens[3]);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("zip code not valid" , e);
        }

        try{
            weightValidate(tokens[4]);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("weight not valid", e);
        }

        try{
            dimensionValidate(tokens[5]);
            dimensionValidate(tokens[6]);
            dimensionValidate(tokens[7]);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("dimensions not valid", e);
        }

    }

    public static void shipValidate(String method) throws IllegalArgumentException{
        if(method.equals("GRD") || method.equals("AIR") || method.equals("RAL")){
            //pack.setGRD(method);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int idValidate(String id)throws NumberFormatException{
        return Integer.parseInt(id);
    }

    public static int zipValidate(String zip) throws NumberFormatException{
        if(zip.length() == 5){
            return Integer.parseInt(zip);
        }
        else{
            throw new NumberFormatException();
        }
    }

    public static double weightValidate(String weight) throws NumberFormatException{
        double parseWeight = Double.parseDouble(weight);
        return Math.ceil(parseWeight);

    }

    public static int dimensionValidate(String heightWeightDepth) throws NumberFormatException{
        int dimension = Integer.parseInt(heightWeightDepth);
        return dimension;
    }
}
