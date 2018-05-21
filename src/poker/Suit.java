package poker;

public enum Suit {
    DIAMONDS(1, "D"),
    CLUBS(2, "C"),
    HEARTS(3, "H"),
    SPADES(4, "S");

    private final int suitValue;
    private final String suitChar;

//    Suit(final int suitValue){
//        this.suitValue = suitValue;
//    }

    Suit(final int suitValue, final String suitChar){
        this.suitValue = suitValue;
        this.suitChar = suitChar;
    }

    public int getSuitValue(){
        return this.suitValue;
    }

    public String getSuitChar(){
        return this.suitChar;
    }

    public static Suit get(int code) {
        for(Suit suit : values()) {
            if(suit.getSuitValue() == code) return suit;
        }
        return null;
    }
}
