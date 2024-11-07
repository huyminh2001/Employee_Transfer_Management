package jframes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.Border;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.sun.tools.javac.Main;

import helpers.RoundedBorder;
import jdialogs.JDialogAddProfile;
import jdialogs.JDialogEditProfile;
import jdialogs.JDialogProfile;
import jpanels.JPanelHome;
import jpanels.JPanelLetter;
import jpanels.JPanelRecord;
import jpanels.JPanelReport;
import jpanels.JPanelRequestForm;
import jpanels.JpanelEmployeeProfile;

import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class JFrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpanelCenter;
	private JPanel jpanelLeft;
	private JPanel jpanelMain;
	private JButton jbuttonMenuHome;
	private JButton jbuttonMenuRequestForm;
	private JButton jbuttonMenuRecord;
	private JMenuItem jmenuItemAddProfile;
	private JMenuItem jmenuItemProfile;
	private JMenuItem jmenuItemLogout;
	private Map<String, Object> data;
	private JButton jbuttonEmployeeProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
//			FlatArcOrangeIJTheme.setup();

//			FlatMaterialLighterIJTheme.setup();
//			IntelliJTheme.setup(Main.class.getResourceAsStream("/onelight.theme.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
		setTitle("Transfer Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 551);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Account");
		menuBar.add(mnNewMenu);

		jmenuItemProfile = new JMenuItem("Profile");
		jmenuItemProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jmenuItemProfile_actionPerformed(e);
			}
		});
		mnNewMenu.add(jmenuItemProfile);

		jmenuItemAddProfile = new JMenuItem("Add profile");
		jmenuItemAddProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jmenuItemAddProfile_actionPerformed(e);
			}
		});
		mnNewMenu.add(jmenuItemAddProfile);

		jmenuItemLogout = new JMenuItem("Logout");
		jmenuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jmenuItemLogout_actionPerformed(e);
			}
		});
		mnNewMenu.add(jmenuItemLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		int panelMainPadding = 20; // Adjust padding value as needed
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 877, 0 };
		gbl_contentPane.rowHeights = new int[] { 331, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		jpanelMain = new JPanel() {
			private int panelRightRadius = 50; // Radius for rounded corners
//		    private Color borderColor = Color.RED; // Border color

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Fill the rounded rectangle
				g2d.setColor(getBackground());
				g2d.fillRoundRect(0, 0, getWidth(), getHeight(), panelRightRadius, panelRightRadius);

				// Draw the rounded border
//		        g2d.setColor(borderColor);
//		        g2d.drawRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
			}
		};
		jpanelMain.setBorder(BorderFactory.createEmptyBorder(panelMainPadding, panelMainPadding, panelMainPadding,
				panelMainPadding));
		jpanelMain.setLayout(new BorderLayout(0, 0));
		jpanelMain.setBackground(new Color(29, 29, 29));
		jpanelMain.setOpaque(false);

		jpanelLeft = new JPanel() {
			private int panelLeftRadius = 20; // Radius for rounded corners
			// private Color borderColor = Color.RED; // Border color

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Fill the rounded rectangle
				g2d.setColor(getBackground());
				g2d.fillRoundRect(0, 0, getWidth(), getHeight(), panelLeftRadius, panelLeftRadius);

				// Draw the rounded border
				// g2d.setColor(borderColor);
				// g2d.drawRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
			}
		};
		jpanelMain.add(jpanelLeft, BorderLayout.WEST);

		jpanelLeft.setBackground(new Color(29, 29, 29));
		jpanelLeft.setBorder(new EmptyBorder(8, 0, 8, 8));
		jpanelLeft.setOpaque(false);
		GridBagLayout gbl_jpanelLeft = new GridBagLayout();
		gbl_jpanelLeft.columnWidths = new int[] { 179 }; // Only one column with width of 179
		gbl_jpanelLeft.rowHeights = new int[] { 0, 0, 33, 33, 33, 33, 33, 0, 33, 0, 0 }; // Keep row heights
		gbl_jpanelLeft.columnWeights = new double[] { 1.0 }; // One column with weight, set to 1.0 to expand if
		// necessary
		gbl_jpanelLeft.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE }; // Keep row
		// weights
		// the same
		jpanelLeft.setLayout(gbl_jpanelLeft);

		jbuttonMenuHome = new JButton("Home");
		jbuttonMenuHome.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonMenuHome.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/white/Pi7_home_32px.png")));
		jbuttonMenuHome.setForeground(Color.WHITE);
		jbuttonMenuHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonMenuHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonHome_actionPerformed(e);
			}
		});
		jbuttonMenuHome.setOpaque(false); // Turn off opaque
		jbuttonMenuHome.setBorderPainted(false); // Optionally remove the border to make it fully transparent
		// jbuttonMenuHome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jbuttonMenuHome.setBackground(new Color(29, 29, 29)); // Rest state
		jbuttonMenuHome.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				jbuttonMenuHome.setBackground(new Color(0, 126, 167)); // Focus state color
			}

			@Override
			public void focusLost(FocusEvent e) {
				jbuttonMenuHome.setBackground(new Color(29, 29, 29)); // Rest state color
			}
		});
		
		jlabelHi = new JLabel("Hi, ");
		jlabelHi.setForeground(Color.WHITE);
		jlabelHi.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_jlabelHi = new GridBagConstraints();
		gbc_jlabelHi.anchor = GridBagConstraints.WEST;
		gbc_jlabelHi.insets = new Insets(0, 0, 5, 0);
		gbc_jlabelHi.gridx = 0;
		gbc_jlabelHi.gridy = 0;
		jpanelLeft.add(jlabelHi, gbc_jlabelHi);

		lblNewLabel = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		jpanelLeft.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_jbuttonMenuHome = new GridBagConstraints();
		gbc_jbuttonMenuHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbuttonMenuHome.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonMenuHome.gridx = 0;
		gbc_jbuttonMenuHome.gridy = 2;
		jpanelLeft.add(jbuttonMenuHome, gbc_jbuttonMenuHome);

		jbuttonMenuRequestForm = new JButton("Request");
		jbuttonMenuRequestForm.setForeground(Color.WHITE);
		jbuttonMenuRequestForm.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonMenuRequestForm
				.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/white/Pi7_form_32px.png")));
		jbuttonMenuRequestForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonMenuRequestForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonRequestForm_actionPerformed(e);
			}
		});
		jbuttonMenuRequestForm.setOpaque(false); // Turn off opaque
		jbuttonMenuRequestForm.setBorderPainted(false); // Optionally remove the border to make it fully transparent
		jbuttonMenuRequestForm.setBackground(new Color(29, 29, 29)); // Rest state
		jbuttonMenuRequestForm.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				jbuttonMenuRequestForm.setBackground(new Color(0, 126, 167)); // Focus state color
			}

			@Override
			public void focusLost(FocusEvent e) {
				jbuttonMenuRequestForm.setBackground(new Color(29, 29, 29)); // Rest state color
			}
		});

		GridBagConstraints gbc_jbuttonMenuRequestForm = new GridBagConstraints();
		gbc_jbuttonMenuRequestForm.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbuttonMenuRequestForm.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonMenuRequestForm.gridx = 0;
		gbc_jbuttonMenuRequestForm.gridy = 3;
		jpanelLeft.add(jbuttonMenuRequestForm, gbc_jbuttonMenuRequestForm);

		jbuttonMenuRecord = new JButton("Records");
		jbuttonMenuRecord.setForeground(Color.WHITE);
		jbuttonMenuRecord.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonMenuRecord.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/white/Pi7_table2_32px.png")));
		jbuttonMenuRecord.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonMenuRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonMenuRecord_actionPerformed(e);
			}
		});
		jbuttonMenuRecord.setOpaque(false); // Turn off opaque
		jbuttonMenuRecord.setBorderPainted(false); // Optionally remove the border to make it fully transparent
		jbuttonMenuRecord.setBackground(new Color(29, 29, 29)); // Rest state
		jbuttonMenuRecord.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				jbuttonMenuRecord.setBackground(new Color(0, 126, 167)); // Focus state color
			}

			@Override
			public void focusLost(FocusEvent e) {
				jbuttonMenuRecord.setBackground(new Color(29, 29, 29)); // Rest state color
			}
		});

		GridBagConstraints gbc_jbuttonMenuRecord = new GridBagConstraints();
		gbc_jbuttonMenuRecord.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbuttonMenuRecord.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonMenuRecord.gridx = 0;
		gbc_jbuttonMenuRecord.gridy = 4;
		jpanelLeft.add(jbuttonMenuRecord, gbc_jbuttonMenuRecord);

		jbuttonEmployeeProfile = new JButton("Profiles");
		jbuttonEmployeeProfile.setForeground(Color.WHITE);
		jbuttonEmployeeProfile.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonEmployeeProfile
				.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/white/Pi7_usercircle_32px.png")));
		jbuttonEmployeeProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonEmployeeProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonEmployeeProfile_actionPerformed(e);
			}
		});
		jbuttonEmployeeProfile.setOpaque(false); // Turn off opaque
		jbuttonEmployeeProfile.setBorderPainted(false); // Optionally remove the border to make it fully transparent
		jbuttonEmployeeProfile.setBackground(new Color(29, 29, 29)); // Rest state
		jbuttonEmployeeProfile.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				jbuttonEmployeeProfile.setBackground(new Color(0, 126, 167)); // Focus state color
			}

			@Override
			public void focusLost(FocusEvent e) {
				jbuttonEmployeeProfile.setBackground(new Color(29, 29, 29)); // Rest state color
			}
		});

		GridBagConstraints gbc_jbuttonEmployeeProfile = new GridBagConstraints();
		gbc_jbuttonEmployeeProfile.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbuttonEmployeeProfile.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonEmployeeProfile.gridx = 0;
		gbc_jbuttonEmployeeProfile.gridy = 5;
		jpanelLeft.add(jbuttonEmployeeProfile, gbc_jbuttonEmployeeProfile);
		
		jbuttonMenuLogout = new JButton("Logout");
		jbuttonMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_jbuttonMenuLogout_actionPerformed(e);
			}
		});
		jbuttonMenuLogout.setIcon(new ImageIcon(JFrameMain.class.getResource("/resources/white/Pi7_logout2_32px.png")));
		jbuttonMenuLogout.setOpaque(false);
		jbuttonMenuLogout.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonMenuLogout.setForeground(Color.WHITE);
		jbuttonMenuLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonMenuLogout.setBorderPainted(false);
		jbuttonMenuLogout.setBackground(new Color(29, 29, 29));
		jbuttonMenuLogout.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				jbuttonMenuLogout.setBackground(new Color(0, 126, 167)); // Focus state color
			}

			@Override
			public void focusLost(FocusEvent e) {
				jbuttonMenuLogout.setBackground(new Color(29, 29, 29)); // Rest state color
			}
		});
		GridBagConstraints gbc_jbuttonMenuLogout = new GridBagConstraints();
		gbc_jbuttonMenuLogout.anchor = GridBagConstraints.SOUTH;
		gbc_jbuttonMenuLogout.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbuttonMenuLogout.insets = new Insets(0, 0, 5, 0);
		gbc_jbuttonMenuLogout.gridx = 0;
		gbc_jbuttonMenuLogout.gridy = 9;
		jpanelLeft.add(jbuttonMenuLogout, gbc_jbuttonMenuLogout);

		// jpanelCenter = new JPanel();
		jpanelCenter = new JPanel() {
			private int panelCenterRadius = 20; // Radius for rounded corners
			// private Color borderColor = Color.RED; // Border color

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Fill the rounded rectangle
				g2d.setColor(getBackground());
				g2d.fillRoundRect(0, 0, getWidth(), getHeight(), panelCenterRadius, panelCenterRadius);

				// Draw the rounded border
				// g2d.setColor(borderColor);
				// g2d.drawRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
			}
		};
		// jpanelCenter.setBackground(new Color(29, 29, 29));
		jpanelCenter.setBorder(BorderFactory.createEmptyBorder());
		jpanelCenter.setOpaque(false);

		jpanelMain.add(jpanelCenter, BorderLayout.CENTER);
		jpanelCenter.setBorder(new MatteBorder(0, 0, 0, 0, (Color) null));
		jpanelCenter.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_jpanelMain = new GridBagConstraints();
		gbc_jpanelMain.fill = GridBagConstraints.BOTH;
		gbc_jpanelMain.gridx = 0;
		gbc_jpanelMain.gridy = 0;
		contentPane.add(jpanelMain, gbc_jpanelMain);

	}

	public JFrameMain(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	private void initJFrame() {
		clearScreen();
		JPanelHome jpanelHome = new JPanelHome(data);
		jpanelCenter.add(jpanelHome);
		jpanelHome.setVisible(true);
		
		jlabelHi.setText(data.get("name").toString());
		jlabelHi.setBorder(BorderFactory.createEmptyBorder(0,24,8,8));

		int roleId = Integer.parseInt(data.get("roleId").toString());
		if (roleId == 1) {

		} else {
			jbuttonEmployeeProfile.setVisible(false);
			jmenuItemAddProfile.setVisible(false);
		}
	}

	private void clearScreen() {
		jpanelCenter.removeAll();
		jpanelCenter.revalidate();
		jpanelCenter.repaint();
	}

	protected void do_jbuttonHome_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelHome jpanelHome = new JPanelHome(data);
		jpanelCenter.add(jpanelHome);
		jpanelHome.setVisible(true);
	}

	protected void do_jbuttonRequestForm_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRequestForm jpanelRequestForm = new JPanelRequestForm(data);
		jpanelCenter.add(jpanelRequestForm);
		jpanelRequestForm.setVisible(true);
	}

	protected void do_jbuttonMenuRecord_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelRecord jpanelRecord = new JPanelRecord(data);
		jpanelCenter.add(jpanelRecord);
		jpanelRecord.setVisible(true);
	}

	protected void do_jmenuItemAddProfile_actionPerformed(ActionEvent e) {
		JDialogAddProfile jdialogAddProfile = new JDialogAddProfile(data);
		jdialogAddProfile.setVisible(true);

	}

	protected void do_jmenuItemProfile_actionPerformed(ActionEvent e) {
		JDialogProfile jdialogProfile = new JDialogProfile(data);
		jdialogProfile.setVisible(true);
	}

	protected void do_jmenuItemLogout_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
