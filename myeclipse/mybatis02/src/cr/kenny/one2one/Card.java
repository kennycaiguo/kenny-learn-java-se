package cr.kenny.one2one;

public class Card {
    private Integer id;
    private String num;
    
    public Card(){}

	public Card(Integer id, String num) {
		 
		this.id = id;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", num=" + num + "]";
	}
    
}
