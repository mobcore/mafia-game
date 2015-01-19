package GameEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameEngine The game engine is responsible for keeping track of everything
 * that happens in the game. This will include: - Keeping a map of all Players
 * and their Character role - Assigning roles to all Players - Acting as an
 * interface to allow human players to set targets for their actions - Invoking
 * the actions of all Characters when it is night-time
 */
public class GameEngine {

	private static Map<Player, Character> player_character_map = new HashMap<Player, Character>();
	//List of players still alive, used for setTarget() method in Character Class
	public static List<Player> AliveList = new ArrayList<Player>();
	/**
	 * GameEngine.registerPlayer Registers a player into the game.
	 * 
	 * @param name
	 * @return true if successful, false if not.
	 */
	public static boolean registerPlayer(String name) {
		return Player.register(name);
	}

	/**
	 * GameEngine.getCharacter
	 * 
	 * @param player
	 *            The human name of the player
	 * @return Gets the character role of the player
	 */
	public static Character getCharacter(Player player) {
		return player_character_map.get(player);
	}
	
	/**
	 * GameEngine.assignCharacters Randomly assigns a character role to all
	 * players
	 */
	public static void assignCharacters() {
		// TODO: implement me!
	}

	/**
	 * GameEngine.assignCharacter Assigns a single character role to a single
	 * player
	 */
	public static void assignCharacter(Player player, Character character) {
		player_character_map.put(player, character);
		AliveList.add(player);
	}

	/**
	 * GameEngine.setTarget
	 * 
	 * @param player
	 *            The player performing the action
	 * @param targets
	 *            The target(s) of the action
	 * @return true if target was successfully set, false otherwise
	 */
	public static boolean setTarget(Player player, List<Player> targets) {
		return player_character_map.get(player).setTarget(targets);
	}

	/**
	 * GameEngine.performNightActions Makes each character perform his/her night
	 * action
	 */
	public static void performNightActions() {
		// TODO: implement me!
	}

}
