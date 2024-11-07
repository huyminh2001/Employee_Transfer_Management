package jdialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;
import entities.Projects;
import entities.Role;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RoleModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.toedter.calendar.JDateChooser;

public class JDialogEditProfile extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldName;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JTextField jtextFieldProject;
	private JTextField jtextFieldDepartment;
	private JTextField jtextFieldLocation;
	private Map<String, Object> data;
	private JLabel lblNewLabel_11;
	private JTextField jtextFieldId;
	private JButton jbuttonCancel;
	private JButton jbuttonConfirm;
	private JComboBox jcomboBoxRole;
	private JDateChooser jdateChooserJoining;
	private JComboBox jcomboBoxManager;
	private JComboBox jcomboBoxNhapProject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogEditProfile dialog = new JDialogEditProfile();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogEditProfile() {
		setModal(true);
		setTitle("Edit Profile");
		setBounds(100, 100, 450, 470);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Transfer Management");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Edit Profile");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			lblNewLabel_11 = new JLabel("ID");
			GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
			gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_11.gridx = 1;
			gbc_lblNewLabel_11.gridy = 3;
			getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);
		}
		{
			jtextFieldId = new JTextField();
			jtextFieldId.setEditable(false);
			GridBagConstraints gbc_jtextFieldId = new GridBagConstraints();
			gbc_jtextFieldId.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldId.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldId.gridx = 2;
			gbc_jtextFieldId.gridy = 3;
			getContentPane().add(jtextFieldId, gbc_jtextFieldId);
			jtextFieldId.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Name");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 4;
			getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtextFieldName = new JTextField();
			GridBagConstraints gbc_jtextFieldName = new GridBagConstraints();
			gbc_jtextFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldName.gridx = 2;
			gbc_jtextFieldName.gridy = 4;
			getContentPane().add(jtextFieldName, gbc_jtextFieldName);
			jtextFieldName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Email");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 5;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldEmail = new JTextField();
			jtextFieldEmail.setColumns(10);
			GridBagConstraints gbc_jtextFieldEmail = new GridBagConstraints();
			gbc_jtextFieldEmail.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmail.gridx = 2;
			gbc_jtextFieldEmail.gridy = 5;
			getContentPane().add(jtextFieldEmail, gbc_jtextFieldEmail);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Username");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 6;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jtextFieldUsername = new JTextField();
			jtextFieldUsername.setEditable(false);
			jtextFieldUsername.setColumns(10);
			GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
			gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldUsername.gridx = 2;
			gbc_jtextFieldUsername.gridy = 6;
			getContentPane().add(jtextFieldUsername, gbc_jtextFieldUsername);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Role");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 7;
			getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			jcomboBoxRole = new JComboBox();
			GridBagConstraints gbc_jcomboBoxRole = new GridBagConstraints();
			gbc_jcomboBoxRole.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxRole.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxRole.gridx = 2;
			gbc_jcomboBoxRole.gridy = 7;
			getContentPane().add(jcomboBoxRole, gbc_jcomboBoxRole);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Project");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 8;
			getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			jtextFieldProject = new JTextField();
			jtextFieldProject.setEditable(false);
			jtextFieldProject.setColumns(10);
			GridBagConstraints gbc_jtextFieldProject = new GridBagConstraints();
			gbc_jtextFieldProject.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldProject.gridx = 2;
			gbc_jtextFieldProject.gridy = 8;
			getContentPane().add(jtextFieldProject, gbc_jtextFieldProject);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Department");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 9;
			getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			jtextFieldDepartment = new JTextField();
			jtextFieldDepartment.setEditable(false);
			jtextFieldDepartment.setColumns(10);
			GridBagConstraints gbc_jtextFieldDepartment = new GridBagConstraints();
			gbc_jtextFieldDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldDepartment.gridx = 2;
			gbc_jtextFieldDepartment.gridy = 9;
			getContentPane().add(jtextFieldDepartment, gbc_jtextFieldDepartment);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Location");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 10;
			getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			jtextFieldLocation = new JTextField();
			jtextFieldLocation.setEditable(false);
			jtextFieldLocation.setColumns(10);
			GridBagConstraints gbc_jtextFieldLocation = new GridBagConstraints();
			gbc_jtextFieldLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldLocation.gridx = 2;
			gbc_jtextFieldLocation.gridy = 10;
			getContentPane().add(jtextFieldLocation, gbc_jtextFieldLocation);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Joining Date");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 11;
			getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			jdateChooserJoining = new JDateChooser();
			GridBagConstraints gbc_jdateChooserJoining = new GridBagConstraints();
			gbc_jdateChooserJoining.insets = new Insets(0, 0, 5, 5);
			gbc_jdateChooserJoining.fill = GridBagConstraints.BOTH;
			gbc_jdateChooserJoining.gridx = 2;
			gbc_jdateChooserJoining.gridy = 11;
			getContentPane().add(jdateChooserJoining, gbc_jdateChooserJoining);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("Manager");
			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
			gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_10.gridx = 1;
			gbc_lblNewLabel_10.gridy = 12;
			getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		}
		{
			jcomboBoxManager = new JComboBox();
			GridBagConstraints gbc_jcomboBoxManager = new GridBagConstraints();
			gbc_jcomboBoxManager.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxManager.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxManager.gridx = 2;
			gbc_jcomboBoxManager.gridy = 12;
			getContentPane().add(jcomboBoxManager, gbc_jcomboBoxManager);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 13;
			getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				jbuttonConfirm = new JButton("Confirm");
				jbuttonConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonConfirm_actionPerformed(e);
					}
				});
				panel.add(jbuttonConfirm);
			}
			{
				jbuttonCancel = new JButton("Cancel");
				panel.add(jbuttonCancel);
			}
		}
		{
			jcomboBoxNhapProject = new JComboBox();
			GridBagConstraints gbc_jcomboBoxNhapProject = new GridBagConstraints();
			gbc_jcomboBoxNhapProject.insets = new Insets(0, 0, 0, 5);
			gbc_jcomboBoxNhapProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxNhapProject.gridx = 2;
			gbc_jcomboBoxNhapProject.gridy = 14;
			getContentPane().add(jcomboBoxNhapProject, gbc_jcomboBoxNhapProject);
		}
	}
	
	public JDialogEditProfile(Map<String, Object> data) {
		this();
		this.data = data;
		initJDialog();
		
	}
	
	private void initJDialog() {
		profileRender();
	}
	
	private void profileRender() {
		int id = Integer.parseInt(data.get("id").toString());
		jtextFieldId.setText(String.valueOf(id));
		
		String name = data.get("name").toString();
		jtextFieldName.setText(name);
		
		String email = data.get("email").toString();
		jtextFieldEmail.setText(email);
		
		String username = data.get("username").toString();
		jtextFieldUsername.setText(username);
		
		int roleId = Integer.parseInt(data.get("roleId").toString());
		RoleModel roleModel = new RoleModel();
//		jtextFieldRole.setText(roleModel.findById(roleId).getName());
		jcomboBoxRole.setSelectedItem(roleId);
		
		int projectId = Integer.parseInt(data.get("projectId").toString());
		ProjectsModel projectsModel = new ProjectsModel();
		jtextFieldProject.setText(projectsModel.findById(projectId).getName());
		
		int departmentId = Integer.parseInt(data.get("departmentId").toString());
		DepartmentModel departmentModel = new DepartmentModel();
		jtextFieldDepartment.setText(departmentModel.findById(departmentId).getName());
		
		int locationId = Integer.parseInt(data.get("locationId").toString());
		LocationModel locationModel = new LocationModel();
		jtextFieldLocation.setText(locationModel.findById(locationId).getName());
		
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat("dd/MM/yyyy");
//		String joiningDate = simpleDateFormate.format(data.get("joiningDate"));
//		Date joiningDate = Date.parse(data.get("joiningDate").toString());
//		jtextFieldJoiningDate.setText(joiningDate);
		Date joiningDate = (Date) data.get("joiningDate");
		jdateChooserJoining.setDate(joiningDate);
		
		int managerId = Integer.parseInt(data.get("managerId").toString());
		EmployeeModel employeeModel = new EmployeeModel();
//		jtextFieldManager.setText(employeeModel.findById(managerId).getName());
		jcomboBoxManager.setSelectedItem(managerId);
		
		DefaultComboBoxModel<Projects> nhapProjComboBox = new DefaultComboBoxModel();
		for(Projects project : projectsModel.findAll()) {
			nhapProjComboBox.addElement(project);
		}
		jcomboBoxNhapProject.setModel(nhapProjComboBox);
		jcomboBoxNhapProject.setRenderer(new ProjectCellRender());
		
		jcomboBoxNhapProject.getModel().setSelectedItem(projectsModel.findById(3));
	}
	
	protected void do_jbuttonConfirm_actionPerformed(ActionEvent e) {
		Employee employee = new Employee();
		EmployeeModel employeeModel = new EmployeeModel();
		
//		employee.setName(getName());
	}
	
//	====================================================================
	
	private class ProjectCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects projects = (Projects) value;
			return super.getListCellRendererComponent(list, projects.getId() + " - " + projects.getName(), index, isSelected, cellHasFocus);
		}
		
	}
}
