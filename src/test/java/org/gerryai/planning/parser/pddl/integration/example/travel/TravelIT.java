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
package org.gerryai.planning.parser.pddl.integration.example.travel;

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
 * Integration test to check that the Travel example files are parsed correctly.
 */
public class TravelIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/travel.pddl";
    }

    @Test
     void travelDomainHasCorrectName() {
        assertEquals("bulldozer", domain.getName());
    }

    @Test
     void travelDomainHasThreeRequirements() {
        assertEquals(3, domain.getRequirements().size());
    }

    @Test
     void travelDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
     void travelDomainHasEqualityRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.EQUALITY));
    }

    @Test
     void travelDomainHasNegativePreconditionsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.NEGATIVE_PRECONDITIONS));
    }

    @Test
     void travelDomainHasSevenPredicates() {
        assertEquals(7, domain.getPredicates().size());
    }

    @Test
     void travelDomainHasPredicateRoad() {
        Predicate road = new Predicate.Builder()
                .name("road")
                .variable("from")
                .variable("to")
                .build();
        assertTrue(domain.getPredicates().contains(road), "Domain contains the (road ?from ?to) predicate");
    }

    @Test
     void travelDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("thing")
                .variable("place")
                .build();
        assertTrue(domain.getPredicates().contains(at), "Domain contains the (at ?thing ?place) predicate");
    }

    @Test
     void travelDomainHasPredicateMobile() {
        Predicate mobile = new Predicate.Builder()
                .name("mobile")
                .variable("thing")
                .build();
        assertTrue(domain.getPredicates().contains(mobile), "Domain contains the (mobile ?thing) predicate");
    }

    @Test
     void travelDomainHasPredicateBridge() {
        Predicate bridge = new Predicate.Builder()
                .name("bridge")
                .variable("from")
                .variable("to")
                .build();
        assertTrue(domain.getPredicates().contains(bridge), "Domain contains the (bridge ?from ?to) predicate");
    }

    @Test
     void travelDomainHasPredicatePerson() {
        Predicate person = new Predicate.Builder()
                .name("person")
                .variable("p")
                .build();
        assertTrue(domain.getPredicates().contains(person), "Domain contains the (person ?p) predicate");
    }

    @Test
     void travelDomainHasPredicateVehicle() {
        Predicate vehicle = new Predicate.Builder()
                .name("vehicle")
                .variable("v")
                .build();
        assertTrue(domain.getPredicates().contains(vehicle), "Domain contains the (vehicle ?v) predicate");
    }

    @Test
     void travelDomainHasPredicateDriving() {
        Predicate driving = new Predicate.Builder()
                .name("driving")
                .variable("p")
                .variable("v")
                .build();
        assertTrue(domain.getPredicates().contains(driving), "Domain contains the (driving ?p ?v) predicate");
    }

    @Test
     void travelDomainHasFourActions() {
        assertEquals(4, domain.getActions().size());
    }

    @Test
     void travelDomainHasActionDrive() {
        Action drive = Action.builder()
                .name("drive")
                .parameter(new Variable("thing"))
                .parameter(new Variable("from"))
                .parameter(new Variable("to"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("road", variable("from"), variable("to")),
                                predicate("at", variable("thing"), variable("from")),
                                predicate("mobile", variable("thing")),
                                not(equality(variable("from"), variable("to"))))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", variable("thing"), variable("to")),
                                not(predicate("at", variable("thing"), variable("from"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(drive), "Domain contains the Drive action");
    }

    @Test
     void travelDomainHasActionCross() {
        Action cross = Action.builder()
                .name("cross")
                .parameter(new Variable("thing"))
                .parameter(new Variable("from"))
                .parameter(new Variable("to"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("bridge", variable("from"), variable("to")),
                                predicate("at", variable("thing"), variable("from")),
                                predicate("mobile", variable("thing")),
                                not(equality(variable("from"), variable("to"))))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", variable("thing"), variable("to")),
                                not(predicate("at", variable("thing"), variable("from"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(cross), "Domain contains the Cross action");
    }

    @Test
     void travelDomainHasActionBoard() {
        Action board = Action.builder()
                .name("board")
                .parameter(new Variable("person"))
                .parameter(new Variable("place"))
                .parameter(new Variable("vehicle"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("at", variable("person"), variable("place")),
                                predicate("person", variable("person")),
                                predicate("vehicle", variable("vehicle")),
                                predicate("at", variable("vehicle"), variable("place")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("driving", variable("person"), variable("vehicle")),
                                predicate("mobile", variable("vehicle")),
                                not(predicate("at", variable("person"), variable("place"))),
                                not(predicate("mobile", variable("person"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(board), "Domain contains the Board action");
    }

    @Test
     void travelDomainHasActionDisembark() {
        Action disembark = Action.builder()
                .name("disembark")
                .parameter(new Variable("person"))
                .parameter(new Variable("place"))
                .parameter(new Variable("vehicle"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("person", variable("person")),
                                predicate("vehicle", variable("vehicle")),
                                predicate("driving", variable("person"), variable("vehicle")),
                                predicate("at", variable("vehicle"), variable("place")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", variable("person"), variable("place")),
                                predicate("mobile", variable("person")),
                                not(predicate("driving", variable("person"), variable("vehicle"))),
                                not(predicate("mobile", variable("vehicle"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(disembark), "Domain contains the Disembark action");
    }
}
