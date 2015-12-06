/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruncher;

import java.io.IOException;

/**
 *
 * @author Erik Nagy - UP646321
 */
public class DictionaryAttack {
    /* I don't think this is good practice but I don't know any better :( */
    //public static String pathHash = "/Users/Erik/Desktop/grp4pw.txt";

    public static void run(String pathHash, String pathDict) throws IOException {
        System.out.println("Cruncher: Dictionary Attack");
        
        Crack.run(pathHash, pathDict);
        
        System.out.println("\n [?] Would you like to list obtained user details? (Y/N) ");
        int choice = System.in.read();
        
        switch(choice){
            case 'y':
            case 'Y':
                System.out.println(" [+] Obtained user information:");
                Crack.DisplayCracked();
                break;
            case 'n':
            case 'N':
                break;
            default:
                System.out.println("Wrong parameters provided please try running the program again");
                endProgram();
                break;
        }
    }
    
    public static void endProgram() throws IOException{
        System.out.println("\n Press Enter to terminate");
        System.in.read();
        
    }

    
}
