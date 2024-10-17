package lotteria;

import java.util.Random;

//@author Riccardo Poggiani

public class Giocatore extends Thread{
    // attributi
    private int idGiocatore;
    private String nomeGiocatore;
    private Estrazione estrazione;
    private Random Random;
      
    //Metodo costruttore
    public Giocatore(int idGiocatore,String nomeGiocatore, Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.nomeGiocatore = nomeGiocatore;
        this.estrazione = estrazione;
        Random = new Random();
    }

    //Metodo per eseguire il thread
    public synchronized void run() {

        // scelta del numero da giocare
        int numeroScelto = Random.nextInt(5);
        System.out.println("Il numero scelto dal giocatore " + idGiocatore + " è " + numeroScelto);
       
       // verifica del risutlato
       estrazione.verifica(this, numeroScelto);
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }
    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

}