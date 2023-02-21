package org.acme;
import java.util.Optional;
import java.util.UUID;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;

@Entity
public class Car extends PanacheEntity {
    
    @NotNull
    public UUID uuid;
    public String carBrand;
    public String carModel;
    public Integer yearModel;

    public Car() {
    }

    public Car(UUID uuid, String carBrand, String carModel, Integer yearModel) {
        this.uuid = uuid;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearModel = yearModel;
    }

    public Car(String carBrand, String carModel, Integer yearModel) {
        this(UUID.randomUUID(), carBrand, carModel, yearModel);
    }

    @JsonbCreator
    public static Car of(String carBrand, String carModel, Integer yearModel) {
        return new Car(carBrand, carModel, yearModel);
    }

    @Transactional
    @Consumes
    public static void update(final Car car) {
        Optional<Car> previous = Car.findByIdOptional( car.uuid );
            previous.ifPresent((update) -> {
                update.uuid = car.uuid;
                update.carBrand = car.carBrand;
                update.carModel = car.carModel;
                update.yearModel = car.yearModel;
                update.persist();
            });
        }

    public String getCarBrand() {
        return this.carBrand;
    }
    

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }


    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getYearModel() {
        return this.yearModel;
    }

    public void setYearModel(Integer yearModel) {
        this.yearModel = yearModel;
    }
}
