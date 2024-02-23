package com.bootcampsbforum.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcampsbforum.dto.gov.request.PostRequestDTO;
import com.bootcampsbforum.dto.gov.request.UserRequestDTO;
import com.bootcampsbforum.dto.gov.request.response.gov.PostDTO;
import com.bootcampsbforum.dto.gov.request.response.gov.UserDTO;
import com.bootcampsbforum.dto.gov.request.response.gov.UserPostDTO;
import com.bootcampsbforum.entity.PostEntity;
import com.bootcampsbforum.entity.UserEntity;
import com.bootcampsbforum.model.dto.jph.Post;
import com.bootcampsbforum.model.dto.jph.User;


// When server starts,
// Spring ensures modelMapper is ready before creating GovMapper object
@Component // -> Bean
public class UserMapper {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PostMapper postMapper;

  public UserDTO map(User user) {
    // map all fields by name
    return this.modelMapper.map(user, UserDTO.class);
  }

  public UserEntity mapEntity(User user) {
    return new UserEntity(null, //
        user.getName(), //
        user.getUsername(), //
        user.getEmail(), //
        user.getPhone(), //
        user.getWebsite(), //
        user.getAddress().getStreet(), //
        user.getAddress().getSuite(), //
        user.getAddress().getCity(), //
        user.getAddress().getZipcode(), //
        user.getAddress().getGeo().getLatitude(), //
        user.getAddress().getGeo().getLongitude(), //
        user.getCompany().getName(), //
        user.getCompany().getCatchPhrase(), //
        user.getCompany().getBusService(), //
        null);
  }

  public UserEntity mapEntity(UserRequestDTO dto) {

    UserEntity userEntity = new UserEntity(null, //
        dto.getName(), //
        dto.getUsername(), //
        dto.getEmail(), //
        dto.getPhone(), //
        dto.getWebsite(), //
        dto.getStreet(), //
        dto.getSuite(), //
        dto.getCity(), //
        dto.getZipcode(), //
        dto.getAddrLat(), //
        dto.getAddrLong(), //
        dto.getCompanyName(), //
        dto.getCompanyCatchPhrase(), //
        dto.getCompanyBusService(), //
        null);

    List<PostEntity> postEntities = new ArrayList<>();
    for (PostRequestDTO postDto : dto.getPosts()) {
      PostEntity postEntity = postMapper.mapEntity(postDto);
      postEntity.setUser(userEntity); // set each post with userEntity
      postEntities.add(postEntity);
    }
    userEntity.setPosts(postEntities); // set the post in the userEntity and ready for input
    return userEntity;
  }

  public UserPostDTO map(User user, List<Post> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    return UserPostDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
    // ModelMapper mm = new ModelMapper();
  }
}
