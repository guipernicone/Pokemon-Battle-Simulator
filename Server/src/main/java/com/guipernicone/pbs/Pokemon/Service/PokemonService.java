package com.guipernicone.pbs.Pokemon.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guipernicone.pbs.Pokemon.Pokemon;
import com.guipernicone.pbs.Pokemon.PokemonRepository;
import com.guipernicone.pbs.Pokemon.Controller.Dto.PokemonStatusDto;

@Service
public class PokemonService {

	@Autowired 
	private PokemonRepository pokemonRepository;
	
	/**
	 * Get a resumed pokemon status
	 * 
	 * @param pokedexNumber The pokemon pokedex number
	 * 
	 * @return PokemonStatusDto
	 */
	public PokemonStatusDto getPokemonStatus(int pokedexNumber) {
		
		Optional<Pokemon> optionalPokemon = pokemonRepository.findPokemonByPokedexNumber(pokedexNumber);

		if (optionalPokemon.isPresent()) {
			
			Pokemon pokemon = optionalPokemon.get();

			PokemonStatusDto pokemonDto = new PokemonStatusDto(
						pokemon.getName(),
						pokemon.getJapaneseName(),
						pokemon.getPokedexNumber(),
						pokemon.getGeneration(),
						pokemon.isLegendary(),
						pokemon.getFirstType(),
						pokemon.getSecondType(),
						pokemon.getHp(),
						pokemon.getAttack(),
						pokemon.getDefense(),
						pokemon.getSpeed(),
						pokemon.getHeight(),
						pokemon.getWeight(),
						pokemon.getAbilities()
					);
			
			
			return pokemonDto;
		}
		
		return null;
	}

	/**
	 * Get all status of a pokemon
	 * 
	 * @param pokedexNumber The pokemon pokedex number
	 * 
	 * @return Pokemon
	 */
	public Pokemon getPokemonAllStatus(int pokedexNumber) {
		Optional<Pokemon> optionalPokemon = pokemonRepository.findPokemonByPokedexNumber(pokedexNumber);

		if (optionalPokemon.isPresent()) {

			return optionalPokemon.get();
		}
		
		return null;
	}

	/**
	 * Simulate a battle between two pokemons
	 * 
	 * @param firstPokemon First pokemon pokedex number
	 * @param secondPokemon Second pokemon pokedex number
	 * @return 
	 * 	PokedexNumber - Winner;
	 * 	0 - Tie;
	 *  -1 - Pokemon not found;
	 */
	public int battleSimulateSolo(int firstPokemon, int secondPokemon) {
		Optional<Pokemon> optionalPokemon1 = pokemonRepository.findPokemonByPokedexNumber(firstPokemon);
		Optional<Pokemon> optionalPokemon2 = pokemonRepository.findPokemonByPokedexNumber(secondPokemon);
		
		if (optionalPokemon1.isPresent() && optionalPokemon2.isPresent()) {

			Pokemon pokemon1 = optionalPokemon1.get();
			Pokemon pokemon2 = optionalPokemon2.get();
			
			Float pokemon1status = (float) calculatePokemonStatus(pokemon1);
			Float pokemon2status = (float) calculatePokemonStatus(pokemon2);

			Float pokemon1TypeMultiplier = getPokemonType(pokemon1, pokemon2.getFirstType());
			pokemon1TypeMultiplier = pokemon1TypeMultiplier * getPokemonType(pokemon1, pokemon2.getSecondType());
			
			Float pokemon2TypeMultiplier = getPokemonType(pokemon2, pokemon1.getFirstType());
			pokemon2TypeMultiplier = pokemon2TypeMultiplier * getPokemonType(pokemon2, pokemon1.getSecondType());

			pokemon1status = pokemon1status * pokemon2TypeMultiplier;
			pokemon2status = pokemon2status * pokemon1TypeMultiplier;
			
//			System.out.println();
//			System.out.println("TypeMultiplyer 1: " + pokemon1TypeMultiplier);
//			System.out.println("Pokemon status 1 : " + (float) calculatePokemonStatus(pokemon1));
//			System.out.println("Pokemon status 1 w/mult: " + pokemon1status);
//			System.out.println("TypeMultiplyer 2: " + pokemon2TypeMultiplier);
//			System.out.println("Pokemon status 2 : " + (float) calculatePokemonStatus(pokemon2));
//			System.out.println("Pokemon status 2 w/mult: " + pokemon2status);
//			System.out.println();
			
			if (pokemon1status.equals(pokemon2status)) {
				return 0;
			}
			if (pokemon1status > pokemon2status) {
				return firstPokemon;
			}
			if (pokemon1status < pokemon2status) {
				return secondPokemon;
			}
		}
		
		return -1;
	}
	
	/**
	 * Calculate the Pokemon Battle Status
	 * 
	 * @param Pokemon
	 * @return Pokemon Battle Status
	 */
	private int calculatePokemonStatus(Pokemon Pokemon) {
		int attack = Pokemon.getAttack() + Pokemon.getSpAttack();
		int defense = Pokemon.getDefense() + Pokemon.getSpDefense();
		
		return ( attack *  Pokemon.getSpeed()) + (defense * Pokemon.getHp());
	}
	
	/**
	 * Get the Pokemon type multiplier
	 * 
	 * @param pokemon - Pokemon Object
	 * @param AgainstPokemonType - Type of the Pokemon
	 * 
	 * @return Float - The multiplier
	 */
	private Float getPokemonType(Pokemon pokemon, String AgainstPokemonType) {
		if (AgainstPokemonType != null) {

			switch (AgainstPokemonType) {
				case "bug":
					return pokemon.getAgainstBug();
				case "dark":
					return pokemon.getAgainstDark();
				case "dragon":
					return pokemon.getAgainstDragon();
				case "electric":
					return pokemon.getAgainstElectric();
				case "fairy":
					return pokemon.getAgainstFairy();
				case "fight":
					return pokemon.getAgainstFight();
				case "fire":
					return pokemon.getAgainstFire();
				case "flying":
					return pokemon.getAgainstFlying();
				case "ghost":
					return pokemon.getAgainstGhost();
				case "grass":
					return pokemon.getAgainstGrass();
				case "ground":
					return pokemon.getAgainstGround();
				case "ice":
					return pokemon.getAgainstIce();
				case "normal":
					return pokemon.getAgainstNormal();
				case "poison":
					return pokemon.getAgainstPoison();
				case "psychic":
					return pokemon.getAgainstPsychic();
				case "rock":
					return pokemon.getAgainstRock();
				case "steel":
					return pokemon.getAgainstSteel();
				case "water":
					return pokemon.getAgainstWater();
			}
			
		}
		return 1f;
	}
	
}
