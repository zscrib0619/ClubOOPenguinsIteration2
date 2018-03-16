package Controller.SavingLoading;

import Model.Entity.Entity;
import Model.Entity.Equipment;
import Model.Entity.Inventory;
import Model.Entity.Player;
import Model.Entity.Skill.Skill;
import Model.Map.Location;
import Model.Map.Map;
import Model.Map.World;

public interface Saver {

    public void savePlayer(Player entity);
    public void saveWorld(World world);

}
