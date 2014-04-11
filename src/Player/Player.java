package Player;

import Exceptions.CashAccountException;
import Exceptions.ShareDepositException;
import Core.Share;
import Core.ShareItem;

public  class Player {
    
    final String Name;
    private CashAccount Geldbeutel = new CashAccount("Geldbeutel",0);
    private Sharedeposit aktienDepot = new Sharedeposit("aktiendepot", 0);    
    
    public Player (String Name, long Betrag){
        
       this.Name = Name;
       Geldbeutel.setWert(Betrag);
       
    }
    
    //To-String 
    
    public String toString(){
        
        return (Name + " " + "Guthaben: " + Geldbeutel.getWert() + " "  + aktienDepot.toString());
    }
    
    public String depotToString(){
        return aktienDepot.toString();
    }
    
    
    //Neue Aktien kaufen
    //Wird später implentieren
    
    public void einkaufvonAktien(Share neueAktie, int Anzahl, String Name){
       ShareItem newShareItem = new ShareItem(0, 0, Name );
       newShareItem.setStueck(Anzahl);
       newShareItem.setKursShare(neueAktie.getKurs());
       
        try{
        Geldbeutel.einkaufen(neueAktie.getKurs(), Anzahl);
        aktienDepot.buyAktie(newShareItem);
        }
        catch(CashAccountException q){
        System.out.println("Ihr Geldbeutel hat nicht genug Guthaben!"+ q.toString());
        }
        
    }
    
    
    //Verkauf von Aktien: Depot verändern und abgeben und dann den Gelbeutel anpassen
    
    public void verkaufvonAktien(long verWert, int verAnzahl, String verName){
        try{
            aktienDepot.saleAktie(verName, verAnzahl);
            Geldbeutel.verkauft(verWert, verAnzahl);}
        catch(ShareDepositException w){
            System.out.println("Fehler im Depot" + w.toString());
        }
                
    }
    
    public long getCash(){
        return this.Geldbeutel.getWert();
    }
  
    public String getName(){
        return this.Name;
    }
    
    public long getDepotValue(){
        return aktienDepot.getWert();
    }
}
