package Bank;

//Diese Bank setzt alles auf den Anfangszustand zurück:

public class StockPriceProviderConst extends StockPriceProvider  {
    
    
    public StockPriceProviderConst(){}
    
    //Überschreiben der Methode der Vererbung:
    @Override
    public void changePrice(){
        for(int i = 0; i<this.bankAktien.length;i++){
            bankAktien[i].setKurs(bankAktien[i].getStartPrice());
        }
    }
    
}
