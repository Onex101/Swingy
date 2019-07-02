package Models;

import Models.Artifacts.Artifact;
import Models.Mobs.Hero;
import Models.Mobs.Monster;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;


public class Game {

    @NotNull (message = "Hero cannot be null")
    private Hero hero;
    private int heroX;
    private int heroY;
    private int mapSize;
    @Min(value = 1, message = "Round cannot be less than 1")
    private int round;
    @NotNull (message = "Map cannot be null")
    private int[][] map;

    static final int HERO = 1;
    static final int MONSTER = 2;

    public Game() {
    }

    public void initGame(Hero hero) {
        this.hero = hero;
        this.mapSize = (this.hero.getLevel() - 1) * 5 + 10 - (this.hero.getLevel() % 2);
        this.heroX = mapSize / 2;
        this.heroY = mapSize / 2;
        this.map = new int[mapSize][mapSize];
        this.map[this.heroY][this.heroX] = HERO;
        if (this.round < 1)
            this.round = 1;
        generateMonsters();
    }

    public void setHeroCoordinates(int x, int y){
        this.heroX = x;
        this.heroY = y;
    }

    public void generateMonsters(){
        int rand;
        int level = this.hero.getLevel();
        Random randomGenerator = new Random(System.nanoTime());
        for (int i = 0; i < this.mapSize; i++) {
            for (int j = 0; j < this.mapSize; j++) {
                rand = randomGenerator.nextInt(100);
                if ((rand <= level * 10) && map[i][j] == 0)
                    map[i][j] = MONSTER;
            }
        }
    }

    public Monster randomMonster(){
        Random random = new Random(System.nanoTime());
        String[] monsterNames = new String[]{"Vaccine Man",
                                            "Crablante",
                                            "Fukegao",
                                            "Marugori",
                                            "Subterraneans",
                                            "Mosquito Girl",
                                            "Doctor Genus",
                                            "Hammerhead",
                                            "Super Custom YO649Z Mk. II",
                                            "Kombu Infinity",
                                            "Deep Sea King",
                                            "Ancient King",
                                            "Sky King",
                                            "Dark Matter Thieve",
                                            "Garou"};
        Artifact artifact = new Artifact(random.nextInt(3)+1);
        Artifact[] equipped = new Artifact[3];
        equipped[random.nextInt(3)] = artifact;
        return new Monster(monsterNames[random.nextInt(15)]
                            , this.hero.getLevel()
                            , 0
                            , random.nextInt(this.hero.getMaxHitPnts() + 1)
                            , random.nextInt(this.hero.getMaxAttackPnts() + 1)
                            , random.nextInt(this.hero.getMaxDefencePnts() + 1)
                            , null
                            , equipped);
    }


    public Hero getHero(){
        return this.hero;
    }

    public int getHeroX(){return heroX;}
    public int getHeroY(){return heroY;}

    public int getRound() {
        return this.round;
    }

    public void newRound() {
        this.round++;
        initGame(this.hero);
    }

    public int getMapSize() {
        return this.mapSize;
    }

    public boolean checkForMonster(){
        try{
            if (map[heroY][heroX] == MONSTER){
                return true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }

        return false;
    }

    public int[][] getMap() {
        return this.map;
    }

    public int fight(Monster monster) {
        while (this.hero.getHitPnts() > 0){
            if (this.hero.attack(monster)){
                this.hero.gainExperince((monster.getMaxAttackPnts() + monster.getMaxDefencePnts() + monster.getMaxHitPnts()) * 50);
                return 1;
            }
            monster.attack(this.hero);
        }
        return -1;
    }

    public boolean moveHero(int x, int y, int prevX, int prevY) {

        boolean checkMonster = false;

        try{
            map[prevY][prevX] = 0;
            setHeroCoordinates(x, y);
            if (checkForMonster())
                checkMonster = true;
            return checkMonster;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return checkMonster;
        }
    }

    public void setMap() {
        if (heroY >= 0 && heroY < mapSize && heroX >= 0 && heroX < mapSize)
            map[heroY][heroX] = HERO;
    }
}
