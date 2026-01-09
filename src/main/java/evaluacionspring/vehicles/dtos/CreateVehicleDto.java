package evaluacionspring.vehicles.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateVehicleDto {
    

    @NotBlank(message = "Brand es obligatorio")
    @Size(min = 1, message = "Brand no puede estar vacio")
    public String brand;

    @NotBlank(message = "Model es obligatorio")
    @Size(min = 1, message = "Model no puede estar vacio")
    public String model;

    @Min(value = 0, message = "Price debe ser mayor o igual a 0")
    public BigDecimal price;

    @Min(value = 0, message = "Stock debe ser mayor o igual a 0")
    public Integer stock;

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

    
}
