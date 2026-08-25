package ro.ase.acs.classes;

import ro.ase.acs.models.ConsoleGame;
import ro.ase.acs.models.Game;
import ro.ase.acs.models.GameType;

public class Main {

    public static void main(String[] args) {
        ConsoleGame CS = new ConsoleGame ("CSGO", "VALVe",2012, GameType.MULTI_PLAYER);
        ConsoleGame NFS = new ConsoleGame ("NFSHeat", "EA", 2021, GameType.MULTI_PLAYER);
        ConsoleGame CS2 = new ConsoleGame ("CSGO","VALVe", 2012, GameType.MULTI_PLAYER);
        ConsoleGame FH = new ConsoleGame ("Forza Horizon 6", "Playground Games", 2026, GameType.MULTI_PLAYER );
        ConsoleGame FHs = new ConsoleGame("Forza Horizon 6", "Playground Games", 2026, GameType.SINGLE_PLAYER );
        ConsoleGame.newGame(CS);
        ConsoleGame.newGame(NFS);
        ConsoleGame.newGame(CS2);
        ConsoleGame.newGame(FH);
        ConsoleGame.newGame(FHs);
        System.out.println(ConsoleGame.JocuriDistincte.size());
        for(Game joc : ConsoleGame.JocuriDistincte)
            System.out.println(joc);
        System.out.println( );
        for(Game joc : ConsoleGame.getGames())
            System.out.println(joc);
    }

}