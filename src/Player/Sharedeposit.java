package Player;

//Aktiendepot eines Spielers
//Mit vielen ShareItems als Array angelegt
import Exceptions.ShareDepositException;
import Core.Asset;
import Core.ShareItem;
import java.util.Arrays;

public class Sharedeposit extends Asset {

//Leeres Array zur Initialisiereung des Arrays:
    ShareItem[] Depot = null;
    long DepotWert;

    public Sharedeposit(String Name, long Wert) {
        super(Name, Wert);
    }

//Einpflegen der gekauften Aktien in das Depot(Array aus Aktien(ShareItem))
    public void buyAktie(ShareItem crossAktie) {
     //System.out.println(crossAktie);
        if (Depot == null) {
            ShareItem[] Depotzw = new ShareItem[1];  //neues Array
            Depotzw[0] = crossAktie;                  //in neues Array schreiben
            Depot = Depotzw;

        } else {
            ShareItem[] Depotzw = new ShareItem[Depot.length + 1];
            for (int w = 0; w < Depotzw.length - 1; w++) {
                Depotzw[w] = Depot[w];
            }

            Depotzw[Depotzw.length - 1] = crossAktie;
            Depot = Depotzw;

            //System.out.println(Arrays.toString(Depotzw) + Depotzw.length); 
        }

    }

// Verkauf von Aktien:
    public boolean saleAktie(String verName, int verAnzahl) throws ShareDepositException{
        //Prüfen ob Array leer ist?
        if (Depot == null) {
            //Fehlermeldung für ein Leeres Array, also keine Aktien vorhanden zum verkauf!
            throw new ShareDepositException(" Nein  Depot ist komplett leer"+ toString());
            
        } else {

            //Prüfen ob das Array diese Aktein und derren Verkaufszahl beinhaltent
            int habenAktien = 0; //Anzahl der vorhanden gesuchten Aktien.
            int[] orte = new int[Depot.length]; //Array für die Speicherzellen wo die gesuchten Aktien liegen
            int zeahler = 0;
            

            //Komplettes Array durchsuchen 
            for (int t = 0; t < Depot.length; t++) {
                if (Depot[t].getName().equals(verName)) {
                    habenAktien = habenAktien + Depot[t].getStueck();
                    orte[zeahler] = t;
                    zeahler++;
                } else {
                }
            }

            //Wenn wir genug der Verkaufsaktien gefunden haben:
            if (habenAktien >= verAnzahl) {
                int i = 0;
                //Ab hier gehts um die Aufösung der Verkaufszahl!             

                if (Depot[orte[i]].getStueck() == verAnzahl) {  //bei gleicher Aktiengröße eines ShareItems und abbruch
                    Depot[orte[i]] = null;
                    
                    System.out.println("Ihre Aktien wurden aus Ihrem Depot entfernt und an den Käufer weitergereicht.(1)");

                } else {

                    //Addieeren der Shareitems zum Verkauf
                    //Shareitemsvergleichen und löschen --> Siehe unten
                    int x = 0;
                    while (verAnzahl != 0) {
                        if (Depot[orte[x]].getStueck() <= verAnzahl) {

                            verAnzahl = verAnzahl - Depot[orte[x]].getStueck();
                            Depot[orte[x]] = null;
                            x++;
                        } else {
                            int aktStelleanzahl = Depot[orte[x]].getStueck();
                            int uebrigeaktien = aktStelleanzahl - verAnzahl;
                            Depot[orte[x]].setStueck(uebrigeaktien);
                            verAnzahl = 0;
                        }
                    }
                    System.out.println("Ihre Aktien wurden verkauft.(2)");
                }
                depotAufraum();
                return true;
                
            } else {
                throw new ShareDepositException("Nicht genug oder keine Aktien von " + verName + " vorhanden."); 
                
            }
        }
    }

    //Aufräumen von leeren Shareitems im Array Depot
    private void depotAufraum() {
        //Alle "null" nach unten schieben
        for (int t = 0; t < Depot.length; t++) {
            if (Depot[t] == null && t != (Depot.length - 1)) {
                Depot[t] = Depot[t + 1];
                Depot[t + 1] = null;
            }
            //"null" an letzter Stelle "löschen"
            while (Depot[Depot.length - 1] == null) {
                ShareItem[] newDepot = new ShareItem[Depot.length - 1];
                for (int z = 0; z < newDepot.length; z++) {
                    newDepot[z] = Depot[z];
                }
                Depot = newDepot;
            }

        }

    }

// ToString Methode:
    @Override
    public String toString() {

        return ("Ihr Wert des Depots: " + DepotWert() + " " + Arrays.toString(Depot));
    }

//Rückgabe des Wertes des Depots
    public long DepotWert() {
        long DepotWert = 0;
        int r = 0;
        if(Depot != null){
        while (r < Depot.length) { //oder for-Schleife
            
            DepotWert = DepotWert + (Depot[r].getWertPaket());
            r++;
        }}
//System.out.println(DepotWert);//Fehler ist hier in der berechnung
        
        return DepotWert;
   
    }
}