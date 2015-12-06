/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruncher;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.Crypt;

/**
 *
 * @author Erik
 */
public class Crack {
    
    /* Matched user details to be stored in these arrays */
    static final List<String> crackedUser =  new ArrayList<>();
    static final List<String> crackedPasswd = new ArrayList<>();
    
    /* Fixed path for dictionary file and salt */
    //public static String pathWord = "/Users/Erik/Desktop/test_dictionary.txt";
    public static String salt = "aa";
    
    public static void DisplayCracked(){
        int i = 0;
        
        while ( i < crackedUser.size()){
            System.out.println("  || Username: "+ crackedUser.get(i) + " | Password: " + crackedPasswd.get(i) + " ||");
            i++;
        }
    }
    
    public static void run(String hashList, String pathWord){
        /* Counters */
        int i = 0;
        
        /* Grab and read files */
        ReadFile.grabHashes(hashList);
        ReadFile.processWord(pathWord);
        
        while (i < ReadFile.hashes.size()){
            int a = 0;
            while (a < ReadFile.wordl.size()){
                if ((null == (ReadFile.getHash(i)) ? Crypt.crypt((ReadFile.getWord(a)),salt) == null : (ReadFile.getHash(i)).equals(Crypt.crypt((ReadFile.getWord(a)),salt)))){
                    System.out.println("\n Match found! The password is: \n " + ReadFile.getWord(a) + " for user " + ReadFile.getUser(i));
                    crackedUser.add(ReadFile.getUser(i));
                    crackedPasswd.add(ReadFile.getWord(a));
                }
                a++;
            }
            i++;
        }
    }
    
    
    
}
