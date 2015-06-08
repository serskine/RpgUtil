package model.impls.map;

import java.awt.Rectangle;

import model.ifaces.actor.ActorModel;
import model.ifaces.actor.set.SetListener;
import model.ifaces.actor.set.SetModel;
import model.ifaces.map.MapListener;
import model.ifaces.map.MapModel;
import model.impls.actor.set.SetActor;
import announcer.Announcer;

public class Map implements MapModel, SetListener {

	private Announcer<MapListener>	listeners = Announcer.to(MapListener.class);
	
	private SetActor	rootActor = new SetActor();
	
	@Override
	public SetActor getRoot() {
		return rootActor;
	}

	@Override
	public void setRoot(SetActor rootActor) {
		if (this.rootActor!=null) {
			this.rootActor.removeSetListener(this);
		}
		this.rootActor = rootActor;
		if (this.rootActor!=null) {
			this.rootActor.addSetListener(this);
		}
	}

	@Override
	public void addMapListener(MapListener listener) {
		listeners.addListener(listener);
	}

	@Override
	public void removeMapListener(MapListener listener) {
		listeners.removeListener(listener);
	}

	@Override
	public void changed(ActorModel model) {
		listeners.announce().mapChanged(this);
	}

	@Override
	public void locationChanged(ActorModel model) {
		listeners.announce().mapChanged(this);
	}

	@Override
	public void actorRemoved(SetModel source, ActorModel actor) {
		listeners.announce().mapChanged(this);
	}

	@Override
	public void actorAdded(SetModel source, ActorModel actor) {
		listeners.announce().mapChanged(this);
	}

	@Override
	public void actorChanged(SetModel source, ActorModel actor) {
		listeners.announce().mapChanged(this);
	}

	@Override
	public boolean touchesBounds(Rectangle bounds) {
		return getRoot().touchesBounds(bounds);
	}
	
	


	
	
}
