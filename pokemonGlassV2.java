import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import sun.audio.*;

public class pokemonGlassV2 extends Applet implements ActionListener, KeyListener
{
    AudioClip soundFile;

    int uPoke = 0;
    int move = 0; //for your steps taken (if move%10 = 0 and your in tall grass fight will start with a wild pokemon
    int money = 0;
    int moneyR = 0;

    int i = 1;
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    CardLayout cdLayout = new CardLayout ();
    String choice, name = null, desc = null, pokemon = null, searchBy = null, region = null, type = null, species = null, habitat = null;
    String gender = " ";
    int pokeNo = 0;

    int row = 40;
    int col = 50;
    int total = row * col;

    JLabel x[] = new JLabel [total]; //grid1
    int screen = 0;

    String pics[] [] = new String [row] [col];
    String level1[] [] = {{"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "201", "201", "201", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "house1", "house2", "door", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "letter", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}};
    String level2[] [] = {{"tree3", "tree4", "tree3", "tree4", "river", "river", "river", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree1", "tree2", "river", "river", "river", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1"}, {"tree3", "tree4", "tree3", "tree4", "river", "river", "river", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "river", "river", "river", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "grass2", "grass2", "ground", "ground", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "grass2", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "grass2", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree1", "tree2", "grass2", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree3", "tree4", "grass2", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "flower", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "pTown", "pTown", "pTown", "pTown", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}};
    String level3[] [] = {{"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "mom", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "carpet", "carpet", "carpet", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}};

    int startPosX[] = {35, 14, 24, 2, 11, 44, 14};
    int startPosY[] = {24, 38, 38, 8, 38, 38, 38};
    int guyx = 0;
    int guyy = 0;

    String ins[] = new String [17];
    JButton storyline;
    JLabel professorPic;
    int n = 0; //counter for instructions by proffessor Oak

    JButton direction[] = new JButton [9];

    String pokeName1[] = {"Turtwig", "Chimchar", "Piplup"};
    int pic1[] = {10, 11, 12};
    String region1[] = {"Sinnoh", "Sinnoh", "Sinnoh"};
    int pokeNo1[] = {387, 390, 393};
    String species1[] = {"Tiny Leaf", "Chimp", "Penguin"};
    String type1[] = {"Grass", "Fire", "Water"};
    String habitat1[] = {"Lake-side", "Mountain", "Arctic"};
    String desc1[] = {"It undertakes photosynthesis with its body, making oxygen. The leaf on its head wilts if it is thirsty.", "Its fiery rear end is fueled by gas made in its belly. Even rain can't extinguish the fire.",
	"A poor walker, it often falls down. However, its strong pride makes it puff up its chest without a care."};
    int pokeLvl[] = {5, 5, 5};
    int pokeHp[] = {55, 44, 53};
    int lvl = 0;
    int hp = 0;

    String wildPokeName[] = {"Starly", "Bidoof", "Kricketot", "Shinx", "Abra", "Zubat", "Budew", "Geodude", "Gligar", "Ralts", "Riolu", "Cranidos", "Machop", "Pachirisu", "Heracross", "Drifloon", "Happiny", "Chatot", "Pichu", "Pikachu", "Gible", "Croagunk", "Duskull", "Swablu", "Togepi", "Moltres", "Articuno", "Zapdos", "Mewtwo", "Mew", "Uxie", "Mesprit", "Azelf", "Dialga", "Giratina", "Palkia", "Mega Lucario", "Rotom", "Manaphy", "Shiny Lugia", "Shiny Gyarados", "Shiny Charzard", "Shiny Articuno", "Magicarp", "Feebas", "Azurill", "Goldeen", "Buizel"};
    String cAtt1[] = {"Double Hit", "Double Hit", "Double Hit", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Tackle", "Double Slap", "Double Slap", "Double Slap", "Double Slap", "Double Slap", "Poison Jab", "Feint", "Wing Attack", "Tackle", "Flamethrower", "Ice Beam", "Thunder", "Psybeam", "Psybeam", "Psybeam", "Psybeam", "Psybeam", "Hidden Power", "Hidden Power", "Hidden Power", "Close Combat", "Ice Beam", "Bubble", "Wing Attack", "Hydro Pump", "Flamethrower", "Ice Beam", "Bubble", "Bubble", "Bubble", "Bubble", "Bubble"};
    int wildLvl[] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 5, 7, 5, 5, 6, 7, 7, 7, 7, 5, 6, 5, 5, 6, 60, 60, 60, 70, 70, 50, 50, 50, 70, 70, 70, 100, 20, 40, 99, 99, 99, 99, 99, 5, 6, 5, 6, 5};
    int wildHp[] = {40, 59, 37, 45, 25, 40, 40, 40, 65, 28, 40, 67, 70, 40, 80, 90, 100, 76, 30, 100, 58, 48, 20, 45, 35, 300, 300, 300, 350, 350, 200, 200, 200, 350, 350, 350, 500, 70, 250, 400, 400, 400, 400, 25, 45, 40, 35, 65};
    int wildNum[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};
    int counter = 0;

    int uDmg1 = 0;
    int uDmg2 = 0;
    int uDmg3 = 0;
    int cDmg = 0;

    String pokeNameBag[] = new String [50];
    int num = 0;

    String s = "Poke Bag \n";

    JProgressBar uP;
    JProgressBar eP;
    JProgressBar cP;

    JButton catching;

    JLabel wildPokePic;
    JLabel cName;
    JLabel cLvl;

    int cHp = 0;
    int exp = 0;
    double reqExp = Math.pow ((2 * pokeLvl [uPoke]), 1.5);

    public void init ()

    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	palletTown ();
	//Pokedex ();
	mainMenu ();
	Instructions ();
	//nameIn ();
	chimchar ();
	turtwig ();
	piplup ();
	stats ();
	fight ();
	startInst ();
	//route201 ();
	//house ();
	// caught ();
	resize (1000, 660);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void change (int assd)
    {
	pokeNameBag [num] = pokeName1 [assd];
	s = "Poke Bag \n";
	num++;
	for (int i = 0 ; i < num ; i++) //Pokemon bag
	    s += pokeNameBag [i] + "\n";
	uPoke = assd;
	i = pic1 [assd];
	region = region1 [assd];
	pokeNo = pokeNo1 [assd];
	species = species1 [assd];
	type = type1 [assd];
	habitat = habitat1 [assd];
	desc = desc1 [assd];
	lvl = pokeLvl [assd];
	hp = pokeHp [assd];
    }


    public void Pokedex ()
    {
	card1 = new Panel ();
	card1.setBackground (Color.black);
	card1.resize (700, 800);

	choice = JOptionPane.showInputDialog (null, "Do you know the name of the Starter Sinnoh Region Pokemon you are looking for? (Yes/No)", "Welcome to the Starter Pokedex!", 3);
	while (!choice.equalsIgnoreCase ("Yes") && !choice.equalsIgnoreCase ("No"))
	    choice = JOptionPane.showInputDialog ("Invalid Input. Do you know the name of the Starter Sinnoh Region Pokemon you are looking for? (Yes/No)");

	if (choice.equalsIgnoreCase ("yes"))
	{
	    pokemon = JOptionPane.showInputDialog (null, "Enter the name of the Starter Pokemon from the Sinnoh Region: ", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
	    Invalid ();
	}
	else
	{
	    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Sinnoh region: \n\nTurtwig \nChimchar \nPiplup \n\nWhich Pokemon would you like to search?", "Sinnoh Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
	    Invalid ();
	}

	if (pokemon.equalsIgnoreCase ("Turtwig"))
	    change (0);

	else if (pokemon.equalsIgnoreCase ("Chimchar"))
	    change (1);

	else if (pokemon.equalsIgnoreCase ("Piplup"))
	    change (2);


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
	choosen.setFont (new Font ("Courier New", Font.PLAIN, 15));
	choosen.setForeground (Color.white);
	p.add (choosen);

	JButton begin = new JButton ("Let's begin our Journey");
	begin.addActionListener (this);
	begin.setActionCommand ("begin");
	begin.setFont (new Font ("Courier New", Font.PLAIN, 12));
	begin.setForeground (Color.black);
	p.add (begin);

	card1.add (p);
	p_card.add ("1", card1);
    }


    public void palletTown ()
    {
	sound ();
	card2 = new Panel ();
	card2.setBackground (Color.black);
	card2.resize (1000, 600);

	JLabel title = new JLabel ("Pokemon");
	title.setFont (new Font ("Pokemon Solid", Font.PLAIN, 30));
	title.setForeground (Color.yellow);
	card2.add (title);

	Panel g1 = new Panel (new GridLayout (row, col, 0, 0));

	for (int i = 0 ; i < total ; i++)
	{
	    //  System.out.println ("Hi " + i);
	    x [i] = new JLabel (createImageIcon ("tree3.jpg"));
	    x [i].setPreferredSize (new Dimension (15, 15));
	    x [i].setIcon (createImageIcon ("tree3.jpg"));
	    //x[i].setBorderPainted(false);
	    g1.add (x [i]);
	}
	screen = 1;
	moveLevel ();
	redraw ();

	JButton mainmenu = new JButton ("Main Menu");
	mainmenu.setFont (new Font ("Courier New", Font.PLAIN, 12));
	mainmenu.setForeground (Color.gray);
	mainmenu.addActionListener (this);
	mainmenu.setActionCommand ("mainmenu");

	JButton bag = new JButton ("PokeBag");
	bag.setFont (new Font ("Courier New", Font.PLAIN, 12));
	bag.setForeground (Color.gray);
	bag.addActionListener (this);
	bag.setActionCommand ("bag");
	card2.add (bag);

	JButton fight = new JButton ("Fight");
	fight.setFont (new Font ("Courier New", Font.PLAIN, 12));
	fight.setForeground (Color.gray);
	fight.addActionListener (this);
	fight.setActionCommand ("fight");
	//card2.add (fight);

	Panel g2 = new Panel (new GridLayout (3, 3));
	for (int i = 0 ; i < direction.length ; i++)
	{
	    direction [i] = new JButton (createImageIcon ("10" + i + ".jpg"));
	    direction [i].addActionListener (this);
	    direction [i].addKeyListener (this);
	    direction [i].setActionCommand ("10" + i);
	    direction [i].setBackground (Color.white);
	    direction [i].setBorderPainted (false);
	    g2.add (direction [i]);
	}
	direction [0].setVisible (false);
	direction [2].setVisible (false);
	direction [4].setVisible (false);
	direction [6].setVisible (false);
	direction [8].setVisible (false);
	card2.add (mainmenu);
	card2.add (bag);
	card2.add (g1);
	card2.add (g2);
	p_card.add ("2", card2);

    }


    public void redraw ()
    {
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		x [m].setIcon (createImageIcon (pics [i] [j] + ".jpg"));
		m++;
	    }
	}
	if (gender.equalsIgnoreCase ("girl"))
	    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
	else
	    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
    }


    public void mainMenu ()
    {
	card3 = new Panel ();
	card3.setBackground (Color.black);

	JLabel main = new JLabel (createImageIcon ("main.jpg"));
	card3.add (main);

	JButton start = new JButton ("Click to Start");
	start.setFont (new Font ("Courier New", Font.PLAIN, 15));
	start.setForeground (Color.gray);
	start.addActionListener (this);
	start.setActionCommand ("start");
	card3.add (start);

	JButton load = new JButton ("Load Game");
	load.setFont (new Font ("Courier New", Font.PLAIN, 15));
	load.setForeground (Color.gray);
	load.addActionListener (this);
	load.setActionCommand ("load");
	card3.add (load);

	JButton inst = new JButton ("Instructions");
	inst.setFont (new Font ("Courier New", Font.PLAIN, 15));
	inst.setForeground (Color.gray);
	inst.addActionListener (this);
	inst.setActionCommand ("inst");
	card3.add (inst);

	p_card.add ("3", card3);

    }


    public void Instructions ()
    {
	card4 = new Panel ();
	card4.setBackground (Color.black);
	card4.resize (200, 500);

	professorPic = new JLabel (createImageIcon ("professor.jpg"));
	card4.add (professorPic);

	ins [0] = "Hello, there! Glad to meet you!";
	storyline = new JButton (ins [n]);
	storyline.setFont (new Font ("Courier New", Font.PLAIN, 15));
	storyline.setForeground (Color.black);
	storyline.addActionListener (this);
	storyline.setActionCommand ("storyline");
	storyline.setPreferredSize (new Dimension (700, 200));

	card4.add (storyline);
	p_card.add ("4", card4);

    }


    public void nameIn ()
    {
	card5 = new Panel ();
	card5.setBackground (Color.white);


	name = JOptionPane.showInputDialog ("What's your name?");

	p_card.add ("5", card5);

    }


    public void chimchar ()
    {
	card6 = new Panel ();
	card6.setBackground (Color.black);

	JLabel title = new JLabel ("Chimchar");
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("chimcharStats.jpg"));

	JButton back = new JButton ("Back");
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card6.add (title);
	card6.add (pic);
	card6.add (back);

	p_card.add ("6", card6);
    }


    public void turtwig ()
    {
	card7 = new Panel ();
	card7.setBackground (Color.black);

	JLabel title = new JLabel ("Turtwig");
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("turtwigStats.jpg"));

	JButton back = new JButton ("Back");
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card7.add (title);
	card7.add (pic);
	card7.add (back);
	p_card.add ("7", card7);
    }


    public void piplup ()
    {
	card8 = new Panel ();
	card8.setBackground (Color.black);

	JLabel title = new JLabel ("Piplup");
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("piplupStats.jpg"));

	JButton back = new JButton ("Back");
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card8.add (title);
	card8.add (pic);
	card8.add (back);
	p_card.add ("8", card8);

    }


