package com.Prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Prospecta.exception.EntryException;
import com.Prospecta.model.AllEntryDTO;
import com.Prospecta.model.Entry;
import com.Prospecta.model.EntryDto;
import com.Prospecta.repository.EntryRepo;

@Service
public class EntryServiceImpl  implements EntryService{

	 @Autowired
	    private EntryRepo entryRepo;

	    @Autowired
	    private RestTemplate  restTemp;
	    @Override
	    public List<EntryDto> getEntryByCategory(String category) {
	      //  String str = "https://api.publicapis.org/entries";

	        ResponseEntity<AllEntryDTO> responseEntity = restTemp.getForEntity("https://api.publicapis.org/entries", AllEntryDTO.class);

	        System.out.println(responseEntity.getBody().getEntries());
	        List<EntryDto> list = new ArrayList<>();

	        for(Entry e: responseEntity.getBody().getEntries()){
	            if(category.equals(e.getCategory())){
	                list.add(new EntryDto(e.getTitle(),e.getDescription()));
	            }
	            System.out.println(list);
	        }

	        if(list.size()==0)
	            throw new EntryException("No Entry found with category : "+category);

	        return list;

	    }

	    @Override
	    public Entry saveEntry() {
	       // String str = "https://api.publicapis.org/random";

	        ResponseEntity<AllEntryDTO> responseEntity = restTemp.getForEntity("https://api.publicapis.org/random", AllEntryDTO.class);

	        Entry entry = responseEntity.getBody().getEntries().get(0);

	        return entryRepo.save(entry);
	    }

}
