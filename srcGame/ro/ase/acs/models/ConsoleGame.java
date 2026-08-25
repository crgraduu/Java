package ro.ase.acs.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConsoleGame extends Game implements Cloneable {
    private GameType GameType;
    public ConsoleGame(String name, String producer, int year, GameType GameType) {
        super(name, producer, year);
        this.GameType = GameType;
    }
    @Override
    public int getPoints() {
        if(GameType == GameType.SINGLE_PLAYER)
            return getLevel()*1000;
        else if (GameType == GameType.MULTI_PLAYER)
            return getLevel()*2000;
        else
            return 0;
    }
    public String GetName() {
        return this.name;
    }
    public String getProducer() {
        return this.producer;
    }
    public int getYear() {
        return this.year;
    }
    public GameType getGameType() {
        return this.GameType;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ConsoleGame) super.clone();
    }
    int NewLevel=0;
    @Override
    public int getLevel() {
        int level = this.NewLevel;
        this.NewLevel++;
        return level;
    }
    @Override
    public String toString() {
        return this.name + " " + this.producer + " " + this.year+ " "+ this.GameType;
    }
    public static Set<Game> JocuriDistincte = new HashSet<>();
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ConsoleGame that = (ConsoleGame) o;
        return this.year== that.year && Objects.equals(this.name,that.name) && Objects.equals(this.producer, that.producer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.producer, this.year);
    }

    public static void newGame(Game game) {
        ConsoleGame.JocuriDistincte.add(game);
    }
    public static Collection<Game> getGames() {
        return new HashSet <Game>(ConsoleGame.JocuriDistincte);
    }
    }
