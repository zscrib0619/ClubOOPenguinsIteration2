package Model.Item.TakeableItem.BaneItem;

import Controller.SavingLoading.Saver;
import Model.Entity.Entity;
import Model.Item.TakeableItem.Projectile.LinearProjectile;
import Model.Item.TakeableItem.Projectile.Projectile;
import Model.Map.Direction;
import Model.Map.Location;

public class LinearIceAttack extends BaneItem {

    public LinearIceAttack(){
        super();
        this.name = "linearIceAttack";
    }

    private int manaNeeded = 10;

    private double damageAmount = 1.0;
    private double linearDecreaseFactor = 0.25;

    private double speed = 0.75;

    @Override
    protected int getManaNeeded() {
        return manaNeeded;
    }

    @Override
    protected void apply(Location locationOfEntity, Direction directionFacing, int baneSkillLevel) {
        Projectile projectile = new LinearProjectile(damageAmount*baneSkillLevel,
                linearDecreaseFactor*baneSkillLevel,
                speed, locationOfEntity, directionFacing,"Linear Ice");

        super.addProjectile(projectile);
    }

    @Override
    public String save(Saver saver) {
        return saver.saveLinearIceAttack(this);
    }
}
