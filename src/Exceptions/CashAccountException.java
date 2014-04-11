

package Exceptions;


public class CashAccountException extends Exception{
    String Fehlermeldung;
    
    public CashAccountException(String uebergabe){
        
        this.Fehlermeldung = uebergabe;
        
    }    
    
    
}
