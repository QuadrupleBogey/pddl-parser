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
package org.gerryai.planning.parser.pddl.integration.general.success;

import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.Effect;
import org.gerryai.planning.model.domain.Precondition;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.gerryai.planning.model.logic.FormulaBuilder.constantDefinition;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.gerryai.planning.model.logic.FormulaBuilder.typeDefinition;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that PDDL parsing is case-insensitive.
 */
public class CaseInsensitiveDomainIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/case-insensitive-domain.pddl";
    }

    @Test
    void testDomainHasLowerCaseDomainName() {
        assertEquals("test", domain.getName());
    }

    @Test
    void testDomainHasConstantTestConst() {
        assertTrue(domain.getConstants().contains(constantDefinition("testconst", type("testconst2"))), "Domain contains constant testconst");
    }

    @Test
    void testDomainHasConstantTestConst2() {
        assertTrue(domain.getConstants().contains(constantDefinition("testconst2")), "Domain contains constant testconst2");
    }

    @Test
    void testDomainHasPredicateTestType() {
        assertTrue(domain.getTypes().contains(typeDefinition("testtype", type("testtype2"))), "Domain contains type testtype");
    }

    @Test
    void testDomainHasPredicateTestType1() {
        assertTrue(domain.getTypes().contains(typeDefinition("testtype1", type("testtype2"))), "Domain contains type testtype1");
    }

    @Test
    void testDomainHasPredicateTestType2() {
        assertTrue(domain.getTypes().contains(typeDefinition("testtype2")), "Domain contains type testtype2");
    }

    @Test
    void testDomainHasPredicateTest1() {
        assertTrue(domain.getPredicates().contains(predicate("test1", variable("x"))), "Domain contains the test1 predicate");
    }

    @Test
    void testDomainHasPredicateTest2() {
        assertTrue(domain.getPredicates().contains(predicate("test2", variable("x", type("testtype")))), "Domain contains the test2 predicate");
    }

    @Test
    void testDomainHasPredicateTest3() {
        assertTrue(domain.getPredicates().contains(predicate("test3", variable("x", type("testtype1", "testtype2")))), "Domain contains the test3 predicate");
    }

    @Test
    void testDomainHasActionTest() {
        Action testing = Action.builder()
                .name("test")
                .parameter(new Variable("x"))
                .precondition(new Precondition(Optional.ofNullable(predicate("test", variable("x")))))
                .effect(new Effect(Optional.empty()))
                .build();
        assertTrue(domain.getActions().contains(testing), "Domain contains the test action");
    }
}
