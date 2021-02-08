/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Render;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Biah
 */
public class MesaCellRender extends DefaultTableCellRenderer{
    
       @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(value instanceof Date){
           SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");
           setValue(sdf.format(value));
        }
            return this;
    }
    
}
