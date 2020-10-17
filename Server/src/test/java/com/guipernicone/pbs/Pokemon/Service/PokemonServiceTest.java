package com.guipernicone.pbs.Pokemon.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
	private PokemonRepository pokemonRepository;
	
	@InjectMocks
	private PokemonService pokemonService;
	
	private Pokemon firePokemon;
	private Pokemon grassPokemon;
	
	@BeforeEach
	public void setup() {
		firePokemon = new Pokemon();
		firePokemon.setName("FirePokemon");
		firePokemon.setJapaneseName("FirePokemonJapaneseName");
		firePokemon.setPokedexNumber(1);
		firePokemon.setGeneration(1);
		firePokemon.setLegendary(false);
		firePokemon.setFirstType("fire");
		firePokemon.setSecondType("ghost");
		firePokemon.setHp(45);
		firePokemon.setAttack(90);
		firePokemon.setDefense(50);
		firePokemon.setSpeed(50);
		firePokemon.setHeight(70.8f);
		firePokemon.setWeight(120.4f);
		firePokemon.setAbilities("[fly]");
		firePokemon.setClassification("bird");
		firePokemon.setSpAttack(20);
		firePokemon.setSpDefense(10);
		firePokemon.setAgainstGrass(0.5f);
		firePokemon.setAgainstGhost(1f);
		firePokemon.setAgainstFire(1f);
		
		grassPokemon = new Pokemon();
		grassPokemon.setName("GrassPokemon");
		grassPokemon.setJapaneseName("GrassPokemon");
		grassPokemon.setPokedexNumber(2);
		grassPokemon.setGeneration(1);
		grassPokemon.setLegendary(false);
		grassPokemon.setFirstType("grass");
		grassPokemon.setSecondType("ghost");
		grassPokemon.setHp(45);
		grassPokemon.setAttack(90);
		grassPokemon.setDefense(50);
		grassPokemon.setSpeed(50);
		grassPokemon.setSpAttack(20);
		grassPokemon.setSpDefense(10);
		grassPokemon.setAgainstFire(2f);
		grassPokemon.setAgainstGhost(1f);
		
		Optional<Pokemon> optionalfirePokemon = Optional.of(firePokemon);
		Optional<Pokemon> optinalGrassPokemon = Optional.of(grassPokemon);
		when(pokemonRepository.findPokemonByPokedexNumber(1)).thenReturn(optionalfirePokemon);
		when(pokemonRepository.findPokemonByPokedexNumber(2)).thenReturn(optinalGrassPokemon);
	}
	
	@Test
	public void testGetPokemonStatus() {
		PokemonStatusDto result = pokemonService.getPokemonStatus(1);
		
		assertEquals(1, result.getPokedexNumber());
		assertEquals("FirePokemon", result.getName());
		assertEquals("FirePokemonJapaneseName", result.getJapaneseName());
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
	
	@Test
	public void testGetPokemonStatusInvalidId() {
		PokemonStatusDto result = pokemonService.getPokemonStatus(0);
		
		assertNull(result);
	}
	
	@Test
	public void testGetPokemonAllStatus() {
		Pokemon result = pokemonService.getPokemonAllStatus(1);
		
		assertEquals(1, result.getPokedexNumber());
		assertEquals("FirePokemon", result.getName());
		assertEquals("FirePokemonJapaneseName", result.getJapaneseName());
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
		assertEquals("bird", result.getClassification());
	}
	
	@Test
	public void testGetPokemonAllStatusInvalidId() {
		Pokemon result = pokemonService.getPokemonAllStatus(0);
		
		assertNull(result);
	}
	
	@Test
	public void testBattleSimulateSoloFireToGrass() {
		int result = pokemonService.battleSimulateSolo(1, 2);
		
		assertEquals(1, result);
	}
	
	@Test
	public void testBattleSimulateSoloEqual() {
		int result = pokemonService.battleSimulateSolo(1, 1);
		
		assertEquals(0, result);
	}
	
	@Test
	public void testBattleSimulateSoloInvalidId() {
		int result = pokemonService.battleSimulateSolo(0, 1);
		
		assertEquals(-1, result);
	}
}
