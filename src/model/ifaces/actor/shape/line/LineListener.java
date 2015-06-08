package model.ifaces.actor.shape.line;

import model.ifaces.actor.ActorListener;

public interface LineListener extends ActorListener {
	public void endPointChanged(LineModel source);
}
