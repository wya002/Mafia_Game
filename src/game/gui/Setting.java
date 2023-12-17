package game.gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Setting {

	public void setBackground(JPanel pnl) {
		pnl.setBackground(Color.WHITE);
	}
	

	public ImageIcon resize(ImageIcon icon, int width, int hight) {
		Image img = icon.getImage();
		Image resizeImg = img.getScaledInstance(width, hight, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(resizeImg);
		return changeIcon;
	}
	
}
