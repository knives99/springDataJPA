package com.example.springDataJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//特殊狀況：想用兩個entity連結同一個table
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//重新綁定Class跟table Column的關係
@AttributeOverrides({
        @AttributeOverride(name = "name",column = @Column(name = "guardian_name")),
        @AttributeOverride(name = "email",column = @Column(name = "guardian_email")),
        @AttributeOverride(name = "mobile",column = @Column(name = "guardian_mobile"))
})

public class Guardian {
    private  String name;
    private  String email;
    private  String mobile;

}
