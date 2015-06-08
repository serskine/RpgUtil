package model.ifaces.actor;

import java.util.EventListener;

public interface ActorListener extends EventListener {
	public void locationChanged(ActorModel model);
	public void changed(ActorModel model);
}
