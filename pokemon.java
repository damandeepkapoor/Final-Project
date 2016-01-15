import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class pokemon extends Applet implements ActionListener
{
    int i = 1;
    String poke[] = new String [18];
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7;
    CardLayout cdLayout = new CardLayout ();
    String choice, name = null, desc = null, pokemon = null, searchBy = null, region = null, type = null, pokeNo = null, species = null, habitat = null;

    int row = 40;
    int col = 50;
    int total = row * col;
    JLabel x[] = new JLabel [total];
    String map1[] [] = {{"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "letter", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}};
    int guyx = 35;
    int guyy = 24;


    public void init ()

    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//Pokedex ();
	gameScreen ();
	mainMenu ();
	Instructions ();
	//nameIn ();
	Win ();
	Lose ();
	resize (1000, 600);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void Pokedex ()
    {
	card1 = new Panel ();
	card1.setBackground (Color.white);
	card1.resize (700, 800);

	String spokemon[] = new String [18];


	choice = JOptionPane.showInputDialog (null, "Do you know the name of the Starter Pokemon you are looking for? (Yes/No)", "Welcome to the Starter Pokedex!", 3);
	if (choice.equalsIgnoreCase ("yes"))
	{
	    pokemon = JOptionPane.showInputDialog (null, "Enter the name of the Starter Pokemon: ", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
	    Invalid ();
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
		    Invalid ();
		}
		else if (type.equalsIgnoreCase ("Water"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are water-type: \n\nSquirtle \nTotodile \nMudkip \nPiplup \nOshawott \nFroakie \n\nWhich Pokemon would you like to search?", "Water-type Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
		}
		else if (type.equalsIgnoreCase ("Grass"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are grass-type: \n\nBulbasaur \nChikorita \nTreecko \nTurtwig \nSnivy \nChespin \n\nWhich Pokemon would you like to search?", "Grass-type Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
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
		    Invalid ();
		}
		else if (region.equalsIgnoreCase ("Johto"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Johto region: \n\nChikorita \nCyndaquil \nTotodile \n\nWhich Pokemon would you like to search?", "Johto Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
		}
		else if (region.equalsIgnoreCase ("Hoenn"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Hoenn region: \n\nTreecko \nTorchic \nMudkip \n\nWhich Pokemon would you like to search?", "Hoenn Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
		}
		else if (region.equalsIgnoreCase ("Sinnoh"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Sinnoh region: \n\nTurtwig \nChimchar \nPiplup \n\nWhich Pokemon would you like to search?", "Sinnoh Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
		}
		else if (region.equalsIgnoreCase ("Unova"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Unova region: \n\nSnivy \nTepig \nOshawott \n\nWhich Pokemon would you like to search?", "Unova Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
		}
		else if (region.equalsIgnoreCase ("Kalos"))
		{
		    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Kalos region: \n\nChespin \nFennekin \nFroakie \n\nWhich Pokemon would you like to search?", "Kalos Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
		    Invalid ();
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
	    i++;
	    region = "Kanto";
	    pokeNo = "004";
	    species = "Lizard";
	    type = "Fire";
	    habitat = "Mountain";
	    desc = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.";
	}

	else if (pokemon.equalsIgnoreCase ("Squirtle"))
	{
	    i += 2;
	    region = "Kanto";
	    pokeNo = "007";
	    species = "Tiny turtle";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.";
	}

	else if (pokemon.equalsIgnoreCase ("Chikorita"))
	{
	    i += 3;
	    region = "Johto";
	    pokeNo = "152";
	    species = "Leaf";
	    type = "Grass";
	    habitat = "Grassland";
	    desc = "A sweet aroma gently wafts from the leaf on its head. It is docile and loves to soak up the sun's rays.";
	}

	else if (pokemon.equalsIgnoreCase ("Cyndaquil"))
	{
	    i += 4;
	    region = "Johto";
	    pokeNo = "155";
	    species = "Fire Mouse";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "It is timid, and always curls itself up in a ball. If attacked, it flares up its back for protection.";
	}

	else if (pokemon.equalsIgnoreCase ("Totodile"))
	{
	    i += 5;
	    region = "Johto";
	    pokeNo = "158";
	    species = "Big Jaw";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "Its well-developed jaws are powerful and capable of crushing anything. Even its trainer must be careful.";
	}

	else if (pokemon.equalsIgnoreCase ("Treecko"))
	{
	    i += 6;
	    region = "Hoenn";
	    pokeNo = "252";
	    species = "Wood Gecko";
	    type = "Grass";
	    habitat = "Forest";
	    desc = "Its well-developed jaws are powerful and capable of crushing anything. Even its trainer must be careful.";
	}

	else if (pokemon.equalsIgnoreCase ("Torchic"))
	{
	    i += 7;
	    region = "Hoenn";
	    pokeNo = "255";
	    species = "Chick";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "A fire burns inside, so it feels very warm to hug. It launches fireballs of 1,800 degrees F.";
	}

	else if (pokemon.equalsIgnoreCase ("Mudkip"))
	{
	    i += 8;
	    region = "Hoenn";
	    pokeNo = "258";
	    species = "Mud Fish";
	    type = "Water";
	    habitat = "Water's-edge";
	    desc = "The fin on MUDKIP's head acts as highly sensitive radar. Using this fin to sense movements of water and air, this POKÉMON can determine what is taking place around it without using its eyes.";
	}

	else if (pokemon.equalsIgnoreCase ("Turtwig"))
	{
	    i += 9;
	    region = "Sinnoh";
	    pokeNo = "387";
	    species = "Tiny Leaf";
	    type = "Grass";
	    habitat = "Lake-side";
	    desc = "It undertakes photosynthesis with its body, making oxygen. The leaf on its head wilts if it is thirsty.";
	}

	else if (pokemon.equalsIgnoreCase ("Chimchar"))
	{
	    i += 10;
	    region = "Sinnoh";
	    pokeNo = "390";
	    species = "Chimp";
	    type = "Fire";
	    habitat = "Mountain";
	    desc = "Its fiery rear end is fueled by gas made in its belly. Even rain can't extinguish the fire.";
	}

	else if (pokemon.equalsIgnoreCase ("Piplup"))
	{
	    i += 11;
	    region = "Sinnoh";
	    pokeNo = "393";
	    species = "Penguin";
	    type = "Water";
	    habitat = "Arctic";
	    desc = "A poor walker, it often falls down. However, its strong pride makes it puff up its chest without a care.";
	}

	else if (pokemon.equalsIgnoreCase ("Snivy"))
	{
	    i += 12;
	    region = "Unova";
	    pokeNo = "495";
	    species = "Grass Snake";
	    type = "Grass";
	    habitat = "Forest";
	    desc = "It is very intelligent and calm. Being exposed to lots of sunlight makes its movements swifter.";
	}

	else if (pokemon.equalsIgnoreCase ("Tepig"))
	{
	    i += 13;
	    region = "Unova";
	    pokeNo = "498";
	    species = "Fire Pig";
	    type = "Fire";
	    habitat = "Grassland";
	    desc = "It can deftly dodge its foe's attacks while shooting fireballs from its nose. It roasts berries before it eats them.";
	}

	else if (pokemon.equalsIgnoreCase ("Oshawott"))
	{
	    i += 14;
	    region = "Unova";
	    pokeNo = "501";
	    species = "Sea Otter";
	    type = "Water";
	    habitat = "Unknown";
	    desc = "The scalchop on its stomach isn't just used for battle - it can be used to break open hard berries as well.";
	}

	else if (pokemon.equalsIgnoreCase ("Chespin"))
	{
	    i += 15;
	    region = "Kalos";
	    pokeNo = "650";
	    species = "Spiny Nut";
	    type = "Grass";
	    habitat = "Unknown";
	    desc = "The quills on its head are usually soft. When it flexes them, the points become so hard and sharp that they can pierce rock.";
	}

	else if (pokemon.equalsIgnoreCase ("Fennekin"))
	{
	    i += 16;
	    region = "Kalos";
	    pokeNo = "653";
	    species = "Fox";
	    type = "Fire";
	    habitat = "Unknown";
	    desc = "Eating a twig fills it with energy, and its roomy ears give vent to air hotter than 390 degrees Fahrenheit.";
	}

	else if (pokemon.equalsIgnoreCase ("Froakie"))
	{
	    i += 17;
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

	JOptionPane.showMessageDialog (null, "* * * Pokemon * * * \n \n"
		+ "" + "Pokemon: " + pokemon + "\nRegion: " + region + "\nNational Pokemon #: " + pokeNo + "\nSpecies: " + species + "\nType: " + type + "\nHabitat: " + habitat + "\nDescription: " + desc, "Pokedex Results", JOptionPane.INFORMATION_MESSAGE);

	JLabel title = new JLabel ("Starter Pokemon");
	title.setFont (new Font ("Pokemon Solid", Font.PLAIN, 100));
	title.setForeground (Color.yellow);

	card1.add (title);

	JLabel pic = new JLabel (createImageIcon (i + ".jpg"));
	card1.add (pic);

	Panel p = new Panel ();

	JLabel choosen = new JLabel ("You have choosen " + pokemon + " to be your starter pokemon!");
	choosen.setFont (new Font ("Arial", Font.PLAIN, 15));
	choosen.setForeground (Color.orange);
	p.add (choosen);

	JButton begin = new JButton ("Let's begin our Journey");
	begin.addActionListener (this);
	begin.setActionCommand ("begin");
	choosen.setFont (new Font ("Raivy", Font.PLAIN, 20));
	choosen.setForeground (Color.orange);
	p.add (begin);

	card1.add (p);
	p_card.add ("1", card1);
    }


    public void gameScreen ()
    {
	card2 = new Panel ();
	card2.setBackground (Color.white);
	card2.resize (1000, 600);

	JLabel title = new JLabel ("Pokemon");
	title.setFont (new Font ("Pokemon Solid", Font.PLAIN, 100));
	title.setForeground (Color.yellow);

	Panel g1 = new Panel (new GridLayout (row, col, 0, 0));

	for (int i = 0 ; i < total ; i++)
	{
	    //  System.out.println ("Hi " + i);
	    x [i] = new JLabel (createImageIcon ("tree3.jpg"));
	    x [i].setPreferredSize (new Dimension (15, 15));
	    x [i].setIcon (createImageIcon ("tree3.jpg"));
	    //  x[i].setBorderPainted(false);
	    g1.add (x [i]);
	}
	redraw ();



	card2.add (g1);

	p_card.add ("2", card2);

    }


    public void redraw ()
    {
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		x [m].setIcon (createImageIcon (map1 [i] [j] + ".jpg"));
		m++;
	    }
	}

	x [guyx + guyy * col].setIcon (createImageIcon ("character1.jpg"));
    }


    public void mainMenu ()
    {
	card3 = new Panel ();
	card3.setBackground (Color.white);
	JLabel title = new JLabel ("Main Menu");

	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.red);

	card3.add (title);
	//card3.add (ins);


	p_card.add ("3", card3);

    }


    public void Instructions ()
    {
	card4 = new Panel ();
	card4.setBackground (Color.white);

	JLabel title = new JLabel ("Instructions");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.red);

	JLabel ins = new JLabel ("");

	card4.add (title);
	card4.add (ins);

	p_card.add ("4", card4);

    }


    public void nameIn ()
    {
	card5 = new Panel ();
	card5.setBackground (Color.white);
	JLabel title = new JLabel ("Hello!");

	name = JOptionPane.showInputDialog ("What's your name?");

	card5.add (title);

	p_card.add ("5", card5);

    }


    public void Win ()
    {
	card6 = new Panel ();
	card6.setBackground (Color.white);
	JLabel title = new JLabel ("Ballroom");

	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.red);
	JLabel ins = new JLabel ("I'm not here. Keep looking!");

	card6.add (title);
	card6.add (ins);

	p_card.add ("6", card6);

    }


    public void Lose ()
    {
	card7 = new Panel ();
	card7.setBackground (Color.white);
	JLabel title = new JLabel ("Bed Room");
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.red);
	JLabel ins = new JLabel ("I'm here. You found me!");

	card7.add (title);
	card7.add (ins);

	p_card.add ("7", card7);

    }



    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals ("begin"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("5"))
	    cdLayout.show (p_card, "5");
	else if (e.getActionCommand ().equals ("6"))
	{
	    cdLayout.show (p_card, "6");
	    showStatus ("You found me!");
	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = pokemon.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void Invalid ()
    {
	while (!pokemon.equalsIgnoreCase ("Bulbasaur") && !pokemon.equalsIgnoreCase ("Charmander") && !pokemon.equalsIgnoreCase ("Squirtle") && !pokemon.equalsIgnoreCase ("Chikorita") && !pokemon.equalsIgnoreCase ("Cyndaquil") && !pokemon.equalsIgnoreCase ("Totodile") && !pokemon.equalsIgnoreCase ("Treecko") && !pokemon.equalsIgnoreCase ("Torchic") && !pokemon.equalsIgnoreCase ("Mudkip") && !pokemon.equalsIgnoreCase ("Turtwig") && !pokemon.equalsIgnoreCase ("Chimchar") && !pokemon.equalsIgnoreCase ("Piplup") && !pokemon.equalsIgnoreCase ("Snivy") && !pokemon.equalsIgnoreCase ("Tepig") && !pokemon.equalsIgnoreCase ("Oshawott") && !pokemon.equalsIgnoreCase ("Chespin") && !pokemon.equalsIgnoreCase ("Froakie") && !pokemon.equalsIgnoreCase ("Fennekin"))
	    pokemon = JOptionPane.showInputDialog (null, "That pokemon wasn't found. Try Again! ", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
    }
}
