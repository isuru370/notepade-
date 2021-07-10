/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;



import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Document;
import static notepad.Notepad.area;



/**
 *
 * @author fernando
 */
public class fontChooser extends JFrame implements ActionListener{
    
    
    JList fonds,jStyle,jSize;
    Font thisFont;
    JTextArea tf;
    JScrollPane panel1,penal2,panel3;
    JTextArea ta;
    public fontChooser() {
          initComponents();
    }
    public static void main(String[] args) {
        new fontChooser().setVisible(true);
        
    }
    public void initComponents(){
        setTitle("Fond Chooser");
        setBounds(40, 80, 380, 450);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
       
        
        String [] fondNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        
        fonds = new JList(fondNames);
        fonds.setSelectedIndex(0);
        JScrollPane fon = new JScrollPane(fonds);
        fon.setBounds(40, 40, 150, 200); 
        
        fonds.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ta.setFont(createFont());
                area.setFont(createFont());
            }
        });
        
        
        String[] fontStyles={"Regular","Italic","Bold","Bold Italic"};
        jStyle=new JList(fontStyles);
        jStyle.setSelectedIndex(0); 
        JScrollPane fon1 = new JScrollPane(jStyle);
        fon1.setBounds(200, 40, 100, 200);
        
        jStyle.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ta.setFont(createFont());
                area.setFont(createFont());
            }
        });
       
        String[] fontSizes=new String[30];
        for(int j=0; j<30; j++)
	fontSizes[j]=new String(10+j*2+"");
        
        jSize=new JList(fontSizes);
        jSize.setSelectedIndex(0); 
        JScrollPane fon2 = new JScrollPane(jSize);
        fon2.setBounds(310, 40, 50, 200);
        
        jSize.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               ta.setFont(createFont());
               area.setFont(createFont());
               
            }
        });
        
        JLabel font = new JLabel("Font");
        font.setBounds(40, 20, 50, 20);
        
        JLabel font_stely = new JLabel("Font Stely");
        font_stely.setBounds(200, 20, 100, 20);
        
        JLabel font_size = new JLabel("Font Size");
        font_size.setBounds(310, 20, 100, 20);
       
        
//        JButton ok = new JButton("OK");
//        ok.setBounds(280, 280, 80, 20);
//        ok.addActionListener(this);
        
        ta = new JTextArea((Document) thisFont);
        ta.append("achintha ISURU");
        ta.append("084256754");
        ta.append("$%^&&*&%%^$^(*&^^");
        JScrollPane tax = new JScrollPane(ta);
        tax.setBounds(50, 250, 300, 80);
        
       
       

       
        
        add(fon);
        add(fon1);
        add(fon2);
        add(font);
        add(tax);
        add(font_stely);
        add(font_size);
     
//        add(ok);
        
    }
    public Font createFont()
{
Font fnt=thisFont;
int fontstyle=Font.PLAIN;
int x=jStyle.getSelectedIndex();

switch(x)
{
case 0:
	fontstyle=Font.PLAIN;	
        break;
case 1:
	fontstyle=Font.ITALIC;	
        break;
case 2:
	fontstyle=Font.BOLD;	
        break;
case 3:
	fontstyle=Font.BOLD+Font.ITALIC;	
        break;
}

int fontsize=Integer.parseInt((String)jSize.getSelectedValue());
String fontname=(String)fonds.getSelectedValue();

fnt=new Font(fontname,fontstyle,fontsize);

return fnt;

}

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("OK")){
           
       }
    }

}
