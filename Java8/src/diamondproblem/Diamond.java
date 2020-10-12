package diamondproblem;

public class Diamond implements Interface1, Interface2 {

	public static void main(String[] args) {
		Diamond d = new Diamond();
		d.draw();
	}

	@Override
	public void draw() {
		Interface1.super.draw();
		Interface2.super.draw();
	}

}
