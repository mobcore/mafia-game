package GameEngine;

/**
 * A class to store all the game messages the game need to display so instead of
 * having to search everywhere for what the game needs to display, it uses this
 * as a median to maintain easy organized strings/messages to display to user.
 * 
 * Also makes changing string messages easier.
 * 
 * @author pacified
 *
 */
public class GameMessage {

	private static String gameMessage;

	/**
	 * A message displayed when character has no targets and no action is
	 * performed
	 * 
	 * @return String
	 */
	public static String noAction() {
		gameMessage = "No action has been registered.";
		return gameMessage;
	}
}