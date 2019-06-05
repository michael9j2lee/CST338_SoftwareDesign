import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main
{
	
	
	
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JButton[] humanButtons = new JButton[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {
	 //Instatiate highCardGame
	 int numPacksPerDeck = 1;
     int numJokersPerPack = 2;
     int numUnusedCardsPerPack = 0;
     Card[] unusedCardsPerPack = null;
     
     CardGameFramework highCardGame = new CardGameFramework( 
             numPacksPerDeck, numJokersPerPack,  
             numUnusedCardsPerPack, unusedCardsPerPack, 
             NUM_PLAYERS, NUM_CARDS_PER_HAND);
     
	  // start new game
	  highCardGame.newGame();
	  highCardGame.deal();
	  Hand compHand = highCardGame.getHand(0);
	  Hand playerHand = highCardGame.getHand(1);
	  
	  
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
      //Iterate through number of cards
      for (int a = 0; a < NUM_CARDS_PER_HAND; a++)
      {
    	 computerLabels[a] = new JLabel();
    	 humanButtons[a] = new JButton();
    	 humanButtons[a].addActionListener(new Action(a,compHand, playerHand));
      }
      //Iterate through number of players
      for (int b = 0; b < NUM_PLAYERS ; b++)
      {
    	  playedCardLabels[b] = new JLabel();
    	  playedCardLabels[b].setHorizontalAlignment(JLabel.CENTER);
    	  playLabelText[b] = new JLabel();
    	  playLabelText[b].setHorizontalAlignment(JLabel.CENTER);
      }
      
      myCardTable.pnlPlayArea.add(playedCardLabels[0]); 
	  myCardTable.pnlPlayArea.add(playedCardLabels[1]);  
	  myCardTable.pnlPlayArea.add(playLabelText[0]);
	  myCardTable.pnlPlayArea.add(playLabelText[1]);
      playLabelText[0].setText("Computer");
	  playLabelText[1].setText("You");
      
      
	  GUICard.loadCardIcons();
      

      
	  
      
      
	  
//      System.out.printf("Player : %s", playerHand.toString());
//      System.out.printf("Comp : %s", compHand.toString());
	  
      // ADD LABELS TO PANELS -----------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  computerLabels[k].setIcon(GUICard.getBackCardIcon());
          myCardTable.pnlComputerHand.add(computerLabels[k]);
          
          humanButtons[k].setIcon(GUICard.getIcon(playerHand.inspectCard(k)));
      	  myCardTable.pnlHumanHand.add(humanButtons[k]);
      	  System.out.printf("%d%n", k);
      }
      
      


	  myCardTable.setVisible(true);
   }


   static class Action implements ActionListener
   {
	   private int cardNumber;
	   private Hand compHand;
	   private Hand playerHand;
	   
	   public Action(int cardNumber, Hand compHand, Hand playerHand)
	   {
		   this.cardNumber = cardNumber;
		   this.compHand = compHand;
		   this.playerHand = playerHand;
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   {
		   playedCardLabels[0].setIcon(GUICard.getIcon(compHand.inspectCard(cardNumber)));
		   playedCardLabels[1].setIcon(GUICard.getIcon(playerHand.inspectCard(cardNumber)));
	   }
   }
}

