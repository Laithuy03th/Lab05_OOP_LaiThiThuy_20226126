package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class Cart {
	
	 // Tối đa số lượng mục trong giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Danh sách các mục trong giỏ hàng
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Thêm một mục Media vào giỏ hàng
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more items.");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("The media item is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The media item has been added.");
        }
    }

    // Xóa một mục Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media item has been removed.");
        } else {
            System.out.println("The media item was not found in the cart.");
        }
    }

    // Tính tổng chi phí của các mục trong giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Hiển thị chi tiết giỏ hàng
    public void displayCart() {
        System.out.println("--- CART DETAILS ---");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$\n");
    }

    // Phương thức main để kiểm tra
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo các mục Media
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        Book book = new Book(2, "Effective Java", "Programming", 45.99f, new ArrayList<>());
        CompactDisc cd = new CompactDisc(3, "Thriller", "Music", 15.99f, 42, "Quincy Jones", new ArrayList<>(), "Michael Jackson");

        // Thêm các mục vào giỏ hàng
        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        // Hiển thị giỏ hàng
        cart.displayCart();

        // Xóa một mục và hiển thị lại giỏ hàng
        cart.removeMedia(book);
        cart.displayCart();
    }

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Object getItemsOrdered() {
		// TODO Auto-generated method stub
		return null;
	}
  
}