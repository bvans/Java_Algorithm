package me.mhxy.sort;

public class SelectionSrot {
	/**
	 * i左边是排好序的
	 * 每次从i右边的集合中选择最小的值与i+1交换
	 * i++
	 */
	public static void selectionSort(int[] data) {
		for(int i = 0; i < data.length - 1; i++) {
			int least = i;
			for(int j = i + 1; j < data.length; j++) {
				if(data[j] <= data[least]) {
					least = j;
				}
			}
			int tmp = data[least];
			data[least] = data[i];
			data[i] = tmp;
		}
	}
	
	public static void heapSort(int[] data) {
		//初始化堆, 保证所有的非叶子节点都大于其子孙
		for(int i = data.length / 2 - 1; i >= 0; i--) {
			moveDown(data, i, data.length -1);
		}
		
		//(迭代), 依次将最大值放到叶子上
		//最后一个位置肯定不用排了, 因为前n-1个都放置正确了
		for(int i = data.length - 1; i >= 1; i--) {
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;
			
			moveDown(data, 0, i - 1);
		}
	}
	
	/**
	 * 将某个节点下沉到合适的位置
	 * 保证first节点的值大于其所有的子孙值
	 */
	private static void moveDown(int[] data, int first, int last) {
		int child = 2 * first + 1;
		while(child <= last) {
			if(child < last && data[child] < data[child + 1]) {
				child++;
			}
			
			//与较大的孩子交换
			//交换后继续递归交换,确保沉到最下边
			if(data[first] < data[child]) {
				int tmp = data[child];
				data[child] = data[first];
				data[first] = tmp;
				
				//递归重构子树,使得first不仅大于孩子节点
				//而且大于子孙节点
				first = child;
				child = first*2 + 1;
			} else {
				//大于
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) Math.floor(Math.random() * 21);
			System.out.print(a[i] + ",");
		}
		System.out.println("排序");
		heapSort (a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		return;
	}
}
