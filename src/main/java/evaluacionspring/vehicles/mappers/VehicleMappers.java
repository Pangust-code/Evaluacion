package evaluacionspring.vehicles.mappers;

import evaluacionspring.vehicles.dtos.VehicleResponseDto;
import evaluacionspring.vehicles.models.Vehicle;

public class VehicleMappers {

    public static VehicleResponseDto toVehicleResponseDto(Vehicle vehicle) {
        VehicleResponseDto dto = new VehicleResponseDto();
        // Map fields from Vehicle entity to VehicleResponseDto
        dto.id = vehicle.getId();
        dto.brand = vehicle.getBrand();
        dto.model = vehicle.getModel();
        dto.price = vehicle.getPrice();
        dto.stock = vehicle.getStock();
        return dto;
    }

    public static Vehicle toVehicleEntity(VehicleResponseDto dto) {
        Vehicle vehicle = new Vehicle();
        // Map fields from VehicleResponseDto to Vehicle entity
        vehicle.setId(dto.id);
        vehicle.setBrand(dto.brand);
        vehicle.setModel(dto.model);
        vehicle.setPrice(dto.price);
        vehicle.setStock(dto.stock);
        return vehicle;
    }

    public static Vehicle fromCreateDto(evaluacionspring.vehicles.dtos.CreateVehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setPrice(dto.getPrice());
        vehicle.setStock(dto.getStock());
        return vehicle;
    }

    
}
