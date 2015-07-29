/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Misc;

import MQApi.QueryModel.QueueDepthStatusModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jzhou
 */
    public class ProgressCellRender extends JProgressBar implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected)
            {
                setBackground(table.getSelectionBackground());
                setForeground(Color.blue);
            }
            else
            {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
            }
            if(value != null){
                QueueDepthStatusModel model = (QueueDepthStatusModel)value;
                int progressValue = model.CurrentDepth * 100 / model.MaxDepth;
                this.setValue(progressValue);
                this.setStringPainted(true);
                this.setString(model.CurrentDepth + " / " + model.MaxDepth);
                return this;
            }
            else{
                this.setValue(0);
                this.setStringPainted(true);
                this.setString("N/A");    
                return this;
                //return new JLabel();
            }
            
        }

    }