package evaluacionspring.vehicles.entites;

import java.math.BigDecimal;

import evaluacionspring.core.entities.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class VehicleEntity extends BaseModel{

    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "brand", nullable = false, unique = true, length = 50)
    private String brand;

    @Column(name = "model", nullable = false, length = 150)
    private String model;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "deleted", nullable = false, length = 1  )
    private String deleted;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getDeleted() {
        return deleted;
    }
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
