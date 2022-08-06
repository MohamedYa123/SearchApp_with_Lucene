/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.searchapp;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
/**
 *
 * @author medo1
 */
public class frmresult extends javax.swing.JFrame {

    /**
     * Creates new form frmresult
     */
    public frmresult() {
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(153,255,255));
        DefaultListModel df=new DefaultListModel();
        jres.setModel(df);
        //this.jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        //jLabel1.setVerticalAlignment(SwingConstants.TOP);
        this.getContentPane().setBackground(new java.awt.Color(153,255,255));
        this.setTitle("نتيجة البحث");
        textlog.setText("hh");
       // this.jLabel1.setText("<html> Type: TextFile <br> Size : 20 kb <br>Last edited : 30/10/2000 </html>");
       // this.jButton1.setVisible(false);
       jres.removeAll();
           ListSelectionListener listSelectionListener = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
         // System.out.println("selcted\n");
          var j=jres.getSelectedIndex();
          var item=jres.getModel().getElementAt(j);
          jList2.setSelectedIndex(j);
          jList3.setSelectedIndex(j);
         // System.out.println("\n"+item+"");
          try {
              setcontent(item);
          } catch (IOException ex) {
              Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    };
    ListSelectionListener ll2 = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
                var j=jList2.getSelectedIndex();
        //  var item=jres.getModel().getElementAt(j);
          jres.setSelectedIndex(j);
          jList3.setSelectedIndex(j);
      }};
    ListSelectionListener ll3 = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
                var j=jList3.getSelectedIndex();
         // var item=jres.getModel().getElementAt(j);
          jres.setSelectedIndex(j);
          jList2.setSelectedIndex(j);
      }};
        
    jres.addListSelectionListener(listSelectionListener);
    jList2.addListSelectionListener(ll2);
    jList3.addListSelectionListener(ll3);
    this.jList2.setModel(new DefaultListModel());
    this.jList3.setModel(new DefaultListModel());
}
    public void setresults(ArrayList<String> sf){
        //var l=sf.split("\n");
        if (sf==null){
            return;
        }
        DefaultListModel df=new DefaultListModel();
        DefaultListModel df2=new DefaultListModel();
        DefaultListModel df3=new DefaultListModel();
        for (String l1 : sf) {
            File f=new File(l1);
            if (!"".equals(l1)){
                df.addElement(l1);
            }
            df2.addElement(f.length()/1024);
            var s=f.getName();
            var g=s.split("\\.");
            df3.addElement(g[g.length-1]);
        }
        jres.setModel(df);
        jList2.setModel(df2);
        jList3.setModel(df3);
    }
    public void settable(ArrayList<String> sf){
    String[] columnNames = {"File name",
                        "Size (kb)",
                        "Date of creation",
                        "date of modification"};
    Object[][] data=new Object[columnNames.length][sf.size()];
    JTable table = new JTable(data, columnNames);
    
    }
    public String content;
    boolean pdfv=false;
    File ff;
    private void setcontent(String path) throws IOException{
        pdfv=path.endsWith(".pdf");
        File f=new File(path);
        ff=f;
        content=readfile(f);
        Path path2=Path.of(f.getPath());
        var attr = Files.readAttributes(path2, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        var ctime=new Date(fileTime.toMillis());
        var etime=new Date(attr.lastModifiedTime().toMillis());
        String s="Location : "+path;
        s+="\nCreation Time : "+ctime;
        s+="\nLast Edit Time : "+etime;
        this.textlog1.setText(s);
    }
    public String readfile(File file) throws FileNotFoundException, IOException{
            BufferedReader br
            = new BufferedReader(new FileReader(file));
        String data="";
        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        if (file.getName().endsWith(".pdf")){
            return "";
        }
        while ((st = br.readLine()) != null){
            data+=st+"\n";}
        return data;
    }
    
    public LuceneTester lt; 
    public mythread mth;
                                            
    public frm1 form1=null;
    public about form2=null;
    public records form3=null;
    public frmresult form4=null;
    public Fileview form5=null;
    void goback(){
        if (form1!=null){
            form1.setVisible(true);
            form1.setLocationRelativeTo(null);
        }
        if (form2!=null){
                 form2.setVisible(true);
            form2.setLocationRelativeTo(null);
        }
        if (form3!=null){
                    form3.setVisible(true);
            form3.setLocationRelativeTo(null);
        }
        if (form4!=null){
                    form4.setVisible(true);
            form4.setLocationRelativeTo(null);
        }
        if (form5!=null){
                    form5.setVisible(true);
            form5.setLocationRelativeTo(null);
        }
        this.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollbar1 = new java.awt.Scrollbar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textlog = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jres = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textlog1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        scrollbar1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                scrollbar1MouseWheelMoved(evt);
            }
        });

        textlog.setColumns(20);
        textlog.setRows(5);
        textlog.setText("\n");
        jScrollPane1.setViewportView(textlog);

        jres.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jres);

        jLabel3.setText("النتائج");

        jLabel4.setText("تفاصيل البحث");

        jLabel5.setText("معلومات الملف");

        textlog1.setColumns(20);
        textlog1.setRows(5);
        textlog1.setText("\n");
        jScrollPane3.setViewportView(textlog1);

        jButton1.setText("عرض الملف");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("عودة");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jList2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList3);

        jLabel1.setText("عنوان الملف");

        jLabel2.setText("الحجم (ك,.ب)");

        jLabel6.setText("النوع");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(331, 331, 331))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(279, 279, 279)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scrollbar1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_scrollbar1MouseWheelMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_scrollbar1MouseWheelMoved

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (pdfv){
            try {
                //  try {
                // pdfView f=new pdfView();
                //  f.setpdfv(ff);
                // f.setVisible(true);
                // f.setLocationRelativeTo(null);
                // } catch (IOException ex) {
                // Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
                // }
                content=readpdfv(ff);
            } catch (IOException ex) {
                Logger.getLogger(frmresult.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    //    else{
        Fileview f=new Fileview();
        f.form4=this;
        f.word=lt.searchword;
        f.data=content;
        f.setselections(); 
        f.setVisible(true);
        f.setLocationRelativeTo(null);//}
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        goback();
    }//GEN-LAST:event_jButton2ActionPerformed
     public String readpdfv(File file) throws IOException{
        try ( //File file = new File("D:/example.pdf");
                PDDocument document = PDDocument.load(file)) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setStartPage(1);
            pdfTextStripper.setEndPage(5);
            String text  = pdfTextStripper.getText(document);
            return text;
            //this.jTextArea1.setText(text);
          //  System.out.println(text);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmresult().setVisible(true);
            }
        });
    }
    public void settext(String s){
        textlog.setText(s);
        textlog.select(textlog.getText().length()-2, 0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> jres;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JTextArea textlog;
    private javax.swing.JTextArea textlog1;
    // End of variables declaration//GEN-END:variables
}
