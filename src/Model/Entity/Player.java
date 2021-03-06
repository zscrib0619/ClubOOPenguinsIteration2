package Model.Entity;

import Controller.SavingLoading.Saver;
import Model.Entity.NPC.NPC;
import Model.Entity.Role.Role;
import Model.Map.Location;
import Model.Saveable;

public class Player extends Entity{
    private Role role;
    private int mana;
    private int gold;
    private Equipment equipment = new Equipment(this);
    private int skillPointsUsed;
    private int skillPointsPerLevel = 5;

    public Player(Role role) {
        this.role = role;
        role.setEntity(this);
        super.setEntityType(EntityType.ICE);// default EntityType
        name = "Player";
    }

    public Player(Role role, EntityType type){
        this.role = role;
        role.setEntity(this);
        super.setEntityType(type);
        name = "Player";
    }

    public Player(Role role, EntityType type, int skillPointsAvailable, Location initialLocation){
        this.role = role;
        role.setEntity(this);
        super.setEntityType(type);
        name = "Player";
        skillPointsUsed = skillPointsPerLevel*getLevel() - skillPointsAvailable;
        super.setLocation(initialLocation);
    }

    public void touchItems(){
        getLocation().itemsTouchedBy(this);
    }

    public void useRoleTraits(){
        role.activateTrait(super.getLocation());
    }

    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    @Override
    public void interactLocation() {
        super.interactLocation();
        touchItems();
        useRoleTraits();
    }

    @Override
    public void interactEntity(Entity entity) {
        ((NPC) entity).talk();
    }

    public Role getRole(){
        return role;
    }

    public int getMana() {
        return mana;
    }

    public void setMaxMana(int maxMana) { role.setMaxMana(maxMana);}

    public int getMaxMana() { return role.getMaxMana(); }

    public void addMana(int mana){
        this.mana += mana;
        if (this.mana > getMaxMana()){
            this.mana = getMaxMana();
        }
        if (this.mana < 0){
            this.mana = 0;
        }
    }

    public int getGold() {
        return gold;
    }

    public void modifyGold(int gold){
        this.gold += gold;
    }

    public int getBargain(){
        return role.getBargain();
    }

    public boolean canIncrementSkill(){
        if(getLevel()*skillPointsPerLevel > skillPointsUsed)
            return true;
        else
            return false;
    }

    public void skillPointIncremented(){
        skillPointsUsed++;
    }

    public int getSkillPointsAvailable(){
        return (getLevel()*skillPointsPerLevel - skillPointsUsed);
    }

    public Equipment getEquipment() {
        return equipment;
    }

}
