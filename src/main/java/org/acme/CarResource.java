package org.acme;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @POST
    @Transactional
    public Car create(final Car car)
    {
        Car newCar = new Car(car.uuid, car.carBrand, car.carModel, car.yearModel);
        newCar.persist();
        return newCar;
    }

    @GET
    public List<Car> list()
    {
        return Car.listAll();
    }

    @PUT
    @Transactional
    public void update( final Car car )
    {
        Car.update(car);
    }

    @DELETE
    @Transactional
    @Path(" {uuid} ")
    public void delete(@PathParam( "uuid" ) final UUID uuid){
        Car.delete("uuid", uuid);
    }
    
}
