package prolab21;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class YoluBul {

	private DosyaOku file = new DosyaOku();
	private ArrayList<Dijsktra> dijkstra = new ArrayList<Dijsktra>();
	private int[][] sehirler_matrisi = new int[81][81];//Sehirlerin graf yapisini tutuyor
	private HashMap<String, Integer> plakaNo = new HashMap<String, Integer>();
	private ArrayList<Sehir> sehir_bilgisi = new ArrayList<Sehir>();
	private String[] gezilecek_sehirler;//Kullanicinin sectigi sehirleri tutuyor
	//////////////////////////////////////////////////////
	private String[] guzergah = new String[10];// en kisa 10 yolun guzergahini tutuyor
	private int[] enkisa_yollar = new int[10];// en kisa 10 yolun maliyetini tutuyor
	//////////////////////////////////////////////////////
	private int sehir_sayisi;// kullanicidan alinan sehir sayisi min:1 max:10
	private Boolean siralama_matrisi[][];//permutasyon siralamasi sonuclari icin kullaniliyor
	private int sehir_sira[];//permutasyon siralamasi sonuclari icin kullaniliyor
	private Boolean sayilar[];//permutasyon siralamasi sonuclari icin kullaniliyor

	public YoluBul(String[] sehirler) {
////////////////////////////////////////////////////////////

		/*
		 * Sehir bilgilerini dosyadan almak icin gerekli atamalarin yapildigi yer
		 */
		this.sehir_sayisi = sehirler.length;
		gezilecek_sehirler = sehirler.clone();
		this.siralama_matrisi = new Boolean[sehir_sayisi][sehir_sayisi];
		this.sehir_sira = new int[sehir_sayisi];
		this.sayilar = new Boolean[sehir_sayisi];

		for (int i = 0; i < 10; i++) {
			enkisa_yollar[i] = Integer.MAX_VALUE;
			guzergah[i] = "";
		}

		file.dosyaOkumaCalistir();

		sehirler_matrisi = file.getSehirler_matrisi();
		plakaNo = file.getPlakaNo();
		sehir_bilgisi = file.getSehir_bilgisi();


		
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
		
		/*
		 * Kullanicinin sectigi sehirler icin herbirinden bir dijkstra nesnesi oluştup
		 * arrayliste ekler
		 * 
		 * Dijkstra nesneleri ise eklenen sehirden diger tum sehirlere olan uzakligi bulur
		 * 
		 */
		int i;
		dijkstra.add(0, new Dijsktra(plakaNo, sehir_bilgisi));
		dijkstra.get(0).yollariBul(sehirler_matrisi, 40);

		for (i = 1; i < sehir_sayisi + 1; i++) {
			dijkstra.add(i, new Dijsktra(plakaNo, sehir_bilgisi));
			dijkstra.get(i).yollariBul(sehirler_matrisi, plakaNo.get(gezilecek_sehirler[i - 1]));

		}

		dijkstra.add(i, new Dijsktra(plakaNo, sehir_bilgisi));
		dijkstra.get(i).yollariBul(sehirler_matrisi, 40);
////////////////////////////////////////////////////////////

		/*
		 * sirala metodu icin degiskenlerin icerigini duzenliyor
		 */
		for (i = 0; i < sehir_sayisi; i++) {
			sehir_sira[i] = -1;
			sayilar[i] = false;
			for (int j = 0; j < sehir_sayisi; j++) {
				siralama_matrisi[i][j] = false;

			}
		}

		
	}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

	/*
	 * Bu metod sirala metodunun her buldugu sonuca gore siralanan sehirleri geziyor
	 * Maliyeti ve guzergahi kayit edip bunlari kontrol icin kayitEt metoduna gonderiyor
	 * 
	 */
	public void KargoyuDagit() {

		// plakaNumaralari dijkstradaki sirayi tutuyor
		// ancak 40 haric bu baslangici sehrinin plakasini tutuyor
		int baslangic_plakano = 40;
		int sonraki_plakano = -1;
		int mesafe = 0;
		String yol = "";

		for (int i = 0; i < sehir_sayisi; i++) {

			for (int j = 0; j < sehir_sayisi; j++) {
				if (i == sehir_sira[j]) {
					sonraki_plakano = j;
					break;
				}
			}

			if (baslangic_plakano == 40) {
				yol = dijkstra.get(0).bellibiryolugoster(plakaNo.get(gezilecek_sehirler[sonraki_plakano]), yol);
				mesafe += dijkstra.get(0).mesafeyiBul(plakaNo.get(gezilecek_sehirler[sonraki_plakano]));
			} else {
				yol = dijkstra.get(baslangic_plakano + 1)
						.bellibiryolugoster(plakaNo.get(gezilecek_sehirler[sonraki_plakano]), yol);
				mesafe += dijkstra.get(baslangic_plakano + 1)
						.mesafeyiBul(plakaNo.get(gezilecek_sehirler[sonraki_plakano]));
			}

			baslangic_plakano = sonraki_plakano;

		}

		yol = dijkstra.get(baslangic_plakano + 1).bellibiryolugoster(40, yol);
		mesafe += dijkstra.get(baslangic_plakano + 1).mesafeyiBul(40);

		kayitEt(mesafe, yol);

	}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

	

	/*
	 * Bu metod sirala metodunun olusturdugu sehir sirasini sifirlamak icin kullaniliyor
	 */
	private void sifirla(int satir) {

		for (int i = 0; i < sehir_sayisi; i++)
			siralama_matrisi[satir][i] = false;
	}

	/*
	 * metod kullanilirken baslangic=0 olmali
	 * 
	 * Bu metod sehir_sayisina gore tum siralanmis ihtimalleri buluyor.
	 * Ornek olarak sehir_sayisi=3 kabul edelim
	 * 1-2-3  1-3-2  2-1-3 ... seklinde tum ihtimalleri deniyor.
	 * 
	 * Her buldugu sonuctan sonra bu sonuca gore gezilecek sehirleri siralayip yeni 
	 * bir guzergah buluyor.
	 * 
	 * 
	 */
	public void sirala(int baslangic) {

		if (baslangic == sehir_sayisi) {
			KargoyuDagit();

			return;
		}

		else {
			for (int i = 0; i < sehir_sayisi; i++) {
				if ((!sayilar[i]) && (sehir_sira[baslangic] != i) && (!siralama_matrisi[baslangic][i])) {
					sehir_sira[baslangic] = i;
					sayilar[i] = true;
					siralama_matrisi[baslangic][i] = true;
					sirala((baslangic + 1));
					i = -1;

					if ((baslangic + 1) < sehir_sayisi) {
						sayilar[sehir_sira[baslangic + 1]] = false;
						sifirla(baslangic + 1);
						sayilar[sehir_sira[baslangic]] = false;

					}

				}
			}
		}

	}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

	/*
	 * Bu metod gidilen guzergahi ve maliyetini kontrol ediyor
	 * 
	 * Eger gidilen yolun maliyeti yeteri kadar az ise kayit ediliyor
	 */
	public void kayitEt(int mesafe, String yol) {

		for (int i = 0; i < 10; i++) {

			// Bu if blogu ayni yolu bir daha bulursa kayit etmemesini sagliyor
			if (yol.equals(guzergah[i])) {
				break;
			} else if (mesafe <= enkisa_yollar[i]) {
				int temp = enkisa_yollar[i];
				enkisa_yollar[i] = mesafe;
				mesafe = temp;

				String temp_string = guzergah[i];
				guzergah[i] = yol;
				yol = temp_string;

			}
		}
	}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

	
	/*
	 * Program'in sonunda bulunan en kisa 10 guzergahi txt dosyasina kayit ediyor 
	 */
	public void ciktiVer() {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Belgeler/Cikti.txt", false))) {

			writer.write("--------------------------------------------\n");
			writer.write("--------------------------------------------\n");
			writer.write("\n");

			writer.write("------En Iyi Yol------\n");
			writer.write("Mesafe: " + enkisa_yollar[0] + "\n");
			writer.write("Guzergah:" + guzergah[0] + "\n");

			for (int i = 1; i < 10; i++) {
				if (enkisa_yollar[i] == Integer.MAX_VALUE) {
					break;
				}

				else {
					writer.write("--------------------------------------------\n");
					writer.write("--------------------------------------------\n");
					writer.write("------Altarnetif Yol " + (i) + " --------\n");
					writer.write("Mesafe: " + enkisa_yollar[i] + "\n");
					writer.write("Guzergah:" + guzergah[i] + "\n");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Cikti Dosyasi Bulunmadai");
		} catch (IOException e1) {
			System.out.println("Cikti Dosyasi Acilirken Hata Olustu");
		}

		

	}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
	
	/*
	 * PlakaNo getter
	 */
	public HashMap<String, Integer> getPlakaNo() {
		return plakaNo;
	}

	/*
	 * sehir_bilgisi getter
	 */
	public ArrayList<Sehir> getSehir_bilgisi() {
		return sehir_bilgisi;
	}

}
