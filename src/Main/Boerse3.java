package Main;

//Habe alles auskommentiert damit hier nicht überall Fehler entstehen und wir den 
//Compiler nutzen können

//Interfaces und Klassen importieren:

import AccountManager.AccountManagerImpl;
import AccountManager.AccountManager;
import Bank.StockPriceInfo;
import Bank.StockPriceProvider;

public class Boerse3 {
    
    public static void main(String[] args) {
        
        
        
        //Anlegen der Instanzen die genutzt werden:
          AccountManager AM = new AccountManagerImpl();
          StockPriceInfo SPI = new StockPriceProvider();
        
        //Aktien im Array anlegen und anzeigen:
        SPI.creatShare("BMW", 1);
        SPI.creatShare("SIEMENS", 2);
        SPI.creatShare("VW", 3);
        SPI.creatShare("PORSCHE", 4);
        //Aktie auf unter 0 setzen: Fehlertest:
        SPI.creatShare("MAN", -2);
        //Alle Aktien aus dem Array wiedergeben:
        System.out.println(SPI.showShares());
        
        //Neue Player anlegen im Array von AMIMPL
        AM.newPlayer("Alex", 1000);
        AM.newPlayer("Tim", 1000);
        //Gleichen Player erneut anlegen: Fehlertest:
        AM.newPlayer("Tim", 1000);
        
        //Verkauf von Aktien aus leeren Depot: Fehlertest
        AM.saleShare("Alex", "BMW", 10,10);

//        //Kaufen von Aktien:
//        //Übergabe könnte im IMPL auch direkt über die Aktie geschehen
//        AM.buyShare("Tim", "PORSCHE",100);
//        AM.buyShare("Alex", "VW",100);
//        //Nicht vorhandene Aktie kaufen: Fehlertest
//        AM.buyShare("Alex", "MAN",100);
//        //Nicht genug Geld im Geldbeutel zum kauf: Fehlertest
//        AM.buyShare("Tim", "PORSCHE", 10000);
//        
//        //Verkauf von Aktien
//        //Nicht vorhanden oder zu wenige Aktien im Array verkaufen: Fehlertest
//        AM.saleShare("Tim", "PROSCHE", 50, 150);
//        //Aktien verkaufen:
//        AM.saleShare("Tim", "PORSCHE", 9, 20);
        
       
        //Aktiendepot, also alle Aktien eines Spielers ausgeben
        System.out.println(AM.getDepotData("Tim"));
        System.out.println(AM.getDepotData("Alex"));
        
        
        //Gesamtes Vermögen ausgeben
        System.out.println(AM.getAllMoney("Alex"));
        System.out.println(AM.getAllMoney("Tim"));        
    }
}
