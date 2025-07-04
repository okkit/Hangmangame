package okkit.gui.console;

/**
 * Represents all constants of the whole project. The interface extends the
 * interfaces for color constants
 * 
 * @author okkit
 */
public interface Constants extends ConsoleColors {
	// TODO Explain: Why are the constants in an interface and not in a class?

	/**
	 * Basic color
	 */
	public static final String COLOR_MAIN = BLACK;
	/**
	 * Color for labels
	 */
	public static final String COLOR_LABEL = BLUE;
	/**
	 * Color for errors and incorrect input by user.<br>
	 * Is used also for the lost-message
	 */
	public static final String COLOR_ERR = RED_BRIGHT;
	/**
	 * Color used for the won-message
	 */
	public static final String COLOR_SPECIAL = GREEN_BRIGHT;
	/**
	 * Message color
	 */
	public static final String COLOR_MSG = BLACK;
	/**
	 * Color for messages before request input by user
	 */
	public static final String COLOR_REQUEST = PURPLE_BOLD_BRIGHT;
	/**
	 * Color for input by user
	 */
	public static final String COLOR_INPUT = PURPLE;
	/**
	 * Game mode exit game
	 */
	public static final int MODE_EXIT = 0;
	/**
	 * Game mode two human players
	 */
	public static final int MODE_2xHUMAN = 1;
	/**
	 * Game mode human vs. bot
	 */
	public static final int MODE_BOTxHUMAN = 2;

	/**
	 * Alphabet used by guessing
	 */
	public static final Character[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'ä', 'ö', 'ü', 'ß' };

	/**
	 * Masked letter
	 */
	public static final String HIDDEN_LETTER = "-";
	/**
	 * Welcome message
	 */
	public static final String LABEL_WELCOME = "Welcome to hangman game";
	/**
	 * Headline for Alphabet
	 */
	public static final String LABEL_ALPHABET = "Alphabet:	";
	/**
	 * Headline for word input
	 */
	public static final String LABEL_YOUR_WORD = "Your word: ";
	/**
	 * Headline for letter input
	 */
	public static final String LABEL_YOUR_LETTER = "Your letter: ";
	/**
	 * Headline for game modes
	 */
	public static final String LABEL_MODE = "Avaiable modes:";
	/**
	 * Message to display before mode input by user
	 */
	public static final String LABEL_CHOOSE_MODE = "Chose mode:";
	/**
	 * Title to display for the mode MODE_EXIT
	 */
	public static final String LABEL_MODE_EXIT = "Exit game:		";
	/**
	 * Title to display for the mode MODE_2xHUMAN
	 */
	public static final String LABEL_MODE_2xHUMAN = "Human vs. human: 	";
	/**
	 * Title to display for the mode MODE_BOTxHUMAN
	 */
	public static final String LABEL_MODE_BOTxHUMAN = "Bot versus human: 		";
	/**
	 * Error message to display if input is a wrong mode
	 */
	public static final String LABEL_WRONG_MODE = "That was not a mode";
	/**
	 * Error message if the input letter is already selected
	 */
	public static final String MSG_OLREADY_SELECTED = "Olready selected";
	/**
	 * Message to display if the guesser has won
	 */
	public static final String MSG_WON = "Congratulations! You have won :-)";
	/**
	 * Message to display if the guesser has lost
	 */
	public static final String MSG_LOST = "Unfortunately you lost ;-(";
}
