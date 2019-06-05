import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Random;

public class Main 
{
	
	
	
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JButton[] humanLabels = new JButton[NUM_CARDS_PER_HAND];  
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
    	 humanLabels[a] = new JButton();
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
      
	  Hand compHand = highCardGame.getHand(0);
	  Hand playerHand = highCardGame.getHand(1);
      
	  
      
      
	  
//      System.out.printf("Player : %s", playerHand.toString());
//      System.out.printf("Comp : %s", compHand.toString());
	  
      // ADD LABELS TO PANELS -----------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  computerLabels[k].setIcon(GUICard.getBackCardIcon());
          myCardTable.pnlComputerHand.add(computerLabels[k]);
          
          humanLabels[k].setIcon(GUICard.getIcon(playerHand.inspectCard(k)));
      	  myCardTable.pnlHumanHand.add(humanLabels[k]);
      	  System.out.printf("%d%n", k);
      }
      
      
      playedCardLabels[0].setIcon(GUICard.getIcon(compHand.inspectCard(0)));
	  playedCardLabels[1].setIcon(GUICard.getIcon(playerHand.inspectCard(0)));

	  myCardTable.setVisible(true);
   }
   
   public class AnonymousInnerClassEx extends JFrame {

	    public AnonymousInnerClassEx() {

	        initUI();
	    }

	    private void initUI() {
	    	
	    	
	    	//ADD ALL THE BUTTONS HERE
	    	
//	        JButton closeBtn = new JButton("Close");
//
//	        closeBtn.addActionListener(new ActionListener() {
//	            
//	            @Override
//	            public void actionPerformed(ActionEvent event) {
//	                System.exit(0);
//	            }
//	        });

	        

	        setTitle("Anonymous inner class");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
   }
}
