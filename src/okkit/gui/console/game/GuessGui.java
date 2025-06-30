package okkit.gui.console.game;

import okkit.gui.console.Constants;
import okkit.gui.console.IO;

/**
 * This class simulates a graphical user interface on console for the human
 * player, who guesses a word  <br>
 * The class offers the input of a letter and reads it.
 * 
 * @author okkit
 */
public class GuessGui implements Constants {

	/**
	 * Reads using IO class a letter by guessing player input.
	 * 
	 * @return The input letter
	 */
	public Character readGuess() {
		String str = IO.io().read(LABEL_YOUR_LETTER);
		return str.charAt(0);
	}

}
