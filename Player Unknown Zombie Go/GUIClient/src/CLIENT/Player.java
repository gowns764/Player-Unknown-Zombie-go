package CLIENT;

import javafx.application.Platform;
import javax.swing.*;
import java.awt.*;

public class Player extends JFrame
{
    public static int power = 5;
    public static int MaxHp = 20;
    public static int CurrentHp = 20;
    public static int speed = 5;
    public static int defensivePower = 0;
    public static int evasionRate = 0;

    public static int currentX = 100;
    public static int currentY = 100;

    public static JLabel winImage = new JLabel(new ImageIcon("WinEnd.png"));
    public static JLabel failImage = new JLabel(new ImageIcon("FailEnd.png"));

    public static JLabel backGround = new JLabel(new ImageIcon("background_green.png"));
    public static JLabel playerLabel = new JLabel(new ImageIcon("player.png"));

    public static JLabel rock1 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock2 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock3 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock4 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock5 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock6 = new JLabel(new ImageIcon("rock.png"));
    public static JLabel rock7 = new JLabel(new ImageIcon("rock.png"));

    public static JLabel tree1 = new JLabel(new ImageIcon("Tree.png"));
    public static JLabel tree2 = new JLabel(new ImageIcon("Tree.png"));
    public static JLabel tree3 = new JLabel(new ImageIcon("Tree.png"));
    public static JLabel tree4 = new JLabel(new ImageIcon("Tree.png"));
    public static JLabel tree5 = new JLabel(new ImageIcon("Tree.png"));

    public void beforeGameStart()
    {
        this.setTitle("Player Unknown's Battle Ground");
        backGround.setBounds(0, 0, 1920, 1080);
        this.add(backGround);
        backGround.add(winImage);
        backGround.add(failImage);
        backGround.add(playerLabel);
        playerLabel.setBounds(currentX, currentY, 60, 250);

        backGround.add(tree1);
        backGround.add(tree2);
        backGround.add(tree3);
        backGround.add(tree4);
        backGround.add(tree5);

        tree1.setBounds(1700, 500, 210, 252);
        tree2.setBounds(1400, 650, 210, 252);
        tree3.setBounds(400, 320, 210, 252);
        tree4.setBounds(1000, 200, 210, 252);
        tree5.setBounds(750, 400, 210, 252);

        backGround.add(rock1);
        backGround.add(rock2);
        backGround.add(rock3);
        backGround.add(rock4);
        backGround.add(rock5);
        backGround.add(rock6);
        backGround.add(rock7);

        rock1.setBounds(300, 100, 115, 84);
        rock2.setBounds(350, 700, 115, 84);
        rock3.setBounds(100, 400, 115, 84);
        rock4.setBounds(700, 250, 115, 84);
        rock5.setBounds(650, 450, 115, 84);
        rock6.setBounds(850, 550, 115, 84);
        rock7.setBounds(1250, 650, 115, 84);

        gameStart();

        this.setLayout(null);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void gameStart()
    {
        Bgm bgm = new Bgm(true);
        bgm.start();

        BorderLayout layout = new BorderLayout();

        addKeyListener(new KeyboardEventHandler());

        this.setSize(1920, 1080);
        this.setLayout(layout);
    }

    public void winEnd()
    {
        rock1.setSize(0, 0);
        rock2.setSize(0, 0);
        rock3.setSize(0, 0);
        rock4.setSize(0, 0);
        rock5.setSize(0, 0);
        rock6.setSize(0, 0);
        rock7.setSize(0, 0);
        tree1.setSize(0, 0);
        tree2.setSize(0, 0);
        tree3.setSize(0, 0);
        tree4.setSize(0, 0);
        tree5.setSize(0, 0);
        playerLabel.setSize(0, 0);

        try
        {
            Thread.sleep(500);
            winImage.setBounds(0, 0, 1920, 1080);
            Platform.exit();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void failEnd()
    {
        rock1.setSize(0, 0);
        rock2.setSize(0, 0);
        rock3.setSize(0, 0);
        rock4.setSize(0, 0);
        rock5.setSize(0, 0);
        rock6.setSize(0, 0);
        rock7.setSize(0, 0);
        tree1.setSize(0, 0);
        tree2.setSize(0, 0);
        tree3.setSize(0, 0);
        tree4.setSize(0, 0);
        tree5.setSize(0, 0);
        playerLabel.setSize(0, 0);

        try
        {
            Thread.sleep(500);
            failImage.setBounds(0, 0, 1920, 1080);
            Platform.exit();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}