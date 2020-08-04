//Daniel Peterson 109091561

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
 
public class ConsoleGame 
{
	int startingplayer = 0;
    static ArrayList<ConsoleCard> player = new ArrayList<>();
	static ArrayList<ConsoleCard> comp1 = new ArrayList<>();
	static ArrayList<ConsoleCard> comp2 = new ArrayList<>();
	static ArrayList<ConsoleCard> comp3 = new ArrayList<>();
	static ArrayList<ConsoleCard> middle = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static ConsoleDeck deck = new ConsoleDeck();
    static int score1 = 0;
    static int score2 = 0;
    static int playersCard;
    public static int flag;

	public static void setFlag(int place)
    {
    	flag = place;
    }
    
    public static int getFlag()
    {
    	return flag;
    }
    
    public void setPlayer()
    {
    	//startingplayer = getPlayerPosition(middle.get(win), middle);
    }
    public int getPlayer()
    {
    	return startingplayer;
    }
    
    public static void deal(ConsoleDeck deck, ArrayList<ConsoleCard> p1, ArrayList<ConsoleCard> p2,  ArrayList<ConsoleCard> p3, ArrayList<ConsoleCard> p4) 
    {
        for (int x = 0; x < 13; x++) 
        {
            p1.add(deck.dealCard());
            p2.add(deck.dealCard());
            p3.add(deck.dealCard());
            p4.add(deck.dealCard());
        }
    }
    
    public static void displayCards(ArrayList<ConsoleCard> hand) 
    {
        for (ConsoleCard c : hand) 
        {
            System.out.print(c.toString());
        }
    }
    public static void displayCards1(ArrayList<ConsoleCard> hand) 
    {
    	int count = 0;
    	System.out.println("\n\nIGNORE THE FIRST CARD, IT IS A PLACEHOLDER\n");
        for (ConsoleCard c : hand) 
        {
            //while(count > 0 && count < 3){
            System.out.print(c.toString());
            //}
           // count++;
        }
    }


    public static int getPlayerCard() 
    {
        do 
        {
            System.out.print("\n The player's hand has " + player.size() + " cards."
                    + "\n Choose your next card by [index]: ");
            while (!input.hasNextInt()) 
            {
                System.out.print("Enter a valid number, [0-13]: ");
                playersCard = input.nextInt();
            }
            
            	return playersCard = input.nextInt();
        } 
        while (playersCard < player.size());
    
    }
    
    public static int getPlayerCard1() 
    {
       // do 
       // {
            //System.out.print("\n The player's hand has " + player.size() + " cards."
             //       + "\n Choose your next card by [index]: ");
          //  while (!input.hasNextInt()) 
          //  {
         //       System.out.print("Enter a valid number, [0-13]: ");
         //       playersCard = input.nextInt();
        //    }
            return playersCard = new Random().nextInt(3-0) + 0;
       // } 
       // while (playersCard < player.size());
    }
    
    public static int getPlayerCard2()
    {
    	do 
        {
            System.out.print("\n The player's hand has " + player.size() + " cards."
                    + "\n Choose your next card by [index]: ");
            while (!input.hasNextInt()) 
            {
                System.out.print("Enter a valid number, [0-13]: ");
                	playersCard = input.nextInt();
            }
            if(input.nextInt() == middle.get(1).getSuit()){
            return playersCard = input.nextInt();
            }
        } 
        while (playersCard < player.size());
    	return -1;
    }
    
    public static ConsoleCard aiSelect(ConsoleCard current, ArrayList<ConsoleCard> aiHand) 
    {
    	//System.out.print(current.suit + ", Kappa");
        Collections.sort(aiHand);
        ConsoleCard max = null;
        ArrayList<ConsoleCard> followSuit = new ArrayList<>();
       // if (!followSuit.isEmpty()) 
       // {
            for (ConsoleCard c : aiHand) 
            {
            //	System.out.print(c.suit + ", KappaKappa");
                if (c.suit == current.suit) 
                {
                    followSuit.add(c);
                    max = followSuit.get(followSuit.size() - 1);
                }
            }
            if(max == null)
            {
            	for(ConsoleCard c :aiHand)
            	{
            		followSuit.add(c);
            		max = followSuit.get(followSuit.size() - 1);
            	}
            	//followSuit.add();
            }
            Collections.sort(aiHand);
  //          max = followSuit.get(followSuit.size() - 1);
           // System.out.println(max + "is the max");
            return max;
       // } 
      //  else 
     //   {
     //       return aiHand.get(aiHand.size() - 1);
      //  }
    }
    
