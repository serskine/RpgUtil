package model.ifaces.actor.shape.pixel;

import model.ifaces.actor.ActorListener;

public interface PixelListener extends ActorListener {
	public void addPixelListener(PixelListener listener);
	public void removePixelListener(PixelListener listener);
}
