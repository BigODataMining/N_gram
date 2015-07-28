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
		String str = "NBAWade 出書 談 爸爸 經 　 澄清 和 教練 爭執 記者 邵瑞峰 綜合 報導 熱火 「 閃電俠 」 Dwyane Wade 近日 推出 了 新書 「 A Father First : How My Life Became Bigger Than Basketball 」 ， 還 特地 送 了 一 本 簽名書 給 好兄弟 「 小 皇帝 」 Lebron James ， Wade 在 書 中 除了 大談 爸爸 經 ， 也 透露 了 一些 不 為 人 知 的 熱火 秘辛 ， 包括 他 在 季後賽 準決賽 第三 戰 和 教練 Erik Spoelstra 對罵 的 內幕 。 Wade 在 今年 季後賽 面對 溜 馬的 東區 準決賽 第三 戰時 ， 於 比賽 中和 Spoelstra 發生 激烈 衝突 ， 兩 人 在 板凳 席 破口大罵 對方 的 畫面 甚至 透過 電視 轉播 讓 所有 球迷 都 看到 了 ， 對 此 Wade 在 書 中 解釋 了 當時 的 情況 ， 表示 自己 那時 正 飽受 膝傷 折磨 ， 而 Spoelstra 正好 被 他 的 怒火 給 掃 到 。 「 ( Spoelstra ) 可能 想 試 著 讓 我 生氣 ， 因為 我 生氣 的 時候 通常 表現 都 很 好 ";
		//int j = 1;
//		for (String ngram : ngrams(
//				1,
//				"NBAWade 出書 談 爸爸 經 　 澄清 和 教練 爭執 記者 邵瑞峰 綜合 報導 熱火 「 閃電俠 」 Dwyane Wade 近日 推出 了 新書 「 A Father First : How My Life Became Bigger Than Basketball 」 ， 還 特地 送 了 一 本 簽名書 給 好兄弟 「 小 皇帝 」 Lebron James ， Wade 在 書 中 除了 大談 爸爸 經 ， 也 透露 了 一些 不 為 人 知 的 熱火 秘辛 ， 包括 他 在 季後賽 準決賽 第三 戰 和 教練 Erik Spoelstra 對罵 的 內幕 。 Wade 在 今年 季後賽 面對 溜 馬的 東區 準決賽 第三 戰時 ， 於 比賽 中和 Spoelstra 發生 激烈 衝突 ， 兩 人 在 板凳 席 破口大罵 對方 的 畫面 甚至 透過 電視 轉播 讓 所有 球迷 都 看到 了 ， 對 此 Wade 在 書 中 解釋 了 當時 的 情況 ， 表示 自己 那時 正 飽受 膝傷 折磨 ， 而 Spoelstra 正好 被 他 的 怒火 給 掃 到 。 「 ( Spoelstra ) 可能 想 試 著 讓 我 生氣 ， 因為 我 生氣 的 時候 通常 表現 都 很 好 "))
//			map.put(ngram, j);
//		for (Object key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}
		// 讀檔
		// 切 tab => String[] xx
		// str = xx[1];		
		map = n_gram.ngrams(3, str);
	}
}
