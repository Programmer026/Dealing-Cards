/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runseweoproject1;

/**
 *
 * @author S533481
 * Name: Oluwayemisi Runsewe
 * Date: February 15th, 2019
 * Title: String Pattern Output
 */
import java.util.*;
public class RunseweOProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // To print out Original deck of cards
       System.out.println("Original Order of Deck: ");
       for (int x = 0; x < 52; x++) {
           printDeck(newDeck(), x);
           System.out.print("\n");
       }       
       // To print out the two shuffled deck of cards
       System.out.println();
       for (int y = 1; y < 3; y++) {
           System.out.println("Shuffle " + y);
           String[] newCards = new String[52];
           for (int i = 0; i < 52; i++) {
               newCards = newDeck();
           }
            for (int x = 0; x < 52; x++) {
                printCard(newCards, deal(newCards));
                System.out.print("\n");
            }
            System.out.println();
       }
       // To print out the hands drawn
      String[] newCards2 = new String[52];
      for (int a = 0; a < 1; a++) {
      newCards2 = newDeck();
      }
      for (int x = 1; x <= 5; x++) {
          System.out.print("\nHands " + x + ": ");
          for (int i = 0; i < 5; i++) {
              printCard(newCards2, deal(newCards2));
              if (i < 4) {
              System.out.print(", ");
              } else {
                  System.out.print(".");
              }
          }
      }
      System.out.println();
    }
    // To get the card type of a deck of card
    public static String[] newDeck() {
        // To iterate through the loop to get a deck of card of 52
        String[] deck = new String[52];
        for(int x = 0; x < 52; x++) {
            if (x <=9 || (x >= 40 && x <= 42)) {
                deck[x] = "Clubs";
            } else if ((x >= 10 && x <= 19) || (x >= 43 && x <= 45)) {
                deck[x] = "Diamonds";
            } else if ((x >= 20 && x <= 29) || (x >= 46 && x <= 48)) {
                deck[x] = "Hearts";
            } else if ((x >= 30 && x <= 39) || (x >= 49 && x <= 51)) {
                deck[x] = "Spades";
            }
        }
        return deck;
        }
    // To detemine the number or letter of the card 
    public static String draw(String[] a,int b) {
        // Switch statement to determine the preix of the card
        String cardName;
        switch (b) {
            case 0:
            case 10:
            case 20:
            case 30:
                cardName = "A of " + a[b];
                break;
            case 40:
            case 43:
            case 46:
            case 49:
                cardName = "J of " + a[b];
                break;
            case 41:
            case 44:
            case 47:
            case 50:
                cardName = "Q of " + a[b];
                break;
            case 42:
            case 45:
            case 48:
            case 51:
                cardName = "K of " + a[b];
                break;
            default:
                int numOfCard = (b % 10) + 1;
                cardName = numOfCard + " of " + a[b];
                break;
        }
        // Assigning each card to used after drawing so as to avoid drawing a card twice
        a[b] = "Used";
        return cardName;
    }
    // To call the draw method and out put to the screen
    public static void printCard(String[] a, int x) {
            //System.out.println(draw(newDeck(),x));
            System.out.print(draw(a,x));
    }
    // To call the printCard method
    public static void printDeck(String[] a, int x) {
            printCard(a, x);
    }
    // To generate a random number which can be used to draw a random card and avoid drawing a card 
    public static int deal(String[] a) {
        Random num = new Random();
        int index = num.nextInt(52);
        while ("Used".compareTo(a[index])== 0) {
            index = num.nextInt(52);
        }
        return index;
    }
}
