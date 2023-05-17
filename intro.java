package intro;
/* 
 * @author NIM  : 1913000018
 *         Nama : Hafiz Sukmono
 */
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class titik implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long id;
	
	private int x;
	private int y;
	
	public titik() {
		
	}
	
	titik(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Long getId() {
		return id;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %d)",this.x, this.y);
	}
}








package intro;
/**
 * @author NIM  : 1913000018
 *         Nama : Hafiz Sukmono
 */
import javax.persistence.*;
import java.util.*;

public class utama {
	public static void main(String[] args) {
		// Buku Koneksi database object
		// membuat database baru jika tidak ada sebelumnya
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("$objectdb/db/titik.odb");
		EntityManager em = emf.createEntityManager();
		
		//Membaca semua object titik dari database 
		TypedQuery<titik> query =
			em.createQuery("SELECT t FROM titik t", titik.class);
		List<titik> hasil = query.getResultList();
		
		//menyimpan 15 object titik dalam database 
/*        em.getTransaction().begin();
		for (int i=5;i<20;i++) {
			titik t = new titik(i,i);
			em.persist(t);
		}
		em.getTransaction().commit();
*/	
		
		//Mengubah nilai sumbu y dengan ditambah 15
/*        em.getTransaction().begin();
		for (titik t : hasil) {
			t.sety(t.gety() + 15);
		}
		em.getTransaction().commit();
*/
		
		//Menghapus semua objek titik
		em.getTransaction().begin();
		for (titik t : hasil) {
			em.remove(t); //delete entity
		}
		em.getTransaction().commit();
		
		//mencari jumlah objek titik dalam databse
		Query q1 = em.createQuery("SELECT COUNT(t) FROM titik t");
		System.out.println("Total object Titik : "+q1.getSingleResult());
		
		//Mecari rata-rata sumbu x
		Query q2 = em.createQuery("SELECT AVG(t.x) FROM titik t");
		System.out.println("Rata-rata x : "+q2.getSingleResult());
		
		//Mencari rata-rata sumbu y
		Query q3 = em.createQuery("SELECT AVG(t.y) FROM titik t");
		System.out.println("Rata-rata y : "+q3.getSingleResult());
		
		//Mencari Nilai minimal sumbu x
		Query q4 = em.createQuery("SELECT MIN(t.x) FROM titik t");
		System.out.println("Minimal x : "+q4.getSingleResult());
		
		//Mencari Nilai maximum sumbu y
		Query q5 = em.createQuery("SELECT MAX(t.y) FROM titik t");
		System.out.println("Maximum y : "+q5.getSingleResult());
		
		//Mencari Nilai total sumbu x
		Query q6 = em.createQuery("SELECT SUM(t.x) FROM titik t");
		System.out.println("Total x : "+q6.getSingleResult());
		
		//Membaca semua object titik dari database 
		for (titik t : hasil) {
			System.out.println(t);
		}
		
		//Menutup Koneksi database
		em.close();
		emf.close();

	} 
}


Total object Titik : 30
Rata-rata x : 12.0
Rata-rata y : 19.5
Minimal x : 5
Maximum y : 34
Total x : 360
5, 20)
6, 21)
7, 22)
8, 23)
9, 24)
10, 25)
11, 26)
12, 27)
13, 28)
14, 29)
15, 30)
16, 31)
17, 32)
18, 33)
19, 34)

Total object Titik : 0
Rata-rata x : null
Rata-rata y : null
Minimal x : null
Maximum y : null
Total x : null

//Tidak Jauh berbeda dengan pertemuan 9, hanya berbeda di bagian paling bawah / baris ke 139 - 166
