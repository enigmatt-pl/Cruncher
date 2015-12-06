/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruncher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik
 */
public class ReadFile {
    
    static private final List<String> users =  new ArrayList<>();
    static final List<String> hashes =  new ArrayList<>();
    static final List<String> wordl = new ArrayList<>();
    
    static private final String hashFile = "/Users/Erik/Desktop/grp4pw.txt";
   
    public static void grabHashes(String hashPath){
        BufferedReader bufferReader = null;
        
            try{
                String sCurrentLine;
                bufferReader = new BufferedReader(new FileReader(hashPath));
                int l = 0;
            
                while((sCurrentLine = bufferReader.readLine()) != null ){
                    String[] parameters = sCurrentLine.split(":");
                    users.add(parameters[0]);
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
  
    
    public static void processWord(String fileName){
        BufferedReader bufferReader = null;
        
            try{
                String sCurrentLine;
                bufferReader = new BufferedReader(new FileReader(fileName));
                
                while((sCurrentLine = bufferReader.readLine()) != null ){
                    String entry = sCurrentLine;
                    wordl.add(entry);
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
    
    
    public static String getWord(int index){
        return wordl.get(index);
    }
      
    public static String getHash(int index){
        return hashes.get(index);
    }
    
    public static String getUser(int index){
        return users.get(index);
    }
    
    static List<String> processWord(List<String> wordList) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
}
