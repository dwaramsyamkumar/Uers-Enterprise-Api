package com.lbg.ob.eaisp.users.ent.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ob.eaisp.commons.constants.Brand;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull
    @Size(min = 1, max = 40)
    @JsonProperty("TspUserId")
    private String tspUserId;

    @NotNull
    @Size(min = 1, max = 40)
    @JsonProperty("TspId")
    private String tspId;

    @NotNull
    @Size(min = 1, max = 24)
    @JsonProperty("PartyId")
    private String partyId;

    @NotNull
    @JsonProperty("Brand")
    private Brand brand;

}
