package sample.Controller;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

/*
* Class controls which screen is currently being accessed by storing
* all scenes in a hashmap, declaring 'key' = String 'scene name'
* and 'Pane' = 'layout'
 */

public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    //Controller that declares current scene
    public ScreenController(Scene main) {
        this.main = main;
    }

    //Add the screens to an empty pane in the steps between removing
    // old scene and posting the new scene
    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    // Removes the old scene to make room for new scene
    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    //Draws the new screen on the window
    protected void activate(String name){
        main.setRoot(screenMap.get(name));
    }
}
