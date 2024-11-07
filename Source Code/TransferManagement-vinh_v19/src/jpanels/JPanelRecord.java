package jpanels;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//import entities.Book;
//import entities.Book;
import entities.Department;
import entities.Employee;
import entities.Location;
import entities.Projects;
import entities.Records;
import helpers.CsvUtils;
import helpers.MailHelpers;
import jdialogs.JDialogUpdateBeginingRecord;
import jdialogs.JDialogUpdateBeginingRecord.UpdateBeginingRepsone;
import jdialogs.JDialogUpdateRecordDepartment;
import jdialogs.JDialogUpdateRecordLocation;
import jdialogs.JDialogUpdateRecordLocation.UpdateLocationRepsone;
import jdialogs.JDialogUpdateRecordProject;
import jdialogs.JDialogUpdateRecordDepartment.UpdateDepartmentRepsone;
import jdialogs.JDialogUpdateRecordProject.UpdateProjectRepsone;
import jdialogs.JDialogViewBeginingRecordEmp;
import jdialogs.ViewRecordInfo.JDialogViewRecordDepartment;
import jdialogs.ViewRecordInfo.JDialogViewRecordLocation;
import jdialogs.ViewRecordInfo.JDialogViewRecordProject;
//import models.BookModel;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RecordModel;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JPanelRecord extends JPanel {

	private final int itemsPerPage = 25;

	private int maxPageIndex;

	private int currentPageIndex = 1;

	DefaultTableModel recordTableModel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(recordTableModel);

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JComboBox jcomboBoxFromProject;
	private JComboBox jcomboBoxToProject;
	private JComboBox jcomboBoxFromDepartment;
	private JComboBox jcomboBoxToDepartment;
	private JComboBox jcomboBoxFromLocation;
	private JComboBox jcomboBoxToLocation;
	private JTextField jtextFieldRequestFor;
	private JTable jtableTransferRecord;
	private Map<String, Object> data;
	private JMenuItem jMenuItemEditRecord;
	private JPopupMenu jpopupMenuRecord;
	private JPanel jpanelStatusCheckBox;
	private JDateChooser jdateChooserLeavingFrom;
	private JDateChooser jdateChooserLeavingTo;
	private JDateChooser jdateChooserJoiningFrom;
	private JDateChooser jdateChooserJoiningTo;
	private JDateChooser jdateChooserCreatedFrom;
	private JDateChooser jdateChooserCreatedTo;
	private JCheckBox jcheckBoxPending;
	private JCheckBox jcheckBoxApproved;
	private JCheckBox jcheckBoxRejected;
	private JButton jbuttonFirstPage;
	private JButton jbuttonPreviousPage;
	private JTextField jtextFieldCurrentPage;
	private JButton jbuttonNextPage;
	private JButton jbuttonLastPage;
	private JLabel jlabelTotalPage;

	/**
	 * Create the panel.
	 */
	public JPanelRecord() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 78, 0, 329, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_16 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 1;
		add(lblNewLabel_16, gbc_lblNewLabel_16);

		JPanel jpanelFilterRecord = new JPanel();
		jpanelFilterRecord
				.setBorder(new TitledBorder(null, "Record Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpanelFilterRecord = new GridBagConstraints();
		gbc_jpanelFilterRecord.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelFilterRecord.fill = GridBagConstraints.BOTH;
		gbc_jpanelFilterRecord.gridx = 2;
		gbc_jpanelFilterRecord.gridy = 1;
		add(jpanelFilterRecord, gbc_jpanelFilterRecord);
		GridBagLayout gbl_jpanelFilterRecord = new GridBagLayout();
		gbl_jpanelFilterRecord.columnWidths = new int[] { 208, 193, 200, 0, 0, 0 };
		gbl_jpanelFilterRecord.rowHeights = new int[] { 0, 36, 0, 0, 0 };
		gbl_jpanelFilterRecord.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_jpanelFilterRecord.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		jpanelFilterRecord.setLayout(gbl_jpanelFilterRecord);

		JPanel jpanelEmployee = new JPanel();
		GridBagConstraints gbc_jpanelEmployee = new GridBagConstraints();
		gbc_jpanelEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelEmployee.fill = GridBagConstraints.BOTH;
		gbc_jpanelEmployee.gridx = 0;
		gbc_jpanelEmployee.gridy = 0;
		jpanelFilterRecord.add(jpanelEmployee, gbc_jpanelEmployee);
		GridBagLayout gbl_jpanelEmployee = new GridBagLayout();
		gbl_jpanelEmployee.columnWidths = new int[] { 37, 45, 86, 0 };
		gbl_jpanelEmployee.rowHeights = new int[] { 19, 0, 0 };
		gbl_jpanelEmployee.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_jpanelEmployee.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpanelEmployee.setLayout(gbl_jpanelEmployee);

		JLabel lblNewLabel = new JLabel("Requestor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		jpanelEmployee.add(lblNewLabel, gbc_lblNewLabel);

		jtextFieldEmployeeName = new JTextField();
		jtextFieldEmployeeName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				do_jtextFieldEmployeeName_keyPressed(e);
			}
		});
//		jtextFieldEmployeeName.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				do_jtextFieldEmployeeName_actionPerformed(e);
//			}
//		});
		GridBagConstraints gbc_jtextFieldEmployeeName = new GridBagConstraints();
		gbc_jtextFieldEmployeeName.gridwidth = 2;
		gbc_jtextFieldEmployeeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_jtextFieldEmployeeName.anchor = GridBagConstraints.NORTH;
		gbc_jtextFieldEmployeeName.gridx = 1;
		gbc_jtextFieldEmployeeName.gridy = 0;
		jpanelEmployee.add(jtextFieldEmployeeName, gbc_jtextFieldEmployeeName);
		jtextFieldEmployeeName.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Request For");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 1;
		jpanelEmployee.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtextFieldRequestFor = new JTextField();
		jtextFieldRequestFor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldRequestFor_keyReleased(e);
			}
		});
