package okkit.gui.console.game;

import java.util.ArrayList;

import okkit.gamelogic.Game;
import okkit.gui.console.Constants;
import okkit.gui.console.IO;

/**
 * This class simulates the game graphical user interface on console. <br>
 * The "gui" is divided in individual areas: <br>
 * the main gui (this class), that starts and runs the game, <br>
 * the menu gui, where the game mode can be selected, <br>
 * the gui for the human player, who thinks of a word and <br>
 * the gui for the human player, who guesses the word.
 * 
 * The class corresponds with the game logic capsuled in the class
 * gamelogic.Game.<br>
 * 
 * All constants are implemented in the interface gui.console.Constans.
 * 
 * To use this class, create an instance of the class and then call the instance
 * method play(). (s. here in the main method).<br>
 * To create an instance, the standard constructor is sufficient. //TODO
 * Explain: Why doesn't the class contain the standard constructor? //TODO
 * Explain: When does a class have to contain the standard constructor?
 * 
 * @author okkit
 */
public class GameGui implements Constants {

	/**
	 * The part of gui for think of
	 */
	ThinkofGui thinkofGui;

	/**
	 * The menu representing part of the gui
	 */
	MenuGui menuGui = new MenuGui();

	/**
	 * The part of gui for guess
	 */
	GuessGui guessGui;

	/**
	 * Game logic. NOT gui
	 */
	Game game;
	
	
/**
 * creates an instance of this class
 */
	public GameGui() {
		super();
	}

	/**
	 * Starts the gui an starts the game.
	 * 
	 * @param args No one in this application
	 */
	public static void main(String[] args) {
		// TODO okkit: To explain [static vs. dynamic]
		GameGui gameGui = new GameGui();
		gameGui.showWelcome();
		gameGui.play();
	}

	/**
	 * Makes game preparations and starts the game loop. <br>
	 * 
	 * Keeps the status of the game in the variable guess. <br>
	 * Keeps the input letter in the variable guess. <br>
	 * Keeps the guessed word as letter array in the variable guessedWord;<br>
	 * 
	 * In depend on game status continues the guessing process:<br>
	 * Displays the alphabet of letters that can be selected. <br>
	 * Obtains the guessed letter using the guessGui. <br>
	 * Updates the guessed word based on input letter using the instance of class
	 * gamelogic.Game. <br>
	 * Displays the current guessed word.<br>
	 * Updates the game status using the instance of class gamelogic.Game. <br>
	 * 
	 * Displays the game result and calls itself.
	 */
	protected void play() {

		startup();
		int status = Game.STATUS_RUN;
		Character guess;
		ArrayList<Character> guessedWord ;

		while (status == Game.STATUS_RUN) {
			showAlphabeth();
			guess = guess();
			guessedWord = game.nextRound(guess);
			showWord(guessedWord);
			status = game.getGameStatus(guessedWord);
		}
		showResult(status);
		play();
	}

	/**
	 * Displays the welcome label.
	 */
	private void showWelcome() {
		IO.io().nextLine();
		IO.io().write(LABEL_WELCOME, COLOR_MAIN);
		IO.io().nextLine();
	}

	/**
	 * Displays the menu and receives the game mode from there.<br>
	 * In depend on mode initializes the thinkof and the guess gui. <br>
	 * Displays the word provided by the thinkof gui.
	 */
	private void startup() {
		int mode = menuGui.chooseMode();

		if (mode == MODE_2xHUMAN) {
			thinkofGui = new ThinkofGui();
			String word = thinkofGui.readWord();
			game = new Game(word);
			guessGui = new GuessGui();
		} else if (mode == MODE_BOTxHUMAN) {
			System.out.println("Not yet implemented s. TODO");
			// TODO Implement the mode human vs. bot. For this, first implement a class
			// Bot in the game logic is to be realized for this. The class Bot has to
			// implement the features of bot guessing and bot sinking.
			startup();
			return;
		} else {
			gameOver();
		}
		showWord(game.getHiddenWord());
	}

	/**
	 * Displays the the result...
	 * 
	 * @param status ...in depend of the game status
	 */
	private void showResult(int status) {
		if (status ==Game.STATUS_LOST)
			IO.io().writeError(COLOR_ERR);
		else if (status == Game.STATUS_WON)
			IO.io().writeMessage(MSG_WON);
	}

	/**
	 * Reads using the guessGui the letter entered by the guessing player. <br>
	 * If the letter has already been selected, displays a message and calls
	 * itself.
	 * 
	 * @return input letter
	 */
	private Character guess() {
		Character guess = guessGui.readGuess();
		if (game.wasSelected(guess)) {
			IO.io().writeMessage(MSG_OLREADY_SELECTED);
			return guess();
		}
		return guess;
	}

	/**
	 * Displays the already guessed word using the letters already selected by
	 * guessing player.
	 * 
	 * @param letters An array of the letters already selected by guessing player.
	 */
	private void showWord(ArrayList<Character> letters) {
		IO.io().write(LABEL_YOUR_WORD, COLOR_LABEL);
		for (Character let : letters) {

			// TODO Explain: How can you tell that this line was written by a programmer and
			// not by a software developer?
			IO.io().write(" " + (let == null ? HIDDEN_LETTER : let), COLOR_MAIN);
		}
		IO.io().nextLine(2);
	}

	/**
	 * Displays the alphabet letter by letter.
	 */
	private void showAlphabeth() {
		ArrayList<Character> selectedLetters = game.getSelectedLetters();
		IO.io().write(LABEL_ALPHABET, COLOR_LABEL);

		for (int i = 0; i < ALPHABET.length; i++) {

			if (selectedLetters.indexOf(ALPHABET[i]) < 0)
				showLetter(ALPHABET[i]);
			else
				showAsSelected(ALPHABET[i]);
		}
		IO.io().nextLine();
	}

	/**
	 * Displays a single letter that has already been selected by guessing player.
	 * 
	 * @param letter The letter to display
	 */
	private void showLetter(char letter) {
		IO.io().write(" " + letter, BLACK);
	}

	/**
	 * Displays a single letter that has not yet been selected by guessing player.
	 * 
	 * @param letter The letter to display
	 */
	private void showAsSelected(char letter) {
		IO.io().write(" " + letter, WHITE);
	}

	/**
	 * Closes the Scanner in the IO class and ends the program
	 */
	private void gameOver() {
		IO.io().release();
		System.exit(0);
	}

}
