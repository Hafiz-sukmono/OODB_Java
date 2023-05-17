/*
 * @author NIM  : 1913000018
 * Nama : Hafiz Sukmono
 * Tanggal : 16/06/2021
 */
package u1913000018;

import java.util.*;
import javax.persistence.*;
import java.text.*;

public class U1913000018 {
	static Scanner input = new Scanner(System.in);
	static int pilih;
	static char c;
	
	public static void main(String[] args) {
		display : while(true)
		{
			System.out.println("Menu Pengolahan Data Sepeda");
			System.out.println
			(
				"Pilih Yang Akan Dikerjakan :\n" +
				"1. Menambah Data \n" +
				"2. Menampilkan Data \n" +
				"3. Mengubah Data \n" +
				"4. Menghapus Data \n" +
				"5. Mencari Data \n" +
				"6. Keluar \n" 
			);
			pilih = input.nextInt();
			switch (pilih) {
				case 1 : 
					tambahdata();
					break;
				case 2 : 
					tampildata();
					break;
				case 3 : 
					ubahdata();
					break;
				case 4 : 
					hapusdata();
					break;
				case 5 : 
					caridata();
					break;
				case 6 : 
					exit();
					break;
				default :
					error();
					break;
			}
		}
	}
	
	static void tambahdata() {
		System.out.println("-- Menambah data Sepeda --");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/sepeda.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		sepeda s = new
				sepeda("4611","Fixie","Commuter Bike","kuning","alloy","700 inch","2017","07-10-2019","bekas",3000000);
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("Data sudah ditambahkan, Tekan sembarang tombol ...\n\n");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
	
	static void tampildata() {
		System.out.println("-- Menampilkan data Sepeda --");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/sepeda.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<sepeda> query =
				em.createQuery("SELECT m FROM sepeda m", sepeda.class);
		List<sepeda> results = query.getResultList();
		for (sepeda n : results) {
			System.out.println(n);
		}
		em.close();
		emf.close();
		System.out.println("Tekan sembarang tombol ...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
	
	static void ubahdata() {
		System.out.println("-- Mengubah data sepeda --");
		String kode_sepeda = "3401";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/sepeda.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<sepeda> query =
				em.createQuery("SELECT m FROM sepeda m", sepeda.class);
		List<sepeda> results = query.getResultList();
		for (sepeda n : results) {
			if (kode_sepeda.equals(n.getkode_sepeda())) {
				em.getTransaction().begin();
				n.setwarna("putih");
				em.getTransaction().commit();
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Data ditemukan dan diubah");
		}
		else {
			System.out.println("Data tidak ditemukan");
		}
		em.close();
		emf.close();
		System.out.println("Tekan sembarang tombol ...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
	
	static void hapusdata() {
		System.out.println("-- Menghapus data sepeda --");
		String kode_sepeda = "2504";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/sepeda.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<sepeda> query =
				em.createQuery("SELECT m FROM sepeda m", sepeda.class);
		List<sepeda> results = query.getResultList();
		for (sepeda n : results) {
			if (kode_sepeda.equals(n.getkode_sepeda())) {
				em.getTransaction().begin();
				em.remove(n);
				em.getTransaction().commit();
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Data ditemukan dan dihapus");
		}
		else {
			System.out.println("Data tidak ditemukan");
		}
		em.close();
		emf.close();
		System.out.println("Tekan sembarang tombol ...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
	
	static void caridata() {
		System.out.println("-- Mencari data sepeda --");
		String kode_sepeda = "4510";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/sepeda.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<sepeda> query =
				em.createQuery("SELECT m FROM sepeda m", sepeda.class);
		List<sepeda> results = query.getResultList();
		for (sepeda n : results) {
			if (kode_sepeda.equals(n.getkode_sepeda())) {
				System.out.println(n);
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Data ditemukan");
		}
		else {
			System.out.println("Data tidak ditemukan");
		}
		em.close();
		emf.close();
		System.out.println("Tekan sembarang tombol ...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
	
	static void exit() {
		System.out.println("Keluar Sytem...");
		System.exit(0);
	}
	
	static void error() {
		System.out.println("Pilihan Salah, silahkan coba lagi");
		System.out.println("Tekan sembarang tombol ...");
		try {
			System.in.read();
		}
		catch(Exception e) {
		}
	}
}





package u1913000018;

/*
 * @author NIM  : 1913000018
 * Nama : Hafiz Sukmono
 * Tanggal : 16/06/2021
 */

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.text.*;

@Entity
public class sepeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long id;
	private String kode_sepeda;
	private String merek;
	private String jenis;
	private String warna;
	private String bahan_rangka;
	private String ukuran_ban;
	private String tahun_rilis;
	private Date tanggal_beli;
	private String kondisi;
	private int harga;

	//constructor
	public sepeda() {
		kode_sepeda = "3401";
		merek = "surly";
		jenis = "Commuter Bike";
		warna = "hitam";
		bahan_rangka = "alloy";
		ukuran_ban = "700 inch";
		tahun_rilis = "2020";
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		tanggal_beli = (Date) fmt.parse("26-01-2021");
		}
		catch(ParseException e)
		{
			System.out.println("Exception : " +e);
		}
		kondisi = "baru";
		harga = 9000000;
	}
	//constructor untuk melewatkan data sepeda
	public sepeda(String kode_sepeda, String merek, String jenis, String warna, String bahan_rangka, String ukuran_ban, String tahun_rilis, String tanggal_beli, String kondisi, int harga) {
		this.kode_sepeda = kode_sepeda;
		this.merek = merek;
		this.jenis = jenis;
		this.warna = warna;
		this.bahan_rangka = bahan_rangka;
		this.ukuran_ban = ukuran_ban;
		this.tahun_rilis = tahun_rilis;
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		this.tanggal_beli = (Date) fmt.parse(tanggal_beli);
		}
		catch(ParseException e)
		{
			System.out.println("Exeption : " +e);
		}
		this.kondisi = kondisi;
		this.harga = harga;
	}
	public long getId() {
		return this.id;
	}
	public String getkode_sepeda() {
		return this.kode_sepeda;
	}
	public String getmerek() {
		return this.merek;
	}
	public String getjenis() {
		return this.jenis;
	}
	public String getwarna() {
		return this.warna;
	}
	public String getbahan_rangka() {
		return this.bahan_rangka;
	}
	public String getukuran_ban() {
		return this.ukuran_ban;
	}
	public String gettahun_rilis() {
		return this.tahun_rilis;
	}
	public String gettanggal_beli() {
		String tanggal_beli;
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		tanggal_beli = fmt.format(this.tanggal_beli);
		return tanggal_beli;
	}
	public String getkondisi() {
		return this.kondisi;
	}
	public int getharga() {
		return this.harga;
	}
	//metod mengatur nilai
	public void setkode_sepeda(String kode_sepeda) {
		this.kode_sepeda = kode_sepeda;
	}
	public void setmerek(String merek) {
		this.merek = merek;
	}
	public void setjenis(String jenis) {
		this.jenis = jenis;
	}
	public void setwarna(String warna) {
		this.warna = warna;
	}
	public void setbahan_rangka(String bahan_rangka) {
		this.bahan_rangka = bahan_rangka;
	}
	public void setukuran_ban(String ukuran_ban) {
		this.ukuran_ban = ukuran_ban;
	}
	public void settahun_rilis(String tahun_rilis) {
		this.tahun_rilis = tahun_rilis;
	}
	public void setTanggal_beli(String tanggal_beli) {
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");	
		this.tanggal_beli = (Date) fmt.parse(tanggal_beli);
		}
		catch(ParseException e)
		{
			System.out.println("Exception : " +e);
		}
	}
	public void setkondisi(String kondisi) {
		this.kondisi = kondisi;
	}
	public void setharga(int harga) {
		this.harga = harga;
	}
	@Override
	   public String toString()
	   {
			String tanggal_beli;
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
			tanggal_beli = fmt.format(this.tanggal_beli);
			return String.format("(%s, %s, %s, %s, %s, %s, %s, %s, %s, %d)", this.kode_sepeda, this.merek, this.jenis, this.warna, this.bahan_rangka, this.ukuran_ban, this.tahun_rilis, tanggal_beli, this.kondisi, this.harga);
	   }
}

