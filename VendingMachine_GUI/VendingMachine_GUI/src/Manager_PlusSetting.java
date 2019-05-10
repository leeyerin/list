import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class Manager_PlusSetting extends JFrame {

	private JPanel contentPane;
	Manager_PlusBev pb = new Manager_PlusBev();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_PlusSetting frame = new Manager_PlusSetting();
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
	public Manager_PlusSetting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333); //
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \"Manager\" ");
		label.setBounds(12, 0, 422, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825\uD558\uACE0\uC790 \uD558\uB294 \uAE30\uB2A5\uC744 \uC120\uD0DD\uD574 \uC8FC\uC138\uC694 ^~^");
		lblNewLabel.setBounds(101, 43, 251, 15);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(43, 68, 333, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//1. 음료추가 
		JButton btnNewButton = new JButton("1) \uC74C\uB8CC\uCD94\uAC00");
		btnNewButton.setBounds(0, 0, 117, 43);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new goActionListener());
		
		
		JButton button = new JButton("2) \uC74C\uB8CC\uC0AD\uC81C");
		button.setBounds(115, 0, 112, 43);
		panel.add(button);
		
		JButton button_1 = new JButton("3) \uB3D9\uC804\uBCF4\uCDA9");
		button_1.setBounds(226, 0, 107, 43);
		panel.add(button_1);
		
		JButton button_2 = new JButton("4) \uC794\uACE0\uD655\uC778");
		button_2.setBounds(0, 42, 117, 43);
		panel.add(button_2);
		
		JButton button_3 = new JButton("5) \uD310\uB9E4\uB7C9\uCD9C\uB825");
		button_3.setBounds(115, 42, 218, 43);
		panel.add(button_3);
		
		JButton button_4 = new JButton("6) \uC7AC\uACE0\uBCF4\uCDA9");
		button_4.setBounds(0, 82, 117, 49);
		panel.add(button_4);
		
		JButton button_5 = new JButton("7) \uD604\uC7AC \uC7AC\uACE0\uB7C9 \uD655\uC778");
		button_5.setBounds(115, 82, 218, 49);
		panel.add(button_5);
		
		JButton button_6 = new JButton("8) \uAD00\uB9AC\uC790 \uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		button_6.setBounds(0, 127, 218, 43);
		panel.add(button_6);
		
		JButton btnExit = new JButton("9) EXIT");
		btnExit.setBounds(216, 127, 117, 43);
		panel.add(btnExit);
	}
	class goActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			pb.setVisible(true);
		}
		
	}
	
}
