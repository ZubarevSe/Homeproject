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
    private String table1[][] = new String[4][3];
  
    private int count = -1;
    
    public Array()
    {
        for (int i = 0;i < 4;++i)        
            for (int j = 0;j < 3;++j)
                table1[i][j] = "";
        
        try(FileInputStream tblKETypeTC = new FileInputStream("Connect Techcards to KE Type.txt"))
        {
            int k;
            int i = 0,j = 0;
            do { 
                k = tblKETypeTC.read();
                if (k != -1 && k != 32 && (char)k != '\r' && (char)k != '\n') table1[i][j] += (char)k;
                else if (k == 32 || (char)k == '\r') j++;
                if (j == 3) 
                {
                    j = 0;
                    i++;
                }
            } while(k != -1);  
            k = 0;
            
            
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
}
