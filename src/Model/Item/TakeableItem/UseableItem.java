package Model.Item.TakeableItem;

import Model.Entity.Entity;
import Model.Entity.Player;
import Model.Map.Location;

public abstract class UseableItem extends TakeableItem {

    public UseableItem(){
        value = 30;
    }

    public abstract void use(Player entityUsingItem, Location locationOfEntity);
}
