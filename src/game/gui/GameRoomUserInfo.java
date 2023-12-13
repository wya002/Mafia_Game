package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameRoomUserInfo extends JPanel {
	private JLabel lblName;
	private JLabel lblImage;
	private JLabel lblRole;
	private Setting setting = new Setting();
	
	public GameRoomUserInfo() {
		init();
		setDisplay();
	}
	
	private void init() {
		lblImage = new JLabel();
		ImageIcon icon = new ImageIcon("src/game/gui/HumanIcon.png");
		lblImage.setIcon(setting.resize(icon));
		
		lblName = new JLabel("이슬짱짱짱");
		lblName.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		lblName.setHorizontalAlignment(JLabel.CENTER);
		
		lblRole = new JLabel("시  민");
		lblRole.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
		lblRole.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new BorderLayout());
		pnlNorth.setBackground(Color.WHITE);
		pnlNorth.add(lblImage, BorderLayout.NORTH);
		pnlNorth.add(lblName, BorderLayout.CENTER);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBackground(Color.WHITE);
		pnlCenter.add(lblRole, BorderLayout.NORTH);
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBackground(Color.WHITE);
		
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		add(pnlMain);
	}
	
}
