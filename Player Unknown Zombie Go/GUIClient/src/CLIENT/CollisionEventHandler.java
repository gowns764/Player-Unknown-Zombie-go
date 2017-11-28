package CLIENT;

public class CollisionEventHandler
{
    Player player = new Player();
    public static boolean isReturn = false;

    public void checkingCollisionToRock()
    {
        if (Math.abs(Player.playerLabel.getX() - player.rock1.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock1.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock2.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock2.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock3.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock3.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock4.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock4.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock5.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock5.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock6.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock6.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
        else if (Math.abs(Player.playerLabel.getX() - player.rock7.getX()) < 50 && Math.abs(Player.playerLabel.getY() - player.rock7.getY()) < 50)
        {
            CollisionEventHandler.isReturn = true;
            return;
        }
    }
}
