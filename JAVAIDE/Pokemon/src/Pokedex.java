
public class Pokedex extends AbstractPokeman{
	
	public void pokemanInfo(Pokeman pokeman) {
		System.out.println("Name: " + pokeman.getName());
		System.out.println("Type: " + pokeman.getType());
		System.out.println("Health: " + pokeman.getHealth());
	}
	
	public void listPokeman(Pokeman pokeman)
	{
		System.out.println(pokeman.getName());
		
	}

	public Pokedex() {
		// TODO Auto-generated constructor stub
	}

//	@Override
	public void listPokeman() {
		// TODO Auto-generated method stub
		
	}

	

}
