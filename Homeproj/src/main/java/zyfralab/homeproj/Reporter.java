/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doc2.managers;
package zyfralab.homeproj;

import java.sql.Timestamp;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 *
 * @author smzubarev
 */
public class Reporter {
    
    //private SMainForm mainGui = null;
    //static Logger monLog = LoggerFactory.getLogger(Reporter.class);

    public Reporter() { //SMainForm mf) {
        //mainGui = mf;
    }
    
    public void closeNow() {
        //mainGui.setExit();
    }
    
    public void reportNow(String msg) {
       // Timestamp ts = new Timestamp(System.currentTimeMillis());
       // mainGui.appInfoMsg(ts + "::" + msg);
       // monLog.info(msg);
    }
    
    public void reportErr(Exception e) {
       // Timestamp ts = new Timestamp(System.currentTimeMillis());
       // mainGui.appInfoMsg(ts + "::" + "Attention! ERROR: " + e);
       // monLog.error("Attention! ERROR:", e);
    }
    
    public void eventsQtyUpdate(int eventsQty) {
       // mainGui.eventsQtyUpdate(eventsQty);
    }
    
    public void eventsKEQtyUpdate(int keID, int eventsQty, int col) {
        //mainGui.eventsKEQtyUpdate(keID, eventsQty, col);
    }
    
    public void sympsQtyUpdate(int sympsQty) {
        //mainGui.sympsQtyUpdate(sympsQty);
    }
    
    public void sympsKEQtyUpdate(int keID, int totSymps, int empSymps, int newSymps, int oldSymps, int notRegSymps) {
        //mainGui.sympsKEQtyUpdate(keID, totSymps, empSymps, newSymps, oldSymps, notRegSymps);
    }

    public void diagsQtyUpdate(int diagsQty) {
        //mainGui.diagsQtyUpdate(diagsQty);
    }
    
    public void diagsKEQtyUpdate(int keID, int value, int col) {
        //mainGui.diagsKEQtyUpdate(keID, value, col);
    }
    
    // Show room - Dashboard for ARM
    public void initMon(int keID) {
        //mainGui.initMon(keID);
    }

    public void updateMon(int keID) {
        //mainGui.updateMon(keID);
    }
    
    public void callCenter(int keID) {
        //mainGui.callCenter(keID);
    }
    
    public void finishMon(int keID) {
        //mainGui.finishMon(keID);
    }
}
 