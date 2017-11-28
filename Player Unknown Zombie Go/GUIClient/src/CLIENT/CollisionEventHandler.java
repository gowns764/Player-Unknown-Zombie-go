package CLIENT;

public class CollisionEventHandler
{
    Player player = new Player();
    public static boolean isReturn = false;

    public void checkingCollisionToRock()
    {
        if (Math.abs(Player.playerLabel.getX() - player.rock1.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock1.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock2.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock2.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock3.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock3.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock4.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock4.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock5.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock5.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock6.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock6.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock7.getX()) < 100 && Math.abs(Player.playerLabel.getY() - player.rock7.getY()) < 100)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
    }
}
