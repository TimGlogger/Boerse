package Bank;

//Erhöht oder verringert die Preise der Aktien zufällig im Wertebereich:

public class StockPriceProviderRandom extends StockPriceProvider {
    
    //Zufallszahl generieren für Aktienwerte:
    private long random(double low, double high){
        double random1 = Math.random() * (high - low) + low;
        long random2 = (long) random1;
        return random2;
    }
    
    @Override
    public long changePrice(){
        
    //Begrenzungen der Zufallszahlen:
    double low = 0;
    double high = 100;
    
    return(random(low,high));
    }
    
    
}
