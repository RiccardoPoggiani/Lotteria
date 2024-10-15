/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

//@author Riccardo Poggiani

public class Giocatore extends Thread{
    // attributi
    private int idGiocatore;
    private Estrazione estrazione;
    private Random Random;
      
    //Metodo costruttore
    public Giocatore(int idGiocatore,Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.estrazione = estrazione;
        Random = new Random();
    }

    //Metodo per eseguire il thread
    public synchronized void run() {
        
        while (estrazione.getEstrazioneCompletata() == false) {
            try {
                wait();  // Aspetta che l'estrazione sia completata
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // scelta del numero da giocare
        int numeroScelto = Random.nextInt(5);
        System.out.println("Il numero scelto dal giocatore " + idGiocatore + " è " + numeroScelto);
       
       // verifica del risutlato
       estrazione.verifica(this, numeroScelto);
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }

}
