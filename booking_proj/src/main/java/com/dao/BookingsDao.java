package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.dto.BusDto;
import com.models.Bookings;
import com.dto.BookingsDto;
import com.models.Bus;
import com.models.Passenger;

@Repository
public class BookingsDao {
	SessionFactory factory=null;
	 Session session = null;
	 Transaction tx = null;
	 BusDto bd= new BusDto();
	 BookingsDao(){
		 
		 try{
			 factory = new Configuration().configure().addAnnotatedClass(Bookings.class).buildSessionFactory();
	        }
	        catch (Throwable throwable){
	            System.out.println("Error");
	            throw new ExceptionInInitializerError(throwable);
	        }
	 }
	 //exporting Dto.
	 public BookingsDto exportDto (Bookings book) {
		 BookingsDto bkdto=new BookingsDto();
		 bkdto.setBookid(book.getBookid());	
		 bkdto.setPid(book.getPassenger().getPid());
		 bkdto.setBid(book.getBus().getBid());
		 bkdto.setTravel_date(book.getTravel_date());
		 bkdto.setSeat_num(book.getSeat_num());
		 return bkdto;
			
		}
	 //importing Dto.
	 public Bookings importDto (BookingsDto bkdto) {
		 Bookings book= new Bookings();
		 book.setBookid(bkdto.getBookid());
		 book.setPassenger(session.get(Passenger.class, bkdto.getPid()));
		 book.setBus(session.get(Bus.class, bkdto.getBid()));
		 book.setTravel_date(bkdto.getTravel_date());
		 book.setSeat_num(bkdto.getSeat_num());
		 return book;
	 }
	 
	 
	 public List<BookingsDto> selectOp() {
		 
	 	 session = factory.openSession();
        tx = session.beginTransaction();
        String hql="from com.models.Bookings";
        List<Bookings> bookings = session.createQuery(hql).list();
        List<BookingsDto> bookingsdtolist = new ArrayList<>();
        for(Bookings b: bookings) {
        	bookingsdtolist.add(exportDto(b));
        	
        }
        tx.commit();
        session.close();
        System.out.println("succsess");
        return bookingsdtolist;  	
  
  }
	 //Selection by id.
	 public BookingsDto selectBooking(int bookid) {
		 session = factory.openSession();
        tx = session.beginTransaction();
        Bookings b=session.get(Bookings.class, bookid);
        tx.commit();
        session.close();
        System.out.println("succsess");
        return exportDto(b);
        
	 }
	 //Booking history by passenger id.
	public List<BookingsDto> selectBookHistory(int pid) {
		
		 session = factory.openSession();
        tx = session.beginTransaction();
        
        Passenger pass=session.get(Passenger.class,pid);
        
        Criteria crit = session.createCriteria(Bookings.class);
        crit.add(Restrictions.eq("passenger",pass));
        List<Bookings> results = crit.list();
        List<BookingsDto> bookingsdtolist = new ArrayList<>();
        for(Bookings b: results) {
        	bookingsdtolist.add(exportDto(b));
        	
        }
        tx.commit();
        session.close();
        System.out.println("succsess");
        return bookingsdtolist;
	}

	// Book bus  ticket
	public int bookTicket(int bookid, int pid, int bid, String travel_date, int seat_num) {
		
		
       
       BusDao b=new BusDao();
       int seatleft=b.seatAvailability(bid, travel_date);
       
       if(seatleft>0) {
       	session = factory.openSession();
           tx = session.beginTransaction();
           Passenger p =session.get(Passenger.class, pid);
           Bus bus = session.get(Bus.class, bid);
           
           if(bd.getTotal_seats()<seat_num) {
        	   System.out.println(bd.getTotal_seats()+"d");
           	return -1;
           }
           
           Criteria crit = session.createCriteria(Bookings.class);
           crit.add(Restrictions.eq("travel_date",travel_date));
           crit.add(Restrictions.eq("bus",bus));
           List<Bookings> tickets = crit.list();
           
           for(int i=0;i<tickets.size();i++) {
           	Bookings book=tickets.get(i);
           	if(book.getSeat_num()==seat_num) {
           		return -2;
           	}
           }
           
           BookingsDto ticket = new BookingsDto(bookid,p.getPid(),bus.getBid(),travel_date,seat_num);
           session.save(importDto(ticket));
           
           tx.commit();
           session.close();
           System.out.println("succsess");
           return 1;
       	
       }
       else
       	return 0;
       
       
       
	}



}
