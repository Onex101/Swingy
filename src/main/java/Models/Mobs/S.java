package Models.Mobs;

import Models.Artifacts.Artifact;
import Models.Items.Item;

import java.util.List;

public class S extends Hero{
    public S(String name){
        super(name
                , 1
                , 0
                , 30
                , 30
                , 30
                , null
                , null);
    }
    public S(String name, int level, int experiencePnts, int maxHitPnts, int maxAttackPnts, int maxDefencePnts, List<Item> backpack, Artifact[] equipped) {
        super(name, level, experiencePnts, maxHitPnts, maxAttackPnts, maxDefencePnts, backpack, equipped);
    }
}
