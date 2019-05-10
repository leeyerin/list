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
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;

public class Manager_PlusBev extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection con = makeConnection();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_PlusBev frame = new Manager_PlusBev();
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
	public Manager_PlusBev() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \"Manager\" ");
		label.setBounds(12, 0, 422, 15);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 58, 57, 15);
		contentPane.add(lblName);
		
		//음료 이름 텍스트 필드
		textField = new JTextField();
		textField.setBounds(64, 55, 79, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(155, 58, 19, 15);
		contentPane.add(lblNewLabel);
		
		//음료 id 텍스트 필드
		textField_1 = new JTextField();
		textField_1.setBounds(175, 55, 98, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(285, 58, 43, 15);
		contentPane.add(lblNewLabel_1);
		
		// 음료가격 텍스트 필드
		textField_2 = new JTextField();
		textField_2.setBounds(322, 55, 88, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//이전으로 버튼
		JButton button = new JButton("\uC774\uC804\uC73C\uB85C");
		button.setBounds(114, 217, 97, 23);
		contentPane.add(button);
		button.addActionListener(new exitActionListener());

		
		//완료버튼
		JButton button_1 = new JButton("\uC644\uB8CC");
		button_1.setBounds(313, 217, 97, 23);
		contentPane.add(button_1);
		button_1.addActionListener(new addMenuActionListener());
		
		
		JLabel label_1 = new JLabel("\uC7AC\uACE0\uB7C9");
		label_1.setBounds(418, 58, 43, 15);
		contentPane.add(label_1);
		
		//재고량 텍스트 필드
		textField_3 = new JTextField();
		textField_3.setBounds(459, 55, 35, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
	
	class addMenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String bevname = textField.getText();
			int id = Integer.parseInt(textField_1.getText());
			int price = Integer.parseInt(textField_2.getText());
			int num = Integer.parseInt(textField_3.getText());
			
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql;
			sql = "insert into beverage (name,id, price,num) values('"+bevname+"',"+id+","+price+","+num+");";
					
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			setVisible(false);
		}
		
	}
	
	class beforeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// 초기화면으로 화면 전환하는 코드
			
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

