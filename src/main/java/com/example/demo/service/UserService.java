package com.example.demo.service;

import com.example.demo.model.entities.CustomerEntity;
import com.example.demo.model.entities.role.UserEntity;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<UserEntity, UserRepository>{

    /*private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;*/

   /* public ResponseEntity<User> register(User user) throws Exception {
        if (repository.existsByUsername(user.getUsername())) {
            throw new ServiceException("username-duplicated");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.CUSTOMER);
        repository.save(user);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> registerAdmin(User user) throws Exception {
        if (repository.existsByUsername(user.getUsername())) {
            throw new ServiceException("username-duplicated");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    public AuthenticationResponse login(LoginDto loginDto) throws Exception {
        authenticate(loginDto.getUsername(), loginDto.getPassword());
        var user = repository.findByUsername(loginDto.getUsername()).orElseThrow();
        final String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(token).user(user).build();
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new ServiceException(e, "user-disabled");
        } catch (BadCredentialsException e) {
            throw new ServiceException(e, "invalid-credentials");
        }
    }*/

    public UserEntity findById(Long id) throws ServiceException {

     /*   if (repository.findById(id) == null) {
            throw new ServiceException("idIsNull");

        }*/
        return repository.findById(id).get();
    }

    public List<UserEntity> getAll() {

        return repository.findAll();
    }

    public UserEntity update(UserEntity user) throws ServiceException {
        UserEntity existingUser = repository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new ServiceException("user-not-available");
        }
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }

        if (user.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(user.getPhoneNumber());
        }

        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }

        if (user.getRole() != null) {
            existingUser.setRole(user.getRole());
        }
      /*  try {
            update(existingUser);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("username-duplicated");
        }*/
        return existingUser;
    }

    public List<UserEntity> getAllWithPagination(int pageNum) {

        return repository.findAll(Pageable.ofSize(2).withPage(pageNum)).getContent();
    }

    public void deleteById(Long id) {
        repository.delete(repository.findById(id).get());
    }

   /* public List<UserEntity> getAllWithPagination(int pageIndex) {

    }*/
}
