import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Welcome extends JFrame {

	private JPanel contentPane;
	
	Show_Menu sm = new Show_Menu(); 
	
	//Manager_login Ml = new Manager_login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setTitle("VeningMachine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(
				"\uC74C\uB8CC \uC790\uD310\uAE30\uB97C \uC774\uC6A9\uD574\uC8FC\uC154\uC11C \uAC10\uC0AC\uD569\uB2C8\uB2E4. ^~^");
		label.setBounds(86, 28, 256, 23);
		contentPane.add(label);

		// exit ���� ��ư
		JButton btnNewButton = new JButton("\uC885\uB8CC");
		btnNewButton.setBounds(145, 130, 175, 36);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new exitButtonListener());

		// ����� ���� ��ư
		JButton button = new JButton("\uC74C\uB8CC\uC218 \uAD6C\uC785");
		button.setBounds(145, 86, 175, 36);
		contentPane.add(button);
		button.addActionListener(new goBuyActionListener() );

		// ������ ��� ��ư
		JButton button_1 = new JButton("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		button_1.setBounds(145, 176, 175, 36);
		contentPane.add(button_1);
		//button_1.addActionListener(new goMmActionListener());
	}

	
	//����� ���� ��ư�� ������ ��
	class goBuyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sm.setVisible(true);
			
		}
		
	} 
	//�����ڸ�� �α��� ��ư�� ������ ��
	/*
	class goMmActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Ml.setVisible(true);
			
		}
		
	}*/
	// ���� ��ư�� �������� actionlistener
	
	class exitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//���� ��ư�� ������ �� connection ���� �����Ų��. 
			setVisible(false);

		}

	}  
}
