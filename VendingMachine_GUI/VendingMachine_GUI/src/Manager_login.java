import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Manager_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtManager;
	private JTextField textField;
	Manager_welcome mw = new Manager_welcome();
	Welcome wc = new Welcome();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_login frame = new Manager_login();
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
	public Manager_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \uACC4\uC815 \uB85C\uADF8\uC778");
		label.setFont(new Font("굴림체", Font.PLAIN, 12));
		label.setBounds(168, 38, 118, 24);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("ID      :");
		lblNewLabel.setBounds(106, 104, 66, 15);
		contentPane.add(lblNewLabel);
		
		txtManager = new JTextField();
		txtManager.setText("Manager");
		txtManager.setBounds(214, 101, 118, 21);
		contentPane.add(txtManager);
		txtManager.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(76, 153, 96, 15);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(214, 150, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//이전으로 버튼
		JButton btnNewButton = new JButton("\uC774\uC804\uC73C\uB85C");
		btnNewButton.setBounds(125, 206, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new beforeActionListener());
		
		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.setBounds(234, 206, 97, 23);
		contentPane.add(button);
		button.addActionListener(new loginActionListener());
	}
	
	class loginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String inputPw = textField.getText();
			if(inputPw.equals("1234")) {
				//화면 넘어가는 코드
				setVisible(false);
				mw.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 제대로 입력해주세요", "경고메시지", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	class beforeActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// 초기화면으로 화면 전환하는 코드
			setVisible(false);
			wc.setVisible(true);
		}
		
	}
}
