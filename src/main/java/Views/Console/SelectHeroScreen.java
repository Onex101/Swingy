package Views.Console;

import Controllers.SelectHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;

import java.util.List;
import java.util.Scanner;

public class SelectHeroScreen {

    private SelectHeroController controller = new SelectHeroController();
    private List<Hero> heroList;

    public void Display() {
        heroList = controller.getSaveGames();
        int heroListSize = heroList.size();
        if (heroListSize <= 0)
            controller.goToHeroCreate();

        System.out.println("Please select a character by their index");
        for (int i = 0; i < heroListSize; ++i){
            System.out.println(heroList.get(i).toString());
        }
        Scanner oScanner = Main.getScanner();
        while (oScanner.hasNext()) {
            int input = oScanner.nextInt();

            if (input < heroListSize) {
                controller.onHeroSelect(heroList.get(input));
                break;
            }
            else {
                System.out.println("Unknown command");
            }
        }

    }
}