    public static ConsoleCard selectMax(ConsoleCard c1, ConsoleCard c2, ConsoleCard c3, ConsoleCard c4) 
    {
        // suit of card 1
        int firstSuit = c1.suit;
      //  System.out.println("First- " + (c1.compareTo(firstSuit, c2) && c1.compareTo(firstSuit, c3) && c1.compareTo(firstSuit, c4)));
      //  System.out.println("Second- " + (c2.compareTo(firstSuit, c1) && c2.compareTo(firstSuit, c3) && c2.compareTo(firstSuit, c4)));
       // System.out.println("Third- " + (c3.compareTo(firstSuit, c1) && c3.compareTo(firstSuit, c2) && c3.compareTo(firstSuit, c4)));
        if (c1.compareTo(firstSuit, c2) && c1.compareTo(firstSuit, c3) && c1.compareTo(firstSuit, c4)) 
        {
            return c1;
        } 
        
        else if (c2.compareTo(firstSuit, c1) )//&& c2.compareTo(firstSuit, c3) && c2.compareTo(firstSuit, c4)) 
        {
            return c2;
        } 
       
        else if (c3.compareTo(firstSuit, c1) )//&& c3.compareTo(firstSuit, c2) && c3.compareTo(firstSuit, c4)) 
        {
            return c3;
        } 
        else if (c4.compareTo(firstSuit, c1) )//&& c4.compareTo(firstSuit, c2) && c4.compareTo(firstSuit, c3))
        {
        	return c4;
        }
        else 
        {
            return c1;
        }
    }
    
    public static int getWinningCard(ArrayList<ConsoleCard> center) 
    {
    	ConsoleCard maxCard = selectMax(center.get(0), center.get(1), center.get(2), center.get(3));
        return center.indexOf(maxCard);
    }
    
    public static int getWinningCard1(ArrayList<ConsoleCard> center) 
    {
    	ConsoleCard maxCard = selectMax(center.get(1), center.get(2), center.get(3), center.get(4));
        return center.indexOf(maxCard);
    }
    
    public static int getWinningCard2(ArrayList<ConsoleCard> center) 
    {
    	ConsoleCard maxCard = selectMax(center.get(2), center.get(3), center.get(4), center.get(1));
        return center.indexOf(maxCard);
    }
    
    public static int getWinningCard3(ArrayList<ConsoleCard> center) 
    {
    	ConsoleCard maxCard = selectMax(center.get(3), center.get(4), center.get(1), center.get(2));
        return center.indexOf((maxCard));
    }
    
    public static int getPlayerPosition(ConsoleCard playerCard, ArrayList<ConsoleCard> center) 
    {
        int place = 0;
        for (int i = 0; i < center.size(); i++) 
        {
            if (playerCard == center.get(i)) 
            {
                place = i;
            }
        }
        //System.out.println("PLACE = " + place);
        return place;
    }
    
    public static int getPlayerPosition1(ConsoleCard playerCard, ArrayList<ConsoleCard> center) 
    {
        int place = 0;
        for (int i = 0; i < center.size(); i++) 
        {
            if (playerCard == center.get(i)) 
            {
                place = i;
            }
        }
        //System.out.println("PLACE = " + place);
        if(place == 0)
        {
        	return place + 1;
        }
        if(place == 1)
        {
        	return 1;
        }
        if(place == 2)
        {
        	return 2;
        }
        if(place == 3)
        {
        	return 3;
        }
        if(place == 4)
        {
        	return 0;
        }
        return place;
    }
    
    public static int getPlayerPosition2(ConsoleCard playerCard, ArrayList<ConsoleCard> center) 
    {
        int place = 0;
        for (int i = 0; i < center.size(); i++) 
        {
            if (playerCard == center.get(i)) 
            {
                place = i;
            }
        }
        //System.out.println("PLACE = " + place);
        if(place == 0)
        {
        	return place + 2;
        }
        if(place == 1)
        {
        	return 2;
        }
        if(place == 2)
        {
        	return 3;
        }
        if(place == 3)
        {
        	return 0;
        }
        if(place == 4)
        {
        	return 1;
        }
        return place;
    }
    
    
    public static int getPlayerPosition3(ConsoleCard playerCard, ArrayList<ConsoleCard> center) 
    {
        int place = 0;
        for (int i = 0; i < center.size(); i++) 
        {
            if (playerCard == center.get(i)) 
            {
                place = i;
            }
        }
       // System.out.println("PLACE = " + place);
        if(place == 3)
        {
        	return 1;
        }
        if(place == 4)
        {
        	return 2;
        }
        if(place == 1)
        {
        	return 3;
        }
        if(place == 2)
        {
        	return 0;
        }
        return place - 1;
    }
    public static void trackScore(ArrayList<ConsoleCard> p_1, ArrayList<ConsoleCard> p_2, ArrayList<ConsoleCard> p_3, ArrayList<ConsoleCard> p_4, ArrayList<ConsoleCard> center, int winner) 
    {
        switch (winner) 
        {
            case 0:
                score1++;
                break;
                
            case 1:
            	score2++;
                break;
                
            case 2:
            	score1++;
                break;
                
            case 3:
            	score2++;
                break;
        }
    }

