package prolab21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Bu class dosyalardan sehir bilgilerini okumak icin kullaniliyor
 */
public class DosyaOku {

	private int[][] sehirler_matrisi = new int[81][81];
	private HashMap<String, Integer> plakaNo = new HashMap<String, Integer>();
	private ArrayList<Sehir> sehir_bilgisi = new ArrayList<Sehir>();

	public DosyaOku() {
		for (int i = 0; i < 81; i++) {
			for (int j = i + 1; j < 81; j++) {
				sehirler_matrisi[i][j] = 0;
				sehirler_matrisi[j][i] = 0;
				sehirler_matrisi[i][i] = 0;

			}
		}
	}

	/*
	 * Ilk olarak sadece sehirler ve plaka numaralari okunuyor ve kayit altina aliniyor
	 */
	private void sehirOkuma() {

		String okunan_bilgi;
		String[] parcalanmis_bilgi;

		try (Scanner okuyucu = new Scanner(new BufferedReader(new FileReader("Belgeler/sehir.txt")))) {

			while (okuyucu.hasNextLine()) {

				okunan_bilgi = okuyucu.nextLine();
				parcalanmis_bilgi = okunan_bilgi.split(",");
				plakaNo.put(parcalanmis_bilgi[1], Integer.parseInt(parcalanmis_bilgi[0])-1);
				//plakalarin 1 eksigi plakaNo ya kayit ediliyor
				
				sehir_bilgisi.add(new Sehir(Integer.parseInt(parcalanmis_bilgi[0]), parcalanmis_bilgi[1]));

			}
		} catch (FileNotFoundException ex) {
			System.out.println("Sehir.txt Dosyasi bulunamadı!");
		}
	}

	/*
	 * İkinci olarak kayit altina alinan sehirlerin komsuluklari okunuyor ve bu bilgiler grafa ekleniyor
	 */
	private void komsuOkuma() {

		String okunan_bilgi;
		String[] parcalanmis_bilgi;
		String[] parcalanmis_ikinci_bilgi;
		int satirNo = 0;

		try (Scanner okuyucu = new Scanner(new BufferedReader(new FileReader("Belgeler/sehir.txt")))) {
			while (okuyucu.hasNextLine()) {
				okunan_bilgi = okuyucu.nextLine();
				parcalanmis_bilgi = okunan_bilgi.split(",");
				for (int j = 2; j < parcalanmis_bilgi.length; j++) {
					parcalanmis_ikinci_bilgi = parcalanmis_bilgi[j].split("-");
					sehirler_matrisi[satirNo][plakaNo.get(parcalanmis_ikinci_bilgi[0])] = Integer
							.parseInt(parcalanmis_ikinci_bilgi[1]);
				}
				satirNo++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Sehir.txt Dosya bulunamadı");
		}
	}
	
	/*
	 * Ucuncu olarak tum sehirlerin harita uzerindeki piksel bilgileri okunarak bu bilgiler
	 * orjinal resmin piksel boyutları yardimiyla oranlanarak kayit altina aliniyor
	 */
	private void sehirPikselOkuma() {
		
		String okunan_bilgi;
		String[] parcalanmis_bilgi;
		
		try (Scanner okuyucu = new Scanner(new BufferedReader(new FileReader("Belgeler/sehirPikselleri.txt")))) {

			while (okuyucu.hasNextLine()) {
				okunan_bilgi=okuyucu.nextLine();
				parcalanmis_bilgi=okunan_bilgi.split("-");
				//parcalanmis_bilgi[0] da plaka var
				//parcalanmis_bilgi[2] da x var
				//parcalanmis_bilgi[0] da y var
				
				
				sehir_bilgisi.get(Integer.parseInt(parcalanmis_bilgi[0])-1).setX(((Integer.parseInt(parcalanmis_bilgi[2]))*100)/2470);
				sehir_bilgisi.get(Integer.parseInt(parcalanmis_bilgi[0])-1).setY(((Integer.parseInt(parcalanmis_bilgi[3]))*100)/1262);
				
				

			}
		} catch (FileNotFoundException ex) {
			System.out.println("sehirPikselleri.txt Dosya bulunamadı!");
		}
		
		
	}

	public void dosyaOkumaCalistir() {
		sehirOkuma();
		komsuOkuma();
		sehirPikselOkuma();
	}

	
	

	
	
	public ArrayList<Sehir> getSehir_bilgisi() {
		return sehir_bilgisi;
	}



	public int[][] getSehirler_matrisi() {
		return sehirler_matrisi;
	}

	public HashMap<String, Integer> getPlakaNo() {
		return plakaNo;
	}

}