//		jtextFieldRequestFor.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				do_jtextFieldRequestFor_keyPressed(e);
//			}
//		});
//		jtextFieldRequestFor.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				do_jtextFieldRequestFor_actionPerformed(e);
//			}
//		});
		GridBagConstraints gbc_jtextFieldRequestFor = new GridBagConstraints();
		gbc_jtextFieldRequestFor.gridwidth = 2;
		gbc_jtextFieldRequestFor.insets = new Insets(0, 0, 0, 5);
		gbc_jtextFieldRequestFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldRequestFor.gridx = 1;
		gbc_jtextFieldRequestFor.gridy = 1;
		jpanelEmployee.add(jtextFieldRequestFor, gbc_jtextFieldRequestFor);
		jtextFieldRequestFor.setColumns(10);

		JPanel jpanelProject = new JPanel();
		GridBagConstraints gbc_jpanelProject = new GridBagConstraints();
		gbc_jpanelProject.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelProject.fill = GridBagConstraints.BOTH;
		gbc_jpanelProject.gridx = 1;
		gbc_jpanelProject.gridy = 0;
		jpanelFilterRecord.add(jpanelProject, gbc_jpanelProject);
		GridBagLayout gbl_jpanelProject = new GridBagLayout();
		gbl_jpanelProject.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelProject.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelProject.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelProject.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpanelProject.setLayout(gbl_jpanelProject);

		JLabel lblNewLabel_1 = new JLabel("From Project");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		jpanelProject.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcomboBoxFromProject = new JComboBox();
		jcomboBoxFromProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxFromProject_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxFromProject = new GridBagConstraints();
		gbc_jcomboBoxFromProject.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxFromProject.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxFromProject.gridx = 1;
		gbc_jcomboBoxFromProject.gridy = 0;
		jpanelProject.add(jcomboBoxFromProject, gbc_jcomboBoxFromProject);

		JLabel lblNewLabel_2 = new JLabel("To Project");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		jpanelProject.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcomboBoxToProject = new JComboBox();
		jcomboBoxToProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxToProject_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxToProject = new GridBagConstraints();
		gbc_jcomboBoxToProject.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxToProject.gridx = 1;
		gbc_jcomboBoxToProject.gridy = 1;
		jpanelProject.add(jcomboBoxToProject, gbc_jcomboBoxToProject);

		JPanel jpanelDepartment = new JPanel();
		GridBagConstraints gbc_jpanelDepartment = new GridBagConstraints();
		gbc_jpanelDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelDepartment.fill = GridBagConstraints.BOTH;
		gbc_jpanelDepartment.gridx = 2;
		gbc_jpanelDepartment.gridy = 0;
		jpanelFilterRecord.add(jpanelDepartment, gbc_jpanelDepartment);
		GridBagLayout gbl_jpanelDepartment = new GridBagLayout();
		gbl_jpanelDepartment.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelDepartment.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelDepartment.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelDepartment.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpanelDepartment.setLayout(gbl_jpanelDepartment);

		JLabel lblNewLabel_4 = new JLabel("From Department");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		jpanelDepartment.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcomboBoxFromDepartment = new JComboBox();
		jcomboBoxFromDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxFromDepartment_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxFromDepartment = new GridBagConstraints();
		gbc_jcomboBoxFromDepartment.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxFromDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxFromDepartment.gridx = 1;
		gbc_jcomboBoxFromDepartment.gridy = 0;
		jpanelDepartment.add(jcomboBoxFromDepartment, gbc_jcomboBoxFromDepartment);

		JLabel lblNewLabel_3 = new JLabel("To Department");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		jpanelDepartment.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcomboBoxToDepartment = new JComboBox();
		jcomboBoxToDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxToDepartment_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxToDepartment = new GridBagConstraints();
		gbc_jcomboBoxToDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxToDepartment.gridx = 1;
		gbc_jcomboBoxToDepartment.gridy = 1;
		jpanelDepartment.add(jcomboBoxToDepartment, gbc_jcomboBoxToDepartment);

		JPanel jpanelLocation = new JPanel();
		GridBagConstraints gbc_jpanelLocation = new GridBagConstraints();
		gbc_jpanelLocation.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelLocation.fill = GridBagConstraints.BOTH;
		gbc_jpanelLocation.gridx = 3;
		gbc_jpanelLocation.gridy = 0;
		jpanelFilterRecord.add(jpanelLocation, gbc_jpanelLocation);
		GridBagLayout gbl_jpanelLocation = new GridBagLayout();
		gbl_jpanelLocation.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelLocation.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelLocation.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelLocation.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		jpanelLocation.setLayout(gbl_jpanelLocation);

		JLabel lblNewLabel_5 = new JLabel("From Location");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		jpanelLocation.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jcomboBoxFromLocation = new JComboBox();
		jcomboBoxFromLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxFromLocation_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxFromLocation = new GridBagConstraints();
		gbc_jcomboBoxFromLocation.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxFromLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxFromLocation.gridx = 1;
		gbc_jcomboBoxFromLocation.gridy = 0;
		jpanelLocation.add(jcomboBoxFromLocation, gbc_jcomboBoxFromLocation);

		JLabel lblNewLabel_6 = new JLabel("To Location");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 1;
		jpanelLocation.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jcomboBoxToLocation = new JComboBox();
		jcomboBoxToLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxToLocation_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxToLocation = new GridBagConstraints();
		gbc_jcomboBoxToLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxToLocation.gridx = 1;
		gbc_jcomboBoxToLocation.gridy = 1;
		jpanelLocation.add(jcomboBoxToLocation, gbc_jcomboBoxToLocation);

		JLabel lblNewLabel_8 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 4;
		gbc_lblNewLabel_8.gridy = 0;
		jpanelFilterRecord.add(lblNewLabel_8, gbc_lblNewLabel_8);

		JPanel jpanelStatus = new JPanel();
		GridBagConstraints gbc_jpanelStatus = new GridBagConstraints();
		gbc_jpanelStatus.anchor = GridBagConstraints.WEST;
		gbc_jpanelStatus.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelStatus.fill = GridBagConstraints.VERTICAL;
		gbc_jpanelStatus.gridx = 0;
		gbc_jpanelStatus.gridy = 1;
		jpanelFilterRecord.add(jpanelStatus, gbc_jpanelStatus);
		jpanelStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_15 = new JLabel("Status");
		jpanelStatus.add(lblNewLabel_15);

		jpanelStatusCheckBox = new JPanel();
		jpanelStatus.add(jpanelStatusCheckBox);

		jcheckBoxPending = new JCheckBox("Pending");
		jcheckBoxPending.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_jcheckBoxPending_itemStateChanged(e);
			}
		});
		jcheckBoxPending.setActionCommand("0");
		jpanelStatusCheckBox.add(jcheckBoxPending);

		jcheckBoxApproved = new JCheckBox("Approved");
		jcheckBoxApproved.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_jcheckBoxApproved_itemStateChanged(e);
			}
		});
		jcheckBoxApproved.setActionCommand("1");
		jpanelStatusCheckBox.add(jcheckBoxApproved);

		jcheckBoxRejected = new JCheckBox("Rejected");
		jcheckBoxRejected.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_jcheckBoxRejected_itemStateChanged(e);
			}
		});
		jcheckBoxRejected.setActionCommand("2");
		jpanelStatusCheckBox.add(jcheckBoxRejected);

		JPanel jpanelLeavingDate = new JPanel();
		GridBagConstraints gbc_jpanelLeavingDate = new GridBagConstraints();
		gbc_jpanelLeavingDate.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelLeavingDate.fill = GridBagConstraints.BOTH;
		gbc_jpanelLeavingDate.gridx = 1;
		gbc_jpanelLeavingDate.gridy = 1;
		jpanelFilterRecord.add(jpanelLeavingDate, gbc_jpanelLeavingDate);
		GridBagLayout gbl_jpanelLeavingDate = new GridBagLayout();
		gbl_jpanelLeavingDate.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelLeavingDate.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelLeavingDate.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelLeavingDate.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		jpanelLeavingDate.setLayout(gbl_jpanelLeavingDate);

		JLabel lblNewLabel_9 = new JLabel("Leaving From");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		jpanelLeavingDate.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jdateChooserLeavingFrom = new JDateChooser();
		jdateChooserLeavingFrom.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserLeavingFrom_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserLeavingFrom = new GridBagConstraints();
		gbc_jdateChooserLeavingFrom.insets = new Insets(0, 0, 5, 0);
		gbc_jdateChooserLeavingFrom.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserLeavingFrom.gridx = 1;
		gbc_jdateChooserLeavingFrom.gridy = 0;
		jpanelLeavingDate.add(jdateChooserLeavingFrom, gbc_jdateChooserLeavingFrom);

		JLabel lblNewLabel_10 = new JLabel("Leaving To");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 1;
		jpanelLeavingDate.add(lblNewLabel_10, gbc_lblNewLabel_10);

		jdateChooserLeavingTo = new JDateChooser();
		jdateChooserLeavingTo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserLeavingTo_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserLeavingTo = new GridBagConstraints();
		gbc_jdateChooserLeavingTo.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserLeavingTo.gridx = 1;
		gbc_jdateChooserLeavingTo.gridy = 1;
		jpanelLeavingDate.add(jdateChooserLeavingTo, gbc_jdateChooserLeavingTo);

		JPanel jpanelJoiningDate = new JPanel();
		GridBagConstraints gbc_jpanelJoiningDate = new GridBagConstraints();
		gbc_jpanelJoiningDate.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelJoiningDate.fill = GridBagConstraints.BOTH;
		gbc_jpanelJoiningDate.gridx = 2;
		gbc_jpanelJoiningDate.gridy = 1;
		jpanelFilterRecord.add(jpanelJoiningDate, gbc_jpanelJoiningDate);
		GridBagLayout gbl_jpanelJoiningDate = new GridBagLayout();
		gbl_jpanelJoiningDate.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelJoiningDate.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelJoiningDate.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelJoiningDate.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		jpanelJoiningDate.setLayout(gbl_jpanelJoiningDate);

		JLabel lblNewLabel_11 = new JLabel("Joining From");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 0;
		jpanelJoiningDate.add(lblNewLabel_11, gbc_lblNewLabel_11);

		jdateChooserJoiningFrom = new JDateChooser();
		jdateChooserJoiningFrom.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserJoiningFrom_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserJoiningFrom = new GridBagConstraints();
		gbc_jdateChooserJoiningFrom.insets = new Insets(0, 0, 5, 0);
		gbc_jdateChooserJoiningFrom.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserJoiningFrom.gridx = 1;
		gbc_jdateChooserJoiningFrom.gridy = 0;
		jpanelJoiningDate.add(jdateChooserJoiningFrom, gbc_jdateChooserJoiningFrom);

		JLabel lblNewLabel_12 = new JLabel("Joining To");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 1;
		jpanelJoiningDate.add(lblNewLabel_12, gbc_lblNewLabel_12);

		jdateChooserJoiningTo = new JDateChooser();
		jdateChooserJoiningTo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserJoiningTo_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserJoiningTo = new GridBagConstraints();
		gbc_jdateChooserJoiningTo.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserJoiningTo.gridx = 1;
		gbc_jdateChooserJoiningTo.gridy = 1;
		jpanelJoiningDate.add(jdateChooserJoiningTo, gbc_jdateChooserJoiningTo);

		JPanel jpanelCreatedDate = new JPanel();
		GridBagConstraints gbc_jpanelCreatedDate = new GridBagConstraints();
		gbc_jpanelCreatedDate.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelCreatedDate.fill = GridBagConstraints.BOTH;
		gbc_jpanelCreatedDate.gridx = 3;
		gbc_jpanelCreatedDate.gridy = 1;
		jpanelFilterRecord.add(jpanelCreatedDate, gbc_jpanelCreatedDate);
		GridBagLayout gbl_jpanelCreatedDate = new GridBagLayout();
		gbl_jpanelCreatedDate.columnWidths = new int[] { 0, 0, 0 };
		gbl_jpanelCreatedDate.rowHeights = new int[] { 0, 0, 0 };
		gbl_jpanelCreatedDate.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_jpanelCreatedDate.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		jpanelCreatedDate.setLayout(gbl_jpanelCreatedDate);

		JLabel lblNewLabel_13 = new JLabel("Created From");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 0;
		jpanelCreatedDate.add(lblNewLabel_13, gbc_lblNewLabel_13);

		jdateChooserCreatedFrom = new JDateChooser();
		jdateChooserCreatedFrom.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserCreatedFrom_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserCreatedFrom = new GridBagConstraints();
		gbc_jdateChooserCreatedFrom.insets = new Insets(0, 0, 5, 0);
		gbc_jdateChooserCreatedFrom.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserCreatedFrom.gridx = 1;
		gbc_jdateChooserCreatedFrom.gridy = 0;
		jpanelCreatedDate.add(jdateChooserCreatedFrom, gbc_jdateChooserCreatedFrom);

		JLabel lblNewLabel_14 = new JLabel("Created To");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 1;
		jpanelCreatedDate.add(lblNewLabel_14, gbc_lblNewLabel_14);

		jdateChooserCreatedTo = new JDateChooser();
		jdateChooserCreatedTo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserCreatedTo_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserCreatedTo = new GridBagConstraints();
		gbc_jdateChooserCreatedTo.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserCreatedTo.gridx = 1;
		gbc_jdateChooserCreatedTo.gridy = 1;
		jpanelCreatedDate.add(jdateChooserCreatedTo, gbc_jdateChooserCreatedTo);
		
		jbuttonResetFilter = new JButton("Reset Filter");
		jbuttonResetFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonResetFilter_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jbuttonResetFilter = new GridBagConstraints();
		gbc_jbuttonResetFilter.insets = new Insets(0, 0, 5, 5);
		gbc_jbuttonResetFilter.gridx = 0;
		gbc_jbuttonResetFilter.gridy = 2;
		jpanelFilterRecord.add(jbuttonResetFilter, gbc_jbuttonResetFilter);

		JButton jbuttonGenerateReport = new JButton("Generate Report");
		jbuttonGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonGenerateReport_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jbuttonGenerateReport = new GridBagConstraints();
		gbc_jbuttonGenerateReport.anchor = GridBagConstraints.EAST;
		gbc_jbuttonGenerateReport.insets = new Insets(0, 0, 5, 5);
		gbc_jbuttonGenerateReport.gridx = 3;
		gbc_jbuttonGenerateReport.gridy = 2;
		jpanelFilterRecord.add(jbuttonGenerateReport, gbc_jbuttonGenerateReport);

		JScrollPane jscrollPaneTransferRecord = new JScrollPane();

		jpopupMenuRecord = new JPopupMenu();
		addPopup(jscrollPaneTransferRecord, jpopupMenuRecord);

		jMenuItemEditRecord = new JMenuItem("Verify");
		jMenuItemEditRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jMenuItemEditRecord_actionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_17 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 3;
		gbc_lblNewLabel_17.gridy = 1;
		add(lblNewLabel_17, gbc_lblNewLabel_17);
		jpopupMenuRecord.add(jMenuItemEditRecord);
		GridBagConstraints gbc_jscrollPaneTransferRecord = new GridBagConstraints();
		gbc_jscrollPaneTransferRecord.insets = new Insets(0, 0, 5, 5);
		gbc_jscrollPaneTransferRecord.fill = GridBagConstraints.BOTH;
		gbc_jscrollPaneTransferRecord.gridx = 2;
		gbc_jscrollPaneTransferRecord.gridy = 3;
		add(jscrollPaneTransferRecord, gbc_jscrollPaneTransferRecord);

		jtableTransferRecord = new JTable();
