/******************************************************************************/
/**
@file          Cruncher.java
@copyright     UP663375, UP646321, ECE00279
* 
@author        Mateusz Michalski
@responsible   UP663375, UP646321, ECE00279
*
@language      Java SE 8 (March 18, 2014)
*
@description   Main class of the Cruncher
*******************************************************************************/
package cruncher;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* INCLUDE FILES **************************************************************/


public class Cruncher {
    
    /* main **************************************************************
    ** 08/11/2015  M.Michalski    Initial Version
    ** 09/11/2015  M.Michalski    Added case no. 2 (this is the documentation example
    ****************************************************************************/
    /** Description: main function of the Cruncher
     * 
     * @param args - arguments from the command line
    ****************************************************************************/
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Setting the parameters");
        
        switch(args[0]){
            case "1":
                System.out.println("Simple Brute Force selected");
                //Create your class here
                endProgram();
                break;
            case "2":
                System.out.println("Brute Force with Masking selected");
                try {
                    BruteForce.run(args[1], Integer.parseInt(args[2]));
                } 
                catch (UnsupportedEncodingException | FileNotFoundException ex) {
                    Logger.getLogger(Cruncher.class.getName()).log(Level.SEVERE, null, ex);
                }
                endProgram();
            case "3":
                System.out.println("Dictionary attack selected");
                //Create your class here
                endProgram();
                break;
            default:
                System.out.println("Wrong parameters provided please try again");
                endProgram();
                break;
                
        }
    }

    /* endProgram **************************************************************
    ** 11/11/2015  M.Michalski    Initial Version   
    ****************************************************************************/
    /** Description: used in order to stop the program from terminating. Please
     *  use whenever you want to prevent the program from quitting.
    ****************************************************************************/
    public static void endProgram(){
        System.out.println("Press Enter to continue");
        try{System.in.read();}
        catch(Exception e){}
    }

    
}