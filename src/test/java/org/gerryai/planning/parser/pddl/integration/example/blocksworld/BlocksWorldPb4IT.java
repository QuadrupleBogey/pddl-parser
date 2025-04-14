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
package org.gerryai.planning.parser.pddl.integration.example.blocksworld;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.jupiter.api.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.and;
import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class BlocksWorldPb4IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb4.pddl";
    }

    @Test
    void blocksWorldProblem4HasCorrectName() {
        assertEquals("pb4", problem.getName());
    }

    @Test
    void blocksWorldProblem4HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem4Has4Objects() {
        assertEquals(4, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem4HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem4HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem4HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem4HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem4Has6StateFormulas() {
        assertEquals(6, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem4InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem4InitialStateHasOnBA() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("b"), constant("a"))));
    }

    @Test
    void blocksWorldProblem4InitialStateHasOnCB() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("c"), constant("b"))));
    }

    @Test
    void blocksWorldProblem4InitialStateHasOnDC() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("d"), constant("c"))));
    }

    @Test
    void blocksWorldProblem4InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem4InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem4HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("b"), constant("a")),
                        predicate("on", constant("c"), constant("b")),
                        predicate("on", constant("a"), constant("d"))));
        assertEquals(goal, problem.getGoal());
    }
}
