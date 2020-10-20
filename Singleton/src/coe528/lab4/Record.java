/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab4;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

/**
 *
 * @author Rohan Zahid
 */
public class Record {     
    // Name of the associated file     
    private String filename;
    private static Record instance;
    private Record(String n) {         
        filename = n;     
    }          
    // Effects: Reads and prints the contents of the associated      
    // file to the standard output.       
    public void read() {         
        try {             
            Scanner fscan = new Scanner(new File(filename));
            String s = "";
            while(fscan.hasNext()) {
                s += fscan.nextLine()+ "\n";
            }
            System.out.println(s);

        } catch (IOException e) {             
            System.out.println("An error occurred.");             
            e.printStackTrace();         
        }     
    }       
 
    // Effects: Appends the specified message, msg, to the      
    // associated file.     
    public void write(String msg) {         
        try {             
            FileWriter fps = new FileWriter(new File(filename), true);
            fps.write(msg);
            fps.close();
            
        } catch (IOException e) {             
            System.out.println("An error occurred.");
            e.printStackTrace();  
        }                          
    }
    public static Record getInstance() {
        if(instance == null)
            instance = new Record("record.txt");
        return instance;
    }
 
    public static void main(String[] args) {         
        // Fill the blank below that obtains the sole instance          
        // of the Record class.          
        // (You should not invoke the Record constructor here.) 
        Record r = Record.getInstance();          
        // Do not modify the code below         
        r.write("Hello-1\n");         
        r.write("Hello-2\n");                  
        System.out.println("Currently the file record.txt " + "contains the following lines:");         
        r.read();     
    } 
}
