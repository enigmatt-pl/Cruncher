/******************************************************************************/
/**
@file         BruteForce.java
@copyright    Mateusz Michalski
* 
@author        Mateusz Michalski(UP663375)
*
@language      Java SE 8 (March 18, 2014)
*
@description  BruteForce with masking option functionality implementation
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.apache.commons.codec.digest.Crypt;

public final class BruteForceMasked {
    
    /* Private variables declarations */
    public static String sSalt = "aa";
    
    /**
     * Notifies if the brute force process is completed
     */
    public static boolean bCrackStatus = false;

    /**
     * flags user input in case they want to stop the application
     */
    public static boolean bUserInput = false;
    
    /* run *********************************************************************
    ** 09/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Runs the logic behind brute force functionality
     * @param sFileName - name of the UNIX
     * @param sMask
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
    ***************************************************************************/
    public static void run(String sFileName, String sMask) 
            throws FileNotFoundException, UnsupportedEncodingException
    {
    
        FileWrapper.UnixPasswdFile.processUnixFile(sFileName);
        
        //String sCurrentHash = CommonFile.sCurrentHash;
        String sGuessTxt, sComparison = Crypt.crypt("mAt3", sSalt);
        
        
        WordGenerator generator = new WordGenerator(sMask);

        System.out.println("The program will now start generating words with " 
                + "the following mask: " + sMask);
        Date currentDate = new Date();
        String sStartTime = currentDate.toString();
        System.out.println("Started at: " + sStartTime);
        
        //for (String sCurrentHash : FileWrapper.UnixPasswdFile.hashes ) {
            //CommonFile.sCurrentHash = sCurrentHash;
            while(bCrackStatus != true){
                //System.out.println(generator.generate());
                sGuessTxt = generator.generate();
                
                if(Crypt.crypt(sGuessTxt, sSalt).equals(sComparison)){
                    CommonFile.addUnhashedValue(sGuessTxt);
                    bCrackStatus = true;
                    currentDate = new Date();
                    String sStopTime = currentDate.toString();
                    System.out.println("Stopped at: " + sStopTime);
                }
                else
                    WordGenerator.nextSequence();
            }
        //}
    }     
}