//		jtableTransferRecord.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				do_jtableTransferRecord_mouseClicked(e);
//			}
//		});
		jscrollPaneTransferRecord.setViewportView(jtableTransferRecord);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);

		jbuttonFirstPage = new JButton("|<");
		jbuttonFirstPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonFirstPage_actionPerformed(e);
			}
		});
		panel.add(jbuttonFirstPage);

		jbuttonPreviousPage = new JButton("<");
		jbuttonPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonPreviousPage_actionPerformed(e);
			}
		});
		panel.add(jbuttonPreviousPage);

		jtextFieldCurrentPage = new JTextField();
		jtextFieldCurrentPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jtextFieldCurrentPage_actionPerformed(e);
			}
		});
		panel.add(jtextFieldCurrentPage);
		jtextFieldCurrentPage.setColumns(10);

		jlabelTotalPage = new JLabel("/ 0");
		panel.add(jlabelTotalPage);

		jbuttonNextPage = new JButton(">");
		jbuttonNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonNextPage_actionPerformed(e);
			}
		});
		panel.add(jbuttonNextPage);

		jbuttonLastPage = new JButton(">|");
		jbuttonLastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonLastPage_actionPerformed(e);
			}
		});
		panel.add(jbuttonLastPage);

	}

	private int cornerRadius = 20;
	private JButton jbuttonResetFilter;
//    private Color borderColor = Color.RED; // Border color

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Fill the rounded rectangle with the current background color (default)
		g2d.setColor(getBackground());
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
		
