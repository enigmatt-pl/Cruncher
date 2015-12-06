/******************************************************************************/
/**
@copyright    UP663375, UP646321, ECE00279
 * 
@author        Mateusz Michalski
@responsible   UP663375
 *
@language      Java SE 8 (March 18, 2014)
 *
@description  BruteForce functionality implementation
 *******************************************************************************/
package cruncher;
 
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
/* INCLUDE FILES **************************************************************/
 
//import org.apache.commons.codec.digest.Crypt;
 
public final class BruteForce {
 
    /* Private variables declarations */
    public static String salt = "aa";
    static String tempHash = "";
    public static String[] hashArray;
    public static ArrayList<String> hashListArray = new ArrayList<String>();
    public static String currentAttempt = "";
 
    static Scanner user_input = new Scanner( System.in );
    static String input;
 
 
    /* run *********************************************************************
     ** 09/11/2015  M.Michalski Initial Version
     ***************************************************************************/
    /** Runs the logic behind brute force functionality
     * @param fileName - name of the UNIX
     ***************************************************************************/
    public static void run(String fileName){
 
        //public static String[] allCharSet ;
 
        String[] allCharSet = new String[] {
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "1","2","3","4","5","6","7","8","9","0",
                "!","£","$","%","^","&","*","(",")","-","_","=","+"
        };
         
        /*
         TODO Accept user customised Character set and use that one instead of allCharSet
         */
 
        // Print CharSet
        System.out.println(Arrays.toString(allCharSet));
 
        // Get password file
        FileWrapper.UnixPasswdFile.processUnixFile(fileName);
 
        // Accept a minimum password length to start from
        System.out.println("Please enter the minimum password length to start from (between 1 and 16): ");
        input= user_input.next();
        int caseNum = Integer.parseInt(input);
 
        switch(caseNum){
        case 1:
            // First test all single digit passwords
            for(int a1 = 0; allCharSet[a1] != null; a1++){
                currentAttempt = "";
                currentAttempt.concat(allCharSet[a1]);
                //currentAttempt.encrypt();
                for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                    // Trim off the salt for each hash
                    tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                    tempHash.substring(2);
                    // Test if current attempt is equal to the current hash
                    if(currentAttempt.equals(tempHash)){
                        System.out.println("Password found!");
                        System.out.println(tempHash + " equals = " + allCharSet[a1]);
                    }}
            }
             
        case 2:
            //Second test all double digit passwords
            for(int b = 0; allCharSet[b] != null; b++){
                for(int a1 = 0; allCharSet[a1] != null; a1++){
                    currentAttempt = "";
                    currentAttempt.concat(allCharSet[b]).concat(allCharSet[a1]);
                    // currentAttempt.encrypt();
                    for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                        // Trim off the salt for each hash
                        tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                        tempHash.substring(2);
                        // Test if current attempt is equal to the current hash
                        if(currentAttempt.equals(tempHash)){
                            System.out.println("Password found!");
                            System.out.println(tempHash + " equals = "+ allCharSet[b] + allCharSet[a1]);
                        }}
                }
            }
             
        case 3:
            //Third test all triple digit passwords
            for(int c = 0; allCharSet[c] != null; c++){
                for(int b = 0; allCharSet[b] != null; b++){
                    for(int a1 = 0; allCharSet[a1] != null; a1++){
                        currentAttempt = "";
                        currentAttempt.concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                        // currentAttempt.encrypt();
                        for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                            // Trim off the salt for each hash
                            tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                            tempHash.substring(2);
                            // Test if current attempt is equal to the current hash
                            if(currentAttempt.equals(tempHash)){
                                System.out.println("Password found!");
                                System.out.println(tempHash + " equals = "+ allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                            }}
                    }
                }
            }
 
