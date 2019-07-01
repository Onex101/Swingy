package Controllers;

import GameLogic.Main;
import Models.Mobs.Hero;
import Models.SaveLoad;
import Views.Console.GameScreen;
import Views.SelectHeroView;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SelectHeroController {

    @NotNull(message = "View cannot be null")
    SelectHeroView view;

    public SelectHeroController(SelectHeroView view){
        this.view = view;
    }


    public List<Hero> getSaveGames(){
        return SaveLoad.getSaveGames();
    }

    public void onHeroSelect(Hero hero) {
        Main.getGame().initGame(hero);
        view.goToGame();
    }

    public void goToHeroCreate() {
        view.goToHeroCreate();
    }
}
