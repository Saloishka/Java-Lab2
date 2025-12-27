import java.util.Objects;

/**
 * Domain model representing a chthonic creature with identifying attributes and attack power
 */
public class ChthonicCreature {

    private final String name;
    private final String species;      //  A
    private final int yearsKnown;       //  Б
    private final String creatureType;  //  В
    private final double attackPower;   //  Г

    public ChthonicCreature(
            String name,
            String species,
            int yearsKnown,
            String creatureType,
            double attackPower) {
        this.name = name;
        this.species = species;
        this.yearsKnown = yearsKnown;
        this.creatureType = creatureType;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public int getYearsKnown() {
        return yearsKnown;
    }
    public String getCreatureType() {
        return creatureType;
    }
    public double getAttackPower() {
        return attackPower;
    }
    @Override
    public String toString() {
        return name + " (" + species + "), attack=" + attackPower;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChthonicCreature)) return false;
        ChthonicCreature that = (ChthonicCreature) o;
        return yearsKnown == that.yearsKnown
                && Double.compare(that.attackPower, attackPower) == 0
                && Objects.equals(name, that.name)
                && Objects.equals(species, that.species)
                && Objects.equals(creatureType, that.creatureType);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, species, yearsKnown, creatureType, attackPower);
    }
}
