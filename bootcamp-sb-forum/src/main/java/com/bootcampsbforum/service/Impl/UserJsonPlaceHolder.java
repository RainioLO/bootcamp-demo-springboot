package com.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcampsbforum.dto.gov.request.UserRequestDTO;
import com.bootcampsbforum.entity.UserEntity;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.infra.BcUtil;
import com.bootcampsbforum.infra.ResourceNotFound;
import com.bootcampsbforum.infra.Scheme;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.mapper.UserMapper;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.repository.UserRepository;
import com.bootcampsbforum.service.PostService;
import com.bootcampsbforum.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// comment here to check
@Service // service start will access if the class correct or not.
public class UserJsonPlaceHolder implements UserService { // the only object

  @Value(value = "${api.jph.domain}")
  private String domain; // instance variable

  @Value(value = "${api.jph.endpoints.user}") // look at the value at yml
  private String userEndpoint;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext // similar to autowired
  private EntityManager entityManager;

  @Override
  public List<User> getUsers() { // instance method ny this Service object
    String userUrl = BcUtil.url(Scheme.HTTPS, domain, userEndpoint); // variable in local method
    User[] users = restTemplate.getForObject(userUrl, User[].class);
    return Arrays.stream(users).collect(Collectors.toList());
  }

  @Override
  public User getUser(int index) {
    Optional<User> userPostDTO = this.getUsers().stream() //
        .filter(e -> e.getId() == index) //
        .findFirst();
    if (userPostDTO.isPresent())
      return userPostDTO.get();
    throw new ResourceNotFound(Syscode.NOTFOUND);
  }

  @Override
  public com.bootcampsbforum.entity.UserEntity findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  // @Override
  // public List<User> findAllByAddrLatGreaterThan(Double latitude){
  // return userRepository.findAllByAddrLatGreaterThan(latitude);
  // }

  @Override
  public List<com.bootcampsbforum.entity.UserEntity> getAllByEmailOrPhone(
      String email, String phone, Sort sort) {
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  public List<com.bootcampsbforum.entity.UserEntity> getAllByEmailOrPhone(String email, String phone) {
    Sort sort = Sort.by("email").ascending().and(Sort.by("phone").ascending());
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  @Override
  public List<com.bootcampsbforum.entity.UserEntity> getUsersByAddrLatGreaterThan(
      Double latitude) {
    return userRepository.findAllByAddrLatGreaterThan(latitude);
  }

  @Override
  public Long countUserByName(String prefix) {
    return userRepository.countUserByNameStartWith(prefix);
  }

  @Override
  @Transactional // all or nothing
  public void updateUserEmailById(Long id, String email) {
    userRepository.updateUser(id, email);
  }

  @Override
  @Transactional
  public com.bootcampsbforum.entity.UserEntity updateUserById(
      Long userId, com.bootcampsbforum.entity.UserEntity newUser) {
    // entityManager.find() -> select
    com.bootcampsbforum.entity.UserEntity oldUser = entityManager
        .find(com.bootcampsbforum.entity.UserEntity.class, userId);
    oldUser.setName(newUser.getName());
    oldUser.setAddrLat(newUser.getAddrLat());
    oldUser.setAddrLong(newUser.getAddrLong());
    oldUser.setCBusService(newUser.getCBusService());
    oldUser.setCCatchPhrase(newUser.getCCatchPhrase());
    oldUser.setCName(newUser.getCName());
    oldUser.setCity(newUser.getCity());
    oldUser.setEmail(newUser.getEmail());
    oldUser.setPhone(newUser.getPhone());
    oldUser.setSuite(newUser.getSuite());
    oldUser.setZipcode(newUser.getZipcode());
    oldUser.setWebsite(newUser.getWebsite());
    oldUser.setUsername(newUser.getUsername());
    oldUser.setStreet(newUser.getStreet());

    // entityManager.merge() -> update
    entityManager.merge(oldUser);
    return oldUser;
  }

  @Override
  @Transactional
  public UserEntity save(UserRequestDTO userRequestDTO) {
    UserEntity userEntity = userMapper.mapEntity(userRequestDTO);
    System.out.println("userEntity=" + userEntity);
    return userRepository.save(userEntity);
  }

}
