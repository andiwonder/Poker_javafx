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
}

