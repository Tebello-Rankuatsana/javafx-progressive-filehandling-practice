module ranks.javafxmidtermpaperpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens ranks.javafxmidtermpaperpractice to javafx.fxml;
    exports ranks.javafxmidtermpaperpractice;
}