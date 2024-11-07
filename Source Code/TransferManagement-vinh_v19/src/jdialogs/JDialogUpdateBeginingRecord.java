package jdialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.cj.protocol.ValueDecoder;
import com.toedter.calendar.JDateChooser;

import entities.Department;
import entities.Employee;
import entities.Location;
import entities.Projects;
import entities.Records;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RecordModel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class JDialogUpdateBeginingRecord extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JComboBox jcomboBoxToDepartment;
	private JDateChooser jdateChooserJoining;
	private final ButtonGroup jbuttonGroupStatus = new ButtonGroup();
	private Map<String, Object> dataRecord;
	private Map<String, Object> data;
	private Records record;
	private JTextField jtextFieldRequestFor;
	private JComboBox jcomboBoxToLocation;
	private JComboBox jcomboBoxToProject;
	
	/**
	 * @wbp.parser.constructor
	 */
	public JDialogUpdateBeginingRecord(UpdateBeginingRepsone updateBeginingRepsone) {
		setTitle("Update");
		setModal(true);
		setBounds(100, 100, 488, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 293, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Update Assign Employee Record");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Employee Name");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtextFieldEmployeeName = new JTextField();
			jtextFieldEmployeeName.setEditable(false);
			GridBagConstraints gbc_jtextFieldEmployeeName = new GridBagConstraints();
			gbc_jtextFieldEmployeeName.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldEmployeeName.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldEmployeeName.gridx = 2;
			gbc_jtextFieldEmployeeName.gridy = 2;
			getContentPane().add(jtextFieldEmployeeName, gbc_jtextFieldEmployeeName);
			jtextFieldEmployeeName.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Request For");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			jtextFieldRequestFor = new JTextField();
			jtextFieldRequestFor.setEditable(false);
			GridBagConstraints gbc_jtextFieldRequestFor = new GridBagConstraints();
			gbc_jtextFieldRequestFor.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldRequestFor.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldRequestFor.gridx = 2;
			gbc_jtextFieldRequestFor.gridy = 3;
			getContentPane().add(jtextFieldRequestFor, gbc_jtextFieldRequestFor);
			jtextFieldRequestFor.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("To Project");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jcomboBoxToProject = new JComboBox();
			GridBagConstraints gbc_jcomboBoxToProject = new GridBagConstraints();
			gbc_jcomboBoxToProject.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxToProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxToProject.gridx = 2;
			gbc_jcomboBoxToProject.gridy = 4;
			getContentPane().add(jcomboBoxToProject, gbc_jcomboBoxToProject);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("To Department");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jcomboBoxToDepartment = new JComboBox();
			GridBagConstraints gbc_jcomboBoxToDepartment = new GridBagConstraints();
			gbc_jcomboBoxToDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxToDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxToDepartment.gridx = 2;
			gbc_jcomboBoxToDepartment.gridy = 5;
			getContentPane().add(jcomboBoxToDepartment, gbc_jcomboBoxToDepartment);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("To Location");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 6;
			getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			jcomboBoxToLocation = new JComboBox();
			GridBagConstraints gbc_jcomboBoxToLocation = new GridBagConstraints();
			gbc_jcomboBoxToLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jcomboBoxToLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jcomboBoxToLocation.gridx = 2;
			gbc_jcomboBoxToLocation.gridy = 6;
			getContentPane().add(jcomboBoxToLocation, gbc_jcomboBoxToLocation);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Joining Date");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 7;
			getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			jdateChooserJoining = new JDateChooser();
			GridBagConstraints gbc_jdateChooserJoining = new GridBagConstraints();
			gbc_jdateChooserJoining.insets = new Insets(0, 0, 5, 5);
			gbc_jdateChooserJoining.fill = GridBagConstraints.BOTH;
			gbc_jdateChooserJoining.gridx = 2;
			gbc_jdateChooserJoining.gridy = 7;
			getContentPane().add(jdateChooserJoining, gbc_jdateChooserJoining);
		}
		{
			JButton jButtonUpdateRecord = new JButton("Update Record");
			jButtonUpdateRecord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jButtonUpdateRecord_actionPerformed(e, updateBeginingRepsone);
				}
			});
			GridBagConstraints gbc_jButtonUpdateRecord = new GridBagConstraints();
			gbc_jButtonUpdateRecord.insets = new Insets(0, 0, 0, 5);
			gbc_jButtonUpdateRecord.gridx = 2;
			gbc_jButtonUpdateRecord.gridy = 8;
			getContentPane().add(jButtonUpdateRecord, gbc_jButtonUpdateRecord);
		}
	}
	
	
	public JDialogUpdateBeginingRecord(UpdateBeginingRepsone updateBeginingRepsone, Map<String, Object> dataRecord, Map<String, Object> data) {
		this(updateBeginingRepsone);
		this.dataRecord = dataRecord;
		this.data = data;
		recordRender();
	}

	private void recordRender() {
		record = (Records) dataRecord.get("record");
		ProjectsModel projectsModel = new ProjectsModel();
		DepartmentModel departmentModel = new DepartmentModel();
		LocationModel locationModel = new LocationModel();
		EmployeeModel employeeModel = new EmployeeModel();
		
		
		DefaultComboBoxModel<Projects> projectBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeProject = employeeModel.getCurrentProject(record.getRequestFor());
		for(Projects project : projectsModel.exclusiveCurrentProject(currentEmployeeProject)) {
			projectBoxModel.addElement(project);
		}
		jcomboBoxToProject.setModel(projectBoxModel);
		jcomboBoxToProject.setRenderer(new ProjectToCellRender());
		
		
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeDepartment = employeeModel.getCurrentProject(record.getRequestFor());
		for(Department department : departmentModel.exclusiveCurrentDepartment(currentEmployeeDepartment)) {
			departmentBoxModel.addElement(department);
		}
		jcomboBoxToDepartment.setModel(departmentBoxModel);
		jcomboBoxToDepartment.setRenderer(new DepartmentToCellRender());
		
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeLocation = employeeModel.getCurrentLocation(record.getRequestFor());
		for(Location location : locationModel.exclusiveCurrentLocation(currentEmployeeLocation)) {
			locationBoxModel.addElement(location);
		}
		jcomboBoxToLocation.setModel(locationBoxModel);
		jcomboBoxToLocation.setRenderer(new LocationToCellRender());
		
		
		
//		Employee requestFor = employeeModel.findById(record.getRequestFor());
//		System.out.println("Request for employee: " + requestFor);
//		jcomboBoxRequestFor.getModel().setSelectedItem(requestFor);
		
		
//		jtextFieldFromProject.setText(projectsModel.findById(record.getProjectFrom()).getName());
		jtextFieldEmployeeName.setText(employeeModel.findById(record.getEmployeeId()).getName());	
		jtextFieldRequestFor.setText(employeeModel.findById(record.getRequestFor()).getName());
		Projects projectTo = projectsModel.findById(record.getProjectTo());
		jcomboBoxToProject.getModel().setSelectedItem(projectTo);
		
		Department departmentTo = departmentModel.findById(record.getDepartmentTo());
		jcomboBoxToDepartment.getModel().setSelectedItem(departmentTo);
		
		Location locationTo = locationModel.findById(record.getLocationTo());
		jcomboBoxToLocation.getModel().setSelectedItem(locationTo);
		jdateChooserJoining.setDate(record.getTransferJoiningDate());
		
		
	}
	
	
	protected void do_jButtonUpdateRecord_actionPerformed(ActionEvent e, UpdateBeginingRepsone updateBeginingRepsone) {
		EmployeeModel employeeModel = new EmployeeModel();
		ProjectsModel projectsModel = new ProjectsModel();
		
		String employeeName = jtextFieldEmployeeName.getText();
		int employeeId = employeeModel.getEmployeeId(employeeName);
		String requestFor = jtextFieldRequestFor.getText();
		int requestForId = employeeModel.findByName(requestFor).getId();
	
		Projects projectsTo = (Projects) jcomboBoxToProject.getSelectedItem();
		Department departmentTo = (Department) jcomboBoxToDepartment.getSelectedItem();
		Location locationTo = (Location) jcomboBoxToLocation.getSelectedItem();

		Date joiningDate = jdateChooserJoining.getDate();
		
		int status = Integer.parseInt(jbuttonGroupStatus.getSelection().getActionCommand());
		
		
		if(joiningDate == null) {
			JOptionPane.showMessageDialog(null, "Please enter a joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!(joiningDate instanceof Date)) {
			JOptionPane.showMessageDialog(null, "Please enter a proper joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		record.setEmployeeId(employeeId);
		record.setRequestFor(requestForId);
		record.setProjectTo(projectsTo.getId());
		record.setDepartmentTo(departmentTo.getId());
		record.setLocationTo(locationTo.getId());
		record.setTransferJoiningDate(joiningDate);
		record.setStatus(status);
		updateBeginingRepsone.getValue(record);
		dispose();
		
	}
	
	public interface UpdateBeginingRepsone{
		public void getValue(Records record);
	}
	
//	private class RequestForCellRender extends DefaultListCellRenderer{
//
//		@Override
//		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
//				boolean cellHasFocus) {
//			Employee employee = (Employee) value;
//			return super.getListCellRendererComponent(list, employee.getId() + " - " + employee.getName(), index, isSelected, cellHasFocus);
//		}
//		
//	}
	
	private class ProjectToCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects projects = (Projects) value;
			return super.getListCellRendererComponent(list, projects.getId() + " - " + projects.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	private class DepartmentToCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getId() + " - " + department.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	private class LocationToCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Location location = (Location) value;
			return super.getListCellRendererComponent(list, location.getId() + " - " + location.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
//	private class DynamicRequestForCellRender extends DefaultListCellRenderer{
//		@Override
//		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
//				boolean cellHasFocus) {
//			Projects projects = (Projects) value;
//			return super.getListCellRendererComponent(list, projects.getId() + " - " + projects.getName(), index, isSelected, cellHasFocus);
//		}
//	}
	
}
