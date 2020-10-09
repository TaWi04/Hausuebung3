package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
  private  int[] numbers = new int[10000];
    public void fillArray(){
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
    
    public List<String> upperCase(String[] strings) {
        //implement this
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}
