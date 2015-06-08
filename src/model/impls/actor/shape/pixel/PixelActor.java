package model.impls.actor.shape.pixel;

import java.awt.Point;
import java.awt.Rectangle;

import model.ifaces.actor.shape.pixel.PixelListener;
import model.ifaces.actor.shape.pixel.PixelModel;
import model.impls.actor.Actor;
import announcer.Announcer;

public class PixelActor extends Actor implements PixelModel {
	
	private Announcer<PixelListener>	listeners = Announcer.to(PixelListener.class);

	@Override
	public boolean containsPoint(Point pos) {
		return pos.equals(location);
	}

	@Override
	public void addPixelListener(PixelListener listener) {
		super.removeListener(listener);
		listeners.addListener(listener);
	}

	@Override
	public void removePixelListener(PixelListener listener) {
		super.removeListener(listener);
		listeners.removeListener(listener);
	}

	@Override
	public boolean touchesBounds(Rectangle bounds) {
		return bounds.contains(location);
	}

}
