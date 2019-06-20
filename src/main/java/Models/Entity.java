package Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected String name;
    protected int level;
    protected int attackPnts;
    protected int defencePnts;
    protected int hitPnts;
    protected int experiencePnts;
    protected List<Items> backpack = new ArrayList<Items>();
    protected List<Artifacts> equipped = new ArrayList<Artifacts>();

    public Entity() {
        this.name = "undefined";
        this.level = 0;
        this.attackPnts = 0;
        this.defencePnts = 0;
        this.hitPnts = 0;
        this.experiencePnts = 0;
        this.backpack = null;
        this.equipped = null;
    }

    public Entity(String name, int level, int attackPnts, int defencePnts, int hitPnts, int experiencePnts, List<Items> backpack, List<Artifacts> equipped) {
        this.name = name;
        this.level = level;
        this.attackPnts = attackPnts;
        this.defencePnts = defencePnts;
        this.hitPnts = hitPnts;
        this.experiencePnts = experiencePnts;
        this.backpack = backpack;
        this.equipped = equipped;
    }

    public void attack(){}

    public void defend(){}

    public void takeDamage(){}

    public void gainHitPnts(){}
}
