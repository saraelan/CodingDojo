
public class Pokeman {
	
	private String name;
	private int health;
	private String type;
	public static int count=0;

	public Pokeman(String name, int health, String type) {
		this.name=name;
		this.health=health;
		this.type=type;
		count++;
		
	}
	
	public void attackPokeman(Pokeman pokeman)
	{
		pokeman.health-=10;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void pokemonInfo(Pokeman pokeman)
    {
    	System.out.println("Name: " + pokeman.name);
		System.out.println("Type: " + pokeman.type);
		System.out.println("Health: " + pokeman.health);
    }
    
    public Pokeman createPokemon(String name,int health,String type) {
		return new Pokeman(name,health,type);
	}
	
    public void listPokeman(Pokeman pokeman)
    {
    	System.out.println("Name: " + pokeman.name);
    }
	
}
