//Kuvaev Maksim(2020a)
//11a(Release)
//241219
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Release {
	static String inputFilename = "output.jpg";
	static String outputFilename = "answer.jpg";
	static int bitNum = 0;
	static byte thisByte;
	static BufferedInputStream bin;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		bin = new BufferedInputStream(new FileInputStream(inputFilename));
		frequence();
		Haffman.createTree();
		Haffman.wSum = Haffman.tree[2*Haffman.M-2].w;
		output();
		bin.close();

	}

	public static void frequence() throws IOException {
		Haffman.M = bin.read() + 1;
		Haffman.freq = new int[Haffman.SIZE];
		for (int i = 0; i < Haffman.M; i++) {
			int symb = bin.read();
			int len = 0;
			for (int j = 0; j < 4; j++) {
				len = (len << 8) + bin.read();
			}
			Haffman.freq[symb] += len;
		}
	}

	public static void output() throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFilename));
		int count = 0;
		int cur = 2 * Haffman.M - 2;
		while (count < Haffman.wSum) {
			int bit = getNextBit();
			if (Haffman.M == 1) {
				bos.write(Haffman.tree[cur].symb);
				count++;
			} else {
				if (bit == 0) {
					cur = Haffman.tree[cur].left;
				} else {
					cur = Haffman.tree[cur].right;
				}
				if (Haffman.tree[cur].symb > -1) {
					bos.write(Haffman.tree[cur].symb);
					cur = 2 * Haffman.M - 2;
					count++;
				}
			}
		}
		bos.close();
	}

	public static int getNextBit() throws IOException {
		int res = 0;
		if (bitNum % 8 == 0) {
			thisByte = (byte) bin.read();
			// System.out.println(thisByte);
			bitNum = 0;
		}
		res = thisByte >> 7;
		thisByte = (byte) (thisByte << 1);
		bitNum++;
		return res;

	}

}