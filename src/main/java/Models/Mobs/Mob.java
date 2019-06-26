package Models.Mobs;

import Models.Artifacts.Artifact;
import Models.Items.Item;

import java.util.ArrayList;
import java.util.List;

import static Models.Artifacts.Artifact.*;
import static Models.Artifacts.Artifact.HELM;

public abstract class Mob {

    protected String name;
    protected int level;
    protected int attackPnts;
    protected int defencePnts;
    protected int hitPnts;
    protected int experiencePnts;
    protected int maxHitPnts;
    protected int maxAttackPnts;
    protected int maxDefencePnts;
    protected int maxExperiencePnts;
    protected List<Item> backpack = new ArrayList<Item>();
    protected Artifact[] equipped = new Artifact[3];

    public Mob() {
        this.name = "undefined";
        this.level = 0;
        this.attackPnts = 0;
        this.defencePnts = 0;
        this.hitPnts = 0;
        this.experiencePnts = 0;
        this.backpack = null;
        this.equipped = new Artifact[3];
    }

    public Mob(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
        this.name = name;
        this.level = level;

        if (equipped == null)
            this.equipped = new Artifact[3];
        else
            this.equipped = equipped;

        this.maxAttackPnts = maxAttackPnts;
        attackPnts = maxAttackPnts;
        if (this.equipped[WEAPON] != null)
            attackPnts += this.equipped[WEAPON].getBuff();

        this.maxDefencePnts = maxDefencePnts;
        defencePnts = maxDefencePnts;
        if (this.equipped[ARMOUR] != null)
            defencePnts += this.equipped[ARMOUR].getBuff();

        this.maxHitPnts = maxHitPnts;
        hitPnts = maxHitPnts;
        if (this.equipped[HELM] != null)
            hitPnts += this.equipped[HELM].getBuff();

        this.experiencePnts -= maxExperiencePnts;
        maxExperiencePnts = level * 1000 + (int)Math.pow(level - 1, 2) * 450;
        this.backpack = backpack;
    }

    public boolean attack(Mob mob){
        if (this.attackPnts > mob.defencePnts){
            int newHitPnts = mob.hitPnts + mob.defencePnts - this.attackPnts;
            if (newHitPnts <= 0){
                mob.setHitPnts(0);
                return true;
            }
            mob.setHitPnts(newHitPnts);
        }
        else{
            int newHitPnts = mob.hitPnts - 1;
            if (newHitPnts <= 0){
                mob.setHitPnts(0);
                return true;
            }
            mob.setHitPnts(newHitPnts);
        }
        return false;
    }

    public void setHitPnts(int i) {
        this.hitPnts = i;
    }

    public void defend(){}

    public void takeDamage(){}

    public void gainHitPnts(){}

    public String getName() {
        return this.name;
    }

    public int getMaxHitPnts() {
        return maxHitPnts;
    }

    public int getMaxAttackPnts() {
        return maxAttackPnts;
    }

    public int getMaxDefencePnts() {
        return maxDefencePnts;
    }

    public int getHitPnts() {
        return hitPnts;
    }

    public String toStringEquipped() {
        String items = "";
        if (equipped[HELM] != null)
            items += "HELM " + equipped[HELM].toString();
        if (equipped[ARMOUR] != null)
            items += "Armour " + equipped[ARMOUR].toString();
        if (equipped[WEAPON] != null)
            items += "WEAPON " + equipped[WEAPON].toString();
        return items;
    }

    public Artifact[] getEquipped() {
        return equipped;
    }
}
