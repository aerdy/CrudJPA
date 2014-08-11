/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crudjpa;

import crudjpa.view.FormMhsJpa;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author bahrie
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
           new FormMhsJpa().setVisible(true);
            }
        });
    }

}
