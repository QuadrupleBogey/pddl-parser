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
public class BlocksWorldPb13IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/blocksworld/pb13.pddl";
    }

    @Test
    void blocksWorldProblem13HasCorrectName() {
        assertEquals("pb13", problem.getName());
    }

    @Test
    void blocksWorldProblem13HasCorrectDomain() {
        assertEquals("blocksworld", problem.getDomainName());
    }

    @Test
    void blocksWorldProblem13Has13bjects() {
        assertEquals(13, problem.getObjects().size());
    }

    @Test
    void blocksWorldProblem13HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void blocksWorldProblem13HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void blocksWorldProblem13HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void blocksWorldProblem13HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void blocksWorldProblem13HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void blocksWorldProblem13HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void blocksWorldProblem13HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void blocksWorldProblem13HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void blocksWorldProblem13HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void blocksWorldProblem13HasObjectJ() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("j")));
    }

    @Test
    void blocksWorldProblem13HasObjectK() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("k")));
    }

    @Test
    void blocksWorldProblem13HasObjectL() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("l")));
    }

    @Test
    void blocksWorldProblem13HasObjectM() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("m")));
    }

    @Test
    void blocksWorldProblem13Has27StateFormulas() {
        assertEquals(27, problem.getInitialStates().size());
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableA() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("a"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableB() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("b"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableC() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("c"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableD() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("d"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableE() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("e"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableF() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("f"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableG() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("g"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableH() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("h"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableI() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("i"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableJ() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("j"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableK() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("k"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableL() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("l"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasOnTableM() {
        assertTrue(problem.getInitialStates().contains(predicate("on-table", constant("m"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearA() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("a"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearB() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("b"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearC() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("c"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearD() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearE() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("e"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearF() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("f"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearG() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("g"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearH() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("h"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearI() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("i"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearJ() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("j"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearK() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("k"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearL() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("l"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasClearM() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("m"))));
    }

    @Test
    void blocksWorldProblem13InitialStateHasArmEmpty() {
        assertTrue(problem.getInitialStates().contains(predicate("arm-empty")));
    }

    @Test
    void blocksWorldProblem13HasGoal() {
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
                        predicate("on", constant("l"), constant("m"))));
        assertEquals(goal, problem.getGoal());
    }
}
