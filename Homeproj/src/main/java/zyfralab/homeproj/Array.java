/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zyfralab.homeproj;

import java.io.*;
import java.util.*;

/**
 *
 * @author Nikita
 */

public class Array 
{
    private List<ArrayList> table1 = new ArrayList();
    private List<ArrayList> table2 = new ArrayList();
    private int count = -1;
    
    public Array()
    {
        
        
        try(FileInputStream tblKETypeTC = new FileInputStream("Connect Techcards to KE Type.txt"))
        {
            int k;
            int i = 0,j = 0;
            ArrayList table1_2 = new ArrayList();
            String str = "";
            do { 
                k = tblKETypeTC.read();
                if (k != -1 && k != 32 && (char)k != '\r' && (char)k != '\n') str += (char)k;
                else if (k == 32 || (char)k == '\r' || k == -1) 
                {
                    Integer x = new Integer(str);
                    str = "";
                    table1_2.add(x);
                    j++;
                }
                if (j == 3) 
                {
                    ArrayList table1_3 = new ArrayList(table1_2);
                    table1.add(table1_3);
                    table1_2.clear();
                    j = 0;
                    i++;
                }
            } while(k != -1);  
           
            
            
        }catch(IOException e){}
        
         try(FileInputStream tblEditDiag = new FileInputStream("Edit Techcards Diagnoses.txt"))
        {
            int k;
            int i = 0,j = 0;
            ArrayList table2_2 = new ArrayList();
            String str = "";
            do { 
                k = tblEditDiag.read();
                if (k != -1 && k != 32 && (char)k != '\r' && (char)k != '\n') str += (char)k;
                else if (k == 32 || (char)k == '\r' || k == -1) 
                {
                    if (j != 2)
                    {
                        Integer x = new Integer(str);
                        table2_2.add(x);
                    }
                    else table2_2.add(str);
                    str = "";
                    j++;
                }
                if (j == 3) 
                {
                    ArrayList table2_3 = new ArrayList(table2_2);
                    table2.add(table2_3);
                    table2_2.clear();
                    j = 0;
                    i++;
                }
            } while(k != -1);  
           
            
            
        }catch(IOException e){}
       
    }
    public int getTCKEDB_columns()
    {
        return 3;
    }
    public int getTCKEDB_rows()
    {
        return 4;
    }
    public int getEDDB_columns()
    {
        return 3;
    }
    public int getEDDB_rows()
    {
        return 4;
    }
    public boolean next()
    {
        count++;
        if (count < 4) return true;
        count = -1;
        return false;
    }
    public Object TCKEDB_getObject(int index)
    {
        return table1.get(count).get(index);
    }
    public Object TCEDDB_getObject(int index)
    {
        return table2.get(count).get(index);
    }
    public void TCKEDB_changeData(Object data,int i,int j)
    {
        table1.get(i).set(j, data);
        System.out.println(table1.get(i).get(j));
    }
     public void TCEDDB_changeData(Object data,int i,int j)
    {
        table2.get(i).set(j, data);
        System.out.println(table2.get(i).get(j));
    }
}