//		g2d.setColor(borderColor);
//        g2d.drawRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
	}
	
	

	public JPanelRecord(Map<String, Object> data) {
		this();
		this.data = data;
		initJPanel();
	}

	private void initJPanel() {
		RecordModel transferRecordModel = new RecordModel();
		fillDataToJtableTransferRecord(transferRecordModel.findAll());
		jcomboboxProjectFrom();
		jcomboBoxDepartmentFrom();
		jcomboBoxLocationFrom();
		jcomboboxProjectTo();
		jcomboBoxDepartmentTo();
		jcomboBoxLocationTo();
		functionRole();
		
		this.setOpaque(false);
	}

	private void functionRole() {
		RecordModel transferRecordModel = new RecordModel();
		int managerId = Integer.parseInt(data.get("id").toString());
		int employeeId = Integer.parseInt(data.get("id").toString());
		int roleId = Integer.parseInt(data.get("roleId").toString());
		if (roleId == 1) {
			fillDataToJtableTransferRecord(transferRecordModel.findAll());
//			System.out.println("If");
		} else {
			fillDataToJtableTransferRecord(transferRecordModel.findManagedEmployeeRecord(employeeId, managerId));
//			System.out.println("else");
		}
	}

	private void fillDataToJtableTransferRecord(List<Records> records) {
		jtableTransferRecord.setModel(recordTableModel);
		recordTableModel.setRowCount(0);

		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		LocationModel locationModel = new LocationModel();
		DepartmentModel departmentModel = new DepartmentModel();
		ProjectsModel projectsModel = new ProjectsModel();
		EmployeeModel employeeModel = new EmployeeModel();

		jtableTransferRecord.setRowSorter(sorter);

		// note tablemodel
//		DefaultTableModel recordTableModel = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//		};

		recordTableModel.addColumn("ID");
		recordTableModel.addColumn("Requestor");
		recordTableModel.addColumn("Request for");
		recordTableModel.addColumn("From Project");
		recordTableModel.addColumn("To Project");
		recordTableModel.addColumn("From Location");
		recordTableModel.addColumn("To Location");
		recordTableModel.addColumn("From Department");
		recordTableModel.addColumn("To Department");
		recordTableModel.addColumn("Relieving Date");
		recordTableModel.addColumn("Joining Date");
		recordTableModel.addColumn("Last Modified");
		recordTableModel.addColumn("Status");

		Map<Integer, Employee> employees = new HashMap<>();
		Map<Integer, Projects> projects = new HashMap<>();
		Map<Integer, Location> locations = new HashMap<>();
		Map<Integer, Department> departments = new HashMap<>();

		for (Records record : records) {
			if (!employees.containsKey(record.getEmployeeId())) {
				employees.put(record.getEmployeeId(), employeeModel.findById(record.getEmployeeId()));
			}

			if (!employees.containsKey(record.getRequestFor())) {
				employees.put(record.getRequestFor(), employeeModel.findById(record.getRequestFor()));
			}

			if (!projects.containsKey(record.getProjectFrom())) {
				projects.put(record.getProjectFrom(), projectsModel.findById(record.getProjectFrom()));
			}

			if (!projects.containsKey(record.getProjectTo())) {
				projects.put(record.getProjectTo(), projectsModel.findById(record.getProjectTo()));
			}

			if (!locations.containsKey(record.getLocationFrom())) {
				locations.put(record.getLocationFrom(), locationModel.findById(record.getLocationFrom()));
			}

			if (!locations.containsKey(record.getLocationTo())) {
				locations.put(record.getLocationTo(), locationModel.findById(record.getLocationTo()));
			}

			if (!departments.containsKey(record.getDepartmentFrom())) {
				departments.put(record.getDepartmentFrom(), departmentModel.findById(record.getDepartmentFrom()));
			}

			if (!departments.containsKey(record.getDepartmentTo())) {
				departments.put(record.getDepartmentTo(), departmentModel.findById(record.getDepartmentTo()));
			}
		}

		for (Records record : records) {
			Employee employee = employees.get(record.getEmployeeId());
			Employee requestFor = employees.get(record.getRequestFor());
			Projects projectFrom = projects.get(record.getProjectFrom());
			Projects projectTo = projects.get(record.getProjectTo());
			Location locationFrom = locations.get(record.getLocationFrom());
			Location locationTo = locations.get(record.getLocationTo());
			Department departmentFrom = departments.get(record.getDepartmentFrom());
			Department departmentTo = departments.get(record.getDepartmentTo());

			recordTableModel.addRow(new Object[] { record.getId(), employee != null ? employee.getName() : "-",
					requestFor != null ? requestFor.getName() : "-", projectFrom != null ? projectFrom.getName() : "-",
					projectTo != null ? projectTo.getName() : "-", locationFrom != null ? locationFrom.getName() : "-",
					locationTo != null ? locationTo.getName() : "-",
					departmentFrom != null ? departmentFrom.getName() : "-",
					departmentTo != null ? departmentTo.getName() : "-",
					record.getTransferRelievingDate() != null ? sp.format(record.getTransferRelievingDate()) : "-",
					sp.format(record.getTransferJoiningDate()), sp.format(record.getCreatedDate()),
					record.getStatus() == 0 ? "Pending" : record.getStatus() == 1 ? "Approved" : "Rejected",

			});
		}

		jtableTransferRecord.getTableHeader().setReorderingAllowed(false);
		jtableTransferRecord.setComponentPopupMenu(jpopupMenuRecord);

		jtableTransferRecord.setAutoCreateColumnsFromModel(false);
		jtableTransferRecord.setComponentPopupMenu(jpopupMenuRecord);

		int rowCount = recordTableModel.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		jlabelTotalPage.setText(String.format("/ %d", maxPageIndex));

		// console log debug view
//		String functionName = new Object(){}.getClass().getEnclosingMethod().getName();
//		String className = this.getClass().getName();
//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//		StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
//		String methodName = e.getMethodName();
//		System.out.println(methodName + " row: " + rowCount);

	}

	private void jcomboboxProjectFrom() {
		ProjectsModel projectsModel = new ProjectsModel();
		DefaultComboBoxModel<Projects> projectBoxModel = new DefaultComboBoxModel<>();
		projectBoxModel.addElement(new Projects(-1, "All"));
		for (Projects projects : projectsModel.findAll()) {
			projectBoxModel.addElement(projects);
		}
		projectBoxModel.addElement(new Projects(-2, "None"));
		jcomboBoxFromProject.setModel(projectBoxModel);
		jcomboBoxFromProject.setRenderer(new ProjectsCellRender());
	}

	private void jcomboboxProjectTo() {
		ProjectsModel projectsModel = new ProjectsModel();
		DefaultComboBoxModel<Projects> projectBoxModel = new DefaultComboBoxModel<>();
		projectBoxModel.addElement(new Projects(-1, "All"));
		for (Projects projects : projectsModel.findAll()) {
			projectBoxModel.addElement(projects);
		}
		projectBoxModel.addElement(new Projects(-2, "None"));
		jcomboBoxToProject.setModel(projectBoxModel);
		jcomboBoxToProject.setRenderer(new ProjectsCellRender());
	}

	private void jcomboBoxDepartmentFrom() {
		DepartmentModel departmentModel = new DepartmentModel();
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		departmentBoxModel.addElement(new Department(-1, "All"));
		for (Department department : departmentModel.findAll()) {
			departmentBoxModel.addElement(department);
		}
		departmentBoxModel.addElement(new Department(-2, "None"));
		jcomboBoxFromDepartment.setModel(departmentBoxModel);
		jcomboBoxFromDepartment.setRenderer(new DepartmentCellRender());
	}

	private void jcomboBoxDepartmentTo() {
		DepartmentModel departmentModel = new DepartmentModel();
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		departmentBoxModel.addElement(new Department(-1, "All"));
		for (Department department : departmentModel.findAll()) {
			departmentBoxModel.addElement(department);
		}
		departmentBoxModel.addElement(new Department(-2, "None"));
		jcomboBoxToDepartment.setModel(departmentBoxModel);
		jcomboBoxToDepartment.setRenderer(new DepartmentCellRender());
	}

	private void jcomboBoxLocationFrom() {
		LocationModel locationModel = new LocationModel();
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		locationBoxModel.addElement(new Location(-1, "All"));
		for (Location location : locationModel.findAll()) {
			locationBoxModel.addElement(location);

		}
		locationBoxModel.addElement(new Location(-2, "None"));
		jcomboBoxFromLocation.setModel(locationBoxModel);
		jcomboBoxFromLocation.setRenderer(new LocationCellRender());
	}

	private void jcomboBoxLocationTo() {
		LocationModel locationModel = new LocationModel();
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		locationBoxModel.addElement(new Location(-1, "All"));
		for (Location location : locationModel.findAll()) {
			locationBoxModel.addElement(location);

		}
		locationBoxModel.addElement(new Location(-2, "None"));
		jcomboBoxToLocation.setModel(locationBoxModel);
		jcomboBoxToLocation.setRenderer(new LocationCellRender());
	}

	private class ProjectsCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Projects projects = (Projects) value;
			return super.getListCellRendererComponent(list, projects.getName(), index, isSelected, cellHasFocus);
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

	protected void do_jcomboBoxFromProject_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jcomboBoxToProject_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jcomboBoxFromDepartment_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jcomboBoxToDepartment_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jcomboBoxFromLocation_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jcomboBoxToLocation_actionPerformed(ActionEvent e) {
		recordFiltering();
	}

	protected void do_jdateChooserLeavingFrom_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserLeavingFrom.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jdateChooserLeavingTo_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserLeavingTo.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jdateChooserJoiningFrom_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserJoiningFrom.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jdateChooserJoiningTo_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserJoiningTo.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jdateChooserCreatedFrom_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserCreatedFrom.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jdateChooserCreatedTo_propertyChange(PropertyChangeEvent evt) {
		if (jdateChooserCreatedTo.getDate() != null) {
			recordFiltering();
		}
	}

	protected void do_jtextFieldEmployeeName_keyPressed(KeyEvent e) {
		recordFiltering();
	}

	protected void do_jtextFieldRequestFor_keyReleased(KeyEvent e) {
		recordFiltering();
	}

	protected void do_jcheckBoxPending_itemStateChanged(ItemEvent e) {
		recordFiltering();
	}

	protected void do_jcheckBoxApproved_itemStateChanged(ItemEvent e) {
		recordFiltering();
	}

	protected void do_jcheckBoxRejected_itemStateChanged(ItemEvent e) {
		recordFiltering();
	}
	
	protected void do_jbuttonResetFilter_actionPerformed(ActionEvent e) {
		jtextFieldEmployeeName.setText("");
		jtextFieldRequestFor.setText("");
		jcomboBoxFromProject.getModel().setSelectedItem(new Projects(-1, "All"));
		jcomboBoxToProject.getModel().setSelectedItem(new Projects(-1, "All"));
		jcomboBoxFromDepartment.getModel().setSelectedItem(new Department(-1, "All"));
		jcomboBoxToDepartment.getModel().setSelectedItem(new Department(-1, "All"));
		jcomboBoxFromLocation.getModel().setSelectedItem(new Location(-1, "All"));
		jcomboBoxToLocation.getModel().setSelectedItem(new Location(-1, "All"));
		jdateChooserLeavingFrom.setDate(null);
		jdateChooserLeavingTo.setDate(null);
		jdateChooserJoiningFrom.setDate(null);
		jdateChooserJoiningTo.setDate(null);
		jdateChooserCreatedFrom.setDate(null);
		jdateChooserCreatedTo.setDate(null);
		jcheckBoxPending.setSelected(false);
		jcheckBoxApproved.setSelected(false);
		jcheckBoxRejected.setSelected(false);
		functionRole();
	}

	private void recordFiltering() {
		EmployeeModel employeeModel = new EmployeeModel();

		Projects projectFrom = (Projects) jcomboBoxFromProject.getSelectedItem();
		Projects projectTo = (Projects) jcomboBoxToProject.getSelectedItem();

		Department departmentFrom = (Department) jcomboBoxFromDepartment.getSelectedItem();
		Department departmentTo = (Department) jcomboBoxToDepartment.getSelectedItem();

		String employeeName = jtextFieldEmployeeName.getText();
		String requestFor = jtextFieldRequestFor.getText();
		Integer requestForId = (requestFor != null && !requestFor.isEmpty()) ? employeeModel.getEmployeeId(requestFor) : null;

		Location locationFrom = (Location) jcomboBoxFromLocation.getSelectedItem();
		Location locationTo = (Location) jcomboBoxToLocation.getSelectedItem();

		Date leavingDateFrom = jdateChooserLeavingFrom.getDate();
		Date leavingDateTo = jdateChooserLeavingTo.getDate();

		Date joiningDateFrom = jdateChooserJoiningFrom.getDate();
		Date joiningDateTo = jdateChooserJoiningTo.getDate();

		Date createDateFrom = jdateChooserCreatedFrom.getDate();
		Date createDateTo = jdateChooserCreatedTo.getDate();
		RecordModel recordModel = new RecordModel();

		SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
		String leavingDateFromParameter = (leavingDateFrom != null) ? spDate.format(leavingDateFrom) : null;
		String leavingDateToParameter = (leavingDateTo != null) ? spDate.format(leavingDateTo) : null;
		String joiningDateFromParameter = (joiningDateFrom != null) ? spDate.format(joiningDateFrom) : null;
		String joiningDateToParameter = (joiningDateTo != null) ? spDate.format(joiningDateTo) : null;
		String createdDateFromParameter = (createDateFrom != null) ? spDate.format(createDateFrom) : null;
		String createdDateToParameter = (createDateTo != null) ? spDate.format(createDateTo) : null;

		String statusPending = "";
		String statusApproved = "";
		String statusRejected = "";

		JCheckBox checkBoxPending = (JCheckBox) jcheckBoxPending;
		if (checkBoxPending.isSelected()) {
			statusPending = String.valueOf(checkBoxPending.getActionCommand());
		}

		JCheckBox checkBoxApproved = (JCheckBox) jcheckBoxApproved;
		if (checkBoxApproved.isSelected()) {
			statusApproved = String.valueOf(checkBoxApproved.getActionCommand());
		}

		JCheckBox checkBoxRejected = (JCheckBox) jcheckBoxRejected;
		if (checkBoxRejected.isSelected()) {
			statusRejected = String.valueOf(checkBoxRejected.getActionCommand());
		}
//		System.out.println("Status: " + statusPending);

		fillDataToJtableTransferRecord(recordModel.findBy_ProjectDepartmentLocation_FromTo(employeeName, requestFor,
				projectFrom.getName(), projectTo.getName(), departmentFrom.getName(), departmentTo.getName(),
				locationFrom.getName(), locationTo.getName(), leavingDateFromParameter, leavingDateToParameter,
				joiningDateFromParameter, joiningDateToParameter, createdDateFromParameter, createdDateToParameter,
				statusPending, statusApproved, statusRejected));

		currentPageIndex = 1;

//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//	    
//	    // The index 2 should point to the direct caller of this method
//	    StackTraceElement caller = stacktrace[2];
//	    
//	    // Get the method name of the caller
//	    String callerMethodName = caller.getMethodName();
//	    
//	    // Print or log the method that called filteringFunction()
//	    System.out.println("filteringFunction was called by: " + callerMethodName);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	protected void do_jMenuItemEditRecord_actionPerformed(ActionEvent e) {
		int selectedRow = jtableTransferRecord.getSelectedRow();
		if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Please select a record to edit.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }		
		int id = Integer.parseInt(jtableTransferRecord.getValueAt(selectedRow, 0).toString());
		EmployeeModel employeeModel = new EmployeeModel();
		RecordModel recordModel = new RecordModel();
		Records record = recordModel.findById(id);
		Map<String, Object> dataRecord = new HashMap<>();
		dataRecord.put("record", record);
		int roleId = Integer.parseInt(data.get("roleId").toString());
		int employeeId = Integer.parseInt(data.get("id").toString());

		if (roleId == 1) {

			if (record.getProjectFrom() != 0 && record.getProjectTo() != 0) {
				if (record.getStatus() == 1 || record.getStatus() == 2) {
					JDialogViewRecordProject viewRecordProject = new JDialogViewRecordProject(dataRecord, data);
					viewRecordProject.setVisible(true);
				} else {
					JDialogUpdateRecordProject updateProjectDialog = new JDialogUpdateRecordProject(
							new UpdateProjectResult(), dataRecord, data);
					updateProjectDialog.setVisible(true);
				}

			}

			if (record.getDepartmentFrom() != 0 && record.getDepartmentTo() != 0) {
				if (record.getStatus() == 1 || record.getStatus() == 2) {
					JDialogViewRecordDepartment viewRecordDepartment = new JDialogViewRecordDepartment(dataRecord,
							data);
					viewRecordDepartment.setVisible(true);
				} else {
					JDialogUpdateRecordDepartment updateRecordDepartment = new JDialogUpdateRecordDepartment(
							new UpdateDepartmentResult(), dataRecord, data);
					updateRecordDepartment.setVisible(true);
				}

			}

			if (record.getLocationFrom() != 0 && record.getLocationTo() != 0) {
				if (record.getStatus() == 1 || record.getStatus() == 2) {
					JDialogViewRecordLocation viewRecordLocation = new JDialogViewRecordLocation(dataRecord, data);
					viewRecordLocation.setVisible(true);
				} else {
					JDialogUpdateRecordLocation updateRecordLocation = new JDialogUpdateRecordLocation(
							new UpdateLocationResult(), dataRecord, data);
					updateRecordLocation.setVisible(true);
				}

			}

			if (record.getProjectTo() != 0 && record.getDepartmentTo() != 0 && record.getLocationTo() != 0) {
				JDialogViewBeginingRecordEmp viewBeginingRecord = new JDialogViewBeginingRecordEmp(dataRecord, data);
				viewBeginingRecord.setVisible(true);
			}
		} else {

			if (record.getProjectFrom() != 0 && record.getProjectTo() != 0) {
				if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId) == true) {
					if(record.getRequestFor() != employeeId) {
						JDialogUpdateRecordProject updateProjectDialog = new JDialogUpdateRecordProject(
								new UpdateProjectResult(), dataRecord, data);
						updateProjectDialog.setVisible(true);
					}
					else {
						JDialogViewRecordProject viewRecordProject = new JDialogViewRecordProject(dataRecord, data);
						viewRecordProject.setVisible(true);
					}
				} else {
					JDialogViewRecordProject viewRecordProject = new JDialogViewRecordProject(dataRecord, data);
					viewRecordProject.setVisible(true);
				}

			}

			if (record.getDepartmentFrom() != 0 && record.getDepartmentTo() != 0) {
				if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId) == true) {
					if(record.getRequestFor() != employeeId) {
						JDialogUpdateRecordDepartment updateRecordDepartment = new JDialogUpdateRecordDepartment(
								new UpdateDepartmentResult(), dataRecord, data);
						updateRecordDepartment.setVisible(true);
					}
					else {
						JDialogViewRecordProject viewRecordProject = new JDialogViewRecordProject(dataRecord, data);
						viewRecordProject.setVisible(true);
					}
				} else {
					JDialogViewRecordDepartment viewRecordDepartment = new JDialogViewRecordDepartment(dataRecord,
							data);
					viewRecordDepartment.setVisible(true);
				}

			}

			if (record.getLocationFrom() != 0 && record.getLocationTo() != 0) {
				if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId) == true) {
					if(record.getRequestFor() != employeeId) {
						JDialogUpdateRecordLocation updateRecordLocation = new JDialogUpdateRecordLocation(
								new UpdateLocationResult(), dataRecord, data);
						updateRecordLocation.setVisible(true);
					}
					else {
						JDialogViewRecordProject viewRecordProject = new JDialogViewRecordProject(dataRecord, data);
						viewRecordProject.setVisible(true);
					}
				} else {
					JDialogViewRecordLocation viewRecordLocation = new JDialogViewRecordLocation(dataRecord, data);
					viewRecordLocation.setVisible(true);
				}

			}

			if (record.getProjectTo() != 0 && record.getDepartmentTo() != 0 && record.getLocationTo() != 0) {
				JDialogViewBeginingRecordEmp viewBeginingRecord = new JDialogViewBeginingRecordEmp(dataRecord, data);
				viewBeginingRecord.setVisible(true);
			}
		}

	}
	
	// Edit menu-item even handler, refactor version, case study purpose only
