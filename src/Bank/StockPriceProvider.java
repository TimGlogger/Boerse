package Bank;

//Der Provider ist die eig. Bank als Klasse:


import Core.*;
import java.util.Arrays;
import java.util.Timer;
import Exceptions.StockPriceProviderException;



public class StockPriceProvider implements StockPriceInfo{

    private Share[] bankAktien = null;
    private static final int TICK_PERIOD = 1000;
    private Timer ticker;
    
    
    public StockPriceProvider(){}

    //Neue Aktien anlegen
    @Override
    public void creatShare(String akName, long Wert) {
        Share neu = new Share("", 0);
        try {
            neu.setKurs(Wert);

            neu.setName(akName);
            if (bankAktien != null) {
                Share[] neuarray = new Share[bankAktien.length + 1];
                for (int x = 0; x < neuarray.length - 1; x++) {
                    neuarray[x] = bankAktien[x];

                }
                neuarray[neuarray.length - 1] = neu;
                bankAktien = neuarray;
            } else {
                Share[] neuarray = new Share[1];
                neuarray[0] = neu;
                bankAktien = neuarray;

            }
        } catch (Error m) {
            System.out.println("Fehler:" + m.toString());
        }
    }

    @Override
    public boolean sameShare(String vergleich1, Object vergleich2) {

        int r = 0;
        try {
            while (bankAktien[r] != null) {
                if (bankAktien[r].getName().equals(vergleich1)) {
                    break;
                }
                r++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte geben Sie eine Gültige Aktie an um diese Vergleichen zu können. Ihre Aktie ist nicht vorhanden! " + e.toString());
        }
        return vergleich1.equals(vergleich2);
    }

    @Override
    public String showShares() {
        return Arrays.toString(bankAktien);
    }

    
    //Eine Aktie aus dem Array suchen und wenn vorhanden ausgeben (Kauf von Aktien)
    //Wird im Interface nicht angezeigt!
    public Share searchShare(String lookafter){
    int r = 0;

        //Fehler bei nichtvorhandener Aktie abfangen
        try {
            while (bankAktien[r] != null) {
                if (bankAktien[r].getName().equals(lookafter)) {
                    break;
                }
                r++;
            }
            
              
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte geben Sie eine Gültige Aktie an. Ihre Aktie ist nicht vorhanden! " + e.toString());
        }
        return bankAktien[r];
    }
    
    //Einzele Aktie Updaten:
    
    protected void updateShareRate(Share share, long newPrice) {
        
    }

    //Alle Aktien Updaten: Schleife durch das Array(Wird nicht im Interface angezeigt)    
    protected void updateShareRates(String bank)throws StockPriceProviderException {
        int r = 0;
            while (bankAktien[r] != null) {
                if(bank.equals("Const")){}
                if(bank.equals("Random")){}
                else{throw new StockPriceProviderException("Keine Gültige Bank angegeben. Bitte geben Sie ein an.");}
                r++;
            }

            
    }

    //Starten des Updates aller Aktien der Spieler (UpdateMethdoe)
    @Override
    public void startUpdate(String bank) { 
       try{
        updateShareRates(bank);}
       catch(StockPriceProviderException r){
       System.out.println("Fehler beim Versuch die Aktien zu Updaten."+ r.toString());
       }
        //2.Update die Spieler.
    }

    //Hat ein gewisser Spieler diese Aktie?
    @Override
    public boolean isShareListed(String PlayerName) {
        boolean kk = true;
        return kk;
    }
    
    //Aktuellen Kurs einer Aktie auslesen
    @Override
    public long getCurrentShareRate(String ShareName) {
       int r = 0;
        try {
            while (bankAktien[r] != null) {
                if (bankAktien[r].getName().equals(ShareName)) {
                    break;
                }
                r++;
            }
            
              
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte geben Sie eine Gültige Aktie an. Ihre Aktie ist nicht vorhanden! " + e.toString());
        }
        return bankAktien[r].getKurs();
    }
    
    //Timer für die Änderung der Aktienwerte:
    public void clock(){
    }
    
    //Überschriebene Methode der einzelen Banken:
    public long changePrice(){return 0;}
    
}
    



