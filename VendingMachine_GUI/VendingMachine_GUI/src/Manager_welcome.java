import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager_welcome extends JFrame {

	private JPanel contentPane;
	Manager_PlusSetting ps = new Manager_PlusSetting();
	Manager_FirstSetting fs = new Manager_FirstSetting();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_welcome frame = new Manager_welcome();
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
	public Manager_welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \"Manager\" ");
		lblNewLabel.setBounds(12, 0, 422, 15);
		contentPane.add(lblNewLabel);
		
		//초기 설정 버튼
		JButton btnSetting = new JButton("\uCD08\uAE30 \uC124\uC815");
		btnSetting.addActionListener(new goFirstSetting());
		btnSetting.setBounds(134, 81, 175, 36);
		contentPane.add(btnSetting);
		//추가 설정 버튼 
		JButton button = new JButton("\uCD94\uAC00 \uC124\uC815");
		button.setBounds(134, 137, 175, 36);
		contentPane.add(button);
		button.addActionListener(new goPlusSetting() );
		
		//이전으로 버튼
		JButton btnNewButton = new JButton("\uC774\uC804\uC73C\uB85C");
		btnNewButton.setBounds(178, 202, 97, 23);
		contentPane.add(btnNewButton);
	}
	
	class goPlusSetting implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ps.setVisible(true);
			
		}
		
	}
	
	class goFirstSetting implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fs.setVisible(true);
		}
		
	}

}
