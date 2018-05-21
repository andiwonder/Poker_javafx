package poker;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private final Stack<Card> deckOfCards;

    private Deck(final boolean shuffle){
        this.deckOfCards = makeDeck(shuffle);
    }

    private Stack<Card> makeDeck(boolean shuffle){
        final Stack<Card> deckOfCards = new Stack<>();

        for(final Suit suit: Suit.values()){
            for(final Rank rank: Rank.values()){
                deckOfCards.push(Card.getCard(rank, suit));
            }
        }

        if(shuffle){
            Collections.shuffle(deckOfCards);
        } else {
            Collections.sort(deckOfCards);
        }
        return deckOfCards;
    }

    /**
     * Do I need this ?
     * @param args
     */
    public static void main(String [] args){
        final Deck deck = Deck.newShuffledDeck();
        final int totalCards = 52;
//        IntStream.range(0, numCardsToDeal).forEach(n -> System.out.println(deck.deal()));
    }

    public static Deck newShuffledDeck() {
        return new Deck(true);
    }

    public static Deck newUnshuffledDeck(){
        return new Deck(false);
    }

    public int size(){
        return this.deckOfCards.size();
    }

    public boolean contains(final Card card){
        return this.deckOfCards.contains(card);
    }

    public Card deal(){
        return this.deckOfCards.pop();
    }

    public void removeTwo(){
        this.deckOfCards.pop();
        this.deckOfCards.pop();
    }
}
