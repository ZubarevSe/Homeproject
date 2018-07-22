/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zyfralab.homeproj;

import javax.swing.JTable;
import java.io.*;
import java.util.*;
/**
 *
 * @author Nikita
 */

public class Array 
{
    private int table1[][] = new int[4][3];
    private int table2_1[][] = new int[4][2];
    private ArrayList table2_2 = new ArrayList();
    private int table3_1[][] = new int[4][3];
    private ArrayList table3_2 = new ArrayList();
    private ArrayList table3_3 = new ArrayList();
    private ArrayList table3_4 = new ArrayList();
    
    public Array()
    {
        try(DataInputStream tblKETypeTC = new DataInputStream(new FileInputStream("Connect Techcards to KE Type.txt")))
        {
            for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 3;++j)
                {
                    table1[i][j] = tblKETypeTC.readInt();
                }
            }
            
        }catch(IOException e){}
        try(DataInputStream jTable1 = new DataInputStream(new FileInputStream("Edit Techcards Diagnoses.txt")))
        {
            for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 3;++j)
                {
                    if (j == 2) table2_2.add(jTable1.read());
                    else table2_1[i][j] = jTable1.readInt();
                }
            }
            
        }catch(IOException e){}
        try(DataInputStream tblActions = new DataInputStream(new FileInputStream("Edit Actions for Techcard.txt")))
        {
            for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 6;++j)
                {
                    if (j == 3) table3_2.add(tblActions.read());
                    else if (j == 4) table3_4.add(tblActions.readInt());
                    else if (j == 5) table3_3.add(tblActions.readFloat());
                    else table3_1[i][j] = tblActions.readInt();
                }
            }
            
        }catch(IOException e){}
    }
    public void initModel(JTable JT1,JTable JT2,JTable JT3)
    {
         for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 3;++j)
                {
                    JT1.setValueAt(table1[i][j], i, j);
                }
            }
         int k = 0;
          for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 3;++j)
                {
                    if (j == 2) 
                    {
                        JT2.setValueAt(table2_2.get(k),i,j);
                        k++;
                    }
                    else JT2.setValueAt(table2_1[i][j],i,j);
                }
            }
          k = 0;
          int p = 0,t = 0;
          for(int i = 0;i < 4;++i)
            {
                for(int j = 0;j < 6;++j)
                {
                    if (j == 3)
                    {
                        JT3.setValueAt(table3_2.get(k), i, j);
                        k++;
                    }
                    else if (j == 4) 
                    {
                         JT3.setValueAt(table3_4.get(p), i, j);
                         p++;
                    }
                    else if (j == 5)
                    {
                         JT3.setValueAt(table3_3.get(t), i, j);
                         t++;
                    }
                    else  JT3.setValueAt(table3_1[i][j], i, j);
                }
            }
    }
    
}
