package com.zeabix.training.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {

    @JsonProperty("firstname")
    protected String firstName;

    @JsonProperty("lastname")
    protected String lastName;

    @JsonProperty("username")
    protected String username;

}
