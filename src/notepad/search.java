/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author isuru
 */
public class search extends JFrame{
    JFrame nod;
    JPanel penal;
    JTextField text1;
    JTextField text2;
    JLabel lable1;
    JLabel lable2;
    JButton but1,but2,but3,but4;

    public search() throws HeadlessException {
       freme();
       panel();
       initcomporent();
       nod.setVisible(true);
      
    }
    public void freme(){
        nod = new JFrame();
        nod.setTitle("Search");
        nod.setBounds(400, 150, 600, 200);
        nod.setDefaultCloseOperation(EXIT_ON_CLOSE);
        nod.setResizable(false);
        nod.setLayout(null);
        
    }
  public void panel(){
      penal = new JPanel();
      penal.setBackground(Color.red);
      nod.add(penal);
  }
  
  public void initcomporent(){
      text1 = new JTextField();
      text1.setBounds(230, 40, 200, 30);
      
      text2 = new JTextField();
      text2.setBounds(230,105, 200, 30);
      
      lable1 = new JLabel("Find What");
      lable1.setBounds(100, 40, 200, 30);
      
      lable2 = new JLabel("RePlace With");
      lable2.setBounds(100, 105, 200, 30);
      
      but1 = new JButton("Fnd Next");
      but1.setBounds(440, 40, 120, 20);
      
      but2 = new JButton("Replace");
      but2.setBounds(440, 65, 120, 20);
      
      but3 = new JButton("Replace All");
      but3.setBounds(440, 90, 120, 20);
      
      but4 = new JButton("Cancel");
      but4.setBounds(440, 115, 120, 20);
      
      
     
      nod.add(text1);
      nod.add(text2);
      nod.add(lable1);
      nod.add(lable2);
      
      nod.add(but1);
      nod.add(but2);
      nod.add(but3);
      nod.add(but4);
      
  }
    
    
    public static void main(String[] args) {
        search sear = new search();
       
    }
    
    
}
