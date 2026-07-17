package com.employee_Manager.performance_system.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.DTOMapper.DTOMapper;
import com.employee_Manager.performance_system.DTOMapper.RequestDTOMapper;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Repository.UserInfoRepository;
import com.employee_Manager.performance_system.RequestDTO.UserInfoRequestDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.LoginResponseDTO;

@Service
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final UserInfoRepository userInfoRepository;

	private final JWTService jwtService;
	private final RequestDTOMapper dTOMapper ;

	public AuthService(AuthenticationManager authenticationManager, JWTService jwtService , UserInfoRepository userInfoRepository , RequestDTOMapper dTOMapper) {
		super();
		this.authenticationManager = authenticationManager;
		this.userInfoRepository = userInfoRepository;
		this.jwtService = jwtService;
		this.dTOMapper = dTOMapper;
	}

	public LoginResponseDTO getAuthentication(UserInfoRequestDTO user) {
		// TODO Auto-generated method stub

		UserInfo userInfo = userInfoRepository.findByUsername(user.getUsername())
		.orElseThrow(()-> new UsernameNotFoundException("No User Found for name : "+ user.getUsername()));
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		return auth.isAuthenticated() ? dTOMapper.toLoginResponseDto(jwtService.getToken(user.getUsername()) , userInfo) : new LoginResponseDTO();
	}

}
