package Models;

import java.util.List;

public class Hero extends Entity {

    public Hero() {
        super();
    }

    public Hero(String name, int level, int attackPnts, int defencePnts, int hitPnts, int experiencePnts, List<Items> backpack, List<Artifacts> equipped) {
        super(name, level, attackPnts, defencePnts, hitPnts, experiencePnts, backpack, equipped);
    }

    public void gainExperince(){}
    public void levelUp(){}
    public void unequipArtifact(){}
    public void lootEnemy(){}
    public void equipArtifact(){}

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attackPnts=" + attackPnts +
                ", defencePnts=" + defencePnts +
                ", hitPnts=" + hitPnts +
                ", experiencePnts=" + experiencePnts +
                ", backpack=" + backpack +
                ", equipped=" + equipped +
                '}';
    }
}
