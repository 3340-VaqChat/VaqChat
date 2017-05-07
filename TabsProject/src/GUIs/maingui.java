package GUIs;

import javafx.scene.Parent;

/**
 * This class contains one field named chatTabs that is a ChatTabs object. This 
 * ChatTabs object holds a new ChatTabs object when the default constructor is
 * called. The final method in this class returns a tab pane.
 * @author Michelle Marie Garcia
 * 
 * 
 */
public class maingui {
    chatstab chatTabs;
    
    public maingui(){
        chatTabs = new chatstab();
    }
    
    public Parent getRootNode(){
        return chatTabs.getTabPane();
    }
}