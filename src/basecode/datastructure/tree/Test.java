package basecode.datastructure.tree;

public class Test {
	public static void main(String[] args) {
		Tree tr = new Tree();
		tr.add(15);
		tr.add(10);
		tr.add(13);
		tr.add(50);
		tr.add(30);
		tr.add(20);
		tr.add(40);
		tr.add(6);
		tr.add(21);
		tr.add(34);
		tr.add(54);
		tr.add(12);
		tr.midOrder1(tr.root);
	}
}
