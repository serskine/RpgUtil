package model.ifaces.map;

import java.awt.Rectangle;
import java.util.EventListener;

import model.impls.actor.set.SetActor;

public interface MapModel extends EventListener {
	public SetActor getRoot();
	public void setRoot(SetActor rootActor);
	
	public void addMapListener(MapListener listener);
	public void removeMapListener(MapListener listener);
	
	public boolean touchesBounds(Rectangle bounds);
}
