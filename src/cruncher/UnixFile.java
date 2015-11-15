/******************************************************************************/
/**
@file          UnixFile.java
@copyright     UP663375, UP646321, ECE00279
* 
@author        Mateusz Michalski
@responsible   UP663375, UP646321, ECE00279
*
@language      Java SE 8 (March 18, 2014)
*
@description   Processes Unix passwd file in order to retrieve all the hashed 
*              passwords
*             
*              
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class UnixFile {
    
    /* Private variables declarations */
    static private final List<String> hashes =  new ArrayList<>();
    
    /* processFile *************************************************************
    ** 09/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Processes the passwd file and holds the result in the hashes ArrayList
     * @param fileName - name of the UNIX passwd file
    ***************************************************************************/
    public static void processFile(String fileName){
    BufferedReader bufferReader = null;
        
        try{
            String sCurrentLine;
            bufferReader = new BufferedReader(new FileReader(fileName));
            int lineNumber = 0;
            
            while((sCurrentLine = bufferReader.readLine()) != null ){
                String[] parameters = sCurrentLine.split(":");
                hashes.add(parameters[1]);
            }
        } 
        catch (IOException e){
        } 
        
        finally{
            try{
                if (bufferReader != null)bufferReader.close();
            } 
            catch (IOException e) {
            }    
        }
    }
    
    /* getHash *****************************************************************
    ** 15/11/2015  M.Michalski Initial Version
    ***************************************************************************/
    /** Takes index of the hash to be returned
     * @param index
     * @return selected hash
    ***************************************************************************/
    public static String getHash(int index){
        return hashes.get(index);
    }
}
