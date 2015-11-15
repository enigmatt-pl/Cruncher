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
import org.apache.commons.codec.digest.Crypt;

public final class BruteForce {
    
    /* Private variables declarations */
    public static String salt = "aa";
    
    /* run *********************************************************************
    ** 09/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Runs the logic behind brute force functionality
     * @param fileName - name of the UNIX
    ***************************************************************************/
    public static void run(String fileName){
    
        UnixFile.processFile(fileName);
        System.out.println(UnixFile.getHash(0));
        
        System.out.println(Crypt.crypt("Wide51", salt));  
    }
}
