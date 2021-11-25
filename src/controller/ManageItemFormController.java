package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class ManageItemFormController {

    public void initialize(){
        try {
            gotoPage("../views/addItemsForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public AnchorPane context3;


    public void addItemsOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/addItemsForm.fxml");

    }

    public void searchItemsOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/SearchItemForm.fxml");
    }

    public void updateItemsOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/UpdateItemForm.fxml");
    }

    public void removeItemsOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/RemoveItemForm.fxml");
    }

    public void allItemsOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/AllItemForm.fxml");
    }


    private  void gotoPage(String location ) throws IOException {
        URL resource = getClass().getResource(location);
        Parent Load = FXMLLoader.load(resource);
        context3.getChildren().clear();
        context3.getChildren().add(Load);

    }




}
