package testfxexample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ClickApplication extends Application {
    
    @Override public void start(Stage stage) {
        Parent sceneRoot = new ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }
    
    // scene object for unit tests
    public static class ClickPane extends StackPane {
        public ClickPane() {
            super();
            final Button button = new Button("click me!");
            button.setId("exampleButton");
            
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    button.setText("clicked!");
                }
            });
            getChildren().add(button);
        }
    }
}
