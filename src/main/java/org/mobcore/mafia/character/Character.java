package org.mobcore.mafia.character;

import org.mobcore.mafia.character.CharacterFactory.Roles;

import java.util.ArrayList;
import java.util.List;

import org.mobcore.mafia.engine.GameRegistration.Player;

/**
 * Character in the game
 */
public abstract class Character {
	private final Roles role;
	protected final Player player;
	protected final CharacterStatus character_status;
	protected String result; //Night action result
	/**
	 * Constructor
	 * 
	 * @param role of player
	 * @param player class
	 */
	protected Character(Roles role, Player player) {
		this.role = role;
		this.player = player;
		character_status = new CharacterStatus();
	}
	/**
	 * Constructor
	 * 
	 * @param role
	 * @param player
	 * @param invulnerable
	 */
	protected Character(Roles role, Player player, boolean invulnerable) {
		this.role = role;
		this.player = player;
		character_status = new CharacterStatus();
	}
	/**
	 * Constructor
	 * 
	 * @param role
	 * @param player
	 * @param invulnerable
	 * @param block_immune
	 */
	protected Character(Roles role, Player player, boolean invulnerable, boolean block_immune) {
		this.role = role;
		this.player = player;
		character_status = new CharacterStatus();
	}
	
	/**
	 * @return String of the role
	 */
	public Roles getRole() {
		return role;
	}
	
	/**
	 * Update night action result string
	 * 
	 * @return true
	 */
	public boolean updateResult(String result) {
		this.result = result;
		return true;
	}
	
	/**
	 * @return night action result string
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Perform night action
	 * 
	 * @param target
	 * @return game log string message
	 */
	public abstract boolean performAction(List<Player> alive_player, Character target);
	
	/**
	 * CharacterStatus saves all the the character status information.
	 */
	protected class CharacterStatus {
		private final boolean invulnerable;
		private final boolean block_immune;
		private final List<Player> visitors;
		private boolean doused;
		private boolean blocked;
		private boolean healed;
		
		/**
		 * Constructor
		 */
		private CharacterStatus() {
			invulnerable = false;
			block_immune = false;
			visitors = new ArrayList<Player>();
			doused = false;
			blocked = false;
			healed = false;
		}
		/**
		 * @return true if is invulnerable, else false
		 */
		protected boolean isInvulnerable() {
			return invulnerable;
		}
		/**
		 * @return true if is block immune, else false
		 */
		protected boolean isBlockImmune() {
			return block_immune;
		}
		/**
		 * @return list of visitors
		 */
		protected List<Player> getVisitors() {
			return visitors;
		}
		/**
		 * @return true if doused, else false
		 */
		protected boolean isDoused() {
			return doused;
		}
		/**
		 * @return true if doused and false if not-doused
		 */
		protected boolean douse() {
			return doused = !doused;
		}
		/**
		 * @return true if blocked, else false
		 */
		protected boolean isBlocked() {
			return blocked;
		}
		/**
		 * @return true when blocked
		 */
		protected boolean block() {
			return blocked = true;
		}
		/**
		 * @return true if healed, else false
		 */
		protected boolean isHealed() {
			return healed;
		}
		/**
		 * @return true when healed
		 */
		protected boolean heal() {
			return healed = true;
		}
		/**
		 * @return true when reset
		 */
		public boolean reset() {
			blocked = false;
			healed = false;
			visitors.clear();
			return true;
		}
	}
}
