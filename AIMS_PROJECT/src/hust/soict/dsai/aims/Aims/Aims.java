package hust.soict.dsai.aims.Aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Aims {

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        // Adding some sample media to the store
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new Book(2, "Effective Java", "Programming", 45.99f, null));
        store.addMedia(
                new CompactDisc(3, "Thriller", "Music", 15.99f, 42, "Quincy Jones", null, "Michael Jackson"));

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // View store
                    store.displayStore();
                    while (true) {
                        storeMenu();
                        int storeChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (storeChoice) {
                            case 1: // See a media's details
                                System.out.print("Enter the title of the media: ");
                                String title = scanner.nextLine();
                                Media media = store.searchByTitle(title);
                                if (media != null) {
                                    System.out.println(media);
                                    while (true) {
                                        mediaDetailsMenu();
                                        int mediaChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline

                                        if (mediaChoice == 1) { // Add to cart
                                            cart.addMedia(media);
                                        } else if (mediaChoice == 2 && (media instanceof DigitalVideoDisc
                                                || media instanceof CompactDisc)) {
                                            media.play();
                                        } else if (mediaChoice == 0) {
                                            break;
                                        } else {
                                            System.out.println("Invalid choice!");
                                        }
                                    }
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;

                            case 2: // Add a media to cart
                                System.out.print("Enter the title of the media: ");
                                title = scanner.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null) {
                                    cart.addMedia(media);
                                } else {
                                    System.out.println("Media not found.");
                                }
                                break;

                            case 3: // Play a media
                                System.out.print("Enter the title of the media: ");
                                title = scanner.nextLine();
                                media = store.searchByTitle(title);
                                if (media != null
                                        && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
                                    media.play();
                                } else {
                                    System.out.println("Invalid media type or not found.");
                                }
                                break;

                            case 4: // See current cart
                                cart.displayCart();
                                break;

                            case 0: // Back
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                        if (storeChoice == 0)
                            break;
                    }
                    break;

                case 2: // Update store
                    System.out.println("1. Add a media\n2. Remove a media");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (updateChoice == 1) {
                        System.out.print("Enter media details (id, title, category, cost): ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        String newTitle = scanner.nextLine();
                        String category = scanner.nextLine();
                        float cost = scanner.nextFloat();

                        store.addMedia(new Media(id, newTitle, category, cost));
                        System.out.println("Media added to the store.");
                    } else if (updateChoice == 2) {
                        System.out.print("Enter the title of the media to remove: ");
                        String removeTitle = scanner.nextLine();
                        store.removeMediaByTitle(removeTitle);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3: // See current cart
                    cart.displayCart();
                    while (true) {
                        cartMenu();
                        int cartChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (cartChoice) {
                            case 1: // Filter medias in cart
                                System.out.println("1. Filter by ID\n2. Filter by title");
                                int filterChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                cart.filterCart(filterChoice);
                                break;

                            case 2: // Sort medias in cart
                                System.out.println("1. Sort by title\n2. Sort by cost");
                                int sortChoice = scanner.nextInt();
                                scanner.nextLine();
                                cart.sortCart(sortChoice);
                                break;

                            case 3: // Remove media from cart
                                System.out.print("Enter the title of the media to remove: ");
                                String removeTitle = scanner.nextLine();
                                cart.removeMediaByTitle(removeTitle);
                                break;

                            case 4: // Play a media
                                System.out.print("Enter the title of the media: ");
                                title = scanner.nextLine();
                                media = cart.searchByTitle(title);
                                if (media != null
                                        && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
                                    media.play();
                                } else {
                                    System.out.println("Invalid media type or not found.");
                                }
                                break;

                            case 5: // Place order
                                System.out.println("Order placed! Your cart is now empty.");
                                cart.clearCart();
                                break;

                            case 0: // Back
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                        if (cartChoice == 0)
                            break;
                    }
                    break;

            }
        }
    }
}