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
public class BlocksWorldPb15IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb15.pddl";
    }

    @Test
    void blocksWorldProblem15HasCorrectName() {
        assertEquals("pb15", problem.getName());
    }

    @Test
    void blocksWorldProblem15HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem15Has15Objects() {
        assertEquals(15, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem15HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem15HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem15HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem15HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem15HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem15HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem15HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem15HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem15HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void blocksWorldProblem15HasObjectJ() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("j")));
    }

    @Test
    void blocksWorldProblem15HasObjectK() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("k")));
    }

    @Test
    void blocksWorldProblem15HasObjectL() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("l")));
    }

    @Test
    void blocksWorldProblem15HasObjectM() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("m")));
    }

    @Test
    void blocksWorldProblem15HasObjectN() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("n")));
    }

    @Test
    void blocksWorldProblem15HasObjectO() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("o")));
    }

    @Test
    void blocksWorldProblem15Has31StateFormulas() {
        assertEquals(31, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableI() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("i"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("j"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableK() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("k"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableL() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("l"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableM() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("m"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableN() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("n"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasOnTableO() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("o"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearI() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("i"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearJ() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("j"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearK() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("k"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearL() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("l"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearM() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("m"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearN() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("n"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasClearO() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("o"))));
    }

    @Test
    void blocksWorldProblem15InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem15HasGoal() {
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
                        predicate("on", constant("m"), constant("n")),
                        predicate("on", constant("n"), constant("o"))));
        assertEquals(goal, problem.getGoal());
    }
}
