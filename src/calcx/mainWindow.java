/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcx;
import java.io.*;
import java.awt.*;
import java.lang.*;
import static calcx.gcd.*;
import javax.swing.*;
import calcx.CALCX.*;
import static calcx.CALCX.buildMap;
import static calcx.CALCX.funcMap;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
/**
 *
 * @author SHAWN
 */
public class mainWindow extends javax.swing.JFrame {
    /**
     * Creates new form mainWindow
     */    
    public String content;
    public static File InputHistory = new File("InputHistory.txt");
    public static File OutputHistory = new File("OutputHistory.txt");
    public void setOutputText (String a){
        JTextArea t = new JTextArea();
        OutputArea.setText(a);
    }
    
    public mainWindow() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OutputArea = new javax.swing.JTextArea();
        ComputeButton = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputArea = new javax.swing.JTextArea();
        HistoryButton = new javax.swing.JLabel();
        ClearButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OutputArea.setColumns(20);
        OutputArea.setRows(5);
        jScrollPane1.setViewportView(OutputArea);

        ComputeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calcx/images/Untitled drawing.png"))); // NOI18N
        ComputeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComputeButtonMouseClicked(evt);
            }
        });

        InputArea.setColumns(20);
        InputArea.setRows(5);
        InputArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        InputArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputAreaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(InputArea);

        HistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calcx/images/his.png"))); // NOI18N
        HistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistoryButtonMouseClicked(evt);
            }
        });

        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calcx/images/Clear button.png"))); // NOI18N
        ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(HistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComputeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(HistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComputeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HistoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryButtonMouseClicked
        try {
            String hisTempIn = (readHistory(InputHistory));
            InputArea.setText(hisTempIn + InputArea.getText()); //update input window
            String hisTempOut = (readHistory(OutputHistory));
            OutputArea.setText(hisTempOut + OutputArea.getText());//update output window
            deleteHistory (InputHistory);
            deleteHistory (OutputHistory);
        } catch (IOException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_HistoryButtonMouseClicked

    private void ComputeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComputeButtonMouseClicked
        content = "";
        int caretPos = InputArea.getCaretPosition();
        int rowNum = (caretPos == 0) ? 1 : 0;
        for (int offset = caretPos; offset > 0;) {
            try {
                offset = Utilities.getRowStart(InputArea, offset) - 1;
            } catch (BadLocationException ex) {
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            rowNum++;
        }
        //now rowNum returns the caret position of the row.
        int line;
        try {
            line = InputArea.getLineOfOffset( InputArea.getCaretPosition() );
            int start = InputArea.getLineStartOffset( line );
            int end = InputArea.getLineEndOffset( line );
            content = InputArea.getDocument().getText(start, end - start);
        } catch (BadLocationException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        numlist = new ArrayList<Integer>();
        buildMap (funcMap, content);
        String command = content.substring(0,content.indexOf("("));        
        command = command.replaceAll("\\s","");        
        try {
            System.out.println(funcMap.get(command).call().toString());
            OutputArea.append(funcMap.get(command).call().toString()+"\n");
            InputArea.setText(InputArea.getText() + "\n");            
        } catch (Exception ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_ComputeButtonMouseClicked

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        WriteHistory(InputArea.getText(), InputHistory);
        WriteHistory(OutputArea.getText(), OutputHistory);
        InputArea.setText("");
        OutputArea.setText("");
        content = "";
        numlist = new ArrayList<Integer>();
        
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void InputAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputAreaKeyPressed
        
    }//GEN-LAST:event_InputAreaKeyPressed

    private void InputAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputAreaKeyReleased
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            content = "";
            int line;
            try {
                line = InputArea.getLineOfOffset(InputArea.getCaretPosition())-1;
                int start = InputArea.getLineStartOffset( line );
                int end = InputArea.getLineEndOffset( line );
                content = InputArea.getDocument().getText(start, end - start);
            } catch (BadLocationException ex) {
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            numlist = new ArrayList<Integer>();
            buildMap (funcMap, content);
            String command = content.substring(0,content.indexOf("("));        
            command = command.replaceAll("\\s","");        
            try {
                System.out.println(funcMap.get(command).call().toString());
                OutputArea.append(funcMap.get(command).call().toString()+"\n");
                InputArea.setText(InputArea.getText());            
            } catch (Exception ex) {
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_InputAreaKeyReleased
    
    public static void WriteHistory (String a, File b){                
        try{
                Writer fileWriter;
                fileWriter = new BufferedWriter(new FileWriter(b, true)); 
                fileWriter.append("!@#$%^\n");  
                fileWriter.append(a);              
                fileWriter.close();
                }
            catch (FileNotFoundException ex){
                System.out.println("Cannot find the file "+ b);
            }
            catch (IOException e) {
                e.printStackTrace();
            }          
    }
    
    public static String readHistory (File b) throws IOException{
        String line = "";
        String acc = "";
        FileReader fileReader = new FileReader(b);
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while (true){
            line = bufferedReader.readLine();
            if (line == null){
                break;
            }
            else if (line.equals("!@#$%^")){
                acc = "";
            }
            else {
                acc = acc + line + "\n";
            }
         }
        return acc;//note that acc ends with a \n
    }
    
    
    public static void deleteHistory (File b) throws IOException{
        //read the existing file to a string.
        String line = null;
        String acc = "";
        FileReader fileReader = new FileReader(b);
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        while (true){
            line = bufferedReader.readLine();
            if (line == null){
                break;
            }
            else {
                acc = acc + line + "\n";
            }
         }
        //delete the part of string that has already been redisplayed on textAreas.
        while (!(acc.substring(acc.length()-6,acc.length()).equals("!@#$%^"))){            
            acc = acc.substring(0, acc.length()-1);
        }
        acc = acc.substring(0, acc.length()-5);
        //update the text file without the displayed string.
        try{
                Writer fileWriter;
                fileWriter = new BufferedWriter(new FileWriter(b, false));
                if (!(acc.equals(""))){
                    fileWriter.write(acc.substring(0,acc.length()-2));
                }               
            fileWriter.close();
            }
            catch (FileNotFoundException ex){
                System.out.println("Cannot find the file "+ b);
            }
            catch (IOException e) {
                e.printStackTrace();
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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
               
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClearButton;
    private javax.swing.JLabel ComputeButton;
    private javax.swing.JLabel HistoryButton;
    private javax.swing.JTextArea InputArea;
    private javax.swing.JTextArea OutputArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
