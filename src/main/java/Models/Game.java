package Models;

import Models.Artifacts.Artifact;
import Models.Mobs.Hero;
import Models.Mobs.Monster;

import java.util.Random;


public class Game {
    private Hero hero;
    private int heroX;
    private int heroY;
    private int mapSize;
    private int round;
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
                rand = randomGenerator.nextInt(50);
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
        initGame(this.hero);
        this.round++;
    }

    public int getMapSize() {
        return this.mapSize;
    }

    public boolean checkForMonster(){
        if (map[heroY][heroX] == MONSTER){
            return true;
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
        map[prevY][prevX] = 0;
        setHeroCoordinates(x, y);
        boolean checkMonster = false;
        if (checkForMonster())
            checkMonster = true;
        return checkMonster;
    }

    public void setMap() {
        map[heroY][heroX] = HERO;
    }
}
