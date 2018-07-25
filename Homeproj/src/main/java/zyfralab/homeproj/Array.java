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
       
    }
    public int columns()
    {
        return 3;
    }
    public int rows()
    {
        return 4;
    }
    public boolean next()
    {
        count++;
        if (count < 4) return true;
        return false;
    }
    public Object getObject(int index)
    {
        return table1.get(count).get(index);
    }
    public void changeData(Object data,int i,int j)
    {
        table1.get(i).set(j, data);
        System.out.println(table1.get(i).get(j));
    }
}
