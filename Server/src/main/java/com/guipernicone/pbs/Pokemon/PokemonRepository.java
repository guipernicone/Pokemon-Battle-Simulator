package com.guipernicone.pbs.Pokemon;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository<Pokemon, String>{

	Optional<Pokemon> findPokemonByPokedexNumber(int pokedexNumber);
}
