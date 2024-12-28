package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Media media;

    public MediaStore(Media media) {
        this.media = media;

        // Sử dụng GridBagLayout để bố trí giao diện
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tiêu đề sản phẩm
        JLabel titleLabel = new JLabel(media.getTitle(), JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Chiếm 2 cột
        add(titleLabel, gbc);

        // Giá sản phẩm
        JLabel costLabel = new JLabel("Price: $" + media.getCost(), JLabel.CENTER);
        costLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        add(costLabel, gbc);

        // Nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addToCartButton = new JButton("Add to Cart");
        buttonPanel.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            buttonPanel.add(playButton);
        }

        gbc.gridy = 2;
        gbc.gridwidth = 2; // Chiếm 2 cột
        add(buttonPanel, gbc);

        // Thêm viền cho JPanel
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
    }
}

