import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Manager_FirstSetting extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Connection con = makeConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_FirstSetting frame = new Manager_FirstSetting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manager_FirstSetting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \"Manager\" ");
		label.setBounds(12, 0, 422, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("tray \uAC1C\uC218 \uC124\uC815  ");
		lblNewLabel.setBounds(30, 58, 132, 15);
		contentPane.add(lblNewLabel);
		//tray 개수 텍스트 필드 
		textField = new JTextField();
		textField.setBounds(209, 55, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("500\uC6D0 \uAC1C\uC218 \uC124\uC815  ");
		label_1.setBounds(30, 106, 141, 15);
		contentPane.add(label_1);
		//500원 개수 텍스트 필드
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(209, 103, 116, 21);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("100\uC6D0 \uAC1C\uC218 \uC124\uC815  ");
		label_2.setBounds(30, 152, 141, 15);
		contentPane.add(label_2);
		//100원 개수 텍스트 필드
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(209, 149, 116, 21);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setBounds(179, 58, 18, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel(":");
		label_4.setBounds(179, 106, 18, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(":");
		label_5.setBounds(179, 152, 18, 15);
		contentPane.add(label_5);
		//이전 버튼
		JButton button = new JButton("\uC774\uC804\uC73C\uB85C");
		button.setBounds(114, 242, 97, 23);
		contentPane.add(button);
		button.addActionListener(new exitActionListener() );
		//완료 버튼 
		JButton button_1 = new JButton("\uC644\uB8CC");
		button_1.setBounds(239, 242, 97, 23);
		contentPane.add(button_1);
		button_1.addActionListener(new completeActionListener());
	}
	
	class completeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int tray = Integer.parseInt(textField.getText());
			int coin500 = Integer.parseInt(textField_1.getText());
			int coin100 = Integer.parseInt(textField_2.getText()); 
			
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql;
			sql = "insert into vendingmachine_setting (tray,coin500, coin100) values("+tray+","+coin500+","+coin100+");";
					
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	
	Connection makeConnection()
	{
		Connection c = null;
		
		String url = "jdbc:mysql://localhost/beverage";
		String user="root";
		String password="apmsetup";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection(url, user, password);
		
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
