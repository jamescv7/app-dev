/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package awtexample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AWTExample extends Frame{
    
    JFrame inputFrame = new JFrame();
    JFrame outputFrame = new JFrame();
    
    JPanel inputPanel = new JPanel();
    JPanel outputPanel = new JPanel();
    
    JTextField inputField = new JTextField(20);
    JLabel inputLabel = new JLabel("Enter Host Address: ");
    JLabel outputIp = new JLabel();
    JTextArea outputArea = new JTextArea(5, 15);
    
    JButton btnFindIp = new JButton("Find IP");
    JButton btnClear = new JButton("Clear");
    JButton btnOkay = new JButton("Okay");
    
    FlowLayout fl = new FlowLayout();
    Font setFont = new Font("", Font.BOLD, 14);
    
    public AWTExample(){
        this.setSize(250,150);
        this.setLocation(200, 200);
        this.setTitle("INPUT");
        this.setResizable(true);
        
        inputFrame.add(inputPanel);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        
        inputPanel.add(btnFindIp);
        btnFindIp.addActionListener(new btnFindIp());
        inputPanel.add(btnClear);
        btnClear.addActionListener(new btnClear());
        
        this.add(inputPanel);
        this.setVisible(true);
    }
    
    
    class btnFindIp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            try{
                String host = inputField.getText();
                String ip = java.net.InetAddress.getByName(host).getHostAddress();
                outputArea.append("Host Address: \n  " + host + 
                        "\n\nIP Address: \n " + ip + "\n");
                             
            }catch(Exception ex){
                System.out.println(ex);
            }
            
            outputFrame.setSize(230, 185);
            outputFrame.setLocation(430, 240);
            outputFrame.setTitle("OUTPUT 21234");
            outputFrame.setResizable(false);
            outputFrame.setVisible(true);
            
            outputArea.setEditable(false);
            outputArea.setFont(setFont);
            
            outputFrame.add(outputPanel);
            
            outputPanel.add(outputArea);
            outputPanel.add(outputIp);
            outputPanel.add(btnOkay);

            btnFindIp.setEnabled(false);
            btnOkay.addActionListener(new btnOkay());

            System.out.println("Hello World");
            
        }
    }
    
    class btnClear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            inputField.setText("");
            outputArea.setText((""));
            btnFindIp.setEnabled(true);
            outputFrame.dispose();
        }
    
    }
    
    class btnOkay implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent i){
            inputField.setText("");
            outputArea.setText("");
            btnFindIp.setEnabled(true);
            outputFrame.dispose();
        }
    }
            
            
    
  
    public static void main(String[] args) {
       AWTExample f = new AWTExample();    
    }
    
}