    public void stats ()
    {
	card9 = new Panel ();
	card9.setBackground (Color.black);

	Panel statsButtons = new Panel ();

	JButton chimButton = new JButton (createImageIcon ("chimchar.jpg"));
	chimButton.addActionListener (this);
	chimButton.setActionCommand ("chimcharStats");
	statsButtons.add (chimButton);

	JButton turtwigButton = new JButton (createImageIcon ("turtwig.jpg"));
	turtwigButton.addActionListener (this);
	turtwigButton.setActionCommand ("turtwigStats");

	statsButtons.add (turtwigButton);

	JButton piplupButton = new JButton (createImageIcon ("piplup.jpg"));
	piplupButton.addActionListener (this);
	piplupButton.setActionCommand ("piplupStats");
	statsButtons.add (piplupButton);

	card9.add (statsButtons);

	JButton choose = new JButton ("Ready to choose the starter?");
	choose.addActionListener (this);
	choose.setActionCommand ("choose");
	choose.setFont (new Font ("Courier New", Font.PLAIN, 15));
	choose.setForeground (Color.black);

	card9.add (choose);

	p_card.add ("9", card9);
    }


    public void wildChange (int number)
    {
	/*String wildPokeName[] = {"Starly", "Bidoof", "Kricketot", "Shinx", "Abra", "Zubat", "Budew", "Geodude", "Gligar", "Ralts", "Riolu", "Cranidos", "Machop", "Pachirisu", "Heracross", "Drifloon", "Happiny", "Chatot", "Pichu", "Pikachu", "Gible", "Croagunk", "Duskull", "Swablu", "Togepi", "Moltres", "Articuno", "Zapdos", "Mewtwo", "Mew", "Uxie", "Mesprit", "Azelf", "Dialga", "Giratina", "Palkia", "Mega Lucario", "Rotom", "Manaphy", "Shiny Lugia", "Shiny Gyarados", "Shiny Charzard", "Shiny Articuno", "Magicarp", "Feebas", "Azurill", "Goldeen", "Buizel"};
	int wildLvl[] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 5, 7, 5, 5, 6, 7, 7, 7, 7, 5, 6, 5, 5, 6, 60, 60, 60, 70, 70, 50, 50, 50, 70, 70, 70, 100, 20, 40, 99, 99, 99, 99, 99, 5, 6, 5, 6, 5};
	int wildHp[] = {40, 59, 37, 45, 25, 40, 40, 40, 65, 28, 40, 67, 70, 40, 80, 90, 100, 76, 30, 100, 58, 48, 20, 45, 35, 300, 300, 300, 350, 350, 200, 200, 200, 350, 350, 350, 500, 70, 250, 400, 400, 400, 400, 25, 45, 40, 35, 65};
	int wildNum[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};
	int counter = 0;
	counter = wildNum [number];
	cHp = wildHp[number];*/
    }


