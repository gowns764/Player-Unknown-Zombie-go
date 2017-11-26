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

    public static JLabel backGround = new JLabel(new ImageIcon("background_green.png"));
    public static JLabel playerLabel = new JLabel(new ImageIcon("player.png"));
    public static JLabel noticeLabel = new JLabel("");

    Player()
    {
        super("Player Unknown Zombie Go");

        backGround.setBounds(0, 0, 1920, 1080);
        backGround.add(playerLabel);
        this.add(backGround);
        playerLabel.setBounds(currentX, currentY, 60, 250);

        noticeLabel.setBounds(900, 100, 500, 50);

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

}