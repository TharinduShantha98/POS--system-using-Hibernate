package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.Impl.CustomerBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddCustomerFormController {


    public JFXTextField txtCustomerTittle;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCustomerCity;
    public JFXTextField txtPostalCode;
    public JFXComboBox cmbProvince;
    public JFXButton btnAddCustomer;

    private  String selectProvince;

    ArrayList<String> province = new ArrayList<>();

    private CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);



    public  void initialize(){
    setProvince();
        try {
            setCustomerId();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }


    private void setProvince(){
        province.add("Western");
        province.add("Northern");
        province.add("North Central");
        province.add("Eastern");
        province.add("North Western");
        province.add("Central");
        province.add("Uwa");
        province.add("Sabaragamuwa");
        province.add("Southern");

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(int i =0; i< province.size();i++){
            observableList.add(province.get(i));
        }
        cmbProvince.setItems(observableList);

        cmbProvince.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectProvince= (String) newValue;

        });


    }

    public void setCustomerId() throws SQLException, ClassNotFoundException {
        txtCustomerId.setText(customerBO.createCustomerId());


    }






    public void addCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerDTO customer = new CustomerDTO(
                txtCustomerId.getText(),
                txtCustomerTittle.getText(),
                txtCustomerName.getText(),
                txtCustomerAddress.getText(),
                txtCustomerCity.getText(),
                selectProvince,
                txtPostalCode.getText());
        if(customerBO.customerAdd(customer)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved Customer").show();
            setCustomerId();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try again ").show();
        }


    }





}
