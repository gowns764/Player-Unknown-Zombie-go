package CLIENT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryMouseEventHandler extends Thread implements MouseListener, ActionListener
{
    Inventory inventory = new Inventory();
    public static String removeItem = "";

    Pistol pistol = new Pistol();
    Smg smg = new Smg();
    Ar ar = new Ar();
    Portion1 portion1 = new Portion1();
    Portion2 portion2 = new Portion2();
    FlyingPan flyingPan = new FlyingPan();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton jButton = (JButton) e.getSource();
        InventoryMouseEventHandler.removeItem = "";

        if (jButton.getText().equals("권총"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.power += pistol.power;
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("기관단총"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.power += smg.power;
            //Inventory.itemList.remove(inventory.smgNumber);
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("돌격소총"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.power += ar.power;
            //Inventory.itemList.remove(inventory.arNumber);
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("소용량 포션"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            if (Player.CurrentHp == Player.MaxHp)
                return;

            else if (Player.CurrentHp < Player.MaxHp)
            {
                Player.CurrentHp += 10;
                Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp);
                //Inventory.itemList.remove(inventory.portion2Number);
                //inventory.removeItem();

                if (Player.CurrentHp >= Player.MaxHp)
                {
                    Player.CurrentHp = Player.MaxHp;
                    Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp);
                }
            }
        }

        else if (jButton.getText().equals("대용량 포션"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            if (Player.CurrentHp == Player.MaxHp)
                return;

            else if (Player.CurrentHp < Player.MaxHp)
            {
                Player.CurrentHp += 20;
                Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp);
                //Inventory.itemList.remove(inventory.portion2Number);
                //inventory.removeItem();

                if (Player.CurrentHp >= Player.MaxHp)
                {
                    Player.CurrentHp = Player.MaxHp;
                    Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp);
                }
            }
        }

        else if (jButton.getText().equals("후라이팬"))
        {
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.power += flyingPan.power;
            //Inventory.itemList.remove(inventory.flyingPanNumber);
            //inventory.removeItem();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
