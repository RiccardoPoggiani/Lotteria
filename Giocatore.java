package lotteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//@author Riccardo Poggiani

public class Giocatore extends Thread{
    // attributi
    public int idGiocatore;
    public String nomeGiocatore;
    public Estrazione estrazione;
      
    //Metodo costruttore
    public Giocatore(int idGiocatore,String nomeGiocatore,Estrazione estrazione) {
       this.idGiocatore=idGiocatore;
       this.nomeGiocatore=nomeGiocatore;
       this.estrazione=estrazione;
    }

    //Metodo per eseguire il thread
    public void run() {
        
        System.out.println("id " + idGiocatore);
        
        // scela del numero da giocare
        int numeroScelto=19;
       
       //conto alla rovescia
       for(int i = 3; i > 0; i--){
           System.out.println(i);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore di sleep!");
            }
       }
       
       // verifica del risutlato
       estrazione.verifica(numeroScelto, idGiocatore);
       
       // stampa fine verifica
       System.out.println("Ho verificato il numero");
    }
}
