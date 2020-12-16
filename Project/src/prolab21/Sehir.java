package prolab21;

/*
 * Bu classta dosyalardan okunan sehir bilgileri tutuluyor
 * 
 * plaka numarasi
 * sehir adi
 * 
 * sehrin harita uzerindeki kordinat bilgisi
 */
public class Sehir {

	
	private int plaka_no;
	private String sehir_adi;
	private int x;
	private int y;
	

	public Sehir(int plaka_no, String sehir_adi) {

		this.plaka_no = plaka_no;
		this.sehir_adi = sehir_adi;
	}

	public int getPlaka_no() {
		return plaka_no;
	}

	public String getSehir_adi() {
		return sehir_adi;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}