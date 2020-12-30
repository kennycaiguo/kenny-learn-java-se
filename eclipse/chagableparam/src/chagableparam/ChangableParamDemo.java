package chagableparam;

public class ChangableParamDemo {
    public static void main(String[] args) {
		//ShowAny("pussy"); //沒有輸出
    	ShowAny("vagina", 0,0,0);
	}
    
    public static void ShowAny(String words,int...ints) {
    	for(int i : ints) {
    		System.out.println(words + ":"+i);
    	}
    }
}
