package Models.Artifacts;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

public class Artifact {
    public static final int HELM = 0;
    public static final int ARMOUR = 1;
    public static final int WEAPON = 2;
    public String[] artifactNames = new String[]{"Rare", "Common", "Legendary", "Black_Ice"};

    @Max(value=5, message = "Ability buff of artifact needs to be between 0 and 5")
    private int abilityBuff;
    @NotEmpty(message = "Please enter name for artifact")
    private String name;
    @Max(value = 2, message = "Ability type of artifact cannot be greater than 2")
    private int type;

    public Artifact(int abilityBuff) {
        Random random = new Random();
        this.abilityBuff = abilityBuff;
        this.name = artifactNames[random.nextInt(4)];
    }

    public Artifact(String name, int abilityBuff) {
        this.abilityBuff = abilityBuff;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{abilityBuff= " + abilityBuff + ", rarity= '" + name + "\'}";
    }

    public int getBuff() {
        return this.abilityBuff;
    }

    public String getName(){return name;}

}
