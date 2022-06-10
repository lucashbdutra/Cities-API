package com.project.citiesapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

/**
 * Como eu usei um sql pronto pra criar as tabelas eu tenho que mapear de forma que as entidades e os atributos recebam
 * o mesmo nome que eles ja possuem no banco de dados.
 *
 * Por default o nome da tabela seria Country, mas como o nome dela é "pais" no BD eu tenho que usar a annotation "@Table"
 * pra alterar o nome dela para "pais".
 *
 * Da mesma forma para que cada atributo que seria uma coluna tenha os mesmos nomes do BD eu uso o "@Column" pra definir,
 * pois por default o nome seria o mesmo do atributo.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pais")
public class Country implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;

}
