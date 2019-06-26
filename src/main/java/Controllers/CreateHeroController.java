package Controllers;

import GameLogic.Main;
import Models.Mobs.*;
import Models.SaveLoad;
import Views.Console.GameScreen;

public class CreateHeroController {

    public CreateHeroController(){}

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
        new GameScreen(Main.getGame());
    }
}
