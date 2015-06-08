package util.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.Calculator;

public class ExpressionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField screenTextField;
	
	private String	inputStr = "";
	private String	outputStr = "";
	private JButton evaluateButton;

	/**
	 * Create the panel.
	 */
	public ExpressionPanel() {
		addComponentListener(new ComponentResizedListener());
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		evaluateButton = new JButton("=");
		evaluateButton.setFont(evaluateButton.getFont().deriveFont(evaluateButton.getFont().getStyle() | Font.BOLD, evaluateButton.getFont().getSize() + 2f));
		evaluateButton.addActionListener(new EvaluateCommandListener());
		add(evaluateButton, BorderLayout.EAST);
		
		screenTextField = new JTextField();
		add(screenTextField, BorderLayout.CENTER);
		screenTextField.addActionListener(new EvaluateCommandListener());
		screenTextField.setHorizontalAlignment(SwingConstants.CENTER);
		screenTextField.setFont(screenTextField.getFont().deriveFont(screenTextField.getFont().getStyle() | Font.BOLD | Font.ITALIC, screenTextField.getFont().getSize() + 2f));
		screenTextField.setColumns(10);

	}

	public String getScreenText() {
		return screenTextField.getText();
	}
	private void setScreenText(String S) {
		screenTextField.setText(S);
	}
	
	private String getInputText() {
		return this.inputStr;
	}
	private void setInputText(String S) {
		this.inputStr = S;
		setScreenText(getInputText());
	}
	
	private String getOutputText() {
		return this.outputStr;
	}
	private void setOutputText(String S) {
		this.outputStr = S;
		setScreenText(getOutputText());
	}
	
	private class EvaluateCommandListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			evaluate();
		}
	}
	
	private class ComponentResizedListener implements ComponentListener {

		@Override
		public void componentResized(ComponentEvent e) {
//			Font		currentFont = screenTextField.getFont();
//			Font		desiredFont = currentFont;
//			FontMetrics desiredMetrics = screenTextField.getFontMetrics(desiredFont);
//			
//			while(	desiredMetrics.getHeight() < screenTextField.getHeight()) {
//				desiredFont = desiredFont.deriveFont((float) (desiredFont.getSize()+1f));
//				desiredMetrics = screenTextField.getFontMetrics(desiredFont);
//			}
//			
//			while(	desiredMetrics.getHeight() >= screenTextField.getHeight()) {
//				desiredFont = desiredFont.deriveFont((float) (desiredFont.getSize()-1f));
//				desiredMetrics = screenTextField.getFontMetrics(desiredFont);
//			}
//			
//			// Just a bit smaller
//			desiredFont = desiredFont.deriveFont((float) (desiredFont.getSize()-1f));
//			
//			
//			evaluateButton.setFont(desiredFont);
//			screenTextField.setFont(desiredFont);
		}

		@Override
		public void componentMoved(ComponentEvent e) { 
			
		}

		@Override
		public void componentShown(ComponentEvent e) {
			
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			
		}

	}
	
	public JTextField getScreenTextField() {
		return screenTextField;
	}
	public JButton getEvaluateButton() {
		return evaluateButton;
	}
	
	public boolean isButtonVisible() {
		return evaluateButton.isVisible();
	}
	
	public void setButtonVisible(boolean value) {
		evaluateButton.setVisible(value);
	}
	
	public void evaluate() {
		try {
			setInputText(getScreenText());
			Double result = Calculator.calculate(getInputText());
			setOutputText(result.toString());
		} catch (Exception exception) {
			setOutputText(exception.getLocalizedMessage());
		}
	}
	
}
