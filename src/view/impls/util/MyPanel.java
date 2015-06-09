package view.impls.util;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import util.ddict.DDict;

public class MyPanel<HmiType> extends javax.swing.JPanel implements
	ComponentListener,
	MouseListener,
	MouseMotionListener,
	MouseInputListener,
	MouseWheelListener,
	KeyListener
{

	/**
	 *	My MousePanel with additional methods for tracking user input
	 */
	private static final long serialVersionUID = 1L;

	protected DDict<Integer,Boolean>		mPressed		= new DDict<Integer,Boolean>(false);
	protected DDict<Integer,Point2D>		mScreenDown		= new DDict<Integer,Point2D>(new Point(0,0));
	protected DDict<Integer,Point2D>		mScreenUp		= new DDict<Integer,Point2D>(new Point(0,0));
	protected Point2D						mScreenPos		= new Point(0,0);
	private boolean							debug	= true;

	private	long		paintDelay = 100;
	protected Thread	paintThread = null;
	public boolean		usingPaintThread = true;

	public MyPanel() {
		super();
		println("MyPanel");
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		this.addKeyListener(this);

		setEnabled(true);
		setVisible(true);
		setDebug(true);

		paintThread = new Thread(
			new Runnable() {
				@Override
				public void run() {
					while(true) {
						if (usingPaintThread) {
							refresh();
							try {
								Thread.sleep(paintDelay);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		);


		paintThread.start();
	}


	public void println(String S) {
		if (this.isDebug()) {
			System.out.println(S);
		}
	}

	public final void refresh() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				paintImmediately(getVisibleRect());
			}
		});
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		println("mouseWheelMoved");
		mScreenPos = e.getPoint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		println("mouseDragged");
		mScreenPos = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		println("mouseMoved");
		mScreenPos = e.getPoint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		println("mouseClicked");
		mScreenPos = e.getPoint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		println("mousePressed");
		mScreenPos = e.getPoint();
		mScreenDown.put(e.getButton(), mScreenPos);
		mPressed.put(e.getButton(), true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		println("mouseReleased");
		mScreenPos = e.getPoint();
		mScreenUp.put(e.getButton(), mScreenPos);
		mPressed.put(e.getButton(), false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		println("mouseEntered");
		mScreenPos = e.getPoint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		println("mouseExited");
		mScreenPos = e.getPoint();
	}

	@Override
	public void componentResized(ComponentEvent e) {
		println("componentResized");
		refresh();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		println("componentMoved");
		refresh();
	}

	@Override
	public void componentShown(ComponentEvent e) {
		println("componentShown");
		refresh();
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		println("componentHidden");
	}

	@Override
	public void paint(Graphics G) {
		println("paint");
		G.clearRect(0,0,getWidth(), getHeight());
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean myPanelDebug) {
		this.debug = myPanelDebug;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		println("keyTyped");
		println("   code = " + e.getKeyCode());
		println("   char = " + e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		println("keyReleased");
		println("   code = " + e.getKeyCode());
		println("   char = " + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
		System.out.println("   code = " + e.getKeyCode());
		System.out.println("   char = " + e.getKeyChar());
	}
}
