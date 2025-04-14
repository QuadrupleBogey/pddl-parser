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
public class BlocksWorldPb5IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb5.pddl";
    }

    @Test
    void blocksWorldProblem5HasCorrectName() {
        assertEquals("pb5", problem.getName());
    }

    @Test
    void blocksWorldProblem5HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem5Has5Objects() {
        assertEquals(5, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem5HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem5HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem5HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem5HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem5HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem5Has11StateFormulas() {
        assertEquals(11, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem5InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem5InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem5HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e"))));
        assertEquals(goal, problem.getGoal());
    }
}
