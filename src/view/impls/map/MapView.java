package view.impls.map;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTree;

import model.ifaces.map.MapModel;
import model.impls.map.Map;
import view.ifaces.map.MapHmiView;
import view.impls.util.MyPanel;

public class MapView extends MyPanel implements MapHmiView {

	protected final		MapModel mapModel;
	protected double	zoom = 1d;
	protected Point		locationOnCanvas = new Point(0,0);
	

	public MapView() {
		this(new Map());
	}
	public MapView(MapModel mapModel) {
		this.mapModel = mapModel;
		mapModel.addMapListener(this);
		setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		add(tree, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		System.err.println("Map view has null map model");
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
