package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private List<Card> deck;

    public BlackJack(List<Card> deck){
        this.deck = deck;
    }
    
    public List<Card> getDeck(){
        return deck;
    }
    
    public List<Player> getWinners(Player player1,Player player2,Player player3,Player crupier){
        
        List<Player> listResult = new ArrayList<>();
        while(getSumOfBet(crupier.getBet()) < 17 && this.deck.size() > 0){
            crupier.addCardtoBet(this.deck.get(0));
            this.deck.remove(0);
        }
        if(!isBlackJack(crupier.getBet())){
            if(isWinner(player1,crupier)){
                listResult.add(player1);
            }
            if(isWinner(player2,crupier)){
                listResult.add(player2);
            }
            if(isWinner(player3,crupier)){
                listResult.add(player3);
            }
        }
        return listResult;
    }
    
    
    
    public boolean isBlackJack(List<Card> bet){
        return getSumOfBet(bet) == 21 && bet.size() == 2;
    }
    
    public boolean isWinner(Player player, Player crupier) {
        boolean result = false;
        if(isBlackJack(crupier.getBet())){
            result = false;
        }else{
            if(isBlackJack(player.getBet())){
                result = true;
            }else{
                int sumOfBetPlayer = getSumOfBet(player.getBet());
                int sumOfBetCrupier = getSumOfBet(crupier.getBet());
                if(sumOfBetCrupier > 21 && sumOfBetPlayer > 21){
                    result = false;
                }else if(sumOfBetCrupier <= 21 && sumOfBetPlayer > 21)
                    result = false;
                else if(sumOfBetPlayer <= 21 && sumOfBetCrupier > 21)
                    result = true;
                else
                    result = sumOfBetPlayer > sumOfBetCrupier;
                
            }
        }
        return result;
    }
    
    public int getSumOfBet(List<Card> bet) {
        int sumOfBet = 0;
        int numberOfAce = 0;
        
        for (Card card : bet) {
            sumOfBet += card.getValue();
            if(card instanceof Ace)
                numberOfAce++;
        }
        while(sumOfBet > 21 && numberOfAce > 0){
            Ace ace = new Ace();
            sumOfBet -= ace.getValue();
            sumOfBet += ace.getSecondValue();
            numberOfAce--;
        }
        
        return sumOfBet;
    }

    
}
