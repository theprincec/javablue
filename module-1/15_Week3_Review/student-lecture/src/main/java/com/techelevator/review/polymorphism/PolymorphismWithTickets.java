package com.techelevator.review.polymorphism;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.review.abstrract.RegularTicketAbstractExample;
import com.techelevator.review.abstrract.TicketAbstractExample;
import com.techelevator.review.abstrract.VipTicketAbstractExample;
import com.techelevator.review.abstrract.WillCallTicketAbstractExample;
import com.techelevator.review.interfaces.tickets.RegularTicketWithInterface;
import com.techelevator.review.interfaces.tickets.TicketInterface;
import com.techelevator.review.interfaces.tickets.VipTicketWithInterface;
import com.techelevator.review.interfaces.tickets.WillCallTicketWithInterface;
import com.techelevator.review.superclass.Ticket;
import com.techelevator.review.superclass.VipTicket;
import com.techelevator.review.superclass.WillCallTicket;

public class PolymorphismWithTickets {

	public static void main(String[] args) {
		new PolymorphismWithTickets().printTickets();
	}
	
	public void printTickets() {
		/* 
		 * Polymorphism using Superclass
		 */
		printTicketsFromSuperclass();
		
		/* 
		 * Polymorphism using Abstract Class
		 */
		printTicketsFromAbstract();
		
		/* 
		 * Polymorphism using Interface
		 */
		printTicketsFromInterface();
	}
	
	
	private void printTicketsFromSuperclass() {
		
		List<Ticket> superclassTickets = new ArrayList<Ticket>();
		
		superclassTickets.add(new Ticket(55.50, "Regular Ticket"));
		superclassTickets.add(new VipTicket(60, 15.50));
		superclassTickets.add(new WillCallTicket(76.25, "John Fulton"));
		
		
		System.out.println();
		System.out.println("Polymorphism with Superclasses");
		System.out.println("----------------------------------------------------");
		for(Ticket ticket : superclassTickets) {
			System.out.printf("%-20s Cost $%4.2f  Fees %4.2f  Total %4.2f%n" ,
					ticket.getType(), ticket.getPrice(), ticket.getFee(), ticket.getTotalPrice() );
		}
	
	}
	
	private void printTicketsFromAbstract() {
		
		List<TicketAbstractExample> abstractTickets = new ArrayList<TicketAbstractExample>();
		abstractTickets.add(new RegularTicketAbstractExample(55.50));
		abstractTickets.add(new VipTicketAbstractExample(60, 15.50));
		abstractTickets.add(new WillCallTicketAbstractExample(76.25, "John Fulton"));
		
		System.out.println();
		System.out.println("Polymorphism with Abstract");
		System.out.println("----------------------------------------------------");
		for(TicketAbstractExample ticket : abstractTickets) {
			System.out.printf("%-20s Cost $%4.2f  Fees %4.2f  Total %4.2f%n" ,
					ticket.getType(), ticket.getPrice(), ticket.getFee(), ticket.getTotalPrice() );
		}
	
	}
	
	private void printTicketsFromInterface() {
		
		List<TicketInterface> interfaceTickets = new ArrayList<TicketInterface>();
		interfaceTickets.add(new RegularTicketWithInterface(55.50));
		interfaceTickets.add(new VipTicketWithInterface(60, 15.50));
		interfaceTickets.add(new WillCallTicketWithInterface(76.25, "John Fulton"));
		
		System.out.println();
		System.out.println("Polymorphism with Interface");
		System.out.println("----------------------------------------------------");
		
		for(TicketInterface ticket : interfaceTickets) {
			System.out.printf("%-20s Cost $%4.2f  Fees %4.2f  Total %4.2f%n" ,
					ticket.getType(), ticket.getPrice(), ticket.getFee(), ticket.getTotalPrice() );
		}
	
	}
	
}
