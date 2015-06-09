package Character;

import GameEngine.GameRegistration.Player;

public class CharacterFactory {
	public static Character makeCharacter(Roles role, Player player) {
		switch (role) {
		case Administrator:
			break;
		case Agent:
			break;
		case Amnesiac:
			break;
		case Arsonist:
			break;
		case Auditor:
			break;
		case Beguiler:
			break;
		case Blackmailer:
			break;
		case Bodyguard:
			break;
		case BusDriver:
			break;
		case Citizen:
			break;
		case Consigliere:
			break;
		case Consort:
			break;
		case Coroner:
			break;
		case Crier:
			break;
		case Cultist:
			break;
		case Deceiver:
			break;
		case Detective:
			break;
		case Disguiser:
			break;
		case Doctor: return new Doctor(player);
		case DragonHead:
			break;
		case Enforcer:
			break;
		case Escort:
			break;
		case Executioner:
			break;
		case Forger:
			break;
		case Framer:
			break;
		case Godfather:
			break;
		case IncenseMaster:
			break;
		case Informant:
			break;
		case Interrogator:
			break;
		case Investigator:
			break;
		case Jailor:
			break;
		case Janitor:
			break;
		case Jester:
			break;
		case Judge:
			break;
		case Kidnapper:
			break;
		case Liaison:
			break;
		case Lookout:
			break;
		case Mafioso:
			break;
		case Marshall:
			break;
		case Mason:
			break;
		case MasonLeader:
			break;
		case MassMurderer:
			break;
		case Mayor: return new Mayor(player);
		case SerialKiller:
			break;
		case Sheriff:
			break;
		case Silencer:
			break;
		case Spy:
			break;
		case Stump:
			break;
		case Survivor:
			break;
		case Vanguard:
			break;
		case Veteran:
			break;
		case Vigilante: return new Vigilante(player);
		case Witch:
			break;
		case WitchDoctor:
			break;
		default:
			break;
		
		}
		return null;
	}
	
	/**
	 * Enumeration of all the roles in the game.
	 */
	public enum Roles {

		Bodyguard(Sides.Town, "Bodyguard"), BusDriver(Sides.Town, "BusDriver"), Citizen(
				Sides.Town, "Citizen"), Coroner(Sides.Town, "Coroner"), Crier(
				Sides.Town, "Crier"), Detective(Sides.Town, "Detective"), Doctor(
				Sides.Town, "Doctor"), Escort(Sides.Town, "Escort"), Investigator(
				Sides.Town, "Investigator"), Jailor(Sides.Town, "Jailor"), Lookout(
				Sides.Town, "Lookout"), Marshall(Sides.Town, "Marshall"), Mason(
				Sides.Town, "Mason"), MasonLeader(Sides.Town, "MasonLeader"), Mayor(
				Sides.Town, "Mayor"), Sheriff(Sides.Town, "Sheriff"), Spy(
				Sides.Town, "Spy"), Stump(Sides.Town, "Stump"), Veteran(
				Sides.Town, "Veteran"), Vigilante(Sides.Town, "Vigilante"), Agent(
				Sides.Mafia, "Agent"), Beguiler(Sides.Mafia, "Beguiler"), Blackmailer(
				Sides.Mafia, "Blackmailer"), Consigliere(Sides.Mafia,
				"Consigliere"), Consort(Sides.Mafia, "Consort"), Disguiser(
				Sides.Mafia, "Disguiser"), Framer(Sides.Mafia, "Framer"), Godfather(
				Sides.Mafia, "Godfather"), Janitor(Sides.Mafia, "Janitor"), Kidnapper(
				Sides.Mafia, "Kidnapper"), Mafioso(Sides.Mafia, "Mafioso"), Administrator(
				Sides.Triad, "Administrator"), Deceiver(Sides.Triad, "Deceiver"), DragonHead(
				Sides.Triad, "DragonHead"), Enforcer(Sides.Triad, "Enforcer"), Forger(
				Sides.Triad, "Forger"), IncenseMaster(Sides.Triad,
				"IncenseMaster"), Informant(Sides.Triad, "Informant"), Interrogator(
				Sides.Triad, "Interrogator"), Liaison(Sides.Triad, "Liaison"), Silencer(
				Sides.Triad, "Silencer"), Vanguard(Sides.Triad, "Vanguard"), Amnesiac(
				Sides.Neutral, "Amnesiac"), Arsonist(Sides.Neutral, "Arsonist"), Auditor(
				Sides.Neutral, "Auditor"), Cultist(Sides.Neutral, "Cultist"), Executioner(
				Sides.Neutral, "Executioner"), Jester(Sides.Neutral, "Jester"), Judge(
				Sides.Neutral, "Judge"), MassMurderer(Sides.Neutral,
				"MassMurderer"), SerialKiller(Sides.Neutral, "SerialKiller"), Survivor(
				Sides.Neutral, "Survivor"), Witch(Sides.Neutral, "Witch"), WitchDoctor(
				Sides.Neutral, "WitchDoctor");

		private Sides side;
		private String role;

		/**
		 * Constructor
		 * 
		 * @param side
		 *            : Side of the character
		 * @param role
		 *            : Role as a string
		 */
		Roles(Sides side, String role) {
			this.side = side;
			this.role = role;
		}

		/**
		 * 
		 * @return the side of the character
		 */
		public String sideToString() {
			return side.toString();
		}

		/**
		 * Returns role as a string
		 */
		public String toString() {
			return role;
		}

		/**
		 * Get the role from string
		 * 
		 * @param text
		 * @return role
		 */
		public static Roles fromString(String string) {
			if (string != null) {
				for (Roles role : Roles.values()) {
					if (string.equalsIgnoreCase(role.role)) {
						return role;
					}
				}
			}
			return null;
		}
	}

	/**
	 * Enumeration of all the sides in the game.
	 */
	public enum Sides {
		Town("Town"), Mafia("Mafia"), Triad("Triad"), Neutral("Neutral");

		private final String side;

		Sides(String side) {
			this.side = side;
		}

		@Override
		public String toString() {
			return side;
		}
	}
}
