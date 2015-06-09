package model.impls;

import model.ifaces.MasterListener;
import model.ifaces.MasterModel;
import model.ifaces.map.MapModel;
import model.impls.map.Map;
import util.announcer.Announcer;

public class Master implements MasterModel {
	
	private Announcer<MasterListener>	listeners = Announcer.to(MasterListener.class);
	
	private final MapModel map = new Map();

	/**
	 * This represents the 2D map
	 * @return the map
	 */
	@Override
	public MapModel getMap() {
		return map;
	}

	@Override
	public void addListener(MasterListener listener) {
		listeners.addListener(listener);
	}

	@Override
	public void removeListener(MasterListener listener) {
		listeners.removeListener(listener);
	}
}
