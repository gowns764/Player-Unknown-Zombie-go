package CLIENT;

import javax.swing.*;
import java.awt.*;

public class Battle extends JFrame
{
    Player player;
    WeakZombie weakZombie = new WeakZombie();
    MouseEventHandler mouseEventHandler = new MouseEventHandler();

    public JLabel battlePlayerLabel = new JLabel(new ImageIcon("player.png"));

    public static int turn = 1;
    private int time = 1000;

    JButton attackButton = null;
    JButton toolButton = null;
    JButton runAwayButton = null;

    private JLabel playerNameLabel = new JLabel(ChatGuiClient.name);
    private JLabel weakZombieNameLabel = new JLabel(WeakZombie.weakZombieName);
    private static JLabel hpLabel = new JLabel(Player.CurrentHp + " / " + Player.MaxHp);
    private static JLabel weakZombieHpLabel = new JLabel(WeakZombie.weakZombieCurrentHp + " / " + WeakZombie.weakZombieMaxHp);

    public static JLabel explainLabel = new JLabel("야생의 " + WeakZombie.weakZombieName + "가 나타났다! " + ChatGuiClient.name +"은(는) 무엇을 할 것인가?");
    public static JLabel toolLabel = new JLabel("");
    JLabel battleGroundLabel = new JLabel(new ImageIcon("BattleGround.png"));
    JLabel weakZombieLabel = new JLabel(new ImageIcon("WeakZombie.png"));

    private Font font = new Font("굴림", Font.BOLD, 20);

    Inventory inventory = new Inventory();

    public Battle()
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

        battleGroundLabel.add(weakZombieLabel);
        weakZombieLabel.setBounds(1550, 200, 250, 250);

        battleGroundLabel.add(weakZombieNameLabel);
        weakZombieNameLabel.setBounds(1600, 350, 200, 50);
        weakZombieNameLabel.setFont(font);

        battleGroundLabel.add(Battle.weakZombieHpLabel);
        weakZombieHpLabel.setBounds(1600, 400, 300, 50);
        weakZombieHpLabel.setFont(font);

        battleGroundLabel.add(Battle.toolLabel);
        toolLabel.setBounds(900, 500, 200, 200);

        battleGroundLabel.add(Battle.explainLabel);
        explainLabel.setBounds(450, 750, 1100, 200);
        explainLabel.setFont(font);

        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void playerTurn()
    {
        WeakZombie.weakZombieCurrentHp -= Player.power;
        weakZombieHpLabel.setText(WeakZombie.weakZombieCurrentHp + " / " + WeakZombie.weakZombieMaxHp);

        if (WeakZombie.weakZombieCurrentHp <= 0)
        {
            inventory.dropTheItem();
            Inventory.countItem++;
            WeakZombie.weakZombieCount++;
            battleEnd();
        }
        else
            zombieTurn();
    }

    public void zombieTurn()
    {
        Player.CurrentHp -= WeakZombie.weakZombiePower;
        StringBuilder builder = new StringBuilder();
        builder.append(Player.CurrentHp + " / " + Player.MaxHp);
        Battle.hpLabel.setText(builder.toString());

        if (Player.CurrentHp <=0)
            battleEnd();

        else
            Battle.explainLabel.setText(ChatGuiClient.name + "이(가) " + Player.power + "만큼의 데미지를 입히고, " + WeakZombie.weakZombieName + "이(가) " +  WeakZombie.weakZombiePower + "만큼의 데미지를 입혔다." + ChatGuiClient.name + "은(는) 무엇을 할 것인가?");
    }

    public void battleEnd()
    {
        WeakZombie.weakZombieCurrentHp = 20;
        weakZombieHpLabel.setText(WeakZombie.weakZombieCurrentHp + " / " + WeakZombie.weakZombieMaxHp);
        Battle.explainLabel.setText("야생의 " + WeakZombie.weakZombieName + "가 나타났다! " + ChatGuiClient.name +"은(는) 무엇을 할 것인가?");

        checkCount();

        this.setVisible(false);
    }

    private void checkCount()
    {
        if (WeakZombie.weakZombieCount == 4)
            Player.noticeLabel.setText("약한 좀비 4마리를 모두 잡으셨습니다.");
    }
}