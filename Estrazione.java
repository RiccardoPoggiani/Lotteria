/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

//@author Riccardo Poggiani 

public class Estrazione extends Thread {
    //Attributi
    private int numeroEstratto;
    private int[] numeriEstratti;
    private int n;
    private Giocatore[] vincitori;
    private boolean estrazioneCompletata;
    private Random Random;
    private int cicliVerifica;
    
    //Metodo costruttore
    public Estrazione() {
       numeroEstratto = 0;
       numeriEstratti = new int[5];
       n = 0;
       vincitori = new Giocatore[3];
       estrazioneCompletata = false;
       Random = new Random();
       cicliVerifica = 0;
    }

    //Metodo per visualizzare la matrice dei numeri estratti
    public synchronized void stampaNumeriEstratti() {
        System.out.print("I numeri estratti fino ad ora sono: ");
        for (int i = 0; i < numeriEstratti.length; i++) {
            if (numeriEstratti[i] != 0)
            System.out.print(numeriEstratti[i] + ", ");
        }
        System.out.println();
    }
    
    //Metodo per visualizzare i vincitori dell'estrazione
    public synchronized void stampaVincitoriEstrazione() {
       System.out.print("I giocatori vincitori dell'estrazione sono: ");
       for(Giocatore vincitore : vincitori){
           if (vincitore != null) {
                System.out.print("il giocatore " + vincitore.getIdGiocatore() + ", ");
            }
       }
       System.out.println();
    }

    // Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    public synchronized void verifica(Giocatore giocatore, int numeroScelto) {
        cicliVerifica++;
        if (numeroScelto == numeroEstratto) {
            System.out.println("Giocatore " + giocatore.getIdGiocatore() + " ha scelto il numero " + numeroScelto + ", ha vinto l'estrazione!");
            for (int i = 0; i < vincitori.length; i++) {
                if (vincitori[i] == null) {
                    vincitori[i] = giocatore;
                    break;
                }
            }
        } else {
            System.out.println("Giocatore " + giocatore.getIdGiocatore() + " non ha scelto il numero " + numeroEstratto + ", ha perso l'estrazione!");
        }

        if (cicliVerifica == 3){
            estrazioneCompletata = false;
            notifyAll();
            stampaNumeriEstratti(); // Sposta qui
            stampaVincitoriEstrazione(); // Sposta qui
        }
    }
    

    //Metodo per eseguire il thread
    public synchronized void run() {
        cicliVerifica = 0;
        System.out.println("Inizio dell'estrazione...");
        int numeroEstratto = Random.nextInt(5);
        System.out.println("Il numero estratto è " + numeroEstratto);
        numeriEstratti[n] = numeroEstratto;
        n++;
        System.out.println("Fine dell'estrazione...");
        estrazioneCompletata = true;
        notifyAll();
    }

    public synchronized boolean getEstrazioneCompletata() {
        return estrazioneCompletata;
    }

    public synchronized void setEstrazioneCompletata(boolean estrazioneCompletata) {
        this.estrazioneCompletata = estrazioneCompletata;
    }
}


