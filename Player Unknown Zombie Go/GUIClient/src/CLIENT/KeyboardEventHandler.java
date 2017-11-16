package CLIENT;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyboardEventHandler extends KeyAdapter
{
    Battle battle =new Battle();
    //Random random = new Random();
    //private int value = 0;


    public void keyPressed(KeyEvent event)
    {
        double randomValue = Math.random();
        double value = (randomValue*100)+1;

        int key = event.getKeyCode();

        switch (key)
        {
            case KeyEvent.VK_UP:
                if (Player.playerLabel.getY() <= 0)
                    return;
                else
                {
                    Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() - Player.speed);
                    if (value <= 1.5)
                        battle.startBattle();
                    break;
                }

            case KeyEvent.VK_DOWN:
                if(Player.playerLabel.getY() + Player.playerLabel.getHeight() + Player.speed > 1080)
                    return;
                else
                {
                    Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() + Player.speed);
                    if (value <= 1.5)
                        battle.startBattle();
                    break;
                }

            case KeyEvent.VK_LEFT:
                if (Player.playerLabel.getX() <= 0)
                    return;
                else
                {
                    Player.playerLabel.setLocation(Player.playerLabel.getX() - Player.speed, Player.playerLabel.getY());
                    if (value <= 1.5)
                        battle.startBattle();
                    break;
                }

            case KeyEvent.VK_RIGHT:
                if (Player.playerLabel.getX() + Player.playerLabel.getWidth() + Player.speed > 1920)
                    return;
                else
                {
                    Player.playerLabel.setLocation(Player.playerLabel.getX() + Player.speed, Player.playerLabel.getY());
                    if (value <= 1.5)
                        battle.startBattle();
                    break;
                }
        }
    }
}
