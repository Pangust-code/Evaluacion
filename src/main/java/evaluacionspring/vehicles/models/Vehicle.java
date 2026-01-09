package evaluacionspring.vehicles.models;

import java.math.BigDecimal;

import evaluacionspring.vehicles.entites.VehicleEntity;

public class Vehicle {
    private long id;
    private String brand;
    private String model;
    private BigDecimal price;
    private Integer stock;
    
    private String deleted;

 
    public Vehicle() {
    }

    public Vehicle(long id, String brand, String model, BigDecimal price, Integer stock, String deleted  ) {

        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        }

        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío");
        }

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser nulo o negativo");
        }

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.deleted = deleted;
    }

    public Vehicle(long id, String brand, String model, Integer stock, String deleted  ) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.stock = stock;
        this.deleted = deleted;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDelete() {
        return deleted;
    }

    public void setDelete(String deleted) {
        this.deleted = deleted;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public static Vehicle fromEntity(VehicleEntity entity) {
        Vehicle vehicle = new Vehicle(entity.getId(), entity.getBrand(), entity.getModel(), entity.getPrice(), entity.getStock(), entity.getDeleted());
        vehicle.setId(entity.getId());
        vehicle.setBrand(entity.getBrand());
        vehicle.setModel(entity.getModel());
        vehicle.setPrice(entity.getPrice());
        vehicle.setStock(entity.getStock());
        vehicle.setDeleted(entity.getDeleted());
        return vehicle;
    }

    public VehicleEntity toEntity() {
        VehicleEntity entity = new VehicleEntity();
        if (this.id > 0) {
            entity.setId((long) this.id);
        }

       
        entity.setBrand(this.brand);
        entity.setModel(this.model);
        entity.setPrice(this.price);
        entity.setStock(this.stock);
        entity.setDeleted(this.deleted);
        return entity;
    }
        // Preservar fechas si existen (para actualizaciones)

}