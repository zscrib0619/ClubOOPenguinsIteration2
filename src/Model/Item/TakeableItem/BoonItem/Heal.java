package Model.Item.TakeableItem.BoonItem;

import Controller.SavingLoading.Saver;
import Model.Entity.Entity;
import Model.Entity.Role.Summoner;
import Model.Entity.Skill.Boon;
import Model.Item.TakeableItem.TakeableItem;
import Model.Map.Location;

import java.util.Random;

public class Heal extends BoonItem {

    public Heal(){
        super();
        this.name = "heal";
    }

    private int manaNeeded = 5;
    private int healingIncrement = 40;

    @Override
    protected int getManaNeeded() {
        return manaNeeded;
    }

    @Override
    protected void apply(Entity entityUsingItem) {
        entityUsingItem.heal(healingIncrement);
    }

    @Override
    public String save(Saver saver) {
        return saver.saveHeal(this);
    }
}
