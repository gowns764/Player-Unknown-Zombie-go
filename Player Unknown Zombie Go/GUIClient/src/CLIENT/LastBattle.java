package CLIENT;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LastBattle extends JFrame
{
    Player player = new Player();
    BossZombie bossZombie = new BossZombie();
    MouseEventHandler mouseEventHandler = new MouseEventHandler();

    public JLabel battlePlayerLabel = new JLabel(new ImageIcon("player.png"));

    JButton attackButton = null;
    JButton toolButton = null;
    JButton runAwayButton = null;

    private JLabel playerNameLabel = new JLabel(ChatGuiClient.name);
    private JLabel bossZombieNameLabel = new JLabel(BossZombie.bossZombieName);
    public static JLabel hpLabel = new JLabel(Player.CurrentHp + " / " + Player.MaxHp + "   " + Player.defensivePower);
    private static JLabel bossZombieHpLabel = new JLabel(BossZombie.bossZombieCurrentHp + " / " + BossZombie.bossZombieMaxHp);

    public static JLabel explainLabel = new JLabel("야생의 " + BossZombie.bossZombieName + "가 나타났다! " + ChatGuiClient.name +"은(는) 무엇을 할 것인가?");
    public static JLabel toolLabel = new JLabel("");
    static JLabel battleGroundLabel = new JLabel(new ImageIcon("BattleGround.png"));
    JLabel bossZombieLabel = new JLabel(new ImageIcon("Zombie.png"));
    JLabel hios = new JLabel(new ImageIcon("Hios.gif"));

    private Font font = new Font("굴림", Font.BOLD, 20);

    Inventory inventory = new Inventory();

    private int accuracyRate = 0;
    private Random random = new Random();

    public LastBattle()
    {
        super("Player Unknown Zombie Go");

        this.attackButton = new JButton("공격");
        this.attackButton.addActionListener(new MouseEventHandler());

        this.toolButton = new JButton("도구");
        this.toolButton.addActionListener(new MouseEventHandler());

        this.runAwayButton = new JButton("도망");
        this.runAwayButton.addActionListener(new MouseEventHandler());
    }

    public void startBattle()
    {
        battleGroundLabel.setBounds(0, 0, 1920, 1080);
        this.add(battleGroundLabel);

        battleGroundLabel.add(hios);
        hios.setBounds(650, 100, 488, 512);

        battleGroundLabel.add(attackButton);
        attackButton.setBounds(400, 650, 200, 100);

        battleGroundLabel.add(toolButton);
        toolButton.setBounds(800, 650, 200, 100);

        battleGroundLabel.add(runAwayButton);
        runAwayButton.setBounds(1200, 650, 200, 100);

        battleGroundLabel.add(battlePlayerLabel);
        battlePlayerLabel.setBounds(100, 500, 50, 250);

        battleGroundLabel.add(playerNameLabel);
        playerNameLabel.setBounds(100, 750, 200, 50);
        playerNameLabel.setFont(font);

        battleGroundLabel.add(Battle.hpLabel);
        hpLabel.setBounds(100, 800, 200, 50);
        hpLabel.setFont(font);

        battleGroundLabel.add(bossZombieLabel);
        bossZombieLabel.setBounds(1550, 100, 250, 250);

        battleGroundLabel.add(bossZombieNameLabel);
        bossZombieNameLabel.setBounds(1600, 450, 200, 50);
        bossZombieNameLabel.setFont(font);

        battleGroundLabel.add(LastBattle.bossZombieHpLabel);
        bossZombieHpLabel.setBounds(1600, 400, 133, 231);
        bossZombieHpLabel.setFont(font);

        battleGroundLabel.add(Battle.toolLabel);
        toolLabel.setBounds(900, 500, 200, 200);

        battleGroundLabel.add(Battle.explainLabel);
        explainLabel.setBounds(450, 750, 1100, 200);
        explainLabel.setFont(font);

        Player.power = 5;
        InventoryMouseEventHandler.isItemClicked = false;

        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void playerTurn()
    {
        BossZombie.bossZombieCurrentHp -= Player.power;
        bossZombieHpLabel.setText(BossZombie.bossZombieCurrentHp + " / " + BossZombie.bossZombieMaxHp);

        if (BossZombie.bossZombieCurrentHp <= 0)
        {
            battleEnd();
            player.winEnd();
        }
        else
        {
            if (InventoryMouseEventHandler.removeItem.equals("기관단총"))
                Player.power++;
            else
                zombieTurn();
        }
    }

    public void zombieTurn()
    {
        accuracyRate = random.nextInt(100);

        if (accuracyRate > Player.evasionRate)
        {
            if (Player.defensivePower == 0)
                Player.CurrentHp -= BossZombie.bossZombiePower;
            else if (Player.defensivePower > 0)
            {
                Player.defensivePower -= BossZombie.bossZombiePower;
                if (Player.defensivePower <= 0)
                {
                    Player.CurrentHp -= Math.abs(Player.defensivePower);
                    Player.defensivePower = 0;
                }
            }

            StringBuilder builder = new StringBuilder();
            builder.append(Player.CurrentHp + " / " + Player.MaxHp + "  " + Player.defensivePower);
            Battle.hpLabel.setText(builder.toString());

            if (Player.CurrentHp <=0)
            {
                battleEnd();
                player.failEnd();
            }
            else
                Battle.explainLabel.setText(ChatGuiClient.name + "이(가) " + Player.power + "만큼의 데미지를 입히고, " + bossZombie.bossZombieName + "에게 " +  BossZombie.bossZombiePower + "만큼의 데미지를 입었다." + ChatGuiClient.name + "은(는) 무엇을 할 것인가?");
        }

        else
            Battle.explainLabel.setText(ChatGuiClient.name + "이(가) " + Player.power + "만큼의 데미지를 입히고, " + BossZombie.bossZombieName + "의 공격을 후라이팬으로 막아냈다!");
    }

    public void battleEnd()
    {
        this.setVisible(false);
    }
}