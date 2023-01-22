
import blackjack.Card;
import blackjack.Player;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static blackjack.Game.getWinners;





public class BlackJack_Test {
    

    @Test
    public void should_give_the_value(){
    assertEquals(11,Card.Ace.getValue());
    assertEquals(10,Card.King.getValue());
    assertEquals(10,Card.Jack.getValue());
    assertEquals(10,Card.Queen.getValue());
    assertEquals(3,Card._3.getValue());
    assertEquals(5,Card._5.getValue());
    assertEquals(8,Card._8.getValue());
    }
    
    @Test
    public void should_tell_if_is_a_figure(){
        assertEquals(false, Card.Ace.isFigure());
        assertEquals(true, Card.King.isFigure());
        assertEquals(true, Card.Jack.isFigure());
        assertEquals(true, Card.Queen.isFigure());
        assertEquals(false, Card._3.isFigure());
        assertEquals(false, Card._5.isFigure());
        assertEquals(false, Card._8.isFigure());
    }
    
    @Test
    public void should_tell_if_is_an_ace(){
        assertEquals(true, Card.Ace.isAce());
        assertEquals(false, Card.King.isAce());
        assertEquals(false, Card.Jack.isAce());
        assertEquals(false, Card.Queen.isAce());
        assertEquals(false, Card._3.isAce());
        assertEquals(false, Card._5.isAce());
        assertEquals(false, Card._8.isAce());
    }
    
    @Test
    public void should_return_the_hand(){
         List<Card> hand = new ArrayList<>();
         hand.add(Card.Ace);
         hand.add(Card._3);
         hand.add(Card.Queen);
         Player player = new Player(hand);
         assertEquals(hand, player.getHand());
         
    }
    
    @Test
    public void should_add_a_card_into_the_hand(){
         List<Card> hand = new ArrayList<>();
         hand.add(Card.Ace);
         hand.add(Card._3);
         hand.add(Card.Queen);
         Player player = new Player(hand);
         player.addCard(Card._5);
         hand.add(Card._5);
         player.addCard(Card.King);
         hand.add(Card._5);     
         assertEquals(hand, player.getHand());
    }
    
    @Test
    public void should_return_the_hand_value(){
        List<Card> hand = new ArrayList<>();
        hand.add(Card.Ace);
        hand.add(Card._3);
        Player player = new Player(hand);
         assertEquals(14, player.HandValue(player.getHand()));
    }
    
    @Test
    public void should_return_the_hand_value_with_an_reducted_Ace(){
        List<Card> hand = new ArrayList<>();
         hand.add(Card.Ace);
         hand.add(Card._3);
         hand.add(Card.Queen);
         Player player = new Player(hand);
         assertEquals(14, player.HandValue(player.getHand()));   
    }
    @Test
    public void should_retun_the_hand_value_with_multiple_Aces(){
        List<Card> hand = new ArrayList<>();
         hand.add(Card.Ace);
         hand.add(Card._3);
         hand.add(Card.Queen);
         Player player = new Player(hand);
         player.addCard(Card.Ace);
         assertEquals(15, player.HandValue(player.getHand())); 
         player.addCard(Card.Ace);
          assertEquals(16, player.HandValue(player.getHand())); 
          player.addCard(Card.Ace);
           assertEquals(17, player.HandValue(player.getHand())); 
        }
    
    @Test
    public void should_return_if_is_a_BlackJack(){
      List<Card> hand = new ArrayList<>();
         hand.add(Card.Ace);
         Player player = new Player(hand);
         player.addCard(Card.Queen);
         assertEquals(true, player.IsBlackJack(player.getHand())); 
         player.addCard(Card.Ace);
         assertEquals(false, player.IsBlackJack(player.getHand())); 
    }
    
    @Test
    public void should_decide_who_wins_one_against_one_no_BlackJack(){
        List<Card> hand_one = new ArrayList<>();
        hand_one.add(Card.Jack);
        hand_one.add(Card._8);
        List<Card> hand_two = new ArrayList<>();  
        hand_two.add(Card.Ace);
        hand_two.add(Card._4);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        assertEquals(true, player_one.winAgainstPlayer(player_two));
        assertEquals(false, player_two.winAgainstPlayer(player_one)); 
    }
    
