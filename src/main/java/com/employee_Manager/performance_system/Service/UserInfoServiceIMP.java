package com.employee_Manager.performance_system.Service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee_Manager.performance_system.Entity.Employees;
import com.employee_Manager.performance_system.Entity.UserInfo;
import com.employee_Manager.performance_system.Enums.RoleTypes;
import com.employee_Manager.performance_system.Exceptions.EmployeeNotFoundException;
import com.employee_Manager.performance_system.Exceptions.UserNotFoundException;
import com.employee_Manager.performance_system.Repository.EmployeeRepository;
import com.employee_Manager.performance_system.Repository.UserInfoRepository;
import com.employee_Manager.performance_system.RequestDTO.ChangePassDTO;
import com.employee_Manager.performance_system.ResponseDtoLayer.UserInfoDTO;

@Service
public class UserInfoServiceIMP implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    private final EmployeeRepository employeeRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//	private final p
    @Override
    public UserInfo createUser(String empID, UserInfo user) {

        Employees emp = employeeRepository.findByEmpcode(empID)
                .orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for EMPID : " + empID));

        emp.setUser(user);

        if (empID.startsWith("Emp")) {
            user.setRole(RoleTypes.EMPLOYEE);
        } else {
            user.setRole(RoleTypes.MANAGER);
        }

        user.setUsername(emp.getFirstname());
        user.setCreatedate(LocalDate.now());
        user.setEmployees(emp);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPhone(emp.getPhone());

        return userInfoRepository.save(user);
    }

    public UserInfoServiceIMP(UserInfoRepository userInfoRepository, EmployeeRepository employeeRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.userInfoRepository = userInfoRepository;
        this.employeeRepository = employeeRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    public UserInfo getUserById(String username) {
        // TODO Auto-generated method stub
        return userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("The User not Found for name :" + username));
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        // TODO Auto-generated method stub
        return userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Not user Found for User name :" + username));
    }

    @Override
    public void deleteUserById(Integer id) {
        // TODO Auto-generated method stub

        userInfoRepository.deleteById(id);

    }

    @Override
    public UserInfo UpdateUserInfo(UserInfoDTO userInfo, String username) {
        // TODO Auto-generated method stub
        UserInfo user = getUserByUsername(username);

        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setPhone(userInfo.getPhone());

        user.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));

        return userInfoRepository.save(user);
    }

    @Override
    public UserInfo createAdmin(UserInfo user) {
        // TODO Auto-generated method stub

        user.setRole(RoleTypes.ADMIN);
        user.setCreatedate(LocalDate.now());

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userInfoRepository.save(user);
    }

    @Override
    public Page<UserInfo> getAllUsers(int page, int size) {
        // TODO Auto-generated method stub

        Pageable pageable = PageRequest.of(page, size);

        return userInfoRepository.findAll(pageable);
    }

    @Override
    public UserInfo UpdatePassword(ChangePassDTO password, String UserName) {
        UserInfo info = userInfoRepository.findByUsername(UserName).orElseThrow(() -> new EmployeeNotFoundException("No Employee Found for name :" + UserName));
        if (bCryptPasswordEncoder.matches(password.getCurrentPass(), info.getPassword())) {
            info.setPassword(bCryptPasswordEncoder.encode(password.getNewPass()));
            return userInfoRepository.save(info);
        }

        throw new RuntimeException("the Currect pass must be Same");

    }

}
