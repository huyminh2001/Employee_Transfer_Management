package jpanels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.crypto.Data;
import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.Department;
import entities.Employee;
import entities.Location;
import entities.Projects;
import entities.Role;
import jdialogs.JDialogUpdateEmployeeRecord;
import jdialogs.JDialogUpdateEmployeeRecord.UpdateEmployeeRespone;
import models.DepartmentModel;
import models.EmployeeModel;
import models.LocationModel;
import models.ProjectsModel;
import models.RoleModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class JpanelEmployeeProfile extends JPanel {

	private final int itemsPerPage = 25;

	private int maxPageIndex;

	private int currentPageIndex = 1;

	DefaultTableModel employeeModelTable = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(employeeModelTable);

	private static final long serialVersionUID = 1L;
	private JTable jtableEmployee;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldManagerName;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JComboBox jcomboBoxEmployeeRole;
	private JComboBox jcomboBoxCurrentProject;
	private JComboBox jcomboBoxCurrentDepartment;
	private JComboBox jcomboBoxCurrentLocation;
	private JDateChooser jdateChooserJoiningDateFrom;
	private JDateChooser jdateChooserJoiningDateTo;
//	private JPopupMenu jpopupMenuEditEmployee;
	private JButton jbuttonFirstPage;
	private JTextField jtextFieldCurrentPage;
	private JLabel jlabelTotalPage;
	private JButton jbuttonNextPage;
	private JButton jbuttonLastPage;
	private JButton jbuttonPreviousPage;
	private JPopupMenu jpopupMenuEditEmployee;
	private JMenuItem jMenuItemEditEmployee;
	private Map<String, Object> data;

	/**
	 * Create the panel.
	 */
	public JpanelEmployeeProfile() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		lblNewLabel_10 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 1;
		add(lblNewLabel_10, gbc_lblNewLabel_10);

		JPanel jpanelEmployeeFilter = new JPanel();
		jpanelEmployeeFilter.setBorder(new TitledBorder(null, "Profile Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpanelEmployeeFilter = new GridBagConstraints();
		gbc_jpanelEmployeeFilter.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelEmployeeFilter.fill = GridBagConstraints.VERTICAL;
		gbc_jpanelEmployeeFilter.gridx = 2;
		gbc_jpanelEmployeeFilter.gridy = 1;
		add(jpanelEmployeeFilter, gbc_jpanelEmployeeFilter);
		GridBagLayout gbl_jpanelEmployeeFilter = new GridBagLayout();
		gbl_jpanelEmployeeFilter.columnWidths = new int[] { 267, 231, 273, 0 };
		gbl_jpanelEmployeeFilter.rowHeights = new int[] { 103, 0 };
		gbl_jpanelEmployeeFilter.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_jpanelEmployeeFilter.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		jpanelEmployeeFilter.setLayout(gbl_jpanelEmployeeFilter);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		jpanelEmployeeFilter.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Employee Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jtextFieldEmployeeName = new JTextField();
		jtextFieldEmployeeName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldEmployeeName_keyReleased(e);
			}
		});
//		jtextFieldEmployeeName.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				do_jtextFieldEmployeeName_keyPressed(e);
//			}
//		});
		GridBagConstraints gbc_jtextFieldEmployeeName = new GridBagConstraints();
		gbc_jtextFieldEmployeeName.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldEmployeeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldEmployeeName.gridx = 1;
		gbc_jtextFieldEmployeeName.gridy = 0;
		panel.add(jtextFieldEmployeeName, gbc_jtextFieldEmployeeName);
		jtextFieldEmployeeName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Employee Manager");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtextFieldManagerName = new JTextField();
		jtextFieldManagerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldManagerName_keyReleased(e);
			}
		});
//		jtextFieldManagerName.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				do_jtextFieldManagerName_keyPressed(e);
//			}
//		});
		GridBagConstraints gbc_jtextFieldManagerName = new GridBagConstraints();
		gbc_jtextFieldManagerName.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldManagerName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldManagerName.gridx = 1;
		gbc_jtextFieldManagerName.gridy = 1;
		panel.add(jtextFieldManagerName, gbc_jtextFieldManagerName);
		jtextFieldManagerName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtextFieldEmail = new JTextField();
		jtextFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldEmail_keyReleased(e);
			}
		});
