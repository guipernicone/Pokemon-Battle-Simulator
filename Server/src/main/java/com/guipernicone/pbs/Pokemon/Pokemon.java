package com.guipernicone.pbs.Pokemon;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Pokemon {
	
	@Id
	private String id;
	
	private String name;
	
	@Field("japanese_name")
	private String japaneseName;
	
	@Field("type1")
	private String firstType;
	
	@Field("type2")
	private String secondType;
	
	@Field("pokedex_number")
	private int pokedexNumber;
	
	@Field("against_bug")
	private Float againstBug;
	
	@Field("against_dark")
	private Float againstDark;
	
	@Field("against_dragon")
	private Float againstDragon;
	
	@Field("against_electric")
	private Float againstElectric;
	
	@Field("against_fairy")
	private Float againstFairy;
	
	@Field("against_fight")
	private Float againstFight;
	
	@Field("against_fire")
	private Float againstFire;
	
	@Field("against_flying")
	private Float againstFlying;
	
	@Field("against_ghost")
	private Float againstGhost;
	
	@Field("against_grass")
	private Float againstGrass;
	
	@Field("against_ground")
	private Float againstGround;
	
	@Field("against_ice")
	private Float againstIce;
	
	@Field("against_normal")
	private Float againstNormal;
	
	@Field("against_poison")
	private Float againstPoison;
	
	@Field("against_psychic")
	private Float againstPsychic;
	
	@Field("against_rock")
	private Float againstRock;
	
	@Field("against_steel")
	private Float againstSteel;
	
	@Field("against_water")
	private Float againstWater;
	
	private int generation;
	
	@Field("is_legendary")
	private boolean legendary;
	
	@Field("height_m")
	private Float height;
	
	@Field("weight_kg")
	private Float weight;
	
	private int hp;
	
	private int attack;
	
	private int defense;
	
	@Field("sp_attack")
	private int spAttack;
	
	@Field("sp_defense")
	private int spDefense;
	
	private int speed;
	
	@Field("classfication")
	private String classification;
	
	@Field("porcentage_male")
	private Float malePercentage;
	
	@Field("capture_rate")
	private int captureRate;
	
	@Field("base_egg_steps")
	private int baseEggSteps;
	
	@Field("base_happiness")
	private int baseHappiness;
	
	@Field("base_total")
	private int baseTotal;
	
	private String abilities;
	
	@Field("experience_growth")
	private int experienceGrowth;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPokedexNumber() {
		return pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public Float getAgainstBug() {
		return againstBug;
	}

	public void setAgainstBug(Float againstBug) {
		this.againstBug = againstBug;
	}

	public Float getAgainstDark() {
		return againstDark;
	}

	public void setAgainstDark(Float againstDark) {
		this.againstDark = againstDark;
	}

	public Float getAgainstDragon() {
		return againstDragon;
	}

	public void setAgainstDragon(Float againstDragon) {
		this.againstDragon = againstDragon;
	}

	public Float getAgainstElectric() {
		return againstElectric;
	}

	public void setAgainstElectric(Float againstElectric) {
		this.againstElectric = againstElectric;
	}

	public Float getAgainstFairy() {
		return againstFairy;
	}

	public void setAgainstFairy(Float againstFairy) {
		this.againstFairy = againstFairy;
	}

	public Float getAgainstFight() {
		return againstFight;
	}

	public void setAgainstFight(Float againstFight) {
		this.againstFight = againstFight;
	}

	public Float getAgainstFire() {
		return againstFire;
	}

	public void setAgainstFire(Float againstFire) {
		this.againstFire = againstFire;
	}

	public Float getAgainstFlying() {
		return againstFlying;
	}

	public void setAgainstFlying(Float againstFlying) {
		this.againstFlying = againstFlying;
	}

	public Float getAgainstGhost() {
		return againstGhost;
	}

	public void setAgainstGhost(Float againstGhost) {
		this.againstGhost = againstGhost;
	}

	public Float getAgainstGrass() {
		return againstGrass;
	}

	public void setAgainstGrass(Float againstGrass) {
		this.againstGrass = againstGrass;
	}

	public Float getAgainstGround() {
		return againstGround;
	}

	public void setAgainstGround(Float againstGround) {
		this.againstGround = againstGround;
	}

	public Float getAgainstIce() {
		return againstIce;
	}

	public void setAgainstIce(Float againstIce) {
		this.againstIce = againstIce;
	}

	public Float getAgainstNormal() {
		return againstNormal;
	}

	public void setAgainstNormal(Float againstNormal) {
		this.againstNormal = againstNormal;
	}

	public Float getAgainstPoison() {
		return againstPoison;
	}

	public void setAgainstPoison(Float againstPoison) {
		this.againstPoison = againstPoison;
	}

	public Float getAgainstPsychic() {
		return againstPsychic;
	}

	public void setAgainstPsychic(Float againstPsychic) {
		this.againstPsychic = againstPsychic;
	}

	public Float getAgainstRock() {
		return againstRock;
	}

	public void setAgainstRock(Float againstRock) {
		this.againstRock = againstRock;
	}

	public Float getAgainstSteel() {
		return againstSteel;
	}

	public void setAgainstSteel(Float againstSteel) {
		this.againstSteel = againstSteel;
	}

	public Float getAgainstWater() {
		return againstWater;
	}

	public void setAgainstWater(Float againstWater) {
		this.againstWater = againstWater;
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

	public int getSpAttack() {
		return spAttack;
	}

	public void setSpAttack(int spAttack) {
		this.spAttack = spAttack;
	}

	public int getSpDefense() {
		return spDefense;
	}

	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Float getMalePercentage() {
		return malePercentage;
	}

	public void setMalePercentage(Float malePercentage) {
		this.malePercentage = malePercentage;
	}

	public int getCaptureRate() {
		return captureRate;
	}

	public void setCaptureRate(int captureRate) {
		this.captureRate = captureRate;
	}

	public int getBaseEggSteps() {
		return baseEggSteps;
	}

	public void setBaseEggSteps(int baseEggSteps) {
		this.baseEggSteps = baseEggSteps;
	}

	public int getBaseHappiness() {
		return baseHappiness;
	}

	public void setBaseHappiness(int baseHappiness) {
		this.baseHappiness = baseHappiness;
	}

	public int getBaseTotal() {
		return baseTotal;
	}

	public void setBaseTotal(int baseTotal) {
		this.baseTotal = baseTotal;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public int getExperienceGrowth() {
		return experienceGrowth;
	}

	public void setExperienceGrowth(int experienceGrowth) {
		this.experienceGrowth = experienceGrowth;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", japaneseName=" + japaneseName + ", firstType=" + firstType
				+ ", secondType=" + secondType + ", pokedexNumber=" + pokedexNumber + ", againstBug=" + againstBug
				+ ", againstDark=" + againstDark + ", againstDragon=" + againstDragon + ", againstElectric="
				+ againstElectric + ", againstFairy=" + againstFairy + ", againstFight=" + againstFight
				+ ", againstFire=" + againstFire + ", againstFlying=" + againstFlying + ", againstGhost=" + againstGhost
				+ ", againstGrass=" + againstGrass + ", againstGround=" + againstGround + ", againstIce=" + againstIce
				+ ", againstNormal=" + againstNormal + ", againstPoison=" + againstPoison + ", againstPsychic="
				+ againstPsychic + ", againstRock=" + againstRock + ", againstSteel=" + againstSteel + ", againstWater="
				+ againstWater + ", generation=" + generation + ", legendary=" + legendary + ", height=" + height
				+ ", weight=" + weight + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", spAttack="
				+ spAttack + ", spDefense=" + spDefense + ", speed=" + speed + ", classification=" + classification
				+ ", malePercentage=" + malePercentage + ", captureRate=" + captureRate + ", baseEggSteps="
				+ baseEggSteps + ", baseHappiness=" + baseHappiness + ", baseTotal=" + baseTotal + ", abilities="
				+ abilities + ", experienceGrowth=" + experienceGrowth + "]";
	}

	
}
