package com.guipernicone.pbs.Pokemon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guipernicone.pbs.Pokemon.Pokemon;
import com.guipernicone.pbs.Pokemon.Controller.Dto.PokemonStatusDto;
import com.guipernicone.pbs.Pokemon.Service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	@Value("${pokemon.max-index}")
	private int pokemonMaxIndex;
	
	@GetMapping("/status")
	private ResponseEntity<?> pokemonStatus(@RequestParam int pokedexIndex) {
		
		if (pokedexIndex > 0 && pokedexIndex <= pokemonMaxIndex) {
			
			PokemonStatusDto pokemonDto = pokemonService.getPokemonStatus(pokedexIndex);
			
			if(pokemonDto != null) {
				return ResponseEntity.ok(pokemonDto);
			}
		}

		return ResponseEntity.badRequest().body("Invalid Pokemon Pokedex Index");
	}
	
	@GetMapping("/all-status")
	private ResponseEntity<?> pokemonAllStatus(@RequestParam int pokedexIndex) {
		
		if (pokedexIndex > 0 && pokedexIndex <= pokemonMaxIndex) {
			
			Pokemon pokemon = pokemonService.getPokemonAllStatus(pokedexIndex);
			
			if(pokemon != null) {
				return ResponseEntity.ok(pokemon);
			}
		}

		return ResponseEntity.badRequest().body("Invalid Pokemon Pokedex Index");
	}
	
	@GetMapping("/battle-simulate-solo")
	private ResponseEntity<?> battleSimulateSolo(@RequestParam int firstPokemon, @RequestParam int secondPokemon) {
		
		if (firstPokemon > 0 && firstPokemon <= pokemonMaxIndex && secondPokemon > 0 && secondPokemon <= pokemonMaxIndex ) {
			
			int winner = pokemonService.battleSimulateSolo(firstPokemon, secondPokemon);

			if(winner != -1) {
				return ResponseEntity.ok(winner);
			}
		}

		return ResponseEntity.badRequest().body("Invalid Pokemon Pokedex Index");
	}
	
	@GetMapping("/list")
	private ResponseEntity<?> getPokemonsStatusList(@RequestParam int page, @RequestParam int qty) {
		
		if (page >= 0 && qty > 0) {
			Page<Pokemon> pokemons = pokemonService.getPokemonsStatusList(page, qty);
			
			if (pokemons != null) 
			{
				return ResponseEntity.ok(pokemons);
			}
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.badRequest().body("Invalid Pokemon Pokedex Index");
	}
}
