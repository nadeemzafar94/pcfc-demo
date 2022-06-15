package com.pcfc.hibernate.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pcfc.hibernate.model.Employee;

/**
 * Create Date : 2022-06-14
 * @author Nadeem
 *
 */
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
    @SuppressWarnings("unchecked")
	@Override
    public List < Employee > getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Employee > cq = cb.createQuery(Employee.class);
        Root < Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveEmployee(Employee emp) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(emp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getEmployee(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee employee = currentSession.get(Employee.class, theId);
        return employee;
    }

}
