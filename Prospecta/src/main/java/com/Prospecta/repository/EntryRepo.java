package com.Prospecta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prospecta.model.Entry;
import com.Prospecta.model.EntryDto;

public interface EntryRepo extends JpaRepository<Entry,Integer>{

	public List<EntryDto> findByCategory(String category);

	
}
