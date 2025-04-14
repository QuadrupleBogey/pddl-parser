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
public class BlocksWorldPb9IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb9.pddl";
    }

    @Test
    void blocksWorldProblem9HasCorrectName() {
        assertEquals("tower9", problem.getName());
    }

    @Test
    void blocksWorldProblem9HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem9Has9Objects() {
        assertEquals(9, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem9HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem9HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem9HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem9HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem9HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem9HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem9HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem9HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem9HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void blocksWorldProblem9Has19StateFormulas() {
        assertEquals(19, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasOnTableI() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("i"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasClearI() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("i"))));
    }

    @Test
    void blocksWorldProblem9InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem9HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e")),
                        predicate("on", constant("e"), constant("f")),
                        predicate("on", constant("f"), constant("g")),
                        predicate("on", constant("g"), constant("h")),
                        predicate("on", constant("h"), constant("i"))));
        assertEquals(goal, problem.getGoal());
    }
}
