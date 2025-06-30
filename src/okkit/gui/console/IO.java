package okkit.gui.console;

import java.util.Scanner;

/**
 * This class handles all inputs and outputs while the game.<br>
 * This class can have only one single instance (singleton).<br>
 * The class holds this single instance of itself as the class variable (static)
 * instance.
 * 
 * @author okkit
 */
public class IO implements Constants {

	/**
	 * Instance of class Scanner. Has to be closed before the program ends.
	 */
	private Scanner scan = new Scanner(System.in);

	/**
	 * Instance of this class.
	 */
	private static IO instance = new IO();

	/**
	 * Get the instance of the class
	 * 
	 * @return Instance of itself
	 */
	public static IO io() {
		//TODO okkit: To explain [what is a singleton?]
		return instance;
	}

	/**
	 * Displays a label on console.
	 * 
	 * @param label Label to display
	 */
	public void writeLabel(String label) {
		nextLine();
		writeLine(label, COLOR_LABEL);
	}

	/**
	 * Displays a message on console.
	 * 
	 * @param msg Message to display
	 */
	public void writeMessage(String msg) {
		writeLine(msg, COLOR_MSG);
	}

	/**
	 * Displays an error message on console.
	 * 
	 * @param err Error to displays
	 */
	public void writeError(String err) {
		writeLine(err, COLOR_ERR);
	}

	/**
	 * Displays a single letter on console.
	 * 
	 * @param letter Letter to displays
	 */
	public void writeLetter(Character letter) {
		write(String.valueOf(letter), COLOR_MAIN);
	}

	/**
	 * Displays a string with in a specific color on console without line break.<br>
	 * After the display the color is reseted.
	 * 
	 * @param str   String to displays
	 * @param color Text color
	 */
	public void write(String str, String color) {
		//TODO okkit: To explain [why in write methods sysout used only once?]
		System.out.print(color + str + RESET);
	}

	/**
	 * Displays a string within a specific color on console and breaks the
	 * line.<br>
	 * After display the color is reseted.
	 * 
	 * @param str   String to displays
	 * @param color Text color
	 */
	public void writeLine(String str, String color) {
		write(str, color);
		nextLine();
	}

	/**
	 * Scans the player input on console.
	 * 
	 * @param info Label before input
	 * @return input Input as String
	 */
	public String read(String info) {
		nextLine();
		write(info, COLOR_REQUEST);
		nextLine();
		setColor(COLOR_INPUT);
		String str = scan.next();
		resetColor();
		return str;
	}

	/**
	 * Breaks line
	 * 
	 * @param n How often to break line
	 */
	public void nextLine(int n) {
		for (int i = 0; i < n; i++) {
			nextLine();
		}
	}

	/**
	 * Breaks the current line
	 */
	public void nextLine() {
		System.out.println();
	}

	/**
	 * Sets the current text color on console
	 * 
	 * @param color Breaks the current line
	 */
	private void setColor(String color) {
		System.out.print(color);
	}

	/**
	 * Resets the current text color on console
	 * 
	 * @param color Text color
	 */
	private void resetColor() {
		System.out.print(RESET);
	}

	/**
	 * Closes the Scanner instance
	 */
	public void release() {
		scan.close();
	}

}
