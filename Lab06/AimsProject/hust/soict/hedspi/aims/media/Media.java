package hust.soict.hedspi.aims.media;

public class Media {
	
	public Media() {}

	public Media(String title, int id) {
		this.title = title;
		this.id = id;
	}
	
	public Media(String title, String category, int id) {
		this(title,id);
		this.category = category;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public String title;
	public String category;
	public float cost;
	public int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

}
