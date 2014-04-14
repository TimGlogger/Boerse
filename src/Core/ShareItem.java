package Core;

import Core.Share;
import Core.Asset;

public class ShareItem extends Asset {
    
    private int Stück;
    private Share aktie = new Share("",0);
    
    public ShareItem(int Anzahl, long Wert, String Name){
        
        super(Name,0); //Hier werden irgendwie die Attribute nicht richtig übergeben.
        
        this.Stück = Anzahl;  //WertPaket is Wert des Assets! Fehler!
        this.aktie.setKurs(Wert);  //Aktie mit Kurs versehen
        this.aktie.setName(Name);
        this.setWert(rechWert());
    }
    
    public void setStueck(int Anzahl){
        this.Stück = Anzahl;
    }
    
    public String getName(){
        return aktie.getName();
    }
    
    //Private Methode zu berechnung des Werts des Pakets
    private long rechWert(){
        
        return (this.Stück * aktie.getKurs());
    }
    
    //Wert des Pakets zurückgeben
    public long getWertPaket (){
        this.setWert(this.Stück * aktie.getKurs());  //Updatemethode
        
        return this.getWert();
    }
    
    public int getStueck (){
        return this.Stück;
    }
   
    public void setKursShare(long neuWert) {
        if (neuWert < 0) {
            throw new Error("Sie versuchen den Wert einer Aktie auf 0 oder unter 0 zu setzen!");
        }

        this.aktie.setKurs(neuWert); 
    }

    @Override
    public String toString() {
        return "Aktienpaket{" + "Anzahl: " + Stück + " WertdesPaket:" + this.getWertPaket() + " Aktie:" + aktie.toString() + '}';
    }
 
}
