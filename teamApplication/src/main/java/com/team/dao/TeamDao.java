package com.team.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team.domain.Team;

@Repository
//@Transactional
public class TeamDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional(rollbackFor=RuntimeException.class, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void createUpdate(Team team){
		getSession().saveOrUpdate(team);
		getSession().flush();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)	
	public Team loadTeam(long id){
		Team team = (Team)getSession().load(Team.class, id);
		return team;		
	}
	
	public List<Team>getAllTeams(){
		Criteria criteria = getSession().createCriteria(Team.class);
		List<Team>teams = criteria.list();
		return teams;		
	}

	@Transactional(rollbackFor=RuntimeException.class, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void delete(Long id){
		Team team = loadTeam(id);
		getSession().delete(team);
		getSession().flush();
	}

	@Transactional(rollbackFor=RuntimeException.class, isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void updateAndDelete(Team t){
		createUpdate(t);
		delete(t.getId());
	}
	
}
