package jdialogs;


import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


import entities.Department;
import entities.Employee;
import entities.Location;
import entities.Projects;
import entities.Role;
import helpers.ValidateHelper;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RoleModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class JDialogUpdateEmployeeRecord extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JComboBox jcomboBoxRole;
	private JComboBox jcomboBoxManager;
	private JComboBox jcomboBoxCurrentProject;
	private JComboBox jcomboBoxCurrentDepartment;
	private JComboBox jcomboBoxCurrentLocation;
	private JButton jbuttonUpdateEmployee;
	private JButton jbuttonCancel;
	private Map<String, Object> employeeData;
	private Employee employee;
	private JLabel lblNewLabel_9;
	private JDateChooser jdateChooserJoining;
	
	/**
	 * @wbp.parser.constructor
	 */
	public JDialogUpdateEmployeeRecord(UpdateEmployeeRespone updateEmployeeRespone) {
		setTitle("Update Record");
		setModal(true);
		setBounds(100, 100, 660, 418);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 374, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Update Employee Record");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Name");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtextFieldEmployeeName = new JTextField();
			GridBagConstraints gbc_jtextFieldEmployeeName = new GridBagConstraints();
			gbc_jtextFieldEmployeeName.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmployeeName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmployeeName.gridx = 2;
			gbc_jtextFieldEmployeeName.gridy = 2;
			getContentPane().add(jtextFieldEmployeeName, gbc_jtextFieldEmployeeName);
			jtextFieldEmployeeName.setColumns(10);
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
			gbc_jtextFieldEmail.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmail.gridx = 2;
			gbc_jtextFieldEmail.gridy = 3;
			getContentPane().add(jtextFieldEmail, gbc_jtextFieldEmail);
			jtextFieldEmail.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Username");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldUsername = new JTextField();
			GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
			gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldUsername.gridx = 2;
			gbc_jtextFieldUsername.gridy = 4;
			getContentPane().add(jtextFieldUsername, gbc_jtextFieldUsername);
			jtextFieldUsername.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Role");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 5;
			getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			jcomboBoxRole = new JComboBox();
			GridBagConstraints gbc_jcomboBoxRole = new GridBagConstraints();
			gbc_jcomboBoxRole.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxRole.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxRole.gridx = 2;
			gbc_jcomboBoxRole.gridy = 5;
			getContentPane().add(jcomboBoxRole, gbc_jcomboBoxRole);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Manager");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 6;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jcomboBoxManager = new JComboBox();
			GridBagConstraints gbc_jcomboBoxManager = new GridBagConstraints();
			gbc_jcomboBoxManager.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxManager.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxManager.gridx = 2;
			gbc_jcomboBoxManager.gridy = 6;
			getContentPane().add(jcomboBoxManager, gbc_jcomboBoxManager);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Current Project");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 7;
			getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			jcomboBoxCurrentProject = new JComboBox();
			jcomboBoxCurrentProject.setEnabled(false);
			GridBagConstraints gbc_jcomboBoxCurrentProject = new GridBagConstraints();
			gbc_jcomboBoxCurrentProject.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxCurrentProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxCurrentProject.gridx = 2;
			gbc_jcomboBoxCurrentProject.gridy = 7;
			getContentPane().add(jcomboBoxCurrentProject, gbc_jcomboBoxCurrentProject);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Current Department");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 8;
			getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			jcomboBoxCurrentDepartment = new JComboBox();
			jcomboBoxCurrentDepartment.setEnabled(false);
			GridBagConstraints gbc_jcomboBoxCurrentDepartment = new GridBagConstraints();
			gbc_jcomboBoxCurrentDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxCurrentDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxCurrentDepartment.gridx = 2;
			gbc_jcomboBoxCurrentDepartment.gridy = 8;
			getContentPane().add(jcomboBoxCurrentDepartment, gbc_jcomboBoxCurrentDepartment);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Current Location");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 9;
			getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			jcomboBoxCurrentLocation = new JComboBox();
			jcomboBoxCurrentLocation.setEnabled(false);
			GridBagConstraints gbc_jcomboBoxCurrentLocation = new GridBagConstraints();
			gbc_jcomboBoxCurrentLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxCurrentLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxCurrentLocation.gridx = 2;
			gbc_jcomboBoxCurrentLocation.gridy = 9;
			getContentPane().add(jcomboBoxCurrentLocation, gbc_jcomboBoxCurrentLocation);
		}
		{
			lblNewLabel_9 = new JLabel("Joining Date");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 10;
			getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			jdateChooserJoining = new JDateChooser();
			GridBagConstraints gbc_jdateChooserJoining = new GridBagConstraints();
			gbc_jdateChooserJoining.insets = new Insets(0, 0, 5, 5);
			gbc_jdateChooserJoining.fill = GridBagConstraints.BOTH;
			gbc_jdateChooserJoining.gridx = 2;
			gbc_jdateChooserJoining.gridy = 10;
			getContentPane().add(jdateChooserJoining, gbc_jdateChooserJoining);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 2;
			gbc_panel.gridy = 11;
			getContentPane().add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				jbuttonUpdateEmployee = new JButton("Update");
				jbuttonUpdateEmployee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonUpdateEmployee_actionPerformed(e, updateEmployeeRespone);
					}
				});
				panel.add(jbuttonUpdateEmployee);
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

	public JDialogUpdateEmployeeRecord(UpdateEmployeeRespone updateEmployeeRespone,Map<String, Object> employeeData) {
		this(updateEmployeeRespone);
		this.employeeData = employeeData;
		employeeRender();
	}
	
	private void employeeRender() {
		employee = (Employee) employeeData.get("employee");
		EmployeeModel employeeModel = new EmployeeModel();
		RoleModel roleModel = new RoleModel();
		ProjectsModel projectsModel = new ProjectsModel();
		DepartmentModel departmentModel = new DepartmentModel();
		LocationModel locationModel = new LocationModel();
		
		String employeeName = employee.getName();
		String employeeEmail = employee.getEmail();
		String employeeUsername = employee.getUsername();
		
		
		DefaultComboBoxModel<Role> roleBoxModel = new DefaultComboBoxModel<>();
		for(Role role : roleModel.findAll()) {
			roleBoxModel.addElement(role);
		}
		jcomboBoxRole.setModel(roleBoxModel);
		jcomboBoxRole.setRenderer(new RoleCellRender());
		
		DefaultComboBoxModel<Employee> employeeBoxModel = new DefaultComboBoxModel<>();
		employeeBoxModel.addElement(new Employee(-2, "None"));
		for(Employee employee : employeeModel.findAll()) {
			if(employee.getName() != null && !employee.getName().isEmpty()) {
				employeeBoxModel.addElement(employee);
			}
		}
		jcomboBoxManager.setModel(employeeBoxModel);
		jcomboBoxManager.setRenderer(new EmployeeCellRender());
		
		
		DefaultComboBoxModel<Projects> projectsBoxModel = new DefaultComboBoxModel<>();
		for(Projects project : projectsModel.findAll()) {
			projectsBoxModel.addElement(project);
		}
		jcomboBoxCurrentProject.setModel(projectsBoxModel);
		jcomboBoxCurrentProject.setRenderer(new ProjectCellRender());
		
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		for(Department project : departmentModel.findAll()) {
			departmentBoxModel.addElement(project);
		}
		jcomboBoxCurrentDepartment.setModel(departmentBoxModel);
		jcomboBoxCurrentDepartment.setRenderer(new DepartmentCellRender());
		
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		for(Location location : locationModel.findAll()) {
			locationBoxModel.addElement(location);
		}
		jcomboBoxCurrentLocation.setModel(locationBoxModel);
		jcomboBoxCurrentLocation.setRenderer(new LocationCellRender());
		
		jtextFieldEmployeeName.setText(employeeName);
		jtextFieldEmail.setText(employeeEmail);
		jtextFieldUsername.setText(employeeUsername);
		
		jcomboBoxRole.getModel().setSelectedItem(roleModel.findById(employee.getRoleId()));
		jcomboBoxManager.getModel().setSelectedItem(employee.getManagerId() != null ? employeeModel.findById(employee.getManagerId()) : new Employee(-2, "None"));
		jcomboBoxCurrentProject.getModel().setSelectedItem(projectsModel.findById(employee.getCurrentProject()));
		jcomboBoxCurrentProject.setEnabled(false);
		jcomboBoxCurrentDepartment.getModel().setSelectedItem(departmentModel.findById(employee.getCurrentDepartment()));
		jcomboBoxCurrentDepartment.setEnabled(false);
		jcomboBoxCurrentLocation.getModel().setSelectedItem(locationModel.findById(employee.getCurrentLocation()));
		jcomboBoxCurrentLocation.setEnabled(false);
		jdateChooserJoining.setDate(employee.getJoiningDate());
		jdateChooserJoining.setEnabled(false);
	}
	
	private class RoleCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getId() +  " - "  +  role.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	private class EmployeeCellRender extends DefaultListCellRenderer {

	    @Override
	    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	        // Ensure that 'value' is cast to Employee safely
	        String text = "None"; // Default text for null or unexpected values
	        if (value instanceof Employee) {
	            Employee employee = (Employee) value;
	            text = employee.getName() != null ? employee.getName() : "None";
	        }
	        
	        // Set the text for the list cell renderer
	        Component component = super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
	        return component;
	    }
	}
	
	private class ProjectCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects projects = (Projects) value;
			return super.getListCellRendererComponent(list,projects.getId() + " - "  +  projects.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	private class DepartmentCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getId() + " - "  + department.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	private class LocationCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Location location = (Location) value;
			return super.getListCellRendererComponent(list, location.getId() +  " - "  + location.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	protected void do_jbuttonUpdateEmployee_actionPerformed(ActionEvent e, UpdateEmployeeRespone updateEmployeeRespone) {
		EmployeeModel employeeModel = new EmployeeModel();
		String employeeName = jtextFieldEmployeeName.getText().trim();
		String email = jtextFieldEmail.getText().trim();
		String username = jtextFieldUsername.getText().trim();
		
		Role role = (Role) jcomboBoxRole.getSelectedItem();
		Employee selectedManager = (Employee) jcomboBoxManager.getSelectedItem();
		Projects project = (Projects) jcomboBoxCurrentProject.getSelectedItem();
		Department department = (Department) jcomboBoxCurrentDepartment.getSelectedItem();
		Location location = (Location) jcomboBoxCurrentLocation.getSelectedItem();
		Date joiningDate = jdateChooserJoining.getDate();
		
		if(employeeName == null) {
			JOptionPane.showMessageDialog(null, "Employee name cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isText(employeeName)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee name", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(email == null) {
			JOptionPane.showMessageDialog(null, "Employee email cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isValidEmail(email)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee email", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(username == null) {
			JOptionPane.showMessageDialog(null, "Employee username cannot be empty", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!ValidateHelper.isUsername(username)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid employee username", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(joiningDate == null) {
			JOptionPane.showMessageDialog(null, "Please enter a joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!(joiningDate instanceof Date)) {
			JOptionPane.showMessageDialog(null, "Please enter a proper joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (selectedManager != null && selectedManager.getId() == -2) {
		    employee.setManagerId(null); // No manager selected
		} else {
		    employee.setManagerId(selectedManager != null ? selectedManager.getId() : null);
		}
		
		if(!employeeName.equals(employeeModel.findById(employee.getId()).getName()) && employeeModel.doesEmployeeNameExist(employeeName)) {
			JOptionPane.showMessageDialog(null, "Employee name already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!email.equals(employeeModel.findById(employee.getId()).getEmail()) && employeeModel.doesEmailExist(email)) {
			JOptionPane.showMessageDialog(null, "Employee email already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!username.equals(employeeModel.findById(employee.getId()).getUsername()) && employeeModel.doesUsernameExist(username)) {
			JOptionPane.showMessageDialog(null, "Employee username already exists", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		employee.setName(employeeName);
		employee.setEmail(email);
		employee.setUsername(username);
		employee.setRoleId(role.getId());
//		employee.setManagerId(manager.getManagerId());
		employee.setCurrentProject(project.getId());
		employee.setCurrentDepartment(department.getId());
		employee.setCurrentLocation(location.getId());
		employee.setJoiningDate(joiningDate);
		boolean isUpdateSuccessful = updateEmployeeRespone.getValue(employee);
		if(isUpdateSuccessful) {
			dispose();
		}
		
	}
	
	public interface UpdateEmployeeRespone{		
		public boolean getValue(Employee employee);
	}
	
	protected void do_jbuttonCancel_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	
}

