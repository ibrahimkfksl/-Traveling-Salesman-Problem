package prolab21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MenuEkrani extends javax.swing.JFrame {

    DefaultListModel model = new DefaultListModel();
    DefaultListModel cikar_model = new DefaultListModel();
    // list modellerine erişebilmek için default modeller oluşturuldu

    public MenuEkrani() throws FileNotFoundException {
        initComponents();
        lst_sehirler.setModel(model);
        lst_secili_sehirler.setModel(cikar_model);
        // modellerin içleri boşaltılıp aktif hale getirildi
        this.setResizable(false);
        dosya_oku();
    }

    public void dosya_oku() throws FileNotFoundException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("Belgeler/SehirIsimleri.txt")))) {
            while (sc.hasNextLine()) {
                String sehir = sc.nextLine();
                model.addElement(sehir);

            }
            model.removeElement("Kocaeli");
            cikar_model.addElement("Kocaeli");
			// dosyadan sehirler okunup modellerin içine konuldu.
            // birinci modele kocaeli hariç tüm iller
            // ikinci modele ise yalnızca kocaeli konuldu
        }
    }

    @SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenu1 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jDialog1 = new javax.swing.JDialog();
		jScrollPane2 = new javax.swing.JScrollPane();
		lst_sehirler = new javax.swing.JList();
		btn_sehir_ekle = new javax.swing.JButton();
		btn_sehir_cikar = new javax.swing.JButton();
		lbl_sehir_ekle = new javax.swing.JLabel();
		lbl_sehir_cikar = new javax.swing.JLabel();
		btn_onayla = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		lst_secili_sehirler = new javax.swing.JList();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();

		jMenu1.setText("jMenu1");

		jMenuItem2.setText("jMenuItem2");

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Gezgin Kargocu Problemi");
		setBackground(java.awt.Color.gray);
		setBounds(new java.awt.Rectangle(200, 100, 0, 0));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setMinimumSize(new java.awt.Dimension(100, 100));

		lst_sehirler.setBackground(java.awt.Color.lightGray);
		lst_sehirler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				java.awt.Color.green, java.awt.Color.blue, java.awt.Color.pink, java.awt.Color.black));
		lst_sehirler.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
		lst_sehirler.setForeground(new java.awt.Color(60, 63, 65));
		lst_sehirler.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Adana", "Adiyaman", "Afyonkarahisar", "Agri", "Amasya", "Ankara", "Antalya", "Artvin",
					"Aydin", "Balikesir", "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa", "Canakkale",
					"Cankiri", "Corum", "Denizli", "Diyarbakir", "Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir",
					"Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay", "Isparta", "Mersin", "Istanbul", "Izmir",
					"Kars", "Kastamonu", "Kayseri", "Kirklareli", "Kirsehir", "Konya", "Kutahya", "Malatya", "Manisa",
					"Kahramanmaras", "Mardin", "Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Rize", "Sakarya", "Samsun",
					"Siirt", "Sinop", "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli", "Sanliurfa", "Usak", "Van",
					"Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kirikkale", "Batman", "Sirnak", "Bartin",
					"Ardahan", "Igdir", "Yalova", "Karabuk", "Kilis", "Osmaniye", "Duzce" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		lst_sehirler.setSelectionForeground(new java.awt.Color(51, 255, 102));
		jScrollPane2.setViewportView(lst_sehirler);

		btn_sehir_ekle.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		btn_sehir_ekle.setText("Şehri Ekle");
		btn_sehir_ekle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_sehir_ekleActionPerformed(evt);
			}
		});

		btn_sehir_cikar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		btn_sehir_cikar.setText("Şehri Çıkar");
		btn_sehir_cikar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_sehir_cikarActionPerformed(evt);
			}
		});

		lbl_sehir_ekle.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		lbl_sehir_ekle.setForeground(new java.awt.Color(204, 51, 0));

		lbl_sehir_cikar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		lbl_sehir_cikar.setForeground(new java.awt.Color(204, 51, 0));

		btn_onayla.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
		btn_onayla.setText("En Kısa Yolu Bul");
		btn_onayla.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_onaylaActionPerformed(evt);
			}
		});

		lst_secili_sehirler.setBackground(java.awt.Color.lightGray);
		lst_secili_sehirler
				.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
						java.awt.Color.green, java.awt.Color.blue, java.awt.Color.pink, java.awt.Color.black));
		lst_secili_sehirler.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
		lst_secili_sehirler.setForeground(new java.awt.Color(60, 63, 65));
		lst_secili_sehirler.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		lst_secili_sehirler.setSelectionForeground(new java.awt.Color(51, 255, 102));
		jScrollPane1.setViewportView(lst_secili_sehirler);

		jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(0, 0, 0));
		jLabel1.setText("Şehirler");

		jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(0, 0, 0));
		jLabel2.setText("Teslimat Yapılacak İller");

		jMenu4.setText("Yardım");

		jMenuItem1.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setText("Yardım");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem1);

		jMenuBar2.add(jMenu4);

		jMenu2.setText("Çıkış");

		jMenuItem3.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem3.setText("Projeyi Sonlandır");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem3);

		jMenuBar2.add(jMenu2);

		setJMenuBar(jMenuBar2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(70, 70, 70)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lbl_sehir_ekle, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_sehir_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_onayla, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
						.addGap(19, 19, 19)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_sehir_cikar, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup().addComponent(btn_sehir_cikar).addGap(0, 134,
										Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(86, 86, 86)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(
										jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane2).addComponent(jScrollPane1)
										.addGroup(layout.createSequentialGroup()
												.addComponent(btn_sehir_cikar, javax.swing.GroupLayout.PREFERRED_SIZE,
														56, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(lbl_sehir_cikar, javax.swing.GroupLayout.PREFERRED_SIZE,
														50, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addComponent(btn_sehir_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lbl_sehir_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(22, 22, 22).addComponent(btn_onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(91, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

    private void btn_sehir_ekleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_sehir_ekleActionPerformed

        lbl_sehir_cikar.setText("");
        lbl_sehir_ekle.setText("");
        int secili_row = lst_sehirler.getSelectedIndex();
        if (secili_row == -1) {
            lbl_sehir_ekle.setText("Lütfen Bir İl Seçiniz!");
        } else {

            if (model.size() <= 70)// en fazla 11 il olur - kocaeli dahil
            {
                lbl_sehir_ekle.setText("Maksimum İl Sayısına Ulaşıldı!");
            } else {
                String il_ismi = model.getElementAt(secili_row).toString();
                model.removeElementAt(secili_row);
                cikar_model.addElement(il_ismi);

            }

        }

    }// GEN-LAST:event_btn_sehir_ekleActionPerformed

    private void btn_sehir_cikarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_sehir_cikarActionPerformed

        prolab21.DosyaOku oku = new prolab21.DosyaOku();
        oku.dosyaOkumaCalistir();
        HashMap<String, Integer> plaka = new HashMap<String, Integer>();
        plaka = oku.getPlakaNo();
        int index;

        lbl_sehir_cikar.setText("");
        lbl_sehir_ekle.setText("");
        int secili_row = lst_secili_sehirler.getSelectedIndex();
        if (secili_row == -1) {
            lbl_sehir_cikar.setText("Lütfen Bir İl Seçiniz!");
        } else if (secili_row == 0) {
            lbl_sehir_cikar.setText("Kocaeli İli Bu Listeden Çıkarılamaz!");
        } else {
            index = 0;
            String il_ismi = cikar_model.getElementAt(secili_row).toString();
            index = plaka.get(il_ismi);
            cikar_model.removeElementAt(secili_row);
            model.add(index, il_ismi);
            // index e göre ekleme yapılıcak!!

        }

    }// GEN-LAST:event_btn_sehir_cikarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
        String mesaj = "1-Bu kısımda eklemek istediğiniz ili seçerek şehri ekle butonuna tıklamanız gerekmektedir!\n"
                + "2-Eklenen şehri seçip şehri çıkar butonuna tıklarsanız şehir listeden çıkarılır!\n"
                + "3-Kocaeli ili Teslimat ili listesinden çıkarılamaz!\n"
                + "4-En Kısa Yolu Bul butonu sizin için en kısa yolları listeler!";
        JOptionPane.showMessageDialog(this, mesaj);
    }// GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_onaylaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_onaylaActionPerformed

        String[] sehirler = new String[cikar_model.size() - 1];
        for (int i = 1; i < cikar_model.size(); i++) {
            sehirler[i - 1] = cikar_model.getElementAt(i).toString();
        }

        //System.out.println(sehirler.length);
        //YoluBul yol = new YoluBul(sehirler);
        if (sehirler.length == 0) {
            JOptionPane.showMessageDialog(this, "Lütfen Gezilecek İl Seçiniz!");
        } else {
            YoluBul yol = new YoluBul(sehirler);
            yol.sirala(0);
            yol.ciktiVer();

            HashMap<String, Integer> plakaNo = yol.getPlakaNo();
            ArrayList<Sehir> sehir_bilgisi = yol.getSehir_bilgisi();


            setVisible(false);
            
            SonucEkrani ikinci_sayfa = new SonucEkrani(plakaNo, sehir_bilgisi);
            ikinci_sayfa.setVisible(true);
            dispose();
            
            
        }

    }// GEN-LAST:event_btn_onaylaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		// </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuEkrani().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuEkrani.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_onayla;
	private javax.swing.JButton btn_sehir_cikar;
	private javax.swing.JButton btn_sehir_ekle;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lbl_sehir_cikar;
	private javax.swing.JLabel lbl_sehir_ekle;
	private javax.swing.JList lst_secili_sehirler;
	private javax.swing.JList lst_sehirler;
	// End of variables declaration//GEN-END:variables
}
