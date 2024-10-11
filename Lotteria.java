package lotteria;

import java.util.logging.Level;
import java.util.logging.Logger;

//@author Riccardo Poggiani
public class Lotteria {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Inizio lotteria");
        
        // Istanza ed avvio del thread Estrazione
        Estrazione e = new Estrazione();
        e.start();
       
        // Istanza di alcuni thread Giocatore
        Giocatore g1 = new Giocatore(1,"tommaso",e);
        Giocatore g2 = new Giocatore(2,"pippo",e);
        Giocatore g3 = new Giocatore(3,"riccardo",e);
       
        // Avvio dei thread Giocatori
        g1.start();
        g2.start();
        g3.start();
        
        try {
            g1.join();
            g2.join();
            g3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nel join!");
        }
       
        // Comunicazione fine gioco
        System.out.println("Fine lotteria");
    }
}
   