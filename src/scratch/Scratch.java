package scratch;

import client.PokerGameState;
import poker.Card;
import poker.Deck;
import poker.Rank;
import poker.Suit;
import poker.util.Combination;
import server.Game;

import java.util.List;

public class Scratch {

    public static void main(String [] args){
//        Card test = new Card(Rank.ACE, Suit.HEARTS);
//        Card test2 = new Card(Rank.KING, Suit.HEARTS);
//        System.out.println(test.equals(test2));
//        System.out.println();
//
//        Deck deck = Deck.newShuffledDeck();
//        int i = 10;
//        while (i > 0){
//            System.out.println(deck.deal().toString());
//            i--;
//        }

//        PokerGameState();

//        Combination.getCombinations();


        Game.startRound(2);
    }

    public static void combinations(int n, int[] arr, List<int[]> list) {
        // Calculate the number of arrays we should create
        int numArrays = (int)Math.pow(arr.length, n);
        // Create each array
        for(int i = 0; i < numArrays; i++) {
            list.add(new int[n]);
        }
        // Fill up the arrays
        for(int j = 0; j < n; j++) {
            // This is the period with which this position changes, i.e.
            // a period of 5 means the value changes every 5th array
            int period = (int) Math.pow(arr.length, n - j - 1);
            for(int i = 0; i < numArrays; i++) {
                int[] current = list.get(i);
                // Get the correct item and set it
                int index = i / period % arr.length;
                current[j] = arr[index];
            }
        }
    }
}
