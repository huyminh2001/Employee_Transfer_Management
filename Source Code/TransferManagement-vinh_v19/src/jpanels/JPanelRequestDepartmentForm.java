package jpanels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.Department;
import entities.Employee;
import entities.Projects;
import entities.Records;
import helpers.MailHelpers;
import models.DepartmentModel;
import models.EmployeeModel;
import models.ProjectsModel;
import models.RecordModel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JPanelRequestDepartmentForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldEmployeeName;
	private JTextField jtextFieldFromDepartment;
	private JComboBox jcomboBoxRequestFor;
	private JComboBox jcomboBoxToDepartment;
	private JDateChooser jdateChooserLeaving;
	private JDateChooser jdateChooserJoining;
	private Map<String, Object> data;
	/**
	 * Create the panel.
	 */
	public JPanelRequestDepartmentForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Request Department Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtextFieldEmployeeName = new JTextField();
		jtextFieldEmployeeName.setEditable(false);
		GridBagConstraints gbc_jtextFieldEmployeeName = new GridBagConstraints();
		gbc_jtextFieldEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_jtextFieldEmployeeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldEmployeeName.gridx = 2;
		gbc_jtextFieldEmployeeName.gridy = 2;
		add(jtextFieldEmployeeName, gbc_jtextFieldEmployeeName);
		jtextFieldEmployeeName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Request For");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcomboBoxRequestFor = new JComboBox();
		jcomboBoxRequestFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jcomboBoxRequestFor_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jcomboBoxRequestFor = new GridBagConstraints();
		gbc_jcomboBoxRequestFor.insets = new Insets(0, 0, 5, 5);
		gbc_jcomboBoxRequestFor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxRequestFor.gridx = 2;
		gbc_jcomboBoxRequestFor.gridy = 3;
		add(jcomboBoxRequestFor, gbc_jcomboBoxRequestFor);
		
		JLabel lblNewLabel_3 = new JLabel("From Department");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtextFieldFromDepartment = new JTextField();
		jtextFieldFromDepartment.setEditable(false);
		GridBagConstraints gbc_jtextFieldFromDepartment = new GridBagConstraints();
		gbc_jtextFieldFromDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_jtextFieldFromDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldFromDepartment.gridx = 2;
		gbc_jtextFieldFromDepartment.gridy = 4;
		add(jtextFieldFromDepartment, gbc_jtextFieldFromDepartment);
		jtextFieldFromDepartment.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("To Department");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcomboBoxToDepartment = new JComboBox();
		GridBagConstraints gbc_jcomboBoxToDepartment = new GridBagConstraints();
		gbc_jcomboBoxToDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_jcomboBoxToDepartment.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcomboBoxToDepartment.gridx = 2;
		gbc_jcomboBoxToDepartment.gridy = 5;
		add(jcomboBoxToDepartment, gbc_jcomboBoxToDepartment);
		
		JLabel lblNewLabel_5 = new JLabel("Leaving Date");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jdateChooserLeaving = new JDateChooser();
		jdateChooserLeaving.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_jdateChooserLeaving_propertyChange(evt);
			}
		});
		GridBagConstraints gbc_jdateChooserLeaving = new GridBagConstraints();
		gbc_jdateChooserLeaving.insets = new Insets(0, 0, 5, 5);
		gbc_jdateChooserLeaving.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserLeaving.gridx = 2;
		gbc_jdateChooserLeaving.gridy = 6;
		add(jdateChooserLeaving, gbc_jdateChooserLeaving);
		
		JLabel lblNewLabel_6 = new JLabel("Joining Date");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jdateChooserJoining = new JDateChooser();
		GridBagConstraints gbc_jdateChooserJoining = new GridBagConstraints();
		gbc_jdateChooserJoining.insets = new Insets(0, 0, 5, 5);
		gbc_jdateChooserJoining.fill = GridBagConstraints.BOTH;
		gbc_jdateChooserJoining.gridx = 2;
		gbc_jdateChooserJoining.gridy = 7;
		add(jdateChooserJoining, gbc_jdateChooserJoining);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		
		JButton jbuttonRequest = new JButton("Make Request");
		panel.add(jbuttonRequest);
		jbuttonRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonRequest_actionPerformed(e);
			}
		});

	}
	
	private int cornerRadius = 20;
