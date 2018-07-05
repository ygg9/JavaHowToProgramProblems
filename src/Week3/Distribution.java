package Week3;

import java.io.IOException;
import java.util.HashMap;
import java.io.File;

import jxl.*;
import jxl.read.biff.BiffException;

public class Distribution implements TrackerWrite {
    public static HashMap<String, Dist> distributionCenter = new HashMap<String, Dist>();
    public static Workbook workbook;
    public static Sheet sheet;
    public static HashMap<Integer, String> zipCodes = new HashMap<Integer, String>();

    public static void trackingString(Package pack) {
        Dist center = getDist(pack.getToZip());
        Writer.getInstance().setWrite(center.getDC() + "|" + pack.getId() + "|");
    }

    public static Dist getDist(int zip) {
        Integer zipCast = new Integer(zip);
        String state = zipCodes.get(zipCast);
        return distributionCenter.get(state);
    }

    public static void getZipCodes() {
        Cell[] zipColumn = sheet.getColumn(0);
        Cell[] stateColumn = sheet.getColumn(1);
        for (int i = 1; i < zipColumn.length; i++) {
            Integer zip = Integer.parseInt(zipColumn[i].getContents());
            zipCodes.put(zip, stateColumn[i].getContents());
        }
    }

    public static void openZipCodes() {
        try {
            workbook = Workbook.getWorkbook(new File("zip.xls"));
        } catch (IOException ioException) {

        } catch (BiffException biffException) {

        }
        sheet = workbook.getSheet(0);
    }

    public static void mapStatesToDist() {
        distributionCenter.put("AL", Dist.DC2);
        distributionCenter.put("AK", Dist.DC3);
        distributionCenter.put("AZ", Dist.DC3);
        distributionCenter.put("AR", Dist.DC2);
        distributionCenter.put("CA", Dist.DC3);
        distributionCenter.put("CO", Dist.DC3);
        distributionCenter.put("CT", Dist.DC1);
        distributionCenter.put("DE", Dist.DC1);
        distributionCenter.put("DC", Dist.DC1);
        distributionCenter.put("FL", Dist.DC1);
        distributionCenter.put("GA", Dist.DC1);
        distributionCenter.put("HI", Dist.NA);
        distributionCenter.put("ID", Dist.DC3);
        distributionCenter.put("IL", Dist.DC2);
        distributionCenter.put("IN", Dist.DC2);
        distributionCenter.put("IA", Dist.DC2);
        distributionCenter.put("KS", Dist.DC3);
        distributionCenter.put("KY", Dist.DC2);
        distributionCenter.put("LA", Dist.DC2);
        distributionCenter.put("ME", Dist.DC1);
        distributionCenter.put("MD", Dist.DC1);
        distributionCenter.put("MA", Dist.DC1);
        distributionCenter.put("MI", Dist.DC2);
        distributionCenter.put("MN", Dist.DC2);
        distributionCenter.put("MS", Dist.DC2);
        distributionCenter.put("MO", Dist.DC2);
        distributionCenter.put("MT", Dist.DC3);
        distributionCenter.put("NE", Dist.DC3);
        distributionCenter.put("NV", Dist.DC3);
        distributionCenter.put("NH", Dist.DC1);
        distributionCenter.put("NJ", Dist.DC1);
        distributionCenter.put("NM", Dist.DC3);
        distributionCenter.put("NY", Dist.DC1);
        distributionCenter.put("NC", Dist.DC1);
        distributionCenter.put("ND", Dist.DC3);
        distributionCenter.put("OH", Dist.DC1);
        distributionCenter.put("OK", Dist.DC3);
        distributionCenter.put("OR", Dist.DC3);
        distributionCenter.put("PA", Dist.DC1);
        distributionCenter.put("RI", Dist.DC1);
        distributionCenter.put("SC", Dist.DC1);
        distributionCenter.put("SD", Dist.DC3);
        distributionCenter.put("TN", Dist.DC2);
        distributionCenter.put("TX", Dist.DC3);
        distributionCenter.put("UT", Dist.DC3);
        distributionCenter.put("VT", Dist.DC1);
        distributionCenter.put("VA", Dist.DC1);
        distributionCenter.put("WA", Dist.DC2);
        distributionCenter.put("WV", Dist.DC1);
        distributionCenter.put("WI", Dist.DC2);
        distributionCenter.put("WY", Dist.DC3);
    }
}
