package CLIENT;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame
{
    public String name =ChatGuiClient.name;
    public static int power = 10;
    public static int MaxHp = 20;
    public static int CurrentHp = 20;
    public static int speed = 5;

    public static JLabel backGround = new JLabel(new ImageIcon("background_green.png"));
    public static JLabel playerLabel = new JLabel(new ImageIcon("player.png"));

    Player()
    {
        super("Player Unknown Zombie Go");

        backGround.setBounds(0, 0, 1920, 1080);
        backGround.add(playerLabel);
        this.add(backGround);
        playerLabel.setBounds(100, 100,250,250);

        gameStart();

        this.setLayout(null);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void gameStart()
    {
        Portal portal = new Portal();
        Thread gunThread = new Gun();

        gunThread.start();

        BorderLayout layout = new BorderLayout();

        addKeyListener(new KeyboardEventHandler());

        this.setSize(1920, 1080);
        this.setLayout(layout);
    }
}