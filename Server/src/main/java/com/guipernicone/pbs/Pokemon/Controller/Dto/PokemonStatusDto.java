package com.guipernicone.pbs.Pokemon.Controller.Dto;

public class PokemonStatusDto {

	private String name;
	
	private String japaneseName;
	
	private int pokedexNumber;
	
	private int generation;
	
	private boolean legendary;
	
	private String firstType;
	
	private String secondType;
	
	private int hp;
	
	private int attack;
	
	private int defense;
	
	private int speed;
	
	private Float height;
	
	private Float weight;
	
	private String abilities;

	public PokemonStatusDto(String name, String japaneseName, int pokedexNumber, int generation, boolean legendary,
			String firstType, String secondType, int hp, int attack, int defense, int speed, Float height, Float weight,
			String abilities) {

		this.name = name;
		this.japaneseName = japaneseName;
		this.pokedexNumber = pokedexNumber;
		this.generation = generation;
		this.legendary = legendary;
		this.firstType = firstType;
		this.secondType = secondType;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.height = height;
		this.weight = weight;
		this.abilities = abilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJapaneseName() {
		return japaneseName;
	}

	public void setJapaneseName(String japaneseName) {
		this.japaneseName = japaneseName;
	}

	public int getPokedexNumber() {
		return pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public String getFirstType() {
		return firstType;
	}

	public void setFirstType(String firstType) {
		this.firstType = firstType;
	}

	public String getSecondType() {
		return secondType;
	}

	public void setSecondType(String secondType) {
		this.secondType = secondType;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "PokemonStatusDto [name=" + name + ", japaneseName=" + japaneseName + ", pokedexNumber=" + pokedexNumber
				+ ", generation=" + generation + ", legendary=" + legendary + ", firstType=" + firstType
				+ ", secondType=" + secondType + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense
				+ ", speed=" + speed + ", height=" + height + ", weight=" + weight + ", abilities=" + abilities + "]";
	}
	
	
}
