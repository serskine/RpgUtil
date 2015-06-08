package model.ifaces.actor.shape.circle;

import model.ifaces.actor.ActorModel;

public interface CircleModel extends ActorModel {
	
	public void addCircleListener(CircleListener listener);
	public void removeCircleListener(CircleListener listener);
	public int getRadius();
	public void setRadius(int radius);
}
