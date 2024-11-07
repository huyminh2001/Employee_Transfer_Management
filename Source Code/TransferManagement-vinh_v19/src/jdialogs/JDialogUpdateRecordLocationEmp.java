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

import entities.Employee;
import entities.Location;
import entities.Records;
import models.EmployeeModel;
import models.LocationModel;
import models.RecordModel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class JDialogUpdateRecordLocationEmp extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldFromLocation;
	private final ButtonGroup jbuttonGroupStatus = new ButtonGroup();
	private Map<String, Object> dataRecord;
	private Map<String, Object> data;
	private Records record;
	private JTextField jtextFieldRequestFor;
	private JTextField jtextFieldToLocation;
	private JTextField jtextFieldLeavingDate;
	private JTextField jtextFieldJoiningDate;
	private JRadioButton jRadioButtonPending;
	private JRadioButton jRadioButtonApprove;
	private JRadioButton jRadioButtonReject;
	
	public JDialogUpdateRecordLocationEmp(UpdateLocationEmpRepsone updateLocationEmpRepsone) {
		setBounds(100, 100, 488, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 293, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Update Location Record");
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
			JLabel lblNewLabel_3 = new JLabel("From Location");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldFromLocation = new JTextField();
			jtextFieldFromLocation.setEditable(false);
			GridBagConstraints gbc_jtextFieldFromLocation = new GridBagConstraints();
			gbc_jtextFieldFromLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldFromLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldFromLocation.gridx = 2;
			gbc_jtextFieldFromLocation.gridy = 4;
			getContentPane().add(jtextFieldFromLocation, gbc_jtextFieldFromLocation);
			jtextFieldFromLocation.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("To Location");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jtextFieldToLocation = new JTextField();
			jtextFieldToLocation.setEditable(false);
			GridBagConstraints gbc_jtextFieldToLocation = new GridBagConstraints();
			gbc_jtextFieldToLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldToLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldToLocation.gridx = 2;
			gbc_jtextFieldToLocation.gridy = 5;
			getContentPane().add(jtextFieldToLocation, gbc_jtextFieldToLocation);
			jtextFieldToLocation.setColumns(10);
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
			jtextFieldLeavingDate = new JTextField();
			jtextFieldLeavingDate.setEditable(false);
			GridBagConstraints gbc_jtextFieldLeavingDate = new GridBagConstraints();
			gbc_jtextFieldLeavingDate.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldLeavingDate.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldLeavingDate.gridx = 2;
			gbc_jtextFieldLeavingDate.gridy = 6;
			getContentPane().add(jtextFieldLeavingDate, gbc_jtextFieldLeavingDate);
			jtextFieldLeavingDate.setColumns(10);
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
			JButton jButtonUpdateRecord = new JButton("Update Record");
			jButtonUpdateRecord.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jButtonUpdateRecord_actionPerformed(e, updateLocationEmpRepsone);
				}
			});
			{
				jtextFieldJoiningDate = new JTextField();
				jtextFieldJoiningDate.setEditable(false);
				GridBagConstraints gbc_jtextFieldJoiningDate = new GridBagConstraints();
				gbc_jtextFieldJoiningDate.insets = new Insets(0, 0, 5, 5);
				gbc_jtextFieldJoiningDate.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtextFieldJoiningDate.gridx = 2;
				gbc_jtextFieldJoiningDate.gridy = 7;
				getContentPane().add(jtextFieldJoiningDate, gbc_jtextFieldJoiningDate);
				jtextFieldJoiningDate.setColumns(10);
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
					jRadioButtonPending = new JRadioButton("Pending");
					jRadioButtonPending.setActionCommand("0");
					jpanelStatus.add(jRadioButtonPending);
				}
				{
					jRadioButtonApprove = new JRadioButton("Approve");
					jRadioButtonApprove.setActionCommand("1");
					jpanelStatus.add(jRadioButtonApprove);
				}
				{
					jRadioButtonReject = new JRadioButton("Reject");
					jRadioButtonReject.setActionCommand("2");
					jpanelStatus.add(jRadioButtonReject);
				}
			}
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
	public JDialogUpdateRecordLocationEmp(UpdateLocationEmpRepsone updateLocationEmpRepsone, Map<String, Object> dataRecord, Map<String, Object> data) {
		this(updateLocationEmpRepsone);
		this.dataRecord = dataRecord;
		this.data = data;
		recordRender();
	}

	private void recordRender() {
		record = (Records) dataRecord.get("record");
		LocationModel locationModel = new LocationModel();
		EmployeeModel employeeModel = new EmployeeModel();
		
//		int managerId = record.getEmployeeId();
//		int employeeId = record.getEmployeeId();
//
//		
//		DefaultComboBoxModel<Employee> requestForBoxModel = new DefaultComboBoxModel<>();
//		for(Employee employee : employeeModel.getManagedEmployees(managerId, employeeId)) {
//			requestForBoxModel.addElement(employee);
//		}
		
		
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeLocation = employeeModel.getCurrentLocation(record.getRequestFor());
		for(Location location : locationModel.exclusiveCurrentLocation(currentEmployeeLocation)) {
			locationBoxModel.addElement(location);
		}
		
		
		jtextFieldEmployeeName.setText(employeeModel.findById(record.getEmployeeId()).getName());
		Employee requestFor = employeeModel.findById(record.getRequestFor());
		jtextFieldRequestFor.setText(requestFor.getName());
		
		jtextFieldFromLocation.setText(locationModel.findById(record.getLocationFrom()).getName());
		jtextFieldToLocation.setText(locationModel.findById(record.getLocationTo()).getName());
		
		SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
		jtextFieldLeavingDate.setText(sp.format(record.getTransferRelievingDate()));
		jtextFieldJoiningDate.setText(sp.format(record.getTransferJoiningDate()));
		setSelectedRadioButton(record.getStatus());
	}
	
	private void setSelectedRadioButton(int value) {
        switch (value) {
            case 0:
                jRadioButtonPending.setSelected(true);
                break;
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
	
	
	protected void do_jButtonUpdateRecord_actionPerformed(ActionEvent e, UpdateLocationEmpRepsone updateLocationEmpRepsone) {
		EmployeeModel employeeModel = new EmployeeModel();
		LocationModel locationModel = new LocationModel();
		
		String employeeName = jtextFieldEmployeeName.getText();
		int employeeId = employeeModel.getEmployeeId(employeeName);
		
		String requestFor = jtextFieldRequestFor.getText();
		int requestForId = employeeModel.getEmployeeId(requestFor);
		
		String locationFrom = jtextFieldFromLocation.getText();
		int locationFromId = locationModel.getLocationId(locationFrom);
		
		String locationTo = jtextFieldToLocation.getText();
		int locationToId = locationModel.getLocationId(locationTo);
		
		
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		String leavingDate = jtextFieldLeavingDate.getText();
		String joiningDate = jtextFieldJoiningDate.getText();
		
		int status = Integer.parseInt(jbuttonGroupStatus.getSelection().getActionCommand());
		
		record.setEmployeeId(employeeId);
		record.setRequestFor(requestForId);
		record.setLocationFrom(locationFromId);
		record.setLocationTo(locationToId);
		try {
			record.setTransferRelievingDate(sp.parse(leavingDate));
			record.setTransferJoiningDate(sp.parse(joiningDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		record.setStatus(status);
		updateLocationEmpRepsone.getValue(record);
		dispose();
		
	}
	
	public interface UpdateLocationEmpRepsone{
		public void getValue(Records record);
	}
	
	private class RequestForCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Employee employee = (Employee) value;
			return super.getListCellRendererComponent(list, employee.getId() + " - " + employee.getName(), index, isSelected, cellHasFocus);
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
//			Location location = (Location) value;
//			return super.getListCellRendererComponent(list, location.getId() + " - " + location.getName(), index, isSelected, cellHasFocus);
//		}
//	}
}
