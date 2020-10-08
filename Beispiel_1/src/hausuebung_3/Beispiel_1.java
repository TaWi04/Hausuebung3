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
public class Beispiel_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadInFile rif = new ReadInFile();
      
       //rif.Comparator_combatType_damageType_name(rif.readFile());
       //rif.printConsole(rif.readFile());
       rif.printTable(rif.readFileWithStream());
    }
    
}
