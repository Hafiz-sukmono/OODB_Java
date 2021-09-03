package latihan1;

class segiempat {
	int pjg;
	int lbr;
}

public class persegi {

	public static void main(String[] args) {
		
		segiempat segipanjang = new segiempat();
		segipanjang.pjg = 10;
		segipanjang.lbr = 5;
		int luas;
		int keliling;
		luas = segipanjang.pjg * segipanjang.lbr;
		System.out.println("luas segipanjang : "+luas);
		segiempat bujursangkar = new segiempat();
		bujursangkar.pjg = bujursangkar.lbr = 5;
		luas = bujursangkar.pjg * bujursangkar.lbr;
		System.out.println("Luas bujursangkar : "+luas);
		keliling = segipanjang.pjg + segipanjang.lbr;
		System.out.println("keliling segipanjang : "+keliling);
		keliling = bujursangkar.pjg + bujursangkar.lbr;
		System.out.println("keliling bujursangkar : "+keliling);

	}

}
