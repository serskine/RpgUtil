package model.ifaces.actor.shape;

import java.awt.Color;

import model.ifaces.actor.ActorModel;

public interface ShapeModel extends ActorModel {
	public Color getBackgroundColor();
	public Color getForegroundColor();
	public void setForegroundColor(Color color);
	public void setBackgroundColor(Color color);
	
}
