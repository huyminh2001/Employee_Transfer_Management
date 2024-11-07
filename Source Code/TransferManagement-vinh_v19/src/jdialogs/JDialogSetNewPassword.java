package jdialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class JDialogSetNewPassword extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldUsername;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldVerificationCode;
	private JButton jbuttonCancel;
	private JButton jbuttonSet;
	private JButton jbuttonResend;
	private JPasswordField jpasswordFieldNew;
	private JPasswordField jpasswordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogSetNewPassword dialog = new JDialogSetNewPassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogSetNewPassword() {
		setTitle("Set New Password");
		setBounds(100, 100, 450, 319);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Set New Password");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 3;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Username");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtextFieldUsername = new JTextField();
			GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
			gbc_jtextFieldUsername.gridwidth = 2;
			gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldUsername.gridx = 2;
			gbc_jtextFieldUsername.gridy = 2;
			getContentPane().add(jtextFieldUsername, gbc_jtextFieldUsername);
			jtextFieldUsername.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Email");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtextFieldEmail = new JTextField();
			GridBagConstraints gbc_jtextFieldEmail = new GridBagConstraints();
			gbc_jtextFieldEmail.gridwidth = 2;
			gbc_jtextFieldEmail.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmail.gridx = 2;
			gbc_jtextFieldEmail.gridy = 3;
			getContentPane().add(jtextFieldEmail, gbc_jtextFieldEmail);
			jtextFieldEmail.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Verification Code");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldVerificationCode = new JTextField();
			GridBagConstraints gbc_jtextFieldVerificationCode = new GridBagConstraints();
			gbc_jtextFieldVerificationCode.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldVerificationCode.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldVerificationCode.gridx = 2;
			gbc_jtextFieldVerificationCode.gridy = 4;
			getContentPane().add(jtextFieldVerificationCode, gbc_jtextFieldVerificationCode);
			jtextFieldVerificationCode.setColumns(10);
		}
		{
			jbuttonResend = new JButton("Resend Code");
			GridBagConstraints gbc_jbuttonResend = new GridBagConstraints();
			gbc_jbuttonResend.insets = new Insets(0, 0, 5, 5);
			gbc_jbuttonResend.gridx = 3;
			gbc_jbuttonResend.gridy = 4;
			getContentPane().add(jbuttonResend, gbc_jbuttonResend);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("New Password");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 6;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jpasswordFieldNew = new JPasswordField();
			GridBagConstraints gbc_jpasswordFieldNew = new GridBagConstraints();
			gbc_jpasswordFieldNew.gridwidth = 2;
			gbc_jpasswordFieldNew.insets = new Insets(0, 0, 5, 5);
			gbc_jpasswordFieldNew.fill = GridBagConstraints.HORIZONTAL;
			gbc_jpasswordFieldNew.gridx = 2;
			gbc_jpasswordFieldNew.gridy = 6;
			getContentPane().add(jpasswordFieldNew, gbc_jpasswordFieldNew);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Confirm Password");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 7;
			getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			jpasswordFieldConfirm = new JPasswordField();
			GridBagConstraints gbc_jpasswordFieldConfirm = new GridBagConstraints();
			gbc_jpasswordFieldConfirm.gridwidth = 2;
			gbc_jpasswordFieldConfirm.insets = new Insets(0, 0, 5, 5);
			gbc_jpasswordFieldConfirm.fill = GridBagConstraints.HORIZONTAL;
			gbc_jpasswordFieldConfirm.gridx = 2;
			gbc_jpasswordFieldConfirm.gridy = 7;
			getContentPane().add(jpasswordFieldConfirm, gbc_jpasswordFieldConfirm);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 3;
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 8;
			getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				jbuttonSet = new JButton("Set New Password");
				panel.add(jbuttonSet);
			}
			{
				jbuttonCancel = new JButton("Cancel");
				panel.add(jbuttonCancel);
			}
		}
	}

}
