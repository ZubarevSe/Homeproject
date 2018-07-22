/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doc2.managers;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//import doc2.data.DBStoreAPI;
//import doc2.managers.ActModel.ActListener;
//import doc2.data.MethComboItem;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;

/**
 *
 * @author smzubarev
 */
public class EditDiagForm extends javax.swing.JFrame {
//    private Reporter repo = null;
//    private ErrCodesModel errTblModel = null;
    private DiagModel diagTblModel = null;
    private TableRowSorter<TableModel> diagTblSorter;
//    private ErrComboModel errCmbModel = null;
    
    /**
     * Creates new form AddTCForm
     */
    public EditDiagForm() {    //Reporter rep) {
        initComponents();
        
        //repo = rep;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblErrCodes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnErrAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiag = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbErrCodes = new javax.swing.JComboBox<>();
        btnDropErrFilter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAddDiag = new javax.swing.JButton();

        setTitle("Editing Diagnoses");
        setLocation(new java.awt.Point(1, 100));
        setPreferredSize(new java.awt.Dimension(1360, 470));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblErrCodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Code", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblErrCodes.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblErrCodes);
        tblErrCodes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblErrCodes.getColumnModel().getColumnCount() > 0) {
            tblErrCodes.getColumnModel().getColumn(0).setMinWidth(45);
            tblErrCodes.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblErrCodes.getColumnModel().getColumn(0).setMaxWidth(45);
            tblErrCodes.getColumnModel().getColumn(1).setMinWidth(150);
            tblErrCodes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblErrCodes.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        jLabel1.setText("Edit Symptoms (error codes)");

        btnErrAdd.setText("Add");
        btnErrAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErrAddActionPerformed(evt);
            }
        });

        tblDiag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Description", "Err Code", "Check type", "Edit Method Here (for auto)", "Weight", "Is Final", "Next one"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiag.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tblDiag);
        tblDiag.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblDiag.getColumnModel().getColumnCount() > 0) {
            tblDiag.getColumnModel().getColumn(0).setMinWidth(45);
            tblDiag.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblDiag.getColumnModel().getColumn(0).setMaxWidth(45);
            tblDiag.getColumnModel().getColumn(1).setMinWidth(250);
            tblDiag.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDiag.getColumnModel().getColumn(1).setMaxWidth(250);
            tblDiag.getColumnModel().getColumn(2).setMinWidth(100);
            tblDiag.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDiag.getColumnModel().getColumn(2).setMaxWidth(100);
            tblDiag.getColumnModel().getColumn(4).setMinWidth(200);
            tblDiag.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jLabel2.setText("Edit Diagnoses Here");

        cmbErrCodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbErrCodesActionPerformed(evt);
            }
        });

        btnDropErrFilter.setText("All");
        btnDropErrFilter.setName(""); // NOI18N
        btnDropErrFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropErrFilterActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter by ErrCodes");

        btnAddDiag.setText("Add");
        btnAddDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnErrAdd))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbErrCodes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDropErrFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddDiag)
                        .addGap(0, 370, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnErrAdd)
                    .addComponent(cmbErrCodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDropErrFilter)
                    .addComponent(jLabel3)
                    .addComponent(btnAddDiag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImageIcon img = new ImageIcon("C:/Users/smzubarev/Documents/NetBeansProjects/Doc2/src/main/resources/icons8.png");
        setIconImage(img.getImage());

        errCodesTbl_Init();
        diagTbl_Init();
        errCmb_Init();
        
    }//GEN-LAST:event_formWindowOpened

    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void btnErrAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErrAddActionPerformed
        // TODO add your handling code here:        
        errCodesTbl_AddErr();

    }//GEN-LAST:event_btnErrAddActionPerformed

    private void cmbErrCodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbErrCodesActionPerformed
        // TODO add your handling code here:
        
        String err = String.valueOf(cmbErrCodes.getSelectedItem());
        
        try {
            diagTblSorter.setRowFilter(
                 RowFilter.regexFilter(err));
           } 
        catch (Exception e) {
            //repo.reportErr(e);
        }
        
    }//GEN-LAST:event_cmbErrCodesActionPerformed

    private void btnDropErrFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropErrFilterActionPerformed
        // TODO add your handling code here:
        diagTblSorter.setRowFilter(null);
    }//GEN-LAST:event_btnDropErrFilterActionPerformed

    private void btnAddDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiagActionPerformed
        // TODO add your handling code here:
        diagTblSorter.setRowFilter(null);
        diagTbl_AddDiag();
    }//GEN-LAST:event_btnAddDiagActionPerformed

    
