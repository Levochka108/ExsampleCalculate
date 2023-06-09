/*
 * IncorrectElementException.java
 *
 * Created on 15 ��� 2004 �., 16:18
 */

package CalcClasses;

/**
 * ���� ����� ������������ ��� ������������� � ������ CalcClasses.
 * ������������ ��� �������������� � ���, ��� � �������� ������
 * ���� ������.
 *
 * @author  Statsenko Vladimir
 */
public class IncorrectElementException extends Exception {
    
    int index = 0;
    
    /** ������� ����� ���������� ������ IncorrectElementException
     * @param mes �������� ������
     * @param index ������ ������� ������� ������������� ��������
     * � �������� ������. */
    public IncorrectElementException(String mes, int index) {
        super(mes);
        this.index = index;
    }
    
    /**���������� ������ ������� ������� ������������� ��������
     * � �������� ������. */
    public int getIndex() {
        return index;
    }
}
