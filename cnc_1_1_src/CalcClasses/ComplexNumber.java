/*
 * ComplexNumber.java
 *
 * Created on 5 ��� 2004 �., 9:12
 */

package CalcClasses;

import java.util.StringTokenizer;
import java.text.NumberFormat;
/**
 * ���� ����� �������� ����������� ����� � ���������
 * ��������� �������������� �������� ��� ���.
 * @author  Statsenko Vladimir
 */
public class ComplexNumber {
    
    private double Re = 0; //�������������� ����� �����
    private double Im = 0; //������ ����� �����
    
    /**
     * ������� ����� ���������� ComplexNumber
     * @param value ������, ���������� ����������� �����.
     * ��������, "5,6 + 2,2i"; "-2"; "-0,3i"
     */
    public ComplexNumber(String value) throws java.text.ParseException {
        String val = removeSpaces(value);
        parseComplexNumber(val);
    }
    
    /**
     * ������� ����� ���������� ComplexNumber
     * @param value ��������� ������ ComplexNumber.
     */
    public ComplexNumber(ComplexNumber value) {
        Re = value.getRe();
        Im = value.getIm();
    }
    
    /** ���������� �������������� ����� �����*/
    public double getRe() {
        return Re;
    }

    /** ���������� ������ ����� ����� */
    public double getIm() {
        return Im;
    }
    
    /** ����������� ����������� ����� � ������ */
    public String toString() {
        String retValue;
        NumberFormat nf = NumberFormat.getInstance();
        if(Re == 0)
            retValue = nf.format(Im) + "i";
        else
            if(Im > 0)
                retValue = nf.format(Re) + "+" + nf.format(Im) + "i";
            else
                retValue = nf.format(Re) + nf.format(Im) + "i";
        if(Im == 0)
            retValue = nf.format(Re);
        return retValue;
    }
    
    /* ������� ������� �� ������ str. ���������� ������ ��� �������� */
    private String removeSpaces(String str) {
        StringTokenizer st = new StringTokenizer(str);
        StringBuffer temp = new StringBuffer(str.length());
        while(st.hasMoreTokens())
        {
            temp.append(st.nextToken());
        }
        return temp.toString();
    }
    
    /* ����������� ������ str � ����������� ����� 
       (������ �� ������ ��������� ��������)*/
    private void parseComplexNumber(String str) 
                    throws java.text.ParseException {
        StringTokenizer st = new StringTokenizer(str, "+-", true);
        String previousToken = "";
        String currentToken = "";
        String numb = "";
        NumberFormat nf = NumberFormat.getInstance();
        while(st.hasMoreTokens())
        {
            currentToken = st.nextToken();
            if(previousToken.equals("-"))
                numb = previousToken + currentToken;
            else
                numb = currentToken;
            if(numb.equals("+") == false && numb.equals("-") == false)
            {
                if(numb.indexOf('i') == -1)
                    Re = nf.parse(numb).doubleValue();
                else
                {
                    numb = numb.replace('i', ' ');
                    if(numb.equals(" "))
                        numb = "1";
                    if(numb.equals("- "))
                        numb = "-1";
                    Im = nf.parse(numb).doubleValue();
                }
            }
            previousToken = currentToken;
        }
    }

    /** ��������� ����� �� ������ ����������� ����� ��������� 
     * @param value �������� ����� 
     */
    public boolean equal(ComplexNumber value) {
        if(Re == value.Re && Im == value.Im)
            return true;
        return false;
    }
    
    /** ���������� � ������� ������������ ����� ��������
     * @param value �������� �����
     */
    public void add(ComplexNumber value) {
        Re += value.Re;
        Im += value.Im;
    }
    
    /** �������� �� ������� ������������ ����� ��������
     * @param value �������� �����
     */
    public void sub(ComplexNumber value) {
        Re -= value.Re;
        Im -= value.Im;
    }
    
    /** �������� ������ ����������� ����� �� ��������
     * @param value �������� �����
     */
    public void mult(ComplexNumber value) {
        double tempRe = Re * value.Re - Im * value.Im;
        double tempIm = Re * value.Im + Im * value.Re;
        Re = tempRe;
        Im = tempIm;
    }

    /** ����� ������ ����������� ����� �� ��������
     * @param value �������� �����
     */
    public void div(ComplexNumber value) {
        double denominator = value.Re * value.Re + value.Im * value.Im;
        if(denominator == 0)
        {
            Re = Im = 0;
            return;
        }
        double tempRe, tempIm;
        tempRe = (Re * value.Re + Im * value.Im) / denominator;
        tempIm = (Im * value.Re - Re * value.Im) / denominator;
        Re = tempRe;
        Im = tempIm;
    }
}
