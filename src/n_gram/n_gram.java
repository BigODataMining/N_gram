package n_gram;

import java.util.*;

public class n_gram {

	public static HashMap<String, Integer> ngrams(int n, String str) {
		HashMap<String, Integer> ngrams = new HashMap<String, Integer>();

		String[] words = str.split(" ");
		for (int i = 0; i < words.length - n + 1; i++) {
			String ngram = concat(words, i, i + n);
			if (!ngrams.containsKey(ngram)) {
				ngrams.put(ngram, 0);
			}
			ngrams.put(ngram, ngrams.get(ngram) + 1);
		}
		// ngrams.add(concat(words, i, i+n));
		return ngrams;
	}

	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		HashMap map;
		String str = "NBAWade �X�� �� ���� �g �@ ��M �M �нm ���� �O�� ���p ��X ���� ���� �u �{�q�L �v Dwyane Wade ��� ���X �F �s�� �u A Father First : How My Life Became Bigger Than Basketball �v �A �� �S�a �e �F �@ �� ñ�W�� �� �n�S�� �u �p �ӫ� �v Lebron James �A Wade �b �� �� ���F �j�� ���� �g �A �] �z�S �F �@�� �� �� �H �� �� ���� ���� �A �]�A �L �b �u���� �ǨM�� �ĤT �� �M �нm Erik Spoelstra ��| �� ���� �C Wade �b ���~ �u���� ���� �� ���� �F�� �ǨM�� �ĤT �Ԯ� �A �� ���� ���M Spoelstra �o�� �E�P �Ĭ� �A �� �H �b �O�� �u �}�f�j�| ��� �� �e�� �Ʀ� �z�L �q�� �༽ �� �Ҧ� �y�g �� �ݨ� �F �A �� �� Wade �b �� �� ���� �F ��� �� ���p �A ��� �ۤv ���� �� ���� ���� ��i �A �� Spoelstra ���n �Q �L �� ��� �� �� �� �C �u ( Spoelstra ) �i�� �Q �� �� �� �� �ͮ� �A �]�� �� �ͮ� �� �ɭ� �q�` ��{ �� �� �n ";
		//int j = 1;
//		for (String ngram : ngrams(
//				1,
//				"NBAWade �X�� �� ���� �g �@ ��M �M �нm ���� �O�� ���p ��X ���� ���� �u �{�q�L �v Dwyane Wade ��� ���X �F �s�� �u A Father First : How My Life Became Bigger Than Basketball �v �A �� �S�a �e �F �@ �� ñ�W�� �� �n�S�� �u �p �ӫ� �v Lebron James �A Wade �b �� �� ���F �j�� ���� �g �A �] �z�S �F �@�� �� �� �H �� �� ���� ���� �A �]�A �L �b �u���� �ǨM�� �ĤT �� �M �нm Erik Spoelstra ��| �� ���� �C Wade �b ���~ �u���� ���� �� ���� �F�� �ǨM�� �ĤT �Ԯ� �A �� ���� ���M Spoelstra �o�� �E�P �Ĭ� �A �� �H �b �O�� �u �}�f�j�| ��� �� �e�� �Ʀ� �z�L �q�� �༽ �� �Ҧ� �y�g �� �ݨ� �F �A �� �� Wade �b �� �� ���� �F ��� �� ���p �A ��� �ۤv ���� �� ���� ���� ��i �A �� Spoelstra ���n �Q �L �� ��� �� �� �� �C �u ( Spoelstra ) �i�� �Q �� �� �� �� �ͮ� �A �]�� �� �ͮ� �� �ɭ� �q�` ��{ �� �� �n "))
//			map.put(ngram, j);
//		for (Object key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}
		// Ū��
		// �� tab => String[] xx
		// str = xx[1];		
		map = n_gram.ngrams(3, str);
	}
}
