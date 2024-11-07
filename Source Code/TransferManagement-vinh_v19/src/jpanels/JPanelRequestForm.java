package jpanels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.mail.internet.NewsAddress;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class JPanelRequestForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpanelRequestForm;
	private Map<String, Object> data;
	/**
	 * Create the panel.
	 */
	public JPanelRequestForm() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 203, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel jpanelSwitchRequestForm = new JPanel();
		GridBagConstraints gbc_jpanelSwitchRequestForm = new GridBagConstraints();
		gbc_jpanelSwitchRequestForm.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelSwitchRequestForm.fill = GridBagConstraints.BOTH;
		gbc_jpanelSwitchRequestForm.gridx = 3;
		gbc_jpanelSwitchRequestForm.gridy = 1;
		add(jpanelSwitchRequestForm, gbc_jpanelSwitchRequestForm);
		jpanelSwitchRequestForm.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton jbuttonProjectForm = new JButton("Project Form");
		jbuttonProjectForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonProjectForm_actionPerformed(e);
			}
		});
		jpanelSwitchRequestForm.add(jbuttonProjectForm);
		
		JButton jbuttonDepartmentForm = new JButton("Department Form");
		jbuttonDepartmentForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonDepartmentForm_actionPerformed(e);
			}
		});
		jpanelSwitchRequestForm.add(jbuttonDepartmentForm);
		
		JButton jbuttonLocationForm = new JButton("Location Form");
		jbuttonLocationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonLocationForm_actionPerformed(e);
			}
		});
		jpanelSwitchRequestForm.add(jbuttonLocationForm);
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jpanelRequestForm = new JPanel();
		GridBagConstraints gbc_jpanelRequestForm = new GridBagConstraints();
		gbc_jpanelRequestForm.insets = new Insets(0, 0, 5, 5);
		gbc_jpanelRequestForm.fill = GridBagConstraints.BOTH;
		gbc_jpanelRequestForm.gridx = 3;
		gbc_jpanelRequestForm.gridy = 2;
		add(jpanelRequestForm, gbc_jpanelRequestForm);

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
	
	public JPanelRequestForm(Map<String, Object> data) {
		this();
		this.data = data;
		initJPanel();
		this.setOpaque(false);
	}
	private void clearScreen() {
		jpanelRequestForm.removeAll();
		jpanelRequestForm.revalidate();
		jpanelRequestForm.repaint();
	}
	
	private void initJPanel() {
		clearScreen();
		jpanelRequestForm.setLayout(new BorderLayout(0, 0));
		JPanelRequestProjectForm projectForm = new JPanelRequestProjectForm(data);
		jpanelRequestForm.add(projectForm);
		projectForm.setVisible(true);
	}
	
	protected void do_jbuttonProjectForm_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRequestProjectForm projectForm = new JPanelRequestProjectForm(data);
		jpanelRequestForm.add(projectForm);
		projectForm.setVisible(true);
	}
	protected void do_jbuttonDepartmentForm_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRequestDepartmentForm departmentForm = new JPanelRequestDepartmentForm(data);
		jpanelRequestForm.add(departmentForm);
		departmentForm.setVisible(true);
	}
	protected void do_jbuttonLocationForm_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRequestLocationForm locationForm = new JPanelRequestLocationForm(data);
		jpanelRequestForm.add(locationForm);
		locationForm.setVisible(true);
	}
}
