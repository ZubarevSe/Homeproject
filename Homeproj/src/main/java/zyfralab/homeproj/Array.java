/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zyfralab.homeproj;

import java.io.*;

/**
 *
 * @author Nikita
 */

public class Array 
{
    private int table1[][] = new int[4][3];
    private int count = -1;
    
    public Array()
    {
        
        
        try(FileInputStream tblKETypeTC = new FileInputStream("Connect Techcards to KE Type.txt"))
        {
            int k;
            int i = 0,j = 0;
            String str = "";
            do { 
                k = tblKETypeTC.read();
                if (k != -1 && k != 32 && (char)k != '\r' && (char)k != '\n') str += (char)k;
                else if (k == 32 || (char)k == '\r' || k == -1) 
                {
                    Integer x = new Integer(str);
                    str = "";
                    table1[i][j] = x;
                    j++;
                }
                if (j == 3) 
                {
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
        return table1[count][index];
    }
    public void changeData(Object data,int i,int j)
    {
        table1[i][j] = (int)data;
        System.out.println(data);
    }
}
