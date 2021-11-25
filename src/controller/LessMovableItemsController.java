package controller;

import bo.BOFactory;
import bo.custom.Impl.LessMovableBOImpl;
import bo.custom.LessMovableBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import views.TM.MovableTM;
import java.sql.SQLException;

public class LessMovableItemsController {

    LessMovableBO lessMovableBO = (LessMovableBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LESS_MOVABLE_ITEM);


    public TableView tblLessMovable;
    public TableColumn colItemCode;
    public TableColumn colOrderCount;
    public TableColumn colLessQty;
    public PieChart pieChartLessMovable;
    public void initialize(){
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderCount.setCellValueFactory(new PropertyValueFactory<>("orderCount"));
        colLessQty.setCellValueFactory(new PropertyValueFactory<>("MovableQty"));



        try {
            setTblMostMovable();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        setPieChartLessMovable();

    }




    ObservableList<MovableTM> movableTMObservableList = FXCollections.observableArrayList();
    public  void setTblMostMovable() throws SQLException, ClassNotFoundException {

        for (MovableTM temp: lessMovableBO.setLessMovableItem()
        ) {
            movableTMObservableList.add(temp);
        }
        tblLessMovable.setItems(movableTMObservableList);
    }




    public void setPieChartLessMovable(){

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();

        for(MovableTM temp: movableTMObservableList){

                observableList.add(new PieChart.Data(temp.getItemCode(),temp.getMovableQty()));

        }

        pieChartLessMovable.setData(observableList);


    }


}
