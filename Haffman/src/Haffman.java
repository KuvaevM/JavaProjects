//Kuvaev Maksim(2020a)
//11a(Main)
//241219
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Haffman {
	static int freq[];
	static final int SIZE = 256;
	static final int SHIFT = 24;
	static Node tree[];
	static int M = 0;
	static int wSum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

	public static void createTree() {
		tree = new Node[2 * M - 1];
		int len = 0;
		for (int i = 0; i < SIZE; i++) {
			if (freq[i] != 0) {
				tree[len] = new Node(freq[i], -1, -1, i);
				len++;
			}
		}
		for (int i = 0; i < M - 1; i++) {
			int min1 = findMin(len);
			int min2 = findMin(len);
			tree[len] = new Node(tree[min1].w + tree[min2].w, min1, min2, -1);
			len++;
		}
	}
	
	public static int findMin(int len) {
		int min = Integer.MAX_VALUE;
		int min1 = 0;
		for (int j = 0; j < len; j++) {
			if (min > tree[j].w && tree[j].used == false) {
				min = tree[j].w;
				min1 = j;
			}
		}
		tree[min1].used = true;
		return min1;
	}


}

class Node {
	int w;
	int left, right;
	int symb;
	boolean used = false;
	String code = "";

	Node(int w1, int left1, int right1, int symb1) {
		w = w1;
		left = left1;
		right = right1;
		symb = symb1;
	}
}
