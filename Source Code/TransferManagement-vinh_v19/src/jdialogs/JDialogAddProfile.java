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
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.Department;
import entities.Employee;
import entities.Location;
import entities.Projects;
import entities.Records;
import entities.Role;
import helpers.MailHelpers;
import helpers.ValidateHelper;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RecordModel;
import models.RoleModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;

public class JDialogAddProfile extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldName;
	private JButton jbuttonAdd;
	private JButton jbuttonCancel;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JComboBox jcomboBoxRole;
	private JComboBox jcomboBoxProject;
	private JComboBox jcomboBoxDepartment;
	private JComboBox jcomboBoxLocation;
	private JDateChooser jdateChooserJoining;
	private JComboBox jcomboBoxManager;
	private Map<String, Object> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogAddProfile dialog = new JDialogAddProfile();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogAddProfile() {
		setModal(true);
		setTitle("Add Profile");
		setBounds(100, 100, 450, 451);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 32, 0, 0, 32, 0 };
		gridBagLayout.rowHeights = new int[] { 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
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
			JLabel lblNewLabel_1 = new JLabel("Add Profile");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Name");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtextFieldName = new JTextField();
			GridBagConstraints gbc_jtextFieldName = new GridBagConstraints();
			gbc_jtextFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldName.gridx = 2;
			gbc_jtextFieldName.gridy = 3;
			getContentPane().add(jtextFieldName, gbc_jtextFieldName);
			jtextFieldName.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Email");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldEmail = new JTextField();
			GridBagConstraints gbc_jtextFieldEmail = new GridBagConstraints();
			gbc_jtextFieldEmail.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmail.gridx = 2;
			gbc_jtextFieldEmail.gridy = 4;
			getContentPane().add(jtextFieldEmail, gbc_jtextFieldEmail);
			jtextFieldEmail.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Username");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jtextFieldUsername = new JTextField();
			GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
			gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldUsername.gridx = 2;
			gbc_jtextFieldUsername.gridy = 5;
			getContentPane().add(jtextFieldUsername, gbc_jtextFieldUsername);
			jtextFieldUsername.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Role");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 7;
			getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
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
			JLabel lblNewLabel_7 = new JLabel("Project");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 8;
			getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			jcomboBoxProject = new JComboBox();
			GridBagConstraints gbc_jcomboBoxProject = new GridBagConstraints();
			gbc_jcomboBoxProject.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxProject.gridx = 2;
			gbc_jcomboBoxProject.gridy = 8;
			getContentPane().add(jcomboBoxProject, gbc_jcomboBoxProject);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Department");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 9;
			getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			jcomboBoxDepartment = new JComboBox();
			GridBagConstraints gbc_jcomboBoxDepartment = new GridBagConstraints();
			gbc_jcomboBoxDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxDepartment.gridx = 2;
			gbc_jcomboBoxDepartment.gridy = 9;
			getContentPane().add(jcomboBoxDepartment, gbc_jcomboBoxDepartment);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Location");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 10;
			getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			jcomboBoxLocation = new JComboBox();
			GridBagConstraints gbc_jcomboBoxLocation = new GridBagConstraints();
			gbc_jcomboBoxLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxLocation.gridx = 2;
			gbc_jcomboBoxLocation.gridy = 10;
			getContentPane().add(jcomboBoxLocation, gbc_jcomboBoxLocation);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("Joining Date");
			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
			gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_10.gridx = 1;
			gbc_lblNewLabel_10.gridy = 11;
			getContentPane().add(lblNewLabel_10, gbc_lblNewLabel_10);
		}
		{
			jdateChooserJoining = new JDateChooser();
			jdateChooserJoining.setDateFormatString("yyyy-MM-dd");
			GridBagConstraints gbc_jdateChooserJoining = new GridBagConstraints();
			gbc_jdateChooserJoining.insets = new Insets(0, 0, 5, 5);
			gbc_jdateChooserJoining.fill = GridBagConstraints.BOTH;
			gbc_jdateChooserJoining.gridx = 2;
			gbc_jdateChooserJoining.gridy = 11;
			getContentPane().add(jdateChooserJoining, gbc_jdateChooserJoining);
		}
		{
			JLabel lblNewLabel_11 = new JLabel("Manager");
			GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
			gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_11.gridx = 1;
			gbc_lblNewLabel_11.gridy = 12;
			getContentPane().add(lblNewLabel_11, gbc_lblNewLabel_11);
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
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 13;
			getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				jbuttonAdd = new JButton("Add");
				jbuttonAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonAdd_actionPerformed(e);
					}
				});
				panel.add(jbuttonAdd);
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
	
	public JDialogAddProfile(Map<String, Object> data) {
		this();
		this.data = data;
		initJDialog();
	}

	private void initJDialog() {

		RoleModel roleModel = new RoleModel();
		ProjectsModel projectsModel = new ProjectsModel();
		DepartmentModel departmentModel = new DepartmentModel();
		LocationModel locationModel = new LocationModel();
		EmployeeModel employeeModel = new EmployeeModel();

		DefaultComboBoxModel<Role> roleComboBoxModel = new DefaultComboBoxModel<Role>();
		DefaultComboBoxModel<Projects> projectsComboBoxModel = new DefaultComboBoxModel<Projects>();
		DefaultComboBoxModel<Department> departmentComboBoxModel = new DefaultComboBoxModel<Department>();
		DefaultComboBoxModel<Location> locationComboBoxModel = new DefaultComboBoxModel<Location>();
		DefaultComboBoxModel<Employee> employeeComboBoxModel = new DefaultComboBoxModel<Employee>();

		for (Role role : roleModel.findAll()) {
			roleComboBoxModel.addElement(role);
		}

		for (Projects project : projectsModel.findAll()) {
			projectsComboBoxModel.addElement(project);
		}

		for (Department department : departmentModel.findAll()) {
			departmentComboBoxModel.addElement(department);
		}

		for (Location location : locationModel.findAll()) {
			locationComboBoxModel.addElement(location);
		}

		for (Employee employee : employeeModel.findAll()) {
			employeeComboBoxModel.addElement(employee);
		}

		jcomboBoxRole.setModel(roleComboBoxModel);
		jcomboBoxProject.setModel(projectsComboBoxModel);
		jcomboBoxDepartment.setModel(departmentComboBoxModel);
		jcomboBoxLocation.setModel(locationComboBoxModel);

		employeeComboBoxModel.addElement(new Employee(-1, "None"));
//		employeeComboBoxModel.addElement(null);
		jcomboBoxManager.setModel(employeeComboBoxModel);

		jcomboBoxRole.setRenderer(new RoleCellRender());
		jcomboBoxProject.setRenderer(new ProjectsCellRender());
		jcomboBoxDepartment.setRenderer(new DepartmentCellRender());
		jcomboBoxLocation.setRenderer(new LocationCellRender());
		jcomboBoxManager.setRenderer(new EmployeeCellRender());
		
		Calendar today = Calendar.getInstance();
		jdateChooserJoining.setMinSelectableDate(today.getTime());
	}

	private class RoleCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getName(), index, isSelected, cellHasFocus);
		}

	}

	private class ProjectsCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects project = (Projects) value;
			return super.getListCellRendererComponent(list, project.getName(), index, isSelected, cellHasFocus);
		}

	}

	private class DepartmentCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getName(), index, isSelected, cellHasFocus);
		}

	}

	private class LocationCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Location location = (Location) value;
			return super.getListCellRendererComponent(list, location.getName(), index, isSelected, cellHasFocus);
		}

	}

	private class EmployeeCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Employee employee = (Employee) value;
			String employeeRender = "";
			if (employee.getId() != -1) {
				employeeRender = employee.getId() + " - " + employee.getName();
			} else {
				employeeRender = employee.getName();
			}
			return super.getListCellRendererComponent(list, employeeRender, index, isSelected, cellHasFocus);
		}

	}

	// Generate random password
	private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom random = new SecureRandom();

	public static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(ALPHANUMERIC_STRING.length());
			sb.append(ALPHANUMERIC_STRING.charAt(index));
		}
		return sb.toString();
	}

	protected void do_jbuttonAdd_actionPerformed(ActionEvent e) {
		RecordModel recordModel = new RecordModel();
		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = new Employee();
		
		String employeeName = jtextFieldName.getText().trim();
		String employeeEmail = jtextFieldEmail.getText().trim();
		String employeeUsername = jtextFieldUsername.getText().trim();
//		String employeePassword = new String(jpasswordTempPassword.getPassword()).trim();
		Date employeeJoiningDate = jdateChooserJoining.getDate();
		
		if(employeeName.isEmpty() || employeeName == null) {
			JOptionPane.showMessageDialog(null, "Employee name cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeName.length() < 3) {
			JOptionPane.showMessageDialog(null, "Employee name must at least 3 characters long", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isText(employeeName)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee name", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeEmail.isEmpty() || employeeEmail == null) {
			JOptionPane.showMessageDialog(null, "Employee email cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isValidEmail(employeeEmail)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee email", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeUsername.isEmpty() || employeeUsername == null) {
			JOptionPane.showMessageDialog(null, "Employee username cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeUsername.length() < 6) {
			JOptionPane.showMessageDialog(null, "Employee username must at least 6 characters long", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isUsername(employeeUsername)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee username", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
//		if(employeePassword.isEmpty() || employeePassword == null) {
//			JOptionPane.showMessageDialog(null, "Employee password cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
		
		if(employeeJoiningDate == null) {
			JOptionPane.showMessageDialog(null, "Employee joining date cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeModel.doesEmployeeNameExist(employeeName)) {
			JOptionPane.showMessageDialog(null, "Employee name already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeModel.doesEmailExist(employeeEmail)) {
			JOptionPane.showMessageDialog(null, "Employee email already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(employeeModel.doesUsernameExist(employeeUsername)) {
			JOptionPane.showMessageDialog(null, "Employee username already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String randomPassword = generateRandomString(10);
			
		employee.setName(employeeName);
		employee.setEmail(employeeEmail);
		employee.setUsername(employeeUsername);
		employee.setPassword(randomPassword);
		employee.setJoiningDate(employeeJoiningDate);
		
		Role role = (Role) jcomboBoxRole.getSelectedItem();
		employee.setRoleId(role.getId());
		
		Projects project = (Projects) jcomboBoxProject.getSelectedItem();
		employee.setCurrentProject(project.getId());
		
		Department department = (Department) jcomboBoxDepartment.getSelectedItem();
		employee.setCurrentDepartment(department.getId());
		
		Location location = (Location) jcomboBoxLocation.getSelectedItem();
		employee.setCurrentLocation(location.getId());
		
		Employee manager = (Employee) jcomboBoxManager.getSelectedItem();
		employee.setManagerId(manager.getId());
			
		if (manager.getId() != -1) {
			employee.setManagerId(manager.getId());
			if (employeeModel.create(employee)) {
				String mailSubject = "Transfer Management - Account Creation";

				String mailBody = "<!--\r\n"
						+ "* This email was built using Tabular.\r\n"
						+ "* For more information, visit https://tabular.email\r\n"
						+ "-->\r\n"
						+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
						+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "<title></title>\r\n"
						+ "<meta charset=\"UTF-8\" />\r\n"
						+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<meta name=\"x-apple-disable-message-reformatting\" content=\"\" />\r\n"
						+ "<meta content=\"target-densitydpi=device-dpi\" name=\"viewport\" />\r\n"
						+ "<meta content=\"true\" name=\"HandheldFriendly\" />\r\n"
						+ "<meta content=\"width=device-width\" name=\"viewport\" />\r\n"
						+ "<meta name=\"format-detection\" content=\"telephone=no, date=no, address=no, email=no, url=no\" />\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "table {\r\n"
						+ "border-collapse: separate;\r\n"
						+ "table-layout: fixed;\r\n"
						+ "mso-table-lspace: 0pt;\r\n"
						+ "mso-table-rspace: 0pt\r\n"
						+ "}\r\n"
						+ "table td {\r\n"
						+ "border-collapse: collapse\r\n"
						+ "}\r\n"
						+ ".ExternalClass {\r\n"
						+ "width: 100%\r\n"
						+ "}\r\n"
						+ ".ExternalClass,\r\n"
						+ ".ExternalClass p,\r\n"
						+ ".ExternalClass span,\r\n"
						+ ".ExternalClass font,\r\n"
						+ ".ExternalClass td,\r\n"
						+ ".ExternalClass div {\r\n"
						+ "line-height: 100%\r\n"
						+ "}\r\n"
						+ "body, a, li, p, h1, h2, h3 {\r\n"
						+ "-ms-text-size-adjust: 100%;\r\n"
						+ "-webkit-text-size-adjust: 100%;\r\n"
						+ "}\r\n"
						+ "html {\r\n"
						+ "-webkit-text-size-adjust: none !important\r\n"
						+ "}\r\n"
						+ "body, #innerTable {\r\n"
						+ "-webkit-font-smoothing: antialiased;\r\n"
						+ "-moz-osx-font-smoothing: grayscale\r\n"
						+ "}\r\n"
						+ "#innerTable img+div {\r\n"
						+ "display: none;\r\n"
						+ "display: none !important\r\n"
						+ "}\r\n"
						+ "img {\r\n"
						+ "Margin: 0;\r\n"
						+ "padding: 0;\r\n"
						+ "-ms-interpolation-mode: bicubic\r\n"
						+ "}\r\n"
						+ "h1, h2, h3, p, a {\r\n"
						+ "line-height: inherit;\r\n"
						+ "overflow-wrap: normal;\r\n"
						+ "white-space: normal;\r\n"
						+ "word-break: break-word\r\n"
						+ "}\r\n"
						+ "a {\r\n"
						+ "text-decoration: none\r\n"
						+ "}\r\n"
						+ "h1, h2, h3, p {\r\n"
						+ "min-width: 100%!important;\r\n"
						+ "width: 100%!important;\r\n"
						+ "max-width: 100%!important;\r\n"
						+ "display: inline-block!important;\r\n"
						+ "border: 0;\r\n"
						+ "padding: 0;\r\n"
						+ "margin: 0\r\n"
						+ "}\r\n"
						+ "a[x-apple-data-detectors] {\r\n"
						+ "color: inherit !important;\r\n"
						+ "text-decoration: none !important;\r\n"
						+ "font-size: inherit !important;\r\n"
						+ "font-family: inherit !important;\r\n"
						+ "font-weight: inherit !important;\r\n"
						+ "line-height: inherit !important\r\n"
						+ "}\r\n"
						+ "u + #body a {\r\n"
						+ "color: inherit;\r\n"
						+ "text-decoration: none;\r\n"
						+ "font-size: inherit;\r\n"
						+ "font-family: inherit;\r\n"
						+ "font-weight: inherit;\r\n"
						+ "line-height: inherit;\r\n"
						+ "}\r\n"
						+ "a[href^=\"mailto\"],\r\n"
						+ "a[href^=\"tel\"],\r\n"
						+ "a[href^=\"sms\"] {\r\n"
						+ "color: inherit;\r\n"
						+ "text-decoration: none\r\n"
						+ "}\r\n"
						+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (min-width: 481px) {\r\n"
						+ ".hd { display: none!important }\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (max-width: 480px) {\r\n"
						+ ".hm { display: none!important }\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (min-width: 481px) {\r\n"
						+ "h1,img,p{margin:0;Margin:0}.t1,.t12,.t15,.t5,.t8{width:480px!important}img,p{font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2,h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;font-weight:400;font-style:normal;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{line-height:30px;font-size:24px}h3{line-height:26px;font-size:20px}.t14,.t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important}\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">@media (min-width: 481px) {[class~=\"x_t14\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t17\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t15\"]{padding-left:60px!important;padding-top:60px!important;padding-bottom:60px!important;padding-right:60px!important;border-top-left-radius:8px!important;border-top-right-radius:8px!important;border-bottom-right-radius:8px!important;border-bottom-left-radius:8px!important;overflow:hidden!important;width:480px!important;} [class~=\"x_t8\"]{width:480px!important;} [class~=\"x_t1\"]{width:480px!important;} [class~=\"x_t12\"]{width:480px!important;} [class~=\"x_t5\"]{width:480px!important;}}</style>\r\n"
						+ "<style type=\"text/css\" media=\"screen and (min-width:481px)\">.moz-text-html img,.moz-text-html p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html .t14,.moz-text-html .t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.moz-text-html .t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important;width:480px!important}.moz-text-html .t1,.moz-text-html .t12,.moz-text-html .t5,.moz-text-html .t8{width:480px!important}</style>\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<link href=\"https://fonts.googleapis.com/css2?family=Albert+Sans:wght@400;600;800&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}div.t14,div.t17{mso-line-height-alt:60px !important;line-height:60px !important;display:block !important}td.t15{padding:60px !important;border-radius:8px !important;overflow:hidden !important}\r\n"
						+ "</style>\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<xml>\r\n"
						+ "<o:OfficeDocumentSettings>\r\n"
						+ "<o:AllowPNG/>\r\n"
						+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
						+ "</o:OfficeDocumentSettings>\r\n"
						+ "</xml>\r\n"
						+ "<![endif]-->\r\n"
						+ "</head>\r\n"
						+ "<body id=\"body\" class=\"t20\" style=\"min-width:100%;Margin:0px;padding:0px;background-color:#F4F4F4;\"><div class=\"t19\" style=\"background-color:#F4F4F4;\"><table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"><tr><td class=\"t18\" style=\"font-size:0;line-height:0;mso-line-height-rule:exactly;background-color:#F4F4F4;\" valign=\"top\" align=\"center\">\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\">\r\n"
						+ "<v:fill color=\"#F4F4F4\"/>\r\n"
						+ "</v:background>\r\n"
						+ "<![endif]-->\r\n"
						+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" id=\"innerTable\"><tr><td><div class=\"t14\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t16\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"600\" class=\"t15\" style=\"background-color:#FFFFFF;padding:40px 40px 40px 40px;\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t15\" style=\"background-color:#FFFFFF;width:400px;padding:40px 40px 40px 40px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%!important;\"><tr><td align=\"center\">\r\n"
						+ "<table class=\"t2\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t1\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t1\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<h1 class=\"t0\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:600;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">Initial Password</h1></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t3\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t6\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t5\" style=\"padding:0 0 16px 0;\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t5\" style=\"width:400px;padding:0 0 16px 0;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<p class=\"t4\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Hello "+ jtextFieldUsername.getText() +"</p></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t9\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t8\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t8\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<h1 class=\"t7\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:800;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">"+randomPassword+"</h1></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t10\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t13\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t12\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t12\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<p class=\"t11\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Your account has been created. Here is the inital password for your account.</p></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr></table></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t17\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr></table></td></tr></table></div></body>\r\n"
						+ "</html>";
				String mailTo = employeeModel.findByUsername(jtextFieldUsername.getText()).getEmail();
				MailHelpers.send("vinhduc0304@gmail.com", mailTo, mailSubject, mailBody);

				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Profile is created. Verification email has been sent.", "Add Profile",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Profile cannot be created. Please check your input.",
						"Add Profile", JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			if(employeeModel.createManagerNull(employee)) {
				String mailSubject = "Transfer Management - Account Creation";
				String mailBody = "<!--\r\n"
						+ "* This email was built using Tabular.\r\n"
						+ "* For more information, visit https://tabular.email\r\n"
						+ "-->\r\n"
						+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
						+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "<title></title>\r\n"
						+ "<meta charset=\"UTF-8\" />\r\n"
						+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<meta name=\"x-apple-disable-message-reformatting\" content=\"\" />\r\n"
						+ "<meta content=\"target-densitydpi=device-dpi\" name=\"viewport\" />\r\n"
						+ "<meta content=\"true\" name=\"HandheldFriendly\" />\r\n"
						+ "<meta content=\"width=device-width\" name=\"viewport\" />\r\n"
						+ "<meta name=\"format-detection\" content=\"telephone=no, date=no, address=no, email=no, url=no\" />\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "table {\r\n"
						+ "border-collapse: separate;\r\n"
						+ "table-layout: fixed;\r\n"
						+ "mso-table-lspace: 0pt;\r\n"
						+ "mso-table-rspace: 0pt\r\n"
						+ "}\r\n"
						+ "table td {\r\n"
						+ "border-collapse: collapse\r\n"
						+ "}\r\n"
						+ ".ExternalClass {\r\n"
						+ "width: 100%\r\n"
						+ "}\r\n"
						+ ".ExternalClass,\r\n"
						+ ".ExternalClass p,\r\n"
						+ ".ExternalClass span,\r\n"
						+ ".ExternalClass font,\r\n"
						+ ".ExternalClass td,\r\n"
						+ ".ExternalClass div {\r\n"
						+ "line-height: 100%\r\n"
						+ "}\r\n"
						+ "body, a, li, p, h1, h2, h3 {\r\n"
						+ "-ms-text-size-adjust: 100%;\r\n"
						+ "-webkit-text-size-adjust: 100%;\r\n"
						+ "}\r\n"
						+ "html {\r\n"
						+ "-webkit-text-size-adjust: none !important\r\n"
						+ "}\r\n"
						+ "body, #innerTable {\r\n"
						+ "-webkit-font-smoothing: antialiased;\r\n"
						+ "-moz-osx-font-smoothing: grayscale\r\n"
						+ "}\r\n"
						+ "#innerTable img+div {\r\n"
						+ "display: none;\r\n"
						+ "display: none !important\r\n"
						+ "}\r\n"
						+ "img {\r\n"
						+ "Margin: 0;\r\n"
						+ "padding: 0;\r\n"
						+ "-ms-interpolation-mode: bicubic\r\n"
						+ "}\r\n"
						+ "h1, h2, h3, p, a {\r\n"
						+ "line-height: inherit;\r\n"
						+ "overflow-wrap: normal;\r\n"
						+ "white-space: normal;\r\n"
						+ "word-break: break-word\r\n"
						+ "}\r\n"
						+ "a {\r\n"
						+ "text-decoration: none\r\n"
						+ "}\r\n"
						+ "h1, h2, h3, p {\r\n"
						+ "min-width: 100%!important;\r\n"
						+ "width: 100%!important;\r\n"
						+ "max-width: 100%!important;\r\n"
						+ "display: inline-block!important;\r\n"
						+ "border: 0;\r\n"
						+ "padding: 0;\r\n"
						+ "margin: 0\r\n"
						+ "}\r\n"
						+ "a[x-apple-data-detectors] {\r\n"
						+ "color: inherit !important;\r\n"
						+ "text-decoration: none !important;\r\n"
						+ "font-size: inherit !important;\r\n"
						+ "font-family: inherit !important;\r\n"
						+ "font-weight: inherit !important;\r\n"
						+ "line-height: inherit !important\r\n"
						+ "}\r\n"
						+ "u + #body a {\r\n"
						+ "color: inherit;\r\n"
						+ "text-decoration: none;\r\n"
						+ "font-size: inherit;\r\n"
						+ "font-family: inherit;\r\n"
						+ "font-weight: inherit;\r\n"
						+ "line-height: inherit;\r\n"
						+ "}\r\n"
						+ "a[href^=\"mailto\"],\r\n"
						+ "a[href^=\"tel\"],\r\n"
						+ "a[href^=\"sms\"] {\r\n"
						+ "color: inherit;\r\n"
						+ "text-decoration: none\r\n"
						+ "}\r\n"
						+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (min-width: 481px) {\r\n"
						+ ".hd { display: none!important }\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (max-width: 480px) {\r\n"
						+ ".hm { display: none!important }\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "@media (min-width: 481px) {\r\n"
						+ "h1,img,p{margin:0;Margin:0}.t1,.t12,.t15,.t5,.t8{width:480px!important}img,p{font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2,h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;font-weight:400;font-style:normal;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{line-height:30px;font-size:24px}h3{line-height:26px;font-size:20px}.t14,.t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important}\r\n"
						+ "}\r\n"
						+ "</style>\r\n"
						+ "<style type=\"text/css\">@media (min-width: 481px) {[class~=\"x_t14\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t17\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t15\"]{padding-left:60px!important;padding-top:60px!important;padding-bottom:60px!important;padding-right:60px!important;border-top-left-radius:8px!important;border-top-right-radius:8px!important;border-bottom-right-radius:8px!important;border-bottom-left-radius:8px!important;overflow:hidden!important;width:480px!important;} [class~=\"x_t8\"]{width:480px!important;} [class~=\"x_t1\"]{width:480px!important;} [class~=\"x_t12\"]{width:480px!important;} [class~=\"x_t5\"]{width:480px!important;}}</style>\r\n"
						+ "<style type=\"text/css\" media=\"screen and (min-width:481px)\">.moz-text-html img,.moz-text-html p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html .t14,.moz-text-html .t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.moz-text-html .t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important;width:480px!important}.moz-text-html .t1,.moz-text-html .t12,.moz-text-html .t5,.moz-text-html .t8{width:480px!important}</style>\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<link href=\"https://fonts.googleapis.com/css2?family=Albert+Sans:wght@400;600;800&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<style type=\"text/css\">\r\n"
						+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}div.t14,div.t17{mso-line-height-alt:60px !important;line-height:60px !important;display:block !important}td.t15{padding:60px !important;border-radius:8px !important;overflow:hidden !important}\r\n"
						+ "</style>\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<xml>\r\n"
						+ "<o:OfficeDocumentSettings>\r\n"
						+ "<o:AllowPNG/>\r\n"
						+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
						+ "</o:OfficeDocumentSettings>\r\n"
						+ "</xml>\r\n"
						+ "<![endif]-->\r\n"
						+ "</head>\r\n"
						+ "<body id=\"body\" class=\"t20\" style=\"min-width:100%;Margin:0px;padding:0px;background-color:#F4F4F4;\"><div class=\"t19\" style=\"background-color:#F4F4F4;\"><table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"><tr><td class=\"t18\" style=\"font-size:0;line-height:0;mso-line-height-rule:exactly;background-color:#F4F4F4;\" valign=\"top\" align=\"center\">\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\">\r\n"
						+ "<v:fill color=\"#F4F4F4\"/>\r\n"
						+ "</v:background>\r\n"
						+ "<![endif]-->\r\n"
						+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" id=\"innerTable\"><tr><td><div class=\"t14\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t16\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"600\" class=\"t15\" style=\"background-color:#FFFFFF;padding:40px 40px 40px 40px;\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t15\" style=\"background-color:#FFFFFF;width:400px;padding:40px 40px 40px 40px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%!important;\"><tr><td align=\"center\">\r\n"
						+ "<table class=\"t2\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t1\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t1\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<h1 class=\"t0\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:600;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">Initial Password</h1></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t3\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t6\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t5\" style=\"padding:0 0 16px 0;\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t5\" style=\"width:400px;padding:0 0 16px 0;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<p class=\"t4\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Hello "+ jtextFieldUsername.getText() +"</p></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t9\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t8\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t8\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<h1 class=\"t7\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:800;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">"+randomPassword+"</h1></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t10\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
						+ "<table class=\"t13\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
						+ "<tr>\r\n"
						+ "<!--[if mso]>\r\n"
						+ "<td width=\"480\" class=\"t12\">\r\n"
						+ "<![endif]-->\r\n"
						+ "<!--[if !mso]>-->\r\n"
						+ "<td class=\"t12\" style=\"width:400px;\">\r\n"
						+ "<!--<![endif]-->\r\n"
						+ "<p class=\"t11\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Your account has been created. Here is the inital password for your account.</p></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr></table></td>\r\n"
						+ "</tr></table>\r\n"
						+ "</td></tr><tr><td><div class=\"t17\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr></table></td></tr></table></div></body>\r\n"
						+ "</html>";
				String mailTo = employeeModel.findByUsername(jtextFieldUsername.getText()).getEmail();
				MailHelpers.send("vinhduc0304@gmail.com", mailTo, mailSubject, mailBody);

				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Profile is created. Verification email has been sent.", "Add Profile",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Profile cannot be created. Please check your input.", "Add Profile",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		Records employeeRecords = new Records();
		
		employeeRecords.setEmployeeId(Integer.parseInt(data.get("id").toString()));

		employeeRecords.setRequestFor(employeeModel.findByName(employee.getName()).getId());
		
		if(employee.getCurrentProject() != null) {
			employeeRecords.setProjectTo(employee.getCurrentProject());
			System.out.println("Project: " + employee.getCurrentProject());
		}
		
		if(employee.getCurrentDepartment() != null) {
			employeeRecords.setDepartmentTo(employee.getCurrentDepartment());
			System.out.println("Department: " + employee.getCurrentDepartment());
		}
		
		if(employee.getCurrentLocation() != null) {
			employeeRecords.setLocationTo(employee.getCurrentLocation());
			System.out.println("Location: " + employee.getCurrentLocation());
		}
		
		if(employee.getJoiningDate() != null) {
			employeeRecords.setTransferJoiningDate(employee.getJoiningDate());
			System.out.println("Joining Date: " + employee.getJoiningDate());
		}
		
		
		if(recordModel.createEmployeeRecord(employeeRecords)) {
			JOptionPane.showMessageDialog(null, "Create record success", "Success", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Create record failed", "Warning", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	protected void do_jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
