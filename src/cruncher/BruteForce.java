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
import java.util.Scanner;
import org.apache.commons.codec.digest.Crypt;

public final class BruteForce {
    
    /* Private variables declarations */
    public static Console console = System.console();
    public static String salt = "aa";

    /**
     * contains English alphabet lower case letters
     */
    public static char[] alphabetLwrCsEn = {
                                         'a','b','c','d','e','f','g','h','i',
                                         + 'j','k','l','m','n','o','p','q','r',
                                         + 's','t','u','v','w','x','y','z'
                                         };
 
     /**
     * contains English alphabet upper case letters
     */
    public static char[] alphabetUprCsEn = {
                                         'A','B','C','D','E','F','G','H','I',
                                         + 'J','K','L','M','N','O','P','Q','R',
                                         + 'S','T','U','V','W','X','Y','Z'
                                         };
    
    /**
     * Symbols for brute force
     */
    public static char[] symbols = { 
                                    ' ', '!', '"', '#', '$', '%', '&','(' ,')',
                                    + '*','+', ',', '-', '.', '/', ':', ';',
                                    + '<', '=', '>', '?', '@', '[', '\', ']',
                                    + '^', '_', '`', '{', '|', '}', '~'
                                    };
    
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
        
        //FileWrapper.initOutputFile("cache.txt");
        //PrintWriter writer = new PrintWriter("cache.txt", "UTF-8");
        
        int alphabetUpperCaseSize = alphabetLwrCsEn.length;
        int alphabetLowerCaseSize = alphabetUprCsEn.length;
        int symbolSize            = symbols.length;
        
        int symbolsToChck = alphabetUpperCaseSize * alphabetLowerCaseSize 
                          * alphabetLowerCaseSize * 9;
        
        symbolsToChck += size;
        System.out.println("Symbols to check: " + symbolsToChck);
        
        /*
        int size = 3;
        no = no of iter
        alph[no<2>], alph[no<1>], alph<0>
        */
        
        //console.readLine("\"Enter length of the test word: ");
        //length = Integer.parseInt("1");
        
        //System.out.println(length);
        int iSequence = 0;
        int iCurrentHash    = CommonFile.iCurrentHash;
        //String sCurrentHash = CommonFile.sCurrentHash;
        String guessTxt = "", sComparison = "";
        
        FileWrapper.UnixPasswdFile.hashes.stream().forEach((sCurrentHash) -> {
            while(crackStatus = true){
                CommonFile.sCurrentHash = sCurrentHash;

                //BT
                //for(int i = 0; i < size; i++){
                //  guessTxt += "adhJGDE";
                //}
                //end BT

                
                //sComparison = Crypt.crypt(guessTxt, salt);
                /*
                if(sComparison.equals(sCurrentHash)){
                CommonFile.addUnhashedValue(guessTxt);
                crackStatus = true;
                }
                else{
                iSequence++;
                System.out.println(iSequence);
                }*/
            }
        });
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
