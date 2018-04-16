package testfxexample;

import static org.testfx.api.FxAssert.*;
import static org.testfx.matcher.control.LabeledMatchers.*;
import static org.junit.Assert.*;

import static org.testfx.assertions.api.Assertions.assertThat;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.robot.Motion;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import org.junit.Test;

public class ClickApplicationTest extends ApplicationTest {
    
    @Override
    public void start(Stage stage) {
        System.out.println("start is called");
        Parent sceneRoot = new ClickApplication.ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }
    
    @Test
    public void should_contain_button() {
        // expect:
        verifyThat(".button", hasText("click me!"));
    }
    
    @Test
    public void should_click_on_button() {
        // when:
        clickOn(".button", Motion.DIRECT);
        
        // then:
        verifyThat(".button", hasText("clicked!"));
    }
    
    /** 
     * The following tests are alternative ways to do the matching. 
     * They would allow an IDE to offer suggestions and let the compiler 
     * detect problems at compile time. 
     */
    
    @Test 
    public void should_contain_button_with_assertj() {
       assertThat(lookup(".button").queryAs(Button.class)).hasText("click me!"); 
    }
    
    @Test 
    public void should_do_click_on_button_with_assertj() {
       clickOn(".button", Motion.DIRECT); 
       assertThat(lookup(".button").queryAs(Button.class)).hasText("clicked!"); 
    }
    
    @Test 
    public void should_do_click_on_button_with_assertj_alternative_version() {  
        clickOn(".button", Motion.DIRECT);
        assertThat(lookup(".button").queryButton()).hasText("clicked!");
    }
}
