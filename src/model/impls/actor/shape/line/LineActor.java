package model.impls.actor.shape.line;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import model.ifaces.actor.shape.line.LineListener;
import model.ifaces.actor.shape.line.LineModel;
import model.impls.actor.Actor;
import announcer.Announcer;

public class LineActor extends Actor implements LineModel {

	private Point	endPoint = new Point(0,0);
	
	private Announcer<LineListener>	listeners = Announcer.to(LineListener.class);
	
	@Override
	public boolean touchesBounds(Rectangle bounds) {
		return getLine().intersects(bounds);
	}

	@Override
	public Point getEndPoint() {
		return endPoint;
	}

	@Override
	public void setEndPoint(Point pos) {
		this.endPoint = pos;
		listeners.announce().endPointChanged(this);
	}

	@Override
	public boolean containsPoint(Point pos) {
		return getLine().contains(pos);
	}

	@Override
	public void addLineListener(LineListener listener) {
		super.addListener(listener);
		listeners.addListener(listener);
	}

	@Override
	public void removeLineListener(LineListener listener) {
		super.removeListener(listener);
		listeners.removeListener(listener);
	}

	@Override
	public Line2D getLine() {
		return new Line2D.Double(getLocation(), getEndPoint());
	}

}
