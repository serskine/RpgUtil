package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.ifaces.MasterModel;
import view.impls.map.MapView;

public class MainView extends JPanel {
	public MainView(
		MasterModel masterModel
	) {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		MapView mapView = new MapView(masterModel.getMap());
		
		
		
		tabbedPane.addTab("Map", null, mapView, "2D view of the Map");
		
	}
}
