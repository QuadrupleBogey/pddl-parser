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

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.jupiter.api.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that PDDL parsing is case-insensitive.
 */
public class CaseInsensitiveProblemIT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/case-insensitive-problem.pddl";
    }

    @Test
    void testProblemHasLowerCaseName() {
        assertEquals("test", problem.getName());
    }

    @Test
    void testProblemHasLowerCaseDomainName() {
        assertEquals("test", problem.getDomainName());
    }

    @Test
    void testProblemHasObjectTest1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("test1", type("testtype"))), "Problem contains the test object");
    }

    @Test
    void testProblemHasObjectTest2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("test2", type("testtype1", "testtype2"))), "Problem contains the test object");
    }

    @Test
    void testProblemHasGoal() {
        Goal goal = new Goal(predicate("test", constant("a"), constant("b")));
        assertEquals(goal, problem.getGoal());
    }
}
