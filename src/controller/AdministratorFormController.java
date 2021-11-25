package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdministratorFormController {


    public JFXButton btnHome;
    public AnchorPane homeLoad;
    public JFXButton btnLogOut;
    public void initialize(){
        try {
            goToPage("../views/AdministratorHomeForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void goToHomeOnAction(ActionEvent actionEvent) throws IOException {
        goToPage("../views/AdministratorHomeForm.fxml");

    }


    public void addManageItemsOnAction(ActionEvent actionEvent) throws IOException {
        goToPage("../views/ManageItemForm.fxml");

    }


    private  void goToPage(String location) throws IOException {
        URL resource = getClass().getResource(location);
        Parent Load = FXMLLoader.load(resource);
        homeLoad.getChildren().clear();
        homeLoad.getChildren().add(Load);

    }

    public void gotoDashBordOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) btnLogOut.getScene().getWindow();
        stage1.close();


        URL resource  = getClass().getResource("../views/DashBordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("DashBord Form");
        stage.show();

    }

    public void mostMovableItem(ActionEvent actionEvent) throws IOException {
        goToPage("../views/MostMovableForm.fxml");
    }

    public void incomeReportOnAction(ActionEvent actionEvent) throws IOException {
        goToPage("../views/IncomeReportForm.fxml");

    }

    public void lessMovableItemsOnAction(ActionEvent actionEvent) throws IOException {
        goToPage("../views/lessMovableItems.fxml");
    }

    public void SettingOnAction(ActionEvent actionEvent) throws IOException {
        goToPage("../views/UserAccountForm.fxml");


    }

    public void goToHome(ActionEvent actionEvent) throws IOException {
        goToPage("../views/AdministratorHomeForm.fxml");
    }
}
