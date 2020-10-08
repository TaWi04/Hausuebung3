/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hausuebung_3;

import java.util.stream.IntStream;

/**
 *
 * @author Tamara
 */
public class Beispiel_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int result = IntStream.range(1, 10)
                .filter(n -> {return (n % 2) != 0;})
                .map(n -> (int)(Math.pow(n, 2)))
                .reduce(0, (n1, n2) ->n1+n2);
        System.out.println(result);
                //.ifPresent(System.out::println);
    }
    
}
