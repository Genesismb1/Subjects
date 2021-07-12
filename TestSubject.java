package javaapplication4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;


public class TestSubject {
    
    //declaring the ArrayList of Subject class and the count variable as static since they are independent of an object and should be called without using object
    
    static ArrayList <Subject> subArr = new ArrayList<Subject>();
    static int count=0;
    
    //Definition of the assignSubjArray method which reads lines from the subjects.txt file and assigns the values to the subject arraylist
    
    public static void assignSubjArray(){
        
        //Exception handling for dealing with cases when file is not readable or available
        
        try{
            
            File fileObj=new File("src/javaapplication4/subjects.txt");
            
            // Reading the lines in the file as long as there are lines in the file
            try (Scanner scan = new Scanner (fileObj)) {
                
                while (scan.hasNextLine()){
                    String [] line;
                    
                    // splitting the line on the basis of , and assigning the first part of the split String to the subjName variable of the Subject object and the second part to the subjCode variable of the Subject object
                    
                    line = scan.nextLine().trim().split(",");
                    subArr.add(new Subject(line[0],line[1]));
                }
                scan.close();
            }
                 
    }
        
        // Exception handling if file is not found
        
        catch (FileNotFoundException e) {
      System.out.println("\nFile not found.");
    }
    }
    
    //Definition of the printSubArr method which prints the values present in the Subject array list by converting the values of its variables into a single String by calling the toString method
    
    public static void printSubArr(){
        System.out.println("\nThe current subject list is: \n");
        for(Subject subArr1: subArr)
    {
        System.out.println(subArr1.toString());
    }
    }
    
    //Definition of the promptUser function which prompts the user if they want to add new subject, and allows them to do so if they enter y/Y
    
    public static boolean promptUser (){
        
        Scanner scan=new Scanner(System.in);
        char rep='y';
        while(rep=='y'){
           System.out.println("\nDo you want to add new subject? (Y/y or N/n)"); 
           rep = scan.next().charAt(0);
           
           //Tells the user to Enter a character if the entered value is not a character 
           
           if(!Character.isLetter(rep)) {
               System.out.println("\nEnter a character");
               rep='y';
           } 
           
           // Tells user to enter either y/Y or n/N if the entered value is not y/Y or n/N
           
           else if (Character.toLowerCase(rep)!='y' && Character.toLowerCase(rep)!='n'){
               System.out.println("\nEnter either Y/y or N/n");
               rep='y';
           }
           //return true if user enters y/Y, i.e. wants to add a new subject
           
           else if(Character.toLowerCase(rep)=='y'){
               return true;
           }
        }
        
        //returns false if user enters letter, letter is either y/Y or n/N and letter is not y/Y, i.e. if letter = n/N
        
        return false;
    }
    
    //Definition of the addSubject function which prompts the user to enter the new subject name and code in different lines, checks if code is valid by calling the isValidCode function, checks if the code does not exist by calling the codeExists function, and creates a new Subject arraylist value if code is valid and does not exist
    
    public static void addSubject(){
        Scanner scan = new Scanner(System.in);
        
        char rep='y';
        while(rep=='y'){
            
            System.out.println("\nEnter new subject name and code in different lines");
            
            String subjName=scan.nextLine();
            String subjCode=scan.nextLine();
            
            //enters loop only if entered code is valid
            if(Subject.isValidCode(subjCode)){
                
                //Enters loop only if entered code does not exist
                
                if(!Subject.codeExists(subArr,subjCode)) {
                    
                    //add new Subject arraylist item if code is valid and does not already exist in the arraylist
                    
                    subArr.add(new Subject(subjName, subjCode.toUpperCase()));
                    
                    //increase count if subject is added
                    
                    count++;
                    System.out.println("\n The subject has been added");
                    printSubArr();
                    rep='n';
                } 
                
                // display the message if code already exists
                
            else System.out.println("\nSubject code already exists!!");
            rep='n';
        }
            // display the message if code is invalid
            
            else System.out.println("\nSubject code is invalid, enter 6 characters (First three letters and last three digits)!!");
            rep='n';
        }
        }

    
    //Definition of the writeToFile function which writes the current value and items present in the Subject arraylist (subArr) to the subjects.txt file
    
    
    public static void writeToFile(){
        
        //Exeption handling for cases when file does not exist or is not available
        
        try{
            FileWriter writer=new FileWriter("src/javaapplication4/subjects.txt");
            
          for(Subject subArr1:subArr){
              
            //write the values of the subArr arraylist to different lines as long as there are items in the arraylist
            
            writer.write(subArr1.toString());
            writer.write("\n");
        }
        writer.close();
    }
    catch (IOException ex) {
            System.out.println("\nAn error occured");
        }
    }
        
    public static void main(String args[]){
        
        //calling the assignSubjArray function to assign items present in the text file into an arraylist of Subject objects
        
        assignSubjArray();
        
        //only enters the loop if user presses y/Y when asked to add a new subject
        
        while(promptUser()) {
            
            // prints the current values of the subArr arraylist
            
            printSubArr();
            
            // calling the addSubject function to allow user to add subject into the existing subArr arraylist if the entered code is valid, and if the entered code does not exist. if subject is added, then the value of count variable is increased
            
            addSubject();
            
        }
        
        //calling the writeToFile function only if count is +ve, i.e. if subArr arraylist has infact been updated
        
        if(count>0) writeToFile();
    }
}
