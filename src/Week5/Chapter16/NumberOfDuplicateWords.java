package Week5.Chapter16;

import java.util.*;

public class NumberOfDuplicateWords {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();

        createMap(map);
        displayMap(map);
    }

    public static void createMap(Map<String, Integer> map){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String sentence = input.nextLine();

        sentence = sentence.replaceAll("[\"\\.\\;\\']", "");

        String[] tokens = sentence.split(" ");

        for(String word: tokens){
            String lowerCase = word.toLowerCase();

            if(map.containsKey(lowerCase)){
                int count = map.get(lowerCase);
                map.put(lowerCase, count+1);
            }
            else{
                map.put(lowerCase,1);
            }
        }
    }

    public static void displayMap(Map<String, Integer> map){
        Set<String> keys = map.keySet();

        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys){
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
