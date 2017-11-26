package CLIENT;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Inventory extends JFrame
{
    public static ItemList itemList = new ItemList();

    private Random random = new Random();
    private int item;
    public static int countItem = 0;

    Pistol pistol = new Pistol();
    Smg smg = new Smg();
    Ar ar = new Ar();
    Portion1 portion1 = new Portion1();
    Portion2 portion2 = new Portion2();
    FlyingPan flyingPan = new FlyingPan();

    JButton jButton0 = null;
    JButton jButton1 = null;
    JButton jButton2 = null;
    JButton jButton3 = null;
    JButton jButton4 = null;
    JButton jButton5 = null;
    JButton jButton6 = null;
    JButton jButton7 = null;
    JButton jButton8 = null;

    public void dropTheItem()
    {
        item = random.nextInt(6);

        switch (item)
        {
            case 0: dropThePistol(); break;
            case 1: dropTheSMG(); break;
            case 2: dropTheAR(); break;
            case 3: dropThePortion1(); break;
            case 4: dropThePortion2(); break;
            case 5: dropTheFlyingFan(); break;
        }
    }

    private void dropThePistol()
    {
        itemList.add(Inventory.countItem, pistol);
    }

    private void dropTheSMG()
    {
        itemList.add(Inventory.countItem, smg);
    }

    private void dropTheAR()
    {
        itemList.add(Inventory.countItem, ar);
    }

    private void dropThePortion1()
    {
        itemList.add(Inventory.countItem, portion1);
    }

    private void dropThePortion2()
    {
        itemList.add(Inventory.countItem, portion2);
    }

    private void dropTheFlyingFan()
    {
        itemList.add(Inventory.countItem, flyingPan);
    }

    public void showInventory() throws NullPointerException
    {
        FlowLayout layout = new FlowLayout();
        this.setSize(200, 800);
        this.setLayout(layout);
        this.setTitle("인벤토리");

        this.jButton0 = new JButton(Inventory.itemList.get(0));
        this.jButton0.addActionListener(new MouseEventHandler());
        this.add(jButton0);

        this.jButton1 = new JButton(Inventory.itemList.get(1));
        this.jButton1.addActionListener(new MouseEventHandler());
        this.add(jButton1);

        this.jButton2 = new JButton(Inventory.itemList.get(2));
        this.jButton2.addActionListener(new MouseEventHandler());
        this.add(jButton2);

        this.jButton3 = new JButton(Inventory.itemList.get(3));
        this.jButton3.addActionListener(new MouseEventHandler());
        this.add(jButton3);

        this.jButton4 = new JButton(Inventory.itemList.get(4));
        this.jButton4.addActionListener(new MouseEventHandler());
        this.add(jButton4);

        this.jButton5 = new JButton(Inventory.itemList.get(5));
        this.jButton5.addActionListener(new MouseEventHandler());
        this.add(jButton5);

        this.jButton6 = new JButton(Inventory.itemList.get(6));
        this.jButton6.addActionListener(new MouseEventHandler());
        this.add(jButton6);

        this.jButton7 = new JButton(Inventory.itemList.get(7));
        this.jButton7.addActionListener(new MouseEventHandler());
        this.add(jButton7);

        this.jButton8 = new JButton(Inventory.itemList.get(8));
        this.jButton8.addActionListener(new MouseEventHandler());
        this.add(jButton8);

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}