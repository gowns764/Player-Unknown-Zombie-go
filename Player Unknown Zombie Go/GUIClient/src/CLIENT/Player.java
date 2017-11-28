package CLIENT;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame
{
    public static int power = 5;
    public static int MaxHp = 20;
    public static int CurrentHp = 20;
    public static int speed = 5;

    public static int currentX = 100;
    public static int currentY = 100;

    public JLabel endImage = null;
    public static JLabel backGround = new JLabel(new ImageIcon("background_green.png"));
    public static JLabel playerLabel = new JLabel(new ImageIcon("player.png"));
    public static JLabel rock1 = new JLabel(new ImageIcon("rock.png")); //346 251
    public static JLabel rock2 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock3 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock4 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock5 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock6 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock7 = new JLabel(new ImageIcon("rock.png"));

    public void beforeGameStart()
    {
        this.setTitle("Player Unknown's Battle Ground");
        backGround.setBounds(0, 0, 1920, 1080);
        backGround.add(playerLabel);
        this.add(backGround);
        playerLabel.setBounds(currentX, currentY, 60, 250);

        backGround.add(rock1);
        backGround.add(rock2);
        backGround.add(rock3);
        backGround.add(rock4);
        backGround.add(rock5);
        backGround.add(rock6);
        backGround.add(rock7);

        rock1.setBounds(300, 100, 346, 251);
        rock2.setBounds(300, 300, 346, 251);
        rock3.setBounds(100, 700, 346, 251);
        rock4.setBounds(700, 100, 346, 251);
        rock5.setBounds(700, 300, 346, 251);
        rock6.setBounds(700, 700, 346, 251);
        rock7.setBounds(1000, 150, 346, 251);

        gameStart();

        this.setLayout(null);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void gameStart()
    {
        BorderLayout layout = new BorderLayout();

        addKeyListener(new KeyboardEventHandler());

        this.setSize(1920, 1080);
        this.setLayout(layout);
    }

    public void winEnd()
    {
        rock1.setSize(0,0 );
        rock2.setSize(0,0 );
        rock3.setSize(0,0 );
        rock4.setSize(0,0 );
        rock5.setSize(0,0 );
        rock6.setSize(0,0 );
        rock7.setSize(0,0 );
        playerLabel.setSize(0, 0);

        endImage = new JLabel(new ImageIcon("WinEnd.png"));
        backGround.add(endImage);
        endImage.setBounds(0, 0, 1920, 1080);
    }

    public void failEnd()
    {
        rock1.setSize(0,0 );
        rock2.setSize(0,0 );
        rock3.setSize(0,0 );
        rock4.setSize(0,0 );
        rock5.setSize(0,0 );
        rock6.setSize(0,0 );
        rock7.setSize(0,0 );
        playerLabel.setSize(0, 0);

        endImage = new JLabel(new ImageIcon("FailEnd.png"));
        backGround.add(endImage);
        endImage.setBounds(0, 0, 1920, 1080);
    }
}