package model.ifaces.actor.shape.rectangle.image;

import javax.swing.ImageIcon;

import model.ifaces.actor.shape.rectangle.RectangleModel;

public interface ImageModel extends RectangleModel {
	public ImageIcon	getImageIcon();
	public void setImageIcon(ImageIcon icon);
	
	public void addImageListener(ImageListener listener);
	public void removeImageListener(ImageListener listener);
}
