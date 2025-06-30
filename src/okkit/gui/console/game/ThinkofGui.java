package okkit.gui.console.game;

import okkit.gui.console.Constants;
import okkit.gui.console.IO;

/**
 * This class simulates a graphical user interface on console for the human
 * player, who thinks of a word and <br>
 * The class offers the input of a word and reads it.
 * 
 * @author okkit
 */
public class ThinkofGui implements Constants {

	/**
	 * Reads using IO class a word input by player, who thinks of.
	 * 
	 * @return guessed word
	 */
	public String readWord() {
		String str = IO.io().read(LABEL_YOUR_WORD);
		return str;
	}
}
