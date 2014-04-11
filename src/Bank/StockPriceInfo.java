package Bank;

//Info ist das Interface zur einzelnen Bank

import Core.Share;


public interface StockPriceInfo {
    
    //Ale Aktien im Array anzeigen
    public String showShares();
    
    //Vergleich zwei Aktien 
    public boolean sameShare(String vergleich1, Object vergleich2);
    
    //Neue Aktie anlegen im Array unter Impl:
    void creatShare(String akName, long Kurs);
    
    //Hat ein gewisser Spieler diese Aktie?
    public boolean isShareListed(String PlayerName);
    
    //Aktuellen Kurs einer Aktie auslesen
    public long getCurrentShareRate(String ShareName);
   
    //Starten des Updates aller Aktien der Spieler (UpdateMethdoe)
    public void startUpdate();   
    
    //Aktie im Array Suchen
    public Share searchShare(String lookafter);
}
