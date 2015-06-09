package model.ifaces.console;

public interface ConsoleModel {
	public void addConsoleListener(ConsoleListener listener);
	public void removeConsoleListener(ConsoleListener listener);
	
	public void setNumCols(int nCharacters);
	public int	getNumCols();
	public void	setNumRows(int nLines);
	public int	getNumRows();
	
	public void addText(String text);
	
	public String getOutput();
}
