import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BuyBeverage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection con = makeConnection();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public BuyBeverage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblbuyer = new JLabel("\uAD6C\uB9E4\uC790 \"Buyer\" ");
		lblbuyer.setBounds(5, 5, 424, 15);
		contentPane.add(lblbuyer);

		JLabel lblNewLabel = new JLabel(
				"      \uAD6C\uB9E4\uD558\uC2DC\uB824\uACE0 \uD558\uB294 \uC74C\uB8CC\uC758 id\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694 ^~^");
		lblNewLabel.setBounds(59, 52, 333, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC74C\uB8CC id   :");
		lblNewLabel_1.setBounds(146, 111, 64, 15);
		contentPane.add(lblNewLabel_1);
		// 구매하려고 하는 음료 id
		textField = new JTextField();
		textField.setBounds(222, 108, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		// 구매버튼
		JButton btnNewButton = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btnNewButton.setBounds(263, 207, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new buyActionListener());
		
		JButton button = new JButton("\uC774\uC804\uC73C\uB85C");
		button.setBounds(146, 207, 97, 23);
		contentPane.add(button);
		button.addActionListener(new exitActionListener());
	}

	class buyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int minusid = Integer.parseInt(textField.getText());
			System.out.println("마이너스" + minusid);
			int minusResult = 0;

			Statement stmt = null;

			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String sql = "select num from beverage where id =" + minusid;
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}

			// 쿼리 결과값 가져오기
			try {
				while (rs.next()) {
					minusResult = rs.getInt("num");
					minusResult = minusResult - 1; // 0
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			if(minusResult > 0) {
			// 새로운 쿼리 실행
			sql = "update beverage set num =" + minusResult + " where id=" + minusid + ";";
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} else {
				JOptionPane.showMessageDialog(null, "음료의 재고가 없습니다 - 구매불가", "경고메시지", JOptionPane.WARNING_MESSAGE);
			}
			setVisible(false);
		}
	}
	
	class exitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}
		
	}
	Connection makeConnection() {
		Connection c = null;

		String url = "jdbc:mysql://localhost/beverage";
		String user = "root";
		String password = "apmsetup";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}
}
