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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* INCLUDE FILES **************************************************************/


public class Cruncher {
    
    /* main **************************************************************
    ** 08/11/2015  M.Michalski    Initial Version
    ** 09/11/2015  M.Michalski    Added case 1 Brute force with character masking
    ** 14/11/2015  E.Naggy        Added case 2 Dictionary attack
    ** 14/11/2015  I.Naggy        Added case 2 Dictionary attack
    ****************************************************************************/
    /** Description: main function of the Cruncher
     * 
     * @param args - arguments from the command line
    ****************************************************************************/
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        switch(args[0]){
            case "-a":
            case "--attack":
            case "--attack-mode":
            case "attack-mode":
            System.out.println();
            System.out.println(" ▄████████    ▄████████ ███    █▄  ███▄▄▄▄    ▄████████    ▄█    █▄       ▄████████    ▄████████    ");
            System.out.println("███    ███   ███    ███ ███    ███ ███▀▀▀██▄ ███    ███   ███    ███     ███    ███   ███    ███          ");
            System.out.println("███    █▀    ███    ███ ███    ███ ███   ███ ███    █▀    ███    ███     ███    █▀    ███    ███             ");
            System.out.println("███         ▄███▄▄▄▄██▀ ███    ███ ███   ███ ███         ▄███▄▄▄▄███▄▄  ▄███▄▄▄      ▄███▄▄▄▄██▀    ");
            System.out.println("███        ▀▀███▀▀▀▀▀   ███    ███ ███   ███ ███        ▀▀███▀▀▀▀███▀  ▀▀███▀▀▀     ▀▀███▀▀▀▀▀       ");
            System.out.println("███    █▄  ▀███████████ ███    ███ ███   ███ ███    █▄    ███    ███     ███    █▄  ▀███████████      ");
            System.out.println("███    ███   ███    ███ ███    ███ ███   ███ ███    ███   ███    ███     ███    ███   ███    ███           ");
            System.out.println("████████▀    ███    ███ ████████▀   ▀█   █▀  ████████▀    ███    █▀      ██████████   ███    ███     ");
            System.out.println("             ███    ███                                                               ███    ███                                 ");
            System.out.println(); 
            switch(args[1]){
                case "0":
                    System.out.println("\nSimple Brute Force selected");
                    BruteForce.run(args[2]);
                    endProgram();
                    break;
                case "1":
                    System.out.println("\nBrute force with character masking selected");
                    try {
                        BruteForceMasked.run(args[2], args[3]);
                    } 
                    catch (UnsupportedEncodingException | FileNotFoundException ex) {
                        Logger.getLogger(Cruncher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    endProgram();
                case "2":
                    System.out.println("\nDictionary attack selected");
                    DictionaryAttack.run(args[2], args[3]);
                    endProgram();
                    break;
                default:
                    System.out.println("\nError, please select one of the "
                            + "allowed attact method!");
                    endProgram();
                    break;

                }break;
                
                case "-h":
                case "-help":
                case "--help":
                case "help":
                    System.out.println();
                    System.out.println(" ▄████████    ▄████████ ███    █▄  ███▄▄▄▄    ▄████████    ▄█    █▄       ▄████████    ▄████████    ");
                    System.out.println("███    ███   ███    ███ ███    ███ ███▀▀▀██▄ ███    ███   ███    ███     ███    ███   ███    ███          ");
                    System.out.println("███    █▀    ███    ███ ███    ███ ███   ███ ███    █▀    ███    ███     ███    █▀    ███    ███             ");
                    System.out.println("███         ▄███▄▄▄▄██▀ ███    ███ ███   ███ ███         ▄███▄▄▄▄███▄▄  ▄███▄▄▄      ▄███▄▄▄▄██▀    ");
                    System.out.println("███        ▀▀███▀▀▀▀▀   ███    ███ ███   ███ ███        ▀▀███▀▀▀▀███▀  ▀▀███▀▀▀     ▀▀███▀▀▀▀▀       ");
                    System.out.println("███    █▄  ▀███████████ ███    ███ ███   ███ ███    █▄    ███    ███     ███    █▄  ▀███████████      ");
                    System.out.println("███    ███   ███    ███ ███    ███ ███   ███ ███    ███   ███    ███     ███    ███   ███    ███           ");
                    System.out.println("████████▀    ███    ███ ████████▀   ▀█   █▀  ████████▀    ███    █▀      ██████████   ███    ███     ");
                    System.out.println("             ███    ███                                                               ███    ███                                 ");
                    System.out.println();                    
                    System.out.println("██████╗ ███████╗ ███████╗ ███████╗ ██████╗  ███████╗███╗   ██╗  ██████ ███████╗    ");
                    System.out.println("██╔══██╗██╔════╝ ██╔════╝ ██╔════╝ ██╔══██╗ ██╔════╝████╗  ██║██╔════╝ ██╔════╝    ");
                    System.out.println("██████╔╝█████╗   █████╗   █████╗   ██████╔╝ █████╗  ██╔██╗ ██║██║      █████╗          ");
                    System.out.println("██╔══██╗██╔══╝   ██╔══╝   ██╔══╝   ██╔══██╗ ██╔══╝  ██║╚██╗██║██║      ██╔══╝          ");
                    System.out.println("██║  ██║███████╗ ██║      ███████╗ ██║  ██║ ███████╗██║ ╚████║╚██████╗ ███████╗         ");
                    System.out.println("╚═╝  ╚═╝╚══════╝ ╚═╝      ╚══════╝  ╚═╝ ╚═╝ ╚══════╝╚═╝  ╚═══╝  ╚═════╝╚══════╝         ");
                    System.out.println();
                    System.out.println();
                    System.out.println("Cruncher, traditional DES password recovery tool");
                    System.out.println("Usage: java -jar Cruncher.jar [options] hashfile [mask|wordfiles|directories]");
                    System.out.println();
                    System.out.println();
                    System.out.println("-h, -help,    --help,        help        - Print Reference(help)");
                    System.out.println("-a, --attack, --attack-mode, attack-mode - Attack-mode, see references below");
                    System.out.println();
                    System.out.println("* Attack modes: \n");
                    System.out.println("0 = Simple Brute Force\n");
                    System.out.println("1 = Brute force with character masking\n");
                    System.out.println("2 = Dictionary attack\n");
                    System.out.println("3 = tbc\n");
                    break;
                
            default:
                System.out.println("\nError, please select your attact method!");
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