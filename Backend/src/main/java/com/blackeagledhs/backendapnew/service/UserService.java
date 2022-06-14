package com.blackeagledhs.backendapnew.service;

import com.blackeagledhs.backendapnew.entity.User;
import com.blackeagledhs.backendapnew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getIdUser(Long iduser) {
        return userRepository.findById(iduser);
    }

    public User editUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long iduser){
        userRepository.deleteById(iduser);
    }
}
