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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class BruteForce {
    
    /* Private variables declarations */
   
    
    public static String run(String fileName){
        BufferedReader bufferReader = null;

        try{

            String sCurrentLine;

            bufferReader = new BufferedReader(new FileReader(fileName));

            while ((sCurrentLine = bufferReader.readLine()) != null) {
                System.out.println(sCurrentLine);
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
