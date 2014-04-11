package Exceptions;

public class ShareException extends Exception{
    
    String Fehlermeldung;
    
    public ShareException(String uebergabe){
        
        this.Fehlermeldung = uebergabe;
        
    }    
    
    
    
    
}
