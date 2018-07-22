/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doc2.managers;

import doc2.data.DBStoreAPI;
import doc2.data.ErrComboItem;
import doc2.data.MethComboItem;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smzubarev
 */
public class TCKETypeModel extends DefaultTableModel{
        ArrayList columnNames = null;
        ArrayList rows = null;
        DBStoreAPI dbStore = null;
        Reporter repo = null;
        
        public class TCKEListener implements TableModelListener{
            
            public TCKEListener() {
            }
            
            @Override
            public void tableChanged(TableModelEvent evt) {
                String strVal = null;
                Object data = null;
                int id = 0;
                int intVal = 0;
                float flVal = 0;      
                boolean boolVal = false;
                int row = evt.getFirstRow();
                int col = evt.getColumn();
                
                if (col<0)
                    col = 1;
                if (row<0)
                    row = 0;

                try {
                    String colName = getColumnName(col);
                    data = getValueAt(row, col);
                    id = (int)getValueAt(row, 0);
                    intVal = (int)data;
                    dbStore.setTCKEDB(id, colName, intVal);
/*
                    switch (col) {                        
                        case 1:
                        case 4:
                            strVal = (String) data;
                            dbStore.setDiagDB(diagID, colName, strVal);
                            break;

                        case 2:    
                            ErrComboItem eci = (ErrComboItem)data;
                            intVal = eci.getValue();
                            dbStore.setDiagDB(diagID, colName, intVal);
                            break;
                            
                        case 3:
                            MethComboItem cmi = (MethComboItem)data;
                            intVal = cmi.getValue();
                            dbStore.setDiagDB(diagID, colName, intVal);
                            break;
                            
                        case 5:
                            flVal = (float)data;
                            dbStore.setDiagDB(diagID, colName, flVal);
                            break;          
                            
                        case 6:
                            boolVal = (Boolean)data;
                            dbStore.setDiagDB(diagID, colName, boolVal);
                            break;          
                            
                        case 7:   
                            intVal = (int)data;
                            dbStore.setDiagDB(diagID, colName, intVal);
                            break;                            
                    }
*/

                }                                        
                catch (Exception e) {
                    repo.reportErr(e);
                }
            }
        }
        
        public TCKETypeModel(Reporter rep) {
            repo = rep;
            dbStore = new DBStoreAPI(repo);
            dbStore.openConn();
        }
        
        public void initModel() {
            try {
                updateTable();
                               
                TCKEListener tckeLis = new TCKEListener(); 
                addTableModelListener(tckeLis);
                                                
            }
            catch (Exception e) {
                repo.reportErr(e);
            }
        }
         
        public void updateTable() {
                       
            try {
                ResultSet rs = dbStore.getTCKEDB();
                ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                if (columnNames==null) 
                    columnNames = new ArrayList();

                // Get the column names
                for (int column = 0; column < numberOfColumns; column++) {
                    columnNames.add(metaData.getColumnLabel(column + 1));
                }

                // Get all rows.
                if (rows==null) 
                    rows = new ArrayList();
                
                addRows(rs, numberOfColumns);                
                
            }
            catch (Exception e) {
                repo.reportErr(e);
                //System.exit(0);
            }        
                                    
        }
 
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            //return String.class;
            return getValueAt(0, columnIndex).getClass();
        }
 
        @Override
        public int getColumnCount() {
            return columnNames.size();
        }
 
        @Override
        public String getColumnName(int columnIndex) {
            if (columnNames==null)
                return null;
            if (columnIndex<0)
                columnIndex = 0;
            
            return columnNames.get(columnIndex).toString();
        }
 
        @Override
        public int getRowCount() {
            if (rows==null)
                return 0;
            else
                return rows.size();
        }
 
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object result = null; 
            
            try {
                Object curObj = null;

                if (rows==null)
                    return null;
                
                if (columnIndex<0)
                    columnIndex = 0;

                ArrayList curRow = (ArrayList) rows.get(rowIndex);
                result = curRow.get(columnIndex);                   
            }
            catch (Exception e) {
                repo.reportErr(e);
            }            
            return result;  
        }
 
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex>0)
                return true;
            else 
                return false;
        }
  
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            ArrayList curRow = (ArrayList) rows.get(rowIndex);
            curRow.set(columnIndex, value);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        
        public void addDiag() {
            ResultSet rs = null;            
            rs = dbStore.addDiag();
            addRows(rs, 8);
        }
        
        public void addRows(ResultSet rs, int colCount) {           
            try {
                if (rs==null)
                    return;
                while (rs.next()) {
                    ArrayList newRow = new ArrayList();
                    for (int i=1; i<=colCount; i++) {
/*
                        if (i==3) {
                            int errID = rs.getInt(i);
                            ErrComboItem eci = dbStore.getErrCmbItem(errID);
                            newRow.add(eci);
                        }                        
                        else if (i==4) {
                            int value = rs.getInt(i);
                            MethComboItem cmi = new MethComboItem(value);
                            newRow.add(cmi);
                        }
                        else {
*/
                            Object obj = rs.getObject(i);
                            newRow.add(obj);
//                        }
                    }
                    rows.add(newRow);  
                }            
            }
            catch (Exception e) {
                repo.reportErr(e);
            }
        }
}

