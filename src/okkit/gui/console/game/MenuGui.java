package okkit.gui.console.game;

import okkit.gui.console.Constants;
import okkit.gui.console.IO;

/**
 * This class simulates a graphical user interface on console where the game
 * mode can be selected. <br>
 * The class features are to display the avaiable game modes and to receive the
 * players choice.
 * 
 * @author okkit
 */
public class MenuGui implements Constants {

	/**
	 * Displays avaiable modes and starts the player input.
	 * 
	 * @return choose() mode
	 */
	public int chooseMode() {
		showModes();
		return choose();
	}

	/**
	 * Displays the request message and receives the player input.
	 * 
	 * @return mode
	 */
	private int choose() {
		String str = IO.io().read(LABEL_CHOOSE_MODE);
		int mode;

		try {
			mode = Integer.valueOf(str.trim());
		} catch (NumberFormatException e) {
			IO.io().writeError(LABEL_WRONG_MODE);
			return choose();
		}

		return mode;
	}

	/**
	 * Displays the avaiable game modes.
	 */
	private void showModes() {
		IO.io().writeLabel(LABEL_MODE);
		IO.io().writeLabel(LABEL_MODE_2xHUMAN + MODE_2xHUMAN);
		IO.io().writeLabel(LABEL_MODE_BOTxHUMAN + +MODE_BOTxHUMAN);
		IO.io().writeLabel(LABEL_MODE_EXIT + MODE_EXIT);
	}

}
