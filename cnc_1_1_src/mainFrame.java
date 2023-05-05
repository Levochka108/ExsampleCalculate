/*
 * mainFrame.java
 *
 * Created on 8 Май 2004 г., 16:29
 */

import javax.swing.*;

/**
 *
 * @author Statsenko Vladimir
 */
public class mainFrame {
    
    /** Creates a new instance of mainFrame */
    public mainFrame() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        JFrame frame = new JFrame("CNC 1.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel mainPane = new mainPanel();
        mainPane.setOpaque(true);
        frame.setContentPane(mainPane);
        frame.getRootPane().setDefaultButton(mainPane.getButton());
        
        frame.pack();
        frame.setVisible(true);
    }
}
