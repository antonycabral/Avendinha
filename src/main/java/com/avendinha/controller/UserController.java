package com.avendinha.controller;

import com.avendinha.model.UserModel;
import com.avendinha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para exibir o formulário de criação de usuário
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createUser"); // Nome do arquivo HTML a ser renderizado
        modelAndView.addObject("user", new UserModel());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createUser(@ModelAttribute("user") UserModel user) {
        // Salvar o usuário no banco de dados
        UserModel createdUser = userService.createUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/"); // Redirecionar para a lista de usuários após a criação
        return modelAndView;
    }
    
    // Endpoint para atualizar um usuário pelo seu ID
    @PutMapping("/{userId}")
    public ModelAndView updateUser(@PathVariable Long userId, @ModelAttribute("userDetails") UserModel userDetails) {
        // Atualiza os detalhes de um usuário existente
        UserModel updatedUser = userService.updateUser(userId, userDetails);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userDetails"); // Nome do arquivo HTML a ser renderizado
        modelAndView.addObject("user", updatedUser);
        return modelAndView;
    }

    // Endpoint para obter todos os usuários
    @GetMapping
    public ModelAndView getAllUsers() {
        // Obtém todos os usuários
        List<UserModel> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userList"); // Nome do arquivo HTML a ser renderizado
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    // Endpoint para obter um usuário pelo seu ID
    @GetMapping("/{userId}")
    public ModelAndView getUserById(@PathVariable Long userId) {
        // Obtém um usuário pelo seu ID
        UserModel user = userService.getUserById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userDetails"); // Nome do arquivo HTML a ser renderizado
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // Endpoint para excluir um usuário pelo seu ID
    @DeleteMapping("/{userId}")
    public ModelAndView deleteUser(@PathVariable Long userId) {
        // Exclui um usuário pelo seu ID
        userService.deleteUser(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users"); // Redireciona para a lista de usuários após a exclusão
        return modelAndView;
    }
}
