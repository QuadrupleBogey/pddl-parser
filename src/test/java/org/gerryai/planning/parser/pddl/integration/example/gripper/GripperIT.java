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
package org.gerryai.planning.parser.pddl.integration.example.gripper;

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
 * Integration test to check that the Gripper example files are parsed correctly.
 */
public class GripperIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/gripper/gripper.pddl";
    }

    @Test
     void gripperDomainHasCorrectName() {
        assertEquals("gripper", domain.getName());
    }

    @Test
     void gripperDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().size());
    }

    @Test
     void gripperDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
     void gripperDomainHasSevenPredicates() {
        assertEquals(7, domain.getPredicates().size());
    }

    @Test
     void gripperDomainHasPredicateRoom() {
        Predicate room = new Predicate.Builder()
                .name("room")
                .variable("r")
                .build();
        assertTrue(domain.getPredicates().contains(room), "Domain contains the (room ?r) predicate");
    }

    @Test
     void gripperDomainHasPredicateBall() {
        Predicate ball = new Predicate.Builder()
                .name("ball")
                .variable("b")
                .build();
        assertTrue(domain.getPredicates().contains(ball), "Domain contains the (ball ?b) predicate");
    }

    @Test
     void gripperDomainHasPredicateGripper() {
        Predicate ball = new Predicate.Builder()
                .name("gripper")
                .variable("g")
                .build();
        assertTrue(domain.getPredicates().contains(ball), "Domain contains the (gripper ?g) predicate");
    }

    @Test
     void gripperDomainHasPredicateAtRobby() {
        Predicate atRobby = new Predicate.Builder()
                .name("at-robby")
                .variable("r")
                .build();
        assertTrue(domain.getPredicates().contains(atRobby), "Domain contains the (at-robby ?r) predicate");
    }

    @Test
     void gripperDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("b")
                .variable("r")
                .build();
        assertTrue(domain.getPredicates().contains(at), "Domain contains the (at ?b ?r) predicate");
    }

    @Test
     void gripperDomainHasPredicateFree() {
        Predicate free = new Predicate.Builder()
                .name("free")
                .variable("g")
                .build();
        assertTrue(domain.getPredicates().contains(free), "Domain contains the (free ?g) predicate");
    }

    @Test
     void gripperDomainHasPredicateCarry() {
        Predicate carry = new Predicate.Builder()
                .name("carry")
                .variable("o")
                .variable("g")
                .build();
        assertTrue(domain.getPredicates().contains(carry), "Domain contains the (carry ?o ?g) predicate");
    }

    @Test
     void gripperDomainHasThreeActions() {
        assertEquals(3, domain.getActions().size());
    }

    @Test
     void gripperDomainHasActionMove() {
        Action move = Action.builder()
                .name("move")
                .parameter(new Variable("from"))
                .parameter(new Variable("to"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("room", variable("from")),
                                predicate("room", variable("to")),
                                predicate("at-robby", variable("from")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at-robby", variable("to")),
                                not(predicate("at-robby", variable("from"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(move), "Domain contains the move action");
    }

    @Test
     void gripperDomainHasActionPick() {
        Action pick = Action.builder()
                .name("pick")
                .parameter(new Variable("obj"))
                .parameter(new Variable("room"))
                .parameter(new Variable("gripper"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("ball", variable("obj")),
                                predicate("room", variable("room")),
                                predicate("gripper", variable("gripper")),
                                predicate("at", variable("obj"), variable("room")),
                                predicate("at-robby", variable("room")),
                                predicate("free", variable("gripper")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("carry", variable("obj"), variable("gripper")),
                                not(predicate("at", variable("obj"), variable("room"))),
                                not(predicate("free", variable("gripper"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(pick), "Domain contains the pick action");
    }

    @Test
     void gripperDomainHasActionDrop() {
        Action pick = Action.builder()
                .name("drop")
                .parameter(new Variable("obj"))
                .parameter(new Variable("room"))
                .parameter(new Variable("gripper"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("ball", variable("obj")),
                                predicate("room", variable("room")),
                                predicate("gripper", variable("gripper")),
                                predicate("carry", variable("obj"), variable("gripper")),
                                predicate("at-robby", variable("room")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", variable("obj"), variable("room")),
                                predicate("free", variable("gripper")),
                                not(predicate("carry", variable("obj"), variable("gripper"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(pick), "Domain contains the pick action");
    }
}
