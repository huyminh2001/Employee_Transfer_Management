package jdialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helpers.MailHelpers;
import models.EmployeeModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JDialogConfirmUsername extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtextFieldUsername;
	private JButton jbuttonConfirm;
	private JButton jbuttonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogConfirmUsername dialog = new JDialogConfirmUsername();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogConfirmUsername() {
		setModal(true);
		setTitle("Forget Password");
		setBounds(100, 100, 450, 179);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{32, 0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblNewLabel = new JLabel("Confirm Username");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Username");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			jtextFieldUsername = new JTextField();
			GridBagConstraints gbc_jtextFieldUsername = new GridBagConstraints();
			gbc_jtextFieldUsername.insets = new Insets(0, 0, 5, 5);
			gbc_jtextFieldUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtextFieldUsername.gridx = 2;
			gbc_jtextFieldUsername.gridy = 2;
			getContentPane().add(jtextFieldUsername, gbc_jtextFieldUsername);
			jtextFieldUsername.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 0, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			getContentPane().add(panel, gbc_panel);
			{
				jbuttonConfirm = new JButton("Confirm");
				jbuttonConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonConfirm_actionPerformed(e);
					}
				});
				panel.add(jbuttonConfirm);
			}
			{
				jbuttonCancel = new JButton("Cancel");
				jbuttonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_jbuttonCancel_actionPerformed(e);
					}
				});
				panel.add(jbuttonCancel);
			}
		}
	}

	protected void do_jbuttonConfirm_actionPerformed(ActionEvent e) {		
		try {
			EmployeeModel employeeModel = new EmployeeModel();
			String username = jtextFieldUsername.getText();
			
			if(username.isEmpty() || username == null) {
				JOptionPane.showMessageDialog(null, "Username cannot be empty.", "System Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			employeeModel.updateSecurityCode(username);
			int verificationCode = employeeModel.findByUsername(username).getSecurityCode();
			
			Map<String, Object> dataUsername = new HashMap<String, Object>();
			dataUsername.put("username", username);
//			dataUserEmail.put("email", email);
			
			String mailSubject = "Transfer Management - Verification Code";
//			String mailBody = "<b>Transfer Management - Verification Code</b>"
//					+ "<p>Username: " + jtextFieldUsername.getText() + "</p>"
//					+ "<p>Verification Code: " + verificationCode + "</p>";
			
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
					+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}\r\n"
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
					+ "@media (min-width: 481px) {\r\n"
					+ "h1,img,p{margin:0;Margin:0}.t1,.t12,.t15,.t5,.t8{width:480px!important}img,p{font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2,h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;font-weight:400;font-style:normal;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{line-height:30px;font-size:24px}h3{line-height:26px;font-size:20px}.t14,.t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important}\r\n"
					+ "}\r\n"
					+ "</style>\r\n"
					+ "<style type=\"text/css\">@media (min-width: 481px) {[class~=\"x_t14\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t17\"]{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important;} [class~=\"x_t15\"]{padding-left:60px!important;padding-top:60px!important;padding-bottom:60px!important;padding-right:60px!important;border-top-left-radius:8px!important;border-top-right-radius:8px!important;border-bottom-right-radius:8px!important;border-bottom-left-radius:8px!important;overflow:hidden!important;width:480px!important;} [class~=\"x_t8\"]{width:480px!important;} [class~=\"x_t1\"]{width:480px!important;} [class~=\"x_t12\"]{width:480px!important;} [class~=\"x_t5\"]{width:480px!important;}}</style>\r\n"
					+ "<style type=\"text/css\" media=\"screen and (min-width:481px)\">.moz-text-html img,.moz-text-html p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}.moz-text-html .t14,.moz-text-html .t17{mso-line-height-alt:60px!important;line-height:60px!important;display:block!important}.moz-text-html .t15{padding:60px!important;border-radius:8px!important;overflow:hidden!important;width:480px!important}.moz-text-html .t1,.moz-text-html .t12,.moz-text-html .t5,.moz-text-html .t8{width:480px!important}</style>\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<link href=\"https://fonts.googleapis.com/css2?family=Albert+Sans:wght@400;600;800&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\" />\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<style type=\"text/css\">\r\n"
					+ "img,p{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:22px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h1{margin:0;Margin:0;font-family:Roboto,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:34px;font-weight:400;font-style:normal;font-size:28px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h2{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:30px;font-weight:400;font-style:normal;font-size:24px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}h3{margin:0;Margin:0;font-family:Lato,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:26px;font-weight:400;font-style:normal;font-size:20px;text-decoration:none;text-transform:none;letter-spacing:0;direction:ltr;color:#333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px}div.t14,div.t17{mso-line-height-alt:60px !important;line-height:60px !important;display:block !important}td.t15{padding:60px !important;border-radius:8px !important;overflow:hidden !important}\r\n"
					+ "</style>\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<xml>\r\n"
					+ "<o:OfficeDocumentSettings>\r\n"
					+ "<o:AllowPNG/>\r\n"
					+ "<o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
					+ "</o:OfficeDocumentSettings>\r\n"
					+ "</xml>\r\n"
					+ "<![endif]-->\r\n"
					+ "</head>\r\n"
					+ "<body id=\"body\" class=\"t20\" style=\"min-width:100%;Margin:0px;padding:0px;background-color:#F4F4F4;\"><div class=\"t19\" style=\"background-color:#F4F4F4;\"><table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\"><tr><td class=\"t18\" style=\"font-size:0;line-height:0;mso-line-height-rule:exactly;background-color:#F4F4F4;\" valign=\"top\" align=\"center\">\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\">\r\n"
					+ "<v:fill color=\"#F4F4F4\"/>\r\n"
					+ "</v:background>\r\n"
					+ "<![endif]-->\r\n"
					+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" id=\"innerTable\"><tr><td><div class=\"t14\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t16\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<td width=\"600\" class=\"t15\" style=\"background-color:#FFFFFF;padding:40px 40px 40px 40px;\">\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t15\" style=\"background-color:#FFFFFF;width:400px;padding:40px 40px 40px 40px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%!important;\"><tr><td align=\"center\">\r\n"
					+ "<table class=\"t2\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<td width=\"480\" class=\"t1\">\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t1\" style=\"width:400px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<h1 class=\"t0\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:600;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">Verification Code</h1></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t3\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t6\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<td width=\"480\" class=\"t5\" style=\"padding:0 0 16px 0;\">\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t5\" style=\"width:400px;padding:0 0 16px 0;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<p class=\"t4\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Hello "+ employeeModel.findByUsername(username).getName() +"</p></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t9\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<td width=\"480\" class=\"t8\">\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t8\" style=\"width:400px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<h1 class=\"t7\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:41px;font-weight:800;font-style:normal;font-size:39px;text-decoration:none;text-transform:none;letter-spacing:-1.56px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:1px;\">"+employeeModel.findByUsername(username).getSecurityCode()+"</h1></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t10\" style=\"mso-line-height-rule:exactly;mso-line-height-alt:16px;line-height:16px;font-size:1px;display:block;\">&nbsp;&nbsp;</div></td></tr><tr><td align=\"center\">\r\n"
					+ "<table class=\"t13\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"Margin-left:auto;Margin-right:auto;\">\r\n"
					+ "<tr>\r\n"
					+ "<!--[if mso]>\r\n"
					+ "<td width=\"480\" class=\"t12\">\r\n"
					+ "<![endif]-->\r\n"
					+ "<!--[if !mso]>-->\r\n"
					+ "<td class=\"t12\" style=\"width:400px;\">\r\n"
					+ "<!--<![endif]-->\r\n"
					+ "<p class=\"t11\" style=\"margin:0;Margin:0;font-family:Albert Sans,BlinkMacSystemFont,Segoe UI,Helvetica Neue,Arial,sans-serif;line-height:21px;font-weight:400;font-style:normal;font-size:16px;text-decoration:none;text-transform:none;letter-spacing:-0.64px;direction:ltr;color:#333333;text-align:left;mso-line-height-rule:exactly;mso-text-raise:2px;\">Use this code to complete setting up a new password for your account.</p></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr></table></td>\r\n"
					+ "</tr></table>\r\n"
					+ "</td></tr><tr><td><div class=\"t17\" style=\"mso-line-height-rule:exactly;font-size:1px;display:none;\">&nbsp;&nbsp;</div></td></tr></table></td></tr></table></div></body>\r\n"
					+ "</html>";
			String mailTo = employeeModel.findByUsername(jtextFieldUsername.getText()).getEmail();
			
			
			if(MailHelpers.send("vinhduc0304@gmail.com", mailTo, mailSubject, mailBody)) {
				JOptionPane.showMessageDialog(null, "Verification code has been sent to your email.", "System Message", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
				JDialogForgetPassword jdialogForgetPassword = new JDialogForgetPassword(dataUsername);
				jdialogForgetPassword.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Undefined error. Cannot set new password.", "System Message", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Username not found.", "System Message", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	protected void do_jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
