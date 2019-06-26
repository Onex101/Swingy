package Models.Mobs;

import Models.Artifacts.Artifact;
import Models.Items.Item;

import java.util.List;

public class B extends Hero{

    public B(String name){
        super(name
                , 1
                , 0
                , 15
                , 15
                , 15
                , null
                , null);
    }

    public B(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
        super(name, level, experiencePnts, maxHitPnts, maxAttackPnts, maxDefencePnts, backpack, equipped);
    }
}
