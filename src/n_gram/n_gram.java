package n_gram;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class n_gram {
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
	public static HashMap<String, Integer> index(
			HashMap<String, Integer> index, int n, String str) {
		// TODO 檢查有沒有 tab
		int count=0;
		str = str.substring(str.indexOf("\t") + 1);
		String[] words = str.split(" ");
		for (int i = 0; i < words.length - n + 1; i++) {
			String ngram = concat(words, i, i + n);
			if (ngram.contains("	")) {
				index.remove(ngram);
				continue;

			}
			if (!index.containsKey(ngram)) {
				index.put(ngram, count+=1);
			}
			index.put(ngram, count);
		}
		return index;
	}
	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}

	public static void main(String[] argv) throws IOException {
		FileInputStream fr = new FileInputStream("Seg_TrainingData.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fr,"UTF-8"));
		FileInputStream Index_fr = new FileInputStream("Seg_TrainingData.txt");
		BufferedReader Index_br = new BufferedReader(new InputStreamReader(Index_fr,"UTF-8"));
		String strNum = null;
		String strNum_index = null;
		String Ngram_line = null;
		String Index_line = null;
		Path Ngram_file = null;
		Path Index_file = null;
		BufferedWriter bufferedWriter = null;
		HashMap<String, Integer> ngrams = new HashMap<String, Integer>();
		HashMap<String, Integer> index = new HashMap<String, Integer>();

		while ((strNum = br.readLine()) != null) {
			//ngrams = n_gram.ngrams(ngrams, 1, strNum);
			 ngrams = n_gram.ngrams(ngrams, 2, strNum);
		}
		while ((strNum_index = Index_br.readLine()) != null) {
			//index = n_gram.index(index, 1, strNum_index);
			 index = n_gram.index(index, 2, strNum_index);
		}
		try {
			if (Files.exists(Paths.get("Ngram_data_output.txt")))
			{
				Files.delete(Paths.get("Ngram_data_output.txt"));
			}
			Ngram_file = Files.createFile(Paths.get("Ngram_data_output.txt"));
			bufferedWriter = Files.newBufferedWriter(Ngram_file,Charset.forName("UTF-8"));
				for (Entry<String, Integer> m : ngrams.entrySet()) {
					Ngram_line = (m.getKey() + " " + m.getValue());
					bufferedWriter.write(Ngram_line);
					bufferedWriter.newLine();
				}
				bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (Files.exists(Paths.get("Index_data_output.txt")))
			{
				Files.delete(Paths.get("Index_data_output.txt"));
			}
			Index_file = Files.createFile(Paths.get("Index_data_output.txt"));
			bufferedWriter = Files.newBufferedWriter(Index_file,Charset.forName("UTF-8"));
				for (Entry<String, Integer> n : index.entrySet()) {
					Index_line = (n.getKey() + ":" + n.getValue());
					bufferedWriter.write(Index_line);
					bufferedWriter.newLine();
				}
				bufferedWriter.close();
		} catch (IOException x) {
			x.printStackTrace();
		}
		System.out.println("Complete");
	}
}
