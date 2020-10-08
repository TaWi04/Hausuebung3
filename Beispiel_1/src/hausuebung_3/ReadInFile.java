/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Tamara
 */
public class ReadInFile {
    String fileName = "weapons.csv";
    List<Weapon> weapons = new ArrayList<>();
    public List<Weapon> readFile(){
        File file = new File(fileName);

        if (!file.canRead() || !file.isFile()) {
            System.out.println("ERROR!");
            System.exit(0);
        }
       
        BufferedReader input = null;
        
        try {
            input = new BufferedReader(new FileReader(fileName));
            String line = null;
            line = input.readLine();
            String[] splitedLine;
            line = input.readLine();
            while (line != null){
            splitedLine = line.split(";");
            weapons.add(new Weapon(splitedLine[0], CombatType.valueOf(splitedLine[1]), DamageType.valueOf(splitedLine[2]), Integer.parseInt(splitedLine[3]), Integer.parseInt(splitedLine[4]), Integer.parseInt(splitedLine[5]), Integer.parseInt(splitedLine[6])));
           // System.out.println(line);
            line = input.readLine();
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                  }
            }
          }
        return weapons;
    
    }
    
    public void Comparator(List<Weapon> weapons){
         weapons.sort((Weapon w1,Weapon w2) -> w2.getDamage() - w1.getDamage());
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }
        //return weapons;
    }
    
    public void Comparator_combatType_damageType_name(List<Weapon> weapons){
        weapons.sort((Weapon w1,Weapon w2) ->{
            if(w1.getCombatType().compareTo(w2.getCombatType())== 0){
                if(w1.getDamageType().compareTo(w2.getDamageType())==0){
                    return w1.getName().compareTo(w2.getName());
                }else{
                   return w1.getDamageType().compareTo(w2.getDamageType());
                }
            }else{
             return  w1.getCombatType().compareTo(w2.getCombatType());
            }
        });
        
//        for (Weapon weapon : weapons) {
//            System.out.println(weapon);
//        }
        //return weapons;
    }
    public void printConsole(List<Weapon> pWeapons){
        /*Printable printable;
        printable = new Printable((w) ->{
            Comparator_combatType_damageType_name(weapons);
            weapon.forEach((w) -> System.out.println(w.toString()))};*/
            Printable printable = (w1)  -> {
                for (Weapon weapon : w1) {
                     System.out.println(weapon);//weapon.getName() + " [" + weapon.getDamageType() + " = " + weapon.getDamage() + "]");
                }
            };
        printable.print(pWeapons);
        
    }
    
    public void printTable(List<Weapon> weapon){
        Weapon temp_Weapon = weapon.get(0);
        List<String> categories = temp_Weapon.getCategoriesList();
        int max = 0;  
        String spaces = "";
//        for (String category : categories) {
//            if(category.length() > max)
//                max = category.length();
//        }
        max = calculateMax(weapon);
        final int spaces_length = max -1;
        lineForTable(weapons, max, spaces, categories,spaces_length);
        for (int i = 0; i <= max; i++) {
           spaces += " ";
        }
      
       Comparator_combatType_damageType_name(weapons);
//        categories.forEach((w) -> {
//            for (int i = 0; i <= spaces_length; i++) {
//                System.out.print("-");
//            }
//            System.out.print("+");
//        });
        
       
        
      printCategoriesForTable(categories,spaces,max);
        lineForTable(weapons, max, spaces, categories,spaces_length);
           
        for (Weapon weapon1 : weapon) {
            String[] tempString = weapon1.newToString().split(";");
            for (String weapon_splitted : tempString) {
            int space_length = (max - weapon_splitted.length())/2;
            if((max - weapon_splitted.length()) % 2 != 0){
                System.out.print(" ");
            }
            
           
            System.out.print(spaces.substring(0,space_length)  + weapon_splitted + spaces.substring(0, space_length) + "|");
                 }
            lineForTable(weapons, max, spaces, categories,spaces_length);
           
            //int space_length = (max - weapon1.getName().length())/2;
            //System.out.print(spaces.substring(0,space_length)  + weapon + spaces.substring(0, space_length) + "|");
            }
      
    }
    
    public void lineForTable(List<Weapon> pWeapons, int max, String spaces, List<String> categories, int spaces_length){
        System.out.println();
        for (int i = 0; i <= max; i++) {
            spaces += " ";
        }
        categories.forEach((w) -> {
            for (int i = 0; i <= spaces_length; i++) {
                System.out.print("-");
            }
            System.out.print("+");
        });
        
        System.out.println();
    }
    public int calculateMax(List<Weapon> weapon){
        int max = 0;
         for (Weapon weapon1 : weapon) {
            if(weapon1.getName().length() > max)
                max = weapon1.getName().length();
        }
        if(max % 2 != 0){
            max += 3;
        }
        else{
            max +=  2;
        }
        
        return max;
    }
    
    public void printCategoriesForTable(List<String> categories,String spaces, int max){
        for (String category : categories) {
            if(category.equals("SPEED")){
            int space_length = (max - category.length())/2;
            System.out.print(spaces.substring(0,space_length)  + category + spaces.substring(0, space_length +1)+"|");
       
            }else{
                int space_length = (max - category.length())/2;
            System.out.print(spaces.substring(0,space_length)  + category + spaces.substring(0, space_length) + "|");
         
            }
    }
}}
