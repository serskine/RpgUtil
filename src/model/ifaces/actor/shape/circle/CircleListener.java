package model.ifaces.actor.shape.circle;

import model.ifaces.actor.ActorListener;

public interface CircleListener extends ActorListener {
	public void radiusChanged(CircleListener source);
}
