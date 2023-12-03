package com.example.RentalCars.service;

import com.example.RentalCars.dto.request.UserRequestDTO;
import com.example.RentalCars.dto.response.UserResponseDTO;
import com.example.RentalCars.model.Role;
import com.example.RentalCars.model.User;
import com.example.RentalCars.projections.UserDetailsProjection;
import com.example.RentalCars.repository.RoleRepository;
import com.example.RentalCars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired @Lazy
	private PasswordEncoder passwordEncoder;


	private UserResponseDTO convertToUserResponseDTO(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setFullName(user.getFullName());
		dto.setRoles(user.getRoles().stream()
				.map(Role::getAuthority)
				.collect(Collectors.toList()));
		return dto;
	}

	@Transactional(readOnly = true)
	public List<UserResponseDTO> listAllUsers() {
		List<User> users = repository.findAll();
		return users.stream()
				.map(this::convertToUserResponseDTO)
				.collect(Collectors.toList());
	}

	public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
		User user = new User();
		user.setFullName(userRequestDTO.getFullName());

		String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
		user.setPassword(encodedPassword);

		user.setEmail(userRequestDTO.getEmail());

		Role role = roleRepository.findByAuthority("ROLE_CLIENT");
		user.addRole(role);
		User savedUser = repository.save(user);

		return convertToUserResponseDTO(savedUser);
	}


	@Transactional
	public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
		User existingUser = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setFullName(userRequestDTO.getFullName());
		existingUser.setEmail(userRequestDTO.getEmail());

		if (userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
			String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
			existingUser.setPassword(encodedPassword);
		}

		existingUser = repository.save(existingUser);
		return convertToUserResponseDTO(existingUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
		if (result.isEmpty()) {
			throw new UsernameNotFoundException("Email not found");
		}
		
		User user = new User();
		user.setEmail(result.get(0).getUsername());
		user.setPassword(result.get(0).getPassword());
		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		
		return user;
	}

	protected User authenticated() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");

			return repository.findByEmail(username).get();
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("Email not found");
		}
	}

	@Transactional(readOnly = true)
	public UserResponseDTO getMe() {
		User user = authenticated();
		return new UserResponseDTO(user);
	}
}
