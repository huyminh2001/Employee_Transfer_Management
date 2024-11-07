package jpanels;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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

import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class JPanelHome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable jtablePendingRecord;
	private Map<String, Object> data;
	private JLabel jlabelHi;
	private final JLabel lblNewLabel_1 = new JLabel("   ");
	/**
	 * Create the panel.
	 */
	public JPanelHome(Map<String, Object> data) {
//		 Set layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        // Make the panel non-opaque to allow custom painting
        setOpaque(false);

        // Create and add label
//        JLabel lblNewLabel = new JLabel("Home Panel");
//        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//        gbc_lblNewLabel.gridx = 1;
//        gbc_lblNewLabel.gridy = 1;
//        add(lblNewLabel, gbc_lblNewLabel);
		
		this.data = data;
		initJPanel();
	}

	private void initJPanel() {
		renderChartByRole();
		renderTableByRole();
		jlabelHi.setText("Hi, " + data.get("name").toString());
		
	}
	
	private void renderChartByRole() {
		int roleId = Integer.parseInt(data.get("roleId").toString());
		if(roleId == 1) {
			adminChartRender();
		}else {
			employeeChartRender();
		}
	}
	
	private void renderTableByRole() {
		RecordModel recordModel = new RecordModel();
		int roleId = Integer.parseInt(data.get("roleId").toString());
		int managerId = Integer.parseInt(data.get("id").toString());
		int employeeId = Integer.parseInt(data.get("id").toString());
		if(roleId == 1) {
			fillDataToJtableTransferRecord(recordModel.findByPendingStatus());
		}else {
			fillDataToJtableTransferRecord(recordModel.findByEmployeePendingStatus(employeeId, managerId));
		}
	}
	
	private void adminChartRender() {
		RecordModel recordModel = new RecordModel();		
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pending", recordModel.countPendingRecord());
        dataset.setValue("Approved", recordModel.countApprovedRecord());
        dataset.setValue("Rejected", recordModel.countRejectedRecord());

        // Create a pie chart based on the dataset
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Records by Status", // Chart title
                dataset,             // Data
                true,                // Include legend
                true,                // Use tooltips
                false                // No URLs
        );
        
        PiePlot plot = (PiePlot) pieChart.getPlot();

        // Custom label generator to show both the category and percentage
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // Format: {category}: {value} ({percentage})
                new DecimalFormat("0"),  // Format for absolute values
                new DecimalFormat("0.00%") // Format for percentages
        ));
                GridBagConstraints gbc_pieChartPanel = new GridBagConstraints();
                gbc_pieChartPanel.anchor = GridBagConstraints.NORTHWEST;
                gbc_pieChartPanel.insets = new Insets(0, 0, 5, 0);
                gbc_pieChartPanel.fill = GridBagConstraints.BOTH;
                gbc_pieChartPanel.gridx = 0;
                gbc_pieChartPanel.gridy = 2;
        

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{172, 0, 610, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 410, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel = new JLabel("   ");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 2;
        gbc_lblNewLabel_1.gridy = 0;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JPanel jpanelHello = new JPanel();
        GridBagConstraints gbc_jpanelHello = new GridBagConstraints();
        gbc_jpanelHello.anchor = GridBagConstraints.WEST;
        gbc_jpanelHello.insets = new Insets(0, 0, 5, 5);
        gbc_jpanelHello.fill = GridBagConstraints.VERTICAL;
        gbc_jpanelHello.gridx = 0;
        gbc_jpanelHello.gridy = 1;
        add(jpanelHello, gbc_jpanelHello);
        
        jlabelHi = new JLabel("Welcome back ");
        jlabelHi.setFont(new Font("Tahoma", Font.BOLD, 12));
        jpanelHello.add(jlabelHi);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "Pending Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);
        
        jtablePendingRecord = new JTable();
        scrollPane.setViewportView(jtablePendingRecord);
        
        JPanel jchartPanel = new JPanel();
        GridBagConstraints gbc_jchartPanel = new GridBagConstraints();
        gbc_jchartPanel.anchor = GridBagConstraints.NORTH;
        gbc_jchartPanel.gridx = 2;
        gbc_jchartPanel.gridy = 2;
        add(jchartPanel, gbc_jchartPanel);
        // Add the pie chart to a panel
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new Dimension(600, 400));
        GroupLayout gl_jchartPanel = new GroupLayout(jchartPanel);
        gl_jchartPanel.setHorizontalGroup(
        	gl_jchartPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_jchartPanel.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(pieChartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_jchartPanel.setVerticalGroup(
        	gl_jchartPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jchartPanel.createSequentialGroup()
        			.addComponent(pieChartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(92, Short.MAX_VALUE))
        );
        pieChartPanel.setLayout(new BoxLayout(pieChartPanel, BoxLayout.X_AXIS));
        jchartPanel.setLayout(gl_jchartPanel);
        
        
	}
	
	private void employeeChartRender() {
		RecordModel recordModel = new RecordModel();
		int managerId = Integer.parseInt(data.get("id").toString());
		int employeeId = Integer.parseInt(data.get("id").toString());
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pending", recordModel.countEmployeePendingRecord(employeeId, managerId));
        dataset.setValue("Approved", recordModel.countEmployeeApprovedRecord(employeeId, managerId));
        dataset.setValue("Rejected", recordModel.countEmployeeRejectedRecord(employeeId, managerId));

        // Create a pie chart based on the dataset
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Records by Status", // Chart title
                dataset,             // Data
                true,                // Include legend
                true,                // Use tooltips
                false                // No URLs
        );
        
        PiePlot plot = (PiePlot) pieChart.getPlot();

        // Custom label generator to show both the category and percentage
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // Format: {category}: {value} ({percentage})
                new DecimalFormat("0"),  // Format for absolute values
                new DecimalFormat("0.00%") // Format for percentages
        ));
                GridBagConstraints gbc_pieChartPanel = new GridBagConstraints();
                gbc_pieChartPanel.anchor = GridBagConstraints.NORTHWEST;
                gbc_pieChartPanel.insets = new Insets(0, 0, 5, 0);
                gbc_pieChartPanel.fill = GridBagConstraints.BOTH;
                gbc_pieChartPanel.gridx = 0;
                gbc_pieChartPanel.gridy = 2;
        

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{172, 0, 610, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 410, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel = new JLabel("   ");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 2;
        gbc_lblNewLabel_1.gridy = 0;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JPanel jpanelHello = new JPanel();
        GridBagConstraints gbc_jpanelHello = new GridBagConstraints();
        gbc_jpanelHello.anchor = GridBagConstraints.WEST;
        gbc_jpanelHello.insets = new Insets(0, 0, 5, 5);
        gbc_jpanelHello.fill = GridBagConstraints.VERTICAL;
        gbc_jpanelHello.gridx = 0;
        gbc_jpanelHello.gridy = 1;
        add(jpanelHello, gbc_jpanelHello);
        
        jlabelHi = new JLabel("Welcome back ");
        jlabelHi.setFont(new Font("Tahoma", Font.BOLD, 12));
        jpanelHello.add(jlabelHi);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "Pending Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);
        
        jtablePendingRecord = new JTable();
        scrollPane.setViewportView(jtablePendingRecord);
        
        JPanel jchartPanel = new JPanel();
        GridBagConstraints gbc_jchartPanel = new GridBagConstraints();
        gbc_jchartPanel.anchor = GridBagConstraints.NORTH;
        gbc_jchartPanel.gridx = 2;
        gbc_jchartPanel.gridy = 2;
        add(jchartPanel, gbc_jchartPanel);
        // Add the pie chart to a panel
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new Dimension(600, 400));
        GroupLayout gl_jchartPanel = new GroupLayout(jchartPanel);
        gl_jchartPanel.setHorizontalGroup(
        	gl_jchartPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_jchartPanel.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(pieChartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_jchartPanel.setVerticalGroup(
        	gl_jchartPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jchartPanel.createSequentialGroup()
        			.addComponent(pieChartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(92, Short.MAX_VALUE))
        );
        pieChartPanel.setLayout(new BoxLayout(pieChartPanel, BoxLayout.X_AXIS));
        jchartPanel.setLayout(gl_jchartPanel);
        
        
	}
	
	
	private void fillDataToJtableTransferRecord(List<Records> records) {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		EmployeeModel employeeModel = new EmployeeModel();
		DefaultTableModel recordTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		
		recordTableModel.addColumn("ID");
		recordTableModel.addColumn("Employee");
		recordTableModel.addColumn("Request for");
		recordTableModel.addColumn("Created At");
		recordTableModel.addColumn("Status");
		
		Map<Integer, Employee> employees = new HashMap<>();
	    
		
		for (Records record : records) {
	        if (!employees.containsKey(record.getEmployeeId())) {
	            employees.put(record.getEmployeeId(), employeeModel.findById(record.getEmployeeId()));
	        }
	        
	        if (!employees.containsKey(record.getRequestFor())) {
	            employees.put(record.getRequestFor(), employeeModel.findById(record.getRequestFor()));
	        }
	       
	    }
		
		for(Records record : records) {
			Employee employee = employees.get(record.getEmployeeId());
	        Employee requestFor = employees.get(record.getRequestFor());
	      
			
			recordTableModel.addRow(new Object[] {
					record.getId(),
		            employee != null ? employee.getName() : "-",
		            requestFor != null ? requestFor.getName() : "-",
		            sp.format(record.getCreatedDate()),
		            record.getStatus() == 0 ? "Pending" : record.getStatus() == 1 ? "Approved" : "Rejected",
					
			});
		}
		jtablePendingRecord.setModel(recordTableModel);
		jtablePendingRecord.getTableHeader().setReorderingAllowed(false);
		
		
	}
}
    

