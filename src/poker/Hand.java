package poker;

public enum Hand {
    NOTHING(0),
    PAIR(1),
    TWO_PAIR(2),
    TRIPLE(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7),
    STRAIGHT_FLUSH(8),
    ROYAL_FLUSH(9);

    private final int handValue;

    Hand(final int handValue){
        this.handValue = handValue;
    }

    public int getHandValue(){
        return this.handValue;
    }

//    public static Hand get(int code){
//        for(Hand hand : values()) {
//            if(hand.getHandValue() == code) return hand;
//        }
//        return null;
//    }
}