//			System.out.println("Yes");
			JFrameLogin jframeLogin = new JFrameLogin();
			this.setVisible(false);
			jframeLogin.setVisible(true);
		}
	}

	protected void do_jbuttonEmployeeProfile_actionPerformed(ActionEvent e) {
		clearScreen();
		JpanelEmployeeProfile jpanelEmployeeProfile = new JpanelEmployeeProfile(data);
		jpanelCenter.add(jpanelEmployeeProfile);
		jpanelEmployeeProfile.setVisible(true);
	}

	private static JButton lastClickedButton = null;
	private JLabel lblNewLabel;
	private JLabel jlabelHi;
	private JButton jbuttonMenuLogout;

	private static void setupButton(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Handle the first click case when lastClickedButton is null
				if (lastClickedButton == null) {
					// Set the current button as the last clicked
					lastClickedButton = button;
					// Set the current button's background to the clicked state
					button.setBackground(new Color(23, 66, 118)); // Click state
				} else if (lastClickedButton != button) {
					// If another button was clicked previously, reset it to the rest state
					lastClickedButton.setBackground(new Color(29, 29, 29)); // Rest state for last clicked button
					// Update the current button to the new last clicked one
					lastClickedButton = button;
					// Set the clicked button to the clicked state
					button.setBackground(new Color(23, 66, 118)); // Click state
				} else {
					// Handle the case where the same button is clicked again
					lastClickedButton = button; // Keep the button in clicked state
					button.setBackground(new Color(23, 66, 118)); // Ensure the button stays in the clicked state
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// Change to hover state if the button is not the last clicked
				if (button != lastClickedButton) {
					button.setBackground(new Color(173, 216, 255)); // Hover state
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Return to rest state if the button is not the last clicked
				if (button != lastClickedButton) {
					button.setBackground(new Color(29, 29, 29)); // Rest state
				}
			}
		});

		button.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Set to click state when the button gains focus
				button.setBackground(new Color(23, 66, 118)); // Focus/Click state
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Reset the color only if it's not the last clicked button
				if (button != lastClickedButton) {
					button.setBackground(new Color(29, 29, 29)); // Rest state
				}
			}
		});
	}
	protected void do_jbuttonMenuLogout_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Comfirm", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
//			System.out.println("Yes");
			JFrameLogin jframeLogin = new JFrameLogin();
			this.setVisible(false);
			jframeLogin.setVisible(true);
		}
//		else if(result == JOptionPane.NO_OPTION) {
//			System.out.println("No");
//		}
		
	}
}