    public void fight ()  //the fight
    {
	card10 = new Panel ();
	card10.setBackground (Color.black);

	counter = (int) (Math.random () * 15) + 0;
	cHp = wildHp [counter];

	Panel u = new Panel ();

	JLabel yourPokePic = new JLabel (createImageIcon (pic1 [uPoke] + ".jpg"));

	JLabel yourPokeName = new JLabel (pokeName1 [uPoke]);
	yourPokeName.setFont (new Font ("Courier New", Font.BOLD, 25));
	yourPokeName.setForeground (Color.white);

	JLabel yourPokeLvl = new JLabel ("Level " + pokeLvl [uPoke]);
	yourPokeLvl.setFont (new Font ("Courier New", Font.BOLD, 12));
	yourPokeLvl.setForeground (Color.white);

	u.add (yourPokePic);
	u.add (yourPokeName);
	u.add (yourPokeLvl);

	uP = new JProgressBar (0, 0, hp);
	uP.setValue (hp);
	uP.setStringPainted (true);

	eP = new JProgressBar (0, 0, exp);
	eP.setValue (exp);
	eP.setStringPainted (true);

	u.add (uP);

	JButton att1 = new JButton ("...");
	att1.addActionListener (this);
	att1.setActionCommand ("att1");
	att1.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att1.setForeground (Color.black);
	u.add (att1);

	JButton att2 = new JButton ("...");
	att2.addActionListener (this);
	att2.setActionCommand ("att2");
	att2.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att2.setForeground (Color.black);
	u.add (att2);

	JButton att3 = new JButton ("...");
	att3.addActionListener (this);
	att3.setActionCommand ("att3");
	att3.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att3.setForeground (Color.black);
	u.add (att3);

	catching = new JButton ("Catch " + wildPokeName [counter]);
	catching.addActionListener (this);
	catching.setActionCommand ("catching");
	catching.setFont (new Font ("Courier New", Font.PLAIN, 15));
	catching.setForeground (Color.black);
	catching.setEnabled (false);
	u.add (catching);

	Panel c = new Panel ();
	wildPokePic = new JLabel (createImageIcon ("wild" + (counter + 1) + ".jpg"));

	cName = new JLabel (wildPokeName [counter]);
	cName.setFont (new Font ("Courier New", Font.BOLD, 25));
	cName.setForeground (Color.white);

	cLvl = new JLabel ("Level " + wildLvl [counter]);
	cLvl.setFont (new Font ("Courier New", Font.BOLD, 12));
	cLvl.setForeground (Color.white);

	cP = new JProgressBar (0, 0, cHp);
	cP.setValue (cHp);
	cP.setStringPainted (true);

	c.add (wildPokePic);
	c.add (cName);
	c.add (cLvl);

	c.add (cP);

	card10.add (u);
	card10.add (c);

	p_card.add ("10", card10);
    }


