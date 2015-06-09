package model.ifaces;

import model.ifaces.map.MapModel;

public interface MasterModel {
	public void addListener(MasterListener listener);
	public void removeListener(MasterListener listener);
	
	public MapModel	getMap();
}
