import java.util.Random;

public class Deck{

    Card[] cards;
    int topIndex;

    public Deck(){
        cards = new Card[52];
        topIndex = 0;
        newDeck();
    }

    public Card drawCard(){
        if(topIndex>=52 || cards[topIndex]==null)
            return null;
        Card topCard = cards[topIndex];
        topIndex++;
        return topCard;
    }

    public void shuffle(){
        for(int i = 0; i < 52; i++){
            if(cards[i]==null){
                for(int j = i; j < 52; j++){
                    if(cards[j]!=null){
                        cards[i] = cards[j];
                        cards[j] = null;
                    }
                }
            }
        }
        for(int j = 0; j < 52; j++){
            Random random = new Random();
            int swapIndex = random.nextInt(52);
            if(cards[swapIndex]!=null){
                Card temp = cards[j];
                cards[j] = cards[swapIndex];
                cards[swapIndex]  = temp;
            }
        }
        topIndex=0;
    }

    public void printDeck(){
        for(int i = 0; i < 52; i++){
            if(cards[i]!=null)
                System.out.println(cards[i].getSuit().toString()+" "+cards[i].value);
        }
    }

    public void newDeck(){
        int fillIndex=0;
        for(int i = 0; i < 4; i++){
            String currentSuit;
            if(i==0)
                currentSuit = "Hearts";
            else if(i==1)
                currentSuit = "Diamonds";
            else if(i==2)
                currentSuit = "Spades";
            else
                currentSuit = "Clubs";
            cards[fillIndex] = new Card(currentSuit, "Ace");
            fillIndex++;
            for(int j = 2; j <= 10; j++){
                cards[fillIndex] = new Card(currentSuit, Integer.toString(j));
                fillIndex++;
            }
            cards[fillIndex] = new Card(currentSuit, "Jack");
            fillIndex++;
            cards[fillIndex] = new Card(currentSuit, "Queen");
            fillIndex++;
            cards[fillIndex] = new Card(currentSuit, "King");
            fillIndex++;
        }
    }
}