//	protected void do_jMenuItemEditRecord_actionPerformed(ActionEvent e) {
//	    int selectedRow = jtableTransferRecord.getSelectedRow();
//	    if (selectedRow == -1) {
//	        JOptionPane.showMessageDialog(null, "Please select a record to edit.", "Error", JOptionPane.ERROR_MESSAGE);
//	        return;
//	    }
//
//	    int id = Integer.parseInt(jtableTransferRecord.getValueAt(selectedRow, 0).toString());
//	    RecordModel recordModel = new RecordModel();
//	    EmployeeModel employeeModel = new EmployeeModel();
//	    Records record = recordModel.findById(id);
//
//	    Map<String, Object> dataRecord = new HashMap<>();
//	    dataRecord.put("record", record);
//
//	    int roleId = Integer.parseInt(data.get("roleId").toString());
//	    int employeeId = Integer.parseInt(data.get("id").toString());
//
//	    if (roleId == 1) { // Admin role
//	        handleAdminRole(record, dataRecord, data);
//	    } else { // Non-admin role
//	        handleNonAdminRole(record, dataRecord, data, employeeId, employeeModel);
//	    }
//	}
//
//	private void handleAdminRole(Records record, Map<String, Object> dataRecord, Map<String, Object> data) {
//	    if (isProjectTransfer(record)) {
//	        openDialogBasedOnStatus(record, dataRecord, data, JDialogViewRecordProject::new, JDialogUpdateRecordProject::new);
//	    } else if (isDepartmentTransfer(record)) {
//	        openDialogBasedOnStatus(record, dataRecord, data, JDialogViewRecordDepartment::new, JDialogUpdateRecordDepartment::new);
//	    } else if (isLocationTransfer(record)) {
//	        openDialogBasedOnStatus(record, dataRecord, data, JDialogViewRecordLocation::new, JDialogUpdateRecordLocation::new);
//	    } else if (isAllTransfers(record)) {
//	        new JDialogViewBeginingRecordEmp(dataRecord, data).setVisible(true);
//	    }
//	}
//
//	private void handleNonAdminRole(Records record, Map<String, Object> dataRecord, Map<String, Object> data, int employeeId, EmployeeModel employeeModel) {
//	    if (isProjectTransfer(record)) {
//	        handleNonAdminProject(record, dataRecord, data, employeeId, employeeModel);
//	    } else if (isDepartmentTransfer(record)) {
//	        handleNonAdminDepartment(record, dataRecord, data, employeeId, employeeModel);
//	    } else if (isLocationTransfer(record)) {
//	        handleNonAdminLocation(record, dataRecord, data, employeeId, employeeModel);
//	    } else if (isAllTransfers(record)) {
//	        new JDialogViewBeginingRecordEmp(dataRecord, data).setVisible(true);
//	    }
//	}
//
//	private void handleNonAdminProject(Records record, Map<String, Object> dataRecord, Map<String, Object> data, int employeeId, EmployeeModel employeeModel) {
//	    if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId)) {
//	        if (record.getRequestFor() != employeeId) {
//	            new JDialogUpdateRecordProject(new UpdateProjectResult(), dataRecord, data).setVisible(true);
//	        } else {
//	            new JDialogViewRecordProject(dataRecord, data).setVisible(true);
//	        }
//	    } else {
//	        new JDialogViewRecordProject(dataRecord, data).setVisible(true);
//	    }
//	}
//
//	private void handleNonAdminDepartment(Records record, Map<String, Object> dataRecord, Map<String, Object> data, int employeeId, EmployeeModel employeeModel) {
//	    if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId)) {
//	        if (record.getRequestFor() != employeeId) {
//	            new JDialogUpdateRecordDepartment(new UpdateDepartmentResult(), dataRecord, data).setVisible(true);
//	        } else {
//	            new JDialogViewRecordDepartment(dataRecord, data).setVisible(true);
//	        }
//	    } else {
//	        new JDialogViewRecordDepartment(dataRecord, data).setVisible(true);
//	    }
//	}
//
//	private void handleNonAdminLocation(Records record, Map<String, Object> dataRecord, Map<String, Object> data, int employeeId, EmployeeModel employeeModel) {
//	    if (record.getStatus() == 0 && employeeModel.checkManagedEmployees(employeeId)) {
//	        if (record.getRequestFor() != employeeId) {
//	            new JDialogUpdateRecordLocation(new UpdateLocationResult(), dataRecord, data).setVisible(true);
//	        } else {
//	            new JDialogViewRecordLocation(dataRecord, data).setVisible(true);
//	        }
//	    } else {
//	        new JDialogViewRecordLocation(dataRecord, data).setVisible(true);
//	    }
//	}
//
//	private void openDialogBasedOnStatus(Records record, Map<String, Object> dataRecord, Map<String, Object> data,
//	                                     Function<Map<String, Object>, JDialog> viewDialogSupplier,
//	                                     Function<Map<String, Object>, JDialog> updateDialogSupplier) {
//	    if (record.getStatus() == 1 || record.getStatus() == 2) {
//	        viewDialogSupplier.apply(dataRecord).setVisible(true);
//	    } else {
//	        updateDialogSupplier.apply(dataRecord).setVisible(true);
//	    }
//	}

	// Helper methods to determine the type of transfer
