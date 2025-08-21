package com.BCC.Crickers;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Autowired
	MyRespository respository;
	public ResponseEntity<Object> saveplayer(Player player) {
		respository.save(player);
		Map<String, Object>map=new HashMap<String, Object>();
			map.put("Message", "data store successefully");
//			map.put("data", map);
		
		return new ResponseEntity<Object> (map, HttpStatus.CREATED);
	}
	public ResponseEntity<Object> fetchById(int id) {
		Optional<Player>optional=respository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("Msg", "Player Details not fond");
			return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
		}else {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("msg", optional.get());
			return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
		}
		
	}
	public ResponseEntity<Object> deletebyid(int id) {
		Optional<Player>optional=respository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("message", "player id not exists");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
		 respository.deleteById(id);
		 Map<String, Object>map=new HashMap<String, Object>();
			map.put("message", "player Details Delete Successfully");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
		
	}
	public ResponseEntity<Object> update(Player player) {
		respository.save(player);
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("message", "Player Details Update Successfully");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	



}
