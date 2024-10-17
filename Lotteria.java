package lotteria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lotteria {
    public static void main(String[] args) {
        int n = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di righe e colonne della matrice di numeri da estrarre: ");
        int N = scanner.nextInt();
        BufferedReader br = new BufferedReader(){
            new InputStreamReader(System.in);
        };
        N = Integer.parseInt(br.readLine());
        
        
        Estrazione e = new Estrazione(n, 4);
        
        System.out.println("Inizio lotteria...");
        e.start();
        
        Giocatore g1 = new Giocatore(1, "a", e);
        Giocatore g2 = new Giocatore(2, "b", e);
        Giocatore g3 = new Giocatore(3, "c", e);
        Giocatore g4 = new Giocatore(4, "d", e);
      
        g1.start();
        try {
            g1.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2.start();
        try {
            g2.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g3.start();
        try {
            g3.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }

        g4.start();
        try {
            g4.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          //istanza ed avvio del thread Estrazione
        System.out.println("3° posto: " + e.getVincitore(3));
        System.out.println("3° posto: " + e.getVincitore(2));
        System.out.println("2° posto: " + e.getVincitore(1));
        System.out.println("1° posto: " + e.getVincitore(0));
           
         System.out.println("Fine della lotteria...");
    }
}