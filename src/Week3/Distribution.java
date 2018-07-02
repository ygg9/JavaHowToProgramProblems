package Week3;

import java.io.IOException;
import java.util.HashMap;
import java.io.File;
import jxl.*;
import jxl.read.biff.BiffException;

public class Distribution {
    public enum DIST {DC1, DC2, DC3, NA};
    public static HashMap<String, DIST> distributionCenter = new HashMap<String, DIST>();
    public static Workbook workbook;
    public static Sheet sheet;
    public static HashMap<Integer, String> zipCodes = new HashMap<Integer, String>();

    /*
    public static void main(String[] args){
        mapStatesToDist();
        openZipCodes();
        getZipCodes();
    }
    */

    public static void getZipCodes(){
        Cell[] zipColumn = sheet.getColumn(0);
        Cell[] stateColumn = sheet.getColumn(1);
        for(int i = 1; i < zipColumn.length; i++){
            Integer zip = Integer.parseInt(zipColumn[i].getContents());
            zipCodes.put(zip, stateColumn[i].getContents());
        }
    }

    public static void openZipCodes(){
        try{
            workbook  = Workbook.getWorkbook(new File("zip.xls"));
        } catch (IOException ioException){

        } catch (BiffException biffException){

        }
        sheet = workbook.getSheet(0);
    }

    public static void mapStatesToDist(){
        distributionCenter.put("AL", DIST.DC2);
        distributionCenter.put("AK", DIST.DC3);
        distributionCenter.put("AZ", DIST.DC3);
        distributionCenter.put("AR", DIST.DC2);
        distributionCenter.put("CA", DIST.DC3);
        distributionCenter.put("CO", DIST.DC3);
        distributionCenter.put("CT", DIST.DC1);
        distributionCenter.put("DE", DIST.DC1);
        distributionCenter.put("DC", DIST.DC1);
        distributionCenter.put("FL", DIST.DC1);
        distributionCenter.put("GA", DIST.DC1);
        distributionCenter.put("HI", DIST.NA);
        distributionCenter.put("ID", DIST.DC3);
        distributionCenter.put("IL", DIST.DC2);
        distributionCenter.put("IN", DIST.DC2);
        distributionCenter.put("IA", DIST.DC2);
        distributionCenter.put("KS", DIST.DC3);
        distributionCenter.put("KY", DIST.DC2);
        distributionCenter.put("LA", DIST.DC2);
        distributionCenter.put("ME", DIST.DC1);
        distributionCenter.put("MD", DIST.DC1);
        distributionCenter.put("MA", DIST.DC1);
        distributionCenter.put("MI", DIST.DC2);
        distributionCenter.put("MN", DIST.DC2);
        distributionCenter.put("MS", DIST.DC2);
        distributionCenter.put("MO", DIST.DC2);
        distributionCenter.put("MT", DIST.DC3);
        distributionCenter.put("NE", DIST.DC3);
        distributionCenter.put("NV", DIST.DC3);
        distributionCenter.put("NH", DIST.DC1);
        distributionCenter.put("NJ", DIST.DC1);
        distributionCenter.put("NM", DIST.DC3);
        distributionCenter.put("NY", DIST.DC1);
        distributionCenter.put("NC", DIST.DC1);
        distributionCenter.put("ND", DIST.DC3);
        distributionCenter.put("OH", DIST.DC1);
        distributionCenter.put("OK", DIST.DC3);
        distributionCenter.put("OR", DIST.DC3);
        distributionCenter.put("PA", DIST.DC1);
        distributionCenter.put("RI", DIST.DC1);
        distributionCenter.put("SC", DIST.DC1);
        distributionCenter.put("SD", DIST.DC3);
        distributionCenter.put("TN", DIST.DC2);
        distributionCenter.put("TX", DIST.DC3);
        distributionCenter.put("UT", DIST.DC3);
        distributionCenter.put("VT", DIST.DC1);
        distributionCenter.put("VA", DIST.DC1);
        distributionCenter.put("WA", DIST.DC2);
        distributionCenter.put("WV", DIST.DC1);
        distributionCenter.put("WI", DIST.DC2);
        distributionCenter.put("WY", DIST.DC3);
    }
}
