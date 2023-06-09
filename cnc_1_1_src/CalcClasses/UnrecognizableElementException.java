/*
 * UnrecognizableElementException.java
 *
 * Created on 6 ��� 2004 �., 17:59
 */

package CalcClasses;

/**
 * ���� ����� ������������ ��� ������������� � ������ CalcClasses.
 * ������������ ��� �������������� � ���, ��� ������� ������ �����
 * ����������� ������.
 * @author  Statsenko Vladimir
 */
public class UnrecognizableElementException extends Exception {
    
    /** ������� ���������� ������ UnrecognizableElementException */
    public UnrecognizableElementException() {
        super("�� ���� ���������� �������");
    }

    /** ������� ���������� ������ UnrecognizableElementException,
     * ���������� ���������� �� ��������, ���������� ������� ��
     * �������.
     * @param element ������, ���������� ��������, ������� �� 
     * ���������� ����������
     */
    public UnrecognizableElementException(String element) {
        super("�� ���� ���������� ������� \"" + element + "\"");
    }
    
}
