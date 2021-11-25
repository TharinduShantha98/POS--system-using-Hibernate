package controller;

import bo.BOFactory;
import bo.custom.AdminHomeBo;
import bo.custom.Impl.AdminHomeBOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemDetailChart;
import views.TM.TodayOrderTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdministratorHomeFormController {

    public Label lblDate;
    public Label lblTime;
    public Label lblSetTotalProfit;
    public Label lblDailyProfit;
    public Label lblMostProfitItemProfit;
    public Label lblMostItemCode;
    public Label lblMostProfitQty;
    public TableView tblTodayOrder;
    public TableColumn colOrderId;
    public TableColumn colFullDiscount;
    public TableColumn colTotalQty;
    public TableColumn colProfit;
    public LineChart<String,Number> tblSaleItemTable;


    private final AdminHomeBo adminHomeBo = (AdminHomeBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN_HOME);


    public void initialize(){
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colFullDiscount.setCellValueFactory(new PropertyValueFactory<>("totalDiscount"));
        colTotalQty.setCellValueFactory(new PropertyValueFactory<>("TotalQty"));
        colProfit.setCellValueFactory(new PropertyValueFactory<>("TotalProfit"));




        setTimeAndDate();

        try {
            setTotalProfit();
            setDailyProfit();
           // setLblMostProfitItemProfit();
            setTableTodayOrderDetail();
            setChart();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private  void setTimeAndDate(){
        new DateAndTime().setTimeAndData(lblDate,lblTime);

    }

    private  void setTotalProfit() throws SQLException, ClassNotFoundException {
        int total = adminHomeBo.setTotalProfit();
        lblSetTotalProfit.setText(String.valueOf(total));
    }


    private void setDailyProfit() throws SQLException, ClassNotFoundException {
        int dailyProfit = adminHomeBo.setTodayProfit(lblDate.getText());
        lblDailyProfit.setText(String.valueOf(dailyProfit));

    }

    private  void setLblMostProfitItemProfit() throws SQLException, ClassNotFoundException {
        ArrayList<String> arrayList = adminHomeBo.setMostProfitItem();
        lblMostItemCode.setText(arrayList.get(0));
        lblMostProfitQty.setText(arrayList.get(1));
        lblMostProfitItemProfit.setText(arrayList.get(2));

    }

    private  void setTableTodayOrderDetail() throws SQLException, ClassNotFoundException {
        ObservableList<TodayOrderTM> observableList = FXCollections.observableArrayList();
        for (TodayOrderTM temp: adminHomeBo.setTableTodayOrder(lblDate.getText())) {
            observableList.add(temp);
        }
        tblTodayOrder.setItems(observableList);

    }


    private void setChart() throws SQLException, ClassNotFoundException {
        XYChart.Series<String,Number> set1 = new XYChart.Series<>();
        ArrayList<ItemDetailChart> temp = adminHomeBo.setItemDetailChart(lblDate.getText());
        for(int i=0; i < temp.size(); i++){
            set1.getData().add(new XYChart.Data<>(temp.get(i).getItemCode(),temp.get(i).getTotalQty()));
        }
        tblSaleItemTable.getData().addAll(set1);

    }









}
