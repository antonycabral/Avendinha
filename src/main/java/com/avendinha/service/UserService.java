package com.avendinha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avendinha.repository.UserRepository;
import com.avendinha.Exception.ResourceNotFoundException;
import com.avendinha.model.UserModel;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para atualizar um usuário pelo seu ID
    public UserModel updateUser(Long userId, UserModel userDetails) {
        UserModel user = userRepository.findById(userId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));

        // Atualiza os detalhes do usuário com os detalhes fornecidos
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setAddress(userDetails.getAddress());

        return userRepository.save(user);
    }

    // Método para obter todos os usuários
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para obter um usuário pelo seu ID
    public UserModel getUserById(Long userId) {
        return userRepository.findById(userId)
                            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + userId));
    }

    // Método para excluir um usuário pelo seu ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
}


