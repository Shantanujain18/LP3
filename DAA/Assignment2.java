import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

class HuffmanNode {

	int data;
	char c;

	HuffmanNode left;
	HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y) {

		return x.data - y.data;
	}
}

class HuffmanTree {
	HuffmanNode root;

	HuffmanTree() {
		root = null;
	}

	public void printCode(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	public void createTree(int n, char[] charArray, int[] charfreq) {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

		for (int i = 0; i < n; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.data = charfreq[i];

			hn.left = null;
			hn.right = null;

			q.add(hn);
		}
		while (q.size() > 1) {
			HuffmanNode x = q.peek();
			q.poll();

			HuffmanNode y = q.peek();
			q.poll();

			HuffmanNode f = new HuffmanNode();

			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			this.root = f;

			q.add(f);
		}

		// print the codes by traversing the tree
		printCode(this.root, "");
	}
}

public class Assignment2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println(" -------------------------- Huffman Encoding --------------------------");
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		HuffmanTree tree = new HuffmanTree();
		tree.createTree(n, charArray, charfreq);

		System.out.println(" -------------------------- Huffman Encoding --------------------------");

		System.out.println("Enter no of characters : ");
		n = sc.nextInt();
		charArray = new char[n];
		charfreq = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("\nEnter character : ");
			char[] ch = sc.next().toCharArray();
			charArray[i] = ch[0];

			System.out.print("\nEnter frequency of character : ");
			int fr = sc.nextInt();
			charfreq[i] = fr;
		}
		System.out.println();
		tree = new HuffmanTree();
		tree.createTree(n, charArray, charfreq);

		sc.close();
	}
}