package com.bootcampsbforum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcampsbforum.entity.User;
import com.bootcampsbforum.mapper.GovMapper;
import com.bootcampsbforum.repository.UserRepository;
import com.bootcampsbforum.service.UserService;
import com.bootcampsbforum.service.Impl.GovServiceHolder;

// @ Autowired
// private CommandLineRunner commandRunner
// main code -> commandlineRunner.run()
// if (commandlineRunner != null) commandlineRunner.run() (if the bean not created --> null)

@Component
public class AppRunner implements CommandLineRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private GovMapper govMapper;

  @Autowired
  private GovServiceHolder govServiceHolder;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("hello world"); // before server start
    // int x = 2;
    // if (x < 3){
    // throw new RuntimeException();
    // }

    // Call JPH -> user -> ,, before start, confirm that the users, posts, should be ready before service start
    govServiceHolder.getUsers();

  }

  // Main Tasks in AppRunner:
  // 1. Checking on configuration -DB or yml --> if dont have -> run method to throw exception
  // 2. Invoke API tp get data (i.e configuration, raw data)
}
