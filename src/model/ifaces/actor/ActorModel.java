package model.ifaces.actor;

import java.awt.Point;
import java.awt.Rectangle;

import model.impls.actor.Actor;

public interface ActorModel {
	public void addListener(ActorListener listener);
	public void removeListener(ActorListener listener);	
	
	public Point		getLocation();
	public void			setLocation(Point location);
	public boolean		touchesBounds(Rectangle bounds);
	public boolean		containsPoint(Point pos);
	
	public void childUpdated(Actor source);
	
}
