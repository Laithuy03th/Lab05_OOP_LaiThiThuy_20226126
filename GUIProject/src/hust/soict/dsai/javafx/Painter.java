package hust.soict.dsai.javafx;

package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải giao diện từ file FXML
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/resources/Painter.fxml"));

            // Tạo BorderPane làm root
            BorderPane rootPane = fxmlLoader.load();

            // Tạo Scene và thiết lập Stage
            Scene mainScene = new Scene(rootPane, 900, 700);
            primaryStage.setTitle("Painter - Draw Your Creativity!");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        } catch (Exception ex) {
            System.err.println("Lỗi xảy ra khi khởi chạy ứng dụng: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(); // Gọi phương thức launch() để bắt đầu ứng dụng
    }
}
