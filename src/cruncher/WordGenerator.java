/******************************************************************************/
/**
@file         WordGenerator.java
@copyright    UP663375, UP646321, ECE00279
* 
@author        Mateusz Michalski
@responsible   UP663375
*
@language      Java SE 8 (March 18, 2014)
*
@description  Generates all possible word combinations within n size
*******************************************************************************/
package cruncher;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;


public class WordGenerator {
    
    /* Private variables declarations */
    private int    iSize;
    private String sWord;
    private char[] cMask;
    private char[] cSymbol;
    private ArrayList<Character> cLowerCaseEnAlphabet;
    private ArrayList<Character> cUpperCaseEnAlphabet;
    private ArrayList<Character> cDigit;
    private ArrayList<Character> cSymbols;
    
    /* Public variables declarations */
    public long lSequenceNo = 1;

    /**
     * Holds all possible symbols
     */
    public static ArrayList<ArrayList> liWord;

    /**
     * Holds current sequence
     */
    public static ArrayList<Integer> bSequence = new ArrayList<>();
    
    public WordGenerator(String sMask){
        this.cMask = sMask.toCharArray();
        this.iSize = cMask.length;
        
        initSymbols('l');
        initSymbols('u');
        initSymbols('d');
        initSymbols('s');
        
        initConditions();
        
        for(int i = 0; i <= iSize; i++){
            WordGenerator.bSequence.add(0);
        }
        
    }
    
    private void initConditions(){
        lSequenceNo = lSequenceNo << (iSize * 8 - 1);
        
        liWord = new ArrayList<>();
        for(int i = 0; i < iSize; i++){
            switch(cMask[i]){
                case 'l':
                    liWord.add(cLowerCaseEnAlphabet);
                    break;
                case 'L':
                    liWord.add(cLowerCaseEnAlphabet);
                    break;
                case 'u':
                    liWord.add(cUpperCaseEnAlphabet);
                    break;
                case 'U':
                    liWord.add(cUpperCaseEnAlphabet);
                    break;
                case 'd':
                    liWord.add(cDigit);
                    break;
                case 'D':
                    liWord.add(cDigit);
                    break;
                case 's':
                    liWord.add(cSymbols);
                    break;
                case 'S':
                    liWord.add(cSymbols);
                    break;
            }
        }
    }
    public String generate(){
        String sOutput = "";

        for(int i =0; i < liWord.size(); i++){

            sOutput += liWord.get(i).get(bSequence.get(i));
        }
        //System.out.println(lSequenceNo);
        return sOutput;
    }
    
    public static void nextSequence(){
        ArrayList<Integer> liNextSequence = new ArrayList<>();
        
        int i = 0;
        if(bSequence.get(i) < liWord.get(i).size() - 1)
            bSequence.set(i, bSequence.get(i) + 1);
        
        else{
            bSequence.set(i, 0);
            i++;
            if (bSequence.get(i) < liWord.get(i).size() - 1)
                bSequence.set(i, bSequence.get(i) + 1);
            else{
                bSequence.set(i, 0);
                i++;
                if (bSequence.get(i) < liWord.get(i).size() - 1)
                    bSequence.set(i, bSequence.get(i) + 1);
                else{
                    bSequence.set(i, 0);
                    i++;
                    if (bSequence.get(i) < liWord.get(i).size() - 1)
                        bSequence.set(i, bSequence.get(i) + 1);
                    else{
                        bSequence.set(i, 0);
                        i++;
                        if (bSequence.get(i) < liWord.get(i).size() - 1)
                            bSequence.set(i, bSequence.get(i) + 1);
                        else{
                            bSequence.set(i, 0);
                            i++;
                            if (bSequence.get(i) < liWord.get(i).size() - 1)
                                bSequence.set(i, bSequence.get(i) + 1);
                            else{
                                bSequence.set(i, 0);
                                i++;
                                if (bSequence.get(i) < liWord.get(i).size() - 1)
                                    bSequence.set(i, bSequence.get(i) + 1);
                                else{
                                    bSequence.set(i, 0);
                                    i++;
                                    if (bSequence.get(i) < liWord.get(i).size() - 1)
                                        bSequence.set(i, bSequence.get(i) + 1);
                                }
                            }
                        }
                    }
                }
            }

        }
    }
    private void initSymbols(char cSymbol){
        
        char ch; //identified chaarcter
                
        switch(cSymbol){
            case 'l':
                cLowerCaseEnAlphabet = new ArrayList<>();
                for( ch = 0x61; ch <= 0x7A ; ch++){
                   cLowerCaseEnAlphabet.add(ch);
                }
            break;
                
            case 'u':
                cUpperCaseEnAlphabet = new ArrayList<>();
                for( ch = 0x41; ch <= 0x5A ; ch++){
                   cUpperCaseEnAlphabet.add(ch);
                }
            break;
                
            case 'd':
                cDigit = new ArrayList<>();
                for( ch = 0x30; ch <= 0x39 ; ch++){
                   cDigit.add(ch);
                }
            break;
                
            case 's':
                cSymbols = new ArrayList<>();
                for( ch = 0x20; ch <= 0x2F; ch++){ //first part of symbols
                   cSymbols.add(ch);
                }
                for( ch = 0x3A; ch <= 0x40; ch++){ //second part of symbols
                   cSymbols.add(ch);
                }
                
            break;
            }
    }   
    
    
}
