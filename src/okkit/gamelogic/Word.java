package okkit.gamelogic;

import java.util.ArrayList;

/**
 * This class describes a word. The features of the class are<br>
 * to check if the word contains a letter and to compare for equality with
 * an other word.
 * 
 * @author okkit
 */
public class Word {

	/**
	 * The word as simple java String
	 */
	private String string;

	/**
	 * Creates an instance of the class for a word given as java.lang.String.
	 * 
	 * @param str Word as simple java String
	 */
	public Word(String str) {
		string = str;
	}

	/**
	 * Checks if the word contains the given letter (param).<br>
	 * 
	 * @param l The letter to be checked
	 * @return true if the word contains the letter, otherwise false.<br>
	 *         Dazu der Witz: Ein Programmierer stellt sich jeden Abend ein volles
	 *         und ein leeres Glas Wasser neben sein Bett. Warum? Weil: Das volle Glas
	 *         hat er, falls er in der Nacht aufwacht und Durst hat. Und das leere
	 *         Glas, falls er in der Nacht aufwacht und keinen Durst hat.
	 */
	public boolean hasLetter(char l) {
		return string.trim().toLowerCase().contains(String.valueOf(l));
	}

	/**
	 * Compares itself with an other string.<br>
	 * The both string are compared by its lower case and without blank.
	 * 
	 * @param str String to compare with
	 * @return true if the words are equals, otherwise false
	 */
	public boolean isEquals(String str) {
		return string.trim().toLowerCase().equals(str.trim().toLowerCase());
	}

	/**
	 * Adjusts the representation of the hidden word by given letters.<br>
	 * The initially hidden word is being adjusted to the list passed as
	 * parameter.<br>
	 * Note: The adjustment takes place based on the entire(!) list of selected
	 * letters and has to be done each time(!), when the list of selected letters
	 * has been updated.<br>
	 * Adjustment is independent(!) of whether a letter has already been found in
	 * the word.
	 * 
	 * @param letters List of the letters, which has to be adapted to hidden word.
	 * @return Adjusted hidden word as list of letters.
	 */
	public ArrayList<Character> adjust(ArrayList<Character> letters) {

		if (letters == null || letters.size() < 1) {
			return getInitialHiding();
		}
		
		char[] wordletters = string.toCharArray();
		ArrayList<Character> retList = getInitialHiding();
		int firstIndex = 0;
		int lastIndex = string.length() - 1;

		for (int i = firstIndex + 1; i < lastIndex; i++) {
			for (int j = 0; j < letters.size(); j++) {
				if (wordletters[i] == letters.get(j)) {
					retList.set(i, wordletters[i]);
				}
			}
		}

		return retList;
	}

	/**
	 * Constructs a hidden word:<br>
	 * The first and the last letters of the word remain visible.<br>
	 * Hides all other letters by null.
	 * 
	 * @return Hidden word as list of letters
	 */
	private ArrayList<Character> getInitialHiding() {

		ArrayList<Character> retList = hideComplet();
		int firstIndex = 0;
		int lastIndex = string.length() - 1;
		retList.set(firstIndex, string.charAt(firstIndex));
		retList.set(lastIndex, string.charAt(lastIndex));

		return retList;
	}

	/**
	 * Constructs a list of null elements with the same capacity as the word (field of the class).
	 * 
	 * @return List of null elements
	 */
	private ArrayList<Character> hideComplet() {

		ArrayList<Character> retList = new ArrayList<Character>(string.length());
		for (int i = 0; i < string.length(); i++) {
			retList.add(null);
		}

		return retList;
	}

}
