package model.impls.actor.shape.circle;

import java.awt.Point;
import java.awt.Rectangle;

import model.ifaces.actor.shape.circle.CircleListener;
import model.ifaces.actor.shape.circle.CircleModel;
import model.impls.actor.Actor;
import announcer.Announcer;

public class CircleActor extends Actor implements CircleModel {

	private Announcer<CircleListener> listeners = Announcer.to(CircleListener.class);
	
	private int radius = 0;
	
	/**
	 * Returns the distance from the center of the circle to it's outer edge
	 */
	@Override
	public int getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of the circle
	 */
	@Override
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * This will determine if the sprite contains the specified point
	 */
	@Override
	public boolean containsPoint(Point pos) {
		return (pos.distance(getLocation()) <= getRadius());
	}

	/**
	 * This will determine if a circle touches a rectangle
	 */
	@Override
	public boolean touchesBounds(Rectangle R) {
		int x = getLocation().x;
		int y = getLocation().y;
		int dx = Math.abs(x - R.x);
		int dy = Math.abs(y - R.y);
		
		if (dx > (R.width/2 + radius))	{ return false;	}
		if (dy > (R.height/2 + radius))	{ return false;	}
		if (dx <= (R.width/2))			{ return true;	}
		if (dy <= (R.height/2))			{ return true;	}
		
		double cornerDistSq	=	Math.pow((dx - R.width/2f), 2) 
							+	Math.pow((dy - R.height/2f), 2);
		return (cornerDistSq <= (radius*radius));
	}

	@Override
	public void addCircleListener(CircleListener listener) {
		super.addListener(listener);
		listeners.addListener(listener);
	}

	@Override
	public void removeCircleListener(CircleListener listener) {
		super.removeListener(listener);
		listeners.removeListener(listener);
	}
	
	

}