    public static void play() 
    {
        System.out.println("(POSITION 0)PLAYER Hand:\n");
        int index = 0;
        for (ConsoleCard card : player) 
        {
            System.out.print("[" + index + "] " + card.toString());
            index++;
        }  
        System.out.println("\n\n(POSITION 1)COMPUTER 1 hand\n");
        displayCards(comp1);
        System.out.println("\n\n(POSITION 2)COMPUTER 2 hand\n");
        displayCards(comp2);
        System.out.println("\n\n(POSITION 3)COMPUTER 3 hand\n");
        displayCards(comp3);
        System.out.println("\n");
        playersCard = getPlayerCard();

        middle.add(player.get(playersCard));
        player.remove(playersCard);

        middle.add(aiSelect(middle.get(0), comp1));
        aiSelect(middle.get(0), comp1);
      //  comp1.remove(aiSelect(middle.get(0), comp1));
        comp1.remove(middle.get(1));
        
       middle.add(aiSelect(middle.get(0), comp2));
        aiSelect(middle.get(0), comp2);
    //    comp2.remove(aiSelect(middle.get(0), comp2));
        comp2.remove(middle.get(2));
        
       middle.add(aiSelect(middle.get(0), comp3));
        aiSelect(middle.get(0), comp3);
      //  comp3.remove(aiSelect(middle.get(0), comp3));
        comp3.remove(middle.get(3));

        System.out.println("Cards that were played: ");
        displayCards(middle);
        
        System.out.println("\nWinner: ");
        System.out.println(selectMax(middle.get(0), (middle.get(1)), (middle.get(2)), (middle.get(3))).toString());
        int win = getWinningCard(middle);
        System.out.println("\nWinning player at position " + getPlayerPosition(middle.get(win), middle) + "\n");
        setFlag(getPlayerPosition(middle.get(win), middle));
        middle.clear();
        trackScore(player, comp2, comp3, comp1, middle, win);
     //   System.out.println(getFlag() + "=flag");
    }

    
    
    public static void playnew1() 
    {
        System.out.println("(POSITION 0)PLAYER Hand:\n");
        int index = 0;
        for (ConsoleCard card : player) 
        {
            System.out.print("[" + index + "] " + card.toString());
            index++;
        }  
        System.out.println("\n\n(POSITION 1)COMPUTER 1 hand\n");
        displayCards(comp1);
        System.out.println("\n\n(POSITION 2)COMPUTER 2 hand\n");
        displayCards(comp2);
        System.out.println("\n\n(POSITION 3)COMPUTER 3 hand\n");
        displayCards(comp3);
        System.out.println("\n");
      //  System.out.println("HERE1");
        middle.add(player.get(getPlayerCard1()));
        middle.add(aiSelect(middle.get(0), comp1));
        aiSelect(middle.get(0), comp1);
      //  comp1.remove(aiSelect(middle.get(0), comp1));
        comp1.remove(middle.get(1));
        
       middle.add(aiSelect(middle.get(1), comp2));
        aiSelect(middle.get(1), comp2);
    //    comp2.remove(aiSelect(middle.get(0), comp2));
        comp2.remove(middle.get(2));
        
       middle.add(aiSelect(middle.get(1), comp3));
        aiSelect(middle.get(1), comp3);
      //  comp3.remove(aiSelect(middle.get(0), comp3));
        comp3.remove(middle.get(3));
        //System.out.println("HERE2");
        System.out.println("Cards that were played: ");
        displayCards1(middle);
        
        playersCard = getPlayerCard();
        middle.add(player.get(playersCard));
        player.remove(playersCard);
        
        
        System.out.println("Cards that were played: ");
        displayCards(middle);
        System.out.println("\nWinner: ");
        System.out.println(selectMax(middle.get(1), (middle.get(2)), (middle.get(3)), (middle.get(4))).toString());
        int win = getWinningCard1(middle);
        System.out.println("\nWinning player at position " + getPlayerPosition1(middle.get(win), middle) + "\n");
        setFlag(getPlayerPosition1(middle.get(win), middle));
        middle.clear();
        trackScore(player, comp2, comp3, comp1, middle, win);
     //   System.out.println(getFlag() + "=flag");
    }
    
