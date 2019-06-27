package Controllers;

import Views.Console.CreateHeroScreen;
import Views.Console.MenuScreen;
import Views.Console.SelectHeroScreen;
import Views.MenuView;

public class MenuController {

    private MenuView menuView;

    public MenuController(MenuView menuView){
        this.menuView = menuView;
    }

    public void onCreateHero() {
        this.menuView.goToHeroCreate();
    }

    public void onSelectHero() {
        this.menuView.goToHeroSelect();
    }
}
