package AccountManager;

//Fehler noch bei Try auf Aktie vorhanden --> sollte in die Bank?
//Evtl. könnte die Prüfung in die Bank ausgelagert werden: Als Methode:

import AccountManager.AccountManager;
import Core.Share;
import Player.Player;
import Bank.StockPriceProvider;
import Bank.StockPriceInfo;

public class AccountManagerImpl implements AccountManager {

    private Player[] alleSpieler = null;

    public AccountManagerImpl() {
    }

    @Override
    public void newPlayer(String Name, long Money) {
        try {

            Player neu = new Player(Name, Money);

            if (alleSpieler != null) {
                for (int x = 0; x < alleSpieler.length; x++) {
                    if (alleSpieler[x].getName().equals(Name)) {
                        throw new Error("Bereits vorhanden.");
                    }
                }
                Player[] neuarray = new Player[alleSpieler.length + 1];
                for (int x = 0; x < neuarray.length - 1; x++) {
                    neuarray[x] = alleSpieler[x];

                }
                neuarray[neuarray.length - 1] = neu;
                alleSpieler = neuarray;
            } else {

                Player[] neuarray = new Player[1];
                neuarray[0] = neu;
                alleSpieler = neuarray;

            }
        //System.out.println(Arrays.toString(alleSpieler));//(Test ob alle Player im Array)

        } catch (Error e) {
            System.out.println("Sie wollten einen Spieler anlegen der bereits vorhanden ist." + e.toString());
        }
    }

    //Aktien verkaufen
    @Override
    public void saleShare(String x, String aktienName, long verkaufswert, int verkaufsanzahl) {

        searchSpieler(x).verkaufvonAktien(verkaufswert, verkaufsanzahl, aktienName);
    }

    //Aktien kaufen
    //Fehler ist noch die Fehlende Instanz statt der Statischen Klasse ;-)
    
    @Override
    public void buyShare(String x, String y, int t, StockPriceInfo SPI) {
        Share boughtShare = SPI.searchShare(y);
        searchSpieler(x).einkaufvonAktien(boughtShare,t,y);
        
    }

    //Abfragen des Depots
    @Override
    public String getDepotData(String x) {
        return searchSpieler(x).depotToString();
    }

    //Abfragen eines Assets
    @Override
    public String getAssets(String x) {
        return searchSpieler(x).toString();
    }

    //Gesamtvermögen eines Spielers abfragen
    @Override
    public String getAllMoney(String x) {
        long gesamt = 0;
        gesamt = gesamt + searchSpieler(x).getDepotValue();
        gesamt = gesamt + searchSpieler(x).getCash();
        String ausgabe = searchSpieler(x).getName() + "-Vermögen: " + gesamt;
        
        return ausgabe;
    }

    private Player searchSpieler(String gesSpieler) {
        for (int x = 0; x < alleSpieler.length; x++) {
            if (alleSpieler[x].getName().equals(gesSpieler)) {
                return alleSpieler[x];
            }

        }
        throw new Error("Der von Ihnen gesuchte Spieler ist nicht vorhanden.");

    }
}
