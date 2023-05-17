/*
 * NIM  : 1913000018
 * Nama : Hafiz Sukmono
 */
package mhsdb;

import java.util.*;
import javax.persistence.*;
import java.text.*;

public class utama {
	static Scanner input = new Scanner(System.in);
	static int pilih;
	static char c;
	
	public static void main(String[] args) {
		display : while(true)
		{
			System.out.println("Menu Pengolahan Data Mahasiswa");
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
		System.out.println("-- Menambah data mahasiswa --");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/mahasiswa.odb");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		mahasiswa m = new
				mahasiswa("1913000004", "Wahyu Jatmiko", 'L', "15-10-2000", 2, 40.15f);
		em.persist(m);
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
		System.out.println("-- Menampilkan data mahasiswa --");
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/mahasiswa.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<mahasiswa> query =
				em.createQuery("SELECT m FROM mahasiswa m", mahasiswa.class);
		List<mahasiswa> results = query.getResultList();
		for (mahasiswa n : results) {
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
		System.out.println("-- Mengubah data mahasiswa --");
		String NIM = "1913000018";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/mahasiswa.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<mahasiswa> query =
				em.createQuery("SELECT m FROM mahasiswa m", mahasiswa.class);
		List<mahasiswa> results = query.getResultList();
		for (mahasiswa n : results) {
			if (NIM.equals(n.getNIM())) {
				em.getTransaction().begin();
				n.setGender('P');
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
		System.out.println("-- Menghapus data mahasiswa --");
		String NIM = "1913000004";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/mahasiswa.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<mahasiswa> query =
				em.createQuery("SELECT m FROM mahasiswa m", mahasiswa.class);
		List<mahasiswa> results = query.getResultList();
		for (mahasiswa n : results) {
			if (NIM.equals(n.getNIM())) {
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
		System.out.println("-- Mencari data mahasiswa --");
		String NIM = "1913000002";
		boolean found = false;
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("$objectdb/db/mahasiswa.odb");
		EntityManager em = emf.createEntityManager();
		TypedQuery<mahasiswa> query =
				em.createQuery("SELECT m FROM mahasiswa m", mahasiswa.class);
		List<mahasiswa> results = query.getResultList();
		for (mahasiswa n : results) {
			if (NIM.equals(n.getNIM())) {
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