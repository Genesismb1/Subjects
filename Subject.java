package javaapplication4;
import java.util.ArrayList;

public class Subject {
    private String subjName, subjCode;
    
    //Definition of the Subject constructor which takes the subject name and subject code as arguments and initializes the subjName and subjCode variables which those values
    
    public Subject(String subName, String subCode){
        this.subjName=subName;
        this.subjCode=subCode;
    }
    
    //Definition of the getter method for the subjName variable which returns the current value of the variable
    
    public String getSubjectName(){
        return subjName;
    }
    
    //Definition of the getter method for the subjCode variable which returns the current value of the variable
    
    public String getSubjectCode(){
        return subjCode;
    }
    
    //Definition of the codeMatches method which checks if the value sent as parameter matches the subjCode variable of the current object that calls the function
    
    public boolean codeMatches(String checkCode){
        return checkCode.matches(subjCode);
    }
    
    //Definition of the toString method which overrides the function of the java String class, and returns a string containing the subjName and subjCode so that it can be copied to the text file
    
    @Override
    public String toString(){
        return (subjName + "," + subjCode.toUpperCase());
    }
    
    //Definition of the isValidCode method which checks if the value sent as parameter is a valid subject code
    
    public static boolean isValidCode(String checkCode){
        String str=checkCode.trim();
        
        //returns true if the length of the string is 6, if the first three characters are letters, and last three characters are digits. returns false if the string does not match any one of the above mentioned conditions
        
        return str.matches("[a-zA-z]{3}\\d{3}");
                
        //((str.length()==6) && (Character.isLetter(str.charAt(0))) && (Character.isLetter(str.charAt(1))) && (Character.isLetter(str.charAt(2))) && Character.isDigit(str.charAt(3)) && Character.isDigit(str.charAt(4)) && Character.isDigit(str.charAt(5)));
            }
    
    //Definition of the codeExists method which checks the code to be checked across the entire array of subjects available and returns true if the code to be checked matches any value in the array
    
    public static boolean codeExists(ArrayList<Subject> subArr, String subCode){
        for (Subject subArr1 : subArr) {
            
            // Calling the codeMatches method to check if the value of the subjCode variable of the calling object matches the code to be checked
            //If code matches return true and if the code does not match any of the existing values then return false
            
            if (subArr1.codeMatches(subCode.toUpperCase())) {
                return true;
            }
        }
        
        // 
        return false;
    }
}
