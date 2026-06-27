package com.employee_Manager.performance_system.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.RequestDTO.UserInfoRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.UserInfoDTO;
import com.employee_Manager.performance_system.Service.AuthService;
import com.employee_Manager.performance_system.Service.UserInfoService;

@RestController
@RequestMapping("/api/")
public class UserInfoController {

	private final UserInfoService userInfoServiceIMP;

	private final AuthService authService;
	private final RequestDTOMapper requestDTOMapper;

	
	public UserInfoController(UserInfoService userInfoServiceIMP, AuthService authService,
			RequestDTOMapper requestDTOMapper) {
		super();
		this.userInfoServiceIMP = userInfoServiceIMP;
		this.authService = authService;
		this.requestDTOMapper = requestDTOMapper;
	}

	@GetMapping("user/log-in")
	public String getAuthenticate(@RequestBody UserInfo user) {
		return authService.getAuthentication(user);
	}
	
	@PostMapping("admin/user/add-admin")
	public ResponseEntity<UserInfoDTO> createAdmin(@RequestBody UserInfoRequestDTO user) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.createAdmin(requestDTOMapper.toUserInfoEntity(user))),
				HttpStatus.CREATED

		);
	}

	@PostMapping("user/signUp/{empId}")
	public ResponseEntity<UserInfoDTO> createUser(@PathVariable String empId, @RequestBody UserInfoRequestDTO user) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.createUser(empId, requestDTOMapper.toUserInfoEntity(user))),
				HttpStatus.CREATED

		);
	}

//	@GetMapping("user/get-userBy")
//	public ResponseEntity<UserInfoDTO> getUserById(Authentication authentication) {
//
//		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.getUserById(authentication.getName())), HttpStatus.OK
//
//		);
//
//	}

	@GetMapping("user/get-userByName")
	public ResponseEntity<UserInfoDTO> getUserByUsername(@RequestParam String username) {

		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.getUserByUsername(username)),
				HttpStatus.OK);

	}

	@DeleteMapping("admin/user/delete-user/{id}")
	public ResponseEntity<UserInfo> deleteUserById(@PathVariable Integer id) {
		userInfoServiceIMP.deleteUserById(id);

		return ResponseEntity.noContent().build();
	}

	@PostMapping("user/changePassword")
	public ResponseEntity<UserInfoDTO> changepasword(@RequestParam String password, Authentication authentication) {
		return new ResponseEntity<>(DTOMapper.toUserInfoDTO(userInfoServiceIMP.changepasword(password, authentication.getName())),
				HttpStatus.OK);
	}

}
