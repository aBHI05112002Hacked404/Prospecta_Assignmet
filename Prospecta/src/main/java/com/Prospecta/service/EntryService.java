package com.Prospecta.service;

import java.util.List;

import com.Prospecta.model.Entry;
import com.Prospecta.model.EntryDto;

public interface EntryService {

	   public List<EntryDto> getEntryByCategory(String category);

	   public Entry saveEntry();
	
}
