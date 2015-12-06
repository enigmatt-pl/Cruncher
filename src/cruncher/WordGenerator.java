/******************************************************************************/
/**
@file         WordGenerator.java
@copyright    Mateusz Michalski
* 
@author       Mateusz Michalski (UP663375)
*
@language     Java SE 8 (March 18, 2014)
*
@description  Generates all possible word combinations according to the mask
*             provided. generate() followed by nextSequence() is used in order
*             to produce output.
*******************************************************************************/
package cruncher;

import java.util.ArrayList;


public class WordGenerator {
    
    /* Private variables declarations */
    private final int iInitSize;
    private final char[] cMask;
    private ArrayList<Character> liLowerCaseEnAlphabet;
    private ArrayList<Character> liUpperCaseEnAlphabet;
    private ArrayList<Character> liDigit;
    private ArrayList<Character> liSymbols;
    private ArrayList<Character> liAll;
    
    /* Public variables declarations */

    /**
     * Holds all possible symbols
     */
    public static ArrayList<ArrayList> liWord;
    public static int iWordSize;

    /**
     * Holds current sequence
     */
    public static ArrayList<Integer> liSequence = new ArrayList<>();
    
    /* Constructor *************************************************************
    ** 12/11/2015  M.Michalski    Initial Version
    ****************************************************************************/
    /* Description: Constructor of the WordGenerator class
     * @param sMask - mask to be used by the program
    ****************************************************************************/
    public WordGenerator(String sMask){
        this.cMask = sMask.toCharArray();
        this.iInitSize = cMask.length;
        
        initSymbols('l');
        initSymbols('u');
        initSymbols('d');
        initSymbols('s');
        initSymbols('a');
        
        initConditions();
        
        /**
        * init the sequence with 0s  
        */
        for(int i = 0; i < iInitSize; i++){
            WordGenerator.liSequence.add(0);
        }
        
    }//end Constructor
    
    /* initConditions **********************************************************
    ** 15/11/2015  M.Michalski    Initial Version
    ****************************************************************************/
    /** Description: assigns sets of symbols for each character
     *  according to the mask.  
    ****************************************************************************/
    private void initConditions(){
        
        liWord = new ArrayList<>();
        for(int i = 0; i < iInitSize; i++){
            switch(cMask[i]){
                case 'l':
                case 'L':   
                    liWord.add(liLowerCaseEnAlphabet);
                    break;
                case 'u':
                case 'U':    
                    liWord.add(liUpperCaseEnAlphabet);
                    break;
                case 'd':
                case 'D':
                    liWord.add(liDigit);
                    break;
                case 's':
                case 'S':
                    liWord.add(liSymbols);
                    break;
                case 'a':
                case 'A':
                    liWord.add(liAll);
                    break;
            }
        }
        
        iWordSize = liWord.size();
        
    }//end initConditions
    
    /* initConditions **********************************************************
    ** 15/11/2015  M.Michalski    Initial Version
    ****************************************************************************/
    /* Description: generates one word according to the specification 
     * @return sOutput
    ****************************************************************************/
    public String generate(){
        String sOutput = "";

        for(int i =0; liWord.size() > i; i++){

            sOutput += liWord.get(i).get(liSequence.get(i));
        }
        return sOutput;
    }//end generate()
    
    /* nextSequence ************************************************************
    ** 16/11/2015  M.Michalski    Initial Version
    ****************************************************************************/
    /* Description: increments liSequence in order to notify how the next word 
     *  should be generated
    ****************************************************************************/
    public static void nextSequence(int iSize){
        
        if(iSize == iWordSize){
            return;
        }
        
        if(liSequence.get(iSize) < liWord.get(iSize).size() - 1)//1
            liSequence.set(iSize, liSequence.get(iSize) + 1);
        else{
            liSequence.set(iSize, 0);
            nextSequence(++iSize); 
        }
    }//end nextSequence()
    
    /* initSymbols *************************************************************
    ** 14/11/2015  M.Michalski    Initial Version
    ****************************************************************************/
    /* Description: initialises ASCII characters into the relevant array lists
    ****************************************************************************/
    private void initSymbols(char cSymbol){
        
        char ch; //identified chaarcter
                
        switch(cSymbol){
            case 'l':
                liLowerCaseEnAlphabet = new ArrayList<>();
                for( ch = 0x61; ch <= 0x7A ; ch++){
                   liLowerCaseEnAlphabet.add(ch);
                }
            break;
                
            case 'u':
                liUpperCaseEnAlphabet = new ArrayList<>();
                for( ch = 0x41; ch <= 0x5A ; ch++){
                   liUpperCaseEnAlphabet.add(ch);
                }
            break;
                
            case 'd':
                liDigit = new ArrayList<>();
                for( ch = 0x30; ch <= 0x39 ; ch++){
                   liDigit.add(ch);
                }
            break;
                
            case 's':
                liSymbols = new ArrayList<>();
                for( ch = 0x20; ch <= 0x2F; ch++){ //first part of symbols
                   liSymbols.add(ch);
                }
                for( ch = 0x3A; ch <= 0x40; ch++){ //second part of symbols
                   liSymbols.add(ch);
                }
                for( ch = 0x5B; ch <= 0x60; ch++){ //third part of symbols
                   liSymbols.add(ch);
                }
                for( ch = 0x7B; ch <= 0x7E; ch++){ //fourth part of symbols
                   liSymbols.add(ch);
                } 
            break;
                
            case 'a':
                liAll = new ArrayList<>();
                for( ch = 0x20; ch <= 0x7E; ch++){ //All Symbols from [Space] to ~
                   liAll.add(ch);
                }
            break;
            }//end switch
    }//end initSymbols()
    
    
}//end class
