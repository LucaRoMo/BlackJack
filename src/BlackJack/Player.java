package BlackJack;

import java.util.List;

public class Player {
    private final String name;
    private List<Card> bet;

    public Player(String name, List<Card> bet) {
        this.name = name;
        this.bet = bet;
    }

    List<Card> getBet() {
        return bet;
    }
    public void addCardtoBet(Card card){
        bet.add(card);
    }
    @Override
    public String toString(){
        return name;
    }
}
