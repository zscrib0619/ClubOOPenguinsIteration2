package Model.Item.TakeableItem.OneHandedWeaponItem;

import Model.Entity.Entity;
import Model.Entity.NPC.NPC;
import Model.Entity.Player;
import Model.Entity.Role.Smasher;
import Model.Entity.Skill.OneHandedWeapon;
import Model.Item.TakeableItem.TakeableItem;
import Model.Item.TakeableItem.UseableItem;
import Model.Map.Direction;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.World;
import Model.Utilites.Time;

public abstract class OneHandedWeaponItem extends UseableItem {

    private double lastUse;
    protected String color;
    public OneHandedWeaponItem(){
        super();
    }

    public boolean canEquip(Player entity) {
        // ok under OCP
        if(entity.getRole().getClass() == Smasher.class)
            return true;
        else
            return false;
    }

    public void use(Player entityUsingItem, Location locationOfEntity) {
        if(Time.currentInSeconds() > lastUse + getSecondsPerUse()) {

            Smasher role = (Smasher) entityUsingItem.getRole();
            double oneHandedWeaponSkillLevel = (double) role.getOneHandedWeapon();

            Direction directionFacing = entityUsingItem.getDirectionFacing();
            Location locationOfTarget = locationOfEntity.getAdjacentAt(directionFacing);
            Map currentMap = World.getWorld().getCurrentMap();
            if(currentMap.entityAtLocation(locationOfTarget) != null){
                Entity entityAtTarget = currentMap.entityAtLocation(locationOfTarget);

                if(this.color == ((NPC)entityAtTarget).getColor())
                    entityAtTarget.takeDamage( (int)(getDamageAmount()*oneHandedWeaponSkillLevel) * 2);
                else entityAtTarget.takeDamage( (int)(getDamageAmount()*oneHandedWeaponSkillLevel));              }

            lastUse = Time.currentInSeconds();
        }
    }

    protected abstract double getSecondsPerUse();

    protected abstract double getDamageAmount();
}
