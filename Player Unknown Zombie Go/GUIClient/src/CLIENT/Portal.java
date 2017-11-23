package CLIENT;

import javax.swing.*;

public class Portal extends JFrame
{
    JLabel portalLabel = new JLabel(new ImageIcon("HiosPortal1.gif"));

    public Portal()
    {
        portalLabel.setBounds(300, 300, 130, 130);
        Player.backGround.add(portalLabel);
    }
}
