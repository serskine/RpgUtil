package model.impls.actor.shape.rectangle;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import model.ifaces.actor.shape.rectangle.RectangleListener;
import model.ifaces.actor.shape.rectangle.RectangleModel;
import model.impls.actor.Actor;
import util.announcer.Announcer;

public class RectangleActor extends Actor implements RectangleModel {

	private Dimension size = new Dimension(1,1);
	
	private Announcer<RectangleListener>	listeners = Announcer.to(RectangleListener.class);
	
	@Override
	public boolean containsPoint(Point pos) {
		return getBounds().contains(pos);
	}

	@Override
	public Dimension getSize() {
		return size;
	}

	@Override
	public void setSize(Dimension size) {
		this.size = size;
		listeners.announce().sizeChanged(this);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(getLocation(), getSize());
	}

	@Override
	public boolean touchesBounds(Rectangle bounds) {
		return bounds.intersects(getBounds());
	}

	@Override
	public void addRectangleListener(RectangleListener listener) {
		super.addListener(listener);
		listeners.addListener(listener);
	}

	@Override
	public void removeRectangleListener(RectangleListener listener) {
		super.removeListener(listener);
		listeners.removeListener(listener);
	}

}
