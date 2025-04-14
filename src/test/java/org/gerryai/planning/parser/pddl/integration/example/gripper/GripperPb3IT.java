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
package org.gerryai.planning.parser.pddl.integration.example.gripper;

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
 * Integration test to check that the Gripper example files are parsed correctly.
 */
public class GripperPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/gripper/pb3.pddl";
    }

    @Test
    void gripperProblem1HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    void gripperProblem1HasCorrectDomain() {
        assertEquals("gripper", problem.getDomainName());
    }

    @Test
    void gripperProblem1HasNoRequirements() {
        assertEquals(0, problem.getRequirements().size());
    }

    @Test
    void gripperProblem1Has10Objects() {
        assertEquals(10, problem.getObjects().size());
    }

    @Test
    void gripperProblem1HasObjectRoomA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("rooma")));
    }

    @Test
    void gripperProblem1HasObjectRoomB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("roomb")));
    }

    @Test
    void gripperProblem1HasObjectBall1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball1")));
    }

    @Test
    void gripperProblem1HasObjectBall2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball2")));
    }

    @Test
    void gripperProblem1HasObjectBall3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball3")));
    }

    @Test
    void gripperProblem1HasObjectBall4() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball4")));
    }

    @Test
    void gripperProblem1HasObjectBall5() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball5")));
    }

    @Test
    void gripperProblem1HasObjectBall6() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ball6")));
    }

    @Test
    void gripperProblem1HasObjectLeft() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("left")));
    }

    @Test
    void gripperProblem1HasObjectRight() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("right")));
    }

    @Test
    void gripperProblem1Has19StateTerms() {
        assertEquals(19, problem.getInitialStates().size());
    }

    @Test
    void gripperProblem1InitialStateHasRoomA() {
        assertTrue(problem.getInitialStates().contains(predicate("room", constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasRoomB() {
        assertTrue(problem.getInitialStates().contains(predicate("room", constant("roomb"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall1() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball1"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall2() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball2"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall3() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball3"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall4() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball4"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall5() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball5"))));
    }

    @Test
    void gripperProblem1InitialStateHasBall6() {
        assertTrue(problem.getInitialStates().contains(predicate("ball", constant("ball6"))));
    }

    @Test
    void gripperProblem1InitialStateHasGripperLeft() {
        assertTrue(problem.getInitialStates().contains(predicate("gripper", constant("left"))));
    }

    @Test
    void gripperProblem1InitialStateHasGripperRight() {
        assertTrue(problem.getInitialStates().contains(predicate("gripper", constant("right"))));
    }

    @Test
    void gripperProblem1InitialStateHasArRobby() {
        assertTrue(problem.getInitialStates().contains(predicate("at-robby", constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasFreeLeft() {
        assertTrue(problem.getInitialStates().contains(predicate("free", constant("left"))));
    }

    @Test
    void gripperProblem1InitialStateHasFreeRight() {
        assertTrue(problem.getInitialStates().contains(predicate("free", constant("right"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball1"), constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball2"), constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball3"), constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall4() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball4"), constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall5() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball5"), constant("rooma"))));
    }

    @Test
    void gripperProblem1InitialStateHasAtBall6() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ball6"), constant("rooma"))));
    }

    @Test
    void gripperProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("ball1"), constant("roomb")),
                        predicate("at", constant("ball2"), constant("roomb")),
                        predicate("at", constant("ball3"), constant("roomb")),
                        predicate("at", constant("ball4"), constant("roomb")),
                        predicate("at", constant("ball5"), constant("roomb")),
                        predicate("at", constant("ball6"), constant("roomb"))));
        assertEquals(goal, problem.getGoal());
    }
}
