import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Random;

public class Main 
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;
     
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // show everything to the user
      myCardTable.setVisible(true);

      
      // CREATE LABELS ----------------------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
        	 computerLabels[k] = new JLabel();
        	 humanLabels[k] = new JLabel();
         }
      
      GUICard.loadCardIcons();
      
      // ADD LABELS TO PANELS -----------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  computerLabels[k].setIcon(GUICard.getBackCardIcon());
          myCardTable.pnlComputerHand.add(computerLabels[k]);
          humanLabels[k].setIcon(GUICard.getIcon(generateRandomCard()));
      	  myCardTable.pnlHumanHand.add(humanLabels[k]);
      }
      
      

      
    
      
      // and two random cards in the play region (simulating a computer/hum ply)
//      code goes here ...

      // show everything to the user
      myCardTable.setVisible(true);
   }
   
   static Card generateRandomCard()
   {
	   Deck deck = new Deck();
	   deck.shuffle();
	   Card card = deck.dealCard();
	   return card; 
   }
}
