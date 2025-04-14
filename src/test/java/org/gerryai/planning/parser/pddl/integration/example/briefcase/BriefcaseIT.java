/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.integration.example.briefcase;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.Effect;
import org.gerryai.planning.model.domain.Precondition;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Briefcase example files are parsed correctly.
 */
public class BriefcaseIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/briefcase/briefcase.pddl";
    }

    @Test
    public void briefcaseDomainHasCorrectName() {
        assertEquals("briefcase", domain.getName());
    }

//    @Test
//    public void briefcaseDomainHasFiveRequirements() {
//        assertEquals(5, domain.getRequirements().size());
//    }

    @Test
    public void briefcaseDomainHasFourRequirements() {
        assertEquals(4, domain.getRequirements().size());
    }

    @Test
    public void briefcaseDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    public void briefcaseDomainHasTypingRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.TYPING));
    }

//    @Test
//    public void briefcaseDomainHasUniversalPreconditionsRequirement() {
//        assertTrue(domain.getRequirements().contains(Requirement.UNIVERSAL_PRECONDITIONS));
//    }

    @Test
    public void briefcaseDomainHasConditionalEffectsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.CONDITIONAL_EFFECTS));
    }

    @Test
    public void briefcaseDomainHasNegativePreconditionsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.NEGATIVE_PRECONDITIONS));
    }

    @Test
    public void briefcaseDomainHasTwoTypes() {
        assertEquals(2, domain.getTypes().size());
    }

    @Test
    public void briefcaseDomainHasTypePortable() {
        assertTrue(domain.getTypes().contains(typeDefinition("portable")));
    }

    @Test
    public void briefcaseDomainHasTypeLocation() {
        assertTrue(domain.getTypes().contains(typeDefinition("location")));
    }

    @Test
    public void briefcaseDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().size());
    }

    @Test
    public void briefcaseDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("y", type("portable"))
                .variable("x", type("location"))
                .build();
        assertTrue(domain.getPredicates().contains(at),
                "Domain contains the (at ?y - portable ?x - location) predicate");
    }

    @Test
    public void briefcaseDomainHasPredicateIn() {
        Predicate in = new Predicate.Builder()
                .name("in")
                .variable("x", type("portable"))
                .build();
        assertTrue(domain.getPredicates().contains(in), "Domain contains the (in ?x - portable) predicate");
    }

    @Test
    public void briefcaseDomainHasPredicateIsAt() {
        Predicate isAt = new Predicate.Builder()
                .name("is-at")
                .variable("x", type("location"))
                .build();
        assertTrue(domain.getPredicates().contains(isAt),
                "Domain contains the (is-at ?x - location) predicate");
    }

    @Test
    public void briefcaseDomainHasThreeActions() {
        assertEquals(3, domain.getActions().size());
    }

    @Test
    public void briefcaseDomainHasActionMove() {
        Action move = Action.builder()
                .name("move")
                .parameter(new Variable("m", type("location")))
                .parameter(new Variable("l", type("location")))
                .precondition(new Precondition(Optional.of(
                        predicate("is-at", variable("m"))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("is-at", variable("l")),
                                not(predicate("is-at", variable("m"))),
                                forAll(
                                        when(predicate("in", variable("x")))
                                                .then(and(
                                                        predicate("at", variable("x"), variable("l")),
                                                        not(predicate("at", variable("x"), variable("m"))))),
                                        variable("x", type("portable")))
                        )
                )))
                .build();
        assertTrue(domain.getActions().contains(move), "Domain contains the move action");
    }

    @Test
    public void briefcaseDomainHasActionTakeOut() {
        Action takeOut = Action.builder()
                .name("take-out")
                .parameter(new Variable("x", type("portable")))
                .precondition(new Precondition(Optional.of(
                        predicate("in", variable("x"))
                )))
                .effect(new Effect(Optional.of(
                        not(predicate("in", variable("x")))
                )))
                .build();
        assertTrue(domain.getActions().contains(takeOut), "Domain contains the take-out action");
    }

    @Test
    public void briefcaseDomainHasActionPutIn() {
        Action takeOut = Action.builder()
                .name("put-in")
                .parameter(new Variable("x", type("portable")))
                .parameter(new Variable("l", type("location")))
                .precondition(new Precondition(Optional.of(
                        and(
                                not(predicate("in", variable("x"))),
                                predicate("at", variable("x"), variable("l")),
                                predicate("is-at", variable("l")))
                )))
                .effect(new Effect(Optional.of(
                        predicate("in", variable("x"))
                )))
                .build();
        assertTrue(domain.getActions().contains(takeOut), "Domain contains the take-out action");
    }
}
