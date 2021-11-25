package controller;


import bo.BOFactory;
import bo.custom.Impl.MonthlyIncomeBOImpl;
import bo.custom.MonthlyBO;
import com.jfoenix.controls.JFXComboBox;
import dao.custom.Impl.QueryDaoImpl;
import dao.custom.QueryDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import views.TM.IncomeTM;

import java.sql.SQLException;

public class MonthlyIncomeFormController {


    public TableColumn colItemCode;
    public TableColumn colSalesQty;
    public TableColumn colItemProfit;
    public JFXComboBox<String> cmbSelectMonth;
    public TableView tblMonth;
    public LineChart chartMonth;
    public CategoryAxis x;
    public NumberAxis y;

    String month;

    MonthlyBO monthlyBO = (MonthlyBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MONTHLY_INCOME);

    public void initialize(){
            setCmbSelectMonth();

            colItemProfit.setCellValueFactory(new PropertyValueFactory<>("itemProfit"));
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colSalesQty.setCellValueFactory(new PropertyValueFactory<>("saleItemQty"));



            cmbSelectMonth.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                month = newValue;
                try {
                    setMonthTable();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                setProfitChart();
            });

    }

    private  void setCmbSelectMonth(){
        ObservableList<String>  month = FXCollections.observableArrayList();
        for(int i = 1; i < 13;i++){
            month.add(String.valueOf(i));

        }

        cmbSelectMonth.setItems(month);

    }

    ObservableList<IncomeTM> tmObservableList = FXCollections.observableArrayList();
    public void setMonthTable() throws SQLException, ClassNotFoundException {


        for (IncomeTM temp :monthlyBO.getMonthProfit(month)
             ) {
             tmObservableList.add(temp);
        }
        tblMonth.setItems(tmObservableList);

    }

    private void setProfitChart(){
        XYChart.Series<String,Number> set1 = new XYChart.Series<>();
        set1.setName("Profit");

        for(int i=0; i < tmObservableList.size(); i++){
            set1.getData().add(new XYChart.Data<>(tmObservableList.get(i).getItemCode(),tmObservableList.get(i).getItemProfit()));

        }

        XYChart.Series<String,Number> set2 = new XYChart.Series<>();
        set1.setName("sales QTY");

        for(int i=0; i < tmObservableList.size(); i++){
            set2.getData().add(new XYChart.Data<>(tmObservableList.get(i).getItemCode(),tmObservableList.get(i).getSaleItemQty()));

        }
        chartMonth.getData().addAll(set1, set2);




    }




}
