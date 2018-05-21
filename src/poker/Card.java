package poker;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Serializable, Comparable<Card> {
    private static final long serialVersionUID = 6039767702677907198L;

    private final Rank rank;
    private final Suit suit;

    private final static Map<String, Card> CARD_CACHE;

    // TODO do i really need this ?
    static {
        final Map<String, Card> cache = new HashMap<>();
        for( final Suit suit: Suit.values()){
            for( final Rank rank: Rank.values()){
                cache.put(cardKey(rank, suit), new Card(rank, suit));
            }
        }
        CARD_CACHE = Collections.unmodifiableMap(cache);
    }

    public Card(final Rank rank, final Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Card(int rankValue, int suitValue){
        this.rank = Rank.get(rankValue);
        this.suit = Suit.get(suitValue);
    }

    private static String cardKey(final Rank rank, final Suit suit){
        return rank + " of " + suit;
    }

    static Card getCard(final Rank rank, final Suit suit){
        final Card card = CARD_CACHE.get(cardKey(rank, suit));
        if (card != null ){
            return card;
        }
        throw new RuntimeException("Invalid card ! " + rank + " " + suit);
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getSuit(){
        return this.suit.getSuitValue();
    }

    public int getValue(){
        return this.rank.getRankValue();
    }

    @Override
    public String toString() {
        return getValue() + this.suit.getSuitChar();
    }

    @Override
    public int compareTo(Card other) {
        final int rankComparison = Integer.compare(this.rank.getRankValue(), other.rank.getRankValue());
        return rankComparison != 0 ? rankComparison : Integer.compare(this.suit.getSuitValue(), other.suit.getSuitValue());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        final Card card = (Card) o;
        return this.rank == card.rank && this.suit == card.suit;
    }

//    @Override
//    public int hashCode() {
//        int result = this.rank != null ? this.rank.hashCode() : 0;
//        result = 31 * result + (this.suit != null ? this.suit.hashCode() : 0);
//        return result;
//    }
}
