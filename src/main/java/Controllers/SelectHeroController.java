package Controllers;

import GameLogic.Main;
import Models.Mobs.Hero;
import Models.SaveLoad;
import Views.Console.GameScreen;

import java.util.List;

public class SelectHeroController {
    public List<Hero> getSaveGames(){
        return SaveLoad.getSaveGames();
    }

    public void onHeroSelect(Hero hero) {
        Main.getGame().initGame(hero);
        new GameScreen(Main.getGame());
    }

    public void goToHeroCreate() {
        new MenuController().onCreateHero();
    }
}
