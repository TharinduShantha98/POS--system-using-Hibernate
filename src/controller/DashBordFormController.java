package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class DashBordFormController {

    public static Stage stage;
    public JFXButton btnAdminLogin;
    public AnchorPane context;
    public Label lblUseName;

    public void initialize(){


        lblUseName.setText(LoginFormController.userName);
        try {
            setStage("../views/CustomerOrderForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void adminLoginOnAction(ActionEvent actionEvent) {

        try {
            setWindows("../views/AdminLoginForm.fxml" , "Admin login form");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void setWindows(String location ,String title ) throws IOException {
       /* Stage stage1 = (Stage) btnAdminLogin.getScene().getWindow();
        stage1.close();*/
        stage = (Stage) btnAdminLogin.getScene().getWindow();

        URL resource  = getClass().getResource(location);
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();

    }

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setStage("../views/CustomerDetailForm.fxml");

    }

    public void goToCustomerOrder(ActionEvent actionEvent) throws IOException {
        setStage("../views/CustomerOrderForm.fxml");
    }


    public void setStage(String location) throws IOException {
        URL resource = getClass().getResource(location);
        Parent Load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(Load);
    }

    public void goToManageOrderONAction(ActionEvent actionEvent) throws IOException {
        setStage("../views/OrderManageForm.fxml");
    }
}
