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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Tamara
 */
public class ReadInFile { // old
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
    
   public List<Weapon> readFileWithStream(){ // new
        try {
            File file = new File(fileName);
            
            if (!file.canRead() || !file.isFile()) {
                System.out.println("ERROR!");
                System.exit(0);
            }
            weapons = Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                            s[0],
                            CombatType.valueOf(s[1]),
                            DamageType.valueOf(s[2]),
                            Integer.parseInt(s[3]),
                            Integer.parseInt(s[4]),
                            Integer.parseInt(s[5]),
                            Integer.parseInt(s[6])
                    )).collect(Collectors.toList());
                    } catch (IOException ex) {
            Logger.getLogger(ReadInFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weapons;
   }
    
    public void Comparator(List<Weapon> weapons){
         weapons.sort((Weapon w1,Weapon w2) -> w2.getDamage() - w1.getDamage());
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }
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
    }
    public void printConsole(List<Weapon> pWeapons){
            Printable printable = (w1)  -> {
                for (Weapon weapon : w1) {
                     System.out.println(weapon);
                }
            };
        printable.print(pWeapons);
        
    }
    
    public void printTable(List<Weapon> weapon){
        Weapon temp_Weapon = new Weapon();
        List<String> categories = temp_Weapon.getCategoriesList();
        int max = 0;  
        String spaces = "";
        max = calculateMax(weapon); // method which calcs the max length for space
        final int spaces_length = max -1;
        String separator = getRowSeparator(fileName, categories, spaces_length);
        System.out.print(separator);
        for (int i = 0; i <= max; i++) {
           spaces += " ";
        }
      
        Comparator_combatType_damageType_name(weapons); //sorts List
        
        printCategoriesForTable(categories,spaces,max); // method which prints all categories
            System.out.print(separator);
 
        for (Weapon weapon1 : weapon) {
            String[] tempString = weapon1.newToString().split(";");
            for (String weapon_splitted : tempString) {
            int space_length = (max - weapon_splitted.length())/2;
            if((max - weapon_splitted.length()) % 2 != 0){
                System.out.print(" ");
            }
            System.out.print(spaces.substring(0,space_length)  + weapon_splitted + spaces.substring(0, space_length) + "|");
                 }
                  System.out.print(separator);
 
             }
      
    }
    
    public String getRowSeparator(String spaces, List<String> categories, int spaces_length){ // method which prints a line
        StringBuilder separator = new StringBuilder();
        separator.append('\n');
       // System.out.println();
        categories.forEach((w) -> {
            for (int i = 0; i <= spaces_length; i++) {
                separator.append('-');
               // System.out.print("-");
            }
            separator.append('+');
            //System.out.print("+");
        });
        separator.append('\n');
        //System.out.println();
        return separator.toString();
    }
    public int calculateMax(List<Weapon> weapon){// method which calcs the max length for space
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
    
    public void printCategoriesForTable(List<String> categories,String spaces, int max){// method which prints all categories
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
