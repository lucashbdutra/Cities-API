package com.project.citiesapi.services;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.exceptions.CountryNotFound;
import com.project.citiesapi.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
    public final CountryRepository countryRepository;

    /**
     * O pageable é, como o nome sugere, uma paginação, quem me permite adicionar parâmetros ao Get de forma a coordenar
     * como o resultado sera exibido pra mim na forma de filtros. Além de me trazer várias informações úteis sobre o retorno
     * do banco de dados como: quantidade de elementos que compoe o conteudo das páginas, quantidade de páginas, etc.
     *
     * Exemplo:
     *
     * http://localhost:8080/countries?page=0&size=10&sort=name,asc
     *
     */

    public Page<Country> findAll(Pageable page){

        return countryRepository.findAll(page);
    }

    public Country findById(Long id) throws CountryNotFound{

      return countryRepository.findById(id)
              .orElseThrow(() -> new CountryNotFound("Country not found for this id = " + id));
    }

}
