
package blackjack;

public enum Card {
    Ace,_2,_3,_4,_5,_6,_7,_8,_9,Jack,Queen,King;
    
    public boolean isAce(){
        return this == Ace;
    }
    
    public boolean isFigure(){
        return this == King || this == Queen || this == Jack;
    }
    
    public int getValue(){
        if(isAce()) return 11;
        if(isFigure()) return 10;
        return ordinal()+1;
    }
}
