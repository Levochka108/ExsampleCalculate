/*
 * CNC_1_0_applet.java
 *
 * Created on 10 Май 2004 г., 18:32
 */
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
/**
 *
 * @author  Statsenko Vladimir
 */
public class CNC_1_1_applet extends javax.swing.JApplet {
    
    /** Creates a new instance of CNC_1_0_applet */
    public CNC_1_1_applet() {
    }
    
    public void init() {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        }
        catch(Exception e)
        {
            System.err.println("Ошибка при создании апплета : " + e.getMessage());
        }
    }
    
    private void createGUI() {
        JPanel mainPane = new mainPanel();
        mainPane.setOpaque(true);
        this.getContentPane().add(mainPane);
        this.getRootPane().setDefaultButton(((mainPanel)mainPane).getButton());
    }
}
