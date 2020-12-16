# -Traveling-Salesman-Problem
 adaptation of the traveling salesman problem to turkey

		GEZGİN KARGO PROBLEMİ

	-Proje Hakkında

-Proje temelde kargo dağıtım firmalarında kullanılmak üzere tasarlanmış bir uygulamadır

	-Proje Nasıl Çalıştırılır

Projeyi bir ide aracılığı ile çalıştırıyoruz
Önünüzde solda ve sağda olmak üzere iki adet liste açıldı.
Sol taraftaki listeden min 1 maks 10 adet olacak şekilde gidilmesi gereken sehirleri seçmeniz gerekmektedir.
Seçtiğiniz her şehir sol taraftaki listeye aktarılmaktadır.
İstemediğiniz şehri sağ taraftaki listeden çıkarabilirsiniz.
Başlangıç ve bitiş şehri Kocaeli şehri olduğu için listeden çıkaramazsınız.
"En Kısa Yolu Hesapla" tuşuna bastığınızda program seçtiğiniz iller arasındaki tüm yollara bakarak en kısa 10 yolu buluyor.
Hesaplama işlemi bitene kadar lütfen bekleyiniz. İşlem bitince önünüze yeni bir pencere gelecektir.
Uyarı: Eğer 10 adet şehir seçilirse 10! den fazla işlem yapıldığı için sonucu bulması biraz uzun sürüyor(80-100 saniye arasında).
Yeni gelen pencerede iki kısım bulunmakta sol tarafta en iyi 6 yolun listesi, sol tarafta ise sonuçların olduğu çıktı dosyasını ya da başka bir txt dosyasını görebileceğiniz bir kısım bulunuyor.
Sol taraftaki listeden hangi yolun harita üzerindeki görüntüsünü görmek istiyorsanız onu seçerek "Sonucu Haritada Göster" butonuna tıklayınız.
Eğer seçtiğiniz yollardan biri bulunamamışsa gerekli uyarıyı ekrana verir. Bu durumda Cikti.txt dosyasını kontrol ederek kaç adet yol olduğuna bakabilirsiniz.


	-Projeyi Geliştirirken Kullandığımız Teknoloji

-Proje de Java Programlama dili kullanılmıştır.
-Eclipse IDE platformu kullanıldı.

	-Projede Kullanılan Classlar

java.util.ArrayList
java.util.HashMap
java.io.BufferedReader
java.io.FileNotFoundException
java.io.FileReader
java.util.Scanner
java.awt.BasicStroke
java.awt.Color
java.awt.Dimension
java.awt.Graphics
java.awt.Graphics2D
java.awt.Toolkit
java.util.NoSuchElementException
javax.swing.ImageIcon
javax.swing.JFrame
javax.swing.JOptionPane
java.io.File
javax.swing.DefaultListModel
javax.swing.JFileChooser
java.io.BufferedWriter
java.io.FileWriter
java.io.IOException

	-Projeyi Geliştirenler
Abdullah Yaşar KISA
İbrahim KAFKASLI
