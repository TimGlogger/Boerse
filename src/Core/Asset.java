package Core;

public abstract class Asset {
    
    private String Name;
    private long Wert;
    
     
    
    public Asset(String Name, long Wert){
        this.Name = Name;
        this.Wert = Wert;
    }
    
    //Methoden:
    
    //Auslesen der Werte eines Assets:
    
    public long getWert(){
      return this.Wert;
  }
    
    //SetWert: Für die automatisch berechung des Wertes eines Aktienpakets(ShareItem) 
    //und für das Verdienen und das Ausgeben von Geld.
    //Wird abstrakt überschreiben!
    
    public void setWert(long Wert){
        this.Wert = Wert;        
    }
    
    public String getName(){
        return this.Name;
    }
    
    @Override
    public String toString (){        
        return (this.Name + this.Wert);
    }
}
