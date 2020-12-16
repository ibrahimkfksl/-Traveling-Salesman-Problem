package prolab21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SonucEkrani extends javax.swing.JFrame {

    DefaultListModel model = new DefaultListModel();
    
    private static HashMap<String, Integer> plakaNo = new HashMap<String, Integer>();
	private static ArrayList<Sehir> sehir_bilgisi = new ArrayList<Sehir>();


    public SonucEkrani(HashMap<String, Integer> plakaNo,ArrayList<Sehir> sehir_bilgisi) {
    	this.plakaNo=plakaNo;
    	this.sehir_bilgisi=sehir_bilgisi;
    	
        initComponents();
        lstSonuclar.setModel(model);
        this.setResizable(false);
        setTitle("Gezgin Kargocu Problemi-Sonuçlar");
        sonuclar();

    }

    public void sonuclar() {
        model.addElement("En İyi Sonuç");
        model.addElement("Alternatif 1. Sonuç");
        model.addElement("Alternatif 2. Sonuç");
        model.addElement("Alternatif 3. Sonuç");
        model.addElement("Alternatif 4. Sonuç");
        model.addElement("Alternatif 5. Sonuç");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSonuclar = new javax.swing.JList();
        btnSonuc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaDosya = new javax.swing.JTextArea();
        btnDosya = new javax.swing.JButton();
        btnDizin = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 200, 0, 0));

        lstSonuclar.setBackground(java.awt.Color.lightGray);
        lstSonuclar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.green, java.awt.Color.blue, java.awt.Color.pink, java.awt.Color.black));
        lstSonuclar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lstSonuclar.setForeground(new java.awt.Color(60, 63, 65));
        lstSonuclar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "En İyi Sonuç", "Alternatif 1. Sonuç", "Alternatif 2. Sonuç", "Alternatif 3. Sonuç", "Alternatif 4. Sonuç", "Alternatif 5. Sonuç" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstSonuclar.setSelectionForeground(new java.awt.Color(51, 255, 102));
        jScrollPane1.setViewportView(lstSonuclar);

        btnSonuc.setText("Sonucu Haritada Göster");
        btnSonuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonucActionPerformed(evt);
            }
        });

        textAreaDosya.setColumns(20);
        textAreaDosya.setRows(5);
        jScrollPane2.setViewportView(textAreaDosya);

        btnDosya.setText("Sonuçları Dosyada Aç");
        btnDosya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosyaActionPerformed(evt);
            }
        });

        btnDizin.setText("Dizinden Dosya Seç");
        btnDizin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDizinActionPerformed(evt);
            }
        });

        jMenu3.setText("Yardım");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Yardım");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Çıkış");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Çıkış");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSonuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDosya, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDizin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDosya, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDizin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDosyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosyaActionPerformed
        textAreaDosya.setText("");
        String icerik = "";
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("Belgeler/Cikti.txt")))) {
            while (sc.hasNextLine()) {
                icerik += sc.nextLine() + "\n";
            }
            textAreaDosya.setText(icerik);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Dosya Bulunamadı!");
        }


    }//GEN-LAST:event_btnDosyaActionPerformed

    private void btnDizinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDizinActionPerformed
        textAreaDosya.setText("");
        JFileChooser fc = new JFileChooser();
        int i = fc.showOpenDialog(this);//dizin açılıyor

        if (i == JFileChooser.APPROVE_OPTION)//okey e basıldıysa
        {
            File file = fc.getSelectedFile();//hangi dosya seçildi
            String icerik = "";
            try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
                while (sc.hasNextLine()) {
                    icerik += sc.nextLine() + "\n";
                }
                textAreaDosya.setText(icerik);

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Dosya Açma Hatası!");
            }

        }


    }//GEN-LAST:event_btnDizinActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String mesaj = "1- Sonucu Göster Butonu ile Listeden Seçtiğiniz Sonucun Map Üzerinde Görüntüsü Ekrana gelir!\n"
                + "2- Sonuçları Dosyada Aç Butonu ile Sonuçları Text Dosyası Halinde Sağ Kısımda Görebilirsiniz!\n"
                + "3- İstediğiniz Herhangi Bir Dizinden Dosya Seçerek İçeriğine Sağ Kısımdan Ulaşabilirsiniz!\n"
                + "4- Seçili İlleri Göster Butonu ile Seçtiğiniz İller Görebilirsiniz!";
        JOptionPane.showMessageDialog(this, mesaj);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnSonucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonucActionPerformed
        int secili_row = lstSonuclar.getSelectedIndex();
        
        
        if (secili_row == -1) {
            JOptionPane.showMessageDialog(this, "Uyarı! Lütfen Gösterilecek Bir Sonuç Seçiniz!");
        } else {
        	try {
            if (secili_row == 0) {
                HaritaEkrani ekran = new HaritaEkrani(4,plakaNo,sehir_bilgisi);

            } else if (secili_row == 1) {

                HaritaEkrani ekran = new HaritaEkrani(9,plakaNo,sehir_bilgisi);

            } else if (secili_row == 2) {
                HaritaEkrani ekran = new HaritaEkrani(14,plakaNo,sehir_bilgisi);
            } else if (secili_row == 3) {
                HaritaEkrani ekran = new HaritaEkrani(19,plakaNo,sehir_bilgisi);
            } else if (secili_row == 4) {
                HaritaEkrani ekran = new HaritaEkrani(24,plakaNo,sehir_bilgisi);
            } else if (secili_row == 5) {
                HaritaEkrani ekran = new HaritaEkrani(29,plakaNo,sehir_bilgisi);
            }
        	}
        	catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(this, "Sectiginiz Alternatif Yol Bulunamadi Cikti Dosyasini Kontrol Ediniz!");

			}
        
        }
    }//GEN-LAST:event_btnSonucActionPerformed

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
            java.util.logging.Logger.getLogger(SonucEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SonucEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SonucEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SonucEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SonucEkrani(plakaNo,sehir_bilgisi).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDizin;
    private javax.swing.JButton btnDosya;
    private javax.swing.JButton btnSonuc;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstSonuclar;
    private javax.swing.JTextArea textAreaDosya;
    // End of variables declaration//GEN-END:variables
}
