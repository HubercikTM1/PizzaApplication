package pl.hubert.pizzaapplication.remote.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrdersStatusDto {

    private OrdersStatusDto status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expectedAt;

    public OrdersStatusDto() {
    }

    public OrdersStatusDto(OrdersStatusDto status, Date createdAt, Date updatedAt, Date expectedAt) {
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expectedAt = expectedAt;
    }

    public OrdersStatusDto getStatus() {
        return status;
    }

    public void setStatus(OrdersStatusDto status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getExpectedAt() {
        return expectedAt;
    }

    public void setExpectedAt(Date expectedAt) {
        this.expectedAt = expectedAt;
    }

}
