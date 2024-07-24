package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class TicketService {

    @Autowired
    TicketDAL ticketDAL;

    @Transactional
    public Ticket getTicketById(Long id) {
        Ticket ticket = ticketDAL.getTicketById(id);

        if(ticket == null){
            throw new NotFoundException("No Ticket found with id:  "+id);
        }

        return ticket;
    }

    @Transactional
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = ticketDAL.getAllTickets();

        if(tickets == null){
            throw new NotFoundException("No tickets found ");
        }

        return tickets;
    }

    @Transactional
    public List<Ticket> getAllTicketsByAge(Long age) {
        List<Ticket> tickets = ticketDAL.getAllTicketsByAge(age);

        if(tickets == null){
            throw new NotFoundException("No tickets found with this age: " + age);
        }

        return tickets;
    }
}
