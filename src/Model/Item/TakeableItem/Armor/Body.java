package Model.Item.TakeableItem.Armor;

import Controller.SavingLoading.Saver;
import Model.Entity.Player;
import Model.Item.TakeableItem.WearableItem;

public class Body extends WearableItem {
    @Override
    public void putOn(Player player) {

    }

    @Override
    public void takeOff(Player player) {

    }

    @Override
    public String getSlot() {
        return null;
    }

    @Override
    public String save(Saver saver) {
        return saver.saveBody(this);
    }
}
