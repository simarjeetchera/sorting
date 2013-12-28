package models;

import java.util.*;

import javax.validation.*;

import play.data.validation.Constraints.*;

public class Contact {
      
    
    @Valid
    public List<Information> informations;
    
    
    public static class Information {
        
        @Required
        public String label;
        
        @Email
        public String email;
            
        
        public Information() {}
        
        public Information(String label, String email) {
            this.label = label;
            this.email = email;
            
        }
        
       
        
    }
    
}