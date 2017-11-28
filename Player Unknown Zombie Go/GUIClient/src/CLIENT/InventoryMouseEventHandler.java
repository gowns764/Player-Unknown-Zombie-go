package CLIENT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventoryMouseEventHandler extends Thread implements MouseListener, ActionListener
{
    Inventory inventory = new Inventory();
    Battle battle = new Battle();
    public static boolean isItemClicked = false;
    public static String removeItem = "";

    Pistol pistol = new Pistol();
    Smg smg = new Smg();
    Ar ar = new Ar();
    Portion1 portion1 = new Portion1();
    Portion2 portion2 = new Portion2();
    FlyingPan flyingPan = new FlyingPan();
    Armor armor = new Armor();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton jButton = (JButton) e.getSource();
        InventoryMouseEventHandler.removeItem = "";

        if (jButton.getText().equals("권총"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.evasionRate = 0;
            Player.power += pistol.power;
            inventory.closeInventory();
            battle.zombieTurn();
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("기관단총"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.evasionRate = 0;
            Player.power += smg.power;
            inventory.closeInventory();
            battle.zombieTurn();
            //Inventory.itemList.remove(inventory.smgNumber);
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("돌격소총"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.evasionRate = 0;
            Player.power += ar.power;
            inventory.closeInventory();
            battle.zombieTurn();
            //Inventory.itemList.remove(inventory.arNumber);
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("소용량 포션"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            if (Player.CurrentHp == Player.MaxHp)
            {
                inventory.closeInventory();
                battle.zombieTurn();
            }
            else if (Player.CurrentHp < Player.MaxHp)
            {
                Player.CurrentHp += 10;
                Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
                //Inventory.itemList.remove(inventory.portion2Number);
                //inventory.removeItem();

                if (Player.CurrentHp >= Player.MaxHp)
                {
                    Player.CurrentHp = Player.MaxHp;
                    Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
                }
                inventory.closeInventory();
                battle.zombieTurn();
            }
        }

        else if (jButton.getText().equals("대용량 포션"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            if (Player.CurrentHp == Player.MaxHp)
            {
                inventory.closeInventory();
                battle.zombieTurn();
            }

            else if (Player.CurrentHp < Player.MaxHp)
            {
                Player.CurrentHp += 20;
                Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
                //Inventory.itemList.remove(inventory.portion2Number);
                //inventory.removeItem();

                if (Player.CurrentHp >= Player.MaxHp)
                {
                    Player.CurrentHp = Player.MaxHp;
                    Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
                }
                inventory.closeInventory();
                battle.zombieTurn();
            }
        }

        else if (jButton.getText().equals("후라이팬"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.power = 5;
            Player.evasionRate = 0;
            Player.evasionRate += flyingPan.evasionRate;
            Player.power += flyingPan.power;

            inventory.closeInventory();
            battle.zombieTurn();
            //Inventory.itemList.remove(inventory.flyingPanNumber);
            //inventory.removeItem();
        }

        else if (jButton.getText().equals("방탄복"))
        {
            InventoryMouseEventHandler.isItemClicked = true;
            InventoryMouseEventHandler.removeItem = jButton.getText();
            Player.defensivePower = 0;
            Player.defensivePower += armor.defensivePower;
            Battle.hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
            inventory.closeInventory();
            battle.zombieTurn();
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
