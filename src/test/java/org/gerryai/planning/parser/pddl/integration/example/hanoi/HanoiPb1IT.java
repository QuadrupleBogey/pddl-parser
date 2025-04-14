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
package org.gerryai.planning.parser.pddl.integration.example.hanoi;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.jupiter.api.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Hanoi example files are parsed correctly.
 */
 class HanoiPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/hanoi/pb1.pddl";
    }

    @Test
     void hanoiProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
     void hanoiProblem1HasCorrectDomain() {
        assertEquals("hanoi", problem.getDomainName());
    }

    @Test
     void hanoiProblem1HasOneRequirement() {
        assertEquals(1, problem.getRequirements().size());
    }

    @Test
     void hanoiProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
     void hanoiProblem1Has6Objects() {
        assertEquals(6, problem.getObjects().size());
    }

    @Test
     void hanoiProblem1HasObjectPeg1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("peg1")));
    }

    @Test
     void hanoiProblem1HasObjectPeg2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("peg2")));
    }

    @Test
     void hanoiProblem1HasObjectPeg3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("peg3")));
    }

    @Test
     void hanoiProblem1HasObjectD1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d1")));
    }

    @Test
     void hanoiProblem1HasObjectD2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d2")));
    }

    @Test
     void hanoiProblem1HasObjectD3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d3")));
    }

    @Test
     void hanoiProblem1Has18StateForumlas() {
        assertEquals(18, problem.getInitialStates().size());
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg1D2() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg1"), constant("d2"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg1D3() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg1"), constant("d3"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg2D1() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg2"), constant("d1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg2D2() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg2"), constant("d2"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg2D3() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg2"), constant("d3"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg3D1() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg3"), constant("d1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg3D2() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg3"), constant("d2"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerPeg3D3() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("peg3"), constant("d3"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerD2D1() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("d2"), constant("d1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerD3D1() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("d3"), constant("d1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasSmallerD3D2() {
        assertTrue(problem.getInitialStates().contains(predicate("smaller", constant("d3"), constant("d2"))));
    }

    @Test
     void hanoiProblem1InitialStateHasClearPeg2() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("peg2"))));
    }

    @Test
     void hanoiProblem1InitialStateHasClearPeg3() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("peg3"))));
    }

    @Test
     void hanoiProblem1InitialStateHasClearD1() {
        assertTrue(problem.getInitialStates().contains(predicate("clear", constant("d1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasHanoiOnD3Peg1() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("d3"), constant("peg1"))));
    }

    @Test
     void hanoiProblem1InitialStateHasHanoiOnD2D3() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("d2"), constant("d3"))));
    }

    @Test
     void hanoiProblem1InitialStateHasHanoiOnD1D2() {
        assertTrue(problem.getInitialStates().contains(predicate("on", constant("d1"), constant("d2"))));
    }

    @Test
     void hanoiProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("on", constant("d3"), constant("peg3")),
                        predicate("on", constant("d2"), constant("d3")),
                        predicate("on", constant("d1"), constant("d2"))));
        assertEquals(goal, problem.getGoal());
    }
}
