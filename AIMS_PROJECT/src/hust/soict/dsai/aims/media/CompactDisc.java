package hust.soict.dsai.aims.media;
import java.util.List;

import java.util.Scanner;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable  {

//	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
//		super(id, title, category, cost, length, director);
//		// TODO Auto-generated constructor stub
//		
//	}
	

	
	private List<Track> tracks = new ArrayList<>();
	private String artist;

	
	public CompactDisc(int id, String title, String category, float cost, int length, String director,
			List<Track> tracks, String artist) {
		super(id, title, category, cost, length, director);
		this.tracks = tracks;
		this.artist = artist;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}else {
			System.out.println("Track " + track.getTitle() + "is in the list");
			
		}
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		}else {
			System.out.println("Track " + track.getTitle() + "isn't in the list");
		}
	}
	
	public int getLength() {
	    int totalLength = 0;
	    for (Track track : tracks) {
	        totalLength += track.getLength();
	    }
	    return totalLength;
	}

	 public String toString() {
	        return "CompactDisc ID: " + getId() + "\nTitle: " + getTitle() + "\nCategory: " + getCategory() +
	               "\nCost: " + getCost() + "\nDirector: " + getDirector() + "\nArtist: " + artist +
	               "\nTotal Length: " + getLength() + " minutes" + "\nTracks: " + tracks;
	    }
	@Override
	public void play() {
		// TODO Auto-generated method stub
		  System.out.println("Playing CompactDisc: " + this.getTitle());
	        System.out.println("Artist: " + this.artist);
	        for (Track track : tracks) {
	            track.play(); 
	        }
	}
	
	public static void main(String[] args) {
		 List<Track> trackList = new ArrayList<>();
	        trackList.add(new Track("Track 1", 5));
	        trackList.add(new Track("Track 2", 4));
	        trackList.add(new Track("Track 3", 3));

	        // Tạo một CompactDisc
	        CompactDisc cd = new CompactDisc(1, "Hits Album", "Music", 20.0f, 0, "John Doe", trackList, "Imagine Dragons");

	        // Tạo một DigitalVideoDisc
	        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Action Movie", "Action", 15.0f, 120, "Jane Smith");

	        // Gọi phương thức play() của CompactDisc
	        cd.play();

	        // Gọi phương thức play() của DigitalVideoDisc
	        dvd.play();
	}
}