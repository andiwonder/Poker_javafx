package poker.util;

import poker.Card;
import poker.Hand;
import poker.Hand.*;
import poker.Rank;

import java.util.ArrayList;

public class PokerRank {

    // Codes for the basic types of poker hand.
    // TODO switch to enum
    public static final int NOTHING = 0;
    public static final int PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int TRIPLE = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH =  8;
    public static final int ROYAL_FLUSH =  9;

    // cards passed to PokerRank
    private ArrayList<Card> cards = new ArrayList<Card>();

    // just to show that rank hasnt been computed
    private int rank = -1;

    // computed at the same time as rank
    private String description;

    // tracks value of triple if it exists
    private int tripleValue = 0;
    // location of triple
    private int tripleLocation = -1;

    // Possible to have two pairs, below keeps track of pair 1 and pair 2 if they exist
    // value of pair 1 (higher if two exist)
    int pairValue1 = 0;
    int pairLoc1 = -1;
    // value of pair 2
    int pairValue2 = 0;
    int pairLoc2 = -1;

    public PokerRank(ArrayList<Card> card){
        for(Card c: card){
            if (card != null) {
                add(c);
            }
        }
    }

    public void add(Card card){
        if (card == null ){
            throw new IllegalArgumentException("PokerRank: Cards can't be null");
        }
        cards.add(card);
        rank = -1;
    }

    public int getRank(){
        if (rank == -1){
            computeRank();
        }
        return rank;
    }

    public String getDescription() {
        if (rank == -1) {
            computeRank();
        }
        return description;
    }

    public int getHandType() {
        if (rank == -1) {
            computeRank();
            return rank;
        }
        return rank;
    }

    // TODO switch to enum
    public String getHandTypeAsString() {
        int type = getHandType();
        if (type == PAIR) {
            return "Pair";
        }
        if (type == TWO_PAIR) {
            return "Two pairs";
        }
        if (type == TRIPLE) {
            return "Triple";
        }
        if (type == STRAIGHT) {
            return "Straight";
        }
        if (type == FLUSH) {
            return "Flush";
        }
        if (type == FULL_HOUSE) {
            return "Full House";
        }
        if (type == FOUR_OF_A_KIND) {
            return "Four of a kind";
        }
        if (type == STRAIGHT_FLUSH) {
            return "Straight Flush";
        }
        if (type == ROYAL_FLUSH) {
            return "Royal Flush";
        }
        return "Nothing";
    }

    public ArrayList<Card> getCards() {
        if ( rank == -1)
            computeRank();
        return new ArrayList<Card>(cards);
    }

    public String toString() {
        return getDescription();
    }

    // -------------------------- private part ------------

    // TODO switch to enum
    private String valueName(Card c) {
        switch ( c.getValue() ) {
            case 2:   return "Two";
            case 3:   return "Three";
            case 4:   return "Four";
            case 5:   return "Five";
            case 6:   return "Six";
            case 7:   return "Seven";
            case 8:   return "Eight";
            case 9:   return "Nine";
            case 10:  return "Ten";
            case 11:  return "Jack";
            case 12:  return "Queen";
            case 13:  return "King";
            default: return "Ace";
        }
    }

    // TODO ?
    private String pluralValueName(Card c) {
        if (c.getValue() == 6)
            return "Sixes";
        else
            return valueName(c) + "s";
    }

    // TODO ?
    private String cardValueNames() {
        StringBuffer s = new StringBuffer(valueName(cards.get(0)));
        for (int i = 1; i < cards.size(); i++) {
            s.append(',');
            s.append(valueName(cards.get(i)));
        }
        return s.toString();
    }

