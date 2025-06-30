/**
 * 
 */
package tests.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okkit.gamelogic.Game;

/**
 * Testing of Game class features 
 * 
 * @author okkit
 */
class TestGame {

	String WORD = "Esophagus";
	Character FIRST_LETTER = 'E';
	String LAST_LETTER = "s";
	Object[] HIDDENWORD = {'E', null, null, null, null, null, null,null, 's'};
	
	Game game;
	
	@Test
	public void testHiddenWord() {
		
		assertNotEquals(game.getHiddenWord(), null, "Hidden word is null!");
	}
	
	@Test
	public void testHiddenWordLength() {
		
		assertTrue(game.getHiddenWord().size() == WORD.length(), "The size of hidden word is wrong :" + game.getHiddenWord().size());
	}
	
	@Test
	public void testTheVisibleLetters() {
		
		assertArrayEquals(HIDDENWORD, game.getHiddenWord().toArray());
	}
	
	@Test
	public void testGameStatus() {
		assertArrayEquals(HIDDENWORD, game.getHiddenWord().toArray());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		game = new Game(WORD);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

}
