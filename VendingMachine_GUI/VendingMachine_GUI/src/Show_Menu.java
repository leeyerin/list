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
	// DB 연결 connection

	Connection makeConnection() {
		// TODO Auto-generated method stub
		Connection c = null;

		String url = "jdbc:mysql://localhost/beverage";
		String user = "root";
		String password = "apmsetup";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("적재성공");
			c = DriverManager.getConnection(url, user, password);
			System.out.println("db연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("연결에 실패하였습니다.");
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

		// 메뉴를 보여 줄 판넬
		JPanel panel = new JPanel();
		panel.setToolTipText("df");
		panel.setBounds(35, 39, 354, 179);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(15, 10, 327, 159);
		panel.add(textArea);
		
		
	
		// 이전으로 버튼
		JButton button = new JButton("\uC774\uC804\uC73C\uB85C");
		button.setBounds(109, 228, 97, 23);
		contentPane.add(button);
		button.addActionListener(new goWelcomeActionListener());

		// 구입하기 버튼
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
			// db에 있는 모든 음료정보 가져오는 sql
			sql = "select * from beverage";
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 데이터 가져오기
			try {
				while (rs.next()) {
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int id = rs.getInt("id");
					int num = rs.getInt("num");
					
					//System.out.println(price);
					//textField.setText(name);
					//textField.setText("음료 이름   : " + name + " 음료 가격   : " + Integer.toString(price)+ " 음료 id   : " + Integer.toString(id)+" 재고 개수   : "+Integer.toString(num)+"\n");
					textArea.append(id + ")" + "음료이름 : " + name + " " + price + " 원 " + " 재고 : " + num + "\n");
					
					
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
