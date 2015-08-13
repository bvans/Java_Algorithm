package me.mhxy;


interface Bitmap {
	//对象大小
	int getByteCount();
	//回收对象资源
	void recycle();
}

class ImgCache<K> extends LruCache<K, Bitmap> {

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