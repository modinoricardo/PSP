package ejer;

public class GeneraNum {

	public static void main(String[] args) {
		final int totalNum = 10;

		try {

			int contador = 1;

			do {
				int numRandom = (int) (Math.random() * 100) + 1;

				if (!esPar(numRandom)) {
					System.out.println(numRandom);
					contador++;
				}

			} while (contador <= totalNum);
			System.exit(0);
		} catch (Exception e) {
			System.exit(-1);
		}
	}

	private static boolean esPar(int num) {
		return num % 2 == 0;
	}
}
