//Ausgabe des Spiels in Frame: Grafisch.
package Gui;

import Core.Share;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Arrays;

public class StockPriceViewer extends JFrame {

    private static final int TICK_PERIOD = 1000;
    private Timer ticker;
    private JLabel clockLabel;

    //Nur Grafik:
    public StockPriceViewer(Share[] Array) {
        clockLabel = new JLabel("Aktiendaten werden ermittelt....");
        add("Center", clockLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 500);
        setVisible(true);

    }
    //Starten des Timers: Und des Tickers:
    public void start(Share[] Array) {
        ticker = new Timer(true);
        ticker.scheduleAtFixedRate(new TickerTask(Array), 1000, TICK_PERIOD);

    }
    
    //Updatemethode zur aktualisierung des Fensters, sollte dann mit dem Timer immer wieder aufgerufen werden!
    public void update(Share []Array){
        ticker.scheduleAtFixedRate(new TickerTask(Array), 1000, TICK_PERIOD);
    }
    //TickerKlasse die den Inhalt des Fensters erstellt und ausgibt...
    
    private class TickerTask extends TimerTask {
        
        Share[] bankAktien = null;

        public TickerTask(Share[] Array) {

            this.bankAktien = Array;
        }

        public void run() {
            String output = createText();
            clockLabel.setText(output);
            clockLabel.repaint();
        }

        //Ausgabe des Textes im Fenster:
        private String createText() {
            String output = "<html><body><h1>Die Glogger & Seemüller</h1><h2> City Börse</h2> ";
            
            //Wenn das Array null ist, kann nichts Angezeigt werden ansonsten soll er das Array als "(To)String"
            //in Html anzeigen.
            
            if (bankAktien == null) {
            } else {
                output += "<p> "+ Arrays.toString(bankAktien)+ "</p>";
            }

            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            DateFormat dateFormatter = DateFormat.getDateTimeInstance();

            output += dateFormatter.format(date) + "</body></html>";

            return output;
        }
    }
}
