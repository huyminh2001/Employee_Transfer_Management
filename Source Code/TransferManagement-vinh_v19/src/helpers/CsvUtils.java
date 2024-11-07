package helpers;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CsvUtils {

	public static File generateCsvFileFromTable(TableModel model) throws IOException {
//        TableModel model = table.getModel();
        File tempFile = File.createTempFile("transfer_data", ".csv");
        tempFile.deleteOnExit(); // Ensure the file is deleted when the JVM exits
        
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"))) {
            // Write column headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) writer.write(',');
            }
            writer.newLine();

            // Write rows
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    String value = String.valueOf(model.getValueAt(i, j));
                    // Handle CSV escaping
                    if (value.contains(",") || value.contains("\"")) {
                        value = "\"" + value.replace("\"", "\"\"") + "\"";
                    }
                    writer.write(value);
                    if (j < model.getColumnCount() - 1) writer.write(',');
                }
                writer.newLine();
            }
        }

        return tempFile;
    }
}
