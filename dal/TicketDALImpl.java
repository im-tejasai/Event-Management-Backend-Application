package com.cn.cnEvent.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;

@Repository
public class TicketDALImpl implements TicketDAL{

    @Autowired
    EntityManager entityManager;

    @Override
    public Ticket getTicketById(Long id) {
       Session session = entityManager.unwrap(Session.class);
       Ticket ticket = session.get(Ticket.class, id);
       return ticket;
    }

    @Override
    public List<Ticket> getAllTickets() {
        Session session = entityManager.unwrap(Session.class);

        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).getResultList();

        return tickets;
    }

    @Override
    public List<Ticket> getAllTicketsByAge(Long age) {
        List<Ticket> allTickets = getAllTickets();

        List<Ticket> TicketsByAge = new ArrayList<>();
        try {
            for (Ticket ticket : allTickets) {
                if (ticket.getPerson().getAge() < age) {
                    TicketsByAge.add(ticket);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException("Tickets of this age is not present");
        }
        return TicketsByAge;
    }
}
