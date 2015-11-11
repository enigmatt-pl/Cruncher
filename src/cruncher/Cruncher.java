/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruncher;

/**
 *
 * @author Mateusz
 */
public class Cruncher {
    
    /*
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Setting the parameters");
        
        switch(args[0]){
            case "1":
                System.out.println("Simple Brute Force selected");
                //Create your class here
                endProgram();
                break;
            case "2":
                System.out.println("Brute Force with Masking selected");
                //Create your class here
                endProgram();
            case "3":
                System.out.println("Dictionary attack selected");
                //Create your class here
                endProgram();
                break;
            default:
                System.out.println("Wrong parameters provided please try again");
                endProgram();
                break;
                
        }
        
            
    }
    
    public static void endProgram(){
        System.out.println("Press Enter to continue");
        try{System.in.read();}
        catch(Exception e){}
    }

    
}

/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
                String s = br.readLine();
                System.out.println(s);
            } catch (IOException ex) {
                Logger.getLogger(Cruncher.class.getName()).log(Level.SEVERE, null, ex);
                
            }
*/