package model.ifaces.actor.set;

import model.ifaces.actor.ActorListener;
import model.ifaces.actor.ActorModel;

public interface SetListener extends ActorListener {
	public void actorRemoved(SetModel source, ActorModel actor);
	public void actorAdded(SetModel source, ActorModel actor);
	public void actorChanged(SetModel source, ActorModel actor);
}
