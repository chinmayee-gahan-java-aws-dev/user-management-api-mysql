package com.chinmayee.rest.web.usermanagementapi.versioning.media;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV1;
import com.chinmayee.rest.web.usermanagementapi.versioning.PersonV2;
import com.chinmayee.rest.web.usermanagementapi.versioning.Name;

@RestController
public class VersioningPersonControllerMedia {
    
    // V1 when Accept: application/vnd.company.app-v1+json
    @GetMapping(value = "/persons/media", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    // V2 when Accept: application/vnd.company.app-v2+json
    @GetMapping(value = "/persons/media", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}