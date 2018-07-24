/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* package doc2.managers;

import doc2.data.DBStoreAPI;
import doc2.data.ErrComboItem;
import doc2.data.MethComboItem; 
import java.sql.ResultSet;
import java.sql.ResultSetMetaData; */

import zyfralab.homeproj.Array;
import java.util.ArrayList;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smzubarev
 */
public class TCKETypeModel extends DefaultTableModel
{
        ArrayList columnNames = null;
        ArrayList rows = null;
        Array dbStore = null;
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
                  

                    switch (col) {                        
                        case 1:
                        case 4:
                            strVal = (String) data;
                     //       dbStore.setDiagDB(diagID, colName, strVal);
                            break;

                        case 2:    
                         
                       //     dbStore.setDiagDB(diagID, colName, intVal);
                            break;
                            
                        case 3:
                            
                       //     dbStore.setDiagDB(diagID, colName, intVal);
                            break;
                            
                        case 5:
                            flVal = (float)data;
                      //      dbStore.setDiagDB(diagID, colName, flVal);
                            break;          
                            
                        case 6:
                            boolVal = (Boolean)data;
                        //    dbStore.setDiagDB(diagID, colName, boolVal);
                            break;          
                            
                        case 7:   
                            intVal = (int)data;
                        //    dbStore.setDiagDB(diagID, colName, intVal);
                            break;                            
                    }


                }                                        
                catch (Exception e) {
                       repo.reportErr(e);
                }
            }
        }
        
        public TCKETypeModel(Reporter rep) {
              repo = rep;
      //      dbStore = new DBStoreAPI(repo);
      //      dbStore.openConn();
            dbStore = new Array();
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
               // ResultSet rs = dbStore.getTCKEDB();
               // ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns =  dbStore.columns(); //metaData.getColumnCount();
                if (columnNames==null) 
                    columnNames = new ArrayList();

                // Get the column names
                for (int column = 0; column < numberOfColumns; column++) {
                    // columnNames.add(metaData.getColumnLabel(column + 1));
                }

                // Get all rows.
                if (rows==null) 
                    rows = new ArrayList();      
                addRows(numberOfColumns);                
                
            }
            catch (Exception e) {
                repo.reportErr(e);
               // System.exit(0);
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
           /* ResultSet rs = null;            
            rs = dbStore.addDiag();
            addRows(rs, 8); */
        }
        
        public void addRows(/*ResultSet rs,*/ int colCount)
        {           
            try {
                if (dbStore==null)
                    return; 
                while (dbStore.next())
                {
                    ArrayList newRow = new ArrayList();
                    for (int i=0; i<colCount; i++)
                    {
                           
                            Object obj = dbStore.getObject(i);
                            System.out.println(obj);
                            newRow.add(obj);
                    }
                    rows.add(newRow);  
                }            
            }
            catch (Exception e) {
                repo.reportErr(e);
            }
        } 
}

