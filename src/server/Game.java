package server;

import poker.Card;
import poker.Deck;
import poker.util.Combination;
import poker.util.PokerRank;

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
            System.out.println("------------Player dealt cards------------");
            System.out.println(player);
        }

        for(int i=0; i < 5; i++){
            tableCards.add(newDeck.deal());
        }

        ArrayList<Card> sevenCards = new ArrayList<>(player1Cards);
        sevenCards.addAll(tableCards);

        newDeck.removeTwo();

        System.out.println("-------Cards on table------------");
        System.out.println(tableCards);
        System.out.println("---------Size of deck------------");
        System.out.println(newDeck.size());

        ArrayList<ArrayList<Card>> allCardCombinations = new ArrayList<>();
        for(int [] combos: Combination.getCombinations()){
            ArrayList<Card> temp = new ArrayList<>();
            for(int i= 0; i < combos.length; i++){
                temp.add(sevenCards.get(combos[i]));
            }
            allCardCombinations.add(temp);
        }


//        System.out.println(allCardCombinations.size());
        for(ArrayList<Card> oneSet: allCardCombinations){
            PokerRank temp = new PokerRank(oneSet);
            System.out.println("-------combo-----");
            System.out.println(oneSet);
            System.out.println("-------Rank------");
            System.out.println(temp);
        }

//        PokerRank rank = new PokerRank(allCardCombinations.get(0));
//        System.out.println("-------------TESTING HAND---------");
//        System.out.println(allCardCombinations.get(0));
//        System.out.println("-------------RANK-----------------®");
//        System.out.println(rank);



    }
}
