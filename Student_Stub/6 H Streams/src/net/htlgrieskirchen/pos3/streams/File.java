/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Tamara
 */
public class File {
    
    final String fileName = "weapons.csv";
    
    public List<Weapon> readFileWithStream(){ 
        List<Weapon> weapons = new ArrayList<>();
        try {
            java.io.File file = new java.io.File(fileName);
            
            if (!file.canRead() || !file.isFile()) {
                System.out.println("ERROR!");
                System.exit(0);
            }
            weapons = Files.lines(new java.io.File("weapons.csv").toPath())
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
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weapons;
   }
}
