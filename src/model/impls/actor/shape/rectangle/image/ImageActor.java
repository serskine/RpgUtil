package model.impls.actor.shape.rectangle.image;

import javax.swing.ImageIcon;

import model.ifaces.actor.shape.rectangle.image.ImageListener;
import model.ifaces.actor.shape.rectangle.image.ImageModel;
import model.impls.actor.shape.rectangle.RectangleActor;
import util.announcer.Announcer;

public class ImageActor extends RectangleActor implements ImageModel {

	private Announcer<ImageListener> listeners = Announcer.to(ImageListener.class);
	
	private ImageIcon	icon = null;
	
	static final protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = ImageActor.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
}

	
	@Override
	public ImageIcon getImageIcon() {
		return icon;
	}

	@Override
	public void setImageIcon(ImageIcon icon) {
		this.icon = icon;
		listeners.announce().iconChanged(this);
	}

	@Override
	public void addImageListener(ImageListener listener) {
		super.addRectangleListener(listener);
		listeners.addListener(listener);
	}

	@Override
	public void removeImageListener(ImageListener listener) {
		super.removeRectangleListener(listener);
		listeners.addListener(listener);
	}

}
