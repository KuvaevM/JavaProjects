//Kuvaev Maksim(2020a)
//11a(Compress)
//241219
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Compress {
	static String inputFilename = "input.jpg";
	static String outputFilename = "output.jpg";
	static String code[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		frequence();
		Haffman.createTree();
		setCodes(2 * Haffman.M - 2);
		codes();
		compression();

	}

	public static void frequence() throws IOException {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(inputFilename));
		Haffman.freq = new int[Haffman.SIZE];
		int symb;
		while ((symb = bin.read()) != -1) {
			if (Haffman.freq[symb] == 0) {
				Haffman.M++;
			}
			Haffman.freq[symb]++;

		}
		bin.close();
	}


	public static void setCodes(int num) {
		if (Haffman.tree[num].symb >= 0) {
			if (Haffman.tree[num].code.length()==0) {
				Haffman.tree[num].code = "0";
			}
			return;
		}
		Haffman.tree[Haffman.tree[num].left].code = Haffman.tree[num].code + "0";
		Haffman.tree[Haffman.tree[num].right].code = Haffman.tree[num].code + "1";
		setCodes(Haffman.tree[num].left);
		setCodes(Haffman.tree[num].right);
	}

	public static void codes() {
		code = new String[Haffman.SIZE];
		for (int i = 0; i < Haffman.M; i++) {
			code[Haffman.tree[i].symb] = Haffman.tree[i].code;
		}
	}

	public static void compression() throws IOException {
		// BufferedWriter bw = new Buffered;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFilename));
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(inputFilename));
		Haffman.wSum = 0;
		bos.write(Haffman.M - 1);
		for (int i = 0; i < Haffman.M; i++) {
			bos.write(Haffman.tree[i].symb);
			Haffman.wSum += Haffman.tree[i].w;
			for (int j = 0;j<Integer.SIZE;j+=Byte.SIZE) {
				bos.write((Haffman.tree[i].w << j) >> Haffman.SHIFT);
			}
		}
		String buffer = "";
		for (int i = 0; i < Haffman.wSum; i++) {
			int v = bin.read();
			buffer = buffer + code[v];
			while (buffer.length() >= 8) {
				String num = buffer.substring(0, 8);
				buffer = buffer.substring(8, buffer.length());
				int x = Integer.parseInt(num, 2);
				bos.write(x);
			}
		}
		if (buffer.length() > 0) {
			while (buffer.length() < 8) {
				buffer = buffer + "0";
			}
			int x = Integer.parseInt(buffer, 2);
			System.out.println(x);
//			System.out.println(x);
			bos.write(x);

		}
		bos.close();
		bin.close();
	}

}



