import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Show_Menu extends JFrame {

	private JPanel contentPane;
	//Welcome wc = new Welcome();
	//Management mg = new Management();
	Connection con = makeConnection();
	Boolean First = true;
	private JTextArea textArea;
	BuyBeverage bB = new BuyBeverage();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_Menu frame = new Show_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
	
	}
	// DB ���� connection

	Connection makeConnection() {
		// TODO Auto-generated method stub
		Connection c = null;

		String url = "jdbc:mysql://localhost/beverage";
		String user = "root";
		String password = "apmsetup";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���缺��");
			c = DriverManager.getConnection(url, user, password);
			System.out.println("db���� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ῡ �����Ͽ����ϴ�.");
			e.printStackTrace();
		}

		return c;
	}

	/**
	 * Create the frame.
	 */
	public Show_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// �޴��� ���� �� �ǳ�
		JPanel panel = new JPanel();
		panel.setToolTipText("df");
		panel.setBounds(35, 39, 354, 179);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(15, 10, 327, 159);
		panel.add(textArea);
		
		
	
		// �������� ��ư
		JButton button = new JButton("\uC774\uC804\uC73C\uB85C");
		button.setBounds(109, 228, 97, 23);
		contentPane.add(button);
		button.addActionListener(new goWelcomeActionListener());

		// �����ϱ� ��ư
		JButton button_1 = new JButton("\uAD6C\uC785\uD558\uAE30");
		button_1.addActionListener(new goBuyActionListener());
		button_1.setBounds(231, 228, 97, 23);
		contentPane.add(button_1);
		
		
		JButton button_2 = new JButton("\uBAA8\uB4E0 \uBA54\uB274\uB97C \uBCF4\uACE0 \uC2F6\uB2E4\uBA74 \uB2E4\uC74C \uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694");
		button_2.setBounds(35, 6, 354, 23);
		contentPane.add(button_2);
		button_2.addActionListener(new showMenuActionListener());
	}

	class showMenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			java.sql.Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql;
			// db�� �ִ� ��� �������� �������� sql
			sql = "select * from beverage";
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// ������ ��������
			try {
				while (rs.next()) {
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int id = rs.getInt("id");
					int num = rs.getInt("num");
					
					//System.out.println(price);
					//textField.setText(name);
					//textField.setText("���� �̸�   : " + name + " ���� ����   : " + Integer.toString(price)+ " ���� id   : " + Integer.toString(id)+" ��� ����   : "+Integer.toString(num)+"\n");
					textArea.append(id + ")" + "�����̸� : " + name + " " + price + " �� " + " ��� : " + num + "\n");
					
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			First = false;
		}

	}
	class goBuyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			 bB.setVisible(true);
		}
		
	}
	
	class goWelcomeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
		
	}
}
