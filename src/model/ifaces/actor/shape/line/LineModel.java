package model.ifaces.actor.shape.line;

import java.awt.Point;
import java.awt.geom.Line2D;

import model.ifaces.actor.ActorModel;

public interface LineModel extends ActorModel {

	public Point	getEndPoint();
	public void		setEndPoint(Point pos);

	public Line2D getLine();
	
	public void addLineListener(LineListener listener);
	public void removeLineListener(LineListener listener);
}
