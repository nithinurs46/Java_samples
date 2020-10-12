import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

interface LambdaBlock {
	String testLambda(int i);
}

public class LambdaFunction {
	public static void main(String[] args) {

		//java 8 approach
		LambdaBlock lamda = (i) -> {
			if (i % 2 == 0) {
				return ("even");
			} else {
				return ("odd");
			}
		};
		System.out.println(lamda.testLambda(3));
		
		//without java 8.. we had to write anonymous inner class
		LambdaBlock lb = new LambdaBlock() {
			
			@Override
			public String testLambda(int i) {
				if (i % 2 == 0) {
					return ("even");
				} else {
					return ("odd");
				}
			}
		};
		System.out.println(lb.testLambda(3));
	}
	
}

interface SuffixFunction {
	String call();
}

class LambdaTest {
	public static void main(String[] args) {
		String word = "test";
		SuffixFunction suffix = () -> (word+"HI");
		System.out.println(suffix.call());
		
		List<Integer> arr = new ArrayList<>(2);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.println(arr.size());
		
	}
}
