package hust.soict.dsai.aims.media;

import java.util.Objects;

public abstract class Media {
	
	 protected int id;
	    protected String title;
	    protected String category;
	    protected float cost;

	    public Media(int id, String title, String category, float cost) {
	        super();
	        this.id = id;
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public float getCost() {
	        return cost;
	    }

	    public void setCost(float cost) {
	        this.cost = cost;
	    }

		@Override
		public int hashCode() {
			return Objects.hash(category, cost, id, title);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Media other = (Media) obj;
			return Objects.equals(category, other.category)
					&& Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost) && id == other.id
					&& Objects.equals(title, other.title);
		}
	    
	}