package Player;

import Exceptions.CashAccountException;
import Core.Asset;

public class CashAccount extends Asset{  
    
    public CashAccount(String Name, long Wert){
       super(Name, Wert);
       
            
    }
    
    //Einzahlen von Geld in den Geldbeutel mit aktuellem Wert als Rückgabewert 
    
    public void verkauft(long Wert, int Anzahl){
        
        this.setWert(this.getWert() + ( Wert * Anzahl));
        
    }
    
    //Abziehen von gekauften aktein und prüfung ob überhaupt möglich!
    
    public void einkaufen(long Wert, int Anzahl) throws CashAccountException{
        
        long zGeldbeutel = Anzahl * Wert;
        
        if((this.getWert() - zGeldbeutel) < 0){
            //Geldbeutel leer Fehlermeldung:
            throw new CashAccountException(" Konto unter 0");
        }
        
        else{
            setWert(this.getWert()- zGeldbeutel);
                       
        }
        
        
    }
    @Override
    public String toString (){
        
        return(this.getName() + this.getWert());
    }
    
}
