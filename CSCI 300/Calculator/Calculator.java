/****************************************************************
   Program:     Calculator.java
   Course Info: CSCI: 300, section 001
   Author:      Josh Howard
   Date:        12/1/2017
   Description: Creates a functioning binary calculator GUI
*****************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator
{
   private int final_num = 0;
   private String equ_display = "", binary_string = "", last_operand = "~";
   private JButton zero, one, plus, minus, divide, multiple, clear, equals;
   private JLabel label;
   private JPanel FullPanel,keyPanel1, keyPanel2, numPanel;
   
//--------------------------------------------------------------
//  runs CalculatorGUI()
//--------------------------------------------------------------   
   public Calculator()
   {
      CalculatorGUI();
   }
   
//--------------------------------------------------------------
//  Creates GUI
//--------------------------------------------------------------  
   public void CalculatorGUI()
   {
      JFrame frame = new JFrame("Binary Calculator");
      frame.setVisible(true);
      frame.setSize(200,400);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      zero = new JButton("O");
      one = new JButton("1");
      plus = new JButton("+");
      minus = new JButton("-");
      divide = new JButton("/");
      multiple = new JButton("*");
      clear = new JButton("C");
      equals = new JButton("=");
      
      ButtonListener listener = new ButtonListener();
      zero.addActionListener(listener);
      one.addActionListener(listener);
      plus.addActionListener(listener);
      minus.addActionListener(listener);
      divide.addActionListener(listener);
      multiple.addActionListener(listener);
      clear.addActionListener(listener);
      equals.addActionListener(listener);
      
      label = new JLabel("0");
      label.setFont(new Font("", Font.PLAIN, 25));
      
      numPanel = new JPanel();
      
      numPanel.add(label);
      
      keyPanel1 = new JPanel(new GridLayout(0,2));
      
      keyPanel1.add(zero);
      keyPanel1.add(one);
      keyPanel1.add(plus);
      keyPanel1.add(minus);
      
      keyPanel2 = new JPanel(new GridLayout(0,2));
      
      keyPanel2.add(divide);
      keyPanel2.add(multiple);
      keyPanel2.add(clear);
      keyPanel2.add(equals);
      
      
      FullPanel = new JPanel(new GridLayout(3,1));
      
      FullPanel.add(numPanel);
      FullPanel.add(keyPanel1);
      FullPanel.add(keyPanel2);
      
      frame.add(FullPanel);

   }
   
   private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Reads in 0 and 1 numbers, sets actions to perform
      //--------------------------------------------------------------
      public void actionPerformed(ActionEvent event)
      {
         if (event.getSource() == zero)
         {
            equ_display = equ_display + "0";
            label.setText(equ_display);
            binary_string = binary_string + "0";
         }
         else if (event.getSource() == one)
         {
            equ_display = equ_display + "1";
            label.setText(equ_display);
            binary_string = binary_string + "1";
         }
         else if (event.getSource() == plus)
         {
            equ_display = equ_display + "+";
            label.setText(equ_display);
            PerformAction(last_operand);
            last_operand = "+";
         }
         else if (event.getSource() == minus)
         {
            equ_display = equ_display + "-";
            label.setText(equ_display);
            PerformAction(last_operand);
            last_operand = "-";
         }
         else if (event.getSource() == divide)
         {
            equ_display = equ_display + "/";
            label.setText(equ_display);
            PerformAction(last_operand);
            last_operand = "/";
         }
         else if (event.getSource() == multiple)
         {
            equ_display = equ_display + "*";
            label.setText(equ_display);
            PerformAction(last_operand);
            last_operand = "*";
         }
         else if (event.getSource() == clear)
         {
            final_num = 0;
            equ_display = "";
            binary_string = "";
            label.setText("0");
            
         }
         else if (event.getSource() == equals)
         {              
            PerformAction(last_operand);
            last_operand = "~";
            equ_display = BinaryDecimal.DecimalToBinary(final_num);
            label.setText(equ_display);
            binary_string = equ_display;
         }
      }
   }
   
//--------------------------------------------------------------
//  Performs action
//--------------------------------------------------------------
   public void PerformAction(String temp)
   {
      if (temp.equals("+"))
         final_num = final_num + BinaryDecimal.BinaryToDecimal(binary_string);
      else if (temp.equals("-"))
         final_num = final_num - BinaryDecimal.BinaryToDecimal(binary_string);
      else if (temp.equals("/"))
         final_num = final_num / BinaryDecimal.BinaryToDecimal(binary_string);
      else if (temp.equals("*"))
         final_num = final_num * BinaryDecimal.BinaryToDecimal(binary_string);
      else if (temp.equals("~"))
         final_num = BinaryDecimal.BinaryToDecimal(binary_string);
      binary_string = "";
   }
   
   public static void main(String[] args)
   {
      new Calculator();
   }
}