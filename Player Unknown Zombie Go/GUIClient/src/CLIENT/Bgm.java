package CLIENT;


import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Bgm extends Thread implements Runnable
{
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Bgm(boolean isLoop)
    {
        try
        {
            this.isLoop = isLoop;
            file = new File("BGM.mp3");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run()
    {
        try
        {
            do
            {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
