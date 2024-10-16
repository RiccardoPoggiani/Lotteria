package lotteria;

import java.util.Random;

//@author Riccardo Poggiani 

public class Estrazione extends Thread {
    //Attributi
    private int numeroEstratto;
    private int[][] numeriEstratti;
    private int N
    private int conta;
    private Giocatore[] vincitori;
    private Random Random;
    /*private boolean estrazioneCompletata;
    private int cicliVerifica;*/
    
    //Metodo costruttore
    public Estrazione(int N, int nGiocatori) {
        this.N = N;
        numeriEstratti = new int[N][N];
        conta = 0;
        vincitori = new Giocatore[nGiocatori];
        Random = new Random();
        /*estrazioneCompletata = false;
        cicliVerifica = 0;*/
    }

    //Metodo per visualizzare la matrice dei numeri estratti
    public synchronized void stampaNumeriEstratti() {
        System.out.print("I numeri estratti fino ad ora sono: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (numeriEstratti[i] != 0)
                    System.out.print(numeriEstratti[i][j] + ", ");
            }
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

        /*cicliVerifica++;
        if (cicliVerifica == 3){
            estrazioneCompletata = false;
            notifyAll();
            stampaNumeriEstratti(); // Sposta qui
            stampaVincitoriEstrazione(); // Sposta qui
        }*/
    }
    

    //Metodo per eseguire il thread
    public synchronized void run() {
        //cicliVerifica = 0;
        
        System.out.println("Inizio dell'estrazione...");
        int numeroEstratto = Random.nextInt(9);
        System.out.println("Il numero estratto è " + numeroEstratto);
        numeriEstratti[conta] = numeroEstratto;
        conta++;
        System.out.println("Fine dell'estrazione...");
        
        /*estrazioneCompletata = true;
        notifyAll();*/
    }

    /*public synchronized boolean getEstrazioneCompletata() {
        return estrazioneCompletata;
    }

    public synchronized void setEstrazioneCompletata(boolean estrazioneCompletata) {
        this.estrazioneCompletata = estrazioneCompletata;
    }*/
}


