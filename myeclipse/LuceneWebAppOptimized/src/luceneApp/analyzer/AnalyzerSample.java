package luceneApp.analyzer;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.fr.FrenchAnalyzer;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import luceneApp.util.LuceneUtil;

public class AnalyzerSample {

	public AnalyzerSample() {
		// TODO Auto-generated constructor stub
	}

	public static void testAnalyer(Analyzer analyzer,String text) throws Exception{
		System.out.println("当前使用的分词器是：" + analyzer.getClass());
		TokenStream tokenstream=analyzer.tokenStream("content", new StringReader(text));
		tokenstream.addAttribute(TermAttribute.class);
		while(tokenstream.incrementToken()) {
			TermAttribute termAttribute=tokenstream.getAttribute(TermAttribute.class);
			System.out.println(termAttribute.term());
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String text="传智播客说我们的首都是北京呀I Am zhoujun it";
		   //这个是lucene内置的分词器，不解析it这个单词（被删除了）
		//testAnalyer(new StandardAnalyzer(LuceneUtil.getVersion()),text);
		//这个是法国分词器，可以解释it
		//testAnalyer(new FrenchAnalyzer(LuceneUtil.getVersion()),text);
		//这是俄罗斯分词器，安装空格来分词
		//testAnalyer(new RussianAnalyzer(LuceneUtil.getVersion()),text);
		//这是中国的分词器，注意中国分词器的构造方法不带参数，I 和it均不解释（被删除了）
		//testAnalyer(new ChineseAnalyzer(),text);
		//以下是CJK分词器，以两个汉字为单位
		//testAnalyer(new CJKAnalyzer(LuceneUtil.getVersion()),text);
		//IKAnalyzer
		testAnalyer(new IKAnalyzer(),text);
	}

}
