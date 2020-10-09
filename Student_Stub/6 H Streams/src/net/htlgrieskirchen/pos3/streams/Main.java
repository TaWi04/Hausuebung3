/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

/**
 *
 * @author Tamara
 */
public class Main {
    public static void main(String[] args) {
        Streams stream = new Streams();
        //stream.fillArray();
        stream.fillStringArray();
        System.out.println(stream.upperCase(stream.getStringsArray()));
        
    }
}
