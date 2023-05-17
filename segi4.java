package rect5;

/* 
 * NIM  : 1913000018
 * Nama : Hafiz Sukmono
 */

class kotak{
	int panjang;
	int lebar;
	//Berikut Adalah Constructor Untuk Class Persegi
	kotak() {
		System.out.println("Constructor Persegi");
		panjang = 100;
		lebar = 50;		
	}
	//Berikut Adalah Constructor Dengan Parameter Berbeda
	kotak(int P, int L) {
		panjang = P;
		lebar = L;
	}
	//Berikut Adalah Constructor Dengan Parameter Berbeda Lagi
	kotak(int A) {
		panjang = lebar = A;
	}
	//Hitung Luas Persegi Empat
	int luas() {
		return panjang * lebar;
	}
}
class box extends kotak {
	int tinggi;
	box(){
		super();
		tinggi = 20;
	}
	void nasikotak(int P, int L, int T) {
		panjang = P;
		lebar = L;
		tinggi = T;
	}
	int volume() {
		return panjang * lebar * tinggi;
	}
}
public class segi4 {

	public static void main(String[] args) {
		kotak kotak4sisi = new kotak();
		kotak kotakkami  = new kotak(88,44);
		kotak nasikotak  = new kotak(55);
		box boxnasikotak = new box();
		
		System.out.println("Luas Kotak Empat Sisi : " +kotak4sisi.luas());
		System.out.println("Luas Kotak Kami       : " +kotakkami.luas());
		System.out.println("Luas Nasi Kotak	      : " +nasikotak.luas());
		System.out.println("Volume Box Nasi Kotak : " +boxnasikotak.volume());
	}

}
