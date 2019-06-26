package Controllers;

import Views.Console.CreateHeroScreen;
import Views.Console.MenuScreen;
import Views.Console.SelectHeroScreen;

public class MenuController {

    private MenuScreen menuScreen;

    public MenuController(){}

    public void onCreateHero() {
        new CreateHeroScreen().Display();
    }

    public void onSelectHero() {
        new SelectHeroScreen().Display();
    }
}
