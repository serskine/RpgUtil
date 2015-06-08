package model.ifaces.actor.shape.rectangle;

import model.ifaces.actor.ActorListener;

public interface RectangleListener extends ActorListener {
	public void sizeChanged(RectangleModel source);
}
