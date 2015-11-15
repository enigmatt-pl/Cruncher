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
@description   Common File - serves as common buffer for all threads
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CommonFile {
    
    /* Private variables declarations */
    private static String currentHash;
    private static final List<String> unhashed =  new ArrayList<>();
    
    /* addHash *****************************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Adds a hash to be processed
     * @param hash
    ***************************************************************************/
    public static void addHash(String hash){
        
        currentHash = hash;
        System.out.println("The following hash will be now processed: " + hash);
        
    }
    
    /* addUnhashedValue ********************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Adds a the successfully cracked hash input text to the array list
     * @param text
    ***************************************************************************/
    public static void addUnhashedValue(String text){
        
        unhashed.add(text);
        System.out.println("The hash: " + currentHash + " has been cracked! The"
                + " unhashed value is: " + unhashed.get(unhashed.size() - 1));
        
    }
    
    /* printUnhashedValues *****************************************************
    ** 11/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Prints all successfully cracked hashes
    ***************************************************************************/
    public static void printUnhashedValues(){
        
        //TODO: Add code for printing the hashed value
        unhashed.stream().forEach((i) -> {
            System.out.println(i);
        });
        
        
    }
    
}