        case 4:
            //Forth test all 4 digit passwords
            for(int d = 0; allCharSet[d] != null; d++){
                for(int c = 0; allCharSet[c] != null; c++){
                    for(int b = 0; allCharSet[b] != null; b++){
                        for(int a1 = 0; allCharSet[a1] != null; a1++){
                            currentAttempt = "";
                            currentAttempt.concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                            // currentAttempt.encrypt();
                            for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                // Trim off the salt for each hash
                                tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                tempHash.substring(2);
                                // Test if current attempt is equal to the current hash
                                if(currentAttempt.equals(tempHash)){
                                    System.out.println("Password found!");
                                    System.out.println(tempHash + " equals = "+ allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                }}
                        }
                    }
                }
            }
 
        case 5:
            //5th test all 5 digit passwords
            for(int e = 0; allCharSet[e] != null; e++){
                for(int d = 0; allCharSet[d] != null; d++){
                    for(int c = 0; allCharSet[c] != null; c++){
                        for(int b = 0; allCharSet[b] != null; b++){
                            for(int a1 = 0; allCharSet[a1] != null; a1++){
                                currentAttempt = "";
                                currentAttempt.concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                // currentAttempt.encrypt();
                                for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                    // Trim off the salt for each hash
                                    tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                    tempHash.substring(2);
                                    // Test if current attempt is equal to the current hash
                                    if(currentAttempt.equals(tempHash)){
                                        System.out.println("Password found!");
                                        System.out.println(tempHash + " equals = " + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                    }}
                            }
                        }
                    }
                }}
 
        case 6:
            //6th test all 6 digit passwords
            for(int f = 0; allCharSet[f] != null; f++){
                for(int e = 0; allCharSet[e] != null; e++){
                    for(int d = 0; allCharSet[d] != null; d++){
                        for(int c = 0; allCharSet[c] != null; c++){
                            for(int b = 0; allCharSet[b] != null; b++){
                                for(int a1 = 0; allCharSet[a1] != null; a1++){
                                    currentAttempt = "";
                                    currentAttempt.concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                    // currentAttempt.encrypt();
                                    for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                        // Trim off the salt for each hash
                                        tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                        tempHash.substring(2);
                                        // Test if current attempt is equal to the current hash
                                        if(currentAttempt.equals(tempHash)){
                                            System.out.println("Password found!");
                                            System.out.println(tempHash + " equals = " + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                        }}
                                }
                            }
                        }
                    }}}
 
        case 7:
            //7th test all 7 digit passwords
            for(int g = 0; allCharSet[g] != null; g++){
                for(int f = 0; allCharSet[f] != null; f++){
                    for(int e = 0; allCharSet[e] != null; e++){
                        for(int d = 0; allCharSet[d] != null; d++){
                            for(int c = 0; allCharSet[c] != null; c++){
                                for(int b = 0; allCharSet[b] != null; b++){
                                    for(int a1 = 0; allCharSet[a1] != null; a1++){
                                        currentAttempt = "";
                                        currentAttempt.concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                        // currentAttempt.encrypt();
                                        for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                            // Trim off the salt for each hash
                                            tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                            tempHash.substring(2);
                                            // Test if current attempt is equal to the current hash
                                            if(currentAttempt.equals(tempHash)){
                                                System.out.println("Password found!");
                                                System.out.println(tempHash + " equals = " + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                            }}
                                    }
                                }
                            }
                        }}}}
 
        case 8:
            //8th test all 8 digit passwords
            for(int h = 0; allCharSet[h] != null; h++){
                for(int g = 0; allCharSet[g] != null; g++){
                    for(int f = 0; allCharSet[f] != null; f++){
                        for(int e = 0; allCharSet[e] != null; e++){
                            for(int d = 0; allCharSet[d] != null; d++){
                                for(int c = 0; allCharSet[c] != null; c++){
                                    for(int b = 0; allCharSet[b] != null; b++){
                                        for(int a1 = 0; allCharSet[a1] != null; a1++){
                                            currentAttempt = "";
                                            currentAttempt.concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                            // currentAttempt.encrypt();
                                            for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                // Trim off the salt for each hash
                                                tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                tempHash.substring(2);
                                                // Test if current attempt is equal to the current hash
                                                if(currentAttempt.equals(tempHash)){
                                                    System.out.println("Password found!");
                                                    System.out.println(tempHash + " equals = " + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                }}
                                        }
                                    }
                                }
                            }}}}}
 
