package com.guipernicone.pbs.Pokemon.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.guipernicone.pbs.Pokemon.Pokemon;
import com.guipernicone.pbs.Pokemon.PokemonRepository;
import com.guipernicone.pbs.Pokemon.Controller.Dto.PokemonStatusDto;

@SpringBootTest
public class PokemonServiceTest {
	@Mock
	PokemonRepository pokemonRepository;
	
	@InjectMocks
	PokemonService pokemonService;
	
	@Test
	void testGetPokemonStatus() {
		
		Pokemon testPokemon = new Pokemon();
		testPokemon.setName("PokemonTest");
		testPokemon.setJapaneseName("PokemonJapaneseName");
		testPokemon.setPokedexNumber(1);
		testPokemon.setGeneration(1);
		testPokemon.setLegendary(false);
		testPokemon.setFirstType("fire");
		testPokemon.setSecondType("ghost");
		testPokemon.setHp(45);
		testPokemon.setAttack(90);
		testPokemon.setDefense(50);
		testPokemon.setSpeed(50);
		testPokemon.setHeight(70.8f);
		testPokemon.setWeight(120.4f);
		testPokemon.setAbilities("[fly]");
		
		Optional<Pokemon> optionalTestPokemon = Optional.of(testPokemon);
		
		when(pokemonRepository.findPokemonByPokedexNumber(1)).thenReturn(optionalTestPokemon);
		
		PokemonStatusDto result = pokemonService.getPokemonStatus(1);
		
		assertEquals(1, result.getPokedexNumber());
		assertEquals("PokemonTest", result.getName());
		assertEquals("PokemonJapaneseName", result.getJapaneseName());
		assertEquals(1, result.getGeneration());
		assertEquals(false, result.isLegendary());
		assertEquals("fire", result.getFirstType());
		assertEquals("ghost", result.getSecondType());
		assertEquals(45, result.getHp());
		assertEquals(90, result.getAttack());
		assertEquals(50, result.getDefense());
		assertEquals(50, result.getSpeed());
		assertEquals(70.8f, result.getHeight());
		assertEquals(120.4f, result.getWeight());
		assertEquals("[fly]", result.getAbilities());
		
	}
}
