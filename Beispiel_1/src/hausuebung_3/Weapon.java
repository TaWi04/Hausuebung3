/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung_3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tamara
 */
public class Weapon {
    private  List<String> categories = new ArrayList<>();
    private  String name;
    private  CombatType combatType;
    private  DamageType damageType;
    private  int damage;
    private  int speed;
    private  int strength;
    private  int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
        creatingCategoriesList();
    }
    public Weapon(){
        creatingCategoriesList();
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }
    private String getCategories(){
        return "name;combatType;damageType;damage;speed;strength;value ".toUpperCase();
    }
    private void creatingCategoriesList(){
       String[] categoriesArray = getCategories().split(";");
        for (String string : categoriesArray) {
            categories.add(string);
        }  
    }
    public List<String> getCategoriesList(){
        return categories;
    }
    
    public String newToString(){
        return name + ";" + combatType + ";" + damageType +";" + damage + ";" + speed + ";" + strength + ";" + value;
    }
    @Override
    public String toString() {
        return "Weapon{"+name + ";" + combatType + ";" + damageType +";" + damage + ";" + speed + ";" + strength + ";" + value + '}';
    }
    
    
    
}
