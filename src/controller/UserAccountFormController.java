package controller;

import bo.BOFactory;
import bo.custom.Impl.UserAccountBOImpl;

import bo.custom.UserAccountBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.UserAccountDTO;

import java.sql.SQLException;

public class UserAccountFormController {


    public JFXTextField txtEmployId;
    public JFXTextField txtEmployNAme;
    public JFXTextField txtAddress;
    public JFXTextField txtPassWord;
    public TableColumn colEmployId;
    public TableColumn colEmployName;
    public TableColumn colTitle;
    public TableColumn colEmployAddress;
    public TableColumn colPassword;
    public JFXComboBox cmbTitle;
    public TableView<UserAccountDTO> tblEmploy;
    String tittle;
    String employId;

    UserAccountBO userAccountBO = (UserAccountBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER_ACCOUNT);



    public void initialize(){
        colEmployId.setCellValueFactory(new PropertyValueFactory<>("EmployId"));
        colEmployName.setCellValueFactory(new PropertyValueFactory<>("EmployName"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("EmployTittle"));
        colEmployAddress.setCellValueFactory(new PropertyValueFactory<>("EmployAddress"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("EmployPassword"));





        setTitle();

        cmbTitle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tittle = (String) newValue;

        });

        try {
            setTableEmployData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


        tblEmploy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                if(newValue.getEmployId().equalsIgnoreCase(null)){

                }else{
                    employId = newValue.getEmployId();
                }

            }catch (Exception e){

            }

        });

    }



    public void setTitle(){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("cashier");
        observableList.add("Admin");

        cmbTitle.setItems(observableList);


    }








    public void AddCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        UserAccountDTO userAccount = new UserAccountDTO(txtEmployId.getText(),
                txtEmployNAme.getText(),
                tittle,
                txtAddress.getText(),
                txtPassWord.getText());

        if(userAccountBO.EmployAdd(userAccount)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            setTableEmployData();
        }else{
            new Alert(Alert.AlertType.WARNING,"failed").show();
        }





    }

    public void SelectOnAction(ActionEvent actionEvent) {

    }

    public void deleteEmployOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(userAccountBO.EmployDelete(employId)){

            new Alert(Alert.AlertType.CONFIRMATION,"SuccessFull").show();
           setTableEmployData();
        }else{

            new Alert(Alert.AlertType.WARNING,"try Again").show();
        }


    }

    public void setTableEmployData() throws SQLException, ClassNotFoundException {
        ObservableList<UserAccountDTO> customers = FXCollections.observableArrayList();
        for (UserAccountDTO c1 : userAccountBO.getAllEmploy()
        ) {
            UserAccountDTO tm = new UserAccountDTO(c1.getEmployId(),c1.getEmployName(), c1.getEmployTittle(),
                    c1.getEmployAddress(), c1.getEmployPassword());

            customers.add(tm);

        }
        tblEmploy.setItems(customers);


    }



}
