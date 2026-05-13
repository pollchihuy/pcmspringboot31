package com.juaracoding.pcmspringboot31.dto.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValAksesMenuDTO {
    private Long menu;
    @JsonProperty("can_insert")
    private Boolean canInsert;
    @JsonProperty("can_update")
    private Boolean canUpdate;
    @JsonProperty("can_delete")
    private Boolean canDelete;
    @JsonProperty("can_view")
    private Boolean canView;
    @JsonProperty("can_print")
    private Boolean canPrint;
}
