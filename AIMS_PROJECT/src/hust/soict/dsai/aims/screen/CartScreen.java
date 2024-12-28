package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private final Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        // Cấu hình JFrame
        setTitle("Cart Management");
        setPreferredSize(new Dimension(1024, 768));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo JFXPanel để tích hợp JavaFX vào Swing
        JFXPanel fxPanel = createFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        // Hiển thị JFrame
        pack();
        setLocationRelativeTo(null); // Căn giữa cửa sổ
        setVisible(true);

        // Khởi chạy JavaFX trên JFXPanel
        initJavaFX(fxPanel);
    }

    private JFXPanel createFXPanel() {
        // Tạo và trả về JFXPanel
        JFXPanel fxPanel = new JFXPanel();
        JLabel loadingLabel = new JLabel("Loading cart screen...", JLabel.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loadingLabel.setForeground(Color.GRAY);
        add(loadingLabel, BorderLayout.SOUTH); // Thêm thông báo loading tạm thời
        return fxPanel;
    }

    private void initJavaFX(JFXPanel fxPanel) {
        Platform.runLater(() -> {
            try {
                // Tải FXML và gắn Controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                loader.setControllerFactory(param -> new CartScreenController(cart)); // Sử dụng Factory để khởi tạo Controller
                Parent root = loader.load();

                // Thiết lập Scene cho JFXPanel
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);

                // Xóa thông báo "loading" sau khi tải xong
                SwingUtilities.invokeLater(() -> remove(1)); // Xóa loadingLabel (phần tử thứ 2 trong JFrame)
            } catch (IOException e) {
                showError(e.getMessage());
            }
        });
    }

    private void showError(String message) {
        // Hiển thị lỗi bằng JOptionPane
        JOptionPane.showMessageDialog(this,
                "Unable to load Cart screen: " + message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Khởi động JavaFX và tạo màn hình giỏ hàng
        SwingUtilities.invokeLater(() -> new CartScreen(new Cart()));
    }
}

