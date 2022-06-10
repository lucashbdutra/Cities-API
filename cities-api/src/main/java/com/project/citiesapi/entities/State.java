package com.project.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) //Ensinando ao hibernate como converter json em Lista
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

  /* 1st - Apenas criar um atributo que recebe o tipo de valor equivalente ao que está no banco de dados
  @Column(name = "pais")
  private Integer countryId;*/

    // 2nd - @ManyToOne -> O hibernate tem que fazer uma query a mais pra isso, já que está relacionando o campo de uma tabela a outra entidade
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;


    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

}
