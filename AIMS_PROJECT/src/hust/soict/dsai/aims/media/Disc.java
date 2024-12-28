package hust.soict.dsai.aims.media;

public class Disc extends Media{
//	public Disc(int id, String title, String category, float cost) {
//		super(id, title, category, cost);
//		// TODO Auto-generated constructor stub
//	}
	private int length;
	private String director;
	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
	
}