package algorithm;


interface Bitmap {
	//对象大小
	int getByteCount();
	//回收对象资源
	void recycle();
}

class ImgCache<K> extends LruCache<K, Bitmap> {
	
	public static void main(String[] args) {
		LruCache<String, Integer> lru = new LruCache<String, Integer>(2);
		lru.put("1", 1);
		lru.put("2", 2);
		lru.put("3", 3);
		lru.put("4", 4);
		
		System.out.println(lru.size());
		int a = lru.get("3");
		System.out.println(a);
	}

	public ImgCache(int maxSize) {
		super(maxSize);

	}

	@Override
	protected int sizeOf(K key, Bitmap value) {
		return value.getByteCount();
	}

	@Override
	protected void entryRemoved(boolean evicted, K key, Bitmap oldValue,
			Bitmap newValue) {
		super.entryRemoved(evicted, key, oldValue, newValue);
		oldValue.recycle();
	}

}