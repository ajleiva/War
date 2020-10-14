import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * War class
 * This class allows the user to play war with the click of a button and it also determines the winner of the game.
 * @author Axel and Paul
 * @version January 28, 2019
 */
public class War {
	//Makes the frame and textfields globalin the war class.
	private JFrame frame;
	private JTextField txtDisplay1;
	private JTextField txtDisplay2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					War window = new War();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public War() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creates a new draw object.
		Draw d = new Draw();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtDisplay1 = new JTextField();
		txtDisplay1.setBounds(10, 114, 198, 71);
		frame.getContentPane().add(txtDisplay1);
		txtDisplay1.setColumns(10);

		JButton btnDraw = new JButton("Draw");
		btnDraw.setEnabled(false);
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//This updates the text boxes according to the card each player has.
				txtDisplay1.setText("The player draws " + Integer.toString(d.getFirstPCard()));
				txtDisplay2.setText("The computer draws " + Integer.toString(d.getFirstCCard()));

				//Calls the draw method in the draw class to play the game.
				d.draw();
				
				//If there is nothing in the domputer deck, the player wins.
				if (d.getFirstCCard() == 0) {
					txtDisplay1.setText("Player wins!");
					txtDisplay2.setText("Computer loses!");
					btnDraw.setEnabled(false);
				}
				//If there is nothing in the player deck, the computer wins.
				else if (d.getFirstPCard() == 0) {
					txtDisplay1.setText("Player loses!");
					txtDisplay2.setText("Computer wins!");
					btnDraw.setEnabled(false);
				}
				//If the computer deck is less than 3 and the face value is equal to the face value of the player card
				//Cannot play the war anymore so the player wins.
				else if ((d.getUpdatedCDeck().size() < 3) && (d.getFirstCCard() == d.getFirstPCard())) {
					txtDisplay1.setText("Player wins!");
					txtDisplay2.setText("Computer loses!");
					btnDraw.setEnabled(false);
				}
				//If the player deck is less than 3 and the face value is equal to the face value of the computer card
				//Cannot play the war anymore so the computer wins.
				else if ((d.getUpdatedPDeck().size() < 3) && (d.getFirstPCard() == d.getFirstCCard())) {
					txtDisplay1.setText("Player loses!");
					txtDisplay2.setText("Computer wins!");
					btnDraw.setEnabled(false);
				}
			}
		});
		btnDraw.setBounds(173, 66, 89, 23);
		frame.getContentPane().add(btnDraw);

		txtDisplay2 = new JTextField();
		txtDisplay2.setColumns(10);
		txtDisplay2.setBounds(226, 114, 198, 71);
		frame.getContentPane().add(txtDisplay2);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IF the start button is enabled, the start button gets disabled and the draw button becomes enabled.
				if (btnStart.isEnabled()) {
					btnDraw.setEnabled(true);
					btnStart.setEnabled(false);
				}
				//Tells the user the cards have been shuffled.
				txtDisplay1.setText("Cards have been shuffled.");
				txtDisplay2.setText("Cards have been shuffled.");
			}
		});
		btnStart.setBounds(173, 11, 89, 23);
		frame.getContentPane().add(btnStart);
	}
}