//		jtextFieldEmail.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				do_jtextFieldEmail_keyPressed(e);
//			}
//		});

		GridBagConstraints gbc_jtextFieldEmail = new GridBagConstraints();
		gbc_jtextFieldEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldEmail.gridx = 1;
		gbc_jtextFieldEmail.gridy = 2;
		panel.add(jtextFieldEmail, gbc_jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Username");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				do_jtextFieldUsername_keyReleased(e);
			}
		});
//		jtextFieldUsername.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				do_jtextFieldUsername_keyPressed(e);
//			}
//		});

		GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
		gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldUsername.gridx = 1;
		gbc_jtextFieldUsername.gridy = 3;
		panel.add(jtextFieldUsername, gbc_jtextFieldUsername);
		jtextFieldUsername.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		jpanelEmployeeFilter.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_4 = new JLabel("Role");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcomboBoxEmployeeRole = new JComboBox();
		jcomboBoxEmployeeRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxEmployeeRole_actionPerformed(e);
			}
		});

		GridBagConstraints gbc_jcomboBoxEmployeeRole = new GridBagConstraints();
		gbc_jcomboBoxEmployeeRole.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxEmployeeRole.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxEmployeeRole.gridx = 1;
		gbc_jcomboBoxEmployeeRole.gridy = 0;
		panel_1.add(jcomboBoxEmployeeRole, gbc_jcomboBoxEmployeeRole);

		JLabel lblNewLabel_5 = new JLabel("Current Project");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jcomboBoxCurrentProject = new JComboBox();
		jcomboBoxCurrentProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxCurrentProject_actionPerformed(e);
			}
		});

		GridBagConstraints gbc_jcomboBoxCurrentProject = new GridBagConstraints();
		gbc_jcomboBoxCurrentProject.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxCurrentProject.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxCurrentProject.gridx = 1;
		gbc_jcomboBoxCurrentProject.gridy = 1;
		panel_1.add(jcomboBoxCurrentProject, gbc_jcomboBoxCurrentProject);

		JLabel lblNewLabel_6 = new JLabel("Current Department");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jcomboBoxCurrentDepartment = new JComboBox();
		jcomboBoxCurrentDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxCurrentDepartment_actionPerformed(e);
			}
		});

		GridBagConstraints gbc_jcomboBoxCurrentDepartment = new GridBagConstraints();
		gbc_jcomboBoxCurrentDepartment.insets = new Insets(0, 0, 5, 0);
		gbc_jcomboBoxCurrentDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxCurrentDepartment.gridx = 1;
		gbc_jcomboBoxCurrentDepartment.gridy = 2;
		panel_1.add(jcomboBoxCurrentDepartment, gbc_jcomboBoxCurrentDepartment);

		JLabel lblNewLabel_7 = new JLabel("Current Location");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 3;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jcomboBoxCurrentLocation = new JComboBox();
		jcomboBoxCurrentLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxCurrentLocation_actionPerformed(e);
			}
		});

		GridBagConstraints gbc_jcomboBoxCurrentLocation = new GridBagConstraints();
		gbc_jcomboBoxCurrentLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxCurrentLocation.gridx = 1;
		gbc_jcomboBoxCurrentLocation.gridy = 3;
		panel_1.add(jcomboBoxCurrentLocation, gbc_jcomboBoxCurrentLocation);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		jpanelEmployeeFilter.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 30, 28, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);
		
				JLabel lblNewLabel_8 = new JLabel("Joining Date From");
				GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
				gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_8.gridx = 0;
				gbc_lblNewLabel_8.gridy = 0;
				panel_2.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
				jdateChooserJoiningDateFrom = new JDateChooser();
				jdateChooserJoiningDateFrom.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						do_jdateChooserJoiningDateFrom_propertyChange(evt);
					}
				});
				GridBagConstraints gbc_jdateChooserJoiningDateFrom = new GridBagConstraints();
				gbc_jdateChooserJoiningDateFrom.insets = new Insets(0, 0, 5, 0);
				gbc_jdateChooserJoiningDateFrom.fill = GridBagConstraints.BOTH;
				gbc_jdateChooserJoiningDateFrom.gridx = 1;
				gbc_jdateChooserJoiningDateFrom.gridy = 0;
				panel_2.add(jdateChooserJoiningDateFrom, gbc_jdateChooserJoiningDateFrom);
		
				JLabel lblNewLabel_9 = new JLabel("Joining Date To");
				GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
				gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_9.gridx = 0;
				gbc_lblNewLabel_9.gridy = 1;
				panel_2.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
				jdateChooserJoiningDateTo = new JDateChooser();
				jdateChooserJoiningDateTo.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						do_jdateChooserJoiningDateTo_propertyChange(evt);
					}
				});
				GridBagConstraints gbc_jdateChooserJoiningDateTo = new GridBagConstraints();
				gbc_jdateChooserJoiningDateTo.insets = new Insets(0, 0, 5, 0);
				gbc_jdateChooserJoiningDateTo.fill = GridBagConstraints.BOTH;
				gbc_jdateChooserJoiningDateTo.gridx = 1;
				gbc_jdateChooserJoiningDateTo.gridy = 1;
				panel_2.add(jdateChooserJoiningDateTo, gbc_jdateChooserJoiningDateTo);
		
		jbuttonResetFilter = new JButton("Reset Filter");
		jbuttonResetFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonResetFilter_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jbuttonResetFilter = new GridBagConstraints();
		gbc_jbuttonResetFilter.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonResetFilter.gridx = 1;
		gbc_jbuttonResetFilter.gridy = 2;
		panel_2.add(jbuttonResetFilter, gbc_jbuttonResetFilter);

		JScrollPane jscrollPaneEmplyee = new JScrollPane();
		
		jpopupMenuEditEmployee = new JPopupMenu();
		addPopup(jscrollPaneEmplyee, jpopupMenuEditEmployee);
		
		jMenuItemEditEmployee = new JMenuItem("Edit");
		jMenuItemEditEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jMenuItemEditEmployee_actionPerformed(e);
			}
		});
		
		lblNewLabel_11 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 3;
		gbc_lblNewLabel_11.gridy = 1;
		add(lblNewLabel_11, gbc_lblNewLabel_11);
		jpopupMenuEditEmployee.add(jMenuItemEditEmployee);

