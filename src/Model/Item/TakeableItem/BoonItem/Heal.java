package Model.Item.TakeableItem.BoonItem;

import Model.Entity.Entity;
import Model.Entity.Role.Summoner;
import Model.Entity.Skill.Boon;
import Model.Item.TakeableItem.TakeableItem;
import Model.Map.Location;

import java.util.Random;

public class Heal extends BoonItem {

    private int healingIncrement = 40;

    @Override
    protected void apply(Entity entityUsingItem) {
        entityUsingItem.heal(healingIncrement);
    }
}
