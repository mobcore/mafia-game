package org.mobcore.mafia.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mobcore.mafia.resouces.GameLog;
import org.mobcore.mafia.engine.GameRegistration.Player;

/**
 * Game Engine's component for storing votes
 */
public class GameVoteEngine {
	
	private static final Map<Player, Player> player_vote_map = new HashMap<Player, Player>();
	private static List<Player> mayor_list = new ArrayList<Player>();
	
	/**
	 * First setup
	 * 
	 * @param player_list
	 * @return true
	 */
	protected static boolean setupVoteMap(List<Player> player_list) {
		player_vote_map.clear();
		for(Player player : player_list) {
			player_vote_map.put(player, null);
		}
		return true;
	}
	
	/**
	 * @return player vote map
	 */
	protected static Map<Player, Player> getVoteMap() {
		return player_vote_map;
	}
	
	/**
	 * Add a mayor
	 * 
	 * @param player
	 * @return true
	 */
	protected static boolean addMayor(Player player) {
		mayor_list.add(player);
		return true;
	}
	
	/**
	 * @return list of mayor(s)
	 */
	protected static List<Player> getMayors() {
		return mayor_list;
	}
	
	/**
	 * Set vote
	 * 
	 * @param player
	 * @param target
	 * @return appropriate game message string
	 */
	protected static String setVote(Player player, Player target) {
		if(player_vote_map.put(player, target) != null) {
			return GameLog.Inputs.VOTE_SUCCESS(player, target);
		} else {
			return GameLog.Inputs.VOTE_FAIL(player, target);
		}
	}
}