    public void levelUp ()
    {
	if (exp == reqExp)
	    pokeLvl [uPoke]++;
	reqExp = Math.pow ((2 * pokeLvl [uPoke]), 1.5);
    }


    public void storyline ()
    {
	n++;

	if (n == 10)
	{
	    gender = JOptionPane.showInputDialog ("Now tell me. Are you a boy? Or are you a girl? (Boy/Girl) ");
	    while (!gender.equalsIgnoreCase ("Boy") && !gender.equalsIgnoreCase ("Girl"))
		gender = JOptionPane.showInputDialog ("Invalid Input. Are you a boy? Or are you a girl? (Boy/Girl) ");
	    name = JOptionPane.showInputDialog ("Let's begin with your name. What is it?");
	    String verify = JOptionPane.showInputDialog ("Are you sure you want " + name + " as your name? (Yes/No)");
	    while (!verify.equalsIgnoreCase ("Yes") && !verify.equalsIgnoreCase ("No"))
		verify = JOptionPane.showInputDialog ("Invalid Input. Are you sure you want " + name + " as your name? (Yes/No)");

	    while (verify.equalsIgnoreCase ("No"))
	    {
		name = JOptionPane.showInputDialog ("Then what is your name? ");
		verify = JOptionPane.showInputDialog ("Are you sure you want " + name + " as your name? (Yes/No) ");
		while (!verify.equalsIgnoreCase ("Yes") && !verify.equalsIgnoreCase ("No"))
		    verify = JOptionPane.showInputDialog ("Invalid Input. Are you sure you want " + name + " as your name? (Yes/No)");
	    }
	    n++;
	}

	if (n == 15)
	{
	    cdLayout.show (p_card, "9");
	    stats ();
	    n++;

	}
	if (n == 16)
	{
	    cdLayout.show (p_card, "9");
	    n = 0;
	}

	ins [1] = "Welcome to the world of Pokemon!";
	ins [2] = "My name is Oak.";
	ins [3] = "People affectionately refer to me as the Pokemon Professor.";
	ins [4] = "This world...";
	ins [5] = "... is inhabited far and wide by creatures called Pokemon.";
	ins [6] = "For some people, Pokemon are pets. Others use them for battling.";
	ins [7] = "As for myself...";
	ins [8] = "I study Pokemon as a profession.";
	ins [9] = "But first, tell me a little about yourself.";
	ins [10] = " ";
	ins [11] = "Right... So you are " + name + ".";
	ins [12] = "" + name + "!";
	ins [13] = "Your very own Pokemon legend is about to unfold!";
	ins [14] = "A world of dreams and adventures with Pokemon awaits! Let's go!";

	storyline.setText ("" + ins [n]);

	if (gender.equalsIgnoreCase ("Boy"))
	    professorPic.setIcon (createImageIcon ("male.jpg"));
	else if (gender.equalsIgnoreCase ("Girl"))
	    professorPic.setIcon (createImageIcon ("female.jpg"));
	else
	    professorPic.setIcon (createImageIcon ("professor.jpg"));
    }


