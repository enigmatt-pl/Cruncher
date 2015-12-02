/******************************************************************************/
/**
@file         BruteForce.java
@copyright    UP663375, UP646321, ECE00279
* 
@author        Mateusz Michalski
@responsible   UP663375
*
@language      Java SE 8 (March 18, 2014)
*
@description  BruteForce functionality implementation
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.codec.digest.Crypt;

public final class BruteForce {
    
    /* Private variables declarations */
    public static Console console = System.console();
    public static String salt = "aa";
    
    /**
     * Notifies if the bruteforce process is completed
     */
    public static boolean crackStatus = false;

    /**
     * gets user input
     */
    public static boolean userInput = false;
    
    /* run *********************************************************************
    ** 09/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Runs the logic behind brute force functionality
     * @param fileName - name of the UNIX
     * @param size
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
    ***************************************************************************/
    public static void run(String fileName, int size) throws FileNotFoundException,
                                                   UnsupportedEncodingException
    {
    
        FileWrapper.UnixPasswdFile.processUnixFile(fileName);
        
        //String sCurrentHash = CommonFile.sCurrentHash;
        String sGuessTxt = "", sComparison = "matpro", sMask = "llllll";
        
        WordGenerator generator = new WordGenerator(sMask);
        
        System.out.println("The program will now start generating words with " 
                + "the following mask: " + sMask);
        Date currentDate = new Date();
        String sStartTime = currentDate.toString();
        System.out.println("Started at: " + sStartTime);
        
        //for (String sCurrentHash : FileWrapper.UnixPasswdFile.hashes ) {
            //CommonFile.sCurrentHash = sCurrentHash;
            while(crackStatus != true){
                //System.out.println(generator.generate());
                sGuessTxt = generator.generate();
                
                if(sGuessTxt.equals(sComparison)){
                    CommonFile.addUnhashedValue(sGuessTxt);
                    crackStatus = true;
                    String sStopTime = currentDate.toString();
                    System.out.println("Stopped at: " + sStopTime);
                }
                else
                    WordGenerator.nextSequence();
            }
        //}
    }
    
    public static void findPwd(char[] password, int position) {
        if (position < 0) {
            System.out.println(new String(password));
            return;
        }
        for (password[position] = 'a' ; password[position] <= 'z' ; password[position]++)
            findPwd(password, position-1);
        

    }
}
