package jdialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.Employee;
import models.EmployeeModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JDialogChangePassword extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPasswordField jpasswordFieldCurrent;
	private JPasswordField jpasswordFieldNew;
	private JPasswordField jpasswordFieldConfirm;
	private JButton jbuttonCancel;
	private JButton jbuttonChange;
	private Map<String, Object> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogChangePassword dialog = new JDialogChangePassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogChangePassword() {
		setModal(true);
		setTitle("Change Password");
		setBounds(100, 100, 450, 241);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Change Password");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Current Password");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jpasswordFieldCurrent = new JPasswordField();
			GridBagConstraints gbc_jpasswordFieldCurrent = new GridBagConstraints();
			gbc_jpasswordFieldCurrent.insets = new Insets(0, 0, 5, 5);
			gbc_jpasswordFieldCurrent.fill = GridBagConstraints.HORIZONTAL;
			gbc_jpasswordFieldCurrent.gridx = 2;
			gbc_jpasswordFieldCurrent.gridy = 2;
			getContentPane().add(jpasswordFieldCurrent, gbc_jpasswordFieldCurrent);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("New Password");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jpasswordFieldNew = new JPasswordField();
			GridBagConstraints gbc_jpasswordFieldNew = new GridBagConstraints();
			gbc_jpasswordFieldNew.insets = new Insets(0, 0, 5, 5);
			gbc_jpasswordFieldNew.fill = GridBagConstraints.HORIZONTAL;
			gbc_jpasswordFieldNew.gridx = 2;
			gbc_jpasswordFieldNew.gridy = 3;
			getContentPane().add(jpasswordFieldNew, gbc_jpasswordFieldNew);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Confirm New Password");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jpasswordFieldConfirm = new JPasswordField();
			GridBagConstraints gbc_jpasswordFieldConfirm = new GridBagConstraints();
			gbc_jpasswordFieldConfirm.insets = new Insets(0, 0, 5, 5);
			gbc_jpasswordFieldConfirm.fill = GridBagConstraints.HORIZONTAL;
			gbc_jpasswordFieldConfirm.gridx = 2;
			gbc_jpasswordFieldConfirm.gridy = 4;
			getContentPane().add(jpasswordFieldConfirm, gbc_jpasswordFieldConfirm);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 5;
			getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				jbuttonChange = new JButton("Change Password");
				jbuttonChange.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonChange_actionPerformed(e);
					}
				});
				panel.add(jbuttonChange);
			}
			{
				jbuttonCancel = new JButton("Cancel");
				jbuttonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonCancel_actionPerformed(e);
					}
				});
				panel.add(jbuttonCancel);
			}
		}
	}

	public JDialogChangePassword(Map<String, Object> data) {
		this();
		this.data = data;
		initJDialog();
	}
	
	private void initJDialog() {
		int id = Integer.parseInt(data.get("id").toString());
	}
	
	protected void do_jbuttonChange_actionPerformed(ActionEvent e) {
		Employee employee = new Employee();
		EmployeeModel employeeModel = new EmployeeModel();
		
		int id = Integer.parseInt(data.get("id").toString());
		
		String currentPw = new String(jpasswordFieldCurrent.getPassword());
		String newPw = new String(jpasswordFieldNew.getPassword());
		String confirmPw = new String(jpasswordFieldConfirm.getPassword());
		
		if(currentPw.isEmpty() || currentPw == null) {
			JOptionPane.showMessageDialog(null, "Please enter your current password.", "System Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(newPw.isEmpty() || newPw == null) {
			JOptionPane.showMessageDialog(null, "New password cannot be empty.", "System Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(newPw.length() < 5) {
			JOptionPane.showMessageDialog(null, "New Password must have at least 5 character long.", "System Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(confirmPw.isEmpty() || confirmPw == null) {
			JOptionPane.showMessageDialog(null, "Please confirm your new password.", "System Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!BCrypt.checkpw(currentPw, employeeModel.findById(id).getPassword())) {
			JOptionPane.showMessageDialog(null, "Invalid current password.", "System Message", JOptionPane.ERROR_MESSAGE);
		} else if(!newPw.equals(confirmPw)) {
			JOptionPane.showMessageDialog(null, "Password confirmation does not match.", "System Message", JOptionPane.ERROR_MESSAGE);
		} else if(employeeModel.changePassword(id, newPw)) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "Password updated!", "System Message", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Undefined error.", "System Message", JOptionPane.ERROR_MESSAGE);
		}
		

	}
	
	protected void do_jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
