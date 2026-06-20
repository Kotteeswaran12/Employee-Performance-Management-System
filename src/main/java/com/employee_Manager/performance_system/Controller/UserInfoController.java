package com.employee_Manager.performance_system.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DtoLayer.UserInfoDTO;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Service.AuthService;
import com.employee_Manager.performance_system.Service.UserInfoServiceIMP;
import com.employee_Manager.performance_systemDTOMapper.DTOMapper;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	private final UserInfoServiceIMP userInfoServiceIMP;

	private final AuthService authService;

	public UserInfoController(UserInfoServiceIMP userInfoServiceIMP, AuthService authService) {
		super();
		this.userInfoServiceIMP = userInfoServiceIMP;
		this.authService = authService;
	}

	@GetMapping("/log-in")
	public String getAuthenticate(@RequestBody UserInfo user) {
		return authService.getAuthentication(user);
	}

	@PostMapping("/add-user/{empId}")
	public ResponseEntity<UserInfoDTO> createUser(@PathVariable String empId, @RequestBody UserInfo user) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.createUser(empId, user)),
				HttpStatus.CREATED

		);
	}

	@GetMapping("/get-userBy/{id}")
	public ResponseEntity<UserInfoDTO> getUserById(@PathVariable Integer id) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.getUserById(id)), HttpStatus.OK

		);

	}

	@GetMapping("/get-userByName")
	public ResponseEntity<UserInfoDTO> getUserByUsername(@RequestParam String username) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.getUserByUsername(username)),
				HttpStatus.OK);

	}

	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<UserInfo> deleteUserById(@PathVariable Integer id) {
		userInfoServiceIMP.deleteUserById(id);

		return ResponseEntity.noContent().build();
	}

	@PostMapping("/changePassword")
	public ResponseEntity<UserInfoDTO> changepasword(@RequestParam String password, @RequestParam String username) {
		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.changepasword(password, username)),
				HttpStatus.OK);
	}

}
