package com.arena.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.arena.entity.Exploration;


@Component
public class ExplorationFactory {
	
	private List<Exploration>  gameExplorations = new ArrayList<>();
	
	
    @PostConstruct
	public void createGameExplorations() {
		
    	Properties p = new Properties();
    	try (InputStream is = getClass().getResourceAsStream("/application.properties")) {
    	    p.load(is);
    	    
    	    gameExplorations  = p.keySet().stream()
    	     .filter(entry ->  ((String)entry).startsWith("GOT"))
    	    .map(entry -> {
    	    	return (new Exploration((String)entry, (String)p.get(entry)));
    	    })
    	    .collect(Collectors.toList());
    	} catch (IOException e) {
			e.printStackTrace();
		}
		
		
      	   
	}

	public  List<Exploration> exploreWesteros() {
		 return this.gameExplorations;
	}

}
