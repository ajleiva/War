import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Card class
 * This class creates the full decks for the game.
 * @author Axel and Paul
 * @version January 21, 2019
 */
public class Card {
	//These arrays represent the decks of the game.
	private ArrayList<Integer> FullDeck = new ArrayList<>();
	private ArrayList<Integer> PDeck = new ArrayList<>();
	private ArrayList<Integer> CDeck = new ArrayList<>();

	//Constructor
	public Card() {
		// TODO Auto-generated constructor stub
		CreateFullDeck();
		Shuffle();
	}
	/**
	 * CreateFullDeck method
	 * This method creates a deck of cards.
	 */
	private void CreateFullDeck() {
		//This for loop adds cards to the full deck in a two dimensional array.
		for (int y = 0; y < 4; y++) {
			for (int x = 2; x < 15; x ++) {
				//Add each card to the array.
				FullDeck.add(y, x);
			}
		}
	}
	/**
	 * Shuffle method
	 * This  method shuffles the full deck and it adds cards to the player and computer deck.
	 */
	private void Shuffle() {
		//This shuffles the full deck randomly.
		Collections.shuffle(FullDeck, new Random());

		//Adds first half of the shuffled full deck to the player deck.
		PDeck.addAll(FullDeck.subList(0, 26));
		//Adds second half of the shuffled full deck to the computer deck.
		CDeck.addAll(FullDeck.subList(26, FullDeck.size()));
	}
	/**
	 * This returns the values of the player deck.
	 * @return PDeck
	 */
	public ArrayList<Integer> getPDeck() {
		return PDeck;
	}
	/**
	 * This returns the values of the computer deck.
	 * @return CDeck
	 */
	public ArrayList<Integer> getCDeck() {
		return CDeck;
	}
}