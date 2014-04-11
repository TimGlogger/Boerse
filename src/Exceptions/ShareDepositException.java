package Exceptions;

public class ShareDepositException extends Exception{
    String Fehlermeldung;
    
    public ShareDepositException(String uebergabe){
        
        this.Fehlermeldung = uebergabe;
        
    }    
    
}
