package com.melhamra.repository;

import com.melhamra.model.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaptopRepository {

    @Autowired
    public SessionFactory sessionFactory;

    public void saveLaptop(Laptop laptop){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(laptop);
        session.getTransaction().commit();
        session.close();
    }
    
    public Laptop getLaptopByID(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Laptop laptop = session.get(Laptop.class, id);
        session.getTransaction().commit();
        session.close();
        return laptop;
    }
    
    public List<Laptop> getAllLaptops(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Laptop");
        List<Laptop> laptopList = query.list();
        session.getTransaction().commit();
        session.close();
        return laptopList;
    }

    public void deleteLaptop(Laptop laptop){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(laptop);
        session.getTransaction().commit();
        session.close();
    }

    public void updateLaptop(Laptop laptop){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(laptop);
        session.getTransaction().commit();
        session.close();
    }

}
