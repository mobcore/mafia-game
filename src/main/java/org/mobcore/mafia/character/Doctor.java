package org.mobcore.mafia.character;

import org.mobcore.mafia.engine.GameRegistration.Player;
import org.mobcore.mafia.character.CharacterFactory.Roles;
import org.mobcore.mafia.resouces.GameLog;

import java.util.List;

public class Doctor extends Character {

	protected Doctor(Player player) {
		super(CharacterFactory.Roles.Doctor, player);
	}

	@Override
	public boolean performAction(List<Player> alive_player, Character target) {
		if(this.character_status.isBlocked()) {
			result = GameLog.Character.BLOCKED(player);
			return true;
		}
		target.character_status.getVisitors().add(player);
		target.character_status.heal();
		result = GameLog.Character.DOCTOR_SUCCESS(player, target.player);
		return true;
	}
}
