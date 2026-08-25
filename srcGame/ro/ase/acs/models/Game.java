package ro.ase.acs.models;
import ro.ase.acs.contracts.Gameable;

public abstract class Game implements Gameable, Cloneable {
    protected String name;
    protected String producer;
    protected int year;

    public Game (String name,String producer,int year)
    {
        this.name = name;
        this.producer = producer;
        this.year = year;
    }
    @Override
    public int getLevel() {
        return 1;
    }
    public abstract int getPoints();
}

