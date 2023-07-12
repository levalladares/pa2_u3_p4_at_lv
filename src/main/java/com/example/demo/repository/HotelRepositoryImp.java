package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImp implements HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// select * from hotel h join habitacion ha on h.htl_id = ha.habi_id_hotel
		// SELECT h from Hotel h JOIN h.habitaciones ha 
		String jpql ="SELECT h FROM Hotel h JOIN h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterRigthJoin() {
		// TODO Auto-generated method stub
		String jpql ="SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha";
        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
	}
	
	public List<Hotel> seleccionarOuterLeftJoin() {
		// TODO Auto-generated method stub
		String jpql ="SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha";
        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
	}
	
	public List<Habitacion> seleccionarHabitacionesOuterLeftJoin() {
		// TODO Auto-generated method stub
		String jpql ="SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha";
        TypedQuery <Habitacion> myQuery  = this.entityManager.createQuery(jpql,Habitacion.class);
        return myQuery.getResultList();
	}
	
	public List<Hotel> seleccionarOuterFullJoin() {
		// TODO Auto-generated method stub
		String jpql ="SELECT h FROM Hotel h FULL JOIN h.habitaciones ha";
        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// Select h.* From hotel h, habitacion ha WHERE h.htl1_id=ha.habi_id_hotel 
		// SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel 
		String jpql ="SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel";
        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);
		return myQuery.getResultList();
	}

	

}
