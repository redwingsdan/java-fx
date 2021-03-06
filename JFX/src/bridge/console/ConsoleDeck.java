//Daniel Peterson 109091561


import java.util.ArrayList;
import java.util.Collections;

public class ConsoleDeck 
{
    ArrayList<ConsoleCard> deck = new ArrayList<>();
    public ConsoleDeck() 
    {
        for (int i = 0; i <= 3; i++) 
        {
            for (int j = 2; j <= 14; j++) 
            {
                deck.add(new ConsoleCard(j, i));
            }
        }
        Collections.shuffle(deck);
    }

    public ConsoleCard dealCard() 
    {
    	ConsoleCard c = null;
        if (deck.size() > 0) 
        {
            c = deck.remove(deck.size() - 1);
        }
        return c;
    }
    
    public void addCard(ConsoleCard c) 
    {
        if (deck.size() <= 51) 
        {
            deck.add(c);
        }
    }
}
