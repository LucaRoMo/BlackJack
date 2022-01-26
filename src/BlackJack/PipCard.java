package BlackJack;

public class PipCard extends Card{
    private final int value;
    
    public PipCard(int value){
        this.value = value;
    }
    
    @Override
    public int getValue() {
        return value;
    }
    
}
