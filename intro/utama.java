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
		
		//menyimpan 10 object titik dalam database 
        em.getTransaction().begin();
		for (int i=5;i<20;i++) {
			titik t = new titik(i,i);
			em.persist(t);
		}
		em.getTransaction().commit();
	
		
		//Mengubah nilai sumbu y dengan ditambah 15
        em.getTransaction().begin();
		for (titik t : hasil) {
			t.sety(t.gety() + 15);
		}
		em.getTransaction().commit();

		
		//Menghapus semua objek titik
/*		em.getTransaction().begin();
		for (titik t : hasil) {
			em.remove(t); //delete entity
		}
		em.getTransaction().commit();
*/		
		
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
