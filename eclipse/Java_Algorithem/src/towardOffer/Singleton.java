package towardOffer;

public class Singleton {
	static class SingletonHolder {
		static Singleton instance = new Singleton();
	}

	static Singleton getInsance() {
		return SingletonHolder.instance;
	}
}
