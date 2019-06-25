package Models.Artifacts;

import java.util.Random;

public class Artifact {
    public static final int HELM = 0;
    public static final int ARMOUR = 1;
    public static final int WEAPON = 2;
    public String[] artifactNames = new String[]{"Rare", "Common", "Legendary", "Black Ice"};

    private int abilityBuff;
    private String name;
    private int type;

    public Artifact(int abilityBuff) {
        Random random = new Random();
        this.abilityBuff = abilityBuff;
        this.name = artifactNames[random.nextInt(4)];
    }

    @Override
    public String toString() {
        return "{abilityBuff= " + abilityBuff + ", rarity= '" + name + "\'}";
    }

    public int getBuff() {
        return this.abilityBuff;
    }

}
