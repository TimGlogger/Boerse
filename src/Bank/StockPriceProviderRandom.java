package Bank;

//Hab hier das Random umgebaut:

//Erhöht oder verringert die Preise der Aktien zufällig im Wertebereich:

import Core.Share;

public class StockPriceProviderRandom extends StockPriceProvider {
    
    public StockPriceProviderRandom(){}
    
    //Zufallszahl generieren für Aktienwerte:
    //Umgebaut nach Int!
    @Override
    public void changePrice(){
        
        for(int i = 0; i<this.bankAktien.length;i++){
            bankAktien[i].setKurs(randomNumber());
        }
    }
        
    public int randomNumber(){
        int high = 100;
        int low = 0;
        int random1 = (int)(Math.random() * (high - low) + low);
        return random1;
    }
}   

