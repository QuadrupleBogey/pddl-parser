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
public class BlocksWorldPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb3.pddl";
    }

    @Test
    void blocksWorldProblem3HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    void blocksWorldProblem3HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem3Has3Objects() {
        assertEquals(3, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem3HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem3HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem3HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem3Has7StateFormulas() {
        assertEquals(7, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem3InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem3InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem3HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c"))));
        assertEquals(goal, problem.getGoal());
    }
}
