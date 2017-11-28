package CLIENT;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEventHandler extends KeyAdapter
{
    CollisionEventHandler collisionEventHandler = new CollisionEventHandler();
    static Battle battle = new Battle();

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
                    CollisionEventHandler.isReturn = false;
                    Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() - Player.speed);

                    collisionEventHandler.checkingCollisionToRock();
                    if (CollisionEventHandler.isReturn)
                    {
                        Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() + Player.speed);
                        return;
                    }

                    if (value <= 1.5)
                    {
                        Player.currentX = Player.playerLabel.getX();
                        Player.currentY = Player.playerLabel.getY();
                        battle.startBattle();
                    }
                    break;
                }

            case KeyEvent.VK_DOWN:
                if(Player.playerLabel.getY() + Player.playerLabel.getHeight() + Player.speed > 1080)
                    return;

                else
                {
                    CollisionEventHandler.isReturn = false;
                    Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() + Player.speed);

                    collisionEventHandler.checkingCollisionToRock();

                    if (CollisionEventHandler.isReturn)
                    {
                        Player.playerLabel.setLocation(Player.playerLabel.getX(), Player.playerLabel.getY() - Player.speed);
                        return;
                    }

                    if (value <= 1.5)
                    {
                        Player.currentX = Player.playerLabel.getX();
                        Player.currentY = Player.playerLabel.getY();
                        battle.startBattle();
                    }
                    break;
                }

            case KeyEvent.VK_LEFT:
                if (Player.playerLabel.getX() <= 0)
                    return;
                else
                {
                    CollisionEventHandler.isReturn = false;
                    Player.playerLabel.setLocation(Player.playerLabel.getX() - Player.speed, Player.playerLabel.getY());

                    collisionEventHandler.checkingCollisionToRock();

                    if (CollisionEventHandler.isReturn)
                    {
                        Player.playerLabel.setLocation(Player.playerLabel.getX() + Player.speed, Player.playerLabel.getY());
                        return;
                    }

                    if (value <= 1.5)
                    {
                        Player.currentX = Player.playerLabel.getX();
                        Player.currentY = Player.playerLabel.getY();
                        battle.startBattle();
                    }
                    break;
                }

            case KeyEvent.VK_RIGHT:
                if (Player.playerLabel.getX() + Player.playerLabel.getWidth() + Player.speed > 1920)
                    return;
                else
                {
                    CollisionEventHandler.isReturn = false;
                    Player.playerLabel.setLocation(Player.playerLabel.getX() + Player.speed, Player.playerLabel.getY());

                    collisionEventHandler.checkingCollisionToRock();
                    if (CollisionEventHandler.isReturn)
                    {
                        Player.playerLabel.setLocation(Player.playerLabel.getX() - Player.speed, Player.playerLabel.getY());
                        return;
                    }

                    if (value <= 1.5)
                    {
                        Player.currentX = Player.playerLabel.getX();
                        Player.currentY = Player.playerLabel.getY();
                        battle.startBattle();
                    }
                    break;
                }
        }
    }
}
