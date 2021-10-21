package com.upgradeHub.championship.controller.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRQ {
    private String name;
    private int age;
    private Long height;
    private Long weight;
}
