package model.impls.console;

import model.ifaces.console.ConsoleListener;
import model.ifaces.console.ConsoleModel;
import util.announcer.Announcer;

public class Console implements ConsoleModel {

	private Announcer<ConsoleListener> listeners = Announcer.to(ConsoleListener.class);
	private int numCols = 120;
	private int numRows = 80;
	private String output = "";
	private int charCount = 0;
	private int lineCount = 0;
	
	@Override
	public void addConsoleListener(ConsoleListener listener) {
		listeners.addListener(listener);
	}

	@Override
	public void removeConsoleListener(ConsoleListener listener) {
		listeners.removeListener(listener);
	}

	@Override
	public void setNumCols(int numCols) {
		this.numCols = Math.max(1, numCols);
		
	}

	@Override
	public int getNumCols() {
		return this.numCols;
	}

	@Override
	public void setNumRows(int nLines) {
		this.numRows = Math.max(1, nLines);
	}

	@Override
	public int getNumRows() {
		return this.numRows;
	}

	@Override
	public void addText(String text) {
		for(char c : text.toCharArray()) {
			if (c=='\r' || c=='\n' || charCount>=getNumCols()) {
				lineCount++;
				charCount = 0;
				output += '\n';
			} else {
				output += c;
			}
		}
		shrinkList();
		listeners.announce().textUpdated();
	}

	@Override
	public String getOutput() {
		return output;
	}

	private void shrinkList() {
		int index;
		
		while(lineCount >= getNumRows()) {
			index = output.indexOf('\n');
			if (index != -1) {
				output = output.substring(index);
				lineCount--;
			}
		}
	}

}
