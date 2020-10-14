import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Draw class
 * This class draws a card and compares the values of each card.
 * @author Axel and Paul
 * @version January 22, 2019
 */
public class Draw {
	//Calls the card class.
	Card c = new Card();
	//Creates arrays to hold the card values.
	ArrayList<Integer> PDeck = new ArrayList<>();
	ArrayList<Integer> CDeck = new ArrayList<>();

	//Constructor
	public Draw() {
		// TODO Auto-generated constructor stub
		//Creates full deck, shuffles full deck, gets array from the card class and puts it into the new array.
		PDeck = c.getPDeck();
		CDeck = c.getCDeck();
		//Displays the full deck, player deck, and computer deck.
		System.out.println(PDeck);
		System.out.println(CDeck);
	}
	/**
	 * draw method
	 * This method draws a card from each decks.
	 */
	public void draw() {
		//If either player still has sufficient cards, then keep playing.
		if (RanOutOfCards() == false) {
			//If the playey card is greater than the computer card, then it will call the AddToPCards method.
			if (PDeck.get(0) > CDeck.get(0)) {
				AddToPCards();
			}
			//If the player card is less than the computer card, then it will call the AddToCCards method.
			else if (PDeck.get(0) < CDeck.get(0)) {
				AddToCCards();
			}
			//If the face values are equal to each other, the game will go into war.
			else if (PDeck.get(0) == CDeck.get(0)) {
				//If both decks have more than 3 cards, the game will continue with the war.
				if (PDeck.size() >= 3 && CDeck.size() >= 3) {
					war();
				}
			}
		}
	}
	/**
	 * AddToPCards method
	 * This method adds cards to the player deck if he wins.
	 */
	private void AddToPCards() {
		System.out.println("Player receives " + CDeck.get(0));
		PDeck.add(CDeck.get(0));
		CDeck.remove(0);
		PDeck.add(PDeck.get(0));
		PDeck.remove(0);
		System.out.println("PDeck array: " + PDeck);
		System.out.println("CDeck array: " + CDeck);
	}
	/**
	 * AddToCCards method
	 * This method adds cards to the computer deck if he wins.
	 */
	private void AddToCCards() {
		System.out.println("Computer receives " + PDeck.get(0));
		CDeck.add(PDeck.get(0));
		PDeck.remove(0);
		CDeck.add(CDeck.get(0));
		CDeck.remove(0);
		System.out.println("PDeck array: " + PDeck);
		System.out.println("CDeck array: " + CDeck);
	}
	/**
	 * war method
	 * This method performs the war part of the game, where the third card of the deck is compared to determine
	 * 		the winner of that turn.
	 */
	private void war() {
		System.out.println("WAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//If the third card of the player deck is greater than the third card of the computer deck, the player
		//		will receive all played cards.
		if (PDeck.get(2) > CDeck.get(2)) {
			System.out.println("Player receives " + CDeck.get(0) + " " + CDeck.get(1) + " " + CDeck.get(2));
			PDeck.add(CDeck.get(0));
			PDeck.add(CDeck.get(1));
			PDeck.add(CDeck.get(2));

			PDeck.add(PDeck.get(0));
			PDeck.add(PDeck.get(1));
			PDeck.add(PDeck.get(2));

			CDeck.remove(0);
			CDeck.remove(0);
			CDeck.remove(0);

			PDeck.remove(0);
			PDeck.remove(0);
			PDeck.remove(0);
			System.out.println("PDeck array: " + PDeck);
			System.out.println("CDeck array: " + CDeck);
		}
		//If the third card of the computer deck is greater than the third card of the player deck, the computer
		//		will receive all played cards.
		else if (PDeck.get(2) < CDeck.get(2)) {
			System.out.println("Computer receives " + PDeck.get(0) + " " + PDeck.get(1) + " " + PDeck.get(2));
			CDeck.add(PDeck.get(0));
			CDeck.add(PDeck.get(1));
			CDeck.add(PDeck.get(2));

			CDeck.add(CDeck.get(0));
			CDeck.add(CDeck.get(1));
			CDeck.add(CDeck.get(2));

			CDeck.remove(0);
			CDeck.remove(0);
			CDeck.remove(0);

			PDeck.remove(0);
			PDeck.remove(0);
			PDeck.remove(0);
			System.out.println("PDeck array: " + PDeck);
			System.out.println("CDeck array: " + CDeck);
		}
		else if (PDeck.get(2) == CDeck.get(2)) {
			//In this version of war, the cards will reshuffle if there is another war after a war.
			System.out.println("SHUFFLE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Collections.shuffle(PDeck, new Random());
			Collections.shuffle(CDeck, new Random());
		}
	}
	/**
	 * IsEnoughCards predicate method
	 * This method determines if either player has enough cards to continue to play.
	 * @return check
	 */
	private boolean RanOutOfCards() {
		boolean check = false;
		//If the player deck or computer deck is equal to 0, the game is over.
		if (PDeck.isEmpty()) {
			check = true;
		}
		else if(CDeck.isEmpty()) {
			check = true;
		}
		return check;
	}
	/**
	 * getUpdatedPDeck method
	 * This method returns the face value of the first card for the player deck.
	 * @return first element in PDeck array
	 */
	public int getFirstPCard() {
		if (!PDeck.isEmpty()) {
			return PDeck.get(0);
		}
		else
			return 0;
	}
	/**
	 * getUpdatedCDeck method
	 * This method returns the face value of the first card for the computer deck.
	 * @return first element in CDeck array
	 */
	public int getFirstCCard() {
		if (!CDeck.isEmpty()) {
			return CDeck.get(0);
		}
		else
			return 0;
	}
	/**
	 * getPDeck method
	 * This method returns the full updated player deck.
	 * @return PDeck
	 */
	public ArrayList<Integer> getUpdatedPDeck() {
		// TODO Auto-generated method stub
		return PDeck;
	}
	/**
	 * getCDeck method
	 * This methof returnd the full updated computer deck
	 * @return
	 */
	public ArrayList<Integer> getUpdatedCDeck() {
		// TODO Auto-generated method stub
		return CDeck;
	}
}