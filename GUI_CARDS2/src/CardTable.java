import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardTable extends JFrame{
	static int MAX_CARDS_PER_HAND = 56;
	static int MAX_PLAYERS = 2; // for now we only allow 2 person games
	private int numCardsPerHand;
	private int numPlayers;
	
	public JPanel pnlComputerHand;
	public JPanel pnlHumanHand;
	public JPanel pnlPlayArea;
	
	
	
	CardTable()
	{
		super( );
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
	}
	
	// provite an acessor, but no mutator other than constructor.
	CardTable(String title, int numCardsPerHand, int numPlayers)
	{
		Dimension size = getPreferredSize();
		size.height = 150;
		
		this.numPlayers = numPlayers;
		this.numCardsPerHand = numCardsPerHand;
		pnlComputerHand = new JPanel();
		pnlComputerHand.setLayout(new GridLayout(1,numCardsPerHand));
		pnlComputerHand.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlComputerHand.setPreferredSize(size);
		
		this.add(pnlComputerHand, BorderLayout.NORTH);
		pnlHumanHand = new JPanel();
		pnlHumanHand.setLayout(new GridLayout(1,5));
		pnlHumanHand.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(pnlHumanHand, BorderLayout.CENTER);
		pnlHumanHand.setPreferredSize(size);
		
		pnlPlayArea = new JPanel();
		pnlPlayArea.setLayout(new GridLayout(1,numCardsPerHand));
		pnlPlayArea.setBorder(BorderFactory.createLineBorder(Color.black));
		pnlPlayArea.setPreferredSize(size);
		
		this.add(pnlHumanHand,BorderLayout.SOUTH);
	}
	

}

