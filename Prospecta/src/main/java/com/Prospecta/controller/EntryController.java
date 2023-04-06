package com.Prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Prospecta.model.Entry;
import com.Prospecta.model.EntryDto;
import com.Prospecta.service.EntryService;

@RestController
public class EntryController {

	 @Autowired
	    private EntryService entryService;

	    @PostMapping("/entries")
	    public ResponseEntity<Entry> saveEntryHandler(){
	           Entry en = entryService.saveEntry();
	        return new ResponseEntity<>(en, HttpStatus.OK);
	    }

	    @GetMapping("/entries/{category}")
	    public ResponseEntity<List<EntryDto>> findEntryByCategoryHandler(@PathVariable("category") String category){
	        List<EntryDto> list= entryService.getEntryByCategory(category);
	        return new ResponseEntity<>(list,HttpStatus.OK);
	    }
}
