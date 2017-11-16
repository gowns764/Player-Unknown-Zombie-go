package CLIENT;

public class Portion
{
    public Portion()
    {
        if (Player.CurrentHp == Player.MaxHp)
            return;
        else if (Player.CurrentHp < Player.MaxHp)
        {
            Player.CurrentHp += 10;
            if (Player.CurrentHp >= Player.MaxHp)
                Player.CurrentHp = Player.MaxHp;
        }
    }
}
