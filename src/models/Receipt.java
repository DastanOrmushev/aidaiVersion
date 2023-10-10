package models;

import java.util.Date;

public class Receipt {
    private Long id;
    private Double sum;
    private Employee employee;
    private Date addDate;

    public Receipt(Long id, Double sum, Employee employee, Date addDate) {
        this.id = id;
        this.sum = sum;
        this.employee = employee;
        this.addDate = addDate;
    }

    public Receipt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", sum=" + sum +
                ", employee=" + employee +
                ", addDate=" + addDate +
                '}';
    }
}
