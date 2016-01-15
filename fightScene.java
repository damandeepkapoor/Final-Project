import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

public class fightScene extends Applet implements ActionListener
{
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7, card8, card9;
    CardLayout cdLayout = new CardLayout ();

    public void init ()

    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	resize (1200, 600);

	fight ();

	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void actionPerformed (ActionEvent e)
    {
    }


    public void fight ()  //the fight


    {
	int uhp = 500; //user hp
	int chp = 500; //witch hp

	while (chp > 0 && uhp > 0)
	{

	    System.out.println ("\n\nYour Attacks:"); //user attacks/hero attacks first

	    System.out.println ("\n1) Binding roots (45-65)"); //in brackets is the damage
	    System.out.println ("2) Hellfire Grasp (80 dmg/minus 25 hp)");
	    System.out.println ("3) Cyclonic Wave (1-100)");
	    System.out.println ("4) Aero Brave Blast (55)");

	    int att = IBIO.inputInt ("\nChoose an attack to use on the witch: "); //user selects attack (#1-4)

	    while (att != 1 && att != 2 && att != 3 && att != 4)
	    {
		att = IBIO.inputInt ("Invalid input. That's not between 1-4. Choose a number between 1-4? ");
	    }
	    switch (att) //switch statement
	    {
		case 1:
		    System.out.println ("\nBinding roots"); //attack 1

		    int dmg = (int) (Math.random () * 20) + 45; //damage
		    chp -= dmg;
		    System.out.println ("This attack did " + dmg + " damage to the witch.");

		    if (chp < 0) //witch 0 hp
			System.out.println ("\nThe witch has 0 hp left.");
		    else
		    {
			System.out.println ("\nThe witch has " + chp + " hp left."); //hp after atttack
			System.out.println ("You have " + uhp + " hp left.\n");
		    }
		    break;

		case 2:
		    System.out.println ("\nHellfire Grasp"); //attack 2

		    int dmg2 = 80; //damage
		    uhp -= 25;
		    chp -= dmg2;
		    System.out.println ("This attack did " + dmg2 + " damage to the witch and 25 damage to you.");
		    if (chp < 0) //witch 0 hp
			System.out.println ("\nThe witch has 0 hp left.");
		    else
		    {
			System.out.println ("\nThe witch has " + chp + " hp left.");
		    }
		    if (uhp < 0) //user 0 hp
			System.out.println ("You have 0 hp left.");

		    else
			System.out.println ("You have " + uhp + " hp left.\n");
		    //hp after atttack
		    break;

		case 3:
		    System.out.println ("\nCyclonic Wave"); //attack 3

		    int dmg3 = (int) (Math.random () * 100) + 1; //damage
		    chp -= dmg3;
		    System.out.println ("This attack did " + dmg3 + " damage to the witch.");

		    if (chp < 0) //witch 0 hp
			System.out.println ("\nThe witch has 0 hp left.");
		    else
		    {
			System.out.println ("\nThe witch has " + chp + " hp left."); //hp after atttack
			System.out.println ("You have " + uhp + " hp left.\n");
		    }
		    break;

		case 4:
		    System.out.println ("\nAero Brave Blast"); //attack 4

		    int dmg4 = 55; //damage
		    chp -= dmg4;
		    System.out.println ("This attack did " + dmg4 + " damage to the witch.");

		    if (chp < 0) //witch 0 hp
			System.out.println ("\nThe witch has 0 hp left.");
		    else
		    {
			System.out.println ("\nThe witch has " + chp + " hp left."); //hp after atttack
			System.out.println ("You have " + uhp + " hp left.\n");
		    }
		    break;

		default: //shows hp
		    System.out.println ("\nThe witch has " + chp + " hp left.");
		    System.out.println ("You have " + uhp + " hp left.\n");
	    }
	    if (chp > 0 && uhp > 0) //this is set, so that the witch doesn't attack if the user is dead.
	    {
		System.out.println ("\nWitchs' Attacks:"); //witch's attack/witch attacks 2nd

		System.out.println ("\n1) Feint Attack (40-70)");
		System.out.println ("2) Hyperspace Fury (80 dmg/minus 30 hp)");
		System.out.println ("3) Dark Void (1-100)");
		System.out.println ("4) Sucker Punch (50)");

		int catt = (int) (Math.random () * 4) + 1; //witch's attack is computer selected

		switch (catt)
		{
		    case 1:
			System.out.println ("\nFeint Attack"); //attack 1

			int cdmg = (int) (Math.random () * 30) + 40; //damage
			uhp -= cdmg;
			System.out.println ("This attack did " + cdmg + " damage to you.");

			if (uhp < 0) //if user hp is 0
			    System.out.println ("\nYou have 0 hp left.");
			else
			{
			    System.out.println ("\nThe witch has " + chp + " hp left.");
			    System.out.println ("You have " + uhp + " hp left.\n");
			}
			break;

		    case 2:
			System.out.println ("\nHyperspace Fury"); //attack 2

			int cdmg2 = 80; //damage
			chp -= 30;
			uhp -= cdmg2;
			System.out.println ("This attack did " + cdmg2 + " damage to you and 30 damage to the witch.");

			if (chp < 0) //if witch hp is 0
			    System.out.println ("\nThe witch has 0 hp left.");

			else
			    System.out.println ("\nThe witch has " + chp + " hp left.");

			if (uhp < 0) //if user hp is 0
			    System.out.println ("You have 0 hp left.");

			else
			    System.out.println ("You have " + uhp + " hp left.");

			break;

		    case 3:
			System.out.println ("\nDark Void"); //attack 3

			int cdmg3 = (int) (Math.random () * 100) + 1; //damage
			uhp -= cdmg3;
			System.out.println ("This attack did " + cdmg3 + " damage to you.");

			if (uhp < 0) //if user hp is 0
			    System.out.println ("\nYou have 0 hp left.");
			else
			{
			    System.out.println ("\nThe witch has " + chp + " hp left.");
			    System.out.println ("You have " + uhp + " hp left.\n");
			}
			break;

		    case 4:
			System.out.println ("\nSucker Punch"); //attack 4

			int cdmg4 = 50; //damage
			uhp -= cdmg4;
			System.out.println ("This attack did " + cdmg4 + " damage to you.");

			if (uhp < 0) //if user hp is 0
			    System.out.println ("\nYou have 0 hp left.");
			else
			{
			    System.out.println ("\nThe witch has " + chp + " hp left.");
			    System.out.println ("You have " + uhp + " hp left.\n");
			}
			break;

		    default: //shows hp
			System.out.println ("\nThe witch has " + chp + " hp left.");
			System.out.println ("You have " + uhp + " hp left.\n");
		}
	    }
	}


	if (uhp > 0) //if user hp is greater than 0, then you win
	{
	    printSlow ("You have defeated the witch.");

	    printSlow ("\nYou win");
	    fightWinner ();
	}


	else if (chp > 0) //if witch hp is greater than 0, then you lose
	{
	    printSlow ("You have died.");

	    printSlow ("\nThe witch defeated you once again...");
	    fightLoser ();
	}


	else //if both hp are 0 than it is a tie
	{
	    printSlow ("\nIt's a tie. Fight again!");
	    fight (); //retry
	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = pokemonGlass.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