    public void moveLevel ()
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (screen == 1)
		    pics [i] [j] = level1 [i] [j];
		else if (screen == 2)
		    pics [i] [j] = level2 [i] [j];
		else if (screen == 3)
		    pics [i] [j] = level3 [i] [j];

	    }
	}
	guyx = startPosX [screen - 1];
	guyy = startPosY [screen - 1];
	redraw ();
    }


    public void startInst ()
    {
	card11 = new Panel ();
	card11.setBackground (Color.black);

	JLabel instTitle = new JLabel ("Instructions");
	instTitle.setFont (new Font ("Courier New", Font.BOLD, 25));
	instTitle.setForeground (Color.white);

	JTextArea TA = new JTextArea ("This game revolves around adventure in the world of Pokémon.\n There are directional buttons on the right of the screen to move your character.\n The tall grass areas will have some Pokémons in them that you may choose to catch during the battle.\n\n Battles in this game are amongst two people who each try to knock out the opponent's Pokémon before the same is done to themselves.\n Pokémon do this using \"moves\" which can have several effects but most prominently they damage the opponent directly.\n\n Fight: This allows you to attack the enemy.\n Choose one move from a move pool of up to four moves, and you will attack your opponent with that move.\n Depending on the move you have chosen, it could either hit or miss.");

	JButton backMenu = new JButton ("Back to Menu");
	backMenu.addActionListener (this);
	backMenu.setActionCommand ("backMenu");
	backMenu.setFont (new Font ("Courier New", Font.PLAIN, 15));
	backMenu.setForeground (Color.black);

	card11.add (instTitle);
	card11.add (TA);
	card11.add (backMenu);
	p_card.add ("11", card11);

    }


    public void actionPerformed (ActionEvent e)
    {
	if (pics [guyy] [guyx].equals ("201"))
	{
	    screen = 2;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("pTown"))
	{
	    screen = 1;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("door"))
	{
	    screen = 3;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("carpet"))
	{
	    screen = 1;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("sgTown"))
	{
	    screen = 4;
	    guyy = 8;
	    guyx = 2;
	    readLevel (screen);
	    redraw ();
	}

	else if (pics [guyy] [guyx].equals ("centre3"))
	{
	    screen = 5;
	    guyy = 39;
	    guyx = 25;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("mart2"))
	{
	    screen = 6;
	    guyy = 38;
	    guyx = 11;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("202"))
	{
	    screen = 7;
	    guyy = 38;
	    guyx = 44;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("cave"))
	{
	    screen = 8;
	    guyy = 38;
	    guyx = 25;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("cDoor"))
	{
	    screen = 7;
	    guyy = 2;
	    guyx = 20;
	    readLevel (screen);
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("begin"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("mainmenu"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("start"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("load"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("inst"))
	{
	    resize (800, 400);
	    cdLayout.show (p_card, "11");
	}
	else if (e.getActionCommand ().equals ("chimcharStats"))
	    cdLayout.show (p_card, "6");
	else if (e.getActionCommand ().equals ("turtwigStats"))
	    cdLayout.show (p_card, "7");
	else if (e.getActionCommand ().equals ("piplupStats"))
	    cdLayout.show (p_card, "8");
	else if (e.getActionCommand ().equals ("back"))
	    cdLayout.show (p_card, "9");
	else if (e.getActionCommand ().equals ("backMenu"))
	{
	    resize (1000, 660);
	    cdLayout.show (p_card, "3");
	}
	//else if (e.getActionCommand ().equals ("fight"))
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("ground"))
	    cdLayout.show (p_card, "10");
	else if (pics [guyy] [guyx].equals ("letter"))
	    JOptionPane.showMessageDialog (null, "You are in Pallet Town.\n\nThere are wild pokemons in the tall grass.\nYou can't travel on the river and the trees.\nSome doors and paths will lead to other areas.\n\nEnjoy your time in Pokemon.", "Pokemon Info", JOptionPane.INFORMATION_MESSAGE);
	else if (pics [guyy] [guyx].equals ("mom"))
	    JOptionPane.showMessageDialog (null, "Hello" + name + "! Don't go into tall grass without some Pokemon.\nGood luck on your journey around this Pokemon world.", "Mom", JOptionPane.INFORMATION_MESSAGE);

	else if (e.getActionCommand ().equals ("101")) //up
	{
	    if (isValid (guyx, guyy - 1))
	    {
		guyy--;
		redraw ();
		if (screen == 3)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Up.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Up.jpg"));
		}
		else if (screen == 5)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Up.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Up.jpg"));
		}
		else if (screen == 6)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Up.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Up.jpg"));
		}
		else if (screen == 8)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Up.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Up.jpg"));
		}
		else
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Up.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Up.jpg"));
		}
		move++;
	    }

	    direction [1].setIcon (createImageIcon ("101.jpg"));

	} //end up-----------------------------------------------------------------

	else if (e.getActionCommand ().equals ("103")) //left
	{
	    if (isValid (guyx - 1, guyy))
	    {
		guyx--;
		redraw ();
		if (screen == 3)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Left.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Left.jpg"));
		}
		else if (screen == 5)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Left.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Left.jpg"));
		}
		else if (screen == 6)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Left.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Left.jpg"));
		}
		else if (screen == 8)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Left.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Left.jpg"));
		}
		else
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Left.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Left.jpg"));
		}
		move++;
	    }

	} //end left-----------------------------------------------------------------

	else if (e.getActionCommand ().equals ("105")) //right
	{
	    if (isValid (guyx + 1, guyy))
	    {
		guyx++;
		redraw ();
		if (screen == 3)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Right.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Right.jpg"));
		}
		else if (screen == 5)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Right.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Right.jpg"));
		}
		else if (screen == 6)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Right.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Right.jpg"));
		}
		else if (screen == 8)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Right.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Right.jpg"));
		}
		else
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Right.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Right.jpg"));
		}
		move++;
	    }

	} //end right-----------------------------------------------------------------


	else if (e.getActionCommand ().equals ("107")) //down
	{
	    if (isValid (guyx, guyy + 1))
	    {
		guyy++;
		redraw ();
		if (screen == 3)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
		}
		else if (screen == 5)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
		}
		else if (screen == 6)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
		}
		else if (screen == 8)
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
		}
		else
		{
		    if (gender.equalsIgnoreCase ("girl"))
			x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
		    else
			x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
		}
		move++;
	    }
	    /*
	    screen++;
	    readLevel(screen - 1);
	    redraw();
	    */
	}

	if (e.getActionCommand ().equals ("storyline"))
	    storyline ();

	if (e.getActionCommand ().equals ("choose"))
	{
	    Pokedex ();
	    cdLayout.show (p_card, "1");
	}


	if (e.getActionCommand ().equals ("bag"))
	{
	    s = "Poke Bag \n";
	    for (int i = 0 ; i < num ; i++) //Pokemon bag
		s += pokeNameBag [i] + "\n";
	    JOptionPane.showMessageDialog (null, s, "Your Poke Bag", JOptionPane.INFORMATION_MESSAGE);
	}

	// else if (pics [y] [x].equals ("ground"))
	// String heal = JOptionPane.showInputDialog (null, "Do you want to restore your Pokemons? ", "Pokemon Centre", JOptionPane.PLAIN_MESSAGE);

	uDmg1 = (int) (Math.random () * lvl) + 1;
	uDmg2 = (int) (Math.random () * lvl) + 1;
	uDmg3 = (int) (Math.random () * lvl) + 1;

	cDmg = (int) (Math.random () * wildLvl [counter]) + 1;

	if (e.getActionCommand ().equals ("att1"))
	{
	    JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + uDmg1 + "damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    cHp -= uDmg1;
	    cP.setValue (cHp);

	    JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + "damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    hp -= cDmg;
	    uP.setValue (hp);

	}


	else if (e.getActionCommand ().equals ("att2"))
	{
	    JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + uDmg2 + "damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    cHp -= uDmg2;
	    cP.setValue (cHp);

	    JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + "damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    hp -= cDmg;
	    uP.setValue (hp);
	}


	else if (e.getActionCommand ().equals ("att3"))
	{
	    JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + uDmg3 + "damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    cHp -= uDmg3;
	    cP.setValue (cHp);

	    JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    hp -= cDmg;
	    uP.setValue (hp);
	}

	if (cHp <= 4 && cHp > 0)
	    catching.setEnabled (true);
	if (e.getActionCommand ().equals ("catching"))
	{
	    pokeNameBag [num] = wildPokeName [counter];
	    num++;
	    JOptionPane.showMessageDialog (null, "You caught " + wildPokeName [counter], "catching " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    counter = (int) (Math.random () * 15) + 0;
	    cHp = wildHp [counter];
	    catching.setEnabled (false);
	    catching.setText ("Catch " + wildPokeName [counter]);
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setValue (cHp);
	    move++;
	    cdLayout.show (p_card, "2");
	}


	if (cHp <= 0)
	{
	    exp += 2 * wildLvl [counter];
	    eP.setValue (exp);
	    moneyR = (int) (Math.random () * 400) + 100;
	    JOptionPane.showMessageDialog (null, "You defeated " + wildPokeName [counter] + "\nYou gained " + exp + ". You recieved " + moneyR + ".", "Defeated " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    money += moneyR;
	    levelUp ();
	    move++;
	    cdLayout.show (p_card, "2");
	}
    }


    public void keyPressed (KeyEvent ev)
    {
	int key = ev.getKeyCode ();
	if (key == 38)
	    direction [1].doClick ();

	else if (key == 37)
	    direction [3].doClick ();

	else if (key == 39)
	    direction [5].doClick ();

	else if (key == 40)
	    direction [7].doClick ();
    }


    public void keyTyped (KeyEvent ev)
    {
    }


    public void keyReleased (KeyEvent ev)
    {
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = pokemonGlassV2.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public boolean isValid (int x, int y)
    {
	if (pics [y] [x].equals ("ground"))
	    return true;
	else if (pics [y] [x].equals ("door"))
	    return true;
	else if (pics [y] [x].equals ("grass1"))
	    return true;
	else if (pics [y] [x].equals ("grass2"))
	    return true;
	else if (pics [y] [x].equals ("grass3"))
	    return true;
	else if (pics [y] [x].equals ("grass4"))
	    return true;
	else if (pics [y] [x].equals ("grass5"))
	    return true;
	else if (pics [y] [x].equals ("grass6"))
	    return true;
	else if (pics [y] [x].equals ("grass7"))
	    return true;
	else if (pics [y] [x].equals ("flower"))
	    return true;
	else if (pics [y] [x].equals ("letter"))
	    return true;
	else if (pics [y] [x].equals ("201"))
	    return true;
	else if (pics [y] [x].equals ("202"))
	    return true;
	else if (pics [y] [x].equals ("center3"))
	    return true;
	else if (pics [y] [x].equals ("mart2"))
	    return true;
	else if (pics [y] [x].equals ("cave"))
	    return true;
	else if (pics [y] [x].equals ("pokeball"))
	    return true;
	else if (pics [y] [x].equals ("sgTown"))
	    return true;
	else if (pics [y] [x].equals ("cDoor"))
	    return true;
	else if (pics [y] [x].equals ("cFloor"))
	    return true;
	else if (pics [y] [x].equals ("pTown"))
	    return true;
	else if (pics [y] [x].equals ("floor"))
	    return true;
	else if (pics [y] [x].equals ("talk1"))
	    return true;
	else if (pics [y] [x].equals ("talk2"))
	    return true;
	else if (pics [y] [x].equals ("talk3"))
	    return true;
	else if (pics [y] [x].equals ("pcFloor"))
	    return true;
	else if (pics [y] [x].equals ("pcCarpet"))
	    return true;
	else if (pics [y] [x].equals ("mCarpet"))
	    return true;
	else if (pics [y] [x].equals ("mFloor"))
	    return true;
	else if (pics [y] [x].equals ("mom"))
	    return true;
	else if (pics [y] [x].equals ("carpet"))
	    return true;
	else
	    return false;
    }


    public void readLevel (int level)
    {
	String filename = "screen" + level + ".txt";
	int i = 0;
	int j = 0;
	int k = 0;
	BufferedReader in;
	try
	{
	    in = new BufferedReader (new FileReader (filename));
	    while (k < total)
	    {
		String input = in.readLine ();
		pics [i] [j] = input;
		j++;
		if (j >= col)
		{
		    j = 0;
		    i++;
		}
		k++;
	    }
	    in.close ();
	}
	catch (IOException e)
	{
	    System.out.println ("Error opening file " + e);
	}
    }


    public void Invalid ()
    {
	while (!pokemon.equalsIgnoreCase ("Turtwig") && !pokemon.equalsIgnoreCase ("Chimchar") && !pokemon.equalsIgnoreCase ("Piplup"))
	    pokemon = JOptionPane.showInputDialog (null, "That pokemon wasn't found. Try Again!\nHere are the list of Starter Pokemon that are from the Sinnoh region: \n\nTurtwig \nChimchar \nPiplup \n\nWhich Pokemon would you like to search?", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
    }


    public void battle ()
    {

    }


    public void talk1 ()
    {

    }


    public void sound ()
    {
	soundFile = getAudioClip (getDocumentBase (), "pokemon.mp3");
	//this attaches the sound file "pokemon.mp3"
	soundFile.loop ();
    }
}


