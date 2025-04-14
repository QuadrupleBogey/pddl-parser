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
package org.gerryai.planning.parser.pddl.integration.example.blocksworld;

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
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class BlocksWorldIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/blocksworld.pddl";
    }

    @Test
    public void blocksWorldDomainHasCorrectName() {
        assertEquals("blocksworld", domain.getName());
    }

    @Test
    public void blocksWorldDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().size());
    }

    @Test
    public void blocksWorldDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    public void blocksWorldDomainHasFivePredicates() {
        assertEquals(5, domain.getPredicates().size());
    }

    @Test
    public void blocksWorldDomainHasPredicateClear() {
        Predicate clear = new Predicate.Builder()
                .name("clear")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(clear), "Domain contains the (clear ?x) predicate");
    }

    @Test
    public void blocksWorldDomainHasPredicateOnTable() {
        Predicate onTable = new Predicate.Builder()
                .name("on-table")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(onTable), "Domain contains the (on-table ?x) predicate");
    }

    @Test
    public void blocksWorldDomainHasPredicateArmEmpty() {
        Predicate armEmpty = new Predicate.Builder()
                .name("arm-empty")
                .build();
        assertTrue(domain.getPredicates().contains(armEmpty), "Domain contains the (arm-empty) predicate");
    }

    @Test
    public void blocksWorldDomainHasPredicateHolding() {
        Predicate holding = new Predicate.Builder()
                .name("holding")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(holding), "Domain contains the (holding ?x) predicate");
    }

    @Test
    public void blocksWorldDomainHasPredicateOn() {
        Predicate on = new Predicate.Builder()
                .name("on")
                .variable("x")
                .variable("y")
                .build();
        assertTrue(domain.getPredicates().contains(on), "Domain contains the (on ?x ?y) predicate");
    }

    @Test
    public void blocksWorldDomainHasFourActions() {
        assertEquals(4, domain.getActions().size());
    }

    @Test
    public void blocksWorldDomainHasActionPickup() {
        Action pickup = Action.builder()
                .name("pickup")
                .parameter(new Variable("ob"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("clear", variable("ob")),
                                predicate("on-table", variable("ob")),
                                predicate("arm-empty"))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("holding", variable("ob")),
                                not(predicate("clear", variable("ob"))),
                                not(predicate("on-table", variable("ob"))),
                                not(predicate("arm-empty")))
                )))
                .build();
        assertTrue(domain.getActions().contains(pickup), "Domain contains the pickup action");
    }

    @Test
    public void blocksWorldDomainHasActionPutDown() {
        Action putDown = Action.builder()
                .name("putdown")
                .parameter(new Variable("ob"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("holding", variable("ob")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("clear", variable("ob")),
                                predicate("arm-empty"),
                                predicate("on-table", variable("ob")),
                                not(predicate("holding", variable("ob"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(putDown), "Domain contains the putdown action");
    }

    @Test
    public void blocksWorldDomainHasActionStack() {
        Action stack = Action.builder()
                .name("stack")
                .parameter(new Variable("ob"))
                .parameter(new Variable("underob"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("clear", variable("underob")),
                                predicate("holding", variable("ob")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("arm-empty"),
                                predicate("clear", variable("ob")),
                                predicate("on", variable("ob"), variable("underob")),
                                not(predicate("clear", variable("underob"))),
                                not(predicate("holding", variable("ob"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(stack), "Domain contains the stack action");
    }

    @Test
    public void blocksWorldDomainHasActionUnstack() {
        Action unstack = Action.builder()
                .name("unstack")
                .parameter(new Variable("ob"))
                .parameter(new Variable("underob"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("on", variable("ob"), variable("underob")),
                                predicate("clear", variable("ob")),
                                predicate("arm-empty"))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("holding", variable("ob")),
                                predicate("clear", variable("underob")),
                                not(predicate("on", variable("ob"), variable("underob"))),
                                not(predicate("clear", variable("ob"))),
                                not(predicate("arm-empty")))
                )))
                .build();
        assertTrue(domain.getActions().contains(unstack), "Domain contains the unstack action");
    }
}
