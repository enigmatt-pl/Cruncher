/******************************************************************************/
/**
@file         Cruncher.java
@copyright    UP663375, UP646321, ECE00279
*
@language     Java
*
@description  Main function of the program
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/


public class Cruncher {
    
    /*
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Setting the parameters");
        
        switch(args[0]){
            case "1":
                System.out.println("Simple Brute Force selected");
                //Create your class here
                BruteForce.run(args[1]);
                endProgram();
                break;
            case "2":
                System.out.println("Brute Force with Masking selected");
                //Create your class here
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