package CLIENT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MouseEventHandler extends Thread implements MouseListener, ActionListener
{
    Inventory inventory = new Inventory();

    private Font font = new Font("굴림", Font.BOLD, 20);

    @Override
    public void mouseClicked(MouseEvent e)
    {
        JButton jButton =(JButton)e.getComponent();

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton jButton = (JButton) e.getSource();
        Battle battle = KeyboardEventHandler.battle;

        if (jButton.getText().equals("공격"))
        {
            battle.playerTurn();
        }

        else if (jButton.getText().equals("도구"))
        {
            inventory.showInventory();
        }

        else if (jButton.getText().equals("도망"))
        {
            if (Player.speed > WeakZombie.weakZombieSpeed)
            {
                battle.battleEnd();
            }

            else
            {
                Random random = new Random();
                int rate = random.nextInt(100);

                if (rate <= ((Player.speed / WeakZombie.weakZombieSpeed) * 100))
                    battle.battleEnd();
                else
                    return;
            }
        }
    }
}
