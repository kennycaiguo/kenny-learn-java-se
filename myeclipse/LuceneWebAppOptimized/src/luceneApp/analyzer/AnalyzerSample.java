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
		System.out.println("��ǰʹ�õķִ����ǣ�" + analyzer.getClass());
		TokenStream tokenstream=analyzer.tokenStream("content", new StringReader(text));
		tokenstream.addAttribute(TermAttribute.class);
		while(tokenstream.incrementToken()) {
			TermAttribute termAttribute=tokenstream.getAttribute(TermAttribute.class);
			System.out.println(termAttribute.term());
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String text="���ǲ���˵���ǵ��׶��Ǳ���ѽI Am zhoujun it";
		   //�����lucene���õķִ�����������it������ʣ���ɾ���ˣ�
		//testAnalyer(new StandardAnalyzer(LuceneUtil.getVersion()),text);
		//����Ƿ����ִ��������Խ���it
		//testAnalyer(new FrenchAnalyzer(LuceneUtil.getVersion()),text);
		//���Ƕ���˹�ִ�������װ�ո����ִ�
		//testAnalyer(new RussianAnalyzer(LuceneUtil.getVersion()),text);
		//�����й��ķִ�����ע���й��ִ����Ĺ��췽������������I ��it�������ͣ���ɾ���ˣ�
		//testAnalyer(new ChineseAnalyzer(),text);
		//������CJK�ִ���������������Ϊ��λ
		//testAnalyer(new CJKAnalyzer(LuceneUtil.getVersion()),text);
		//IKAnalyzer
		testAnalyer(new IKAnalyzer(),text);
	}

}
