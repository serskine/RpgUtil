package model.ifaces.actor.shape.rectangle;

import java.awt.Dimension;
import java.awt.Rectangle;

import model.ifaces.actor.ActorModel;

public interface RectangleModel extends ActorModel {
	public Dimension getSize();
	public void setSize(Dimension size);
	
	public Rectangle getBounds();
	
	public void addRectangleListener(RectangleListener listener);
	public void removeRectangleListener(RectangleListener listener);
}
