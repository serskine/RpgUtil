package model.ifaces.map;

import java.util.EventListener;

public interface MapListener extends EventListener {
	public void mapChanged(MapModel source);
}
