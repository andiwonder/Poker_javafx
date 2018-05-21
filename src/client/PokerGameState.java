package client;

import poker.Card;

import java.io.Serializable;

public class PokerGameState implements Serializable {

    //-------------------------------------------------------------
    // The eight following constants are the possible values of
    // status.  The status is the basic information that tells
    // a player what it should be doing at a given time.

    // The player must click "DEAL" to start the game.
    public final static int DEAL = 0;

    // The player must make the first bet in a betting round, or fold.
    public final static int BET_OR_FOLD = 1;
    // During first round of betting, player must respond
    // to opponent's bet by raising or matching the bet, or folding.
    public final static int RAISE_SEE_OR_FOLD_ROUND_1 = 2;

    // During second round of betting, player must respond
    // to opponent's bet by raising or matching the bet, or folding.
    public final static int RAISE_CALL_OR_FOLD_ROUND_2 = 3;

    // The player must select cards to discard, and click "DRAW".
    public final static int DRAW = 4;

    // Wait for opposing player to start the game.
    public final static int WAIT_FOR_DEAL = 5;
    // Wait for opposing player to BET (or fold).
    public final static int WAIT_FOR_BET = 6;
    // Wait for opposing player to discard cards.
    public final static int WAIT_FOR_DRAW = 7;

    //-------------------------------------------------------------


    // Game status; one of the constants defined in this class.
    public int status;

    // Player's hand; null before game starts.
    public final Card[] hand;

    // Amount of money that player has left.
    public int money;
    // Amount of money that the opposing player has left.
    public int opponentMoney;
    // Amount of money that has been bet in the current game.
    public int pot;

    // When status is RAISE_SEE_OR_FOLD_ROUND_1 or RAISE_CALL_OR_FOLD_ROUND_2,
    // this is the opponent's bet amount which must be matched.
    public int amountToSee;


    /**
     * Create a PokerGameState object with amountToCall equal to 0  and with specified values for
     * the other public variables in this class.
     */
    public PokerGameState(Card[] hand, int status, int money, int opponentMoney, int pot) {
        this(hand,status,money,opponentMoney,pot,0);
    }

    /**
     * Create a PokerGameState object with specified values for all public variables in this class.
     */
    public PokerGameState(Card[] hand, int status, int money, int opponentMoney, int pot, int amountToSee) {
        this.hand = hand;
        this.status = status;
        this.money = money;
        this.opponentMoney = opponentMoney;
        this.pot = pot;
        this.amountToSee = amountToSee;
    }

}