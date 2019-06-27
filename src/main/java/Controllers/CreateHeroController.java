package Controllers;

import GameLogic.Main;
import Models.Mobs.*;
import Models.SaveLoad;
import Views.Console.GameScreen;
import Views.CreateHeroView;
import Views.GameView;

public class CreateHeroController {

    private final CreateHeroView createHeroView;

    public CreateHeroController(CreateHeroView createHeroView){
        this.createHeroView = createHeroView;
    }

    public void onCreateHero(String name, String heroClass) {
        Hero oHero;
        switch(heroClass.toUpperCase()){
            case "C":
                oHero = new C(name);
                break;
            case "B":
                oHero = new B(name);
                break;
            case "A":
                oHero = new A(name);
                break;
            case "S":
                oHero = new S(name);
                break;
            default:
                oHero = new Hero(name);
                break;
        }
        SaveLoad.saveGame(oHero);
        Main.getGame().initGame(oHero);
        createHeroView.goToGame();
    }
}
