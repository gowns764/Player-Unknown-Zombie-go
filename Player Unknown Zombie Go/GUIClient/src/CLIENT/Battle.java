package CLIENT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Battle extends JFrame {
    WeakZombie weakZombie = new WeakZombie();
    private int turn = 1;

    public static JButton attackButton = new JButton("공격");
    JButton toolButton = new JButton("도구");
    JButton runAwayButton = new JButton("도망");

    public static JLabel hpLabel = new JLabel(Player.CurrentHp + " / " + Player.MaxHp);
    public static JLabel weakZombieHpLabel = new JLabel(WeakZombie.weakZombieName + "\n" + WeakZombie.weakZombieCurrentHp + " / " + WeakZombie.weakZombieMaxHp);

    JLabel turnLabel = new JLabel(turn + " 번째 턴");
    JLabel explainLabel = new JLabel("전투가 시작되었습니다. 무엇을 하시겠습니까?");
    JLabel battleGroundLabel = new JLabel(new ImageIcon("BattleGround.png"));
    JLabel weakZombieLabel = new JLabel(new ImageIcon("WeakZombie.png"));



    public Battle()
    {
        super("Player Unknown Zombie Go");
    }

    public void startBattle() {
        Font font = new Font("굴림", Font.BOLD, 20);

        battleGroundLabel.setBounds(0, 0, 1920, 1080);
        this.add(battleGroundLabel);

        battleGroundLabel.add(attackButton);
        attackButton.setBounds(400, 700, 200, 100);

        battleGroundLabel.add(toolButton);
        toolButton.setBounds(800, 700, 200, 100);

        battleGroundLabel.add(runAwayButton);
        runAwayButton.setBounds(1200, 700, 200, 100);

        battleGroundLabel.add(Player.playerLabel);
        Player.playerLabel.setBounds(100, 600, 250, 250);

        battleGroundLabel.add(hpLabel);
        hpLabel.setBounds(100, 800, 200, 100);
        hpLabel.setFont(font);

        battleGroundLabel.add(weakZombieLabel);
        weakZombieLabel.setBounds(1600, 200, 250, 300);

        battleGroundLabel.add(weakZombieHpLabel);
        weakZombieHpLabel.setBounds(1600, 400, 300, 150);
        weakZombieHpLabel.setFont(font);

        battleGroundLabel.add(explainLabel);
        explainLabel.setBounds(600, 400, 500, 200);
        explainLabel.setFont(font);

        battleGroundLabel.add(turnLabel);
        turnLabel.setBounds(800, 0, 250, 100);

        playBattle();

        this.setLayout(null);this.setSize(1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void playBattle()
    {
        while (true)
        {
            attackButton.addActionListener(new MouseEventHandler());
            if (MouseEventHandler.isClicked)
                nextTurn();
                break;
        }

    }

    public void nextTurn()
    {
        turn++;
        MouseEventHandler.isClicked = false;
        turnLabel.setText(turn + " 번째 턴");
        explainLabel.setText(WeakZombie.weakZombieName + "가(이) 공격하였습니다.");
        Player.CurrentHp -= WeakZombie.weakZombiePower;
        hpLabel.setText(Player.CurrentHp + " / " + Player.MaxHp);
    }
}