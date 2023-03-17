package br.pucrs;

import java.util.Arrays;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		long[] A = geraVetor(16, 16);
		long[] auxA = new long[A.length];

		System.out.println("Vetor A original:\n" + Arrays.toString(A));
		mergeSort(A, auxA, 0, A.length-1);
		System.out.println("Vetor A ordenado:\n" + Arrays.toString(A));
		System.out.println("MaxVal1: " + maxVal1(A, A.length));
		System.out.println("MaxVal2: " + maxVal2(A, 0, A.length));

		long[] B = geraVetor(1024, 1024);
		long[] auxB = new long[B.length];

		System.out.println("Vetor B original:\n" + Arrays.toString(B));
		mergeSort(B, auxB, 0, B.length-1);
		System.out.println("Vetor B ordenado:\n" + Arrays.toString(B));
		System.out.println("MaxVal1: " + maxVal1(B, B.length));
		System.out.println("MaxVal2: " + maxVal2(B, 0, B.length));

		long[] C = geraVetor(524288, 524288);
		long[] auxC = new long[C.length];

		System.out.println("Vetor C original:\n" + Arrays.toString(C));
		mergeSort(C, auxC, 0, C.length-1);
		System.out.println("Vetor C ordenado:\n" + Arrays.toString(C));
		System.out.println("MaxVal1: " + maxVal1(C, C.length));
		System.out.println("MaxVal2: " + maxVal2(C, 0, C.length));
	}

	public static void mergeSort(long[] A, long[] aux, int ini, int fim) {
		if (ini < fim) {
			int meio = (ini + fim) / 2;
			mergeSort(A, aux, ini, meio);
			mergeSort(A, aux, meio + 1, fim);
			intercalar(A, aux, ini, meio, fim);
		}
	}

	private static void intercalar(long[] A, long[] aux, int ini, int meio, int fim) {
		for (int k = ini; k <= fim; k++) {
			aux[k] = A[k];
		}

		int i = ini;
		int j = meio + 1;

		for (int k = ini; k <= fim; k++) {
			if (i > meio)
				A[k] = aux[j++];
			else if (j > fim)
				A[k] = aux[i++];
			else if (aux[i] < aux[j])
				A[k] = aux[i++];
			else
				A[k] = aux[j++];
		}
	}

	public static long maxVal1(long A[], int n) {
		long ini = System.currentTimeMillis();
		long max = A[0];
		int it = 0;
		it += 2;
		for (int i = 1; i < n; i++) {
			it++;
			if (A[i] > max) {
				max = A[i];
				it += 2;
			}
		}
		System.out.println("Tamanho: " + A.length + " - Iterações: " + it + " - Tempo: "
				+ (((double) System.currentTimeMillis() - ini) / 1000) + " segundos");
		return max;
	}

	public static long maxVal2(long A[], int init, int end) {
		if (end - init <= 1) {
			return maxVal2(A, (int) A[init], (int) A[end]);
		} else {
			int m = (init + end) / 2;
			long v1 = maxVal2(A, init, m);
			long v2 = maxVal2(A, m + 1, end);
			return maxVal2(A, (int) v1, (int) v2);
		}
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
