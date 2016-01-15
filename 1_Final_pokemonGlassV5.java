/*Damandeep
January 13th, 2015
The purpose of this game is to provide Hadi and Ali Partovi with a teenage game that teens would love to play and learn how to code.
Picture URL:
1)http://cdn.wikimg.net/strategywiki/images/b/b6/Pokemon_FRLG_PalletTown.png
2)http://thumbs.dreamstime.com/x/arrow-direction-buttons-24501147.jpg
3)http://images2.fanpop.com/image/photos/8600000/sprites-pokemon-8690177-316-313.jpg
4)http://k09.kn3.net/1EC8847C5.png
5)http://cdn.bulbagarden.net/upload/thumb/5/5c/387Turtwig.png/250px-387Turtwig.png
6)http://assets22.pokemon.com/assets/cms2/img/pokedex/full/390.png
7)http://img1.wikia.nocookie.net/__cb20120204041851/pokemonlatino/es/images/b/b7/Piplup.gif
8)http://upload.wikimedia.org/wikipedia/en/7/76/Lucariomovieposter.JPG
9)http://fc06.deviantart.net/fs41/f/2009/018/6/2/Pallet_Town_by_CaptainArcane.jpg
10)http://pokemondb.net/pokedex/national
11)http://s255.photobucket.com/user/shnet/media/profesor.png.html
*/

