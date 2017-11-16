package CLIENT;

import javax.swing.*;

public class Portal extends JFrame
{
    public static JLabel portalLabel = new JLabel(new ImageIcon("HiosPortal.gif"));

    public Portal()
    {
        portalLabel.setBounds(300, 300, 300, 300);
        Player.backGround.add(portalLabel);
    }
}