//			private boolean isProjectTransfer(Records record) {
//			    return record.getProjectFrom() != 0 && record.getProjectTo() != 0;
//			}
//
//			private boolean isDepartmentTransfer(Records record) {
//			    return record.getDepartmentFrom() != 0 && record.getDepartmentTo() != 0;
//			}
//
//			private boolean isLocationTransfer(Records record) {
//			    return record.getLocationFrom() != 0 && record.getLocationTo() != 0;
//			}
//
//			private boolean isAllTransfers(Records record) {
//			    return record.getProjectTo() != 0 && record.getDepartmentTo() != 0 && record.getLocationTo() != 0;
//			}
	

	private class UpdateProjectResult implements UpdateProjectRepsone {

		@Override
		public boolean getValue(Records record) {
			RecordModel recordModel = new RecordModel();
			EmployeeModel employeeModel = new EmployeeModel();
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				if (recordModel.updateProjectRecord(record)) {
					JOptionPane.showMessageDialog(null, "Update project record success", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					fillDataToJtableTransferRecord(recordModel.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Update project record failed", "Warning",
							JOptionPane.ERROR_MESSAGE);
				}

				Employee employee = employeeModel.findById(record.getRequestFor());
				employee.setCurrentProject(record.getProjectTo());
				employee.setJoiningDate(record.getTransferJoiningDate());
				if (record.getStatus() == 1) {
					if (employeeModel.updateCurrentProject(employee)) {
						JOptionPane.showMessageDialog(null, "Update current employee project success", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						data.put("projectId", record.getProjectTo());
					} else {
						JOptionPane.showMessageDialog(null, "Update current employee project failed", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				return true;
			}
			return false;
		}

	}

	private class UpdateDepartmentResult implements UpdateDepartmentRepsone {

		@Override
		public boolean getValue(Records record) {
			RecordModel recordModel = new RecordModel();
			EmployeeModel employeeModel = new EmployeeModel();
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				if (recordModel.updateDepartmentRecord(record)) {
					JOptionPane.showMessageDialog(null, "Update department record success", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					fillDataToJtableTransferRecord(recordModel.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Update department record failed", "Warning",
							JOptionPane.ERROR_MESSAGE);
				}
	
				Employee employee = employeeModel.findById(record.getRequestFor());
				employee.setCurrentDepartment(record.getDepartmentTo());
				employee.setJoiningDate(record.getTransferJoiningDate());
				if (record.getStatus() == 1) {
					if (employeeModel.updateCurrentDepartment(employee)) {
						JOptionPane.showMessageDialog(null, "Update current employee department success", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						data.put("departmentId", record.getDepartmentTo());
					} else {
						JOptionPane.showMessageDialog(null, "Update current employee department failed", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				return true;
			}
			return false;
		}

	}

	private class UpdateLocationResult implements UpdateLocationRepsone {

		@Override
		public boolean getValue(Records record) {
			RecordModel recordModel = new RecordModel();
			EmployeeModel employeeModel = new EmployeeModel();
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				if (recordModel.updateLocationRecord(record)) {
					JOptionPane.showMessageDialog(null, "Update location record success", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					fillDataToJtableTransferRecord(recordModel.findAll());
				} else {
					JOptionPane.showMessageDialog(null, "Update location record failed", "Warning",
							JOptionPane.ERROR_MESSAGE);
				}
	
				Employee employee = employeeModel.findById(record.getRequestFor());
				employee.setCurrentLocation(record.getLocationTo());
				employee.setJoiningDate(record.getTransferJoiningDate());
				if (record.getStatus() == 1) {
					if (employeeModel.updateCurrentLocation(employee)) {
						JOptionPane.showMessageDialog(null, "Update current employee location success", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						data.put("locationId", record.getLocationTo());
					} else {
						JOptionPane.showMessageDialog(null, "Update current employee location failed", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				return true;
			}
			return false;
		}

	}

//	private class UpdateBeginingResult implements UpdateBeginingRepsone {
//
//		@Override
//		public void getValue(Records record) {
//			RecordModel recordModel = new RecordModel();
//			EmployeeModel employeeModel = new EmployeeModel();
//			if (recordModel.updateEmployeeRecord(record)) {
//				JOptionPane.showMessageDialog(null, "Update employee begining record success", "Success",
//						JOptionPane.INFORMATION_MESSAGE);
//				fillDataToJtableTransferRecord(recordModel.findAll());
//			} else {
//				JOptionPane.showMessageDialog(null, "Update employee begining record failed", "Warning",
//						JOptionPane.ERROR_MESSAGE);
//			}
//
//			Employee employee = employeeModel.findById(record.getRequestFor());
//			employee.setId(record.getRequestFor());
//			employee.setCurrentProject(record.getProjectTo());
//			employee.setCurrentDepartment(record.getDepartmentTo());
//			employee.setCurrentLocation(record.getLocationTo());
//			employee.setJoiningDate(record.getTransferJoiningDate());
//			if (record.getStatus() == 1) {
//				if (employeeModel.updateCurrentProject_Department_Location(employee)) {
//					JOptionPane.showMessageDialog(null, "Update current employee info success", "Success",
//							JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					JOptionPane.showMessageDialog(null, "Update current employee info failed", "Warning",
//							JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		}
//
//	}

	protected void do_jtableTransferRecord_mouseClicked(MouseEvent e) {
		int r = jtableTransferRecord.rowAtPoint(e.getPoint());
		if (r >= 0 && r < jtableTransferRecord.getRowCount()) {
			jtableTransferRecord.setRowSelectionInterval(r, r);
		} else {
			jtableTransferRecord.clearSelection();
		}

		int rowindex = jtableTransferRecord.getSelectedRow();
		if (rowindex < 0)
			return;

		if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
			JPopupMenu popup = new JPopupMenu();
			popup.show(e.getComponent(), e.getX(), e.getY());
			jtableTransferRecord.setRowSelectionInterval(r, r);
		}
	}

	protected void do_jbuttonGenerateReport_actionPerformed(ActionEvent e) {
		try {
			TableModel tableModel = jtableTransferRecord.getModel();
			File csvFile = CsvUtils.generateCsvFileFromTable(tableModel);
			System.out.println("CSV file created at: " + csvFile.getAbsolutePath());
			// Now you can use this file with your existing send method

			String mailTo = data.get("email").toString();
			String mailSubject = "Transfer Report";

			Map<String, Object> summary = generateSummary(tableModel);

//            String mailBody = "<p>recordTotalNum: " + summary.get("recordTotalNum").toString() + "</p>"
//            				+ "<p>recordPendingNum" + summary.get("recordPendingNum").toString() + "</p>"
//            				+ "<p>recordApprovedNum" + summary.get("recordApprovedNum").toString() + "</p>"
//            				+ "<p>recordRejectedNum" + summary.get("recordRejectedNum").toString() + "</p>"
//            				+ "<p>fromProjectMax" + summary.get("fromProjectMax").toString() + "</p>"
//            				+ "<p>fromDepartmentMax" + summary.get("fromDepartmentMax").toString() + "</p>"
//            				+ "<p>fromLocationMax" + summary.get("fromLocationMax").toString() + "</p>"
//            				+ "<p>toProjectMax" + summary.get("toProjectMax").toString() + "</p>"
//            				+ "<p>toDepartmentMax" + summary.get("toDepartmentMax").toString() + "</p>"
//            				+ "<p>toLocationMax" + summary.get("toLocationMax").toString() + "</p>";

			String mailBody = "<!--\r\n" + "* This email was built using Tabular.\r\n"
					+ "* For more information, visit https://tabular.email\r\n" + "-->\r\n"
					+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
					+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\r\n"
					+ "<head>\r\n" + "<title></title>\r\n" + "<meta charset=\"UTF-8\" />\r\n"
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
					+ "<!--<![endif]-->\r\n" + "<meta name=\"x-apple-disable-message-reformatting\" content=\"\" />\r\n"
					+ "<meta content=\"target-densitydpi=device-dpi\" name=\"viewport\" />\r\n"
					+ "<meta content=\"true\" name=\"HandheldFriendly\" />\r\n"
					+ "<meta content=\"width=device-width\" name=\"viewport\" />\r\n"
					+ "<meta name=\"format-detection\" content=\"telephone=no, date=no, address=no, email=no, url=no\" />\r\n"
					+ "<style type=\"text/css\">\r\n" + "table {\r\n" + "border-collapse: separate;\r\n"
					+ "table-layout: fixed;\r\n" + "mso-table-lspace: 0pt;\r\n" + "mso-table-rspace: 0pt\r\n" + "}\r\n"
					+ "table td {\r\n" + "border-collapse: collapse\r\n" + "}\r\n" + ".ExternalClass {\r\n"
					+ "width: 100%\r\n" + "}\r\n" + ".ExternalClass,\r\n" + ".ExternalClass p,\r\n"
					+ ".ExternalClass span,\r\n" + ".ExternalClass font,\r\n" + ".ExternalClass td,\r\n"
					+ ".ExternalClass div {\r\n" + "line-height: 100%\r\n" + "}\r\n"
					+ ".gmail-mobile-forced-width {\r\n" + "display: none;\r\n" + "display: none !important;\r\n"
					+ "}\r\n" + "body, a, li, p, h1, h2, h3 {\r\n" + "-ms-text-size-adjust: 100%;\r\n"
					+ "-webkit-text-size-adjust: 100%;\r\n" + "}\r\n" + "html {\r\n"
					+ "-webkit-text-size-adjust: none !important\r\n" + "}\r\n" + "body, #innerTable {\r\n"
					+ "-webkit-font-smoothing: antialiased;\r\n" + "-moz-osx-font-smoothing: grayscale\r\n" + "}\r\n"
					+ "#innerTable img+div {\r\n" + "display: none;\r\n" + "display: none !important\r\n" + "}\r\n"
					+ "img {\r\n" + "Margin: 0;\r\n" + "padding: 0;\r\n" + "-ms-interpolation-mode: bicubic\r\n"
					+ "}\r\n" + "h1, h2, h3, p, a {\r\n" + "line-height: inherit;\r\n" + "overflow-wrap: normal;\r\n"
					+ "white-space: normal;\r\n" + "word-break: break-word\r\n" + "}\r\n" + "a {\r\n"
					+ "text-decoration: none\r\n" + "}\r\n" + "h1, h2, h3, p {\r\n" + "min-width: 100%!important;\r\n"
					+ "width: 100%!important;\r\n" + "max-width: 100%!important;\r\n"
					+ "display: inline-block!important;\r\n" + "border: 0;\r\n" + "padding: 0;\r\n" + "margin: 0\r\n"
					+ "}\r\n" + "a[x-apple-data-detectors] {\r\n" + "color: inherit !important;\r\n"
					+ "text-decoration: none !important;\r\n" + "font-size: inherit !important;\r\n"
					+ "font-family: inherit !important;\r\n" + "font-weight: inherit !important;\r\n"
					+ "line-height: inherit !important\r\n" + "}\r\n" + "u + #body a {\r\n" + "color: inherit;\r\n"
					+ "text-decoration: none;\r\n" + "font-size: inherit;\r\n" + "font-family: inherit;\r\n"
					+ "font-weight: inherit;\r\n" + "line-height: inherit;\r\n" + "}\r\n" + "a[href^=\"mailto\"],\r\n"
					+ "a[href^=\"tel\"],\r\n" + "a[href^=\"sms\"] {\r\n" + "color: inherit;\r\n"
					+ "text-decoration: none\r\n" + "}\r\n" + "</style>\r\n" + "<style type=\"text/css\">\r\n"
					+ "@media (min-width: 481px) {\r\n" + ".hd { display: none!important }\r\n" + "}\r\n"
					+ "</style>\r\n" + "<style type=\"text/css\">\r\n" + "@media (max-width: 480px) {\r\n"
					+ ".hm { display: none!important }\r\n" + "}\r\n" + "</style>\r\n" + "<style type=\"text/css\">\r\n"
					+ "@media (max-width: 480px) {\r\n"
					+ ".t74,.t77{mso-line-height-alt:0px!important;line-height:0!important;display:none!important}.t75{padding:40px!important;border-radius:0!important;width:400px!important}.t2{width:368px!important}.t10,.t15,.t20,.t24,.t28,.t32,.t37,.t42,.t47,.t52,.t57,.t6,.t62,.t67,.t72{width:400px!important}\r\n"
					+ "}\r\n" + "</style>\r\n"
					+ "<style type=\"text/css\">@media (max-width: 480px) {[class~=\"x_t74\"]{mso-line-height-alt:0px!important;line-height:0px!important;display:none!important;} [class~=\"x_t77\"]{mso-line-height-alt:0px!important;line-height:0px!important;display:none!important;} [class~=\"x_t75\"]{padding-left:40px!important;padding-top:40px!important;padding-bottom:40px!important;padding-right:40px!important;border-top-left-radius:0px!important;border-top-right-radius:0px!important;border-bottom-right-radius:0px!important;border-bottom-left-radius:0px!important;width:400px!important;} [class~=\"x_t2\"]{width:368px!important;} [class~=\"x_t72\"]{width:400px!important;} [class~=\"x_t6\"]{width:400px!important;} [class~=\"x_t10\"]{width:400px!important;} [class~=\"x_t15\"]{width:400px!important;} [class~=\"x_t20\"]{width:400px!important;} [class~=\"x_t24\"]{width:400px!important;} [class~=\"x_t28\"]{width:400px!important;} [class~=\"x_t32\"]{width:400px!important;} [class~=\"x_t37\"]{width:400px!important;} [class~=\"x_t42\"]{width:400px!important;} [class~=\"x_t47\"]{width:400px!important;} [class~=\"x_t52\"]{width:400px!important;} [class~=\"x_t57\"]{width:400px!important;} [class~=\"x_t62\"]{width:400px!important;} [class~=\"x_t67\"]{width:400px!important;}}</style>\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<link href=\"https://fonts.googleapis.com/css2?family=Albert+Sans:ital,wght@0,400;0,700;1,700&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
					+ "<!--<![endif]-->\r\n" + "<!--[if mso]>\r\n" + "<xml>\r\n" + "<o:OfficeDocumentSettings>\r\n"
					+ "<o:AllowPNG/>\r\n" + "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
					+ "</o:OfficeDocumentSettings>\r\n" + "</xml>\r\n" + "<![endif]-->\r\n" + "</head>\r\n"
					+ "<body id=\"body\" class=\"t80\" style=\"min-width:100%;Margin:0px;padding:0px;background-color:#F4F4F4;\"><div class=\"t79\" style=\"background-color:#F4F4F4;\"><table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"><tr><td class=\"t78\" style=\"font-size:0;line-height:0;mso-line-height-rule:exactly;background-color:#F4F4F4;\" valign=\"top\" align=\"center\">\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\">\r\n"
					+ "<v:fill color=\"#F4F4F4\"/>\r\n" + "</v:background>\r\n" + "<![endif]-->\r\n"
					+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" id=\"innerTable\"><tr><td><div class=\"t74\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:60px;line-height:60px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t76\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n"
					+ "<td width=\"600\" class=\"t75\" style=\"background-color:#FFFFFF;overflow:hidden;padding:60px 60px 60px 60px;border-radius:8px 8px 8px 8px;\">\r\n"
					+ "<![endif]-->\r\n" + "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t75\" style=\"background-color:#FFFFFF;overflow:hidden;width:480px;padding:60px 60px 60px 60px;border-radius:8px 8px 8px 8px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100% !important;\"><tr><td><div class=\"t1\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t3\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n"
					+ "<td width=\"480\" class=\"t2\" style=\"background-color:#F5F5DC;overflow:hidden;padding:8px 16px 8px 16px;border-radius:16px 16px 16px 16px;\">\r\n"
					+ "<![endif]-->\r\n" + "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t2\" style=\"background-color:#F5F5DC;overflow:hidden;width:448px;padding:8px 16px 8px 16px;border-radius:16px 16px 16px 16px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<h1 class=\"t0\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:700;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:center;mso-line-height-rule:exactly;mso-text-raise:1px;\">Transfer Report</h1></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t4\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t7\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t6\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t6\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t5\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Hello "
					+ data.get("name").toString() + "</p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t11\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t10\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t10\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t9\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Your report has been generated. Please check the <span class=\"t8\" style=\"margin:0;Margin:0;font-weight:700;font-style:italic;mso-line-height-rule:exactly;\">attached file</span> for a comprehensive overview of employee transfers.</p></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t14\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t16\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t15\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t15\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t13\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:-1px;\"><span class=\"t12\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Key Highlights</span></p></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t17\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t21\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t20\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t20\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t19\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t18\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Total transfers:</span> "
					+ summary.get("var_transferTotal").toString() + "</p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t25\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t24\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t24\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t23\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t22\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Pending Transfers:</span> "
					+ summary.get("var_transferPending").toString() + "</p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t29\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t28\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t28\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t27\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t26\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Approved Transfers:</span> "
					+ summary.get("var_transferApproved").toString() + "</p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t33\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t32\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t32\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t31\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t30\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Rejected Transfers:</span> "
					+ summary.get("var_transferRejected").toString() + "</p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t36\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t38\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t37\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t37\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t35\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t34\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">[Most Departures]</span></p></td>\r\n"
					+ "</tr></table>\r\n" + "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t43\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t42\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t42\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t41\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t39\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Project:</span><span class=\"t40\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_fromProjectMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t48\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t47\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t47\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t46\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t44\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Department:</span><span class=\"t45\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_fromDepartmentMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t53\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t52\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t52\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t51\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t49\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Location:</span><span class=\"t50\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_fromLocationMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t56\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t58\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t57\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t57\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t55\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t54\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">[Most Arrivals]</span></p></td>\r\n"
					+ "</tr></table>\r\n" + "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t63\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t62\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t62\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t61\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t59\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Project:</span><span class=\"t60\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_toProjectMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t68\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t67\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t67\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t66\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t64\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Department:</span><span class=\"t65\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_toDepartmentMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t73\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n" + "<!--[if mso]>\r\n" + "<td width=\"480\" class=\"t72\">\r\n" + "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n" + "<td class=\"t72\" style=\"width:480px;\">\r\n" + "<!--<![endif]-->\r\n"
					+ "<p class=\"t71\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t69\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Location:</span><span class=\"t70\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> "
					+ summary.get("var_toLocationMax").toString() + "</span></p></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr></table></td>\r\n" + "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t77\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:60px;line-height:60px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr></table></td></tr></table></div><div class=\"gmail-mobile-forced-width\" style=\"white-space: nowrap; font: 15px courier; line-height: 0;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n"
					+ "</div></body>\r\n" + "</html>";

			System.out.println("aaa");
			if(MailHelpers.send("vinhduc0304@gmail.com", mailTo, mailSubject, mailBody, csvFile)) {
				JOptionPane.showMessageDialog(null, "Report has been sent to your email.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}

//	========================= Generate Summary Info =============================
	private static int getColumnIndex(TableModel tableModel, String columnName) {
		for (int i = 0; i < tableModel.getColumnCount(); i++) {
			if (tableModel.getColumnName(i).equals(columnName)) {
				return i;
			}
		}
		return -1;
	}

	private static void incrementCount(Map<String, Integer> map, String key) {
		if (key != null && !key.trim().isEmpty() && !"-".equals(key.trim())) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
	}

	private static String getMostFrequentKey(Map<String, Integer> map) {
		return map.entrySet().stream().filter(entry -> entry.getValue() > 0) // Ensure there are valid entries
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("None");
	}

	public static Map<String, Object> generateSummary(TableModel tableModel) {
		Map<String, Object> summary = new HashMap<>();

		int totalRecords = tableModel.getRowCount();
		int pendingRecords = 0;
		int approvedRecords = 0;
		int rejectedRecords = 0;

		// Maps to track frequencies of projects, departments, and locations
		Map<String, Integer> fromProjectCount = new HashMap<>();
		Map<String, Integer> fromDepartmentCount = new HashMap<>();
		Map<String, Integer> fromLocationCount = new HashMap<>();
		Map<String, Integer> toProjectCount = new HashMap<>();
		Map<String, Integer> toDepartmentCount = new HashMap<>();
		Map<String, Integer> toLocationCount = new HashMap<>();

		int statusColumnIndex = getColumnIndex(tableModel, "Status");
		int fromProjectColumnIndex = getColumnIndex(tableModel, "From Project");
		int fromDepartmentColumnIndex = getColumnIndex(tableModel, "From Department");
		int fromLocationColumnIndex = getColumnIndex(tableModel, "From Location");
		int toProjectColumnIndex = getColumnIndex(tableModel, "To Project");
		int toDepartmentColumnIndex = getColumnIndex(tableModel, "To Department");
		int toLocationColumnIndex = getColumnIndex(tableModel, "To Location");

		if (statusColumnIndex == -1 || fromProjectColumnIndex == -1 || fromDepartmentColumnIndex == -1
				|| fromLocationColumnIndex == -1 || toProjectColumnIndex == -1 || toDepartmentColumnIndex == -1
				|| toLocationColumnIndex == -1) {
			throw new IllegalArgumentException("One or more required columns are missing.");
		}

		// Process each row
		for (int i = 0; i < totalRecords; i++) {
			String status = (String) tableModel.getValueAt(i, statusColumnIndex);
			String fromProject = (String) tableModel.getValueAt(i, fromProjectColumnIndex);
			String fromDepartment = (String) tableModel.getValueAt(i, fromDepartmentColumnIndex);
			String fromLocation = (String) tableModel.getValueAt(i, fromLocationColumnIndex);
			String toProject = (String) tableModel.getValueAt(i, toProjectColumnIndex);
			String toDepartment = (String) tableModel.getValueAt(i, toDepartmentColumnIndex);
			String toLocation = (String) tableModel.getValueAt(i, toLocationColumnIndex);

			// Count records by status
			if ("Pending".equalsIgnoreCase(status)) {
				pendingRecords++;
			} else if ("Approved".equalsIgnoreCase(status)) {
				approvedRecords++;
			} else if ("Rejected".equalsIgnoreCase(status)) {
				rejectedRecords++;
			}

			// Count occurrences of projects, departments, and locations
			incrementCount(fromProjectCount, fromProject);
			incrementCount(fromDepartmentCount, fromDepartment);
			incrementCount(fromLocationCount, fromLocation);
			incrementCount(toProjectCount, toProject);
			incrementCount(toDepartmentCount, toDepartment);
			incrementCount(toLocationCount, toLocation);
		}

		// Find the most frequent projects, departments, and locations
		String mostFrequentFromProject = getMostFrequentKey(fromProjectCount);
		String mostFrequentFromDepartment = getMostFrequentKey(fromDepartmentCount);
		String mostFrequentFromLocation = getMostFrequentKey(fromLocationCount);
		String mostFrequentToProject = getMostFrequentKey(toProjectCount);
		String mostFrequentToDepartment = getMostFrequentKey(toDepartmentCount);
		String mostFrequentToLocation = getMostFrequentKey(toLocationCount);

		// Populate the summary map
		summary.put("var_transferTotal", totalRecords);
		summary.put("var_transferPending", pendingRecords);
		summary.put("var_transferApproved", approvedRecords);
		summary.put("var_transferRejected", rejectedRecords);

		summary.put("var_fromProjectMax", mostFrequentFromProject);
		summary.put("var_fromDepartmentMax", mostFrequentFromDepartment);
		summary.put("var_fromLocationMax", mostFrequentFromLocation);

		summary.put("var_toProjectMax", mostFrequentToProject);
		summary.put("var_toDepartmentMax", mostFrequentToDepartment);
		summary.put("var_toLocationMax", mostFrequentToLocation);

		return summary;
	}

	protected void do_jbuttonFirstPage_actionPerformed(ActionEvent e) {
		currentPageIndex = 1;
		initFilterAndButton();
	}

	protected void do_jbuttonPreviousPage_actionPerformed(ActionEvent e) {
		currentPageIndex -= 1;
		initFilterAndButton();
	}

	protected void do_jbuttonNextPage_actionPerformed(ActionEvent e) {
		currentPageIndex += 1;
		initFilterAndButton();
	}

	protected void do_jbuttonLastPage_actionPerformed(ActionEvent e) {
		currentPageIndex = maxPageIndex;
		initFilterAndButton();
	}

//	private void loadData() {
//		jtableTransferRecord.setModel(recordTableModel);
//		BookModel bookModel = new BookModel();
//		table.setRowSorter(sorter);
//		for (Book book : bookModel.findAll()) {
//			model.addRow(new Object[] { book.getId(), book.getName(), book.getTitle() });
//		}
//		int rowCount = model.getRowCount();
//		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
//		maxPageIndex = rowCount / itemsPerPage + v;
//		initFilterAndButton();
//		label.setText(String.format("/ %d", maxPageIndex));
//	}

	protected void do_jtextFieldCurrentPage_actionPerformed(ActionEvent e) {
		try {
			int v = Integer.parseInt(jtextFieldCurrentPage.getText());
			if (v > 0 && v <= maxPageIndex) {
				currentPageIndex = v;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		initFilterAndButton();
	}

	private void initFilterAndButton() {
		sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}
		});
		jbuttonFirstPage.setEnabled(currentPageIndex > 1);
		jbuttonPreviousPage.setEnabled(currentPageIndex > 1);
		jbuttonNextPage.setEnabled(currentPageIndex < maxPageIndex);
		jtextFieldCurrentPage.setText(Integer.toString(currentPageIndex));
	}

	
}
