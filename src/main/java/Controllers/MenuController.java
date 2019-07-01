package Controllers;

import Views.Console.CreateHeroScreen;
import Views.Console.MenuScreen;
import Views.Console.SelectHeroScreen;
import Views.MenuView;

import javax.validation.constraints.NotNull;

public class MenuController {

    @NotNull(message = "View cannot be null")
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
