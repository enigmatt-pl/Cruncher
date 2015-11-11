/******************************************************************************/
/**
@file         BruteForce.java
@copyright    UP663375, UP646321, ECE00279
*
@language     Java
*
@description  BruteForce functionality implementation
*******************************************************************************/
package cruncher;

/* INCLUDE FILES **************************************************************/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class BruteForce {
    
    /* Private variables declarations */
    static private final List<String> hashes =  new ArrayList<>();
   
    
    public static String run(String fileName){
        BufferedReader bufferReader = null;

        try{

            String sCurrentLine;

            bufferReader = new BufferedReader(new FileReader(fileName));
            int lineNumber = 0;
            
            while ((sCurrentLine = bufferReader.readLine()) != null) {
                String[] parameters = sCurrentLine.split(":");
                hashes.add(parameters[1]);
                System.out.println(hashes.get(lineNumber));
                lineNumber++;
            }

        } 
        catch (IOException e) {
            e.printStackTrace();
        
        } 
        finally {
            try {
                if (bufferReader != null)bufferReader.close();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return "result";
        
    }
}
