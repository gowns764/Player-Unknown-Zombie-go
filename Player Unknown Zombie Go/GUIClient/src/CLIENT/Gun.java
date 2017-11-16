package CLIENT;

import javax.swing.*;

public class Gun extends Thread
{
    public static JLabel gunLabel;
    private boolean isGet = false;

    public Gun()
    {
        gunLabel = new JLabel(new ImageIcon("Gun.png"));
        gunLabel.setBounds(900, 700, 250, 250);
        Player.backGround.add(gunLabel);
    }

    @Override
    public void run()
    {
        while(true) {
            if ((gunLabel.getX() - Player.playerLabel.getX() <= 20) && (gunLabel.getY() - Player.playerLabel.getY() <= 20))
            {
                Player.backGround.remove(gunLabel);
                isGet = true;
                break;
            }
        }
    }
}
