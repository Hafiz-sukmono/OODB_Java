/*
 * NIM : 1913000018
 * Nama : Hafiz Sukmono
 */
package utama;
import kedua.*;
import ketiga.*;

public class akses {

	public static void main(String[] args) {
		persegi segi4 = new persegi();
		kotak balok = new kotak();
		kotaks blok = new kotaks();
		segi4.panjang = 10;
		segi4.lebar = 5;
		segi4.cetak();
		System.out.println("Luas : "+segi4.luas());
		balok.panjang = 8;
		balok.lebar = 4;
		balok.tinggi = 2;
		balok.cetak();
		System.out.println("Volume : " +balok.volume());
		blok.panjang = 9;
		blok.lebar = 3;
		blok.tinggi = 2;
		blok.cetak();
		System.out.println("Volume : "+blok.volume());
	}

}
