
public class _6Static {

	public static void main(String[] args) {
		
		Player p1 = new Player("Abhi");
		Player p2 = new Player("Vikky");
		
		System.out.println(Player.getPlayerCount());
		
		System.out.println(p1);
		System.out.println(p2);
	}
}

class Player{
	private String name;
	private int id;
	private static int playerCount = 0;//common for all player object
	
	public Player(String name) {
		super();
		this.name = name;
		this.id = ++playerCount;
	}
	public Player() {
		super();
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public static int getPlayerCount() {
		return playerCount;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", id=" + id + "]";
	}
	
}