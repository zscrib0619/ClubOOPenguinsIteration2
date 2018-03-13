package Model.Item.TakeableItem.TwoHandedWeaponItem;

import Model.Entity.Entity;
import Model.Entity.Role.Smasher;
import Model.Item.TakeableItem.TakeableItem;
import Model.Map.Direction;
import Model.Map.Location;
import Model.Utilites.Time;

public class InquisitorLightsaber extends TakeableItem{

    private int damageAmount = 45;
    private double secondsPerUse = 2;
    private double lastUse;

    public boolean canEquip(Entity entity) {
        // ok under OCP
        if(entity.getRole().getClass() == Smasher.class)
            return true;
        else
            return false;
    }

    public void use(Entity entityUsingItem, Location locationOfEntity) {
        if(Time.currentInSeconds() > lastUse + secondsPerUse) {

            Direction directionFacing = entityUsingItem.getDirectionFacing();
            Location locationOfTarget = locationOfEntity.getAdjacentAt(directionFacing);
            // TODO: if Entity on locationOfTarget: decrement Entity's health based on skill level
            Smasher role = (Smasher) entityUsingItem.getRole();
            int oneHandedWeaponSkillLevel = role.getOneHandedWeapon();

            lastUse = Time.currentInSeconds();
        }
    }
}
