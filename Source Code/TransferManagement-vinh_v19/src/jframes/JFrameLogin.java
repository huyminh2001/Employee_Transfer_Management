package jframes;

import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mallowigi.idea.themes.themes.OneLightTheme;
import com.sun.tools.javac.Main;

import jdialogs.JDialogConfirmUsername;
import models.EmployeeModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class JFrameLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;
	private JButton jbuttonLogin;
	private JButton jbuttonForgetPassword;
	private JLabel jlabelLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
//			FlatArcOrangeIJTheme.setup();
			
//			FlatMaterialLighterIJTheme.setup();
//			IntelliJTheme.setup(JFrameLogin.class.getResourceAsStream("/onelight.theme.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 32, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(29, 29, 29));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.gridheight = 9;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
//		gbl_panel_1.columnWidths = new int[]{32, 0, 0, 0, 0, 0};  // Fix the first (leftmost) column width to 32 pixels
//		gbl_panel_1.rowHeights = new int[]{32, 64, 0};            // Fix the first (topmost) row height to 32 pixels
//		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0};  // Distribute remaining columns
//		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0};    // Distribute remaining rows
//		panel_1.setLayout(gbl_panel_1);
		
		jlabelLogo = new JLabel("");
		jlabelLogo.setBackground(new Color(29, 29, 29));
		jlabelLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		jlabelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelLogo.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/white/Pi7_logo2.png")));
		GridBagConstraints gbc_jlabelLogo = new GridBagConstraints();
		gbc_jlabelLogo.insets = new Insets(0, 0, 5, 0);
		gbc_jlabelLogo.anchor = GridBagConstraints.CENTER;
		gbc_jlabelLogo.gridx = 2;
		gbc_jlabelLogo.gridy = 1;
		panel_1.add(jlabelLogo, gbc_jlabelLogo);
		
		JLabel lblNewLabel_5 = new JLabel("  ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 5;
		gbc_lblNewLabel_5.gridy = 0;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("  ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 1;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 8, 0, 8, (Color) null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 6;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 5;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Transfer Management");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/user_24px.png")));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtextFieldUsername = new JTextField();
		GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
		gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldUsername.gridwidth = 2;
		gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldUsername.gridx = 1;
		gbc_jtextFieldUsername.gridy = 2;
		panel_2.add(jtextFieldUsername, gbc_jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(JFrameLogin.class.getResource("/resources/key_24px.png")));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
				
				jpasswordFieldPassword = new JPasswordField();
				GridBagConstraints gbc_jpasswordFieldPassword = new GridBagConstraints();
				gbc_jpasswordFieldPassword.gridwidth = 2;
				gbc_jpasswordFieldPassword.insets = new Insets(0, 0, 5, 0);
				gbc_jpasswordFieldPassword.fill = GridBagConstraints.HORIZONTAL;
				gbc_jpasswordFieldPassword.gridx = 1;
				gbc_jpasswordFieldPassword.gridy = 3;
				panel_2.add(jpasswordFieldPassword, gbc_jpasswordFieldPassword);
								
								JPanel panel = new JPanel();
								GridBagConstraints gbc_panel = new GridBagConstraints();
								gbc_panel.gridwidth = 2;
								gbc_panel.gridx = 1;
								gbc_panel.gridy = 5;
								panel_2.add(panel, gbc_panel);
								panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
								
								jbuttonLogin = new JButton("Login");
								//		jbuttonLogin.addKeyListener(new KeyAdapter() {
								//			@Override
								//			public void keyPressed(KeyEvent e) {
								//				do_jbuttonLogin_keyPressed(e);
								//			}
								//		});
										
										jbuttonLogin.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												do_jbuttonLogin_actionPerformed(e);
											}
										});
										panel.add(jbuttonLogin);
										
										jbuttonForgetPassword = new JButton("Forget your password?");
										jbuttonForgetPassword.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												do_jbuttonForgetPassword_actionPerformed(e);
											}
										});
										panel.add(jbuttonForgetPassword);
						
						JLabel lblNewLabel_4 = new JLabel("Group 5 - C2307L1");
						GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
						gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
						gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
						gbc_lblNewLabel_4.gridx = 5;
						gbc_lblNewLabel_4.gridy = 8;
						contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
//		initJFrame();
	}
	
//	private void initJFrame() {
//		setTitle("Logo");
////        setSize(400, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
//        // Load the image from resources or file
//        ImageIcon imageIcon = new ImageIcon("src/resources/G5_Logo_64x64.jpg"); // Adjust the path accordingly
//        
//        // Add the image to a JLabel
//        JLabel imageLabel = new JLabel(imageIcon);
//        getContentPane().add(imageLabel);
////        jlabelLogo.
//        
//        
//        // Display the frame
//        setVisible(true);
//	}
	
	protected void do_jbuttonLogin_actionPerformed(ActionEvent e) {
		try {
			EmployeeModel employeeModel = new EmployeeModel();
			String username = jtextFieldUsername.getText();
			String password = new String(jpasswordFieldPassword.getPassword());
			
			if(username.isEmpty() || username == null) {
				JOptionPane.showMessageDialog(null, "Username cannot be empty.", "System Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(password.isEmpty() || username == null) {
				JOptionPane.showMessageDialog(null, "Password cannot be empty.", "System Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int id = employeeModel.findByUsername(username).getId();
			String name = employeeModel.findByUsername(username).getName();
			String email = employeeModel.findByUsername(username).getEmail();
			int roleId = employeeModel.findByUsername(username).getRoleId();
			int projectId = employeeModel.findByUsername(username).getCurrentProject();
			int departmentId = employeeModel.findByUsername(username).getCurrentDepartment();
			int locationId = employeeModel.findByUsername(username).getCurrentLocation();
			Date joiningDate = employeeModel.findByUsername(username).getJoiningDate();
			int managerId = employeeModel.findByUsername(username).getManagerId();
			int status = employeeModel.findByUsername(username).getStatus();
	
			if(employeeModel.login(username, password)) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("id", id);
				data.put("username", username);
				data.put("password", password);
				data.put("name", name);
				data.put("email", email);
				data.put("roleId", roleId);
				data.put("projectId", projectId);
				data.put("departmentId", departmentId);
				data.put("locationId", locationId);
				data.put("joiningDate", joiningDate);
				data.put("managerId", managerId);
				data.put("status", status);
				
				JFrameMain jframeMain = new JFrameMain(data);
				jframeMain.setVisible(true);
				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Login successfully!", "Login", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect password.", "Login", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Username not found.", "Login", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void do_jbuttonForgetPassword_actionPerformed(ActionEvent e) {
		JDialogConfirmUsername jdialogConfirmUsername = new JDialogConfirmUsername();
		jdialogConfirmUsername.setVisible(true);
	}
	
	
//	protected void do_jbuttonLogin_keyPressed(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            // Simulate button press
//            jbuttonLogin.doClick();
//        }
//	}
}