    private void computeRank(){
        ArrayList<Card> newCards = new ArrayList<>();

        // sort the cards
        while (cards.size() > 0) {
            Card maxCard = cards.get(0);
            for (int i = 1; i < cards.size(); i++)
                if (cards.get(i).getValue() > maxCard.getValue() ||
                        cards.get(i).getValue() == maxCard.getValue() && cards.get(i).getSuit() > maxCard.getSuit())
                    maxCard = cards.get(i);
            cards.remove(maxCard);
            newCards.add(maxCard);
        }

        cards = newCards;
        System.out.println("Sorted the cards it is now: " + newCards);

        /**
         * Cards are now sorted by value.
         * add the values of the cards in bit positions 0 through 19.
         */


        try{
            boolean isFlush = hasFlush(newCards);
            boolean isStraight = hasStraight(newCards);

            // Royal Flush = flush + Straight + Ace
            // Straight Flush = flush + Straight
            // Flush
            if (isFlush) {
                if (isStraight) {
                    if (cards.get(0).getValue() == Rank.ACE.getRankValue()) {
                        rank = ROYAL_FLUSH;
                        // description = longDescription = "Royal Flush";
                    }
                    else {
                        rank = STRAIGHT_FLUSH;
                        // description = longDescription = valueName(cards.get(0)) + "-high Straight Flush";
                    }
                }
                else {
                    rank = FLUSH;
                    description = "Flush";
                    // longDescription = "Flush (" + cardValueNames() + ")";
                }
                return;
            }

            // Straight
            if (isStraight)  {
                rank = STRAIGHT;
                // description = longDescription = valueName(cards.get(0)) + "-high Straight";
                return;
            }

            boolean isFourOfAKind = hasFourOfAKind(cards);

            // Four of a kind
            if (isFourOfAKind){
                rank = FOUR_OF_A_KIND;
                description = "Four " + pluralValueName(cards.get(0));
                // longDescription = description + " (plus " + valueName(cards.get(4)) + ")";
                return;
            }

            checkTriple();
            checkPairs();
            if(highRank()){
                rank = NOTHING;
                description = "High Card (" + valueName(cards.get(0)) + ")";
//            longDescription = "High Card (" + cardValueNames() + ")";
                return;
            }

            checkPairs();
            if(pairValue1 != 0 && pairValue2 != 0){
                rank = TWO_PAIR;
                description = "Two Pairs, " + pluralValueName(cards.get(0)) + " and "
                        + pluralValueName(cards.get(2));
            }
            if(pairValue1 !=0 || pairValue2 != 0){
                rank = PAIR;
                rank = PAIR;
                description = "Pair of " + pluralValueName(cards.get(0));
            }
        } finally {

        }
    }


    private boolean hasFlush(ArrayList<Card> cards){
        return (cards.get(0).getSuit() == cards.get(1).getSuit()
                && cards.get(1).getSuit() == cards.get(2).getSuit()
                && cards.get(1).getSuit() == cards.get(3).getSuit()
                && cards.get(1).getSuit() == cards.get(4).getSuit());
    }

    /**
     * 5-4-3-2-A straight would be A-5-4-3-2
     */
    private boolean hasStraight(ArrayList<Card> cards){
        if (cards.get(0).getValue() == Rank.ACE.getRankValue()
                && cards.get(1).getValue() == 5
                && cards.get(2).getValue() == 4
                && cards.get(3).getValue() == 3
                && cards.get(4).getValue() == 2 ) {
            // Move the ace to the end, by removing it then adding it.
            cards.add(cards.remove(0));
            return true;
        }
        else {  // An ordinary straight.
            return (cards.get(0).getValue() == cards.get(1).getValue() + 1
                    && cards.get(1).getValue() == cards.get(2).getValue() + 1
                    && cards.get(2).getValue() == cards.get(3).getValue() + 1
                    && cards.get(3).getValue() == cards.get(4).getValue() + 1);
        }
    }


    /**
     * can be 1,2,3,4
     * or 2,3,4,5 -> in that case rearrange
     */
    private boolean hasFourOfAKind(ArrayList<Card> cards){
        if (cards.get(0).getValue() == cards.get(1).getValue()
                && cards.get(1).getValue() == cards.get(2).getValue()
                && cards.get(2).getValue() == cards.get(3).getValue()){
            return true;
        } else if (cards.get(1).getValue() == cards.get(2).getValue()
                && cards.get(2).getValue() == cards.get(3).getValue()
                && cards.get(3).getValue() == cards.get(4).getValue()){
            cards.add(cards.remove(0));
            return true;
        }
        return false;
    }

    private void checkTriple(){
        for (int i = 0; i <= cards.size() - 3; i++) {
            if (cards.get(i).getValue() == cards.get(i+1).getValue()
                    && cards.get(i+1).getValue() == cards.get(i+2).getValue()) {
                tripleLocation = i;
                tripleValue = cards.get(i).getValue();
                break;
            }
        }
    }

    private void checkPairs(){
        for (int i = 0; i <= cards.size() - 2; i++) {
            // Look for a pair at position i.  avoid cards part of triple
            if (cards.get(i).getValue() == cards.get(i+1).getValue() && cards.get(i).getValue() != tripleValue) {
                // pair at position i.
                pairValue1 = cards.get(i).getValue();
                pairLoc1 = i;
                for (int j = i+2; j <= cards.size() -2; j++) {
                    // Found a second pair.
                    if (cards.get(j).getValue() == cards.get(j+1).getValue() && cards.get(j).getValue() != tripleValue) {
                        pairValue2 = cards.get(j).getValue();
                        pairLoc2 = j;
                        break;
                    }
                }
                break;
            }
        }
    }

    // no triple or pairs, then its high rank
    private boolean highRank(){
        if (tripleValue == 0 && pairValue1 == 0) {
            // No triple or pair in the hand.  The hand is ranked primarily on its high card.
            return true;
        }
        return false;
    }









}