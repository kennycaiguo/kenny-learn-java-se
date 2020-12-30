package enhancedforloop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/*
 * 增强for循环，可以遍历所有实现了Iterable<T>接口 的类如set，list，数组等等
 * 还可以使用可变参数
 这里演示了使用map实现类
 * 
 * */
public class EnhancedForDemo2 {
	public static void main(String[] args) {
		//Map<E>接口实现类也可以使用增强for
      HashMap<String,String> map=new HashMap<String, String>();
        map.put("001", "pussy"); 
        map.put("002", "vagina");
        map.put("003", "outter lips");
        map.put("004", "inner lips");
        map.put("005", "clitoris");
        
        for(Entry e : map.entrySet()) {
        	   System.out.println("key:" + e.getKey()+",value:"+e.getValue());
        }
  
	}
  
}
