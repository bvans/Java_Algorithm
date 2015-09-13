package designPatterns;

public class Singleton {
	public static void main(String[] args) {
		Single.getTest();
	}
}

class Single {
	public static Single getInstance() {
		return SingleHelper.instance;
	}
	
	public static void getTest() {
		
	}
	
	static {
		System.out.println("Single初始化");
	}
	

	static class SingleHelper {
		public static final Single instance = new Single();
		
		static {
			System.out.println("inner class 初始化");
		}
	}
}