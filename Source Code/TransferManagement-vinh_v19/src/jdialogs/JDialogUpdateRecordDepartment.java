package jdialogs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.Department;
import entities.Employee;
import entities.Projects;
import entities.Records;
import models.DepartmentModel;
import models.EmployeeModel;
import models.ProjectsModel;
import models.RecordModel;

import javax.swing.JRadioButton;
import javax.mail.internet.NewsAddress;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class JDialogUpdateRecordDepartment extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldFromDepartment;
	private JComboBox jcomboBoxToDepartment;
	private JDateChooser jdateChooserLeaving;
	private JDateChooser jdateChooserJoining;
	private final ButtonGroup jbuttonGroupStatus = new ButtonGroup();
	private Map<String, Object> dataRecord;
	private Map<String, Object> data;
	private Records record;
	private JRadioButton jRadioButtonApprove;
	private JRadioButton jRadioButtonReject;
	private JTextField jtextFieldRequestFor;
	
	public JDialogUpdateRecordDepartment(UpdateDepartmentRepsone updateDepartmentRepsone) {
		setBounds(100, 100, 488, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 293, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Update Department Record");
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
			JLabel lblNewLabel_3 = new JLabel("From Department");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldFromDepartment = new JTextField();
			jtextFieldFromDepartment.setEditable(false);
			GridBagConstraints gbc_jtextFieldFromDepartment = new GridBagConstraints();
			gbc_jtextFieldFromDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldFromDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldFromDepartment.gridx = 2;
			gbc_jtextFieldFromDepartment.gridy = 4;
			getContentPane().add(jtextFieldFromDepartment, gbc_jtextFieldFromDepartment);
			jtextFieldFromDepartment.setColumns(10);
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
			JLabel lblNewLabel_5 = new JLabel("Leaving Date");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			jdateChooserLeaving = new JDateChooser();
			GridBagConstraints gbc_jdateChooserLeaving = new GridBagConstraints();
			gbc_jdateChooserLeaving.insets = new Insets(0, 0, 5, 5);
			gbc_jdateChooserLeaving.fill = GridBagConstraints.BOTH;
			gbc_jdateChooserLeaving.gridx = 2;
			gbc_jdateChooserLeaving.gridy = 6;
			getContentPane().add(jdateChooserLeaving, gbc_jdateChooserLeaving);
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
			JLabel lblNewLabel_7 = new JLabel("Status");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 8;
			getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			JPanel jpanelStatus = new JPanel();
			GridBagConstraints gbc_jpanelStatus = new GridBagConstraints();
			gbc_jpanelStatus.insets = new Insets(0, 0, 5, 5);
			gbc_jpanelStatus.fill = GridBagConstraints.BOTH;
			gbc_jpanelStatus.gridx = 2;
			gbc_jpanelStatus.gridy = 8;
			getContentPane().add(jpanelStatus, gbc_jpanelStatus);
			jpanelStatus.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				jRadioButtonApprove = new JRadioButton("Approve");
				jRadioButtonApprove.setActionCommand("1");
				jbuttonGroupStatus.add(jRadioButtonApprove);
				jpanelStatus.add(jRadioButtonApprove);
			}
			{
				jRadioButtonReject = new JRadioButton("Reject");
				jRadioButtonReject.setActionCommand("2");
				jbuttonGroupStatus.add(jRadioButtonReject);
				jpanelStatus.add(jRadioButtonReject);
			}
		}
		{
			JButton jButtonUpdateRecord = new JButton("Update Record");
			jButtonUpdateRecord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jButtonUpdateRecord_actionPerformed(e, updateDepartmentRepsone);
				}
			});
			GridBagConstraints gbc_jButtonUpdateRecord = new GridBagConstraints();
			gbc_jButtonUpdateRecord.insets = new Insets(0, 0, 0, 5);
			gbc_jButtonUpdateRecord.gridx = 2;
			gbc_jButtonUpdateRecord.gridy = 9;
			getContentPane().add(jButtonUpdateRecord, gbc_jButtonUpdateRecord);
		}
	}
	/**
	 * @wbp.parser.constructor
	 */
	public JDialogUpdateRecordDepartment(UpdateDepartmentRepsone updateDepartmentRepsone,Map<String, Object> dataRecord, Map<String, Object> data) {
		this(updateDepartmentRepsone);
		setTitle("Update Record");
		setModal(true);
		this.dataRecord = dataRecord;
		this.data = data;
		recordRender();
	}

	private void recordRender() {
		record = (Records) dataRecord.get("record");
		DepartmentModel departmentModel = new DepartmentModel();
		EmployeeModel employeeModel = new EmployeeModel();
		
//		int managerId = record.getEmployeeId();
//		int employeeId = record.getEmployeeId();
//
//		
//		DefaultComboBoxModel<Employee> requestForBoxModel = new DefaultComboBoxModel<>();
//		for(Employee employee : employeeModel.getManagedEmployees(managerId, employeeId)) {
//			requestForBoxModel.addElement(employee);
//		}
		
		
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeDepartment = employeeModel.getCurrentProject(record.getRequestFor());
		for(Department department : departmentModel.exclusiveCurrentDepartment(currentEmployeeDepartment)) {
			departmentBoxModel.addElement(department);
		}
		jcomboBoxToDepartment.setModel(departmentBoxModel);
		jcomboBoxToDepartment.setRenderer(new DepartmentToCellRender());
		
		
		jtextFieldEmployeeName.setText(employeeModel.findById(record.getEmployeeId()).getName());
		Employee requestFor = employeeModel.findById(record.getRequestFor());
		jtextFieldRequestFor.setText(requestFor.getName());
		
		jtextFieldFromDepartment.setText(departmentModel.findById(record.getDepartmentFrom()).getName());
		jcomboBoxToDepartment.getModel().setSelectedItem(departmentModel.findById(record.getDepartmentTo()));
		
		jdateChooserLeaving.setDate(record.getTransferRelievingDate());
		jdateChooserJoining.setDate(record.getTransferJoiningDate());
		
//		int status = Integer.parseInt(jbuttonGroupStatus.getSelection().getActionCommand());
		
//		setSelectedRadioButton(record.getStatus());
	}
	
	private void setSelectedRadioButton(int value) {
        switch (value) {
            case 1:
                jRadioButtonApprove.setSelected(true);
                break;
            case 2:
                jRadioButtonReject.setSelected(true);
                break;
            default:
                System.out.println("No matching option.");
                break;
        }
    }
	protected void do_jButtonUpdateRecord_actionPerformed(ActionEvent e, UpdateDepartmentRepsone updateDepartmentRepsone) {
		RecordModel recordModel = new RecordModel();
		EmployeeModel employeeModel = new EmployeeModel();
		DepartmentModel departmentModel = new DepartmentModel();
		
		String employeeName = jtextFieldEmployeeName.getText();
		int employeeId = employeeModel.getEmployeeId(employeeName);
		String requestFor = jtextFieldRequestFor.getText();
		int requestForId = employeeModel.getEmployeeId(requestFor);
		
		String departmentFrom = jtextFieldFromDepartment.getText();
		int departmentId = departmentModel.getDepartmentId(departmentFrom);
		Department departmentTo = (Department) jcomboBoxToDepartment.getSelectedItem();
		
		Date leavingDate = jdateChooserLeaving.getDate();
		Date joiningDate = jdateChooserJoining.getDate();
		
		int status = Integer.parseInt(jbuttonGroupStatus.getSelection().getActionCommand());
		
		if(leavingDate == null) {
			JOptionPane.showMessageDialog(null, "Please enter a leaving date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!(leavingDate instanceof Date)) {
			JOptionPane.showMessageDialog(null, "Please enter a proper leaving date", "Warning", JOptionPane.ERROR_MESSAGE);
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
		
		
		record.setEmployeeId(employeeId);
		record.setRequestFor(requestForId);
		record.setDepartmentFrom(departmentId);
		record.setDepartmentTo(departmentTo.getId());
		record.setTransferRelievingDate(leavingDate);
		record.setTransferJoiningDate(joiningDate);
		record.setStatus(status);
		boolean isUpdateSuccessful = updateDepartmentRepsone.getValue(record);
		if(isUpdateSuccessful) {
			dispose();
		}
		
	}
	
	public interface UpdateDepartmentRepsone{
		public boolean getValue(Records record);
	}
	
	private class RequestForCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Employee employee = (Employee) value;
			return super.getListCellRendererComponent(list, employee.getId() + " - " + employee.getName(), index, isSelected, cellHasFocus);
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
	
	private class DynamicRequestForCellRender extends DefaultListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getId() + " - " + department.getName(), index, isSelected, cellHasFocus);
		}
	}
	
}
