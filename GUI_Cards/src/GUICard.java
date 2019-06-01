


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
   
public class GUICard {

   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.
   
   static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static ImageIcon[] icon = new ImageIcon[NUM_CARD_IMAGES];
      
   static void loadCardIcons()
   {
	   int counter = 0;
	   for(int i = 0; i <= 13; i++)
	   {
		   for(int k = 0; k <=3; k++)
		   {
			   String filename = new String();
			   filename = turnIntIntoCardValue(i) + turnIntIntoCardSuit(k) +".gif";
			   System.out.println(filename);
			   ImageIcon newIcon = new ImageIcon();
			   icon[counter] = newIcon;
			   counter++;
			   newIcon = null;
		   }
	   }
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop.  For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
   }
   
   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
	   if ( k > 0 && k < 11)
	   {
		   return String.valueOf(k);
	   }
	   else if(k == 0)
	   {
		   return "A";
	   }
	   else if (k == 11)
	   {
		   return "J";
	   }
	   else if (k == 12)
	   {
		   return "Q";
	   }
	   else if (k == 13)
	   {
		   return "K";
	   }
	   // FAILS
	   else
	   {
		   return "F";
	   }
	   
      // an idea for a helper method (do it differently if you wish)
   }
   
   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
	   switch(j)
	   {
	   case 0:
		   return "C";
	   case 1:
		   return "D";
	   case 2:
		   return "H";
	   case 3:
		   return "S";
	   }
      // an idea for another helper method (do it differently if you wish)
	   //FAILED
	return "F";
   }
   
   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;
      
      // prepare the image icon array
      loadCardIcons();
      
      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
      frmMyWindow.setLayout(layout);
      
      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);
      
      ImageIcon meow = new ImageIcon("JH.gif");
      labels[0] = new JLabel(meow);
      
      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}