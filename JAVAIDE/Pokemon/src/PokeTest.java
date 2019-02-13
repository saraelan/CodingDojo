
public class PokeTest {

	public PokeTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Pokeman p1 =new Pokeman("AAA",100,"BBB");
		Pokeman p2=new Pokeman("CCCC",300,"eeee");
		
		Pokedex p3=new Pokedex();
		p3.listPokeman();
		p3.pokemanInfo(p1);
		p1.attackPokeman(p2);
		p3.pokemanInfo(p2);
		p3.listPokeman();
		

	}

}
