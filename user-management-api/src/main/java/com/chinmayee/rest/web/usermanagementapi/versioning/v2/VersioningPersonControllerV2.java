//package com.chinmayee.rest.web.usermanagementapi.versioning.v2;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.chinmayee.rest.web.usermanagementapi.versioning.Name;
//import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV2;
//
//@RestController
//@RequestMapping("/v2")
//public class VersioningPersonControllerV2 {
//    
//    @GetMapping("/persons")
//    public PersonV2 getSecondVersionOfPerson() {
//        return new PersonV2(new Name("Chinmayee", "Rathod"));
//    }
//}