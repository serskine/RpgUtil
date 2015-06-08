package view.impls.map;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import model.ifaces.map.MapModel;
import view.ifaces.map.MapHmiView;

public class MapView extends JPanel implements MapHmiView {

	protected final		MapModel mapModel;
	protected double	zoom = 1d;
	protected Point		locationOnCanvas = new Point(0,0);
	
	
	public MapView(MapModel mapModel) {
		this.mapModel = mapModel;
	}
	
	@Override
	public void mapChanged(MapModel source) {
		if (mapModel.touchesBounds(getCanvasBounds())) {
			// TODO: Redraw
		}
	}

	@Override
	public Rectangle getScreenBounds() {
		return this.getBounds();
	}

	@Override
	public Rectangle getCanvasBounds() {
		Rectangle screenBounds = getScreenBounds();
		
		double width = (screenBounds.getWidth() * zoom);
		double height = (screenBounds.getHeight() * zoom);
		
		double x = locationOnCanvas.getX();
		double y = locationOnCanvas.getY();
		
		return new Rectangle(
			(int) (getLocationOnCanvas().getX() - width/2d),
			(int) (getLocationOnCanvas().getX() - height/2),
			(int) width,
			(int) height
		);
	}

	@Override
	public double getZoom() {
		return zoom;
	}

	@Override
	public double setZoom(double zoom) {
		return this.zoom = zoom;
	}

	@Override
	public void setLocationOnCanvas(Point canvasPoint) {
		this.locationOnCanvas = canvasPoint;
	}

	@Override
	public Point getLocationOnCanvas() {
		return locationOnCanvas;
	}
}
