package okkit.gamelogic;

import java.util.ArrayList;

/**
 * This class represents the game logic.
 * 
 * @author okkit
 */
public class Game {

	/**
	 * Game status if the guessing player has lost
	 */
	public static final int STATUS_LOST = -1;

	/**
	 * Game status if the guessing player has won
	 */
	public static final int STATUS_WON = 1;

	/**
	 * Game status if the game continues
	 */
	public static final int STATUS_RUN = 0;

	/**
	 * Maxim number of rounds; the same as the number of attempts.
	 */
	private final int ROUNDS = 3;

	/**
	 * Number of rounds; the same as number of attemts.
	 */
	private int count;

	/**
	 * The word to be guessed - an instance of the class Word.
	 */
	private Word word;

	/**
	 * The list of selected letters by guessing player
	 */
	ArrayList<Character> selectedLetters;

	/**
	 * Constructs an instance of this class.<br>
	 * Initializes the instance of class Word by parameter.<br>
	 * Initializes the round count.<br>
	 * Initializes the list of selected letters by guessing.<br>
	 * 
	 * @param string The actual word as String
	 */
	public Game(String string) {
		super();
		count = 0;
		this.word = new Word(string);
		selectedLetters = new ArrayList<Character>();
		// the next 2 lines are bug fixing:
		selectedLetters.add(string.trim().toLowerCase().charAt(0));
		selectedLetters.add(string.charAt(string.length() - 1));
	}

	/**
	 * Get a list of word letters.<br>
	 * Letters that have already been guessed are added to the list as such.<br>
	 * Not yet guessed letters as null object.
	 * 
	 * @return The list of letters
	 */
	public ArrayList<Character> getHiddenWord() {
		return word.adjust(selectedLetters);
	}

	/**
	 * Add the guessed letter to the list of guessed letters.<br>
	 * Increases the round count.<br>
	 * Adjusts the hidden word by selected letters.
	 * 
	 * @param letter List of selected letter.
	 * @return Word as list of letters inc. letters yet hidden.
	 */
	public ArrayList<Character> nextRound(Character letter) {
		// TODO Check if the letter already exists in the list before adding
		selectedLetters.add(letter);
		count++;
		return word.adjust(selectedLetters);
	}

	/**
	 * Checks if the letter exists in the list of already selected letters.
	 * 
	 * @param letter Letter to check
	 * @return true if exists, otherwise false
	 */
	public boolean wasSelected(Character letter) {
		return selectedLetters.indexOf(letter) != -1;
	}

	/**
	 * Get the game status depending on round count and guessing result.
	 * 
	 * @param guessedWord Guessing result adjustet by all already selected letters
	 * @return -1 if the number of rounds is greater than the maximum number of
	 *         rounds, 1 if the word to guess ist complete, otherwise 0.
	 * 
	 */
	public int getGameStatus(ArrayList<Character> guessedWord) {
	
		if (count == ROUNDS)
			return STATUS_LOST;
		else if (!guessedWord.contains(null))
			return STATUS_WON;
		return STATUS_RUN;
	}

	/**
	 * Get the list of letters selected by guessing player.
	 * 
	 * @return The List of selected letters.
	 */
	public ArrayList<Character> getSelectedLetters() {
		return selectedLetters;
	}

}
