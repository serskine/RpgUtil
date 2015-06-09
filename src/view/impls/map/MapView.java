package view.impls.map;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTree;

import model.ifaces.actor.ActorModel;
import model.ifaces.actor.set.SetModel;
import model.ifaces.actor.shape.circle.CircleModel;
import model.ifaces.actor.shape.line.LineModel;
import model.ifaces.actor.shape.pixel.PixelModel;
import model.ifaces.actor.shape.rectangle.RectangleModel;
import model.ifaces.actor.shape.rectangle.image.ImageModel;
import model.ifaces.map.MapModel;
import model.impls.actor.set.SetActor;
import model.impls.map.Map;
import view.ifaces.map.MapHmiView;
import view.impls.util.MyPanel;

public class MapView extends MyPanel implements MapHmiView {

	protected final		MapModel mapModel;
	protected double	zoom = 1d;
	protected Point		locationOnCanvas = new Point(0,0);
	
	private HashMap<Class<? extends ActorModel>, ModelPainter> painterMap = new HashMap<>();
	private final DoNothingPainter doNothingPainter = new DoNothingPainter();
	
	public MapView() {
		this(new Map());
		painterMap.put(SetModel.class, new SetModelPainter());
		painterMap.put(CircleModel.class, new CircleModelPainter());
		painterMap.put(LineModel.class, new LineModelPainter());
		painterMap.put(PixelModel.class, new PixelModelPainter());
		painterMap.put(RectangleModel.class, new RectangleModelPainter());
		painterMap.put(ImageModel.class, new ImageModelPainter());
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
			super.refresh();
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
	
	@Override
	public void paintComponent(Graphics G) {
		SetActor	root = mapModel.getRoot();
		paintActor(G, root);
	}
	
	/**
	 * This will determine the painter that should should be used to draw the sprite on screen.
	 * It will then invoke it's paint method
	 * @param G
	 * @param model
	 */
	private void paintActor(Graphics G, ActorModel actorModel) {
		if (actorModel.touchesBounds(getCanvasBounds())) {
			ModelPainter painter = painterMap.get(actorModel.getClass());
			if (painter==null) {
				painter = doNothingPainter;
			}
			painter.paint(G, actorModel);
		}
	}

	
	
	private interface ModelPainter {

		public void paint(Graphics g, ActorModel model);
	}
	
	private class SetModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			SetModel setModel = (SetModel) model;
			for(ActorModel actor : setModel.getChildren()) {
				paintActor(G, actor);
			}
		}
	}
	
	private class CircleModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			
		}
	}
	
	private class LineModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			// TODO Auto-generated method stub
		}
	}
	
	private class PixelModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			// TODO Auto-generated method stub
		}
	}
	
	private class RectangleModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			// TODO Auto-generated method stub
		}
	}
	
	private class ImageModelPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			// TODO Auto-generated method stub
		}
	}
	
	private class DoNothingPainter implements ModelPainter {
		@Override
		public void paint(Graphics G, ActorModel model) {
			// TODO Auto-generated method stub
		}
	}		
	
	
	
	
}
