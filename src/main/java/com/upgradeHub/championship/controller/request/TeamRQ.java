package com.upgradeHub.championship.controller.request;
import com.upgradeHub.championship.model.TeamType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamRQ {
    private TeamType teamType;
    private String teamName;
}