//		jpopupMenuEditEmployee = new JPopupMenu();
//		addPopup(jscrollPaneEmplyee, jpopupMenuEditEmployee);
//		
//		JMenuItem jMenuItemEditEmployee = new JMenuItem("Edit");
//		jMenuItemEditEmployee.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				do_jMenuItemEditEmployee_actionPerformed(e);
//			}
//		});

//		jpopupMenuEditEmployee.add(jMenuItemEditEmployee);

		GridBagConstraints gbc_jscrollPaneEmplyee = new GridBagConstraints();
		gbc_jscrollPaneEmplyee.insets = new Insets(0, 0, 5, 5);
		gbc_jscrollPaneEmplyee.fill = GridBagConstraints.BOTH;
		gbc_jscrollPaneEmplyee.gridx = 2;
		gbc_jscrollPaneEmplyee.gridy = 3;
		add(jscrollPaneEmplyee, gbc_jscrollPaneEmplyee);

		jtableEmployee = new JTable();
		jscrollPaneEmplyee.setViewportView(jtableEmployee);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 4;
		add(panel_3, gbc_panel_3);

		jbuttonFirstPage = new JButton("|<");
		jbuttonFirstPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonFirstPage_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonFirstPage);

		jbuttonPreviousPage = new JButton("<");
		jbuttonPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonPreviousPage_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonPreviousPage);

		jtextFieldCurrentPage = new JTextField();
		jtextFieldCurrentPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jtextFieldCurrentPage_actionPerformed(e);
			}
		});
		panel_3.add(jtextFieldCurrentPage);
		jtextFieldCurrentPage.setColumns(10);

		jlabelTotalPage = new JLabel("/ 0");
		panel_3.add(jlabelTotalPage);

		jbuttonNextPage = new JButton(">");
		jbuttonNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonNextPage_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonNextPage);

		jbuttonLastPage = new JButton(">|");
		jbuttonLastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonLastPage_actionPerformed(e);
			}
		});
		panel_3.add(jbuttonLastPage);

		

	}
	
	private int cornerRadius = 20;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton jbuttonResetFilter;
