package view.ifaces.map;

import java.awt.Point;
import java.awt.Rectangle;

import model.ifaces.map.MapListener;

public interface MapHmiView extends MapListener {
	public Rectangle getScreenBounds();
	public Rectangle getCanvasBounds();
	
	public double getZoom();
	public double setZoom(double zoom);
	public void setLocationOnCanvas(Point canvasPoint);
	public Point getLocationOnCanvas();
}
