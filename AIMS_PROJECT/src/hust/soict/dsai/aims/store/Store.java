package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public Store() {
        // Default constructor
    }

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The item is already in the store: " + media.getTitle());
        } else {
            itemsInStore.add(media);
            System.out.println("Item added to store: " + media.getTitle());
        }
    }

    // Method to remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Item removed from store: " + media.getTitle());
        } else {
            System.out.println("Item not found in store: " + media.getTitle());
        }
    }

    // Method to print the contents of the store
    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.getTitle() + " - "
                        + media.getCategory() + " - " + media.getCost() + " $");
            }
        }
        System.out.println("***************************************************");
    }

    // Main method to test the Store class
    public static void main(String[] args) {
        Store store = new Store();

        // Test items
        Media dvd = new DigitalVideoDisc(1, "Inception", "Sci-fi", 19.99f, 148, "Christopher Nolan");
        Media book = new Book(2, "1984", "Dystopian", 9.99f, null);
        Media cd = new CompactDisc(3, "The Beatles", "Music", 14.99f, 0, null, null, "John Lennon");

        // Add items to the store
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        // Print store contents
        store.printStore();

        // Remove an item and print store again
        store.removeMedia(dvd);
        store.printStore();
    }
}