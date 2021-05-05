package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Media>{

	@Override
	public boolean equals(Object obj) {
		Media m = (Media) obj;
		if (m instanceof Media) {
			if (m.getId() == this.getId()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Media obj) {
		Media media = (Media) obj;
		if (media instanceof Media) {
			if(media.title.compareTo(this.title) > 0) {
				return -1;
			}else if (media.title.compareTo(this.title) < 0) {
				return 1;
			}else {
				return 0;
			}
		}else {
			new Exception("Error!!!");
			return 1000;
		}
	}

	public Media() {
	}

	public Media(String title, int id) {
		this.title = title;
		this.id = id;
	}

	public Media(String title, String category, int id) {
		this(title, id);
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

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

}
