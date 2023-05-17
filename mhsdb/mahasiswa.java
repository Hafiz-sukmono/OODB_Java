package mhsdb;

/*
 * NIM  : 1913000018
 * Nama : Hafiz Sukmono
 */

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.text.*;

@Entity
public class mahasiswa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long id;
	private String NIM;
	private String nama;
	private char gender;
	private Date tanggallahir;
	private int jsdr;
	private float NEM;
	
	public mahasiswa() {
		NIM = "1913000018";
		nama = "Hafiz Sukmono";
		gender = 'L';
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		tanggallahir = (Date) fmt.parse("18-03-2001");
		}
		catch(ParseException e)
		{
			System.out.println("Exeption : " +e);
		}
		jsdr = 2;
		NEM = 35.65f;
	}
		
	public mahasiswa(String NIM, String nama, char gender, String tanggallahir, int jsdr, float NEM) {
		this.NIM = NIM;
		this.nama = nama;
		this.gender = gender;
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		this.tanggallahir = (Date) fmt.parse(tanggallahir);
		}
		catch(ParseException e)
		{
			System.out.println("Exeption : " +e);
		}
		this.jsdr = jsdr;
		this.NEM = NEM;
	}
	
	public long getId() {
		return this.id;
	}
	public String getNIM() {
		return this.NIM;
	}
	public String getNama() {
		return this.nama;
	}
	public char getGender() {
		return this.gender;
	}
	public String getTanggalLahir() {
		String tanggallahir;
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		tanggallahir = fmt.format(this.tanggallahir);
		return tanggallahir;
	}
	public int getjsdr() {
		return this.jsdr;
	}
	public float getNEM() {
		return this.NEM;
	}
	
	public void setNIM(String NIM) {
		this.NIM = NIM;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setTanggalLahir(String tanggallahir) {
		try
		{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");	
		this.tanggallahir = (Date) fmt.parse(tanggallahir);
		}
		catch(ParseException e)
		{
			System.out.println("Exception : " +e);
		}
	}
	public void setjsdr(int jsdr) {
		this.jsdr = jsdr;
	}
	public void setNEM(float NEM) {
		this.NEM = NEM;
	}
	
	@Override
   public String toString()
   {
		String tanggallahir;
		SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yyyy");
		tanggallahir = fmt.format(this.tanggallahir);
		return String.format("(%s, %s, %c, %s, %d, %f)", this.NIM, this.nama, this.gender, tanggallahir, this.jsdr, this.NEM);
   }
}
