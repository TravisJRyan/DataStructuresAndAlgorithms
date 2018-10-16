/*
    Design an OOP structure for a standard deck of cards.

    For this implementation, I assumed no Jokers or additional cards beyond the standard 52.
    In practice, requirements gathering would be important to clarify this.
*/

public class Card{

    public enum Suit {
        Hearts, Diamonds, Spades, Clubs
    }

    String value;
    String suit;

    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){
        return suit;
    }

    public String getValue(){
        return value;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public void setValue(String value){
        this.value = value;
    }


}