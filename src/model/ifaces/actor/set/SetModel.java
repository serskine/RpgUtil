package model.ifaces.actor.set;

import model.ifaces.actor.ActorListener;
import model.ifaces.actor.ActorModel;
import model.impls.actor.Actor;

public interface SetModel extends ActorModel, ActorListener {
	public void addActor(Actor actor);
	public void removeActor(Actor actor);
	
	public void addSetListener(SetListener listener);
	public void removeSetListener(SetListener listener);
	

}
