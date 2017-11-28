package CLIENT;

public class Item
{
    public String name = "";
    public int power = 0;
    public int defensivePower = 0;
    public double evasionRate = 0.0;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public void setDefensivePower(int defensivePower)
    {
        this.defensivePower = defensivePower;
    }

    public void setEvasionRate(double evasionRate)
    {
        this.evasionRate = evasionRate;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPower()
    {
        return this.power;
    }

    public int getDefensivePower()
    {
        return this.defensivePower;
    }

    public double getEvasionRate()
    {
        return this.evasionRate;
    }
}
