package program.java.validation_email;

import java.util.regex.*;    
import java.util.*;    
public class Email_Validation{  
    public static void main(String args[]){  
        ArrayList<String> emails = new ArrayList<String>();  
        emails.add("firstname@gmail.co.in");  
        emails.add("javaTpoint@gmail.com");  
        emails.add("java-class#@gmail.co.in");  
        emails.add("test123prepare@co.edu.com");  
        emails.add("javaclass@gmailcom");  
        emails.add("@yahoo.com");  
        emails.add("12javaTpoint#gmail.com");   
        String regex = "^(.+)@(.+)$";   
        Pattern pattern = Pattern.compile(regex);   
        for(String email : emails){  
            Matcher matcher = pattern.matcher(email);  
            System.out.println(email +" : "+ matcher.matches()+"\n");  
        }  
    }  
}  
