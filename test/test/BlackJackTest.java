package test;

import BlackJack.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class BlackJackTest{
    
    @Test
    public void bet_with_3_6_Ace_3_Ace_FigureCard_adds_24(){
        List<Card> bet = new ArrayList<>();
        bet.add(new PipCard(3));
        bet.add(new PipCard(6));
        bet.add(new Ace());
        bet.add(new PipCard(3));
        bet.add(new Ace());
        bet.add(new FigureCard());
        
        BlackJack blackJack = new BlackJack(null);
        assertTrue(blackJack.getSumOfBet(bet) == 24);
    }
    
    
    @Test
    public void bet_with_FigureCard_and_Ace_is_BlackJack(){
        List<Card> bet = new ArrayList<>();
        bet.add(new FigureCard());
        bet.add(new Ace());
        BlackJack blackJack = new BlackJack(null);
        assertTrue(blackJack.isBlackJack(bet));
    }
    
    @Test
    public void return_player1_when_we_present_case_1(){
        List<Card> betPlayer1 = new ArrayList<>();
        betPlayer1.add(new FigureCard());
        betPlayer1.add(new Ace());
        Player player1 = new Player("player1",betPlayer1);
        
        List<Card> betPlayer2 = new ArrayList<>();
        betPlayer2.add(new PipCard(10));
        betPlayer2.add(new PipCard(5));
        betPlayer2.add(new PipCard(6));
        Player player2 = new Player("player2",betPlayer2);
        
        List<Card> betPlayer3 = new ArrayList<>();
        betPlayer3.add(new PipCard(3));
        betPlayer3.add(new PipCard(6));
        betPlayer3.add(new Ace());
        betPlayer3.add(new PipCard(3));
        betPlayer3.add(new Ace());
        betPlayer3.add(new FigureCard());
        Player player3 = new Player("player3",betPlayer3);
        
        List<Card> betCrupier = new ArrayList<>();
        betCrupier.add(new PipCard(9));
        betCrupier.add(new PipCard(7));
        Player crupier = new Player("crupier",betCrupier);
        
        List<Player> listBase = new ArrayList<>();
        listBase.add(player1);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new FigureCard());
        deck.add(new PipCard(2));
        
        BlackJack blackJack = new BlackJack(deck);
        
        List<Player> listTest = blackJack.getWinners(player1,player2,player3,crupier);
        assert(listTest.equals(listBase));
    }
    
    @Test
    public void return_player1_and_player3_when_we_present_case_2(){
        List<Card> betPlayer1 = new ArrayList<>();
        betPlayer1.add(new PipCard(10));
        betPlayer1.add(new FigureCard());
        Player player1 = new Player("player1",betPlayer1);
        
        List<Card> betPlayer2 = new ArrayList<>();
        betPlayer2.add(new PipCard(10));
        betPlayer2.add(new PipCard(2));
        betPlayer2.add(new PipCard(6));
        Player player2 = new Player("player2",betPlayer2);
        
        List<Card> betPlayer3 = new ArrayList<>();
        betPlayer3.add(new PipCard(8));
        betPlayer3.add(new PipCard(8));
        betPlayer3.add(new PipCard(5));
        Player player3 = new Player("player3",betPlayer3);
        
        List<Card> betCrupier = new ArrayList<>();
        betCrupier.add(new PipCard(5));
        betCrupier.add(new PipCard(10));
        Player crupier = new Player("crupier",betCrupier);
        
        List<Player> listBase = new ArrayList<>();
        listBase.add(player1);
        listBase.add(player3);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new FigureCard());
        deck.add(new PipCard(2));
        
        BlackJack blackJack = new BlackJack(deck);
        
        List<Player> listTest = blackJack.getWinners(player1,player2,player3,crupier);
        
        assertEquals(listTest,listBase);
    }
}
