package GUIs;

import coursetab.coursestab;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import profiletab.profilestab;

/**
 *
 * @author Michelle Marie Garcia
 * 
 * This class creates a tab pane with four tabs in total. The first tab holds the 
 * previous chat project which will be usable by all connected users. The second 
 * tab holds the previous project on sorting profiles. The third tab holds classes 
 * entered and sorts them as well. The fourth and final tab holds a simple about 
 * page about the application. Each tab has an icon beside its title with the
 * exception of the about tab.
 */
public class chatstab {
    private TabPane tabPane = new TabPane();
    private Image img0 = new Image("imgs/note.png");
    private Image img1 = new Image("imgs/open.gif");
    private Image img2 = new Image("imgs/save.gif");
    private Image img3 = new Image("imgs/login.jpg");
    
    public chatstab(){
        tabPane.setStyle("-fx-background-color: cornsilk;");
        
	Tab tab0 = new Tab("Chat");
        tab0.idProperty().set("Chat");
        tab0.setClosable(false);
        tab0.setGraphic(new ImageView(img0));
        tab0.setStyle("-fx-border-color: navy; -fx-background-color: bisque;");
        tab0.setContent(new mainChatGUI());
        
        Tab tab1 = new Tab("Profiles");
        tab1.idProperty().set("Profiles");
        tab1.setClosable(false);
        tab1.setGraphic(new ImageView(img1));
        tab1.setStyle("-fx-border-color: navy; -fx-background-color: bisque;");
        tab1.setContent(new profilestab());
        
        Tab tab2 = new Tab("Courses");
        tab2.idProperty().set("Courses");
        tab2.setClosable(false);
        tab2.setGraphic(new ImageView(img2));
        tab2.setStyle("-fx-border-color: navy; -fx-background-color: bisque;");
        tab2.setContent(new coursestab());
        
        Tab tab3 = new Tab("About");
        tab3.setClosable(false);
        tab3.setStyle("-fx-border-color: navy; -fx-background-color: bisque;");
        
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load(getClass().getResource("/aboutHTML/aboutstab.html").toString());
        tab3.setContent(browser);
        
        tabPane.getTabs().addAll(tab1, tab2, tab0, tab3);
    }

    /**
     * @return the tabPane
     */
    public TabPane getTabPane() {
        return tabPane;
    }

    /**
     * @param tabPane the tabPane to set
     */
    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }
}