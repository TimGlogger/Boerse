package AccountManager;

import Exceptions.ShareException;

public interface AccountManager {
    
       //Neuen Spieler anlegen
    void newPlayer(String Name, long Money);
    
    //Aktien kaufen
    void saleShare(String x,String aktienName,long verkaufswert,int verkaufsanzahl);
    
    //Aktien verkaufen
    void buyShare(String x, String akName, int Anzahl);
    
    //Abfragen des Depots
    String getDepotData(String Name);
    
    //Abfragen eines Assets
    String getAssets(String Name);
    
    //Gesamtvermögen eines Spielers abfragen
    String getAllMoney(String Name);
  }