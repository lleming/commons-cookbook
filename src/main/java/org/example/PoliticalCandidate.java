package org.example;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class PoliticalCandidate {
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private BigDecimal moneyRaised;
    private State hostState;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getMoneyRaised() {
        return moneyRaised;
    }

    public void setMoneyRaised(BigDecimal moneyRaised) {
        this.moneyRaised = moneyRaised;
    }

    public State getHostState() {
        return hostState;
    }

    public void setHostState(State hostState) {
        this.hostState = hostState;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static class State {
        private String name;
        private long population;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(13, 31)
                    .append(this.getName())
                    .append(this.getPopulation())
                    .toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            boolean equals = false;
            if (obj != null && PoliticalCandidate.State.class.isAssignableFrom(obj.getClass())) {
                PoliticalCandidate.State state = (State) obj;
                equals = new EqualsBuilder()
                        .append(this.population, state.getPopulation())
                        .append(this.name, state.getName())
                        .isEquals();
            }
            return equals;
        }

    }
}
