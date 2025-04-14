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
public class BlocksWorldPb8IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb8.pddl";
    }

    @Test
    void blocksWorldProblem8HasCorrectName() {
        assertEquals("tower8", problem.getName());
    }

    @Test
    void blocksWorldProblem8HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem8Has8Objects() {
        assertEquals(8, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem8HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem8HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem8HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem8HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem8HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem8HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem8HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem8HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem8Has15StateFormulas() {
        assertEquals(17, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem8InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem8HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e")),
                        predicate("on", constant("e"), constant("f")),
                        predicate("on", constant("f"), constant("g")),
                        predicate("on", constant("g"), constant("h"))));
        assertEquals(goal, problem.getGoal());
    }
}
