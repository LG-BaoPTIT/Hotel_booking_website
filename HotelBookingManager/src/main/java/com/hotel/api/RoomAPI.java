package com.hotel.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import com.hotel.dto.RoomDTO;
import com.hotel.entities.RoomEntity;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;

@RestController("/")
@Controller
public class RoomAPI {
	@Autowired
	RoomService roomService;
	private static final String UPLOAD_DIR = "src/main/resources/static/img/";
	@GetMapping(value = "/api/rooms")
	public List<RoomDTO> getAllRoom(){
		List<RoomDTO> result = new ArrayList<>();
		List<RoomEntity> entities = roomService.findAll();
		for(RoomEntity entity : entities) {
			result.add(roomService.toDTO(entity));
		}
		return result;
	}
	
  @PostMapping("/api/rooms")
  public ResponseEntity<?> addRoom(@RequestParam("image") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("rate") Long rate,
			@RequestParam("price") BigDecimal price,
			@RequestParam("status") Long status) throws IOException, URISyntaxException {
      try {
          byte[] bytes = file.getBytes();
          Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
          Path path2 = Paths.get(file.getOriginalFilename());
          Files.write(path, bytes);
			RoomEntity room = new RoomEntity();
			RoomDTO roomDTO = new RoomDTO();
			roomDTO.setName(name);
			roomDTO.setDescription(description);
			roomDTO.setRate(rate);
			roomDTO.setPrice(price);
			roomDTO.setStatus(status);
			
			roomDTO.setImgLink("\\img\\" + path2.toString());
			room=roomService.save(roomService.toEntity(roomDTO));

          return ResponseEntity.ok(room);
      } catch(RuntimeException ex) {
			System.out.println("false");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
  }
//	@PostMapping("/api/rooms")
//	public ResponseEntity<RoomEntity> addRoom(
//			@RequestParam("image") MultipartFile file,
//			@RequestParam("name") String name,
//			@RequestParam("description") String description,
//			@RequestParam("rate") Long rate,
//			@RequestParam("price") BigDecimal price,
//			@RequestParam("status") Long status
//			
//			) throws IOException{
//		
//		
//		try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
//            Files.write(path, bytes);
//            
//			RoomEntity room = new RoomEntity();
//			RoomDTO roomDTO = new RoomDTO();
//			roomDTO.setName(name);
//			roomDTO.setDescription(description);
//			roomDTO.setRate(rate);
//			roomDTO.setPrice(price);
//			roomDTO.setStatus(status);
//			roomDTO.setImgLink(path.toString());
//			room = roomService.save(roomService.toEntity(roomDTO));
//			System.out.println(roomDTO.toString());
//			return ResponseEntity.ok(room);
//		}catch(RuntimeException ex) {
//			System.out.println("false");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
//		
//	}
	
	@PutMapping(value = "/api/rooms/update")
	  public ResponseEntity<?> updateRoom(@RequestParam(value="image", required = false) MultipartFile file,
			  	@RequestParam("id") Long id,
			  	@RequestParam("name") String name,
				@RequestParam("description") String description,
				@RequestParam("rate") Long rate,
				@RequestParam("price") BigDecimal price,
				@RequestParam("status") Long status) throws IOException, URISyntaxException {
	      try {
	    	  	RoomEntity room = new RoomEntity();
				RoomDTO roomDTO = new RoomDTO();
	    	  if(file!=null) {
	    		  byte[] bytes = file.getBytes();
	    		  Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
	    		  Path path2 = Paths.get(file.getOriginalFilename());
	    		  Files.write(path, bytes);
	    		  roomDTO.setImgLink("\\img\\" + path2.toString());
	    	  }else {
	    		  Optional<RoomEntity> r= roomService.findById(id);
	    		  RoomDTO tmp = new RoomDTO();
	    		  tmp = roomService.toDTO(r.get());
	    		  roomDTO.setImgLink(tmp.getImgLink());
	    	  }
	          
		
				roomDTO.setId(id);
				roomDTO.setName(name);
				roomDTO.setDescription(description);
				roomDTO.setRate(rate);
				roomDTO.setPrice(price);
				roomDTO.setStatus(status);
				
				
				room=roomService.save(roomService.toEntity(roomDTO));

	          return ResponseEntity.ok(room);
	      } catch(RuntimeException ex) {
				System.out.println("false");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
	  }
//	public ResponseEntity<RoomEntity> updateRoom(@RequestBody RoomDTO model){
//		try {
//			RoomEntity room = roomService.save(roomService.toEntity(model));
//			return ResponseEntity.ok(room);
//		}catch(RuntimeException ex) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//			
//		}
//	}
	@DeleteMapping(value = "/api/rooms/delete")
	public void deleteRoom(@RequestBody RoomDTO model) {
		System.out.println(model.getImgLink());
		roomService.deleteById(model.getId());
	}
	

}
