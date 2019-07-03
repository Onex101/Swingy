package Views.Console;

import Controllers.SelectHeroController;
import GameLogic.Main;
import Models.Mobs.Hero;

import java.util.List;
import java.util.Scanner;

public class SelectHeroScreen implements Views.SelectHeroView {

    private SelectHeroController controller;
    private List<Hero> heroList;

    SelectHeroScreen(){
        controller = new SelectHeroController(this);
    }

    @Override
    public void display() {
        heroList = controller.getSaveGames();
        int heroListSize = heroList.size();
        if (heroListSize <= 0){
            controller.goToHeroCreate();
        }
        else{
            System.out.println("Please select a character by their index");
            for (int i = 0; i < heroListSize; ++i){
                System.out.println("Hero Index:" + i);
                System.out.println(heroList.get(i).toString());
            }
            Scanner oScanner = Main.getScanner();
            while (oScanner.hasNext()) {
                String input = oScanner.next();

                if (Integer.parseInt(input) < heroListSize) {
                    controller.onHeroSelect(heroList.get(Integer.parseInt(input) ));
                    break;
                }
                else {
                    System.out.println("Unknown command");
                }
            }
        }


    }

    @Override
    public void goToGame(){
        new GameScreen(Main.getGame()).display(Main.getGame());
    }

    @Override
    public void goToHeroCreate(){
        new CreateHeroScreen().display();
    }
}
