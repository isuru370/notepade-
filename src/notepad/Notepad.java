package notepad;


import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.Element;
import javax.swing.undo.UndoManager;



public class Notepad extends JFrame implements ActionListener,KeyListener {
    
    JFrame window;
    public static JTextArea area;
    private JScrollPane scpane;
    String text = "";
    JLabel statusBar;
    Color colors;
    String cname;
    JMenuBar menuBar;
    JMenu edit,file,about,viwe,look,color,fromet;
    JMenuItem newdoc,open,save,saveas,print,exit,copy,paste,cut,selectall,notepad,metal,nimbus,cde,windows,windowsc,black,
              white,green,blue,pink,dark_gray,red,yellow,orenge,Magenta,fond,Topcol,backg,undo,redo;
    String Filename;
    String Fileaddress;
    FileNameExtensionFilter onlifile;
    UndoManager unandre;
    String text2;
    JTextArea line;
   
   
    
   
    public Notepad() {
        cratwindo();
        initComponents();
        textarea();
        Popmenu();
        window.setVisible(true);
        setLineNumbers();
        
        
      
    }
    
    public void cratwindo(){
        window = new JFrame("Notepad");
        window.setBounds(350,60,750, 600);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        statusBar =new JLabel("||       Ln 1, Col 1  ",JLabel.RIGHT);
        window.add(statusBar,BorderLayout.SOUTH);
        
    }
    public void textarea(){
         area = new JTextArea();
         scpane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scpane.setBorder(BorderFactory.createEtchedBorder());
         window.add(scpane);
         window. add(scpane, BorderLayout.CENTER);
         area.getDocument().addUndoableEditListener(unandre);
         area.setWrapStyleWord(true);
         area.setLineWrap(true);
         area.addKeyListener(this);
         un();
         
    }
    public void initComponents(){
        
        menuBar = new JMenuBar(); //menubar
        unandre = new UndoManager();
//      menuBar.setBackground(color.getGreen());
  //================================================== menu add ==================================== 
        newdoc = new JMenuItem("New");     
        file = new JMenu("File"); //file menu
        edit = new JMenu("Edit");
        about = new JMenu("Help");
        viwe = new JMenu("Viwe");
        look = new JMenu("Look And Feel");
        color = new JMenu("Font Color");
        fromet = new JMenu("Format");
 

//========================================== About calss call ========================================
          
         notepad = new JMenuItem("About Notepad");
        
 //========================================================= menuItems ======================================        
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save As");
        print = new JMenuItem("Print");
        exit = new JMenuItem("Exit");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        cut = new JMenuItem("Cut");
        selectall = new JMenuItem("Select All");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
       
//==================================================lookandfeel Items ==============================================        
        metal = new JMenuItem("Metel");
        nimbus = new JMenuItem("Nimbus");
        cde = new JMenuItem("CDE/Motif");
        windows = new JMenuItem("Windows");
        windowsc = new JMenuItem("Windows Classic");
       
//========================================================normal color  items ===========================================
        black = new JMenuItem("Black");
        white = new JMenuItem("White");
        green = new JMenuItem("Green");
        blue = new JMenuItem("Blue");
        pink = new JMenuItem("Pink");
        dark_gray = new JMenuItem("Dark gray");
        red = new JMenuItem("Red");
        yellow = new JMenuItem("Yellow");
        orenge = new JMenuItem("Orenge");
        Magenta = new JMenuItem("Magenta");
        
//================================================ totpup color ==========================================================        
        fond = new JMenuItem("Fond");
        Topcol = new JMenuItem("Top Fnd Color");
        backg = new JMenuItem("Top BackGround Color");
        
        //============================================  Shot Key =========================================      
        
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
         
  //================================================= menuitems ActionListener ===============================        
        newdoc.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        selectall.addActionListener(this);
        notepad.addActionListener(this);
 //================================================== look and feel ActionListener =============================        
        metal.addActionListener(this);
        nimbus.addActionListener(this);
        cde.addActionListener(this);
        windows.addActionListener(this);
        windowsc.addActionListener(this);
//=================================================== color ActionListener ==============================   
         black.addActionListener(this);
         white.addActionListener(this);
         green.addActionListener(this);
         blue.addActionListener(this);
         pink.addActionListener(this);
         dark_gray.addActionListener(this);
         red.addActionListener(this);
         yellow.addActionListener(this);
         Magenta.addActionListener(this);
//================================================= color ActtionLisner ==============================         
         fond.addActionListener(this);
         Topcol.addActionListener(this);
         backg.addActionListener(this);
         
         
         redo.addActionListener(this);
        
       
        
//        area = new JTextArea();
//        area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
//        area.setLineWrap(true);
//        area.setWrapStyleWord(true);
//        
//        scpane = new JScrollPane(area); 
//        scpane.setBorder(BorderFactory.createEmptyBorder());
//        
        window.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(viwe);
        menuBar.add(fromet);
        menuBar.add(about);
        

        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(print);
        file.add(exit);
        
        
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);
        edit.add(undo);
        edit.add(redo);
        