// Methods to work with Errors Table    
    private void errCodesTbl_Init() {
   //     errTblModel = new ErrCodesModel(repo);
   //     errTblModel.initModel();
        tblErrCodes.setAutoCreateColumnsFromModel(false);
   //     tblErrCodes.setModel(errTblModel);             
    }    
  
    /**
     * Purpose: add new error in a new row
     */
    private void errCodesTbl_AddErr() {
    //    errTblModel.addErr();
    //    errTblModel.fireTableDataChanged();
        errCodesTbl_Set2Last();     
    }
    
    /**
     * Purpose: set cursor to the last row to edit
     */
    private void errCodesTbl_Set2Last() {
        tblErrCodes.setCellSelectionEnabled(true);
        int row = tblErrCodes.getRowCount()-1;
        tblErrCodes.changeSelection(row, 1, false, false);
//        tblErrCodes.requestFocus();
        tblErrCodes.editCellAt(row, 1);
        tblErrCodes.getEditorComponent().requestFocus();            
        
    }

// Methods to work with Diagnoses Table
    private void diagTbl_Init() {
        // Setting model
    //    diagTblModel = new DiagModel(repo);
        diagTblModel.initModel();
        tblDiag.setAutoCreateColumnsFromModel(false);
        tblDiag.setModel(diagTblModel);
        
        // Adding combo for Errors column
        TableColumn errCol = tblDiag.getColumnModel().getColumn(2);
        JComboBox errCombo = new JComboBox();
    //    ErrComboModel edcm = new ErrComboModel(repo);
    //    edcm.initModel();
    //    errCombo.setModel(edcm);
        errCol.setCellEditor(new DefaultCellEditor(errCombo));
        
     //   if (errTblModel!=null)  
     //       errTblModel.addTableModelListener(edcm.getErrTblListener());
        
        // Adding combo for Method Type column
        TableColumn chkCol = tblDiag.getColumnModel().getColumn(3);
        JComboBox chkCombo = new JComboBox();
        for (int i=1; i<=3; i++) 
     //       chkCombo.addItem(new MethComboItem(i));
        chkCol.setCellEditor(new DefaultCellEditor(chkCombo));        
        
        // Adding sorter
        diagTblSorter = new TableRowSorter<TableModel>(diagTblModel);
        tblDiag.setRowSorter(diagTblSorter);

    }

    /**
     * Purpose: add new error in a new row
     */
    private void diagTbl_AddDiag() {
        diagTblModel.addDiag();
        diagTblModel.fireTableDataChanged();
        diagTbl_Set2Last();     
    }
    
    /**
     * Purpose: set cursor to the last row to edit
     */
    private void diagTbl_Set2Last() {
        tblDiag.setCellSelectionEnabled(true);
        int row = tblDiag.getRowCount()-1;
        tblDiag.changeSelection(row, 1, false, false);
//        tblErrCodes.requestFocus();
        tblDiag.editCellAt(row, 1);
        tblDiag.getEditorComponent().requestFocus();            
        
    }
    

// Methods to work with Err Combo Box
    private void errCmb_Init() {
/*       errCmbModel = new ErrComboModel(repo);
       errCmbModel.initModel();
       cmbErrCodes.setModel(errCmbModel);

       if (errTblModel!=null)  
             errTblModel.addTableModelListener(errCmbModel.getErrTblListener()); */

        
    }        
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDiag;
    private javax.swing.JButton btnDropErrFilter;
    private javax.swing.JButton btnErrAdd;
    private javax.swing.JComboBox<String> cmbErrCodes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDiag;
    private javax.swing.JTable tblErrCodes;
    // End of variables declaration//GEN-END:variables
}