//  private Color borderColor = Color.RED; // Border color

	public JpanelEmployeeProfile(Map<String, Object> data) {
		this();
		this.data = data;
		initJPanel();
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Fill the rounded rectangle with the current background color (default)
		g2d.setColor(getBackground());
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
		
//		g2d.setColor(borderColor);
//      g2d.drawRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
	}

	private void initJPanel() {
		EmployeeModel employeeModel = new EmployeeModel();
		fillDataToJTableEmployee(employeeModel.findAll());
		jcomboBoxEmployeeRole();
		jcomboBoxCurrentProject();
		jcomboBoxCurrentDepartment();
		jcomboBoxCurrentLocation();
		this.setOpaque(false);
	}

	private void fillDataToJTableEmployee(List<Employee> employees) {
		jtableEmployee.setModel(employeeModelTable);
		employeeModelTable.setRowCount(0);

		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		EmployeeModel employeeModel = new EmployeeModel();
		LocationModel locationModel = new LocationModel();
		DepartmentModel departmentModel = new DepartmentModel();
		ProjectsModel projectsModel = new ProjectsModel();

		jtableEmployee.setRowSorter(sorter);

		// pagination
//		DefaultTableModel employeeModelTable = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};

		employeeModelTable.addColumn("ID");
		employeeModelTable.addColumn("Name");
		employeeModelTable.addColumn("Manager");
		employeeModelTable.addColumn("Role");
		employeeModelTable.addColumn("Email");
		employeeModelTable.addColumn("Username");
		employeeModelTable.addColumn("Current Project");
		employeeModelTable.addColumn("Current Department");
		employeeModelTable.addColumn("Current Location");
		employeeModelTable.addColumn("Joining Date");

		Map<Integer, Employee> employeeManager = new HashMap<>();
		for (Employee employee : employees) {
			if (employee.getManagerId() != null && employee.getManagerId() > 0
					&& !employeeManager.containsKey(employee.getManagerId())) {
				employeeManager.put(employee.getManagerId(), employeeModel.findById(employee.getManagerId()));
			}
		}

		for (Employee employee : employees) {
			Employee manager = employeeManager.get(employee.getManagerId());

			employeeModelTable.addRow(new Object[] { employee.getId(), employee.getName(),
//					employeeModel.findById(employee.getManagerId()).getName(),
					manager != null ? employeeModel.findById(employee.getManagerId()).getName() : "-",
					employee.getRoleId() == 1 ? "Admin" : "Employee", employee.getEmail(), employee.getUsername(),
					projectsModel.findById(employee.getCurrentProject()).getName(),
					departmentModel.findById(employee.getCurrentDepartment()).getName(),
					locationModel.findById(employee.getCurrentLocation()).getName(),
					sp.format(employee.getJoiningDate()) });
		}
//		jtableEmployee.setModel(employeeModelTable);
		jtableEmployee.getTableHeader().setReorderingAllowed(false);
		jtableEmployee.setComponentPopupMenu(jpopupMenuEditEmployee); //**modongnay

		jtableEmployee.setAutoCreateColumnsFromModel(false);

		int rowCount = employeeModelTable.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		jlabelTotalPage.setText(String.format("/ %d", maxPageIndex));
	}

	private void jcomboBoxEmployeeRole() {
		RoleModel roleModel = new RoleModel();
		DefaultComboBoxModel<Role> roleBoxModel = new DefaultComboBoxModel<>();
		roleBoxModel.addElement(new Role(-1, "All"));
		for (Role role : roleModel.findAll()) {
			roleBoxModel.addElement(role);
		}
		jcomboBoxEmployeeRole.setModel(roleBoxModel);
		jcomboBoxEmployeeRole.setRenderer(new RoleCellRender());
	}

	private void jcomboBoxCurrentProject() {
		ProjectsModel projectsModel = new ProjectsModel();
		DefaultComboBoxModel<Projects> projectsBoxModel = new DefaultComboBoxModel<>();
		projectsBoxModel.addElement(new Projects(-1, "All"));
		for (Projects project : projectsModel.findAll()) {
			projectsBoxModel.addElement(project);
		}
		jcomboBoxCurrentProject.setModel(projectsBoxModel);
		jcomboBoxCurrentProject.setRenderer(new ProjectCellRender());
	}

	private void jcomboBoxCurrentDepartment() {
		DepartmentModel departmentModel = new DepartmentModel();
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		departmentBoxModel.addElement(new Department(-1, "All"));
		for (Department project : departmentModel.findAll()) {
			departmentBoxModel.addElement(project);
		}
		jcomboBoxCurrentDepartment.setModel(departmentBoxModel);
		jcomboBoxCurrentDepartment.setRenderer(new DepartmentCellRender());
	}

	private void jcomboBoxCurrentLocation() {
		LocationModel locationModel = new LocationModel();
		DefaultComboBoxModel<Location> locationBoxModel = new DefaultComboBoxModel<>();
		locationBoxModel.addElement(new Location(-1, "All"));
		for (Location location : locationModel.findAll()) {
			locationBoxModel.addElement(location);
		}
		jcomboBoxCurrentLocation.setModel(locationBoxModel);
		jcomboBoxCurrentLocation.setRenderer(new LocationCellRender());

	}

