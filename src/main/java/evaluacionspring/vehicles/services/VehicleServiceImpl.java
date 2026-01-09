package evaluacionspring.vehicles.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import evaluacionspring.vehicles.dtos.CreateVehicleDto;
import evaluacionspring.vehicles.dtos.VehicleResponseDto;
import evaluacionspring.vehicles.entites.VehicleEntity;
import evaluacionspring.vehicles.mappers.VehicleMappers;
import evaluacionspring.vehicles.models.Vehicle;
import evaluacionspring.vehicles.repositories.VehicleRepository;



@Service
public class VehicleServiceImpl implements VehicleService {
    
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

@Override
    public List<VehicleResponseDto> findAll() {

        // Lista final que se devolverá al controlador
        List<VehicleResponseDto> response = new ArrayList<>();

        // 1. Obtener todas las entidades desde la base de datos
        List<VehicleEntity> entities = vehicleRepository.findAll();

        // 2. Iterar sobre cada entidad
        for (VehicleEntity entity : entities) {

            // 3. Convertir la entidad en modelo de dominio
            Vehicle vehicle = Vehicle.fromEntity(entity);

            // 4. Convertir el modelo de dominio en DTO de respuesta
            VehicleResponseDto dto = VehicleMappers.toVehicleResponseDto(vehicle);

            // 5. Agregar el DTO a la lista de resultados
            response.add(dto);
        }

        // 6. Retornar la lista final de DTOs
        return response;
    }

    @Override
    public VehicleResponseDto findByModel(String model) {
        return vehicleRepository.findByModel((String) model)
                .map(Vehicle::fromEntity)
                .map(VehicleMappers::toVehicleResponseDto)
                .orElseThrow(() -> new Error("Vehiculo con modelo: " + model + " no encontrado"));
    }

    @Override
    public VehicleResponseDto create(CreateVehicleDto dto) {
        // Validar que el email no exista ya ANTES de intentar insertar
        if (vehicleRepository.findByModel(dto.model).isPresent()) {
            throw new Error("El modelo '" + dto.model + "' ya está registrado");
        }
        
        return Optional.of(dto)
                .map(VehicleMappers::fromCreateDto)
                .map(Vehicle::toEntity)
                .map(vehicleRepository::save)
                .map(Vehicle::fromEntity)
                .map(VehicleMappers::toVehicleResponseDto)
                .orElseThrow(() -> new Error("Error al crear el vehiculo" + dto));
    }



 
   @Override
    public void delete(String model) {
          // Verifica existencia y elimina
        vehicleRepository.findByModel(model)
        .ifPresentOrElse(
            vehicleRepository::delete,
            () -> {
                throw new Error("Vehiculo con modelo: " + model + " no encontrado");
            }
        );
    }




}