        about.add(notepad);
        
        viwe.add(color);
         color.add(black);
        color.add(white);
        color.add(green);
        color.add(blue);
        color.add(pink);
        color.add(dark_gray);
        color.add(red);
        color.add(yellow);
        color.add(orenge);
        color.add(Magenta);
        fromet.add(fond);
        fromet.add(Topcol);
        fromet.add(backg);
        
        viwe.add(look);
        look.add(metal);
        look.add(nimbus);
        look.add(cde);
        look.add(windows);
        look.add(windowsc);
 
//        add(scpane, BorderLayout.CENTER);
       
        
    }

    public void Popmenu(){
        final JPopupMenu pop = new JPopupMenu();
        JMenuItem New = new JMenuItem("New");
        New.addActionListener(this);
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        JMenuItem paset = new JMenuItem("Paste");
        paset.addActionListener(this);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        JMenuItem saveas = new JMenuItem("Save As");
        saveas.addActionListener(this);
        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(this);
        
        JMenuItem run = new JMenuItem("Run");
        run.addActionListener(this);
        
        JMenuItem compile = new JMenuItem("Compile");
        compile.addActionListener(this);
        
        pop.add(New);
        pop.add(open);
        pop.add(run);
        pop.add(compile);
        pop.add(cut);
        pop.add(copy);
        pop.add(paset);
        pop.add(save);
        pop.add(saveas);
        pop.add(print);
        
           area.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              if(e.getButton() == 3){
                  pop.show(area, e.getX(), e.getY());
              }
            }

            @Override
            public void mousePressed(MouseEvent e) {
              
            }

            @Override
            public void mouseReleased(MouseEvent e) {
              
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
        
       
    }
     public void setLineNumbers() {
        line = new JTextArea(0, 3);
        line.setEditable(false);
        line.setBackground(Color.GRAY);
        line.setForeground(Color.WHITE);
        line.setFont(new Font("Tahoma", 0, 18));

        DocumentListener d = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                line.setFont(area.getFont());
                String s[] = getLine().split("\\n");
                statusBar.setText(s[s.length - 1]);
                line.setText(getLine());

            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                line.setFont(area.getFont());
                String s[] = getLine().split("\\n");
                statusBar.setText(s[s.length - 1]);
                line.setText(getLine());
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                line.setFont(area.getFont());
                String s[] = getLine().split("\\n");
                statusBar.setText(s[s.length - 1]);
                line.setText(getLine());
            }

            
        };
        area.getDocument().addDocumentListener(d);
        scpane.setRowHeaderView(line);
    }

    public String getLine() {
        int caretPos = 0;
        String lines;
        caretPos = area.getDocument().getLength();
        Element root = area.getDocument().getDefaultRootElement();
        lines = String.format("%s%s", 1, System.lineSeparator());

        for (int i = 2; i < root.getElementIndex(caretPos) + 2; i++) {
            lines += String.format("%s%s", i, System.lineSeparator());

        }

        return lines;

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("New")) {
           
            if(text2.isEmpty()){
                  
            area.setText("");
            window.setTitle("New");
            Filename = null;
            Fileaddress = null;
                 
            }else{     
             saved();
            }
           
        
        } else if (ae.getActionCommand().equals("Open")) {
             openfile();
           
        } else if(ae.getActionCommand().equals("Save")){
               saved();

        }else if(ae.getActionCommand().equals("Save As")){
            saveasfile();
        }
        else if(ae.getActionCommand().equals("Print")){
            
            try{
                if(!print.equals("")){
                  area.print();
                }else
                  {
                
                  }
            }catch(Exception e){}
        }else if (ae.getActionCommand().equals("Exit")) {
            int x = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?", "select",JOptionPane.YES_NO_CANCEL_OPTION);
            if(x == 0){
              
                 
            }if(x == 1){
                System.exit(0);
            }
           
        }else if (ae.getActionCommand().equals("Copy")) {
            text = area.getSelectedText();
        }else if (ae.getActionCommand().equals("Paste")) {
            area.insert(text, area.getCaretPosition());
        }else if (ae.getActionCommand().equals("Cut")) {
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }else if (ae.getActionCommand().equals("Select All")) {
            area.selectAll();
        }else if (ae.getActionCommand().equals("About Notepad")) {
            new About().setVisible(true);
            
        }else if(ae.getActionCommand().equals("Fond")){
            fontChooser fc = new fontChooser();
            fc.setVisible(true);
            
            
        }else if(ae.getActionCommand().equals("Black")){
            area.setForeground(Color.BLACK);
        }else if(ae.getActionCommand().equals("White")){
            area.setForeground(Color.WHITE);
        }else if(ae.getActionCommand().equals("Green")){
            area.setForeground(Color.GREEN);
        }else if(ae.getActionCommand().equals("Blue")){
            area.setForeground(Color.BLUE);
        }else if(ae.getActionCommand().equals("Pink")){
            area.setForeground(Color.PINK);
        }else if(ae.getActionCommand().equals("Dark gray")){
            area.setForeground(Color.DARK_GRAY);
        }else if(ae.getActionCommand().equals("Red")){
            area.setForeground(Color.RED);
        }else if(ae.getActionCommand().equals("Yellow")){
            area.setForeground(Color.YELLOW);
        }else if(ae.getActionCommand().equals("Orenge")){
            area.setForeground(Color.ORANGE);
        }else if(ae.getActionCommand().equals("Magenta")){
            area.setForeground(Color.MAGENTA);
        
        
        }else if(ae.getActionCommand().equals("Top Fnd Color")){
           colors();
        }else if(ae.getActionCommand().equals("Top BackGround Color")){
            backgroundcolors();
        }else if(ae.getActionCommand().equals("Compile")){
            compile();
        }else if(ae.getActionCommand().equals("Run")){
               
            try {
//                new classname().setVisible(true);
//                if(name1.equals("A")){
                 run(); 
//                }else
//                {
//                    System.out.println("weradi");
//                }
            } catch (Exception e) {
            }
              
  
        } else if(ae.getActionCommand().equals("Metel")){
            try {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            } catch (Exception ex) {
               
            }
        } else if(ae.getActionCommand().equals("Nimbus")){
            try {
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
            } catch (Exception ex) {
               
            }
        }else if(ae.getActionCommand().equals("CDE/Motif")){
            try {
                UIManager.setLookAndFeel(new MotifLookAndFeel());
            } catch (Exception ex) {
               
            }
        }else if(ae.getActionCommand().equals("Windows")){
            try {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
            } catch (Exception ex) {
               
            }
        }else if(ae.getActionCommand().equals("Windows Classic")){
            try {
                UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
            } catch (Exception ex) {
               
            }
        } else if(ae.getActionCommand().equals("Undo")){
            un();
        }else if(ae.getActionCommand().equals("Redo")){
            re();
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        new Notepad();
        
    }
    
    public void openfile(){
           
        FileDialog fd = new FileDialog(window,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!= null){
        fd.getFilenameFilter();
            
            Filename = fd.getFile();
            Fileaddress = fd.getDirectory();
            window.setTitle(Filename);
        }
        System.out.println("File Address And File Name " + Fileaddress + Filename);
        try {
            BufferedReader br = new BufferedReader( new FileReader(Fileaddress + Filename));
            area.setText("");
            String line = null;
            while((line = br.readLine())!= null){
            area.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File Not Open");
        }
           
//           comformsave();             
//            JFileChooser chooser = new JFileChooser("D:\\");
//            chooser.setAcceptAllFileFilterUsed(false);
//            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt"); 
//            FileNameExtensionFilter java = new FileNameExtensionFilter("Only .java file", "java");
//            chooser.addChoosableFileFilter(restrict);
//            chooser.addChoosableFileFilter(java);
//    	
//            int result = chooser.showOpenDialog(this);
//            if(result == JFileChooser.APPROVE_OPTION) {
//            File file = chooser.getSelectedFile();
//            cname = chooser.getSelectedFile().getAbsolutePath();
//            System.out.println(cname);
//                
//            
//				
//                try{
////                 System.out.println("Achi");
//                    FileReader reader = new FileReader(file);
//                    BufferedReader br = new BufferedReader(reader);
//                    area.read(br, null );
//                    br.close();
//                    area.requestFocus();
//                }catch(Exception e){
//                    System.out.print(e);
//                }
//            }
                     
}
    
    public void saveasfile(){
        
        FileDialog fd = new FileDialog(window,"Save As",FileDialog.SAVE);
        fd.setVisible(true);
        
        if(fd.getFile()!= null){
        Filename = fd.getFile();
        Fileaddress = fd.getDirectory();
        window.setTitle(Filename);
        }
        
        try {
            FileWriter fw = new FileWriter(Fileaddress + Filename);
            fw.write(area.getText());
            fw.close();
            JOptionPane.showMessageDialog(null," File" + Filename + " successfull in " + Fileaddress);
        } catch (Exception e) {
        }
        
        
        
        
//           final JFileChooser SaveAs = new JFileChooser();
//            SaveAs.setApproveButtonText("Save");
//            
//            int actionDialog = SaveAs.showOpenDialog(this);
//            if (actionDialog != JFileChooser.APPROVE_OPTION) {
//                return;
//            }
//
//            File fileName = new File(SaveAs.getSelectedFile() + ".txt");
//            BufferedWriter outFile = null;
//            try {
//                outFile = new BufferedWriter(new FileWriter(fileName));
//                area.write(outFile);
//                cname = SaveAs.getSelectedFile().getAbsolutePath();
//                System.out.println(cname);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
    }
    
    public void saved(){
        int x =  JOptionPane.showConfirmDialog(null,"Do you wont save file ", "Select", JOptionPane.YES_NO_CANCEL_OPTION);
        if( x == 0){
             if(Filename == null){
             saveasfile();
        } if(x == 1){
            area.setText("");
            window.setTitle("New");
            Filename = null;
            Fileaddress = null;
        }
      
       }else{
           try {
                FileWriter fw = new FileWriter(Fileaddress + Filename);
                fw.write(area.getText());
                window.setTitle(Filename);
                fw.close();
           } catch (Exception e) {
           }
       }
        
        
    }
    public void colors(){
        
        colors = colors.WHITE;
         colors = JColorChooser.showDialog(this, "Select a color", colors);
         if(colors == null){
             colors = colors.black;
             area.setForeground(colors);
         }
         area.setForeground(colors);
    }
    public void backgroundcolors(){
        
        colors = colors.WHITE;
         colors = JColorChooser.showDialog(this, "Select a color", colors);
         if(colors == null){
             colors = colors.WHITE;
             area.setBackground(colors);
         }
         area.setBackground(colors);
    }
    public void run() throws IOException, InterruptedException{
        
        try {
            System.out.println(cname);
            String runs = cname.substring(0,cname.lastIndexOf("\\"));
            System.out.println(runs);
            
                 
//           JTextField name = classname.javaclassname;
             Process process=Runtime.getRuntime().exec("java -cp "+ runs +" A");
             System.out.println(process);     
             StringBuilder bilder = new StringBuilder();
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             String line;
             
             while((line = reader.readLine())!= null){
              bilder.append(line + "\n");
             }
             int exitVal = process.waitFor();
             System.out.println(bilder);
             if(exitVal == 0){
                 System.out.println("Success");
                 System.out.println(cname);
               
                 
             }else{
                 System.out.println("somet hing abnormal has haapened : ");
             }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        }
     public void compile(){
       
         try {
            Runtime.getRuntime().exec("javac "+cname);
             
            
//          fname =  s.toString();
              
         } catch (Exception e) {
         }
     }
     public void un(){
         if(text == null){
              undo.setEnabled(false);  
            
         }else if(area != null){
             setEnabled(true);
               undo.addActionListener(this); 
         }
        
     }
    public void re(){
        unandre.redo();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        text2 = area.getText();
        System.out.println(text2);
    }
//     public void opense(){
//        JFileChooser  fi = new JFileChooser(".");
//        fi.setDialogType(JFileChooser.CANCEL_OPTION);
//        fi.setDialogTitle("open ");
//        fi.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        fi.setFileHidingEnabled(false);
//        fi.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        fi.setMultiSelectionEnabled(true);
//        
//        int rs = fi.showOpenDialog(fi);
//        
//        if(rs == JFileChooser.APPROVE_OPTION);
//        File sf = fi.getSelectedFile();
//        FileFilter select = (FileFilter) fi.getFileFilter();
//        
//     Filename = sf.getName();
//     Fileaddress = sf.getParent();
//     
//         try {
//            BufferedReader br = new BufferedReader( new FileReader(Fileaddress + Filename));
//            area.setText("");
//            String line = null;
//            while((line = br.readLine())!= null){
//            area.append(line + "\n");
//            }
//            br.close();
//        } catch (Exception e) {
//            System.out.println("File Not Open");
//    }
//    }
}
        
         
    

