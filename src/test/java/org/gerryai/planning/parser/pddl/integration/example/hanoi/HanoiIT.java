/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General  License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General  License for more details.
 *
 * You should have received a copy of the GNU General  License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.integration.example.hanoi;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.Effect;
import org.gerryai.planning.model.domain.Precondition;
import org.gerryai.planning.model.logic.Predicate;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.gerryai.planning.model.logic.FormulaBuilder.and;
import static org.gerryai.planning.model.logic.FormulaBuilder.not;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Hanoi example files are parsed correctly.
 */
public class HanoiIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/hanoi.pddl";
    }

    @Test
    void hanoiDomainHasCorrectName() {
        assertEquals("hanoi", domain.getName());
    }

    @Test
    void hanoiDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().size());
    }

    @Test
    void hanoiDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    void hanoiDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().size());
    }

    @Test
    void hanoiDomainHasPredicateClear() {
        Predicate clear = new Predicate.Builder()
                .name("clear")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(clear), "Domain contains the (clear ?x) predicate");
    }

    @Test
    void hanoiDomainHasPredicateOn() {
        Predicate on = new Predicate.Builder()
                .name("on")
                .variable("x")
                .variable("y")
                .build();
        assertTrue(domain.getPredicates().contains(on), "Domain contains the (on ?x ?y) predicate");
    }

    @Test
    void hanoiDomainHasPredicateSmaller() {
        Predicate smaller = new Predicate.Builder()
                .name("smaller")
                .variable("x")
                .variable("y")
                .build();
        assertTrue(domain.getPredicates().contains(smaller), "Domain contains the (smaller ?x ?y) predicate");
    }

    @Test
    void hanoiDomainHasOneAction() {
        assertEquals(1, domain.getActions().size());
    }

    @Test
    void hanoiDomainHasActionMove() {
        Action move = Action.builder()
                .name("move")
                .parameter(new Variable("disc"))
                .parameter(new Variable("from"))
                .parameter(new Variable("to"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("smaller", variable("to"), variable("disc")),
                                predicate("on", variable("disc"), variable("from")),
                                predicate("clear", variable("disc")),
                                predicate("clear", variable("to")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("clear", variable("from")),
                                predicate("on", variable("disc"), variable("to")),
                                not(predicate("on", variable("disc"), variable("from"))),
                                not(predicate("clear", variable("to"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(move), "Domain contains the move action");
    }
}
