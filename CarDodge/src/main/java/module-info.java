
module CarDodge.fxcore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    opens CarDodge.fxcore to javafx.fxml;
    exports CarDodge.fxcore;
}
