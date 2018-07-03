package Week3;

import java.util.ArrayList;

public class Barcode {
    private static String[] codes = new String[9];
    private static String tokens[];
    private static ArrayList<Package> packValid = new ArrayList<Package>();

    public static ArrayList<Package> getPackValid() {
        return packValid;
    }

    public static void splitBarcodes(){
        for(String barcode: codes){
            tokens = splitter(barcode);
            try{
                validatePackage(tokens);
                packValid.add(new Package(idValidate(tokens[0]), tokens[1], zipValidate(tokens[2]), zipValidate(tokens[3]), weightValidate(tokens[4]), dimensionValidate(tokens[5]), dimensionValidate(tokens[6]), dimensionValidate(tokens[7]), tokens[10]));
            }catch(IllegalArgumentException e){
                System.out.print("Error with barcode");
            }
        }
    }

    public static void createBarcodes(){
        codes[0] = "11112324|GRD|30131|30132|30.0|5|8|10|Xalkdjf|adc|123 Main street";
        codes[1] = "11321324|AIR|35034|60099|30.0|5|8|10|Xalkdjf|adc|42 Hello world";
        codes[2] = "12312324|RAL|35645|47532|30.0|5|8|10|Xalkdjf|adc|100 wow wow";
        codes[3] = "23112324|GRD|98791|51548|30.0|5|8|10|Xalkdjf|adc|200 pew pew";
        codes[4] = "14112324|RAL|85324|67447|30.0|5|8|10|Xalkdjf|adc|404 Not Found";
        codes[5] = "86112324|AIR|72201|41773|30.0|5|8|10|Xalkdjf|adc|492 what am i doing";
        codes[6] = "34112324|GRD|90265|12754|30.0|5|8|10|Xalkdjf|adc|322 garfield road";
        codes[7] = "23112324|RAL|92342|13786|30.0|5|8|10|Xalkdjf|adc|212 turnaround";
        codes[8] = "10112324|AIR|95969|57429|30.0|5|8|10|Xalkdjf|adc|800 jokes rd";
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
