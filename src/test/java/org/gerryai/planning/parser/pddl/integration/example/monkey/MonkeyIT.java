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
package org.gerryai.planning.parser.pddl.integration.example.monkey;

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
import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.constantDefinition;
import static org.gerryai.planning.model.logic.FormulaBuilder.not;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Monkey example files are parsed correctly.
 */
class MonkeyIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/monkey/monkey.pddl";
    }

    @Test
    void monkeyDomainHasCorrectName() {
        assertEquals("monkey", domain.getName());
    }

    @Test
    void monkeyDomainHasOneRequirement() {
        assertEquals(1, domain.getRequirements().size());
    }

    @Test
    void monkeyDomainHasStripsRequirement() {
        assertTrue(domain.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    void monkeyDomainHasSixConstants() {
        assertEquals(6, domain.getConstants().size());
    }

    @Test
    void monkeyDomainHasConstantMonkey() {
        assertTrue(domain.getConstants().contains(constantDefinition("monkey")));
    }

    @Test
    void monkeyDomainHasConstantBox() {
        assertTrue(domain.getConstants().contains(constantDefinition("box")));
    }

    @Test
    void monkeyDomainHasConstantKnife() {
        assertTrue(domain.getConstants().contains(constantDefinition("knife")));
    }

    @Test
    void monkeyDomainHasConstantBananas() {
        assertTrue(domain.getConstants().contains(constantDefinition("bananas")));
    }

    @Test
    void monkeyDomainHasConstantGlass() {
        assertTrue(domain.getConstants().contains(constantDefinition("glass")));
    }

    @Test
    void monkeyDomainHasConstantWaterFountain() {
        assertTrue(domain.getConstants().contains(constantDefinition("waterfountain")));
    }

    @Test
    void monkeyDomainHasEightPredicates() {
        assertEquals(8, domain.getPredicates().size());
    }

    @Test
    void monkeyDomainHasPredicateLocation() {
        Predicate location = new Predicate.Builder()
                .name("location")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(location), "Domain contains the (location ?x) predicate");
    }

    @Test
    void monkeyDomainHasPredicateOnFloor() {
        Predicate onFloor = new Predicate.Builder()
                .name("on-floor")
                .build();
        assertTrue(domain.getPredicates().contains(onFloor), "Domain contains the (on-floor) predicate");
    }

    @Test
    void monkeyDomainHasPredicateAt() {
        Predicate at = new Predicate.Builder()
                .name("at")
                .variable("m")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(at), "Domain contains the (at ?m ?x) predicate");
    }

    @Test
    void monkeyDomainHasPredicateHasKnife() {
        Predicate hasKnife = new Predicate.Builder()
                .name("hasknife")
                .build();
        assertTrue(domain.getPredicates().contains(hasKnife), "Domain contains the (hasknife) predicate");
    }

    @Test
    void monkeyDomainHasPredicateOnBox() {
        Predicate onbox = new Predicate.Builder()
                .name("onbox")
                .variable("x")
                .build();
        assertTrue(domain.getPredicates().contains(onbox), "Domain contains the (onbox ?x) predicate");
    }

    @Test
    void monkeyDomainHasPredicateHasBananas() {
        Predicate hasBananas = new Predicate.Builder()
                .name("hasbananas")
                .build();
        assertTrue(domain.getPredicates().contains(hasBananas), "Domain contains the (hasbananas) predicate");
    }

    @Test
    void monkeyDomainHasPredicateHasGlass() {
        Predicate hasGlass = new Predicate.Builder()
                .name("hasglass")
                .build();
        assertTrue(domain.getPredicates().contains(hasGlass), "Domain contains the (hasglass) predicate");
    }

    @Test
    void monkeyDomainHasPredicateHasWater() {
        Predicate hasWater = new Predicate.Builder()
                .name("haswater")
                .build();
        assertTrue(domain.getPredicates().contains(hasWater), "Domain contains the (haswater) predicate");
    }

    @Test
    void monkeyDomainHasSevenActions() {
        assertEquals(7, domain.getActions().size());
    }

    @Test
    void monkeyDomainHasActionGoTo() {
        Action goTo = Action.builder()
                .name("go-to")
                .parameter(new Variable("x"))
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("x")),
                                predicate("location", variable("y")),
                                predicate("on-floor"),
                                predicate("at", constant("monkey"), variable("y")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", constant("monkey"), variable("x")),
                                not(predicate("at", constant("monkey"), variable("y"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(goTo), "Domain contains the GO-TO action");
    }

    @Test
    void monkeyDomainHasActionClimb() {
        Action climb = Action.builder()
                .name("climb")
                .parameter(new Variable("x"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("x")),
                                predicate("at", constant("box"), variable("x")),
                                predicate("at", constant("monkey"), variable("x")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("onbox", variable("x")),
                                not(predicate("on-floor")))
                )))
                .build();
        assertTrue(domain.getActions().contains(climb), "Domain contains the CLIMB action");
    }

    @Test
    void monkeyDomainHasActionPushBox() {
        Action pushBox = Action.builder()
                .name("push-box")
                .parameter(new Variable("x"))
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("x")),
                                predicate("location", variable("y")),
                                predicate("at", constant("box"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")),
                                predicate("on-floor"))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("at", constant("monkey"), variable("x")),
                                not(predicate("at", constant("monkey"), variable("y"))),
                                predicate("at", constant("box"), variable("x")),
                                not(predicate("at", constant("box"), variable("y"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(pushBox), "Domain contains the PUSH-BOX action");
    }

    @Test
    void monkeyDomainHasActionGetKnife() {
        Action getKnife = Action.builder()
                .name("get-knife")
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("y")),
                                predicate("at", constant("knife"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("hasknife"),
                                not(predicate("at", constant("knife"), variable("y"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(getKnife), "Domain contains the GET-KNIFE action");
    }

    @Test
    void monkeyDomainHasActionGrabBananas() {
        Action grabBananas = Action.builder()
                .name("grab-bananas")
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("y")),
                                predicate("hasknife"),
                                predicate("at", constant("bananas"), variable("y")),
                                predicate("onbox", variable("y")))
                )))
                .effect(new Effect(Optional.of(
                        predicate("hasbananas")
                )))
                .build();
        assertTrue(domain.getActions().contains(grabBananas), "Domain contains the GRAB-BANANAS action");
    }

    @Test
    void monkeyDomainHasActionPickGlass() {
        Action pickGlass = Action.builder()
                .name("pickglass")
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("y")),
                                predicate("at", constant("glass"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")))
                )))
                .effect(new Effect(Optional.of(
                        and(
                                predicate("hasglass"),
                                not(predicate("at", constant("glass"), variable("y"))))
                )))
                .build();
        assertTrue(domain.getActions().contains(pickGlass), "Domain contains the PICKGLASS action");
    }

    @Test
    void monkeyDomainHasActionGetWater() {
        Action getWater = Action.builder()
                .name("getwater")
                .parameter(new Variable("y"))
                .precondition(new Precondition(Optional.of(
                        and(
                                predicate("location", variable("y")),
                                predicate("hasglass"),
                                predicate("at", constant("waterfountain"), variable("y")),
                                predicate("at", constant("monkey"), variable("y")),
                                predicate("onbox", variable("y")))
                )))
                .effect(new Effect(Optional.of(
                        predicate("haswater")
                )))
                .build();
        assertTrue(domain.getActions().contains(getWater), "Domain contains the GETWATER action");
    }
}
