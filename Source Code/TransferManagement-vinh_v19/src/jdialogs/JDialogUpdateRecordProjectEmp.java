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

import entities.Employee;
import entities.Projects;
import entities.Records;
import models.EmployeeModel;
import models.ProjectsModel;
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

public class JDialogUpdateRecordProjectEmp extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldFromProject;
	private final ButtonGroup jbuttonGroupStatus = new ButtonGroup();
	private Map<String, Object> dataRecord;
	private Map<String, Object> data;
	private Records record;
	private JTextField jtextFieldRequestFor;
	private JTextField jtextFieldToProject;
	private JTextField jtextFieldLeavingDate;
	private JTextField jtextFieldJoiningDate;
	private JRadioButton jRadioButtonApprove;
	private JRadioButton jRadioButtonReject;
	private JRadioButton jRadioButtonPending;
	
	/**
	 * @wbp.parser.constructor
	 */
	public JDialogUpdateRecordProjectEmp(UpdateProjectEmpRepsone updateProjectEmpRepsone) {
		setBounds(100, 100, 488, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 293, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Update Project Record");
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
			JLabel lblNewLabel_3 = new JLabel("From Project");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			jtextFieldFromProject = new JTextField();
			jtextFieldFromProject.setEditable(false);
			GridBagConstraints gbc_jtextFieldFromProject = new GridBagConstraints();
			gbc_jtextFieldFromProject.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldFromProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldFromProject.gridx = 2;
			gbc_jtextFieldFromProject.gridy = 4;
			getContentPane().add(jtextFieldFromProject, gbc_jtextFieldFromProject);
			jtextFieldFromProject.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("To Project");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			jtextFieldToProject = new JTextField();
			jtextFieldToProject.setEditable(false);
			GridBagConstraints gbc_jtextFieldToProject = new GridBagConstraints();
			gbc_jtextFieldToProject.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldToProject.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldToProject.gridx = 2;
			gbc_jtextFieldToProject.gridy = 5;
			getContentPane().add(jtextFieldToProject, gbc_jtextFieldToProject);
			jtextFieldToProject.setColumns(10);
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
		}
	}
	
	
	public JDialogUpdateRecordProjectEmp(UpdateProjectEmpRepsone updateProjectEmpRepsone, Map<String, Object> dataRecord, Map<String, Object> data) {
		this(updateProjectEmpRepsone);
		this.dataRecord = dataRecord;
		this.data = data;
		recordRender();
	}

	private void recordRender() {
		record = (Records) dataRecord.get("record");
		ProjectsModel projectsModel = new ProjectsModel();
		EmployeeModel employeeModel = new EmployeeModel();
		RecordModel recordModel = new RecordModel();
			
		jtextFieldEmployeeName.setText(employeeModel.findById(record.getEmployeeId()).getName());	
		
		Employee requestFor = employeeModel.findById(record.getRequestFor());
		jtextFieldRequestFor.setText(requestFor.getName());

		
		jtextFieldFromProject.setText(projectsModel.findById(record.getProjectFrom()).getName());
		Projects projectTo = projectsModel.findById(record.getProjectTo());
		jtextFieldToProject.setText(projectTo.getName());
		
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
	
	public interface UpdateProjectEmpRepsone{
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
	
	private class ProjectToCellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects projects = (Projects) value;
			return super.getListCellRendererComponent(list, projects.getId() + " - " + projects.getName(), index, isSelected, cellHasFocus);
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
