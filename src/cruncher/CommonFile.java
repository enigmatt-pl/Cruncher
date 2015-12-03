/******************************************************************************/
/**
@file          Cruncher.java
@copyright     Mateusz Michalski
* 
@author        Mateusz Michalski(UP663375)
*
@language      Java SE 8 (March 18, 2014)
*
@description   Common File - serves as common buffer for all threads
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.util.ArrayList;
import java.util.List;

public final class CommonFile {
    
    /* Private variables declarations */
    public static String sCurrentHash;
    public static int    iCurrentHash = 0;
    private static final List<String> lUnhashed =  new ArrayList<>();
    
    /* addHash *****************************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Adds a hash to be processed
     * @param hash
    ***************************************************************************/
    public static void addHash(String hash){
        
        //iCurrentHash = hash;
        System.out.println("The following hash will be now processed: " + hash);
        sCurrentHash = hash;
    }
    
    /* addUnhashedValue ********************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Adds a the successfully cracked hash input text to the array list
     * @param text
    ***************************************************************************/
    public static void addUnhashedValue(String text){
        
        lUnhashed.add(text);
        iCurrentHash++;
        System.out.println("The hash: " + sCurrentHash + " has been cracked! The"
                + " unhashed value is: " + lUnhashed.get(lUnhashed.size() - 1));
        
    }
    
    /* printUnhashedValues *****************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Prints all successfully cracked hashes
    ***************************************************************************/
    public static void printUnhashedValues(){
        
        //TODO: Add code for printing the hashed value
        lUnhashed.stream().forEach((i) -> {
            System.out.println(i);
        });
        
        
    }
    
}


