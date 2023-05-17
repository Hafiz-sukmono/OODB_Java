package koleksi;
/*
 * @author NIM : 1913000018
 * 	     Nama : Hafiz Sukmono
 * 	  Tanggal : 7/4/2021
 */

class sepedaku {
	String jenis;
	//Contoh Sepeda lipat, Comuter
	String merek;
	int kode_sepeda;
	long harga_sepeda;
	String warna;
	char kondisi;
	// A : baru , B : bekas
	sepedaku(){
		jenis = "Commuter Bike";
		merek = "Surly";
		kode_sepeda = 3401;
		harga_sepeda = 9000000;
		kondisi = 'A';
		warna = "Hitam";
	}
	
}


class berat extends sepedaku{
	String berat;
	berat(){
	berat = "3.5 Kg";
	}
}

public class sepeda {
	String jenis;
	//contoh sepeda dewasa, sepeda anak
	String merek;
	int kode_sepeda;
	float harga_sepeda;
	String Warna;
	char kondisi;
	// A : baru, B : bekas
	
	public static void main(String[] args) {
		sepedaku surly = new sepedaku();
		berat sepeda = new berat();
		System.out.println("Jenis 	     = " +surly.jenis);
		System.out.println("merek	     = " +surly.merek);
		System.out.println("kode Sepeda  = " +surly.kode_sepeda);
		System.out.println("Harga Sepeda = " +surly.harga_sepeda);
		System.out.println("Kondisi	     = " +surly.kondisi);
		System.out.println("Berat 	     = " +sepeda.berat);
		System.out.println("Warna 	     = " +surly.warna);
	}
}

Jenis 	     = Commuter Bike
merek	          = Surly
kode Sepeda    = 3401
Harga Sepeda   = 9000000
Kondisi	     = A
Berat 	     = 3.5 Kg
Warna 	     = Hitam
