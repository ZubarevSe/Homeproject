/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zyfralab.homeproj;

import javax.swing.SwingUtilities;

/**
 *
 * @author Nikita
 */
public class Start {
    
     public static void main(String x[])
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new EditTCForm(new Reporter()).setVisible(true);
                }
            });
        } 
    
}
