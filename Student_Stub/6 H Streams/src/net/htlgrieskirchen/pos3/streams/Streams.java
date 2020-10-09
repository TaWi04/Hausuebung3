package net.htlgrieskirchen.pos3.streams;

import com.sun.org.apache.bcel.internal.classfile.Code;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {
  private  int[] numbers = new int[10000];
  private  String[] strings = new String[10];
  
    private void fillArray(){
        numbers = Arrays.stream(numbers)
                .map(x -> (int) (Math.random()*101))
                .toArray();
        
        for (int number : numbers) {
            System.out.println(number);   
        }
    }

    public int[] getNumbers() {
        return numbers;
    }
    
    public double average(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }
    
    public void fillStringArray(){
        strings = (String[]) Arrays.stream(strings)
                .map(x -> createRandomString())
                .toArray(String[]::new);
    }
    
     public String[] getStringsArray() {
        return strings;
    }
    
    private String createRandomString(){
          String string = "";
          for (int i = 0; i < 10; i++) {
              string += randomChar();
          }
          return string;
      }
    
    private char randomChar(){
        Random rdm = new Random();
          return (char)(rdm.nextInt(26)+'a');
      }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings)
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());   
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream()
                .min((w1, w2) -> w1.getDamage() - w2.getDamage())
                .orElse(null);
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
         return weapons.stream()
                .max((w1, w2) -> w1.getMinStrength()- w2.getMinStrength())
                .orElse(null);
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
         return weapons.stream()
                .filter((w) -> w.getDamageType() == DamageType.MISSILE)
                 .collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
         return weapons.stream()
                .max((w1, w2) -> w1.getName().length() - w2.getName().length())
                .orElse(null);
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
      return weapons.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());   
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
      return weapons.stream()
                .mapToInt(x ->(int) x.getSpeed())
                .toArray();   
    }
    
    public int sumUpValues(List<Weapon> weapons) {
         return weapons.stream()
                .mapToInt(x ->(int) x.getValue())
                .sum();   
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
       return weapons.stream()
                .mapToInt(x ->(int) x.hashCode())
                .sum(); 
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
         return weapons.stream()
                .distinct()
                .collect(Collectors.toList()); 
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream()
                .forEach(w ->  w.setValue((int)(w.getValue()*1.1))); 
    }
}
