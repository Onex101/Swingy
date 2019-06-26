package Models;

import Models.Artifacts.Artifact;
import Models.Mobs.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Models.Artifacts.Artifact.ARMOUR;
import static Models.Artifacts.Artifact.HELM;
import static Models.Artifacts.Artifact.WEAPON;

public class SaveLoad {

    private static final String savedGameDir = "src/main/java/Models/savedGames.txt";
    private static File file = new File(savedGameDir);
    private static Scanner sc = null;
    private static List<Hero> heroes = new ArrayList<Hero>();
    SaveLoad(){

    }

    public static void saveGame(Hero hero){
        try {
            FileWriter fr = new FileWriter(file, true);
            fr.write(hero.saveString() + "\n");
            fr.close();
        } catch (IOException e){
            System.out.println("Cannot save game.");
        }
    }

    public static List<Hero> getSaveGames() {
        List<Hero> heroList = new ArrayList<Hero>();

        try {
            sc = new Scanner(file);

            String name;
            String heroClass;
            int level;
            int xpPnts;
            int hpPnts;
            int attackPnts;
            int defencePnts;
            List<Artifact> backpack = new ArrayList<Artifact>();

            while (sc.hasNext()) {
                Artifact[] equipped = new Artifact[3];

                name = sc.next();
                heroClass = sc.next();
                level = sc.nextInt();
                xpPnts = sc.nextInt();
                hpPnts = sc.nextInt();
                attackPnts = sc.nextInt();
                defencePnts = sc.nextInt();
                sc.nextInt();
                try{//need to fix this
                    equipped[0] = new Artifact(sc.next(), sc.nextInt());
                    equipped[1] = new Artifact(sc.next(), sc.nextInt());
                    equipped[2] = new Artifact(sc.next(), sc.nextInt());
                }
                catch(InputMismatchException e){
                    System.out.println("No item equipped");
                }

                Hero oHero;
                switch(heroClass.toUpperCase()){
                    case "C":
                        oHero = new C(name ,level, xpPnts, hpPnts ,attackPnts, defencePnts, null, equipped);
                        break;
                    case "B":
                        oHero = new B(name ,level, xpPnts, hpPnts ,attackPnts, defencePnts, null, equipped);
                        break;
                    case "A":
                        oHero = new A(name ,level, xpPnts, hpPnts ,attackPnts, defencePnts, null, equipped);
                        break;
                    case "S":
                        oHero = new S(name ,level, xpPnts, hpPnts ,attackPnts, defencePnts, null, equipped);
                        break;
                    default:
                        oHero = new Hero(name ,level, xpPnts, hpPnts ,attackPnts, defencePnts, null, equipped);
                        break;
                }
                heroList.add(oHero);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No save games");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid save game");
            e.printStackTrace();
        } catch ( InputMismatchException e){
            System.out.println("Invalid save game " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return (heroList);
    }


}
