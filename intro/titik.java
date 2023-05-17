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
