package com.code.geektrust;

import java.util.*;
import java.util.stream.Collectors;

public class TameOfThrones {

    static Set<String> alliesList = new HashSet<String>();
    static Map<String,String> emblem = new HashMap<String,String>();

    static {
        emblem.put("LAND","panda");
        emblem.put("WATER","octopus");
        emblem.put("ICE","mammoth");
        emblem.put("AIR","owl");
        emblem.put("FIRE","dragon");
    }

    public static void main(String[] args) {
        System.out.println("Please enter vaid input no.");
        System.out.println("1.Who is the ruler of Southeros?");
        System.out.println("2.Allies of King Shan? ");
        System.out.println("3.Input Messages to kingdoms from King Shan:");

        Scanner sc=new Scanner(System.in);
        try {
            int input = sc.nextInt();
            TameOfThrones.inputType(sc,input);
        } catch (Exception e){
            System.out.println("Invalid argument provided. Exiting.....");
        }
        sc.close();
    }


    public static void inputType(Scanner sc,int inputType){
        switch(inputType) {
            case 1:
                ruler(sc);
                break;
            case 2:
                allies(sc);
                break;
            case 3:
                sendSecretMsg(sc);
                break;
            default:
                System.out.println("Invalid input. PLease enter again!");
                inputType(sc,sc.nextInt());
                break;
        }
    }

    private static void sendSecretMsg(Scanner sc) {
        System.out.println("Kingdom Name : ");
        String kingdom = sc.next();
        if (!emblem.keySet().contains(kingdom.toUpperCase())){
            throw new IllegalArgumentException();
        } else if (alliesList.contains(kingdom)) {
            System.out.println(kingdom + " is already an allies.Please select another kingdom");
            inputType(sc,3);
        }
        System.out.println("secret Message : ");
        sc.nextLine();
        String secretMsg = sc.nextLine();
        processMessage(secretMsg.toLowerCase(),kingdom);
        System.out.print("Do you want to send another message? (y/n) : ");
        String decision = sc.next();
        if (decision.equalsIgnoreCase("Y")){
            inputType(sc,3);
        }
        System.out.println("select Input Type: ");
        inputType(sc,sc.nextInt());
    }

    private static void allies(Scanner sc) {
        System.out.println("Allies of King Shan? ");
        String allies = alliesList.size() == 0 ? "NONE":alliesList.toString();
        System.out.println(allies);
        System.out.println("select Input no.: ");
        inputType(sc,sc.nextInt());
    }

    private static void ruler(Scanner sc) {
        System.out.println("Who is the ruler of Southeros?");
        if (alliesList.size() > 2){
            System.out.println("King Shan");
        } else {
            System.out.println("NONE");
        }
        System.out.println("select Input no.: ");
        inputType(sc,sc.nextInt());
    }

    private static void processMessage(String secretMsg,String kingdom) {
        Map<String, Long> frequentCharsSecretMsg = Arrays.stream(
                secretMsg.toLowerCase().split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<String, Long> frequentCharsEmblem = Arrays.stream(
                emblem.get(kingdom.toUpperCase()).split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting()));

        for (String s :frequentCharsEmblem.keySet()){
            Long count = frequentCharsSecretMsg.get(s);
            if (count == null || count < frequentCharsEmblem.get(s)){
                return;
            }
        }

        alliesList.add(kingdom);
    }
}
