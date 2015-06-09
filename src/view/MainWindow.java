package view;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import model.ifaces.MasterModel;
import model.impls.Master;

public class MainWindow extends Applet implements WindowListener {
	private static final long serialVersionUID = 1L;
	
	private JFrame 					mainFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainWindow		window = new MainWindow();
					
					final GraphicsConfiguration config = window.mainFrame.getGraphicsConfiguration();


			        final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
			        final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
			        final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
			        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;

			        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        final int width = screenSize.width - left - right;
			        final int height = screenSize.height - top - bottom;

			        window.mainFrame.setResizable(true);
			        window.mainFrame.setSize(width,height);
			        window.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        window.mainFrame.setVisible(true);

			    } catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Dispose of information on close
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		MasterModel masterModel = new Master();
		
		mainFrame = new JFrame();
		mainFrame.setTitle("RPG Utilities");
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		mainFrame.setBounds(0, 0, 1383, 792);
		
		MainView mainPanel = new MainView(masterModel);
		mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	}


	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
}
