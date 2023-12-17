package game.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameRoomList extends JPanel {
	private JButton[] btnList1 = new JButton[6];
//	private JButton lblList2;
//	private JButton lblList3;
//	private JButton lblList4;
//	private JButton lblList5;
//	private JButton lblList6;
	private Setting setting = new Setting();
	
	public GameRoomList() {
		init();
		setDisplay();
		addListener();
	}
	
	private void init() {
		for(int i=0; i<btnList1.length; i++) {
			btnList1[i] = new JButton("tester" + (i + 1));
			btnList1[i].setHorizontalAlignment(JLabel.CENTER);

			ImageIcon icon = new ImageIcon("src/game/gui/HumanIcon.png");
			btnList1[i].setIcon(setting.resize(icon, 50, 50));
		}
	}
	
	private void setDisplay() {
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(0, 2));
		for(int i=0; i<btnList1.length; i++) {
			pnlCenter.add(btnList1[i]);
		}
		setting.setBackground(pnlCenter);
		
		add(pnlCenter);
	}

	private void addListener() {
		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				System.out.println(btn.getText());
				String btnStr = btn.getText();
				int result = JOptionPane.showConfirmDialog(
						GameRoomList.this,
						btnStr + "님을 마피아로 선택하시겠습니까?",
						"확인",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE
				);
				
				if(result == JOptionPane.YES_OPTION) {
					for(int i=0; i< btnList1.length; i++) {
						if(!(btnList1[i].getText().equals(btnStr))) {
							btnList1[i].setEnabled(false);
						}
						
					}
				}
			}
		};
		for(int i=0; i<btnList1.length; i++) {
			btnList1[i].addActionListener(aListener);
		}
	}
	
}
