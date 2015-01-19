package GameEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Player
 * 
 * This class acts as a data type representing each human player. Each person
 * will have to be first registered into the Player class's data map so that
 * their real-world name will be considered valid within the data type.
 */
public class Player {

	// Class-wide validation map of human player names
	static private final ArrayList<String> valid_names = new ArrayList<String>();

	private final String name;

	/**
	 * Player.get
	 * 
	 * @param name
	 *            The human name of a player
	 * @return A Player if the name is registered, null if the name is not
	 *         registered
	 */
	// Would love if this threw an exception instead of returning null. A null
	// player undetected in code could be hard to find.
	public static Player get(String name) {
		if (valid_names.contains(name)) {
			return new Player(name);
		} else {
			return null;
		}
	}

	/**
	 * Player.getAllPlayers
	 * 
	 * @return A list of all registered players
	 */
	public static List<Player> getAllPlayers() {
		List<Player> list = new ArrayList<Player>();
		for (String name : valid_names) {
			list.add(new Player(name));
		}
		return list;
	}

	/**
	 * Player.register Registers a human name to the list of valid player names.
	 * This method is protected as we want players to be registered through the
	 * GameEngine.
	 * 
	 * @param name
	 *            The human name of a player
	 * @return true if the name was added successfully, false otherwise
	 */
	protected static boolean register(String name) {
		if (valid_names.contains(name)) {
			return false;
		} else {
			return valid_names.add(name);
		}
	}

	/**
	 * Player.remove Removes a human name from the list of valid player names.
	 * This method is protected as we want players to be removed through the
	 * GameEngine.
	 * 
	 * @param name
	 *            The human name of a player
	 * @return true if the name was added successfully, false otherwise
	 */
	protected static boolean remove(String name) {
		if (valid_names.contains(name)) {
			valid_names.remove(name);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Player This constructor is private so that the only way someone can
	 * access a Player name is through the Player.get interface. This is to
	 * ensure only valid Players are used with valid names.
	 * 
	 * @param name
	 *            The name of a human player
	 */
	private Player(String name) {
		this.name = name;
	}

	/**
	 * getName
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object other_player) {
		if (other_player instanceof Player) {
			Player other = (Player) other_player;
			return (this.name.equals(other.getName()));
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
