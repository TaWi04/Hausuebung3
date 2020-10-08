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
       int auswahl = -12;
        Predicate<Integer> isEven = number -> {return (number % 2) == 0;};
        System.out.println("Is " + auswahl + " even?" +"\n"+ isEven.test(auswahl));
        IntPredicate isPositive = number -> {return number > 0;};
        System.out.println("Is " + auswahl + " positive?\n" + isPositive.test(auswahl));
        
    }
    
}
