/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doc2.managers;

import doc2.data.ErrComboItem;
import doc2.data.DBStoreAPI;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author smzubarev
 */
public class ErrComboModel extends DefaultComboBoxModel {
    private Reporter repo = null; 
    private DBStoreAPI dbStore = null;
    private ErrTblComboListener errTblListener = null;
//    private ErrComboListener errComboListener = null;

    
    public class ErrTblComboListener implements TableModelListener {

        public ErrTblComboListener() {
        }

        @Override
        public void tableChanged(TableModelEvent e) {
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    updateCombo();
                }
            });            
        }
    }    

/*    
    public class ErrComboListener implements ChangeListener {
        public ErrComboListener() {
            
        }
        
        @Override
        public void stateChanged(ChangeEvent e) {
            updateCombo();
        }
        
    }
*/    
        
// Methods of MAIN class
    public ErrComboModel(Reporter rep) {
        repo = rep;
        dbStore = new DBStoreAPI(repo);
        dbStore.openConn();
    }

    public void initModel() {
        try {
            updateCombo();
            //DiagListener errsLis = new DiagListener(); 
            //addTableModelListener(errsLis);

        }
        catch (Exception e) {
            repo.reportErr(e);
        }
    }

    
    public TableModelListener getErrTblListener() {
        if (this.errTblListener==null)
            this.errTblListener = new ErrTblComboListener();
        
        return this.errTblListener;
    }
    
    public void updateCombo() {

        try {
            removeAllElements();
            ResultSet rs = dbStore.getErrsDB();
            addRows(rs);      
        }
        catch (Exception e) {
            repo.reportErr(e);
            //System.exit(0);
        }        
    }    
    
    public void addRows(ResultSet rs) {
        int errID = 0;
        String errDesc = null;
        
        try {
            if (rs==null)
                return;
            while (rs.next()) {
                errID = rs.getInt("errid");
                errDesc = rs.getString("errcode");
                ErrComboItem newItem = new ErrComboItem(errID, errDesc);

                addElement(newItem);  
            }            
        }
        catch (Exception e) {
            repo.reportErr(e);
        }
    }  
    
}
