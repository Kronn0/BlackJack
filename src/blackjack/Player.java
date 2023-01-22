
package blackjack;

import java.util.List;


public class Player {
    private List<Card> hand;
    
    
    
    public Player(List<Card> hand){
        this.hand = hand;
    }
    
    public List<Card> getHand(){
        return this.hand;
    }
    
    public void addCard(Card card){
        hand.add(card);
    }
    
    public int HandValue(List<Card> playerHand){
        int value = 0;
        int numbersOfAces = 0;
        for(Card card : playerHand){
            if(card.isAce()) numbersOfAces++;
            value += card.getValue();
        }
        while(value > 21 && numbersOfAces > 0){
            value -= 10;
            numbersOfAces--;
        }
        return value;
    }
    
    public boolean IsBlackJack(List<Card> playerHand){
        return (HandValue(playerHand) == 21 && playerHand.size() == 2);
    }
    
    public boolean winAgainstPlayer(Player player){
        int rivalHand = player.HandValue(player.getHand());
        
        return(HandValue(this.hand) > rivalHand) && (HandValue(this.hand) <= 21)
                || IsBlackJack(this.hand) || 
                (HandValue(this.hand) == rivalHand) && (HandValue(this.hand) <= 21 && (this.hand.size() < player.getHand().size()));

    }
    
}
