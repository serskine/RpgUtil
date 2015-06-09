package view.impls.console;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.ifaces.console.ConsoleListener;
import model.ifaces.console.ConsoleModel;

public class ConsoleView extends JPanel implements ConsoleListener {
	private final ConsoleModel consoleModel;
	private final JTextArea textArea;
	
	public ConsoleView(ConsoleModel consoleModel) {
		this.consoleModel = consoleModel;
		
		consoleModel.addConsoleListener(this);
		
		setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		textArea.setEditable(false);
		add(textArea);
	}

	@Override
	public void textUpdated() {
		textArea.setText(consoleModel.getOutput());
	}

	@Override
	public void numRowsUpdated() {
		textArea.setRows(consoleModel.getNumRows());
	}

	@Override
	public void numColsUpdated() {
		textArea.setColumns(consoleModel.getNumCols());
	}

}
