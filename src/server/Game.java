package server;

import poker.Card;
import poker.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Game {

    public static void startRound(int players){
        Deck newDeck = Deck.newShuffledDeck();
        ArrayList<Card> player1Cards = new ArrayList<>();
        ArrayList<Card> player2Cards = new ArrayList<>();
        ArrayList<ArrayList<Card>> listOfPlayers = new ArrayList<>();
        ArrayList<Card> tableCards = new ArrayList<>();
        listOfPlayers.add(player1Cards);
        listOfPlayers.add(player2Cards);

        for(ArrayList<Card> player: listOfPlayers){
            player.add(newDeck.deal());
            player.add(newDeck.deal());
        }

        for(ArrayList<Card> player: listOfPlayers){
            System.out.println(player);
        }

        for(int i=0; i < 5; i++){
            tableCards.add(newDeck.deal());
        }

        newDeck.removeTwo();

        System.out.println(tableCards);
        System.out.println(newDeck.size());

//        List<int []> testlist = new LinkedList<>();
//        int combos = 5;
//        int [] possibles = new int [] {1,2,3,4,5,6,7};
//
//        combinations(combos, possibles, testlist);
//        for(int [] combo: testlist){
//            System.out.println(Arrays.toString(combo));
//        }
//
//        System.out.println(testlist.size());
    }
}
