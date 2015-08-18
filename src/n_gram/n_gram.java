package n_gram;
import java.io.*;
import java.util.*;

public class n_gram {

    public static HashMap<String,Integer> ngrams(int n, String str) {
        HashMap<String,Integer> ngrams = new HashMap<String,Integer>();
        String[] words = str.split(" ");
        for (int i=0;i<words.length-n+1;i++)
        {
            String ngram=concat(words,i,i+n);
        	if(!ngrams.containsKey(ngram))
        			{
        			ngrams.put(ngram,0);
        			}
        	ngrams.put(ngram,ngrams.get(ngram)+1);
        }
        return ngrams;
    }

    public static String concat(String[] words,int start,int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }
    public static void main(String[] argv) throws IOException
    {
    		HashMap map;
    		FileInputStream fr=new FileInputStream("D:\\Akai Wang\\Seg_TestingData.txt");
    		BufferedReader br=new BufferedReader(new InputStreamReader(fr,"UTF-8"));
    		StringBuffer sb = new StringBuffer();
    		String strNum = br.readLine();
    		while ((strNum=br.readLine())!=null)
    		{
    			sb.append(strNum);
      			String str=br.readLine();
      			map=n_gram.ngrams(2, str);
    		}
    		FileOutputStream fileStream = new FileOutputStream(new File("D:\\Akai Wang\\2_gram"));
    		OutputStreamWriter writer = new OutputStreamWriter(fileStream, "UTF-8");
    		
    }
}
     