    @Test
    public void should_decide_who_wins_one_against_one_with_BlackJack(){
        List<Card> hand_one = new ArrayList<>();
        hand_one.add(Card.Ace);
        hand_one.add(Card.Queen);
        List<Card> hand_two = new ArrayList<>();  
        hand_two.add(Card.Ace);
        hand_two.add(Card._4);
        hand_two.add(Card._6);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        assertEquals(true, player_one.winAgainstPlayer(player_two));
        assertEquals(false, player_two.winAgainstPlayer(player_one)); 
    }
    
     @Test
    public void should_decide_who_wins_one_against_one_with_draw(){
        List<Card> hand_one = new ArrayList<>();
        hand_one.add(Card.Jack);
        hand_one.add(Card.Queen);
        List<Card> hand_two = new ArrayList<>();  
        hand_two.add(Card.King);
        hand_two.add(Card._4);
        hand_two.add(Card._6);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        assertEquals(true, player_one.winAgainstPlayer(player_two));
        assertEquals(false, player_two.winAgainstPlayer(player_one)); 
    }
    
    @Test
    public void should_decide_who_wins_the_game_with_3_players_crupier_lost(){
        List<Card> hand_one = new ArrayList<>();
        List<Card> hand_two = new ArrayList<>();
        List<Card> hand_three = new ArrayList<>();
        List<Card> hand_crupier = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        hand_one.add(Card.Ace);
        hand_one.add(Card.Jack);
        hand_two.add(Card._7);
        hand_two.add(Card._2);
        hand_three.add(Card.King);
        hand_three.add(Card._8);
        hand_crupier.add(Card._5);
        deck.add(Card.Ace);
        deck.add(Card.Queen);
        deck.add(Card._8);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        Player player_three = new Player(hand_three);
        Player crupier = new Player(hand_crupier);
        List<Player> test_winners = new ArrayList<>();
        test_winners.add(player_one);
        test_winners.add(player_two);
        test_winners.add(player_three);
        assertEquals(test_winners,getWinners(player_one,player_two,player_three,crupier,deck));
        
       
    }
    
     @Test
    public void should_decide_who_wins_the_game_with_3_players_crupier_win(){
        List<Card> hand_one = new ArrayList<>();
        List<Card> hand_two = new ArrayList<>();
        List<Card> hand_three = new ArrayList<>();
        List<Card> hand_crupier = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        hand_one.add(Card._2);
        hand_one.add(Card.Jack);
        hand_two.add(Card._7);
        hand_two.add(Card._2);
        hand_three.add(Card.King);
        hand_three.add(Card._8);
        hand_crupier.add(Card.Jack);
        deck.add(Card.Ace);
        deck.add(Card.Queen);
        deck.add(Card._8);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        Player player_three = new Player(hand_three);
        Player crupier = new Player(hand_crupier);
        List<Player> test_winners = new ArrayList<>();
        assertEquals(test_winners,getWinners(player_one,player_two,player_three,crupier,deck));
    }
     @Test
    public void should_decide_who_wins_the_game_with_3_players_player1_and_Player2_win(){
        List<Card> hand_one = new ArrayList<>();
        List<Card> hand_two = new ArrayList<>();
        List<Card> hand_three = new ArrayList<>();
        List<Card> hand_crupier = new ArrayList<>();
        List<Card> deck = new ArrayList<>();
        hand_one.add(Card._2);
        hand_one.add(Card.Jack);
        hand_one.add(Card._7);
        hand_two.add(Card._8);
        hand_two.add(Card.Ace);
        hand_three.add(Card.King);
        hand_three.add(Card._5);
        hand_crupier.add(Card._5);
        deck.add(Card._2);
        deck.add(Card.King);
        deck.add(Card._6);
        Player player_one = new Player(hand_one);
        Player player_two = new Player(hand_two);
        Player player_three = new Player(hand_three);
        Player crupier = new Player(hand_crupier);
        List<Player> test_winners = new ArrayList<>();
        test_winners.add(player_one);
        test_winners.add(player_two);
        assertEquals(true, player_two.winAgainstPlayer(crupier));
        assertEquals(test_winners,getWinners(player_one,player_two,player_three,crupier,deck));
    }
    
}
    

