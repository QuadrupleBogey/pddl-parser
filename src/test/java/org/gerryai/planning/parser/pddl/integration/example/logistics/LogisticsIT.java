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
package org.gerryai.planning.parser.pddl.integration.example.logistics;

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
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.gerryai.planning.model.logic.FormulaBuilder.typeDefinition;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
public class LogisticsIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/logistics.pddl";
    }

    @Test
    void logisticsDomainHasCorrectName() {
        assertEquals("logistics", domain.getName());
    }

    @Test
    void logisticsDomainHasTwoRequirements() {
        assertEquals(2, domain.getRequirements().size());
    }

    @Test
    void logisticsDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    void logisticsDomainHasTypingRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.TYPING));
    }

    @Test
    void logisticsDomainHasSevenTypes() {
        assertEquals(7, domain.getTypes().size());
    }

    @Test
    void logisticsDomainHasTypePackage() {
        assertTrue(domain.getTypes().contains(typeDefinition("package")));
    }

    @Test
    void logisticsDomainHasTypeLocation() {
        assertTrue(domain.getTypes().contains(typeDefinition("location")));
    }

    @Test
    void logisticsDomainHasTypeVehicle() {
        assertTrue(domain.getTypes().contains(typeDefinition("vehicle")));
    }

    @Test
    void logisticsDomainHasTypeTruck() {
        assertTrue(domain.getTypes().contains(typeDefinition("truck", type("vehicle"))));
    }

    @Test
    void logisticsDomainHasTypeAirplane() {
        assertTrue(domain.getTypes().contains(typeDefinition("airplane", type("vehicle"))));
    }

    @Test
    void logisticsDomainHasTypeCity() {
        assertTrue(domain.getTypes().contains(typeDefinition("city", type("location"))));
    }

    @Test
    void logisticsDomainHasTypeAirport() {
        assertTrue(domain.getTypes().contains(typeDefinition("airport", type("location"))));
    }

    @Test
    void logisticsDomainHasThreePredicates() {
        assertEquals(3, domain.getPredicates().size());
    }

    @Test
    void logisticsDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("vehicle-or-package", type("vehicle", "package"))
                .variable("location", type("location"))
                .build();
        assertTrue(domain.getPredicates().contains(at),
                "Domain contains the (at ?vehicle-or-package - (either vehicle package)  ?location - location) "
                        + "predicate");
    }

    @Test
    void logisticsDomainHasPredicateIn() {
        Predicate in = new Predicate.Builder()
                .name("in")
                .variable("package", type("package"))
                .variable("vehicle", type("vehicle"))
                .build();
        assertTrue(domain.getPredicates().contains(in),
                "Domain contains the (in ?package - package ?vehicle - vehicle) predicate");
    }

    @Test
    void logisticsDomainHasPredicateInCity() {
        Predicate inCity = new Predicate.Builder()
                .name("in-city")
                .variable("loc-or-truck", type("location", "truck"))
                .variable("citys", type("city"))
                .build();
        assertTrue(domain.getPredicates().contains(inCity),
                "Domain contains the (in-city ?loc-or-truck - (either location truck) ?citys - city) predicate");
    }


    @Test
    void logisticsDomainHasSixActions() {
        assertEquals(6, domain.getActions().size());
    }

    @Test
    void logisticsDomainHasActionLoadTruck() {
        Action loadTruck = Action.builder()
                .name("load-truck")
                .parameter(new Variable("obj", type("package")))
                .parameter(new Variable("truck", type("truck")))
                .parameter(new Variable("loc", type("location")))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("at", variable("truck"), variable("loc")),
                                predicate("at", variable("obj"), variable("loc"))))
                ))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("at", variable("obj"), variable("loc"))),
                                predicate("in", variable("obj"), variable("truck"))))
                ))
                .build();
        assertTrue(domain.getActions().contains(loadTruck), "Domain contains the load-truck action");
    }

    @Test
    void logisticsDomainHasActionLoadAirplane() {
        Action loadAirplane = Action.builder()
                .name("load-airplane")
                .parameter(new Variable("obj", type("package")))
                .parameter(new Variable("airplane", type("airplane")))
                .parameter(new Variable("loc", type("airport")))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("at", variable("obj"), variable("loc")),
                                predicate("at", variable("airplane"), variable("loc"))))
                ))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("at", variable("obj"), variable("loc"))),
                                predicate("in", variable("obj"), variable("airplane"))))
                ))
                .build();
        assertTrue(domain.getActions().contains(loadAirplane), "Domain contains the load-airplane action");
    }

    @Test
    void logisticsDomainHasActionUnloadTruck() {
        Action unloadTruck = Action.builder()
                .name("unload-truck")
                .parameter(new Variable("obj", type("package")))
                .parameter(new Variable("truck", type("truck")))
                .parameter(new Variable("loc", type("location")))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("at", variable("truck"), variable("loc")),
                                predicate("in", variable("obj"), variable("truck"))))
                ))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("in", variable("obj"), variable("truck"))),
                                predicate("at", variable("obj"), variable("loc")))
                )))
                .build();
        assertTrue(domain.getActions().contains(unloadTruck), "Domain contains the unload-truck action");
    }

    @Test
    void logisticsDomainHasActionUnloadAirplane() {
        Action unloadAirplane = Action.builder()
                .name("unload-airplane")
                .parameter(new Variable("obj", type("package")))
                .parameter(new Variable("airplane", type("airplane")))
                .parameter(new Variable("loc", type("airport")))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("in", variable("obj"), variable("airplane")),
                                predicate("at", variable("airplane"), variable("loc"))))
                ))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("in", variable("obj"), variable("airplane"))),
                                predicate("at", variable("obj"), variable("loc"))))
                ))
                .build();
        assertTrue(domain.getActions().contains(unloadAirplane), "Domain contains the unload-airplane action");
    }

    @Test
    void logisticsDomainHasActionDriveTruck() {
        Action driveTruck = Action.builder()
                .name("drive-truck")
                .parameter(new Variable("truck", type("truck")))
                .parameter(new Variable("loc-from", type("location")))
                .parameter(new Variable("loc-to", type("location")))
                .parameter(new Variable("city", type("city")))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("at", variable("truck"), variable("loc-from")),
                                predicate("in-city", variable("loc-from"), variable("city")),
                                predicate("in-city", variable("loc-to"), variable("city"))))))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("at", variable("truck"), variable("loc-from"))),
                                predicate("at", variable("truck"), variable("loc-to"))))))
                .build();
        assertTrue(domain.getActions().contains(driveTruck), "Domain contains the drive-truck action");
    }

    @Test
    void logisticsDomainHasActionFryAirplane() {
        Action flyAirplane = Action.builder()
                .name("fly-airplane")
                .parameter(new Variable("airplane", type("airplane")))
                .parameter(new Variable("loc-from", type("airport")))
                .parameter(new Variable("loc-to", type("airport")))
                .precondition(new Precondition(Optional.of(
                        predicate("at", variable("airplane"), variable("loc-from")))))
                .effect(new Effect(Optional.of(
                        and(
                                not(predicate("at", variable("airplane"), variable("loc-from"))),
                                predicate("at", variable("airplane"), variable("loc-to")))
                )))
                .build();
        assertTrue(domain.getActions().contains(flyAirplane), "Domain contains the fly-airplane action");
    }
}
