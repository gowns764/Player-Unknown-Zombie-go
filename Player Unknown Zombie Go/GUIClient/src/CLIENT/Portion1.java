package CLIENT;

public class Portion1 extends Item
{
    public Portion1()
    {
        setName("소용량 포션");
        setPower(0);

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
