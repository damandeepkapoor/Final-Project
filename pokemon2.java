import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class pokemon2 extends Applet implements ActionListener
{
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6;
    CardLayout cdLayout = new CardLayout ();
    String map1[] [] = {{"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house64", "house63", "house62", "house61", "house60", "house59", "house58", "house57", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house64", "house63", "house62", "house61", "house60", "house59", "house58", "house57", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house49", "house50", "house51", "house52", "house53", "house54", "house55", "house56", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house49", "house50", "house51", "house52", "house53", "house54", "house55", "house56", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "letter", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}};
    
    int row = 40;
    int col = 50;
    int total = row * col;

    public void init ()

    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	screen6 ();
	resize (750, 600);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    {
	card1 = new Panel ();
	card1.setBackground (Color.white);
	JLabel title = new JLabel ("Pokemon");

	JLabel x[] = new JLabel [10];
	for (int i = 0 ; i < 10 ; i++)
	{
	    x [i] = new JLabel (createImageIcon ("tree3.jpg"));
	    card1.add (x [i]);
	}
	title.setFont (new Font ("Arial", Font.BOLD, 30));
	title.setForeground (Color.red);
	
	card1.add (title);
	p_card.add ("1", card1);

    }


    public void screen2 ()
    {
	card2 = new Panel ();
	card2.setBackground (Color.white);
	

	p_card.add ("2", card2);

    }


    public void screen3 ()
    {
	card3 = new Panel ();
	card3.setBackground (Color.white);

	p_card.add ("3", card3);

    }


    public void screen4 ()
    {
	card4 = new Panel ();
	card4.setBackground (Color.white);

	p_card.add ("4", card4);

    }


    public void screen5 ()
    {
	card5 = new Panel ();
	card5.setBackground (Color.white);
	p_card.add ("5", card5);

    }


    public void screen6 ()
    {
	card6 = new Panel ();
	card6.setBackground (Color.white);
	p_card.add ("6", card6);

    }



    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals ("1"))
	    cdLayout.show (p_card, "1");
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
	java.net.URL imgURL = pokemon2.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
