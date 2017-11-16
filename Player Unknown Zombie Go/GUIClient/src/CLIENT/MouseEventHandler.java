package CLIENT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler extends Thread implements MouseListener, ActionListener
{
    public static boolean isClicked = false;

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
        Battle battle = new Battle();

        if (jButton.getText().equals("공격"))
        {
            WeakZombie.weakZombieCurrentHp -= Player.power;
            Battle.weakZombieHpLabel.setText(WeakZombie.weakZombieName + "\n" + WeakZombie.weakZombieCurrentHp + " / " + WeakZombie.weakZombieMaxHp);
            isClicked = true;
        }
    }
}
