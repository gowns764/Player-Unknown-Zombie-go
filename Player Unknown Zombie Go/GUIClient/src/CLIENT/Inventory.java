package CLIENT;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Inventory extends JFrame
{
    public static ItemList itemList = new ItemList();
    public int pistolNumber = 0;
    public int smgNumber = 0;
    public int arNumber = 0;
    public int portion1Number = 0;
    public int portion2Number = 0;
    public int flyingPanNumber = 0;

    private Random random = new Random();
    private int item;
    public static int countItem = 0;

    Pistol pistol = new Pistol();
    Smg smg = new Smg();
    Ar ar = new Ar();
    Portion1 portion1 = new Portion1();
    Portion2 portion2 = new Portion2();
    FlyingPan flyingPan = new FlyingPan();

    JLabel InventoryGround = new JLabel(new ImageIcon("InventoryGround.png"));
    JButton jButton0 = null;
    JButton jButton1 = null;
    JButton jButton2 = null;
    JButton jButton3 = null;
    JButton jButton4 = null;
    JButton jButton5 = null;
    JButton jButton6 = null;
    JButton jButton7 = null;
    JButton jButton8 = null;
    JLabel noneItem = new JLabel("아이템이 없습니다.");

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
        pistolNumber = Inventory.countItem;
        itemList.add(Inventory.countItem, pistol);
    }

    private void dropTheSMG()
    {
        smgNumber = Inventory.countItem;
        itemList.add(Inventory.countItem, smg);
    }

    private void dropTheAR()
    {
        arNumber = Inventory.countItem;
        itemList.add(Inventory.countItem, ar);
    }

    private void dropThePortion1()
    {
        portion1Number = Inventory.countItem;
        itemList.add(Inventory.countItem, portion1);
    }

    private void dropThePortion2()
    {
        portion2Number = Inventory.countItem;
        itemList.add(Inventory.countItem, portion2);
    }

    private void dropTheFlyingFan()
    {
        flyingPanNumber = Inventory.countItem;
        itemList.add(Inventory.countItem, flyingPan);
    }

    public void showInventory()
    {
        BorderLayout layout = new BorderLayout();
        this.setSize(400, 1000);
        this.setLayout(layout);
        this.setTitle("인벤토리");

        this.InventoryGround.setBounds(0, 0, 1290, 1080);
        this.add(InventoryGround);

        if (Inventory.itemList.size() >= 1)
        {
            this.remove(noneItem);
            this.jButton0 = new JButton(Inventory.itemList.get(0));
            this.jButton0.addActionListener(new InventoryMouseEventHandler());
            InventoryGround.add(jButton0);
            jButton0.setBounds(0, 0, 400, 50);

            if (Inventory.itemList.size() >= 2)
            {
                this.jButton1 = new JButton(Inventory.itemList.get(1));
                this.jButton1.addActionListener(new InventoryMouseEventHandler());
                InventoryGround.add(jButton1);
                this.jButton1.setBounds(0, 100, 400, 50);

                if (Inventory.itemList.size() >= 3)
                {
                    this.jButton2 = new JButton(Inventory.itemList.get(2));
                    this.jButton2.addActionListener(new InventoryMouseEventHandler());
                    InventoryGround.add(jButton2);
                    jButton2.setBounds(0, 200, 400, 50);

                    if (Inventory.itemList.size() >= 4)
                    {
                        this.jButton3 = new JButton(Inventory.itemList.get(3));
                        this.jButton3.addActionListener(new InventoryMouseEventHandler());
                        InventoryGround.add(jButton3);
                        jButton3.setBounds(0, 300, 400, 50);

                        if (Inventory.itemList.size() >= 5)
                        {
                            this.jButton4 = new JButton(Inventory.itemList.get(4));
                            this.jButton4.addActionListener(new InventoryMouseEventHandler());
                            InventoryGround.add(jButton4);
                            jButton4.setBounds(0, 400, 400, 50);

                            if (Inventory.itemList.size() >= 6)
                            {
                                this.jButton5 = new JButton(Inventory.itemList.get(5));
                                this.jButton5.addActionListener(new InventoryMouseEventHandler());
                                InventoryGround.add(jButton5);
                                jButton5.setBounds(0, 500, 400, 50);

                                if (Inventory.itemList.size() >= 7)
                                {
                                    this.jButton6 = new JButton(Inventory.itemList.get(6));
                                    this.jButton6.addActionListener(new InventoryMouseEventHandler());
                                    InventoryGround.add(jButton6);
                                    jButton6.setBounds(0, 600, 400, 50);


                                    if (Inventory.itemList.size() >= 8)
                                    {
                                        this.jButton7 = new JButton(Inventory.itemList.get(7));
                                        this.jButton7.addActionListener(new InventoryMouseEventHandler());
                                        InventoryGround.add(jButton7);
                                        jButton7.setBounds(0, 700, 400, 50);

                                        if (Inventory.itemList.size() >= 9)
                                        {
                                            this.jButton8 = new JButton(Inventory.itemList.get(8));
                                            this.jButton8.addActionListener(new InventoryMouseEventHandler());
                                            InventoryGround.add(jButton8);
                                            jButton8.setBounds(0, 800, 400, 50);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        else
        {
            noneItem.setBounds(0, 0, 400, 100);
            this.add(noneItem);
        }

        this.setVisible(true);
    }

    public void removeItem()
    {
        /*switch (InventoryMouseEventHandler.removeItem)
        {
            case jButton0.getText():
                Inventory.itemList.remove(pistolNumber);
        }*/
    }
}