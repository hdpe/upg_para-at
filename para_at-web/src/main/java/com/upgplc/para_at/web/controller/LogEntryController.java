package com.upgplc.para_at.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgplc.para_at.client.model.GetLogEntriesResult;
import com.upgplc.para_at.client.model.GetLogEntriesResultEntry;
import com.upgplc.para_at.web.model.Journey;
import com.upgplc.para_at.web.repository.JourneysRepository;

import static java.util.stream.Collectors.toList;

@RestController
public class LogEntryController {

	@Autowired
	private JourneysRepository journeysRepository;
	
	@RequestMapping("/logEntries")
	public GetLogEntriesResult getLogEntries(long taxiId) {
		return new GetLogEntriesResult(journeysRepository.findByTaxiId(taxiId).stream()
			.map(j -> toDto(j)).collect(toList()));
	}

	private static GetLogEntriesResultEntry toDto(Journey journey) {
		return new GetLogEntriesResultEntry(journey.getTaxi().getRegistration(), journey.getLength());
	}
}
