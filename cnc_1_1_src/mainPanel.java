/*
 * mainPanel.java
 *
 * Created on 8 Май 2004 г., 16:05
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CalcClasses.*;

/** Этот класс создает панель, для приложения CNC
 * (Complex Numbers Calculator)
 *
 * @author  Statsenko Vladimir
 */
public class mainPanel extends JPanel implements ActionListener {
    
    protected JPanel controlPanel;
    protected JPanel historyPanel;
    protected JTextField expressionField;
    protected JTextField resultField;
    protected JButton solveButton;
    protected JList historyList;
    protected JScrollPane historyScroller;
    protected DefaultListModel listModel;
    
    private PostfixConverter converter = null;
    private PostfixCalculator calc = null;
    private ComplexNumber result = null;
    
    /** Создает новые экземпляры класса mainPanel */
    public mainPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints cc = new GridBagConstraints();
        
        historyPanel = new JPanel(new BorderLayout());
        
        expressionField = new JTextField(30);
        expressionField.setHorizontalAlignment(JTextField.RIGHT);
        
        resultField = new JTextField(15);
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        resultField.setEditable(false);
        
        solveButton = new JButton(" = ");
        solveButton.addActionListener(this);
        
        listModel = new DefaultListModel();
        historyList = new JList(listModel);
        historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyList.setVisibleRowCount(5);
        historyScroller = new JScrollPane(historyList);
        
        cc.gridx = 0;
        cc.gridy = 0;
        cc.fill = GridBagConstraints.HORIZONTAL;
        cc.weightx = 1;
        controlPanel.add(expressionField, cc);
        
        cc.gridx = 1;
        cc.gridy = 0;
        cc.fill = GridBagConstraints.NONE;
        cc.weightx = 0;
        controlPanel.add(solveButton, cc);

        cc.gridx = 2;
        cc.gridy = 0;
        cc.fill = GridBagConstraints.NONE;
        controlPanel.add(resultField, cc);
        
        historyPanel.add(historyScroller, BorderLayout.CENTER);
        
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        
        add(controlPanel, c);
        
        c.gridy = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        add(historyPanel, c);
    }
    
    /** Этот метод вызывается при нажатии пользователем на кнопку 
     * " = " (solveButton) или на клавишу Enter. */
    public void actionPerformed(ActionEvent e) {
        try
        {
            String src = expressionField.getText();
            converter = new PostfixConverter(src);
            calc = new PostfixCalculator(converter.convertToPostfix());
            result = new ComplexNumber(calc.calculate());
            String res = result.toString();
            resultField.setText(res);
            listModel.addElement(src + " = " + res);
            int lastElement = listModel.size() - 1;
            historyList.setSelectedIndex(lastElement);
            historyList.ensureIndexIsVisible(lastElement);
        }
        catch(IncorrectElementException iee)
        {
            listModel.addElement(iee.getMessage());
            int lastElement = listModel.size() - 1;
            historyList.setSelectedIndex(lastElement);
            historyList.ensureIndexIsVisible(lastElement);
            expressionField.select(iee.getIndex(),
                                expressionField.getText().length());
        }
        catch(Exception err)
        {
            listModel.addElement(err.getMessage());
            int lastElement = listModel.size() - 1;
            historyList.setSelectedIndex(lastElement);
            historyList.ensureIndexIsVisible(lastElement);
        }
    }
    
    /** Возвращает ссылку на компонент solveButton. Для того,
     * чтобы программа, использующая этот класс могла сделать
     * эту кнопку используемой по умолчанию. Например, так
     * <code>frame.getRootPane().setDefaultButton(((mainPanel)mainPane).getButton());</code>
     */
    public JButton getButton() {
        return solveButton;
    }
}
