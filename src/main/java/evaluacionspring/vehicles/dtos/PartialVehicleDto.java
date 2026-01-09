package evaluacionspring.vehicles.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PartialVehicleDto {
    
    @NotBlank
    @Size
    public String brand;

    @NotBlank
    @Size
    public String model;

    @Min(value = 0)
    public BigDecimal price;

    @Min(value = 0)
    public Integer stock;


}
