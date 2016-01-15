import javax.swing.*;
public class StarterPokedex
{

    public static void main (String[] args)
    {

	String choice, desc = null, pokemon = null, searchBy = null, region = null, type = null, pokeNo = null, species = null, habitat = null;

	choice = JOptionPane.showInputDialog (null, "Do you know the name of the Starter Pokemon you are looking for? (Yes/No)", "Welcome to the Starter Pokedex!", 3);
	if (choice.equalsIgnoreCase ("yes"))
	{
	    pokemon = JOptionPane.showInputDialog (null, "Enter the name of the Starter Pokemon: ", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
	}
	else if (choice.equalsIgnoreCase ("no"))
	{
	    searchBy = JOptionPane.showInputDialog (null, "Search by: 'type' or 'region'?", "Welcome to the Starter Pokedex!", 3);

	    if (searchBy.equalsIgnoreCase ("type"))
	    {
		type = JOptionPane.showInputDialog (null, "Enter pokemon type: (Fire/Water/Grass)", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);

		if (type.equalsIgnoreCase ("Fire"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are fire-type: \n\nCharmander \nCyndaquil \nTorchic \nChimchar \nTepig \nFennekin \n\nWhich Pokemon would you like to search?", "Fire-type Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (type.equalsIgnoreCase ("Water"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are water-type: \n\nSquirtle \nTotodile \nMudkip \nPiplup \nOshawott \nFroakie \n\nWhich Pokemon would you like to search?", "Water-type Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (type.equalsIgnoreCase ("Grass"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are grass-type: \n\nBulbasaur \nChikorita \nTreecko \nTurtwig \nSnivy \nChespin \n\nWhich Pokemon would you like to search?", "Grass-type Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}

		else
		{
		    JOptionPane.showMessageDialog (null, "You entered an invalid keyword. Try again.", "Error!", 1);
		}
	    }


	    else if (searchBy.equalsIgnoreCase ("region"))
	    {
		region = JOptionPane.showInputDialog (null, "Enter region: (Kanto/Johto/Hoenn/Sinnoh/Unova/Kalos)", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);

		if (region.equalsIgnoreCase ("Kanto"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Kanto region: \n\nBulbasaur \nCharmander \nSquirtle \n\nWhich Pokemon would you like to search?", "Kanto Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (region.equalsIgnoreCase ("Johto"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Johto region: \n\nChikorita \nCyndaquil \nTotodile \n\nWhich Pokemon would you like to search?", "Johto Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (region.equalsIgnoreCase ("Hoenn"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Hoenn region: \n\nTreecko \nTorchic \nMudkip \n\nWhich Pokemon would you like to search?", "Hoenn Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (region.equalsIgnoreCase ("Sinnoh"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Sinnoh region: \n\nTurtwig \nChimchar \nPiplup \n\nWhich Pokemon would you like to search?", "Sinnoh Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (region.equalsIgnoreCase ("Unova"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Unova region: \n\nSnivy \nTepig \nOshawott \n\nWhich Pokemon would you like to search?", "Unova Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}
		else if (region.equalsIgnoreCase ("Kalos"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Kalos region: \n\nChespin \nFennekin \nFroakie \n\nWhich Pokemon would you like to search?", "Kalos Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		}

		else
		{
		    JOptionPane.showMessageDialog (null, "You entered an invalid keyword. Try again.", "Error!", 1);
		}

	    }

	    else
	    {
		JOptionPane.showMessageDialog (null, "You entered an invalid keyword. Try again.", "Error!", 1);
	    }

	}

	else
	    JOptionPane.showMessageDialog (null, "You entered an invalid keyword. Try again.", "Error!", 1);


	if (pokemon.equalsIgnoreCase ("Bulbasaur"))
	{
	    region = "Kanto";
	    pokeNo = "001";
	    species = "Seed";
	    type = "Grass";
	    habitat = "Grassland";
	    desc = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.";
	}

	else if (pokemon.equalsIgnoreCase ("Charmander"))
	{
	    region = "Kanto";
	    pokeNo = "004";
	    species = "Lizard";
	    type = "Fire";
	    habitat = "Mountain";
	    desc = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.";
	}

	else if (pokemon.equalsIgnoreCase ("Squirtle"))
	{
	    region = "Kanto";
	    pokeNo = "007";
	    species = "Tiny turtle";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.";
	}

	else if (pokemon.equalsIgnoreCase ("Chikorita"))
	{
	    region = "Johto";
	    pokeNo = "152";
	    species = "Leaf";
	    type = "Grass";
	    habitat = "Grassland";
	    desc = "A sweet aroma gently wafts from the leaf on its head. It is docile and loves to soak up the sun's rays.";
	}

	else if (pokemon.equalsIgnoreCase ("Cyndaquil"))
	{
	    region = "Johto";
	    pokeNo = "155";
	    species = "Fire Mouse";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "It is timid, and always curls itself up in a ball. If attacked, it flares up its back for protection.";
	}

	else if (pokemon.equalsIgnoreCase ("Totodile"))
	{
	    region = "Johto";
	    pokeNo = "158";
	    species = "Big Jaw";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "Its well-developed jaws are powerful and capable of crushing anything. Even its trainer must be careful.";
	}

	else if (pokemon.equalsIgnoreCase ("Treecko"))
	{
	    region = "Hoenn";
	    pokeNo = "252";
	    species = "Wood Gecko";
	    type = "Grass";
	    habitat = "Forest";
	    desc = "Its well-developed jaws are powerful and capable of crushing anything. Even its trainer must be careful.";
	}

	else if (pokemon.equalsIgnoreCase ("Torchic"))
	{
	    region = "Hoenn";
	    pokeNo = "255";
	    species = "Chick";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "A fire burns inside, so it feels very warm to hug. It launches fireballs of 1,800 degrees F.";
	}

	else if (pokemon.equalsIgnoreCase ("Mudkip"))
	{
	    region = "Hoenn";
	    pokeNo = "258";
	    species = "Mud Fish";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "The fin on MUDKIP's head acts as highly sensitive radar. Using this fin to sense movements of water and air, this POKÉMON can determine what is taking place around it without using its eyes.";
	}

	else if (pokemon.equalsIgnoreCase ("Turtwig"))
	{
	    region = "Sinnoh";
	    pokeNo = "387";
	    species = "Tiny Leaf";
	    type = "Grass";
	    habitat = "Lake-side";
	    desc = "It undertakes photosynthesis with its body, making oxygen. The leaf on its head wilts if it is thirsty.";
	}

	else if (pokemon.equalsIgnoreCase ("Chimchar"))
	{
	    region = "Sinnoh";
	    pokeNo = "390";
	    species = "Chimp";
	    type = "Fire";
	    habitat = "Mountain";
	    desc = "Its fiery rear end is fueled by gas made in its belly. Even rain can't extinguish the fire.";
	}

	else if (pokemon.equalsIgnoreCase ("Piplup"))
	{
	    region = "Sinnoh";
	    pokeNo = "393";
	    species = "Penguin";
	    type = "Water";
	    habitat = "Arctic";
	    desc = "A poor walker, it often falls down. However, its strong pride makes it puff up its chest without a care.";
	}

	else if (pokemon.equalsIgnoreCase ("Snivy"))
	{
	    region = "Unova";
	    pokeNo = "495";
	    species = "Grass Snake";
	    type = "Grass";
	    habitat = "Forest";
	    desc = "It is very intelligent and calm. Being exposed to lots of sunlight makes its movements swifter.";
	}

	else if (pokemon.equalsIgnoreCase ("Tepig"))
	{
	    region = "Unova";
	    pokeNo = "498";
	    species = "Fire Pig";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "It can deftly dodge its foe's attacks while shooting fireballs from its nose. It roasts berries before it eats them.";
	}

	else if (pokemon.equalsIgnoreCase ("Oshawott"))
	{
	    region = "Unova";
	    pokeNo = "501";
	    species = "Sea Otter";
	    type = "Water";
	    habitat = "Unknown";
	    desc = "The scalchop on its stomach isn't just used for battle - it can be used to break open hard berries as well.";
	}

	else if (pokemon.equalsIgnoreCase ("Chespin"))
	{
	    region = "Kalos";
	    pokeNo = "650";
	    species = "Spiny Nut";
	    type = "Grass";
	    habitat = "Unknown";
	    desc = "The quills on its head are usually soft. When it flexes them, the points become so hard and sharp that they can pierce rock.";
	}

	else if (pokemon.equalsIgnoreCase ("Fennekin"))
	{
	    region = "Kalos";
	    pokeNo = "653";
	    species = "Fox";
	    type = "Fire";
	    habitat = "Unknown";
	    desc = "Eating a twig fills it with energy, and its roomy ears give vent to air hotter than 390 degrees Fahrenheit.";
	}

	else if (pokemon.equalsIgnoreCase ("Froakie"))
	{
	    region = "Kalos";
	    pokeNo = "656";
	    species = "Foam Frog";
	    type = "Water";
	    habitat = "Unknown";
	    desc = "It secretes flexible bubbles from its chest and back. The bubbles reduce the damage it would otherwise take when attacked.";
	}

	else
	{
	    JOptionPane.showMessageDialog (null, "No such Starter Pokemon exists. Try again.");
	}

	JOptionPane.showMessageDialog (null, "Pokemon: " + pokemon + "\nRegion: " + region + "\nNational Pokemon #: " + pokeNo + "\nSpecies: " + species + "\nType: " + type + "\nHabitat: " + habitat + "\nDescription: " + desc, "Pokedex Results", 1);


    }
}
//https://compilr.com/damandeep/pokemon-prototype-clone/Pokemon.java
