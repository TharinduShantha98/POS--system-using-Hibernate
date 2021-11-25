package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class CustomerDetailFormController {

    public AnchorPane context1;
    public AnchorPane context2;


    public void initialize() throws IOException {
        gotoPage("../views/addCustomerForm.fxml");

    }



    public void AddCustomerOnAction(ActionEvent actionEvent) {
        try {
            gotoPage("../views/addCustomerForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void updateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/UpdateCustomerForm.fxml");
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/SearchCustomerFrom.fxml");
    }

    public void removeCustomerOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/RemoveCustomerForm.fxml");
    }

    public void allCustomerOnAction(ActionEvent actionEvent) throws IOException {
        gotoPage("../views/AllCustomerForm.fxml");
    }


    private  void gotoPage(String location ) throws IOException {
        URL resource = getClass().getResource(location);
        Parent Load = FXMLLoader.load(resource);
        context2.getChildren().clear();
        context2.getChildren().add(Load);

    }
}
