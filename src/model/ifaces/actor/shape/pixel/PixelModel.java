package model.ifaces.actor.shape.pixel;

import model.ifaces.actor.ActorModel;

public interface PixelModel extends ActorModel {

	public void addPixelListener(PixelListener listener);
	public void removePixelListener(PixelListener listener);
}
