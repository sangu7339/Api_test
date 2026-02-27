package com.BCC.Crickers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	MyService myService;
	
	@PostMapping("/player")
	public ResponseEntity<Object>saveplayer(@RequestBody Player player){
		return myService.saveplayer(player);
	}
	@GetMapping("/player/{id}")
	public ResponseEntity<Object>fetchById(@PathVariable int id){
		return myService.fetchById(id);
	}
	
	@DeleteMapping("/player/{id}")
	public ResponseEntity<Object>deletebyid(@PathVariable int id){
		return myService.deletebyid(id);
	}
	
	@PutMapping("/player/{id}")
	public ResponseEntity<Object>Update(@RequestBody  Player player){
		return myService.update(player);
		
	}

	  @GetMapping("/test")
    public String test() {
        return "Spring Boot Test Successful 🚀";
    }


}
