package CLIENT;

import javax.swing.*;

public class Portion
{
    JLabel portionLabel = new JLabel(new ImageIcon("Portion.png"));

    public Portion()
    {
        portionLabel.setBounds(600, 300, 130, 130);
        Player.backGround.add(portionLabel);

        /*if (Player.CurrentHp == Player.MaxHp)
            return;
        else if (Player.CurrentHp < Player.MaxHp)
        {
            Player.CurrentHp += 10;
            if (Player.CurrentHp >= Player.MaxHp)
                Player.CurrentHp = Player.MaxHp;
        }*/
    }
}
