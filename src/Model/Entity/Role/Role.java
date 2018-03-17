package Model.Entity.Role;

import Model.Entity.Entity;
import Model.Entity.Player;
import Model.Entity.Skill.Bargain;
import Model.Entity.Skill.BindWounds;
import Model.Entity.Skill.Observation;
import Model.Map.Location;
import javafx.beans.Observable;

public class Role {

    protected Player entity;
    private BindWounds bindWounds;
    private Bargain bargain;
    private Observation observation;

    public Role(){}

    public void setEntity(Player entity){
        this.entity = entity;
    }

    public int getBindWounds(){
        return bindWounds.getPoints();
    }

    public int getBargain(){
        return bargain.getPoints();
    }

    public int getObservation(){
        return observation.getPoints();
    }

    public void addBindWounds(int points){
        bindWounds.addPoints(points);
    }

    public void addBargain(int points){
        bargain.addPoints(points);
    }

    public void addObservation(int points){
        observation.addPoints(points);
    }

    public void bindWounds(){
        bindWounds.use(this.entity);
    }

    public void activateTrait(Location location){}


}