        case 9:
            //9th test all 9 digit passwords
            for(int i = 0; allCharSet[i] != null; i++){
                for(int h = 0; allCharSet[h] != null; h++){
                    for(int g = 0; allCharSet[g] != null; g++){
                        for(int f = 0; allCharSet[f] != null; f++){
                            for(int e = 0; allCharSet[e] != null; e++){
                                for(int d = 0; allCharSet[d] != null; d++){
                                    for(int c = 0; allCharSet[c] != null; c++){
                                        for(int b = 0; allCharSet[b] != null; b++){
                                            for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                currentAttempt = "";
                                                currentAttempt.concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                // currentAttempt.encrypt();
                                                for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                    // Trim off the salt for each hash
                                                    tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                    tempHash.substring(2);
                                                    // Test if current attempt is equal to the current hash
                                                    if(currentAttempt.equals(tempHash)){
                                                        System.out.println("Password found!");
                                                        System.out.println(tempHash + " equals = " + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                    }}
                                            }
                                        }
                                    }
                                }}}}}}
 
        case 10:
            //10th test all 10 digit passwords
            for(int j = 0; allCharSet[j] != null; j++){
                for(int i = 0; allCharSet[i] != null; i++){
                    for(int h = 0; allCharSet[h] != null; h++){
                        for(int g = 0; allCharSet[g] != null; g++){
                            for(int f = 0; allCharSet[f] != null; f++){
                                for(int e = 0; allCharSet[e] != null; e++){
                                    for(int d = 0; allCharSet[d] != null; d++){
                                        for(int c = 0; allCharSet[c] != null; c++){
                                            for(int b = 0; allCharSet[b] != null; b++){
                                                for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                    currentAttempt = "";
                                                    currentAttempt.concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                    // currentAttempt.encrypt();
                                                    for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                        // Trim off the salt for each hash
                                                        tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                        tempHash.substring(2);
                                                        // Test if current attempt is equal to the current hash
                                                        if(currentAttempt.equals(tempHash)){
                                                            System.out.println("Password found!");
                                                            System.out.println(tempHash + " equals = " + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                        }}
                                                }
                                            }
                                        }
                                    }}}}}}}
 
        case 11:
            //11th test all 11 digit passwords
            for(int k = 0; allCharSet[k] != null; k++){
                for(int j = 0; allCharSet[j] != null; j++){
                    for(int i = 0; allCharSet[i] != null; i++){
                        for(int h = 0; allCharSet[h] != null; h++){
                            for(int g = 0; allCharSet[g] != null; g++){
                                for(int f = 0; allCharSet[f] != null; f++){
                                    for(int e = 0; allCharSet[e] != null; e++){
                                        for(int d = 0; allCharSet[d] != null; d++){
                                            for(int c = 0; allCharSet[c] != null; c++){
                                                for(int b = 0; allCharSet[b] != null; b++){
                                                    for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                        currentAttempt = "";
                                                        currentAttempt.concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                        // currentAttempt.encrypt();
                                                        for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                            // Trim off the salt for each hash
                                                            tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                            tempHash.substring(2);
                                                            // Test if current attempt is equal to the current hash
                                                            if(currentAttempt.equals(tempHash)){
                                                                System.out.println("Password found!");
                                                                System.out.println(tempHash + " equals = " + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                            }}
                                                    }
                                                }
                                            }
                                        }}}}}}}}
 
        case 12:
            //12th test all 12 digit passwords
            for(int l = 0; allCharSet[l] != null; l++){
                for(int k = 0; allCharSet[k] != null; k++){
                    for(int j = 0; allCharSet[j] != null; j++){
                        for(int i = 0; allCharSet[i] != null; i++){
                            for(int h = 0; allCharSet[h] != null; h++){
                                for(int g = 0; allCharSet[g] != null; g++){
                                    for(int f = 0; allCharSet[f] != null; f++){
                                        for(int e = 0; allCharSet[e] != null; e++){
                                            for(int d = 0; allCharSet[d] != null; d++){
                                                for(int c = 0; allCharSet[c] != null; c++){
                                                    for(int b = 0; allCharSet[b] != null; b++){
                                                        for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                            currentAttempt = "";
                                                            currentAttempt.concat(allCharSet[l]).concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                            // currentAttempt.encrypt();
                                                            for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                                // Trim off the salt for each hash
                                                                tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                                tempHash.substring(2);
                                                                // Test if current attempt is equal to the current hash
                                                                if(currentAttempt.equals(tempHash)){
                                                                    System.out.println("Password found!");
                                                                    System.out.println(tempHash + " equals = " + allCharSet[l] + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                                }}
                                                        }
                                                    }
                                                }
                                            }}}}}}}}}
 
        case 13:
            //13th test all 13 digit passwords
            for(int m = 0; allCharSet[m] != null; m++){
                for(int l = 0; allCharSet[l] != null; l++){
                    for(int k = 0; allCharSet[k] != null; k++){
                        for(int j = 0; allCharSet[j] != null; j++){
                            for(int i = 0; allCharSet[i] != null; i++){
                                for(int h = 0; allCharSet[h] != null; h++){
                                    for(int g = 0; allCharSet[g] != null; g++){
                                        for(int f = 0; allCharSet[f] != null; f++){
                                            for(int e = 0; allCharSet[e] != null; e++){
                                                for(int d = 0; allCharSet[d] != null; d++){
                                                    for(int c = 0; allCharSet[c] != null; c++){
                                                        for(int b = 0; allCharSet[b] != null; b++){
                                                            for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                                currentAttempt = "";
                                                                currentAttempt.concat(allCharSet[m]).concat(allCharSet[l]).concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                                // currentAttempt.encrypt();
                                                                for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                                    // Trim off the salt for each hash
                                                                    tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                                    tempHash.substring(2);
                                                                    // Test if current attempt is equal to the current hash
                                                                    if(currentAttempt.equals(tempHash)){
                                                                        System.out.println("Password found!");
                                                                        System.out.println(tempHash + " equals = " + allCharSet[m] + allCharSet[l] + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                                    }}
                                                            }
                                                        }
                                                    }
                                                }}}}}}}}}}
 
        case 14:
            //14th test all 14 digit passwords
            for(int n = 0; allCharSet[n] != null; n++){
                for(int m = 0; allCharSet[m] != null; m++){
                    for(int l = 0; allCharSet[l] != null; l++){
                        for(int k = 0; allCharSet[k] != null; k++){
                            for(int j = 0; allCharSet[j] != null; j++){
                                for(int i = 0; allCharSet[i] != null; i++){
                                    for(int h = 0; allCharSet[h] != null; h++){
                                        for(int g = 0; allCharSet[g] != null; g++){
                                            for(int f = 0; allCharSet[f] != null; f++){
                                                for(int e = 0; allCharSet[e] != null; e++){
                                                    for(int d = 0; allCharSet[d] != null; d++){
                                                        for(int c = 0; allCharSet[c] != null; c++){
                                                            for(int b = 0; allCharSet[b] != null; b++){
                                                                for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                                    currentAttempt = "";
                                                                    currentAttempt.concat(allCharSet[n]).concat(allCharSet[m]).concat(allCharSet[l]).concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                                    // currentAttempt.encrypt();
                                                                    for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                                        // Trim off the salt for each hash
                                                                        tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                                        tempHash.substring(2);
                                                                        // Test if current attempt is equal to the current hash
                                                                        if(currentAttempt.equals(tempHash)){
                                                                            System.out.println("Password found!");
                                                                            System.out.println(tempHash + " equals = " + allCharSet[n] + allCharSet[m] + allCharSet[l] + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                                        }}
                                                                }
                                                            }
                                                        }
                                                    }}}}}}}}}}}
 
        case 15:
            //15th test all 15 digit passwords
            for(int o = 0; allCharSet[o] != null; o++){
                for(int n = 0; allCharSet[n] != null; n++){
                    for(int m = 0; allCharSet[m] != null; m++){
                        for(int l = 0; allCharSet[l] != null; l++){
                            for(int k = 0; allCharSet[k] != null; k++){
                                for(int j = 0; allCharSet[j] != null; j++){
                                    for(int i = 0; allCharSet[i] != null; i++){
                                        for(int h = 0; allCharSet[h] != null; h++){
                                            for(int g = 0; allCharSet[g] != null; g++){
                                                for(int f = 0; allCharSet[f] != null; f++){
                                                    for(int e = 0; allCharSet[e] != null; e++){
                                                        for(int d = 0; allCharSet[d] != null; d++){
                                                            for(int c = 0; allCharSet[c] != null; c++){
                                                                for(int b = 0; allCharSet[b] != null; b++){
                                                                    for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                                        currentAttempt = "";
                                                                        currentAttempt.concat(allCharSet[o]).concat(allCharSet[n]).concat(allCharSet[m]).concat(allCharSet[l]).concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                                        // currentAttempt.encrypt();
                                                                        for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                                            // Trim off the salt for each hash
                                                                            tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                                            tempHash.substring(2);
                                                                            // Test if current attempt is equal to the current hash
                                                                            if(currentAttempt.equals(tempHash)){
                                                                                System.out.println("Password found!");
                                                                                System.out.println(tempHash + " equals = " + allCharSet[o] + allCharSet[n] + allCharSet[m] + allCharSet[l] + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                                            }}
                                                                    }
                                                                }
                                                            }
                                                        }}}}}}}}}}}}
 
        case 16:
            //16th test all 16 digit passwords
            for(int p = 0; allCharSet[p] != null; p++){
                for(int o = 0; allCharSet[o] != null; o++){
                    for(int n = 0; allCharSet[n] != null; n++){
                        for(int m = 0; allCharSet[m] != null; m++){
                            for(int l = 0; allCharSet[l] != null; l++){
                                for(int k = 0; allCharSet[k] != null; k++){
                                    for(int j = 0; allCharSet[j] != null; j++){
                                        for(int i = 0; allCharSet[i] != null; i++){
                                            for(int h = 0; allCharSet[h] != null; h++){
                                                for(int g = 0; allCharSet[g] != null; g++){
                                                    for(int f = 0; allCharSet[f] != null; f++){
                                                        for(int e = 0; allCharSet[e] != null; e++){
                                                            for(int d = 0; allCharSet[d] != null; d++){
                                                                for(int c = 0; allCharSet[c] != null; c++){
                                                                    for(int b = 0; allCharSet[b] != null; b++){
                                                                        for(int a1 = 0; allCharSet[a1] != null; a1++){
                                                                            currentAttempt = "";
                                                                            currentAttempt.concat(allCharSet[p]).concat(allCharSet[o]).concat(allCharSet[n]).concat(allCharSet[m]).concat(allCharSet[l]).concat(allCharSet[k]).concat(allCharSet[j]).concat(allCharSet[i]).concat(allCharSet[h]).concat(allCharSet[g]).concat(allCharSet[f]).concat(allCharSet[e]).concat(allCharSet[d]).concat(allCharSet[c]).concat(allCharSet[b]).concat(allCharSet[a1]);
                                                                            // currentAttempt.encrypt();
                                                                            for(int a2 = 0; FileWrapper.UnixPasswdFile.getHash(a2) != null; a2++){
                                                                                // Trim off the salt for each hash
                                                                                tempHash = FileWrapper.UnixPasswdFile.getHash(a2);
                                                                                tempHash.substring(2);
                                                                                // Test if current attempt is equal to the current hash
                                                                                if(currentAttempt.equals(tempHash)){
                                                                                    System.out.println("Password found!");
                                                                                    System.out.println(tempHash + " equals = " + allCharSet[p] + allCharSet[o] + allCharSet[n] + allCharSet[m] + allCharSet[l] + allCharSet[k] + allCharSet[j] + allCharSet[i] + allCharSet[h] + allCharSet[g] + allCharSet[f] + allCharSet[e] + allCharSet[d] + allCharSet[c] + allCharSet[b] + allCharSet[a1]);
                                                                                }}
                                                                        }
                                                                    }
                                                                }
                                                            }}}}}}}}}}}}}
 
        default:    System.out.println("Invalid number");
                    break;
 
        } 
    }
}