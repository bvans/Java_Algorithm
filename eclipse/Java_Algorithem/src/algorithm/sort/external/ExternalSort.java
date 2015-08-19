package algorithm.sort.external;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalSort {
	/**
	 * 使用10M内存
	 */
	public static final long FREE_MEMMORY = 10 * 1024;

	public static void main(String[] args) throws IOException {
		String in = "D:\\Users\\fan\\Desktop\\jit.js";
		String out = in + ".sorted";
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		
		List<File> tmps = sortInBatch(new File(in), cmp);
		mergeSortedFiles(tmps, new File(out), cmp);
	}

	/**
	 * 分割后的小文件的大小
	 */
	public static long getSizeOfBolcks(File toBeSorted) {
		// 使用一半的内存空间用作对文件中所有的数据进行排序
		return FREE_MEMMORY / 2;
	}

	/**
	 * @param tmpList
	 *            待排序的数据
	 * @param tmp
	 *            排序方法
	 * @return 含有排好序的数据的临时文件
	 * @throws IOException
	 */
	public static File sortAndSave(List<String> tmpList, Comparator tmp)
			throws IOException {
		Collections.sort(tmpList);
		File newTmpFile = File.createTempFile("sortInBatch", "flatFile");
		newTmpFile.deleteOnExit();
		BufferedWriter bw = new BufferedWriter(new FileWriter(newTmpFile));
		try {
			for (String r : tmpList) {
				bw.write(r);
				bw.newLine();
			}
		} finally {
			bw.close();
		}
		return newTmpFile;

	}

	/**
	 * @param file
	 *            待排序的大文件
	 * @param cmp
	 *            每行数据的排序方法
	 * @return 排好序的小文件列表
	 * @throws IOException
	 */
	public static List<File> sortInBatch(File file, Comparator cmp)
			throws IOException {
		List<File> files = new ArrayList<File>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		long blockSize = getSizeOfBolcks(file);

		List<String> tmpList = new ArrayList<String>();
		String line = "";
		try {
			while (line != null) {
				long curBlockSize = 0;

				while (curBlockSize < blockSize
						&& ((line = br.readLine()) != null)) {
					// 将每行待排序的数据加入链表
					tmpList.add(line);
					blockSize += line.length();
				}

				// 读满一个小文件, 对其进行排序并存储
				files.add(sortAndSave(tmpList, cmp));
				tmpList.clear();
			}
		} catch (IOException e) {
			if (tmpList.size() > 0) {
				files.add(sortAndSave(tmpList, cmp));
				tmpList.clear();
			}
		} finally {
			br.close();
		}

		return files;
	}

	public static int mergeSortedFiles(List<File> files, File outFile,
			final Comparator cmp) throws IOException {
		PriorityQueue<BinaryFileBuffer> queue = new PriorityQueue<BinaryFileBuffer>(
				11, new Comparator<BinaryFileBuffer>() {
					@Override
					public int compare(BinaryFileBuffer i, BinaryFileBuffer j) {
						return cmp.compare(i.peek(), j.peek());
					}
				});

		for (File file : files) {
			BinaryFileBuffer bfr = new BinaryFileBuffer(file);
			queue.add(bfr);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int rowCounter = 0;
		while (queue.size() > 0) {
			BinaryFileBuffer buffer = queue.poll();
			String r = buffer.pop();
			bw.write(r);
			bw.newLine();
			++rowCounter;
			if (buffer.empty) {
				// 当前buffer对应的文件读取完毕
				buffer.close();
				buffer.originalFile.delete();
			} else {
				queue.add(buffer);
			}
		}
		bw.close();
		return rowCounter;
	}

	static class BinaryFileBuffer {
		public static final int BEFEER_SIZE = 2048;
		public BufferedReader br;
		public File originalFile;
		public String cache;
		private boolean empty;

		public BinaryFileBuffer(File file) throws FileNotFoundException {
			originalFile = file;
			br = new BufferedReader(new FileReader(file), BEFEER_SIZE);
			reload();
		}

		public void reload() {
			try {
				if ((cache = br.readLine()) == null) {
					empty = true;
					cache = null;
				} else {
					empty = false;
				}
			} catch (IOException e) {
				empty = true;
				cache = null;
			}
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public String peek() {
			if (empty) {
				return null;
			} else {
				return cache.toString();
			}
		}

		public String pop() throws IOException{
			String answer = peek();
			reload();
			return answer;
		}
	}
}
