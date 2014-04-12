package Exceptions;


public class StockPriceProviderException extends Exception{
    String Fehlermeldung;
    
    public StockPriceProviderException(String uebergabe){
        
        this.Fehlermeldung = uebergabe;
        
    }   
    
}
