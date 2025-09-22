package com.example.Proyecto.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Entity.Menu;

@Repository("menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Serializable> {

	public List<Menu> findByIdMenu(Integer IdMenu);
}