//	protected void do_jtextFieldEmployeeName_keyPressed(KeyEvent e) {
//		employeeFiltering();
//	} @@

//	protected void do_jtextFieldManagerName_keyPressed(KeyEvent e) {
//		employeeFiltering();
//	} @@
//	
//	protected void do_jtextFieldEmail_keyPressed(KeyEvent e) {
//		employeeFiltering();
//	} @@
//	
//	protected void do_jtextFieldUsername_keyPressed(KeyEvent e) {
//		employeeFiltering();
//	} @@
//	
	protected void do_jcomboBoxEmployeeRole_actionPerformed(ActionEvent e) {
		employeeFiltering();
	}
	
	protected void do_jcomboBoxCurrentProject_actionPerformed(ActionEvent e) {
		employeeFiltering();
	}
	
	protected void do_jcomboBoxCurrentDepartment_actionPerformed(ActionEvent e) {
		employeeFiltering();
	}
	
	protected void do_jcomboBoxCurrentLocation_actionPerformed(ActionEvent e) {
		employeeFiltering();
	}
	
	protected void do_jdateChooserJoiningDateFrom_propertyChange(PropertyChangeEvent evt) {
		if(jdateChooserJoiningDateFrom.getDate() != null) {
			employeeFiltering();
		}
		
	}
	
	protected void do_jdateChooserJoiningDateTo_propertyChange(PropertyChangeEvent evt) {
		if(jdateChooserJoiningDateTo.getDate() != null) {
			employeeFiltering();
		}
	}

	protected void do_jbuttonResetFilter_actionPerformed(ActionEvent e) {
		EmployeeModel employeeModel = new EmployeeModel();
		jtextFieldEmployeeName.setText("");
		jtextFieldManagerName.setText("");
		jtextFieldEmail.setText("");
		jtextFieldUsername.setText("");
		jcomboBoxEmployeeRole.getModel().setSelectedItem(new Role(-1, "All"));
		jcomboBoxCurrentProject.getModel().setSelectedItem(new Projects(-1, "All"));
		jcomboBoxCurrentDepartment.getModel().setSelectedItem(new Department(-1, "All"));
		jcomboBoxCurrentLocation.getModel().setSelectedItem(new Location(-1, "All"));
		fillDataToJTableEmployee(employeeModel.findAll());
	}
