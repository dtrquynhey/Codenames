package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Table extends JTable {

    public Table(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        setOpaque(false);
        setFont(new Font(Label.FONT_FAMILY, Font.PLAIN, 14));
        setBackground(CustomColor.CONTAINER_BROWN.getColor());
        setForeground(Color.WHITE);
        setGridColor(CustomColor.CONTAINER_BROWN.getColor());
        setRowHeight(50);
        setPreferredSize(getPreferredSize());
        setEnabled(false);

        // Customize renderer for all cells
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        setDefaultRenderer(Object.class, renderer);

        // Create and set the table header
        JTableHeader header = createDefaultTableHeader();
        setTableHeader(header);

        // Adjust column widths based on content
        adjustColumnWidths();


    }

    // Method to adjust column widths based on content
    private void adjustColumnWidths() {
        for (int column = 0; column < getColumnCount(); column++) {
            int maxWidth = 0;

            // Get maximum width of cells in this column
            for (int row = 0; row < getRowCount(); row++) {
                TableCellRenderer cellRenderer = getCellRenderer(row, column);
                Component cellComponent = prepareRenderer(cellRenderer, row, column);
                int cellWidth = cellComponent.getPreferredSize().width;
                maxWidth = Math.max(maxWidth, cellWidth);
            }

            // Set column width to the maximum width
            TableColumn tableColumn = getColumnModel().getColumn(column);
            tableColumn.setPreferredWidth(maxWidth + getIntercellSpacing().width);
        }
    }




    @Override
    protected JTableHeader createDefaultTableHeader() {
        JTableHeader header = super.createDefaultTableHeader();
        header.setOpaque(false);
        header.setFont(getFont());
        header.setBackground(CustomColor.CONTAINER_BROWN.getColor());
        header.setForeground(Color.WHITE);

        // Create a custom border for the header
        Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, CustomColor.CONTAINER_BROWN.getColor()); // Example: Black bottom border
        header.setBorder(border);

        return header;
    }
}