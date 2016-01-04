/*
 * Copyright 2014-2016, Stigmergic-Modeling Project
 * SEIDR, Peking University
 * All rights reserved
 *
 * Stigmergic-Modeling is used for collaborative groups to create a conceptual model.
 * It is based on UML 2.0 class diagram specifications and stigmergy theory.
 */

package net.stigmod.controller;

import net.stigmod.domain.node.User;
//import net.stigmod.repository.MovieRepository;
import net.stigmod.repository.node.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.stigmod.util.config.Config;
import net.stigmod.util.config.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handle user related page requests
 *
 * @version     2015/08/11
 * @author 	    Shijun Wang
 */
@Controller
public class UserController {

    // Common settings
    private Config config = ConfigLoader.load();
    private String host = config.getHost();
    private String port = config.getPort();

    @Autowired
    UserRepository userRepository;
//    @Autowired
//    MovieRepository movieRepository;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String profile(Model model) {
        final User user = userRepository.getUserFromSession();
        model.addAttribute("user", user);
        model.addAttribute("host", host);
        model.addAttribute("port", port);
        model.addAttribute("title", "user");
//        if (user!=null) {
//            model.addAttribute("recommendations", movieRepository.getRecommendations(user));
//        }
        return "/user";
    }

    @RequestMapping(value = "/newmodel", method = RequestMethod.GET)
    public String newModel(Model model) {
        final User user = userRepository.getUserFromSession();
        model.addAttribute("user", user);
        model.addAttribute("host", host);
        model.addAttribute("port", port);
        model.addAttribute("title", "New Model");
        return "/new_model";
    }

//    @RequestMapping(value = "/user/{login}/friends", method = RequestMethod.POST)
//    public String addFriend(Model model, @PathVariable("login") String login) {
//        userRepository.addFriend(login, userRepository.getUserFromSession());
//		return "forward:/user/"+login;
//    }

//    @RequestMapping(value = "/user/{login}")
//    public String publicProfile(Model model, @PathVariable("login") String login) {
//        User profiled = userRepository.findByLogin(login);
//        User user = userRepository.getUserFromSession();
//
//        return publicProfile(model, profiled, user);
//    }
//
//    private String publicProfile(Model model, User profiled, User user) {
//        if (profiled.equals(user)) return profile(model);
//
//        model.addAttribute("profiled", profiled);
//        model.addAttribute("user", user);
////        model.addAttribute("isFriend", areFriends(profiled, user));
//        return "/user/public";
//    }

//    private boolean areFriends(User user, User loggedIn) {
//        return user!=null && user.isFriend(loggedIn);
//    }

    private String cvtObj2Json (Object obj) {
        return "ok";
    }
}

