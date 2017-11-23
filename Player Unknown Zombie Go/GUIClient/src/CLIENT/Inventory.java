package CLIENT;

import java.util.Random;

public class Inventory
{
    ItemList itemList = new ItemList();

    private Random random = new Random();
    private int item;

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

    }

    private void dropTheSMG()
    {

    }

    private void dropTheAR()
    {

    }

    private void dropThePortion1()
    {

    }

    private void dropThePortion2()
    {

    }

    private void dropTheFlyingFan()
    {

    }
}