//	private void employeeFiltering() {
//		EmployeeModel employeeModel = new EmployeeModel();
//		String employeeName = jtextFieldEmployeeName.getText();
//		String managerName = jtextFieldManagerName.getText();
//		Integer managerId = (managerName != null && !managerName.isEmpty())
//				? employeeModel.getEmployeeManagerId(managerName)
//				: null;
//		System.out.println("Manager ID: " + managerId);
//
//		String email = jtextFieldEmail.getText();
//		String username = jtextFieldUsername.getText();
//
//		Role role = (Role) jcomboBoxEmployeeRole.getSelectedItem();
//		Projects currentProject = (Projects) jcomboBoxCurrentProject.getSelectedItem();
//		Department currentDepartment = (Department) jcomboBoxCurrentDepartment.getSelectedItem();
//		Location currentLocation = (Location) jcomboBoxCurrentLocation.getSelectedItem();
//
//		Date joiningDateFrom = jdateChooserJoiningDateFrom.getDate();
//		Date joiningDateTo = jdateChooserJoiningDateTo.getDate();
//
//		SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
//		String joiningDateFromParameter = (joiningDateFrom != null) ? spDate.format(joiningDateFrom) : null;
//		String joiningDateToParameter = (joiningDateTo != null) ? spDate.format(joiningDateTo) : null;
//
//		String roleName = (role != null) ? role.getName() : "";
//		String currentProjectName = (currentProject != null) ? currentProject.getName() : "";
//		String currentDepartmentName = (currentDepartment != null) ? currentDepartment.getName() : "";
//		String currentLocationName = (currentLocation != null) ? currentLocation.getName() : "";
//
//		fillDataToJTableEmployee(
//				employeeModel.filterEmployee(employeeName, managerId, email, username, roleName, currentProjectName,
//						currentDepartmentName, currentLocationName, joiningDateFromParameter, joiningDateToParameter));
//		
//		currentPageIndex = 1;
//	}
	
	private void employeeFiltering() {
		EmployeeModel employeeModel = new EmployeeModel();
		String employeeName = jtextFieldEmployeeName.getText();
		String managerName = jtextFieldManagerName.getText();
//		Integer managerId = (managerName != null && !managerName.isEmpty()) ? employeeModel.getEmployeeManagerId(managerName) : null;
		Integer managerId = (managerName != null && !managerName.isEmpty()) ? employeeModel.getEmployeeId(managerName) : null;
		System.out.println("Manager ID: " + managerId);
		
		String email = jtextFieldEmail.getText();
		String username = jtextFieldUsername.getText();
		
		Role role = (Role) jcomboBoxEmployeeRole.getSelectedItem();
		Projects currentProject = (Projects) jcomboBoxCurrentProject.getSelectedItem();
		Department currentDepartment = (Department) jcomboBoxCurrentDepartment.getSelectedItem();
		Location currentLocation = (Location) jcomboBoxCurrentLocation.getSelectedItem();
		
		Date joiningDateFrom = jdateChooserJoiningDateFrom.getDate();
		Date joiningDateTo = jdateChooserJoiningDateTo.getDate();
		
		SimpleDateFormat spDate = new SimpleDateFormat("yyyy-MM-dd");
		String joiningDateFromParameter = (joiningDateFrom != null) ? spDate.format(joiningDateFrom) : null;
		String joiningDateToParameter = (joiningDateTo != null) ? spDate.format(joiningDateTo) : null;
		
		
		int roleId = role.getId();
		int currentProjectId = currentProject.getId();
		int currentDepartmentId = currentDepartment.getId();
		int currentLocationId = currentLocation.getId();
		
//		String roleName =  role.getName() ;
//		System.out.println("Role name: " + roleName);
//	    String currentProjectName =  currentProject.getName() ;
//	    String currentDepartmentName =  currentDepartment.getName() ;
//	    String currentLocationName =  currentLocation.getName() ;
	    
		fillDataToJTableEmployee(employeeModel.filterEmployee(employeeName, managerName,
															  email, username,  roleId, 
															  currentProjectId, currentDepartmentId, 
															  currentLocationId, joiningDateFromParameter, joiningDateToParameter));
		
		currentPageIndex = 1;
	}

	private class RoleCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Role role = (Role) value;
			return super.getListCellRendererComponent(list, role.getName(), index, isSelected, cellHasFocus);
		}

	}

	private class ProjectCellRender extends DefaultListCellRenderer {

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

	protected void do_jtextFieldCurrentPage_actionPerformed(ActionEvent e) {
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

	// =======================
	protected void do_jtextFieldEmployeeName_keyReleased(KeyEvent e) {
		employeeFiltering();
	}

	protected void do_jtextFieldManagerName_keyReleased(KeyEvent e) {
		employeeFiltering();
	}
	
	// =======================
	protected void do_jtextFieldEmail_keyReleased(KeyEvent e) {
		employeeFiltering();
	}
	protected void do_jtextFieldUsername_keyReleased(KeyEvent e) {
		employeeFiltering();
	}
	
	protected void do_jMenuItemEditEmployee_actionPerformed(ActionEvent e) {
		int selectedRow = jtableEmployee.getSelectedRow();
		int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
		EmployeeModel employeeModel = new EmployeeModel();
		Employee employee = employeeModel.findById(id);
		Map<String, Object> employeeData = new HashMap<>();
		employeeData.put("employee", employee);
		
		JDialogUpdateEmployeeRecord jDialogUpdateEmployeeRecord = new JDialogUpdateEmployeeRecord(new UpdateEmployeeResult() , employeeData);
		jDialogUpdateEmployeeRecord.setVisible(true);
	}
	
	private class UpdateEmployeeResult implements UpdateEmployeeRespone{
		
		@Override
		public boolean getValue(Employee employee) {
			
			EmployeeModel employeeModel = new EmployeeModel();
		    boolean updateSuccess;
		    int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
			    if (employee.getManagerId() == null) {
			        updateSuccess = employeeModel.updateManagerNull(employee);
			    } else {
			        updateSuccess = employeeModel.update(employee);
			    }
			    
			    // Show appropriate message based on update success
			    String message = updateSuccess ? "Update employee record success" : "Update employee record failed";
			    int messageType = updateSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
			    
			    JOptionPane.showMessageDialog(null, message, "Result", messageType);
			    
			   
			    if (updateSuccess) {
			        fillDataToJTableEmployee(employeeModel.findAll());
			        data.put("name", employee.getName());
			        data.put("email", employee.getEmail());
			        data.put("username", employee.getUsername());
			        return true;
			    }
			}
			return false;
		}
		
	}
	
}