import java.util.*;
import java.text.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import sun.audio.*; //music
import java.applet.AudioClip; //music
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class pokemonGlassV5 extends Applet implements ActionListener, KeyListener
{
    AudioClip music; //music

    JFrame f, fP, level;
    JLabel lvlStarter;

    JFrame loadingFrame;
    JProgressBar loading;

    int uPoke = 0; //your pokemon number in the starter pokemon array
    int move = 1; //for your steps taken (if move%10 = 0 and your in tall grass fight will start with a wild pokemon
    int money = 0; //Money you have in the game. Can be used in PokeMart.
    int moneyR = 0; //Money you recieve from battles.

    int i = 12; //used to show the picture of your pokemon
    Panel p_card; //the main panel
    Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12; //screens
    CardLayout cdLayout = new CardLayout (); //layout
    String choice, name = null, desc = null, pokemon = null, searchBy = null, region = null, type = null, species = null, habitat = null; //declaration of the starter pokemon info
    String gender = " "; //Declaration of gender variable used in Oak's speech
    int pokeNo = 0; //Number of the starter pokemon on the Pokedex

    String heal = " ";
    String pokeballBuy = " ";
    String potionBuy = " ";
    String verify = " ";

    int quantity = 0; //how many Pokeballs do u want
    int PokeballQ = 0; //pokeballs the user has
    int PotionQ = 0; //Potions the user has

    int max = 0; //your maximum amount the user can buy

    int totalCost = 0; //total cost of the pokeballs
    int pQuantity = 0; //how many potions do u want
    int tC = 0; //total cost of the potions

    int row = 40; //row declaration
    int col = 50; //column declaration
    int total = row * col; //total of the row*col

    JLabel x[] = new JLabel [total]; //grid for the game
    int screen = 0; //starting screen
    int catchMove = 0;

    String pics[] [] = new String [row] [col]; //the 2D array for the pictures on the grid
    String level1[] [] = {{"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "201", "201", "201", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house57", "house58", "house59", "house60", "house61", "house62", "house63", "house64", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house48", "house47", "house46", "house45", "house44", "house43", "house42", "house41", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house33", "house34", "house35", "house36", "house37", "house38", "house39", "house40", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house32", "house31", "house30", "house29", "house28", "house27", "house26", "house25", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house17", "house18", "house19", "house20", "house21", "house22", "house23", "house24", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "house16", "house15", "house14", "house13", "house12", "house11", "house10", "house9", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "house1", "house2", "house3", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "house1", "house2", "door", "house4", "house5", "house6", "house7", "house8", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "talk5", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "talk5", "letter", "talk5", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "talk5", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "river", "river", "river", "river", "river", "river", "river", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}};
    String level2[] [] = {{"tree3", "tree4", "tree3", "tree4", "river", "river", "river", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree1", "tree2", "river", "river", "river", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1"}, {"tree3", "tree4", "tree3", "tree4", "river", "river", "river", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3"}, {"tree1", "tree2", "tree5", "tree6", "river", "river", "river", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "flower", "flower", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "grass2", "grass2", "ground", "ground", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "tree5", "tree6", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "grass2", "ground", "ground", "sgTown"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "grass2", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "grass2", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "grass2", "ground", "ground", "grass2", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree1", "tree2", "grass2", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree3", "tree4", "grass2", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "grass2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass2", "grass2", "grass2", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "tree5", "tree6", "tree5", "tree6", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "ground", "ground", "ground", "flower", "flower", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "flower", "flower", "ground", "flower", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "grass1", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4"}, {"tree1", "tree2", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "ground", "ground", "ground", "ground", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}, {"tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "ground", "ground", "ground", "ground", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4", "tree3", "tree4"}, {"tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "pTown", "pTown", "pTown", "pTown", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2", "tree1", "tree2"}}; //screen 2
    String level3[] [] = {{"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall", "wall"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "talk4", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "talk4", "mom", "talk4", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "talk4", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}, {"floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "carpet", "carpet", "carpet", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor", "floor"}}; //screen3
    int startPosX[] = {35, 14, 24, 2, 11, 44, 14}; //x position of character depending on the map
    int startPosY[] = {24, 38, 38, 8, 38, 38, 38}; //y position of character depending on the map
    int guyx = 35; //x coordinate
    int guyy = 25; //y coordinate

    String ins[] = new String [17]; //the storyline array (Oak's Speech)
    JButton storyline; //button to go through instructions
    JLabel professorPic; //picture of the professor
    int n = 0; //counter for instructions by proffessor Oak

    JButton direction[] = new JButton [9]; //left/right/up/down buttons

    String pokeName1[] = {"Turtwig", "Chimchar", "Piplup"}; //Starter pokemon
    int pic1[] = {10, 11, 12}; //picture file names
    String region1[] = {"Sinnoh", "Sinnoh", "Sinnoh"}; //region of starters
    int pokeNo1[] = {387, 390, 393}; //number in the pokedex
    String species1[] = {"Tiny Leaf", "Chimp", "Penguin"}; //type of species
    String type1[] = {"Grass", "Fire", "Water"}; //type
    String habitat1[] = {"Lake-side", "Mountain", "Arctic"}; //habitat of starters
    String desc1[] = {"It undertakes photosynthesis with its body, making oxygen. The leaf on its head wilts if it is thirsty.", "Its fiery rear end is fueled by gas made in its belly. Even rain can't extinguish the fire.",
	"A poor walker, it often falls down. However, its strong pride makes it puff up its chest without a care."}; //description of the starters
    int pokeLvl[] = {5, 5, 5}; //starting level
    int pokeHp[] = {100, 100, 100}; //starting hp
    int lvl = 0; //lvl counter (changes once you battle)
    int hp = 100; //hp counter

    String wildPokeName[] = {"Starly", "Bidoof", "Kricketot", "Shinx", "Abra", "Zubat", "Budew", "Geodude", "Gligar", "Ralts", "Riolu", "Cranidos", "Machop", "Pachirisu", "Heracross", "Drifloon", "Happiny", "Chatot", "Pichu", "Pikachu", "Gible", "Croagunk", "Duskull", "Swablu", "Togepi", "Moltres", "Articuno", "Zapdos", "Mewtwo", "Mew", "Uxie", "Mesprit", "Azelf", "Dialga", "Giratina", "Palkia", "Mega Lucario", "Rotom", "Manaphy", "Shiny Lugia", "Shiny Gyarados", "Shiny Charzard", "Shiny Articuno"}; //wild pokemons you can catch (used in battle scene)
    int wildLvl[] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 5, 7, 5, 5, 6, 7, 7, 7, 7, 5, 6, 5, 5, 6, 60, 60, 60, 70, 70, 50, 50, 50, 70, 70, 70, 100, 20, 40, 99, 99, 99, 99}; //lvl of the wild pokemon
    int wildHp[] = {30, 40, 30, 35, 25, 30, 30, 30, 40, 28, 30, 40, 40, 30, 80, 90, 100, 76, 30, 100, 58, 48, 20, 45, 35, 300, 300, 300, 350, 350, 200, 200, 200, 350, 350, 350, 500, 70, 250, 400, 400, 400, 400}; //hp of wild pokemon
    int wildNum[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43}; //picture file names of wild pokemon
    int counter = 0; //wild pokemon radomizer

    int uDmg1 = 0; //attack 1's damage
    int uDmg2 = 0; //attack 2's damage
    int uDmg3 = 0; //attack 3's damage
    int cDmg = 0; //attack for wild pokemon

    String pokeNameBag[] = new String [50]; //your pokebag
    int num = 0; //starting value of the bag

    String s = "Poke Bag \n\n"; //used in the printing out of the pokebag

    JProgressBar uP; //hp of your pokemon
    JProgressBar eP; //exp of your pokemon
    JProgressBar cP; //hp of wild pokemon

    JButton catching; //catching the wild pokemon button

    JLabel wildPokePic; //picture of wild pokemon
    JLabel cName; //name of wild pokemon
    JLabel cLvl; //level of wild pokemon
    int cHp = 0; //wild pokemon hp

    int exp = 1; //exp counter
    int reqExp = (pokeLvl [uPoke] * 10) / 2; //required exp

    JButton load, potion, done;

    JLabel yourPokePic; //your pokemon picture
    JLabel yourPokeName; //your pokemon name
    JLabel yourPokeLvl; //your pokemon lvl

    JPasswordField p; //password field

    JButton att1, att2, att3;
    JButton save;


    public void init ()  //init method

    {
	loadingMethod ();
	music = getAudioClip (getDocumentBase (), "pokemon.wav");
	music.loop ();

	p_card = new Panel ();
	p_card.setLayout (cdLayout);

	password ();
	mainMenu ();
	palletTown (); //game screen
	//Pokedex ();
	Instructions ();
	chimchar ();
	turtwig ();
	piplup ();
	stats ();
	startInst ();
	fight (); //battle with wild pokemon

	resize (400, 500); //resized
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void loadingMethod ()
    {
	loadingFrame = new JFrame ("Loading...");
	loading = new JProgressBar (0, 100);
	loading.setStringPainted (true);
	loadingFrame.getContentPane ().add (loading, BorderLayout.CENTER);
	loadingFrame.setSize (500, 80);
	loadingFrame.setVisible (true);
	loadingFrame.setLocationRelativeTo (null);
	loadingFrame.setDefaultCloseOperation (0);

	for (int i = 0 ; i < 10 ; i++)
	{
	    try
	    {
		Thread.sleep (250);
		loading.setValue (loading.getValue () + 10);

	    }
	    catch (Exception e1)
	    {

	    }
	}
	loadingFrame.dispose ();

    }


    public void change (int assd)  //your starter pokemon choice
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


    public void Pokedex ()  //choosing the starter pokemon
    {
	card1 = new Panel ();
	card1.setBackground (Color.black);
	card1.resize (700, 800);

	choice = JOptionPane.showInputDialog (null, "Do you know the name of the Starter Sinnoh Region Pokemon you are looking for? (Yes/No)", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
	while (!choice.equalsIgnoreCase ("Yes") && !choice.equalsIgnoreCase ("No"))
	    choice = JOptionPane.showInputDialog (null, "Invalid Input. Do you know the name of the Starter Sinnoh Region Pokemon you are looking for? (Yes/No)", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);

	if (choice.equalsIgnoreCase ("yes"))
	{
	    pokemon = JOptionPane.showInputDialog (null, "Enter the name of the Starter Pokemon from the Sinnoh Region: ", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
	    Invalid ();
	}
	else
	{
	    pokemon = JOptionPane.showInputDialog (null, "Here are the list of Starter Pokemon that are from the Sinnoh region: \n\nChimchar \nTurtwig \nPiplup \n\nWhich Pokemon would you like to search?", "Sinnoh Starter Pokemon", JOptionPane.PLAIN_MESSAGE);
	    Invalid ();
	}

	if (pokemon.equalsIgnoreCase ("Turtwig"))
	    change (0);

	else if (pokemon.equalsIgnoreCase ("Chimchar"))
	    change (1);

	else if (pokemon.equalsIgnoreCase ("Piplup"))
	    change (2);


	JOptionPane.showMessageDialog (null, "* * * Pokemon * * * \n \n" //description of the starter
		+ "" + "Pokemon: " + pokemon + "\nRegion: " + region + "\nNational Pokemon #: " + pokeNo + "\nSpecies: " + species + "\nType: " + type + "\nHabitat: " + habitat + "\nDescription: " + desc, "Pokedex Results", JOptionPane.INFORMATION_MESSAGE);

	JLabel title = new JLabel ("Starter Pokemon"); //title
	title.setFont (new Font ("Pokemon Solid", Font.PLAIN, 100));
	title.setForeground (Color.yellow);

	card1.add (title);

	JLabel pic = new JLabel (createImageIcon (i + ".jpg")); //picture of the pokemon you choose
	card1.add (pic);

	Panel p = new Panel ();

	JLabel choosen = new JLabel ("You have choosen " + pokemon + " to be your starter pokemon!"); //statement about who you chose
	choosen.setFont (new Font ("Courier New", Font.PLAIN, 15));
	choosen.setForeground (Color.white);
	p.add (choosen);

	JButton begin = new JButton ("Let's begin our Journey"); //button that leads to game screen
	begin.addActionListener (this);
	begin.setActionCommand ("begin");
	begin.setFont (new Font ("Courier New", Font.PLAIN, 12));
	begin.setForeground (Color.black);
	p.add (begin);

	card1.add (p);
	p_card.add ("1", card1);
    }


    public void palletTown ()  //game screen
    {
	card2 = new Panel ();
	card2.setBackground (Color.black);
	card2.resize (1000, 600);

	JLabel title = new JLabel ("Pokemon"); //title
	title.setFont (new Font ("Pokemon Solid", Font.PLAIN, 30));
	title.setForeground (Color.yellow);
	card2.add (title);

	Panel g1 = new Panel (new GridLayout (row, col, 0, 0)); //grid layout

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
	moveLevel (); //sets up the grid we are using
	redraw ();

	JButton mainmenu = new JButton ("Main Menu"); //back to the main menu
	mainmenu.setFont (new Font ("Courier New", Font.PLAIN, 12));
	mainmenu.setForeground (Color.gray);
	mainmenu.addActionListener (this);
	mainmenu.setActionCommand ("mainmenu");

	JButton bag = new JButton ("PokeBag"); //your pokebag
	bag.setFont (new Font ("Courier New", Font.PLAIN, 12));
	bag.setForeground (Color.gray);
	bag.addActionListener (this);
	bag.setActionCommand ("bag");
	card2.add (bag);

	Panel g2 = new Panel (new GridLayout (3, 3));
	for (int i = 0 ; i < direction.length ; i++) //buttons for direction
	{
	    direction [i] = new JButton (createImageIcon ("10" + i + ".jpg"));
	    direction [i].addActionListener (this);
	    direction [i].addKeyListener (this);
	    direction [i].setActionCommand ("10" + i);
	    direction [i].setBackground (Color.white);
	    direction [i].setBorderPainted (false);
	    direction [i].setFocusable (true);
	    direction [i].requestFocus (true);
	    g2.add (direction [i]);
	}
	direction [0].setVisible (false);
	direction [2].setVisible (false);
	direction [4].setVisible (false);
	direction [6].setVisible (false);
	direction [8].setVisible (false);

	save = new JButton ("Save Game");
	save.addActionListener (this);
	save.setActionCommand ("save");


	card2.add (mainmenu);
	card2.add (bag);
	card2.add (g1);
	card2.add (g2);
	card2.add (save);
	p_card.add ("2", card2);

    }


    public void redraw ()  //redraw the right screen
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
	if (gender.equalsIgnoreCase ("girl")) //if your a girl then a girl icon is printed
	    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down.jpg"));
	else //if your a boy then a boy icon is printed
	    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down.jpg"));
    }


    public void mainMenu ()  //main menu
    {
	card3 = new Panel ();
	card3.setBackground (Color.black);

	JLabel title = new JLabel ("Main Menu"); //title
	title.setFont (new Font ("Courier New", Font.PLAIN, 30));
	title.setForeground (Color.blue);
	card3.add (title);

	JLabel main = new JLabel (createImageIcon ("main.jpg")); //picture
	card3.add (main);

	JButton start = new JButton ("Click to Start"); //new game will start
	start.setFont (new Font ("Courier New", Font.PLAIN, 15));
	start.setForeground (Color.gray);
	start.addActionListener (this);
	start.setActionCommand ("start");
	card3.add (start);

	load = new JButton ("Load Game"); //starts from game screen, loads the game where you left it
	load.setFont (new Font ("Courier New", Font.PLAIN, 15));
	load.setForeground (Color.gray);
	load.addActionListener (this);
	load.setActionCommand ("load");
	load.setEnabled (false);
	card3.add (load);

	JButton inst = new JButton ("Instructions"); //leads to instructions screen
	inst.setFont (new Font ("Courier New", Font.PLAIN, 15));
	inst.setForeground (Color.gray);
	inst.addActionListener (this);
	inst.setActionCommand ("inst");
	card3.add (inst);

	p_card.add ("3", card3);
    }


    public void Instructions ()  //Instructions by Professor Oak
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


    public void password ()  //password screen
    {
	card5 = new Panel ();
	card5.setBackground (Color.black);

	Date now = new Date ();
	DateFormat df = DateFormat.getDateInstance ();
	String date = df.format (now);

	JLabel dateIn = new JLabel (date);
	dateIn.setFont (new Font ("Courier New", Font.BOLD, 25));
	dateIn.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("password.jpg"));

	p = new JPasswordField (7);

	done = new JButton ("Done");
	done.setActionCommand ("Done");
	done.addActionListener (this);
	done.addKeyListener (this);
	done.setFocusable (true);
	done.requestFocus (true);

	card5.add (dateIn);
	card5.add (pic);
	card5.add (p);
	card5.add (done);
	p_card.add ("5", card5);

    }


    public void chimchar ()  //Chimchar stats
    {
	card6 = new Panel ();
	card6.setBackground (Color.black);

	JLabel title = new JLabel ("Chimchar"); //title
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("chimcharStats.jpg")); //pic for stats

	JButton back = new JButton ("Back"); //back to the stats menu
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card6.add (title);
	card6.add (pic);
	card6.add (back);

	p_card.add ("6", card6);
    }


    public void turtwig ()  //Turtwig stats
    {
	card7 = new Panel ();
	card7.setBackground (Color.black);

	JLabel title = new JLabel ("Turtwig"); //title
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("turtwigStats.jpg")); //pic for stats

	JButton back = new JButton ("Back"); //back to the stats menu
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card7.add (title);
	card7.add (pic);
	card7.add (back);
	p_card.add ("7", card7);
    }


    public void piplup ()  //Piplup stats
    {
	card8 = new Panel ();
	card8.setBackground (Color.black);

	JLabel title = new JLabel ("Piplup"); //title
	title.setFont (new Font ("Courier New", Font.BOLD, 25));
	title.setForeground (Color.white);

	JLabel pic = new JLabel (createImageIcon ("piplupStats.jpg")); //pic for stats

	JButton back = new JButton ("Back"); //back to the stats menu
	back.addActionListener (this);
	back.setActionCommand ("back");
	back.setFont (new Font ("Courier New", Font.PLAIN, 15));
	back.setForeground (Color.black);

	card8.add (title);
	card8.add (pic);
	card8.add (back);
	p_card.add ("8", card8);

    }


    public void stats ()  //stats menu
    {
	card9 = new Panel ();
	card9.setBackground (Color.black);

	Panel statsButtons = new Panel ();

	JButton chimButton = new JButton (createImageIcon ("chimchar.jpg")); //chimchar stats
	chimButton.addActionListener (this);
	chimButton.setActionCommand ("chimcharStats");
	statsButtons.add (chimButton);

	JButton turtwigButton = new JButton (createImageIcon ("turtwig.jpg")); //turtwig stats
	turtwigButton.addActionListener (this);
	turtwigButton.setActionCommand ("turtwigStats");

	statsButtons.add (turtwigButton);

	JButton piplupButton = new JButton (createImageIcon ("piplup.jpg")); //piplup stats
	piplupButton.addActionListener (this);
	piplupButton.setActionCommand ("piplupStats");
	statsButtons.add (piplupButton);

	card9.add (statsButtons);

	JButton choose = new JButton ("Ready to choose the starter?"); //leads to the pokedex
	choose.addActionListener (this);
	choose.setActionCommand ("choose");
	choose.setFont (new Font ("Courier New", Font.PLAIN, 15));
	choose.setForeground (Color.black);

	card9.add (choose);

	p_card.add ("9", card9);
    }


    public void fight ()  //the fight
    {
	card10 = new Panel ();
	card10.setBackground (Color.black);

	counter = (int) (Math.random () * 15) + 0;
	cHp = wildHp [counter];

	Panel u = new Panel (); //your pokemon nad attacks and Progress bar panel

	yourPokePic = new JLabel (createImageIcon (i + ".jpg")); //picture of your pokemon

	yourPokeName = new JLabel (pokeName1 [uPoke]); //name of your pokemon
	yourPokeName.setFont (new Font ("Courier New", Font.BOLD, 25));
	yourPokeName.setForeground (Color.white);

	yourPokeLvl = new JLabel ("Level " + pokeLvl [uPoke]); //level of your pokemon
	yourPokeLvl.setFont (new Font ("Courier New", Font.BOLD, 12));
	yourPokeLvl.setForeground (Color.white);

	u.add (yourPokePic);
	u.add (yourPokeName);
	u.add (yourPokeLvl);

	f = new JFrame ("Health");
	f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Container content = f.getContentPane ();
	uP = new JProgressBar ();
	uP.setValue (hp);
	uP.setStringPainted (true);
	Border border = BorderFactory.createTitledBorder ("Hp...");
	uP.setBorder (border);
	content.add (uP, BorderLayout.NORTH);
	f.setSize (300, 100);
	f.setVisible (true);

	fP = new JFrame ("EXP");
	fP.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Container content2 = fP.getContentPane ();
	eP = new JProgressBar ();
	eP.setValue (exp);
	eP.setStringPainted (true);
	Border border2 = BorderFactory.createTitledBorder ("Exp...");
	eP.setBorder (border2);
	content2.add (eP, BorderLayout.NORTH);
	fP.setSize (300, 100);
	fP.setVisible (true);

	level = new JFrame ("Level");
	level.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Container content3 = level.getContentPane ();
	lvlStarter = new JLabel ("You don't currently have any Pokemons...");
	Border border3 = BorderFactory.createTitledBorder ("Level");
	lvlStarter.setBorder (border3);
	content3.add (lvlStarter, BorderLayout.NORTH);
	level.setSize (300, 100);
	level.setVisible (true);

	att1 = new JButton ("Tackle"); //attack1
	att1.addActionListener (this);
	att1.setActionCommand ("att1");
	att1.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att1.setForeground (Color.black);
	u.add (att1);

	att2 = new JButton ("Double Slap"); //attack2
	att2.addActionListener (this);
	att2.setActionCommand ("att2");
	att2.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att2.setForeground (Color.black);
	u.add (att2);

	att3 = new JButton ("Hidden Power"); //attack3
	att3.addActionListener (this);
	att3.setActionCommand ("att3");
	att3.setFont (new Font ("Courier New", Font.PLAIN, 15));
	att3.setForeground (Color.black);
	u.add (att3);

	catching = new JButton ("Throw Pokeball"); //catch the pokemon
	catching.addActionListener (this);
	catching.setActionCommand ("catching");
	catching.setFont (new Font ("Courier New", Font.PLAIN, 15));
	catching.setForeground (Color.black);
	catching.setEnabled (false);

	potion = new JButton ("Use Potion"); //catch the pokemon
	potion.addActionListener (this);
	potion.setActionCommand ("potion");
	potion.setFont (new Font ("Courier New", Font.PLAIN, 15));
	potion.setForeground (Color.black);
	potion.setEnabled (false);
	u.add (potion);
	u.add (catching);

	Panel c = new Panel (); //wild pokemon and attacks and Progress bar panel

	wildPokePic = new JLabel (createImageIcon ("wild" + (counter + 1) + ".jpg")); //picture of wild pokemon

	cName = new JLabel (wildPokeName [counter]); //name of wild pokemon
	cName.setFont (new Font ("Courier New", Font.BOLD, 25));
	cName.setForeground (Color.white);

	cLvl = new JLabel ("Level " + wildLvl [counter]); //level of wild pokemon
	cLvl.setFont (new Font ("Courier New", Font.BOLD, 12));
	cLvl.setForeground (Color.white);

	cP = new JProgressBar (0, 0, cHp); //hp of wild pokemon
	cP.setValue (cHp);
	cP.setStringPainted (true);
	cP.setPreferredSize (new Dimension (150, 20));
	cP.setForeground (Color.red);

	c.add (wildPokePic);
	c.add (cName);
	c.add (cLvl);

	c.add (cP);

	card10.add (u);
	card10.add (c);

	p_card.add ("10", card10);
    }


    public void levelUp ()  //your pokemon leveling up
    {
	if (exp >= reqExp)
	{
	    hp = pokeHp [uPoke];
	    pokeLvl [uPoke]++;
	    pokeHp [uPoke] = hp + pokeLvl [uPoke];

	    reqExp = (pokeLvl [uPoke] * 10) / 2; //changes the requirements after you level up
	    exp = 1;
	    uP.setMaximum (hp);
	    eP.setMaximum (reqExp);
	    eP.setValue (exp);
	    JOptionPane.showMessageDialog (null, "Your pokemon leveled up to " + pokeLvl [uPoke], "Leveled Up", JOptionPane.INFORMATION_MESSAGE);

	    if (pokeName1 [uPoke].equalsIgnoreCase ("chimchar") && pokeLvl [uPoke] == 14)
	    {
		pokeName1 [uPoke] = "Monferno";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 13;
		att1.setText ("Flamethrower");
		att2.setText ("Ember");
		att3.setText ("Double Hit");
	    }
	    else if (pokeName1 [uPoke].equalsIgnoreCase ("turtwig") && pokeLvl [uPoke] == 18)
	    {
		pokeName1 [uPoke] = "Grotle";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 14;
		att1.setText ("Leaf Storm");
		att2.setText ("Giga Drain");
		att3.setText ("Leech Seed");
	    }
	    else if (pokeName1 [uPoke].equalsIgnoreCase ("piplup") && pokeLvl [uPoke] == 16)
	    {
		pokeName1 [uPoke] = "Prinplup";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 15;
		att1.setText ("Bubble Beam");
		att2.setText ("Whirlpool");
		att3.setText ("Hydro Pump");
	    }
	    else if (pokeName1 [uPoke].equalsIgnoreCase ("Monferno") && pokeLvl [uPoke] == 36)
	    {
		pokeName1 [uPoke] = "Infernape";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 16;
		att1.setText ("Flare Blitz");
		att2.setText ("Mach Punch");
		att3.setText ("Close Combat");
	    }
	    else if (pokeName1 [uPoke].equalsIgnoreCase ("Grotle") && pokeLvl [uPoke] == 32)
	    {
		pokeName1 [uPoke] = "Torterra";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 17;
		att1.setText ("Razor Leaf");
		att2.setText ("Mega Drain");
		att3.setText ("Earthquake");
	    }

	    else if (pokeName1 [uPoke].equalsIgnoreCase ("Prinplup") && pokeLvl [uPoke] == 36)
	    {
		pokeName1 [uPoke] = "Empoleon";
		JOptionPane.showMessageDialog (null, "Your pokemon evolved to " + pokeName1 [uPoke], "Evolving", JOptionPane.INFORMATION_MESSAGE);
		i = 18;
		att1.setText ("Brine");
		att2.setText ("Aqua Jet");
		att3.setText ("Metal Claw");
	    }
	    yourPokePic.setIcon (createImageIcon (i + ".jpg"));
	    yourPokeLvl.setText ("Level " + pokeLvl [uPoke]); //level of your pokemon
	    yourPokeName.setText (pokeName1 [uPoke]); //name of your pokemon
	    lvlStarter.setText ("Your " + pokeName1 [uPoke] + " is level: " + pokeLvl [uPoke]);

	}
    }


    public void storyline ()  //Oak's Speech
    {
	n++;

	if (n == 10)
	{
	    gender = JOptionPane.showInputDialog (null, "Now tell me. Are you a boy? Or are you a girl? (Boy/Girl) ", "Gender", JOptionPane.PLAIN_MESSAGE);
	    while (!gender.equalsIgnoreCase ("Boy") && !gender.equalsIgnoreCase ("Girl"))
		gender = JOptionPane.showInputDialog (null, "Invalid Input. Are you a boy? Or are you a girl? (Boy/Girl)", "Gender", JOptionPane.PLAIN_MESSAGE);
	    name = JOptionPane.showInputDialog (null, "Let's begin with your name. What is it?", "Name", JOptionPane.PLAIN_MESSAGE);
	    verify = JOptionPane.showInputDialog (null, "Are you sure you want " + name + " as your name? (Yes/No)", "Name", JOptionPane.PLAIN_MESSAGE);
	    while (!verify.equalsIgnoreCase ("Yes") && !verify.equalsIgnoreCase ("No"))
		verify = JOptionPane.showInputDialog (null, "Invalid Input. Are you sure you want " + name + " as your name? (Yes/No)", "Name", JOptionPane.PLAIN_MESSAGE);

	    while (verify.equalsIgnoreCase ("No"))
	    {
		name = JOptionPane.showInputDialog (null, "Then what is your name? ", "Name", JOptionPane.PLAIN_MESSAGE);
		verify = JOptionPane.showInputDialog (null, "Are you sure you want " + name + " as your name? (Yes/No) ", "Name", JOptionPane.PLAIN_MESSAGE);
		while (!verify.equalsIgnoreCase ("Yes") && !verify.equalsIgnoreCase ("No"))
		    verify = JOptionPane.showInputDialog (null, "Invalid Input. Are you sure you want " + name + " as your name? (Yes/No)", "Name", JOptionPane.PLAIN_MESSAGE);
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


    public void moveLevel ()  //changes screen
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
	redraw ();
    }


    public void startInst ()  //Starting instructions page
    {
	card11 = new Panel ();
	card11.setBackground (Color.black);

	JLabel instTitle = new JLabel ("Instructions");
	instTitle.setFont (new Font ("Courier New", Font.BOLD, 25));
	instTitle.setForeground (Color.white);

	JTextArea TA = new JTextArea ("This game revolves around adventure in the world of Pokémon.\n There are directional buttons on the right of the screen to move your character.\n The tall grass areas will have some Pokémons in them that you may choose to catch during the battle.\n\n Battles in this game are amongst two people who each try to knock out the opponent's Pokémon before the same is done to themselves.\n Pokémon do this using \"moves\" which can have several effects but most prominently they damage the opponent directly.\n\n Fight: This allows you to attack the enemy.\n Choose one move from a move pool of up to four moves, and you will attack your opponent with that move.\n Depending on the move you have chosen, it could either hit or miss.");

	JButton backMenu = new JButton ("Back to Menu"); //Leads to main menu
	backMenu.addActionListener (this);
	backMenu.setActionCommand ("backMenu");
	backMenu.setFont (new Font ("Courier New", Font.PLAIN, 15));
	backMenu.setForeground (Color.black);

	card11.add (instTitle);
	card11.add (TA);
	card11.add (backMenu);
	p_card.add ("11", card11);

    }


    public void actionPerformed (ActionEvent e)  //Action performed method
    {
	yourPokePic.setIcon (createImageIcon (i + ".jpg")); //picture of your pokemon
	yourPokeLvl.setText ("Level " + pokeLvl [uPoke]); //level of your pokemon
	yourPokeName.setText (pokeName1 [uPoke]); //name of your pokemon

	catchMove++; //counter of catching your pokemon

	if (hp <= 0) //if your hp is 0 or less than you go to the Pokemon Center
	{
	    eP.setValue (exp);
	    screen = 5;
	    guyy = 16;
	    guyx = 25;
	    move++;
	    readLevel (screen);
	    redraw ();
	    cdLayout.show (p_card, "2");
	    JOptionPane.showMessageDialog (null, "You have been defeated and have been rushed to the Pokemon Centre.\n You have been healed by the PokeLady!", "Lose the battle", JOptionPane.INFORMATION_MESSAGE);
	    hp = pokeHp [uPoke];
	    uP.setValue (hp);
	}
	//changes screens once you move to the exit
	else if (pics [guyy] [guyx].equals ("201") && screen == 1) //goes from screen 1 to screen 2
	{
	    screen = 2;
	    guyy = 38;
	    guyx = 14;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("pTown")) //screen 2 to screen 1
	{
	    screen = 1;
	    guyy = 2;
	    guyx = 24;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("door")) //screen 1 to screen 3
	{
	    screen = 3;
	    guyy = 38;
	    guyx = 25;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("carpet")) //screen 3 to screen 1
	{
	    screen = 1;
	    guyy = 14;
	    guyx = 40;
	    moveLevel ();
	}

	else if (pics [guyy] [guyx].equals ("sgTown") && screen == 2) //screen 2 to screen 4
	{
	    screen = 4;
	    guyy = 8;
	    guyx = 2;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("201") && screen == 4) //screen 4 to screen 2
	{
	    screen = 2;
	    guyy = 8;
	    guyx = 48;
	    moveLevel ();
	}
	else if (pics [guyy] [guyx].equals ("center3")) //screen 4 to screen 5
	{
	    screen = 5;
	    guyy = 38;
	    guyx = 25;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("pcCarpet")) //screen 5 to screen 4
	{
	    screen = 4;
	    guyy = 24;
	    guyx = 18;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("mart2")) //screen 4 to screen 6
	{
	    screen = 6;
	    guyy = 38;
	    guyx = 11;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("mCarpet")) //screen 6 to screen 4
	{
	    screen = 4;
	    guyy = 25;
	    guyx = 28;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("202")) //screen 4 to screen 7
	{
	    screen = 7;
	    guyy = 38;
	    guyx = 44;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("sgTown") && screen == 7) //screen 7 to screen 4
	{
	    screen = 4;
	    guyy = 3;
	    guyx = 44;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("cave")) //screen 7 to screen 8
	{
	    screen = 8;
	    guyy = 38;
	    guyx = 25;
	    readLevel (screen);
	    redraw ();
	}
	else if (pics [guyy] [guyx].equals ("cDoor")) //screen 8 to screen 7
	{
	    screen = 7;
	    guyy = 2;
	    guyx = 21;
	    readLevel (screen);
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("begin")) //begin button leads to game screen
	{
	    resize (950, 660);
	    lvlStarter.setText ("Your " + pokeName1 [uPoke] + " is level: " + pokeLvl [uPoke]);
	    cdLayout.show (p_card, "2");
	}
	else if (e.getActionCommand ().equals ("mainmenu"))  //main menu leads to the main menu
	{
	    resize (500, 600);
	    cdLayout.show (p_card, "3");
	}
	else if (e.getActionCommand ().equals ("start"))  //new game
	{
	    load.setEnabled (true);
	    s = "Poke Bag \n\n";
	    professorPic.setIcon (createImageIcon ("professor.jpg"));
	    screen = 1;
	    moveLevel ();
	    guyx = 35;
	    guyy = 25;

	    lvl = 0; //lvl counter (changes once you battle)
	    hp = 100; //hp counter
	    exp = 1; //exp counter
	    reqExp = (pokeLvl [uPoke] * 10) / 2; //required exp

	    resize (1000, 660);
	    cdLayout.show (p_card, "4");
	}
	else if (e.getActionCommand ().equals ("load"))  //load leads to main screen
	{
	    resize (1000, 660);
	    cdLayout.show (p_card, "2");
	}
	else if (e.getActionCommand ().equals ("inst"))  //instruction screen
	{
	    resize (800, 400);
	    cdLayout.show (p_card, "11");
	}
	else if (e.getActionCommand ().equals ("chimcharStats")) //stats
	    cdLayout.show (p_card, "6");
	else if (e.getActionCommand ().equals ("turtwigStats")) //stats
	    cdLayout.show (p_card, "7");
	else if (e.getActionCommand ().equals ("piplupStats")) //stats
	    cdLayout.show (p_card, "8");
	else if (e.getActionCommand ().equals ("back")) //back to the stats menu
	    cdLayout.show (p_card, "9");
	else if (e.getActionCommand ().equals ("backMenu")) //back to the main menu
	{
	    resize (500, 600);
	    cdLayout.show (p_card, "3");
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass1")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 0;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("cFloor")) //floor leads to wild pokemons

	    {
		counter = (int) (Math.random () * 14) + 29;
		cHp = wildHp [counter];
		cP.setMaximum (cHp);
		cHp = wildHp [counter];
		catching.setText ("Throw Pokeball");
		wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
		cName.setText (wildPokeName [counter] + " ");
		cLvl.setText ("Level " + wildLvl [counter]);
		cP.setMaximum (cHp);
		resize (1200, 660);
		cdLayout.show (p_card, "10");
		move++;
	    }

	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass2")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 5;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass3")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 10;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass4")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 15;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass5")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 20;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass6")) //grass leads to wild pokemons
	{
	    counter = (int) (Math.random () * 5) + 25;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}
	else if (move % 10 == 0 && pics [guyy] [guyx].equals ("grass7"))  //step on tall grass and fight starts
	{
	    counter = (int) (Math.random () * 29) + 0;
	    cHp = wildHp [counter];
	    cP.setMaximum (cHp);
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    resize (1200, 660);
	    cdLayout.show (p_card, "10");
	    move++;
	}

	else if (pics [guyy] [guyx].equals ("talk5"))  //in game instructions
	{
	    JOptionPane.showMessageDialog (null, "You are in Pallet Town.\n\nThere are wild pokemons in the tall grass.\nYou can't travel on the river and the trees.\nSome doors and paths will lead to other areas.\n\nEnjoy your time in Pokemon.", "Pokemon Info", JOptionPane.INFORMATION_MESSAGE);
	    guyy--;
	}


	else if (pics [guyy] [guyx].equals ("talk4"))  //your mom tells you some instructions
	{
	    JOptionPane.showMessageDialog (null, "Hello " + name + "! Don't go into tall grass without some Pokemon.\nGood luck on your journey around this Pokemon world.", "Mom", JOptionPane.INFORMATION_MESSAGE);
	    guyy++;
	}


	else if (pics [guyy] [guyx].equals ("talk1")) //pokemon center lady heals you
	{
	    heal = JOptionPane.showInputDialog (null, "Do you want to restore your Pokemon? ", "Pokemon Centre", JOptionPane.PLAIN_MESSAGE);
	    while (!heal.equalsIgnoreCase ("Yes") && !heal.equalsIgnoreCase ("No"))
		heal = JOptionPane.showInputDialog ("Invalid Input. Do you want to restore your Pokemon? (Yes/No)");
	    if (heal.equalsIgnoreCase ("yes"))
	    {
		hp = pokeHp [uPoke];
		uP.setValue (hp);
		JOptionPane.showMessageDialog (null, "Your Pokemons have been healed.", "Pokemon Centre", JOptionPane.INFORMATION_MESSAGE);
	    }
	    JOptionPane.showMessageDialog (null, "Thanks for visiting!", "Pokemon Centre", JOptionPane.INFORMATION_MESSAGE);
	    guyy++;
	}


	else if (pics [guyy] [guyx].equals ("talk2")) //pokeball buy
	    talk2 ();

	else if (pics [guyy] [guyx].equals ("talk3")) //potion buy
	    talk3 ();

	else if (e.getActionCommand ().equals ("101")) //up
	    up ();

	else if (e.getActionCommand ().equals ("103")) //left
	    left ();

	else if (e.getActionCommand ().equals ("105")) //right
	    right ();

	else if (e.getActionCommand ().equals ("107")) //down
	    down ();

	else if (e.getActionCommand ().equals ("storyline")) //Professor Oak's speech
	    storyline ();

	else if (e.getActionCommand ().equals ("choose")) //leads to screen 1
	{
	    resize (850, 660);
	    Pokedex ();
	    cdLayout.show (p_card, "1");
	}

	else if (e.getActionCommand ().equals ("bag")) //your pokebag (adding to a partially filled array)
	{
	    s = "Poke Bag \n";
	    for (int i = 0 ; i < num ; i++) //Pokemon bag
		s += pokeNameBag [i] + "\n";
	    JOptionPane.showMessageDialog (null, s, "Your Poke Bag", JOptionPane.INFORMATION_MESSAGE);
	}

	else if (e.getActionCommand ().equals ("att1")) //your attack 1
	    att1 ();

	else if (e.getActionCommand ().equals ("att2")) //your attack 2
	    att2 ();

	else if (e.getActionCommand ().equals ("att3")) //your attack 3
	    att3 ();

	else if (e.getActionCommand ().equals ("catching")) //catch the pokemon
	    catching ();
	else if (e.getActionCommand ().equals ("potion")) //potion use on you pokemon
	{
	    PotionQ--;
	    hp += 20;
	    if (pokeHp [uPoke] >= hp)
		hp = pokeHp [uPoke];
	    if (PotionQ <= 0)
		potion.setEnabled (false);
	    else
		potion.setEnabled (true);
	}
	else if (e.getActionCommand ().equals ("Done")) //password screen done button leads to main menu screen
	{
	    if (p.getText ().equals ("Pokemon")) //pokemon is the password
	    {
		JOptionPane.showMessageDialog (null, "Welcome to Pokemon", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		resize (500, 600);
		cdLayout.show (p_card, "3");
	    }
	    else
		JOptionPane.showMessageDialog (null, "Unauthorized Access", "Incorrect Log on", JOptionPane.ERROR_MESSAGE);
	    p.setText ("");
	}
	else if (e.getActionCommand ().equals ("save"))
	{
	    openFile ();
	}
    }


    public void up ()  //up arrow
    {
	if (isValid (guyx, guyy - 1))
	{
	    guyy--;
	    redraw ();
	    if (screen == 3)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Up3.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Up3.jpg"));
	    }
	    else if (screen == 5)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Up5.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Up5.jpg"));
	    }
	    else if (screen == 6)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Up6.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Up6.jpg"));
	    }
	    else if (screen == 8)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Up8.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Up8.jpg"));
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

    }


    public void left ()  //left arrow
    {
	if (isValid (guyx - 1, guyy))
	{
	    guyx--;
	    redraw ();
	    if (screen == 3)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Left3.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Left3.jpg"));
	    }
	    else if (screen == 5)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Left5.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Left5.jpg"));
	    }
	    else if (screen == 6)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Left6.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Left6.jpg"));
	    }
	    else if (screen == 8)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Left8.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Left8.jpg"));
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

    }


    public void right ()  //right arrow
    {
	if (isValid (guyx + 1, guyy))
	{
	    guyx++;
	    redraw ();
	    if (screen == 3)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Right3.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Right3.jpg"));
	    }
	    else if (screen == 5)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Right5.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Right5.jpg"));
	    }
	    else if (screen == 6)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Right6.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Right6.jpg"));
	    }
	    else if (screen == 8)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Right8.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Right8.jpg"));
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

    }


    public void down ()  //down arrow
    {
	if (isValid (guyx, guyy + 1))
	{
	    guyy++;
	    redraw ();
	    if (screen == 3)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down3.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down3.jpg"));
	    }
	    else if (screen == 5)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down5.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down5.jpg"));
	    }
	    else if (screen == 6)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down6.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down6.jpg"));
	    }
	    else if (screen == 8)
	    {
		if (gender.equalsIgnoreCase ("girl"))
		    x [guyx + guyy * col].setIcon (createImageIcon ("character4Down8.jpg"));
		else
		    x [guyx + guyy * col].setIcon (createImageIcon ("character5Down8.jpg"));
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
    }


    public void catching ()  //catching the pokemon
    {
	PokeballQ--;
	if (catchMove % 2 == 0)
	{
	    pokeNameBag [num] = wildPokeName [counter];
	    num++;
	    JOptionPane.showMessageDialog (null, "You caught " + wildPokeName [counter], "Catching " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    counter = (int) (Math.random () * 15) + 0;
	    cHp = wildHp [counter];
	    catching.setText ("Throw Pokeball");
	    wildPokePic.setIcon (createImageIcon ("wild" + (counter + 1) + ".jpg"));
	    cName.setText (wildPokeName [counter] + " ");
	    cLvl.setText ("Level " + wildLvl [counter]);
	    cP.setMaximum (cHp);
	    move++;

	    cdLayout.show (p_card, "2");
	}

	else
	    JOptionPane.showMessageDialog (null, "You didn't catch " + wildPokeName [counter] + "he escaped the pokeball.", "Catching " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	if (PokeballQ <= 0)
	    catching.setEnabled (false);
	else
	    catching.setEnabled (true);
    }


    public void att1 ()  //attack 1
    {
	eP.setMaximum (reqExp);
	uDmg1 = (int) (Math.random () * lvl) + 1;

	cDmg = (int) (Math.random () * wildLvl [counter]) + 1;
	JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + " did " + uDmg1 + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	cHp -= uDmg1;
	cP.setValue (cHp);

	JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	hp -= cDmg;
	uP.setValue (hp);
	if (PokeballQ >= 1 && cHp <= 4 && cHp > 0)
	    catching.setEnabled (true);
	else if (cHp <= 0)
	{
	    exp += 2 * wildLvl [counter];
	    eP.setValue (exp);
	    moneyR = (int) (Math.random () * 400) + 100;
	    JOptionPane.showMessageDialog (null, "You defeated " + wildPokeName [counter] + "\nYou gained " + exp + " exp. You recieved " + moneyR + " money.", "Defeated " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    money += moneyR;
	    levelUp ();
	    move++;
	    readLevel (screen);
	    cdLayout.show (p_card, "2");
	}
	else if (hp <= 0)
	{
	    eP.setValue (exp);
	    screen = 5;
	    guyy = 16;
	    guyx = 25;
	    move++;
	    readLevel (screen);
	    redraw ();
	    cdLayout.show (p_card, "2");
	    JOptionPane.showMessageDialog (null, "You have been defeated and have been rushed to the Pokemon Centre.\n You have been healed by the PokeLady!", "Lose the battle", JOptionPane.INFORMATION_MESSAGE);
	    hp = pokeHp [uPoke];
	    uP.setValue (hp);
	}
    }


    public void att2 ()  //attack 2
    {
	eP.setMaximum (reqExp);
	uDmg2 = (int) (Math.random () * lvl) + 1;


	cDmg = (int) (Math.random () * wildLvl [counter]) + 1;
	JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + " did " + uDmg2 + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	cHp -= uDmg2;
	cP.setValue (cHp);

	JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	hp -= cDmg;
	uP.setValue (hp);
	if (cHp <= 4 && cHp > 0)
	    catching.setEnabled (true);
	else if (cHp <= 0)
	{
	    exp += 2 * wildLvl [counter];
	    eP.setValue (exp);
	    moneyR = (int) (Math.random () * 400) + 100;
	    JOptionPane.showMessageDialog (null, "You defeated " + wildPokeName [counter] + "\nYou gained " + exp + " exp. You recieved " + moneyR + " money.", "Defeated " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    money += moneyR;
	    levelUp ();
	    move++;
	    readLevel (screen);
	    cdLayout.show (p_card, "2");
	}
	else if (hp <= 0)
	{
	    eP.setValue (exp);
	    screen = 5;
	    guyy = 16;
	    guyx = 25;
	    move++;
	    readLevel (screen);
	    redraw ();
	    cdLayout.show (p_card, "2");
	    JOptionPane.showMessageDialog (null, "You have been defeated and have been rushed to the Pokemon Centre.\n You have been healed by the PokeLady!", "Lose the battle", JOptionPane.INFORMATION_MESSAGE);
	    hp = pokeHp [uPoke];
	    uP.setValue (hp);
	}
    }


    public void att3 ()  //attack 3
    {
	eP.setMaximum (reqExp);
	uDmg3 = (int) (Math.random () * lvl) + 1;

	cDmg = (int) (Math.random () * wildLvl [counter]) + 1;
	JOptionPane.showMessageDialog (null, "" + pokeName1 [uPoke] + " did " + uDmg3 + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	cHp -= uDmg3;
	cP.setValue (cHp);

	JOptionPane.showMessageDialog (null, "" + wildPokeName [counter] + " did " + cDmg + " damage", "Battling " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	hp -= cDmg;
	uP.setValue (hp);

	if (cHp <= 4 && cHp > 0)
	    catching.setEnabled (true);
	else if (cHp <= 0)
	{
	    exp += 3 * wildLvl [counter];
	    eP.setValue (exp);
	    moneyR = (int) (Math.random () * 400) + 100;
	    JOptionPane.showMessageDialog (null, "You defeated " + wildPokeName [counter] + "\nYou gained " + exp + " exp. You recieved " + moneyR + " money.", "Defeated " + wildPokeName [counter], JOptionPane.INFORMATION_MESSAGE);
	    money += moneyR;
	    levelUp ();
	    move++;
	    readLevel (screen);
	    cdLayout.show (p_card, "2");
	}
	else if (hp <= 0)
	{
	    eP.setValue (exp);
	    screen = 5;
	    guyy = 16;
	    guyx = 25;
	    move++;
	    readLevel (screen);
	    redraw ();
	    cdLayout.show (p_card, "2");
	    JOptionPane.showMessageDialog (null, "You have been defeated and have been rushed to the Pokemon Centre.\n You have been healed by the PokeLady!", "Lose the battle", JOptionPane.INFORMATION_MESSAGE);
	    hp = pokeHp [uPoke];
	    uP.setValue (hp);
	}
    }


    public void keyPressed (KeyEvent ev)  //key listeners method where the key is pressed
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

	else if (key == KeyEvent.VK_ENTER)
	    done.doClick ();
    }


    public void keyTyped (KeyEvent ev)
    {
    }


    public void keyReleased (KeyEvent ev)
    {
    }


    public void talk2 ()  //buy pokeballs
    {
	pokeballBuy = JOptionPane.showInputDialog (null, "You have " + money + " coins. Do you want to buy a Pokeball for 200 coins each? (Yes/No) ", "PokeMart", JOptionPane.PLAIN_MESSAGE);
	while (!pokeballBuy.equalsIgnoreCase ("Yes") && !pokeballBuy.equalsIgnoreCase ("No"))
	    pokeballBuy = JOptionPane.showInputDialog ("Invalid Input. You have " + money + " coins. Do you want to buy a Pokeball for 200 coins each? (Yes/No)");

	if (pokeballBuy.equalsIgnoreCase ("yes"))
	{
	    if (money < 200)
		JOptionPane.showMessageDialog (null, "You dont have enough money", "Insufficiant Funds", JOptionPane.INFORMATION_MESSAGE);
	    else
	    {
		max = money / 200;
		quantity = Integer.parseInt (JOptionPane.showInputDialog (null, "The max Pokeballs you can buy is " + max + ". How many do you want to buy? (number Input only) ", "PokeMart", JOptionPane.PLAIN_MESSAGE));
		while (totalCost >= money)
		    quantity = Integer.parseInt (JOptionPane.showInputDialog (null, "Insufficiant Funds. You can only buy " + max + " Pokeballs. How many do you want to buy?", "PokeMart", JOptionPane.PLAIN_MESSAGE));

		totalCost = 200 * quantity;
		PokeballQ += quantity;
		money -= totalCost;
		JOptionPane.showMessageDialog (null, "" + quantity + " Pokeballs costed you $" + totalCost + ". You have $" + money + " money left.", "PokeMart", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	guyy++;
	JOptionPane.showMessageDialog (null, "Thanks for visiting", "PokeMart", JOptionPane.INFORMATION_MESSAGE);
    }


    public void talk3 ()  //buy potions
    {
	potionBuy = JOptionPane.showInputDialog (null, "You have " + money + " coins. Do you want to buy some Potions for 200 coins each? (Yes/No) ", "PokeMart", JOptionPane.PLAIN_MESSAGE);
	while (!potionBuy.equalsIgnoreCase ("Yes") && !potionBuy.equalsIgnoreCase ("No"))
	    potionBuy = JOptionPane.showInputDialog ("Invalid Input. You have " + money + " coins. Do you want to buy some Potions for 200 coins each? (Yes/No)");

	if (potionBuy.equalsIgnoreCase ("yes"))
	{
	    if (money < 200)
		JOptionPane.showMessageDialog (null, "You dont have enough money", "Insufficiant Funds", JOptionPane.INFORMATION_MESSAGE);
	    else
	    {
		max = money / 200;
		pQuantity = Integer.parseInt (JOptionPane.showInputDialog (null, "The max Potions you can buy is " + max + ". How many do you want to buy? ", "PokeMart", JOptionPane.PLAIN_MESSAGE));

		while (tC >= money)
		    pQuantity = Integer.parseInt (JOptionPane.showInputDialog (null, "Insufficiant Funds. You can only buy " + max + " Potions. How many do you want to buy? (number Input only)", "PokeMart", JOptionPane.PLAIN_MESSAGE));
		tC = 200 * pQuantity;
		PotionQ += pQuantity;
		money -= tC;
		JOptionPane.showMessageDialog (null, "" + pQuantity + " Potions costed you $" + tC + ". You have $" + money + " money left.", "PokeMart", JOptionPane.INFORMATION_MESSAGE);

	    }
	}
	guyy++;
	JOptionPane.showMessageDialog (null, "Thanks for visiting", "PokeMart", JOptionPane.INFORMATION_MESSAGE);
    }


    protected static ImageIcon createImageIcon (String path)  //Creates Images
    {
	java.net.URL imgURL = pokemonGlassV5.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void openFile ()
    {

	String line;

	try
	{
	    BufferedReader br = new BufferedReader (new FileReader (new File ("test.txt")));
	    BufferedWriter bw = new BufferedWriter (new FileWriter (new File ("test.txt")));

		
	    
	}
	catch (Exception e1)
	{
	    JOptionPane.showMessageDialog (null, "File failed to load.");
	}
    }


    public boolean isValid (int x, int y)  //where the player can walk and cannot walk
    {
	if (y > 39)
	    return false;
	if (y < 0)
	    return false;
	if (x > 49)
	    return false;
	if (x < 0)
	    return false;
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
	else if (pics [y] [x].equals ("talk5"))
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
	else if (pics [y] [x].equals ("talk4"))
	    return true;
	else if (pics [y] [x].equals ("carpet"))
	    return true;
	else
	    return false;
    }


    public void readLevel (int level)  //changes screens
    {
	String filename = "screen" + level + ".txt"; //gets the file name
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
		pics [i] [j] = input; //set the grid to equal the file so that each grid can run
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


    public void Invalid ()  //Checks for Invalid input for the pokedex
    {
	while (!pokemon.equalsIgnoreCase ("Turtwig") && !pokemon.equalsIgnoreCase ("Chimchar") && !pokemon.equalsIgnoreCase ("Piplup"))
	    pokemon = JOptionPane.showInputDialog (null, "That pokemon wasn't found. Try Again!\nHere are the list of Starter Pokemon that are from the Sinnoh region: \n\nChimchar \nTurtwig \nPiplup \n\nWhich Pokemon would you like to search?", "Welcome to the Starter Pokedex!", JOptionPane.PLAIN_MESSAGE);
    }
}
