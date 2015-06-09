package model.ifaces.console;

import java.util.EventListener;

public interface ConsoleListener extends EventListener {
	public void textUpdated();
	public void numRowsUpdated();
	public void numColsUpdated();
}
