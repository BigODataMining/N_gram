package n_gram;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class n_gram {
	/**
	 * 
	 * @param ngrams
	 * @param n
	 * @param str
	 * @return
	 */
	public static HashMap<String, Integer> ngrams(
			HashMap<String, Integer> ngrams, int n, String str) {
		// TODO 檢查有沒有 tab
		str = str.substring(str.indexOf("\t") + 1);

		String[] words = str.split(" ");
		for (int i = 0; i < words.length - n + 1; i++) {
			String ngram = concat(words, i, i + n);
			if (ngram.contains("	")) {
				ngrams.remove(ngram);
				continue;

			}
			if (!ngrams.containsKey(ngram)) {
				ngrams.put(ngram, 0);
			}
			ngrams.put(ngram, ngrams.get(ngram) + 1);
		}
		return ngrams;
	}

	/**
	 * 加入註解
	 * 
	 * @param words
	 * @param start
	 * @param end
	 * @return
	 */
	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}

	public static void main(String[] argv) throws IOException {
		FileInputStream fr = new FileInputStream("Seg_TestingData.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fr,
				"UTF-8"));
		StringBuffer sb = new StringBuffer();
		String strNum = null;
		String line = null;
		Path file = null;
		BufferedWriter bufferedWriter = null;
		HashMap<String, Integer> ngrams = new HashMap<String, Integer>();

		while ((strNum = br.readLine()) != null) {
			//ngrams = n_gram.ngrams(ngrams, 1, strNum);
			 ngrams = n_gram.ngrams(ngrams, 2, strNum);
		}
		try {
			if (Files.exists(Paths.get("data_output.txt")))
			{
				Files.delete(Paths.get("data_output.txt"));
			}
			file = Files.createFile(Paths.get("data_output.txt"));
			bufferedWriter = Files.newBufferedWriter(file,
					Charset.forName("UTF-8"));
			for (Entry<String, Integer> m : ngrams.entrySet()) {
				line = (m.getKey() + " " + m.getValue());
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Complete");
	}
}
