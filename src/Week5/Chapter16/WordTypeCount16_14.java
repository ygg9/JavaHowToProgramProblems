package Week5.Chapter16;

import java.util.*;

public class WordTypeCount16_14 {
    public static void main(String[] args){
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);
    }

    private static void createMap(Map<String, Integer> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        char[] charInput = input.replaceAll("\\s","").toCharArray();

        for(Character c: charInput){
            String lowerCase = c.toString().toLowerCase();

            if(map.containsKey(lowerCase)){
                int count = map.get(lowerCase);
                map.put(lowerCase, count + 1);
            }
            else{
                map.put(lowerCase, 1);
            }
        }
    }

    private static void displayMap(Map<String, Integer> map){
        Set<String> keys = map.keySet();

        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys){
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }

}
