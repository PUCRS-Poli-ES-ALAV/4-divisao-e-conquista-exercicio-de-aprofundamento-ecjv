package br.pucrs;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		long[] A = geraVetor(16, 16);
		long[] B = geraVetor(1024, 1024);
		long[] C = geraVetor(524288, 524288);
		System.out.println("N=32: " + maxVal1(A, A.length));
		System.out.println("N=2048: " + maxVal1(B, B.length));
		System.out.println("N=1048576: " + maxVal1(C, C.length));
	}

	public static long maxVal1(long A[], int n) {
		long max = A[0];
		for (int i = 1; i < n; i++) {
			if (A[i] > max)
				max = A[i];
		}
		return max;
	}

	public static long[] geraVetor(int nroPares, int nroImpares) {
		long[] res = null;
		int contPar = 0, contImpar = 0, novoNum;
		Random rnd = new Random();

		if ((nroPares >= 0) ||
				(nroImpares >= 0) &&
						(nroPares + nroImpares > 0)) {

			res = new long[nroPares + nroImpares];

			while ((contPar < nroPares) || (contImpar < nroImpares)) {
				novoNum = rnd.nextInt(98) + 1;

				if ((novoNum % 2 == 0) && (contPar < nroPares)) {
					res[contPar + contImpar] = novoNum;
					contPar++;
				} else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
					res[contPar + contImpar] = novoNum;
					contImpar++;
				}
			}
		}

		return res;
	}
}
