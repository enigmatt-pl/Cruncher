/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruncher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public final class CommonFile {
    
    private static String currentHash;
    private static final List<String> unhashed =  new ArrayList<>();
    
    public static void addHash(String hash){
        
        currentHash = hash;
        System.out.println("The following hash will be now processed: " + hash);
        
    }
    
    public static void addUnhashedValue(String text){
        
        unhashed.add(text);
        System.out.println("The hash: " + currentHash + " has been cracked! The"
                + " unhashed value is: " + unhashed.get(unhashed.size() - 1));
        
    }
    
    public static void printUnhashedValues(String text){
        
        unhashed.stream().forEach((i) -> {
            System.out.println(i);
        });
        
        
    }
    
}


