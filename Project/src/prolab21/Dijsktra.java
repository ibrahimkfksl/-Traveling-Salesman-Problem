package prolab21;

import java.util.ArrayList;
import java.util.HashMap;


/*
 *  Kaynak: https://www.devglan.com/datastructure/dijkstra-algorithm-java
 *  
 *  Kaynakta bulunan kodun ustunde ufak degisiklik ve eklemeler yapilidi
 */
public class Dijsktra {

	private static final int sehir_sayisi = 81;

	private int[] yollar = new int[81];// graftaki yollari tutuyor
	private ArrayList<Sehir> sehir_bilgisi = new ArrayList<Sehir>();
	private int mesafe[] = new int[81];

	public Dijsktra(HashMap<String, Integer> plakaNo, ArrayList<Sehir> sehir_bilgisi) {
		this.sehir_bilgisi = sehir_bilgisi;
	}

	private int minMesafeIndexBul(int mesafe[], Boolean gezildi_mi[]) {

		int min_mesafe = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i = 0; i < sehir_sayisi; i++) {

			if (gezildi_mi[i] == false && mesafe[i] < min_mesafe) {
				min_mesafe = mesafe[i];
				min_index = i;

			}
		}

		return min_index;
	}

	public void yollariBul(int graf[][], int baslangic) {
		Boolean gezildi_mi[] = new Boolean[81];

		for (int i = 0; i < sehir_sayisi; i++) {
			mesafe[i] = Integer.MAX_VALUE;
			gezildi_mi[i] = false;
			yollar[i] = -1;
		}

		mesafe[baslangic] = 0;

		for (int i = 0; i < sehir_sayisi - 1; i++) {
			int min = minMesafeIndexBul(mesafe, gezildi_mi);

			gezildi_mi[min] = true;

			for (int j = 0; j < sehir_sayisi; j++) {

				if (!gezildi_mi[j] && graf[min][j] != 0 && mesafe[min] + graf[min][j] < mesafe[j]) {
					mesafe[j] = mesafe[min] + graf[min][j];
					yollar[j] = min;
				}

			}

		}

		
	
	}

	public void yollariYazdir() {

		for (int i = 0; i < 81; i++) {
			System.out.println(i + "----" + (yollar[i]));
		}
	}

	/*
	 * dijsktra algoritmasındaki i indisinde bulunan yola bir önceki turda hangi
	 * graftan geldiğini gosteriyor plaka numarasina gore bir ustteki algoritmanın
	 * bir tık üstü son_sehir indisindeki sehirden itibaren baslangic sehrine kadar
	 * ekrana sehir isimlerini yazdirir
	 */

	
	public String bellibiryolugoster(int son_sehir, String yol) {
		int indis = son_sehir;
		String eklenecek_yol = "";
		String eklenecek_yol2[];

		while (indis != -1) {
			
			eklenecek_yol += "" + sehir_bilgisi.get(indis).getSehir_adi() + "-";
			indis = yollar[indis];
		}

		eklenecek_yol2 = eklenecek_yol.split("-");

		for (int i = (eklenecek_yol2.length - 1); i > -1; i--) {
			yol += eklenecek_yol2[i] + "-";
		}

		yol += "---";

		return yol;

	}
	/*
	 * int plaka=hashmapte plaka bilgisi
	 * 
	 * 
	 */
	public int mesafeyiBul(int plaka) {
		
		
		return mesafe[plaka];
		
	}

}
