package prolab21;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class HaritaEkrani extends JFrame{
    ImageIcon image = new ImageIcon("Belgeler/harita.png");
    private int sonuc_no;
    String[] iller;
    private int x;
    private int y;
    private HashMap<String, Integer> plakaNo = new HashMap<String, Integer>();
    private ArrayList<Sehir> sehir_bilgisi = new ArrayList<Sehir>();
    public void sonuc_dosyasi_oku () 
    {
        int satir_no=0;
        String satir ="";
        int iki_satir=0;
        String[] mesafe = new String[2];
        String[] tum_yol = new String[2];
        String[] cizilecek_iller;
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader("Belgeler/Cikti.txt"))))
        {
            
         for(int i=0;i<sonuc_no;i++) {
        	 satir=sc.nextLine();
         }
         
         satir=sc.nextLine();
         mesafe = satir.split(":");
         JOptionPane.showMessageDialog(this,"Bu Güzergahın Toplam Mesafesi = "+mesafe[1]+"km");
         
         satir=sc.nextLine();
         tum_yol = satir.split(":");
         iller = tum_yol[1].split("----");
        
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Cikti.txt Dosyası Bulunamadı! Sonuçlar Çizilemiyor");
        }

        
    }
    public void paint(Graphics g)
    {
    	Graphics2D g2= (Graphics2D)g;
        g.drawImage(image.getImage(),0,0,getWidth(),getHeight(),null);
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        
        
        
        
        int baslangic_plaka=0;
		int son_plaka = 0;
		
        for(int i=0;i<iller.length;i++) {
        	String iki_sehir_arasi[]=iller[i].split("-");
        	
        	for(int j=0;j<iki_sehir_arasi.length-1;j++) {
        		baslangic_plaka=plakaNo.get(iki_sehir_arasi[j]);
        		son_plaka=plakaNo.get(iki_sehir_arasi[j+1]);
        		
        		if((i==0)&&(j==0)) {
        			g2.setColor(Color.GREEN);
        		}
        		
        		else {
        			g2.setColor(Color.BLACK);

        		}
        	   
        		g.drawLine((sehir_bilgisi.get(baslangic_plaka).getX())*x/100, (sehir_bilgisi.get(baslangic_plaka).getY())*y/100, (sehir_bilgisi.get(son_plaka).getX())*x/100, (sehir_bilgisi.get(son_plaka).getY())*y/100);
    			g2.setColor(Color.BLACK);
        		g.drawOval((sehir_bilgisi.get(baslangic_plaka).getX())*x/100, (sehir_bilgisi.get(baslangic_plaka).getY())*y/100, 40, 40);
        		g.drawOval((sehir_bilgisi.get(son_plaka).getX())*x/100, (sehir_bilgisi.get(son_plaka).getY())*y/100, 40, 40);

        	}
        	
        	
        	
        	
        }
        g2.setColor(Color.RED);
		g.drawLine((sehir_bilgisi.get(baslangic_plaka).getX())*x/100, (sehir_bilgisi.get(baslangic_plaka).getY())*y/100, (sehir_bilgisi.get(son_plaka).getX())*x/100, (sehir_bilgisi.get(son_plaka).getY())*y/100);
		g2.setColor(Color.BLACK);
		g.drawOval((sehir_bilgisi.get(baslangic_plaka).getX())*x/100, (sehir_bilgisi.get(baslangic_plaka).getY())*y/100, 40, 40);
		g.drawOval((sehir_bilgisi.get(son_plaka).getX())*x/100, (sehir_bilgisi.get(son_plaka).getY())*y/100, 40, 40);

    }
    public HaritaEkrani (int sonuc_no,HashMap<String, Integer> plakaNo,ArrayList<Sehir> sehir_bilgisi) throws NoSuchElementException
    {
        
    	this.plakaNo=plakaNo;
    	this.sehir_bilgisi=sehir_bilgisi;
    	this.sonuc_no=sonuc_no;
        sonuc_dosyasi_oku();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        x=screenSize.width ;
        y=screenSize.height;
        
        setSize(screenSize);
        setVisible(true);

       

    }
    
    
	

    
   
}