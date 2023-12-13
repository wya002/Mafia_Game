package game.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameRoomList extends JPanel {
	private JButton lblList1;
	private JButton lblList2;
	private JButton lblList3;
	private JButton lblList4;
	private JButton lblList5;
	private JButton lblList6;
	private Setting setting = new Setting();
	
	public GameRoomList() {
		init();
		setDisplay();
	}
	
	private void init() {
		lblList1 = new JButton("tester1");
		lblList1.setHorizontalAlignment(JLabel.CENTER);
		
		lblList2 = new JButton("tester2");
		lblList2.setHorizontalAlignment(JLabel.CENTER);
		lblList3 = new JButton("tester3");
		lblList3.setHorizontalAlignment(JLabel.CENTER);
		lblList4 = new JButton("tester4");
		lblList4.setHorizontalAlignment(JLabel.CENTER);
		lblList5 = new JButton("tester5");
		lblList5.setHorizontalAlignment(JLabel.CENTER);
		lblList6 = new JButton("tester6");
		lblList6.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	private void setDisplay() {
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(0, 2));
		pnlCenter.add(lblList1);
		pnlCenter.add(lblList2);
		pnlCenter.add(lblList3);
		pnlCenter.add(lblList4);
		pnlCenter.add(lblList5);
		pnlCenter.add(lblList6);
		setting.setBackground(pnlCenter);
		
		add(pnlCenter);
	}
	
}
