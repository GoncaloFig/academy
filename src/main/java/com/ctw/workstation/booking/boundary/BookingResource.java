package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingRepository;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDto;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/booking")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingRepository bookingRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> getAll(){
        return bookingRepository.listAll();
    }

    @POST
    @Transactional
    public Response add(BookingDto bookingDto){
        Booking booking = new Booking();
        booking.setRackId(bookingDto.rackId());
        booking.setRequesterId(bookingDto.requesterId());
        booking.setBookFrom(bookingDto.bookFrom());
        booking.setBookTo(bookingDto.bookTo());
        booking.setCreatedAt(bookingDto.createdAt());
        booking.setModifiedAt(bookingDto.modifiedAt());
        bookingRepository.persist(booking);
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }
}
