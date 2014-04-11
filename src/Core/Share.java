package Core;

import Exceptions.ShareException;

public class Share {

    private String Name;

    private long Wert; //Kurs!!

    //Initialisierung der Klasse beim Start:
    public Share(String Name, long Startwert) {
        this.Wert = Startwert;
        this.Name = Name;
    }

    //To-String
    @Override
    public String toString() {
        return (Name + " Kurs: " + Wert);
    }

    //Vergleichsmethode 
    
    public boolean equals2(Object a) throws ShareException {
        
        if (!(a instanceof Share)) {

            throw new ShareException("Das übergebene Objekt ist keine Aktie");

        } else {
            Share ver = (Share) a;

            if ( ver.Name.equals(this.Name) && ver.getKurs() == this.getKurs()) {

                System.out.println("Ihre verlgeichten Aktien sind gleich!");
                
                return true;
            } else {
                throw new ShareException("Die übergebene Aktien sind nicht gleich.");
            }
        }
    }

    //GETTER UND SETTER
    public long getKurs() {
        long aktWert = this.Wert;
        return aktWert;
    }

    public void setKurs(long neuWert) {
        if (neuWert < 0) {
            throw new Error("Sie versuchen den Wert einer Aktie auf 0 oder unter 0 zu setzen!");
        }

        this.Wert = neuWert;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