    public static void playnew2() 
    {
        System.out.println("(POSITION 0)PLAYER Hand:\n");
        int index = 0;
        for (ConsoleCard card : player) 
        {
            System.out.print("[" + index + "] " + card.toString());
            index++;
        }  
        System.out.println("\n\n(POSITION 1)COMPUTER 1 hand\n");
        displayCards(comp1);
        System.out.println("\n\n(POSITION 2)COMPUTER 2 hand\n");
        displayCards(comp2);
        System.out.println("\n\n(POSITION 3)COMPUTER 3 hand\n");
        displayCards(comp3);
        System.out.println("\n");
      //  System.out.println("HERE1");
        middle.add(player.get(getPlayerCard1())); 
       middle.add(aiSelect(middle.get(0), comp2));
        aiSelect(middle.get(0), comp2);
    //    comp2.remove(aiSelect(middle.get(0), comp2));
        comp2.remove(middle.get(1));
        
       middle.add(aiSelect(middle.get(1), comp3));
        aiSelect(middle.get(1), comp3);
      //  comp3.remove(aiSelect(middle.get(0), comp3));
        comp3.remove(middle.get(2));
       // System.out.println("HERE2");
        System.out.println("Cards that were played: ");
        displayCards1(middle);
        
        playersCard = getPlayerCard();
        middle.add(player.get(playersCard));
        player.remove(playersCard);

        middle.add(aiSelect(middle.get(1), comp1));
        aiSelect(middle.get(1), comp1);
      //  comp1.remove(aiSelect(middle.get(0), comp1));
        comp1.remove(middle.get(4));
        
        
        System.out.println("Cards that were played: ");
        displayCards(middle);
        System.out.println("\nWinner: ");
        System.out.println(selectMax(middle.get(1), (middle.get(2)), (middle.get(3)), (middle.get(4))).toString());
        int win = getWinningCard2(middle);
        System.out.println("\nWinning player at position " + getPlayerPosition2(middle.get(win), middle) + "\n");
        setFlag(getPlayerPosition2(middle.get(win), middle));
        middle.clear();
        trackScore(player, comp2, comp3, comp1, middle, win);
     //   System.out.println(getFlag() + "=flag");
    }
    
    public static void playnew3() 
    {
        System.out.println("(POSITION 0)PLAYER Hand:\n");
        int index = 0;
        for (ConsoleCard card : player) 
        {
            System.out.print("[" + index + "] " + card.toString());
            index++;
        }  
        System.out.println("\n\n(POSITION 1)COMPUTER 1 hand\n");
        displayCards(comp1);
        System.out.println("\n\n(POSITION 2)COMPUTER 2 hand\n");
        displayCards(comp2);
        System.out.println("\n\n(POSITION 3)COMPUTER 3 hand\n");
        displayCards(comp3);
        System.out.println("\n");
        
     //  System.out.println("HERE1");
        middle.add(player.get(getPlayerCard1()));
       middle.add(aiSelect(middle.get(0), comp3));
        aiSelect(middle.get(0), comp3);
      //  comp3.remove(aiSelect(middle.get(0), comp3));
        comp3.remove(middle.get(1));
       // System.out.println("HERE2");
        System.out.println("Cards that were played: ");
        displayCards1(middle);
        
        playersCard = getPlayerCard();
        middle.add(player.get(playersCard));
        player.remove(playersCard);

        middle.add(aiSelect(middle.get(1), comp1));
        aiSelect(middle.get(1), comp1);
      //  comp1.remove(aiSelect(middle.get(0), comp1));
        comp1.remove(middle.get(3));
        
       middle.add(aiSelect(middle.get(1), comp2));
        aiSelect(middle.get(1), comp2);
    //    comp2.remove(aiSelect(middle.get(0), comp2));
        comp2.remove(middle.get(4));

        
        System.out.println("Cards that were played: ");
        displayCards(middle);
        System.out.println("\nWinner: ");
        System.out.println(selectMax(middle.get(1), (middle.get(2)), (middle.get(3)), (middle.get(4))).toString());
        int win = getWinningCard3(middle);
        System.out.println("\nWinning player at position " + getPlayerPosition3(middle.get(win), middle) + "\n");
        setFlag(getPlayerPosition3(middle.get(win), middle));
        middle.clear();
        trackScore(player, comp2, comp3, comp1, middle, win);
      //  System.out.println(getFlag() + "=flag");
    }
    
    
    
    public static void main(String[] args) 
    {
        System.out.println("Creating deck...\nDealing to players...");
        deal(deck, player, comp1, comp2, comp3);
        //while (getFlag() == 0){
        do
        {
        	if(flag == 1)
        	{
        		System.out.println("Flag isnt 0");
        		playnew1();
        	}
        	else if(flag == 2)
        	{
        		playnew2();
        	}
        	else if(flag == 3)
        	{
        		playnew3();
        	}
        else{
        	play();
        }
        }
        while (!player.isEmpty() || !comp1.isEmpty() || !comp2.isEmpty() || !comp3.isEmpty()); 
        
        System.out.println("FINAL SCORES: \nTEAM1: " + score1 + "\nTEAM2: " + score2);
        input.close();
        System.exit(0);

    }
}