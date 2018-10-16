import java.util.ArrayList;

public class Blackjack{

    Deck deck;
    ArrayList<Card> userCards;

    public Blackjack(){
        deck = new Deck();
        deck.shuffle();
        userCards = new ArrayList<Card>();
    }

    public void startGame(){
        dealCard();
        dealCard();
    }

    public void dealCard(){
        Card newCard = deck.drawCard();
        userCards.add(newCard);
    }







}