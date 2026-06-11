package com.chinmayee.rest.web.usermanagementapi.versioning.header;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV1;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV2;
import com.chinmayee.rest.web.usermanagementapi.versioning.Name;

@RestController
public class VersioningPersonControllerHeader {
    
    // V1 when header X-API-VERSION=1
    @GetMapping(value = "/persons/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Bikash Behera");
    }

    // V2 when header X-API-VERSION=2  
    @GetMapping(value = "/persons/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Bikash", "Behera"));
    }
}