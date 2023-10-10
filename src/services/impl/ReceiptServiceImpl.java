package services.impl;

import models.Receipt;
import services.DbHelper;
import services.EmployeeService;
import services.ReceiptService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReceiptServiceImpl implements ReceiptService {

    DbHelper dbHelper = new DbHelperImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public Receipt save (Receipt receipt) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbHelper.getStatement("insert into tb_receipt(sum,empl_id,date) values (?,?,?)");
            preparedStatement.setDouble(1,receipt.getSum());
            preparedStatement.setLong(2,receipt.getEmployee().getId());
           // preparedStatement.setString(3,new java.util.Date().toString());
            LocalDate localDate = LocalDate.now();
            preparedStatement.setDate
                    (3, new Date(localDate.getYear(),localDate.getMonthValue(), localDate.getDayOfMonth()));

            return findLast();
        } catch (SQLException e){
            throw new RuntimeException("Ошибка при сохранение чека "+e.getMessage());

        }
    }
    @Override
    public Receipt findById(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbHelper.getStatement("select * tb_receipt where id=?");
            preparedStatement.setDouble(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Receipt receipt = new Receipt();
            while (resultSet.next()){
                receipt.setId(resultSet.getLong("id"));
                receipt.setSum(resultSet.getDouble("sum"));
                receipt.setEmployee(employeeService.findById(resultSet.getLong("empl_id")));
                receipt.setAddDate(resultSet.getDate("date"));
            }
            return receipt;

        } catch (SQLException e){
            throw  new RuntimeException(e);

        }
    }
    @Override
    public Receipt findLast() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbHelper.getStatement
                    ("select * from tb_receipt where id= (select max (id) from tb_receipt)");

            ResultSet resultSet = preparedStatement.executeQuery();
            Receipt receipt = new Receipt();
            while (resultSet.next()){
                receipt.setId(resultSet.getLong("id"));
                receipt.setSum(resultSet.getDouble("sum"));
                receipt.setEmployee(employeeService.findById(resultSet.getLong("empl_id")));
                receipt.setAddDate(resultSet.getDate("date"));
            }
            return receipt;


        } catch (SQLException e){
            throw  new RuntimeException(e);

        }
    }
}
