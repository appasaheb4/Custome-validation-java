package Helper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class SadFaceSimpleAlert extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel lblTitle;
	public JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SadFaceSimpleAlert dialog = new SadFaceSimpleAlert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SadFaceSimpleAlert() {
		setBounds(100, 100, 360, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SadFaceSimpleAlert.class.getResource("/Helper/sadfaceForAlert.png")));
		lblNewLabel.setBounds(6, 6, 348, 75);
		contentPanel.add(lblNewLabel);
		
		lblTitle = new JLabel("New label");
		lblTitle.setFont(new Font("Avenir Next", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 93, 348, 16);
		contentPanel.add(lblTitle);
		
		lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Avenir Next", Font.PLAIN, 14));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(6, 121, 348, 29);
		contentPanel.add(lblMessage);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setMinimumSize(new Dimension(75, 35));
		btnOk.setMaximumSize(new Dimension(75, 35));
		btnOk.setPreferredSize(new Dimension(75, 35));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
		btnOk.setBounds(6, 150, 348, 35);
		contentPanel.add(btnOk);
	}
}