//  private Color borderColor = Color.RED; // Border color

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
	
	public JPanelRequestDepartmentForm(Map<String, Object> data) {
		this();
		this.data = data;
		requestDepartmentRender();
		jcomboBoxRequestFor();
		jcomboBoxDepartmentTo();
		this.setOpaque(false);
	}
	
	private void jcomboBoxRequestFor() {
		EmployeeModel employeeModel = new EmployeeModel();
		DefaultComboBoxModel<Employee> requestForBoxModel = new DefaultComboBoxModel<>();
		int managerId = Integer.parseInt(data.get("id").toString());
		int employeeId = Integer.parseInt(data.get("id").toString());
		for(Employee employee : employeeModel.getManagedEmployees(managerId,employeeId)) {
			requestForBoxModel.addElement(employee);
		}
		jcomboBoxRequestFor.setModel(requestForBoxModel);
		jcomboBoxRequestFor.setRenderer(new RequestForCellRender());
	}
	
	private void jcomboBoxDepartmentTo() {
		DepartmentModel departmentModel = new DepartmentModel();
		EmployeeModel employeeModel = new EmployeeModel();
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		int currentEmployeeDepartment = employeeModel.getCurrentDepartment(Integer.parseInt(data.get("id").toString()));
		for(Department department : departmentModel.exclusiveCurrentDepartment(currentEmployeeDepartment)) {
			departmentBoxModel.addElement(department);
		}
		jcomboBoxToDepartment.setModel(departmentBoxModel);
		jcomboBoxToDepartment.setRenderer(new DepartmentToCellRender());
	}
	
	private void requestDepartmentRender() {
		EmployeeModel employeeModel = new EmployeeModel();
		DepartmentModel departmentModel = new DepartmentModel();
		String employeeName = data.get("name").toString();
		jtextFieldEmployeeName.setText(employeeName);
		
		String fromDepartment = String.valueOf(departmentModel.findById(Integer.parseInt(data.get("departmentId").toString())).getName());
		jtextFieldFromDepartment.setText(fromDepartment);
		
		Calendar today = Calendar.getInstance();
        jdateChooserLeaving.setMinSelectableDate(today.getTime());
        jdateChooserJoining.setMinSelectableDate(today.getTime());
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
	protected void do_jbuttonRequest_actionPerformed(ActionEvent e) {
		Records record = new Records();		
		EmployeeModel employeeModel = new EmployeeModel();
		DepartmentModel departmentModel = new DepartmentModel();

		String employeeName = data.get("name").toString();
		jtextFieldEmployeeName.setText(employeeName);
		
		String fromDepartment = String.valueOf(departmentModel.findById(Integer.parseInt(data.get("departmentId").toString())).getName());
		jtextFieldFromDepartment.setText(fromDepartment);
		
		
		int employeeId = Integer.parseInt(data.get("id").toString());
		int departmentFrom = Integer.parseInt(data.get("departmentId").toString());
		Employee requestFor = (Employee) jcomboBoxRequestFor.getSelectedItem();
		Department toDepartment = (Department) jcomboBoxToDepartment.getSelectedItem();
		
		Date leavingDate = (Date) jdateChooserLeaving.getDate();
		if(leavingDate == null) {
			JOptionPane.showMessageDialog(null, "Please enter a leaving date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!(leavingDate instanceof Date)) {
			JOptionPane.showMessageDialog(null, "Please enter a proper leaving date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Date joiningDate = (Date) jdateChooserJoining.getDate();
		if(joiningDate == null) {
			JOptionPane.showMessageDialog(null, "Please enter a joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!(joiningDate instanceof Date)) {
			JOptionPane.showMessageDialog(null, "Please enter a proper joining date", "Warning", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		record.setEmployeeId(employeeId);
		record.setRequestFor(requestFor.getId());
		record.setDepartmentFrom(departmentFrom);
		record.setDepartmentTo(toDepartment.getId());
		record.setTransferRelievingDate(leavingDate);
		record.setTransferJoiningDate(joiningDate);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String var_requestForName = employeeModel.findById(record.getRequestFor()).getName();
		String var_requestByName = employeeModel.findById(record.getEmployeeId()).getName();
		String var_departmentFromName = departmentModel.findById(record.getDepartmentFrom()).getName();
		String var_departmentToName = departmentModel.findById(record.getDepartmentTo()).getName();
		String var_relievingDate = simpleDateFormat.format(record.getTransferRelievingDate());
		String var_joiningDate = simpleDateFormat.format(record.getTransferJoiningDate());
		String var_statusString = record.getStatus() == 0 ? "Pending" : "Approved";
		
		String mailTo = employeeModel.findById(record.getRequestFor()).getEmail();
		String mailCc = data.get("email").toString();
		String mailSubject = "Transfer Request for " + var_requestForName + " - " + simpleDateFormat.format(new Date());
		
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
				+ ".gmail-mobile-forced-width {\r\n"
				+ "display: none;\r\n"
				+ "display: none !important;\r\n"
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
				+ "@media (max-width: 480px) {\r\n"
				+ ".t41,.t44{mso-line-height-alt:0px!important;line-height:0!important;display:none!important}.t42{padding:40px!important;border-radius:0!important;width:400px!important}.t1{width:368px!important}.t13,.t18,.t22,.t28,.t33,.t39,.t5,.t8{width:400px!important}\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<style type=\"text/css\">@media (max-width: 480px) {[class~=\"x_t41\"]{mso-line-height-alt:0px!important;line-height:0px!important;display:none!important;} [class~=\"x_t44\"]{mso-line-height-alt:0px!important;line-height:0px!important;display:none!important;} [class~=\"x_t42\"]{padding-left:40px!important;padding-top:40px!important;padding-bottom:40px!important;padding-right:40px!important;border-top-left-radius:0px!important;border-top-right-radius:0px!important;border-bottom-right-radius:0px!important;border-bottom-left-radius:0px!important;width:400px!important;} [class~=\"x_t1\"]{width:368px!important;} [class~=\"x_t5\"]{width:400px!important;} [class~=\"x_t8\"]{width:400px!important;} [class~=\"x_t13\"]{width:400px!important;} [class~=\"x_t18\"]{width:400px!important;} [class~=\"x_t22\"]{width:400px!important;} [class~=\"x_t28\"]{width:400px!important;} [class~=\"x_t33\"]{width:400px!important;} [class~=\"x_t39\"]{width:400px!important;}}</style>\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Albert+Sans:wght@400;700&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<xml>\r\n"
				+ "<o:OfficeDocumentSettings>\r\n"
				+ "<o:AllowPNG/>\r\n"
				+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
				+ "</o:OfficeDocumentSettings>\r\n"
				+ "</xml>\r\n"
				+ "<![endif]-->\r\n"
				+ "</head>\r\n"
				+ "<body id=\"body\" class=\"t47\" style=\"min-width:100%;Margin:0px;padding:0px;background-color:#F4F4F4;\"><div class=\"t46\" style=\"background-color:#F4F4F4;\"><table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"><tr><td class=\"t45\" style=\"font-size:0;line-height:0;mso-line-height-rule:exactly;background-color:#F4F4F4;\" valign=\"top\" align=\"center\">\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\">\r\n"
				+ "<v:fill color=\"#F4F4F4\"/>\r\n"
				+ "</v:background>\r\n"
				+ "<![endif]-->\r\n"
				+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" id=\"innerTable\"><tr><td><div class=\"t41\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:60px;line-height:60px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t43\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"600\" class=\"t42\" style=\"background-color:#FFFFFF;overflow:hidden;padding:60px 60px 60px 60px;border-radius:8px 8px 8px 8px;\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t42\" style=\"background-color:#FFFFFF;overflow:hidden;width:480px;padding:60px 60px 60px 60px;border-radius:8px 8px 8px 8px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100% !important;\"><tr><td align=\"center\">\r\n"
				+ "<table class=\"t2\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t1\" style=\"background-color:#F5F5DC;overflow:hidden;padding:8px 16px 8px 16px;border-radius:16px 16px 16px 16px;\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t1\" style=\"background-color:#F5F5DC;overflow:hidden;width:448px;padding:8px 16px 8px 16px;border-radius:16px 16px 16px 16px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<h1 class=\"t0\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:700;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:center;mso-line-height-rule:exactly;mso-text-raise:1px;\">Transfer Request</h1></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t3\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t6\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t5\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t5\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t4\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Hello " + var_requestForName + "</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t9\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t8\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t8\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t7\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Here is your transfer request.</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t12\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t14\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t13\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t13\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t11\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:-1px;\"><span class=\"t10\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Request Information</span></p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t15\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t19\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t18\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t18\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t17\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t16\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Requested For:</span> " + var_requestForName + "</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t23\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t22\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t22\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t21\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t20\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Requested By:</span> " + var_requestByName + "</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t24\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t29\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t28\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t28\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t27\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t25\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">From:</span> " + var_departmentFromName + " (relieving on <span class=\"t26\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">" + var_relievingDate + "</span>)</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t34\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t33\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t33\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t32\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t30\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">To:</span> " + var_departmentToName + " (relieving on <span class=\"t31\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">" + var_joiningDate + "</span>)</p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t38\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:8px;line-height:8px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
				+ "<table class=\"t40\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
				+ "<tr>\r\n"
				+ "<!--[if mso]>\r\n"
				+ "<td width=\"480\" class=\"t39\">\r\n"
				+ "<![endif]-->\r\n"
				+ "<!--[if !mso]>-->\r\n"
				+ "<td class=\"t39\" style=\"width:480px;\">\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<p class=\"t37\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\"><span class=\"t35\" style=\"margin:0;Margin:0;font-weight:700;mso-line-height-rule:exactly;\">Request Status:</span><span class=\"t36\" style=\"margin:0;Margin:0;font-weight:400;mso-line-height-rule:exactly;\"> " + var_statusString + "</span></p></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr></table></td>\r\n"
				+ "</tr></table>\r\n"
				+ "</td></tr><tr><td><div class=\"t44\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:60px;line-height:60px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr></table></td></tr></table></div><div class=\"gmail-mobile-forced-width\" style=\"white-space: nowrap; font: 15px courier; line-height: 0;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n"
				+ "</div></body>\r\n"
				+ "</html>";;
		
		RecordModel recordModel = new RecordModel();
		boolean isCreated = false;
		if(!recordModel.checkAvailablePendingDepartmentRecord(requestFor)){
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				isCreated = recordModel.createDepartmentRecord(record);
				MailHelpers.send("vinhduc0304@gmail.com", mailTo, mailCc, mailSubject, mailBody);
			}
		}
		
		String message = isCreated ? "Create Record success" : "Create Record failed. " + requestFor.getName() + " can only have 1 pending department request.";
		int messageType = isCreated ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
		
		JOptionPane.showMessageDialog(null, message, isCreated ? "Success" : "Failed", messageType);
		

	}
	protected void do_jcomboBoxRequestFor_actionPerformed(ActionEvent e) {
		EmployeeModel employeeModel = new EmployeeModel();
		DepartmentModel departmentModel = new DepartmentModel();
		
		Employee requestFor = (Employee) jcomboBoxRequestFor.getSelectedItem();
//		System.out.println("Request for id: " + requestFor.getId());
		jtextFieldFromDepartment.setText(departmentModel.findById(requestFor.getCurrentDepartment()).getName());
		
		DefaultComboBoxModel<Department> departmentBoxModel = new DefaultComboBoxModel<>();
		int currentRequestForDepartment = employeeModel.getCurrentDepartment(requestFor.getId()); // problem
//		System.out.println("Current employee request for project: " + currentRequestForProject);
		for(Department department : departmentModel.exclusiveCurrentDepartment(currentRequestForDepartment)) {
			departmentBoxModel.addElement(department);
		}
		jcomboBoxToDepartment.setModel(departmentBoxModel);
		jcomboBoxToDepartment.setRenderer(new DynamicRequestForCellRender());
	}
	
	private class DynamicRequestForCellRender extends DefaultListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getId() + " - " + department.getName(), index, isSelected, cellHasFocus);
		}
	}
	
	protected void do_jdateChooserLeaving_propertyChange(PropertyChangeEvent evt) {
		Date leavingDate = jdateChooserLeaving.getDate();
        
        if (leavingDate != null) {
            // Update the minimum selectable date for jdatechooserJoining
            jdateChooserJoining.setMinSelectableDate(leavingDate);
            jdateChooserJoining.setEnabled(true);
        } else {
            // If no date is selected, set minimum selectable date to null
        	jdateChooserJoining.setEnabled(false);
            jdateChooserJoining.setMinSelectableDate(null);
        }
	}
}
