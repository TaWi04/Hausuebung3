/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung_3;

/**
 *
 * @author Tamara
 */
import java.util.function.IntPredicate;
import java.util.function.Predicate; 
public class Beispiel_3 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
         // Creating predicate 
        Predicate<Integer> lesserthan = i -> (i < 18);  
  
        // Calling Predicate method 
        System.out.println(lesserthan.test(10));
       // int number;
       int auswahl = 18;
       String temp = null;
        Predicate<Integer> isEven = number -> {return (number % 2) == 0;};      //isEven
        System.out.println("Is " + auswahl + " even?" +"\n"+ isEven.test(auswahl));
        
        Predicate<Integer> isPositive = number -> {return number > 0;};         //isPositive
        System.out.println("Is " + auswahl + " positive?\n" + isPositive.test(auswahl));
        
        Predicate<Integer> is0 = number -> {return number == 0;};               //isZero
        System.out.println("Is " + auswahl + " zero?" +"\n"+ is0.test(auswahl));
        
        Predicate isNull = number -> {return number == null;};                  //isNull
        System.out.println("Is " + temp + " null?\n" + isNull.test(temp));
        
        String shortWord = "Hey";
        String longWord = "Halleluja";
        Predicate<String> isShortWord = word -> {return word.length() < 4;};    //isShortWord
        System.out.println("Is " + shortWord + " a short word?\n" + isShortWord.test(shortWord));
        System.out.println("Is " + longWord + "  a short word?\n" + isShortWord.test(longWord));
        
        System.out.println("Is " + auswahl + " positive and even?\n" + isPositive.and(isEven).test(auswahl)); //mix with positve and even + and
        
        System.out.println("Is " + auswahl + " positive and odd?\n" + isPositive.and(isEven.negate()).test(auswahl)); //mix with positve and even + and + negate
    }
    
}
