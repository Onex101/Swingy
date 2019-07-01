package Controllers;

import GameLogic.Main;
import Models.Mobs.*;
import Models.SaveLoad;
import Views.CreateHeroView;

import javax.validation.constraints.NotNull;

public class CreateHeroController {

    @NotNull (message = "View cannot be null")
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
                oHero = new HeroBuilder().setName(name).createHero();
                break;
        }
        SaveLoad.saveGame(oHero);
        Main.getGame().initGame(oHero);
        createHeroView.goToGame();
    }
}
