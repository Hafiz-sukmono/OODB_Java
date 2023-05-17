/*
 * NIM  : 1913000018
 * Nama : Hafiz Sukmono
 */
package kedua;

public class kotak extends persegi {
	public int tinggi;
	
	public int volume() {
		return panjang * lebar * tinggi;
	}
	public void cetak() {
		super.cetak();
		System.out.println("Tinggi : "+tinggi);
	}
}
