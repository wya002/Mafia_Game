package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GameRoom extends JFrame {
	Setting setting = new Setting();
	
	private JLabel lblTitle;
	private JTextArea taMsg;
	private JTextArea taInput;
	
	private JPanel pnlMain;
	private JPanel pnlSouth;
	private JPanel pnlEast;
	private JPanel pnlWest;
	
	private JButton btnSend;
	private JButton btnExit;
	
	public GameRoom() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		
		lblTitle = new JLabel("MAFIA GAME");
		lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 25));	
		
		
		taInput = new JTextArea(5, 5);
		taInput.setEditable(true);
		taInput.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 15));
		taInput.setLineWrap(true);
		
		taMsg = new JTextArea(50, 50);
		taMsg.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		taMsg.setEditable(false);
		taMsg.setBackground(Color.BLACK);
		taMsg.setForeground(Color.WHITE);
		
		Dimension dimension = new Dimension(90, 50);
		btnSend = new JButton("전송");
		btnSend.setPreferredSize(dimension);
		
		btnExit = new JButton("나가기");
		btnExit.setPreferredSize(dimension);
	}
	
	private void setDisplay() {
		JPanel pnlTop = new JPanel();
		pnlTop.setBorder(new EmptyBorder(20, 50, 20, 50));
		pnlTop.setBackground(Color.WHITE);
		pnlTop.add(lblTitle);
		
		pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBackground(Color.BLACK);
		pnlMain.add(taMsg, BorderLayout.NORTH);
		
		pnlWest = new GameRoomUserInfo();
		pnlWest.setBorder(new EmptyBorder(10, 10, 10, 10));
		setting.setBackground(pnlWest);
		
		pnlEast = new GameRoomList();
		pnlEast.setLayout(new GridLayout(0, 1));
		pnlEast.setBorder(new EmptyBorder(15, 15, 15, 15));
		setting.setBackground(pnlEast);
		
		JPanel pnlEastSouth = new JPanel(new BorderLayout());
		pnlEastSouth.add(btnExit, BorderLayout.SOUTH);
		setting.setBackground(pnlEastSouth);

		pnlEast.add(pnlEastSouth);
		
		pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
		setting.setBackground(pnlSouth);
		
		JPanel pnlSouthInput = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane(taInput);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnlSouthInput.add(scroll, BorderLayout.CENTER);
		pnlSouthInput.add(btnSend, BorderLayout.EAST);
		pnlSouthInput.setBackground(Color.WHITE);
		pnlSouth.add(pnlSouthInput, BorderLayout.CENTER);
		
		add(pnlTop, BorderLayout.NORTH);
		add(pnlMain, BorderLayout.CENTER);
		add(pnlWest, BorderLayout.WEST);
		add(pnlEast, BorderLayout.EAST);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = taInput.getText();
//				lblMsg.setText(txt);
				taMsg.append(txt);
				taMsg.append("\n");
				taInput.setText("");
//				lblTxt.setForeground(Color.WHITE);
				pnlMain.add(taMsg, BorderLayout.CENTER);
				System.out.println(txt);
				
			}
			
		};
		
		ActionListener exitListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		};
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
//				owner.setVisible(true);
			}
		});
		
		btnSend.addActionListener(aListener);
		btnExit.addActionListener(exitListener);
	}
	
	private void showFrame() {
		setTitle("Mafia Game");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		GameRoom gameRoom = new GameRoom();
	}
}
