package blackjack;

import blackjack.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public static List<Player> getWinners(Player player_1, Player player_2, Player player_3,Player crupier, List<Card> deck) {
        List<Player> winners = new ArrayList<>();
        Player[] players = {player_1, player_2, player_3};

        while (crupier.HandValue(crupier.getHand()) < 17) {
            crupier.addCard(deck.remove(0));
        }

        if (crupier.HandValue(crupier.getHand()) > 21) {
            for (Player player : players) {
                if (player.HandValue(player.getHand()) <= 21) {
                    winners.add(player);
                }
            }
            return winners;
        }

        if (crupier.IsBlackJack(crupier.getHand())) {
            return winners;
        }

        for (Player player : players) {
            if (player.winAgainstPlayer(crupier)) {
                winners.add(player);
            }
        }
        return winners;
    }

}
