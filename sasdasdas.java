import java.awt.*;
import java.applet.*;
import java.io.*;
public class sasdasdas extends Applet
{
    int size = 10;
    int a[];
    public void init ()
    {
	a = new int [20];
	a [0] = 3;
	a [1] = 56;
	a [2] = 23;
	a [3] = 9;
	a [4] = 10;
	a [5] = 86;
	a [6] = 45;
	a [7] = 23;
	a [8] = 2;
	a [9] = 9;
	a [10] = 1;
	a [11] = 65;
	a [12] = 79;
	a [13] = 39;
	a [14] = 43;
	a [15] = 5;
	a [16] = 57;
	a [17] = 27;
	a [18] = 57;
	a [19] = 95;
    }

    public void printarray (int a[])
    {
	Graphics g = getGraphics ();
	g.setColor (Color.white);
	g.fillRect (0, 0, 500, 500);
	int x = 60;
	for (int i = 0 ; i < 20 ; i++)
	{
	    g.setColor (new Color (0, 255 - a [i] * 2, a [i] * 2));
	    g.fillRect (60, x, a [i] * 2, 10);
	    x += 12;
	}

    }
    public void paint (Graphics g)
    {
	g.setColor (Color.red);
	printarray (a);
    }


}
