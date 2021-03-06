package org.mobcore.mafia.engine;


import java.util.ArrayList;
import java.util.List;

import org.mobcore.mafia.resouces.GameLog;

/**
 * Game Engine's component for game registration
 */
public class GameRegistration {

	private static final ArrayList<Player> valid_players = new ArrayList<Player>();

	/**
	 * Registers a player in the game
	 * 
	 * @param name
	 *            of player
	 * @return appropriate game message string
	 */
	protected static String registerPlayer(String name) {
		if (PlayerValidation.register(name)) {
			return GameLog.Registration.REGISTER_SUCCESS(name);
		} else {
			return GameLog.Registration.REGISTER_FAIL(name);
		}
	}

	/**
	 * Unregisters a player from the game
	 * 
	 * @param name
	 *            of player
	 * @return appropriate game message string
	 */
	protected static String unregisterPlayer(String name) {
		if (PlayerValidation.unregister(name)) {
			return GameLog.Registration.UNREGISTER_SUCCESS(name);
		} else {
			return GameLog.Registration.UNREGISTER_FAIL(name);
		}
	}

	/**
	 * Unregister all players from the game
	 * 
	 * @return appropriate game message string
	 */
	protected static String unregisterAll() {
		if (PlayerValidation.unregisterAll()) {
			return GameLog.Registration.UNREGISTER_ALL_SUCCESS();
		} else {
			return GameLog.Registration.UNREGISTER_ALL_FAIL();
		}
	}

	/**
	 * Lists all players in the game
	 * 
	 * @return appropriate game message string
	 */
	protected static String listAllPlayers() {
		List<String> all_players = PlayerValidation.listAll();
		if (!all_players.isEmpty()) {
			return GameLog.Registration.LIST_ALL_PLAYERS(all_players);
		} else {
			return GameLog.Registration.NO_PLAYER_REGISTERED();
		}
	}

	/**
	 * Get all players
	 * 
	 * @return list of all players
	 */
	protected static List<Player> getAllPlayers() {
		GameRegistration game_registration = new GameRegistration();
		List<String> all_players_string = PlayerValidation.listAll();
		List<Player> all_players = new ArrayList<Player>();
		for (String player_string : all_players_string) {
			all_players.add(game_registration.new Player(player_string));
		}
		valid_players.addAll(all_players);
		return all_players;
	}

	/**
	 * Get player with name (TESTING ONLY)
	 * 
	 * @param name of player
	 * @return player if valid, else null
	 */
	// For testing purposes. Not to be used anywhere else in the code.
	public static Player get(String name) {
		for (Player player : valid_players) {
			if (player.getName().equals(name)) {
				return player;
			}
		}
		return null;
	}

	/**
	 * The Player class acts as a data type to represent the player
	 */
	public class Player {
		private final String name;

		private Player(String name) {
			this.name = name;
		}

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

		@Override
		public String toString() {
			return name;
		}
	}

	/**
	 * The PlayerValidation class acts as a data type to manage the registration
	 * of human players in the game.
	 */
	private static class PlayerValidation {

		private static final ArrayList<String> valid_names = new ArrayList<String>();

		/**
		 * Registers a player in the game
		 * 
		 * @param name
		 *            of player
		 * @return true if successfully registered, else false.
		 */
		private static boolean register(String name) {
			if (!valid_names.contains(name) && !name.contains(" ")) {
				valid_names.add(name);
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Unregisters a player from the game
		 * 
		 * @param name
		 *            of player
		 * @return true if successfully unregistered, else false.
		 */
		private static boolean unregister(String name) {
			if (valid_names.contains(name)) {
				valid_names.remove(name);
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Unregisters all players from the game
		 * 
		 * @return true if successfully unregistered all, else false.
		 */
		private static boolean unregisterAll() {
			if (!valid_names.isEmpty()) {
				valid_names.clear();
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return a list of all players in the game
		 */
		private static List<String> listAll() {
			return new ArrayList<String>(valid_names);
		}
	}
}