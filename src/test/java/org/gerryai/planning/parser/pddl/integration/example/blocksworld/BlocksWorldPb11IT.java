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
public class BlocksWorldPb11IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb11.pddl";
    }

    @Test
    void blocksWorldProblem11HasCorrectName() {
        assertEquals("pb11", problem.getName());
    }

    @Test
    void blocksWorldProblem11HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem11Has11Objects() {
        assertEquals(11, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem11HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem11HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem11HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem11HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem11HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem11HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem11HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem11HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem11HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void blocksWorldProblem11HasObjectJ() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("j")));
    }

    @Test
    void blocksWorldProblem11HasObjectK() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("k")));
    }

    @Test
    void blocksWorldProblem11Has23StateFormulas() {
        assertEquals(23, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableI() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("i"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("j"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasOnTableK() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("k"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearI() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("i"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearJ() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("j"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasClearK() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("k"))));
    }

    @Test
    void blocksWorldProblem11InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem11HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("a"), constant("b")),
                        predicate("on", constant("b"), constant("c")),
                        predicate("on", constant("c"), constant("d")),
                        predicate("on", constant("d"), constant("e")),
                        predicate("on", constant("e"), constant("f")),
                        predicate("on", constant("f"), constant("g")),
                        predicate("on", constant("g"), constant("h")),
                        predicate("on", constant("h"), constant("i")),
                        predicate("on", constant("i"), constant("j")),
                        predicate("on", constant("j"), constant("k"))));
        assertEquals(goal, problem.getGoal());
    }
}
