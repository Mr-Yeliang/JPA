package com.example.demo.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.domain.UserInfo;

@Service
public class UserService {
	@Inject
	EntityManager em;
	
	
	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	@Transactional
	public void persist(User user) {
		em.persist(user);
	}

	/**
	 * 根据主键查询用户
	 * 
	 * @param user
	 */
	@Transactional
	public User find(String id) {
		User user = em.find(User.class, id);
		return user;
	}

	/**
	 * 根据主键修改用户信息
	 * 
	 * @param user
	 */
	@Transactional
	public User merge(String id,String name) {
		User user = find(id);
		if (null!=user) {
			user.setName(name);
			em.merge(user);
		}
		return user;
	}

	/**
	 * 根据主键删除用户
	 * 
	 * @param user
	 */
	@Transactional
	public void remove(String id) {
		User user = find(id);
		em.remove(user);
	}

	
	/**
	 * 分页
	 * @param page
	 * @return
	 */
	@Transactional
	public List<User> page(int page) {
		List<User> list=em.createQuery("Select u from User u").setFirstResult((page-1)*5).setMaxResults(5).getResultList();
		return list;
	}
	
	
	@Transactional
	public List<UserInfo> sel(int page) {
		List<UserInfo> list=em.createQuery("Select u from User u").setFirstResult((page-1)*5).setMaxResults(5).getResultList();
		return list;
	}
//	
//	@Transactional
//	public List<User> sel(int page) {
//		List<User> list=em.createQuery("Select u from User u").setFirstResult((page-1)*5).setMaxResults(5).getResultList();
//		return list;
//	}
//	
//	@Transactional
//	public List<User> sel(int page) {
//		List<User> list=em.createQuery("Select u from User u").setFirstResult((page-1)*5).setMaxResults(5).getResultList();
//		return list;
//	}
	
}
