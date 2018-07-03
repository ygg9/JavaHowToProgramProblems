package Week3.Airport;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class AirportLocator {
  // zipcode->Coordinate table ["98103"->Coordinate(47.67335, 122.342621)]
  private static Map<String, Coordinate> zipcodeMap = new HashMap<String, Coordinate>(29500);
  
  // Airports
  private static Collection<Airport> airportList = new ArrayList<Airport>();
  
  /**
   * Finds the closest Airport to the given zipcode.
   */
  public static Airport findClosestAirport(String zipcode) {
    Airport result = null;
    
    // get Coordinate for zipcode
    Coordinate zipCoord = zipcodeMap.get(zipcode);
    
    // iterate over airports, find distance between zipcode and each one
    // hold onto airport with smallest distance
    double shortestDistance = 10000000000.0;
    for (Airport airport : airportList) {
      Coordinate airportCoord = new Coordinate(airport.getLat(), airport.getLng());
      double distance = zipCoord.distanceTo(airportCoord);
      if (distance < shortestDistance) {
        shortestDistance = distance;
        result = airport;
      }
    }
    // return airport with smallest distance
    return result;
  }
  
  static {
    loadZipcodeData();
    loadAirports();
  }

  private static void loadZipcodeData() {
    // disable warnings
    WorkbookSettings settings = new WorkbookSettings();
    settings.setSuppressWarnings(true);
    
    Workbook workbook = null;
    try {
      // load spreadsheet
      workbook = Workbook.getWorkbook(new File("zipLatLng.xls"), settings);
      Sheet sheet = workbook.getSheet(0);
      
      // read all rows (zero-indexed), store zipcode/Coordinate data in map
      int numRows = sheet.getRows();
      for (int i = 1; i < numRows; i++) {
        Cell[] rowCells = sheet.getRow(i);
        String zipcode = rowCells[1].getContents();
        String lat = rowCells[4].getContents();
        String lng = rowCells[5].getContents();
        zipcodeMap.put(zipcode, 
          new Coordinate(Double.parseDouble(lat), Double.parseDouble(lng)));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (workbook != null) {
        workbook.close();
      }
    }
  }

  private static void loadAirports() {
    airportList.add(new Airport("MIA", "Miami International", "Miami", 25, 47, 0, 80, 16, 0));
    airportList.add(new Airport("ORD", "O'Hare International", "Chicago", 41, 58, 43, 87, 54, 17));
    airportList.add(new Airport("JFK", "John F. Kennedy Intl", "New York", 40, 38, 0, 73, 47, 0));
    airportList.add(new Airport("DEN", "Denver International", "Denver", 39, 51, 42, 104, 40, 23));
    airportList.add(new Airport("DFW", "Dallas/Fort Worth Intl", "Dallas", 32, 53, 49, 97, 2, 17));
    airportList.add(new Airport("SEA", "Seattle-Tacoma Intl", "Seattle", 47, 27, 56, 122, 18, 42));
    airportList.add(new Airport("LAX", "Los Angeles International", "Los Angeles", 33, 56, 33, 118, 24, 26));
    airportList.add(new Airport("MSP", "Minneapolis-St. Paul Intl", "Minneapolis", 44, 53, 0, 93, 13, 1));
    airportList.add(new Airport("ATL", "Hartsfield-Jackson Intl", "Atlanta", 33, 38, 12, 84, 25, 41));
    airportList.add(new Airport("PHX", "Sky Harbor International", "Phoenix", 33, 26, 0, 112, 2, 0));
  }
}