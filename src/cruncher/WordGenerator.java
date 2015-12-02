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

import java.util.ArrayList;


public class WordGenerator {
    
    /* Private variables declarations */
    private int    iSize;
    private String sWord;
    private char[] cMask;
    private char[] cSymbol;
    private int[]  iMaxIter;
    private ArrayList<Character> cLowerCaseEnAlphabet;
    private ArrayList<Character> cUpperCaseEnAlphabet;
    private ArrayList<Character> cDigit;
    private ArrayList<Character> cSymbols;
    
    /* Public variables declarations */
    public long lSequenceNo = 0;
    public ArrayList<ArrayList> LiWord;
    
    public WordGenerator(String sMask){
        this.cMask = sMask.toCharArray();
        this.iSize = cMask.length;
        
        initSymbols('l');
        initSymbols('u');
        initSymbols('d');
        initSymbols('s');
        
        initConditions();
    }
    
    private void initConditions(){
        LiWord = new ArrayList<>();
        for(int i = 0; i < iSize; i++){
            switch(cMask[i]){
                case 'l':
                    LiWord.add(cLowerCaseEnAlphabet);
                    break;
                case 'L':
                    LiWord.add(cLowerCaseEnAlphabet);
                    break;
                case 'u':
                    LiWord.add(cUpperCaseEnAlphabet);
                    break;
                case 'U':
                    LiWord.add(cUpperCaseEnAlphabet);
                    break;
                case 'd':
                    LiWord.add(cDigit);
                    break;
                case 'D':
                    LiWord.add(cDigit);
                    break;
                case 's':
                    LiWord.add(cSymbols);
                    break;
                case 'S':
                    LiWord.add(cSymbols);
                    break;
            }
        }
    }
    public String generate(){
        String sOutput = "";

        for(int i =0; i < LiWord.size(); i++){
            
            sOutput += LiWord.get(i).get(i);
        }
        
        return sOutput;
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
