package model.impls.actor;

import java.awt.Point;
import java.awt.Rectangle;

import model.ifaces.actor.ActorListener;
import model.ifaces.actor.ActorModel;
import util.announcer.Announcer;

public abstract class Actor implements ActorModel {

	private Announcer<ActorListener>	listeners = Announcer.to(ActorListener.class);
	protected Point						location = new Point(0,0);

	/**
	 * Collision method used to determine if a point is contained by the actor
	 */
	@Override
	public abstract boolean containsPoint(Point pos);

	/**
	 * Collision method that is used to determine if we should draw the actor on screen
	 */
	@Override
	public abstract boolean touchesBounds(Rectangle bounds);
	
	
	
	@Override
	public void addListener(ActorListener listener) {
		listeners.addListener(listener);
	}

	@Override
	public void removeListener(ActorListener listener) {
		listeners.removeListener(listener);
	}
	
	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public void setLocation(Point location) {
		this.location = location;
		listeners.announce().locationChanged(this);
	}

	@Override
	public void childUpdated(Actor source) {
		listeners.announce().changed(this);
	}

}
