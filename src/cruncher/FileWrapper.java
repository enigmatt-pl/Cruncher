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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileWrapper {
    
    static PrintWriter writer;
            
    public static void initOutputFile(String outputFile){
        try {
            writer = new PrintWriter("cache.csv", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(BruteForceMasked.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void writeToOutputFile(String text){
        writer.println(text);
    }
   
    public static class UnixPasswdFile {

        /* Private variables declarations */
        static public final List<String> liHashes =  new ArrayList<>();

        /* processFile *************************************************************
        ** 09/11/2015  M.Michalski Initial Version
        ***************************************************************************/
        /** Processes the passwd file and holds the result in the liHashes ArrayList
         * @param fileName - name of the UNIX passwd file
        ***************************************************************************/
        public static void processUnixFile(String fileName){
        BufferedReader bufferReader = null;

            try{
                String sCurrentLine;
                bufferReader = new BufferedReader(new FileReader(fileName));

                while((sCurrentLine = bufferReader.readLine()) != null ){
                    String[] parameters = sCurrentLine.split(":");
                    liHashes.add(parameters[1]);
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

        /* getHash *************************************************************
        ** 15/11/2015  M.Michalski Initial Version
        ***********************************************************************/
        /** Takes index of the hash to be returned
         * @param index
         * @return selected hash
        ***********************************************************************/
        public static String getHash(int index){
            if(index < liHashes.size())
                return liHashes.get(index);
            else 
                return"";
        }
    }
}
