package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private final Store store;

    public StoreScreen(Store store) {
        this.store = store;

        // Thiết lập JFrame
        setTitle("AIMS Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setLayout(new BorderLayout());

        // Thêm các thành phần vào JFrame
        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    // Tạo khu vực phía trên (North)
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        // Thêm menu bar và tiêu đề
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo MenuBar
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EmptyBorder(5, 5, 5, 5));

        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        menuBar.add(menu);
        return menuBar;
    }

    // Tạo tiêu đề
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(120, 50));
        cartButton.setMaximumSize(new Dimension(120, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Tạo khu vực trung tâm (Center)
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10));
        center.setBorder(new EmptyBorder(10, 10, 10, 10));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            Media media = mediaInStore.get(i);
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        // Ví dụ khởi chạy
        Store store = new Store(); // Giả định Store đã được khởi tạo và có dữ liệu
        new StoreScreen(store);
    }
}

// Lớp MediaStore để hiển thị từng sản phẩm
class MediaStore extends JPanel {
    private final Media media;

    public MediaStore(Media media) {
        this.media = media;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("$" + media.getCost());
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        JButton addToCartButton = new JButton("Add to Cart");
        buttonPanel.add(addToCartButton);

        if (media instanceof hust.soict.dsai.aims.media.Playable) {
            JButton playButton = new JButton("Play");
            buttonPanel.add(playButton);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(buttonPanel);
        add(Box.createVerticalGlue());
    }
}
