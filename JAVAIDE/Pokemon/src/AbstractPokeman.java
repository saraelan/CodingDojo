
public abstract class AbstractPokeman implements PokemanInterface {
	
	public Pokeman createPokeman(String name, int health, String type)
	{
		return new Pokeman(name,health,type);
	}

//	public void pokemanInfo(Pokeman pokeman)
//	{
//		return pokemanInfo(pokeman);
//	}
	public AbstractPokeman() {
		// TODO Auto-generated constructor stub
	}
	
	public void attackPokemon(Pokeman pokeman) {
		pokeman.setHealth(pokeman.getHealth() - 10);
	}
	

}
