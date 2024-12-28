package hust.soict.dsai.javafx;

package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    private Canvas canvas; // Canvas để vẽ
    private GraphicsContext gc; // Context để thao tác trên Canvas

    @FXML
    public void initialize() {
        // Tạo một canvas và thêm vào Pane
        canvas = new Canvas(drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        gc = canvas.getGraphicsContext2D();

        // Đặt nền mặc định
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawingAreaPane.getChildren().add(canvas);

        // Xử lý khi kích thước Pane thay đổi
        drawingAreaPane.widthProperty().addListener((obs, oldVal, newVal) -> resizeCanvas());
        drawingAreaPane.heightProperty().addListener((obs, oldVal, newVal) -> resizeCanvas());
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ nội dung canvas
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Vẽ khi kéo chuột
        double x = event.getX();
        double y = event.getY();

        gc.setFill(Color.BLACK); // Màu vẽ
        gc.fillOval(x - 2, y - 2, 4, 4); // Vẽ một điểm nhỏ tại vị trí chuột
    }

    private void resizeCanvas() {
        // Đảm bảo Canvas thay đổi kích thước khi Pane thay đổi
        double newWidth = drawingAreaPane.getWidth();
        double newHeight = drawingAreaPane.getHeight();

        Canvas newCanvas = new Canvas(newWidth, newHeight);
        GraphicsContext newGc = newCanvas.getGraphicsContext2D();

        // Sao chép nội dung cũ
        newGc.drawImage(canvas.snapshot(null, null), 0, 0);

        // Thay thế canvas cũ bằng canvas mới
        drawingAreaPane.getChildren().remove(canvas);
        canvas = newCanvas;
        gc = newGc;
        drawingAreaPane.getChildren().add(canvas);
    }
}
