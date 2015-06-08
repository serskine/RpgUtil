package model.impls.actor.set;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

import model.ifaces.actor.ActorModel;
import model.ifaces.actor.set.SetListener;
import model.ifaces.actor.set.SetModel;
import model.impls.actor.Actor;
import util.announcer.Announcer;

public class SetActor extends Actor implements SetModel {

	private Announcer<SetListener> listeners = Announcer.to(SetListener.class);
	private Set<Actor>	actors = new HashSet<Actor>();
	
	@Override
	public void addActor(Actor actor) {
		actors.add(actor);
		listeners.announce().actorAdded(this, actor);
	}
	
	@Override
	public void removeActor(Actor actor) {
		actors.remove(actors);
		listeners.announce().actorRemoved(this, actor);
	}
	
	@Override
	public void addSetListener(SetListener listener) {
		super.addListener(listener);
		listeners.addListener(listener);
	}
	
	@Override
	public void removeSetListener(SetListener listener) {
		super.removeListener(listener);
		listeners.removeListener(listener);
	}
	
	@Override
	public boolean containsPoint(Point pos) {
		Point newPos = new Point(pos.x - location.x, pos.y - location.y);
		synchronized(actors) {
			for(Actor actor : actors) {
				if (actor.containsPoint(newPos)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchesBounds(Rectangle bounds) {
		Rectangle newBounds = new Rectangle(bounds.x - location.x, bounds.y - location.y, bounds.width, bounds.height);
		synchronized(actors) {
			for(Actor actor : actors) {
				if (actor.touchesBounds(newBounds)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void locationChanged(ActorModel actorModel) {
		listeners.announce().actorChanged(this, actorModel);
	}

	@Override
	public void changed(ActorModel actorModel) {
		listeners.announce().actorChanged(this, actorModel);
	}
}
