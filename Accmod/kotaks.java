/*
 * NIM  : 1913000018
 * Nama : Hafiz Sukmono
 */
package ketiga;
import kedua.*;

public class kotaks extends persegi {
	public int tinggi;
	
	public int volume() {
		return panjang * lebar * tinggi;
	}
	public void cetak() { 
		super.cetak();
		System.out.println("Tinggi : "+tinggi);
	}
}
