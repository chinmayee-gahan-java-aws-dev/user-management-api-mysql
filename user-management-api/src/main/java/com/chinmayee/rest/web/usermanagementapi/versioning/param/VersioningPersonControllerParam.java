package com.chinmayee.rest.web.usermanagementapi.versioning.param;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV1;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV2;
import com.chinmayee.rest.web.usermanagementapi.versioning.Name;

@RestController
public class VersioningPersonControllerParam {
    
    // V1 when ?version=1
    @GetMapping(value = "/persons/param", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Bob Charlie");
    }

    // V2 when ?version=2
    @GetMapping(value = "/persons/param", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}