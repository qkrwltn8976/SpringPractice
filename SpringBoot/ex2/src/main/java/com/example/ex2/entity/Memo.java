package com.example.ex2.entity;

import lombok.*;
import sun.util.resources.cldr.gv.LocaleNames_gv;

import javax.persistence.*;

@Entity
@Table(name = "tbl_memo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    private String memoText;
}
