///*
// * package com.chinmayee.rest.web.usermanagementapi.versioning.v1;
// * 
// * import org.springframework.web.bind.annotation.GetMapping; import
// * org.springframework.web.bind.annotation.PathVariable; import
// * org.springframework.web.bind.annotation.RequestMapping; import
// * org.springframework.web.bind.annotation.RestController;
// * 
// * import
// * com.chinmayee.rest.web.usermanagementapi.exception.UserNotFoundException;
// * import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV1;
// * 
// * @RestController
// * 
// * @RequestMapping("/v1") public class VersioningPersonControllerV1 {
// * 
// * @GetMapping("/persons") public PersonV1 getFirstVersionOfPerson() { return
// * new PersonV1("Chinmayee Rathod"); }
// * 
// * @GetMapping("/users/{id}") public String getUserById(@PathVariable int id) {
// * if(id > 3) { throw new UserNotFoundException("id-"+id+" not Found"); } return
// * "User " + id; } }
// */