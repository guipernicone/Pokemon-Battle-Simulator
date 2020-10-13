package com.guipernicone.pbs.Pokemon;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PokemonRepository extends MongoRepository<Pokemon, String>{

	Optional<Pokemon> findPokemonByPokedexNumber(int pokedexNumber);
}
