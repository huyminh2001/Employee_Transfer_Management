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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class JDialogViewBeginingRecordEmp extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private final ButtonGroup jbuttonGroupStatus = new ButtonGroup();
	private Map<String, Object> dataRecord;
	private Map<String, Object> data;
	private Records record;
	private JTextField jtextFieldRequestFor;
	private JTextField jtextFieldToProject;
	private JTextField jtextFieldToDepartment;
	private JTextField jtextFieldToLocation;
	private JTextField jtextFieldJoiningDate;
	
	/**
	 * @wbp.parser.constructor
	 */
	public JDialogViewBeginingRecordEmp() {
		setBounds(100, 100, 488, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 293, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("View Assign Employee Record");
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
			jtextFieldToProject = new JTextField();
			jtextFieldToProject.setEditable(false);
			GridBagConstraints gbc_jtextFieldToProject = new GridBagConstraints();
			gbc_jtextFieldToProject.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldToProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldToProject.gridx = 2;
			gbc_jtextFieldToProject.gridy = 4;
			getContentPane().add(jtextFieldToProject, gbc_jtextFieldToProject);
			jtextFieldToProject.setColumns(10);
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
			jtextFieldToDepartment = new JTextField();
			jtextFieldToDepartment.setEditable(false);
			GridBagConstraints gbc_jtextFieldToDepartment = new GridBagConstraints();
			gbc_jtextFieldToDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldToDepartment.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldToDepartment.gridx = 2;
			gbc_jtextFieldToDepartment.gridy = 5;
			getContentPane().add(jtextFieldToDepartment, gbc_jtextFieldToDepartment);
			jtextFieldToDepartment.setColumns(10);
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
			jtextFieldToLocation = new JTextField();
			jtextFieldToLocation.setEditable(false);
			GridBagConstraints gbc_jtextFieldToLocation = new GridBagConstraints();
			gbc_jtextFieldToLocation.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldToLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldToLocation.gridx = 2;
			gbc_jtextFieldToLocation.gridy = 6;
			getContentPane().add(jtextFieldToLocation, gbc_jtextFieldToLocation);
			jtextFieldToLocation.setColumns(10);
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
		}
		{
			JButton jbuttonCancel = new JButton("Cancel");
			jbuttonCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_jbuttonCancel_actionPerformed(e);
				}
			});
			GridBagConstraints gbc_jbuttonCancel = new GridBagConstraints();
			gbc_jbuttonCancel.insets = new Insets(0, 0, 0, 5);
			gbc_jbuttonCancel.gridx = 2;
			gbc_jbuttonCancel.gridy = 8;
			getContentPane().add(jbuttonCancel, gbc_jbuttonCancel);
		}
	}
	
	
	public JDialogViewBeginingRecordEmp( Map<String, Object> dataRecord, Map<String, Object> data) {
		this();
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
			
//		jtextFieldFromProject.setText(projectsModel.findById(record.getProjectFrom()).getName());
		jtextFieldEmployeeName.setText(employeeModel.findById(record.getEmployeeId()).getName());	
		jtextFieldRequestFor.setText(employeeModel.findById(record.getRequestFor()).getName());
		Projects projectTo = projectsModel.findById(record.getProjectTo());
		jtextFieldToProject.setText(projectTo.getName());
		
		Department departmentTo = departmentModel.findById(record.getDepartmentTo());
		jtextFieldToDepartment.setText(departmentTo.getName());
		
		Location locationTo = locationModel.findById(record.getLocationTo());
		jtextFieldToLocation.setText(locationTo.getName());
		
		SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
		jtextFieldJoiningDate.setText(sp.format(record.getTransferJoiningDate()));
		
	}
	

	protected void do_jbuttonCancel_actionPerformed(ActionEvent e) {
		dispose();
	}
}
