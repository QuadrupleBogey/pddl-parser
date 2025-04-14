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
public class BlocksWorldPb14IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb14.pddl";
    }

    @Test
    void blocksWorldProblem14HasCorrectName() {
        assertEquals("pb14", problem.getName());
    }

    @Test
    void blocksWorldProblem14HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem14Has14Objects() {
        assertEquals(14, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem14HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem14HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem14HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem14HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem14HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem14HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem14HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem14HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem14HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void blocksWorldProblem14HasObjectJ() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("j")));
    }

    @Test
    void blocksWorldProblem14HasObjectK() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("k")));
    }

    @Test
    void blocksWorldProblem14HasObjectL() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("l")));
    }

    @Test
    void blocksWorldProblem14HasObjectM() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("m")));
    }

    @Test
    void blocksWorldProblem14HasObjectN() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("n")));
    }

    @Test
    void blocksWorldProblem14Has29StateFormulas() {
        assertEquals(29, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableI() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("i"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("j"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableK() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("k"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableL() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("l"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableM() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("m"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasOnTableN() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("n"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearI() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("i"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearJ() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("j"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearK() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("k"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearL() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("l"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearM() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("m"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasClearN() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("n"))));
    }

    @Test
    void blocksWorldProblem14InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem14HasGoal() {
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
                        predicate("on", constant("j"), constant("k")),
                        predicate("on", constant("k"), constant("l")),
                        predicate("on", constant("l"), constant("m")),
                        predicate("on", constant("m"), constant("n"))));
        assertEquals(goal, problem.getGoal());
    }
}
