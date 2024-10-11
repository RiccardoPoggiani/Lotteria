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
    public int numero;
    public int[] numeriEstratti;
    public Giocatore[] vincitori;
    
    //Metodo costruttore
    public Estrazione() {
       this.numero = new Random().nextInt(20);
       this.numeriEstratti = new int[20];
       this.vincitori = new Giocatore[3];
    }

    //Metodo per visualizzare la matrice dei numeri estratti
    public void stampaMatrice() {
       System.out.println("Numeri estratti: ");
       for(int i : numeriEstratti){
           System.out.print(numeriEstratti[i] + ", ");
       }
       System.out.println();
    }
    
    //Metodo per visualizzare i vincitori dell'estrazione
    public void stampaVincitori() {
       System.out.println("I vincitori dell'estrazione sono: ");
       for(Giocatore vincitore : vincitori){
           if (vincitore != null) {
                System.out.print("Il giocatore " + vincitore.nomeGiocatore + " ha vinto! ");
            }
       }
    }

    //Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    public void verifica(int numero, int idGiocatore) {
           if(numero == this.numero){
               System.out.println("Giocatore " + idGiocatore + " ha scelto il numero " + numero + ", ha vinto l'estrazione!");
               for (int i = 0; i < vincitori.length; i++) {
                if (vincitori[i] == null) {
                    vincitori[i] = 
                    break;
                }
            }
           }
           else{
               System.out.println("Giocatore " + idGiocatore + " non ha scelto il numero " + numero + ", ha perso l'estrazione!");
           }
    }

    //Metodo per eseguire il thread
    public void run() {
        // stampa iniziale
        // estrazione dei numeri
        // stampa matrice
        // stampa finale
    }
}


