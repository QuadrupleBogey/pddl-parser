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
package org.gerryai.planning.parser.pddl.integration.example.monkey;

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
 * Integration test to check that the Monkey example files are parsed correctly.
 */
public class MonkeyPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/monkey/pb3.pddl";
    }

    @Test
    void monkeyProblem3HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
    void monkeyProblem3HasCorrectDomain() {
        assertEquals("monkey", problem.getDomainName());
    }

    @Test
    void monkeyProblem3HasNoRequirements() {
        assertEquals(0, problem.getRequirements().size());
    }


    @Test
    void monkeyProblem3Has12Objects() {
        assertEquals(12, problem.getObjects().size());
    }

    @Test
    void monkeyProblem3HasObjectP1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p1")));
    }

    @Test
    void monkeyProblem3HasObjectP2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p2")));
    }

    @Test
    void monkeyProblem3HasObjectP3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p3")));
    }

    @Test
    void monkeyProblem3HasObjectP4() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p4")));
    }

    @Test
    void monkeyProblem3HasObjectP5() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p5")));
    }

    @Test
    void monkeyProblem3HasObjectP6() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("p6")));
    }

    @Test
    void monkeyProblem3HasObjectBananas() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bananas")));
    }

    @Test
    void monkeyProblem3HasObjectMonkey() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("monkey")));
    }

    @Test
    void monkeyProblem3HasObjectBox() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("box")));
    }

    @Test
    void monkeyProblem3HasObjectKnife() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("knife")));
    }

    @Test
    void monkeyProblem3HasObjectGlass() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("glass")));
    }

    @Test
    void monkeyProblem3HasObjectWaterFountain() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("waterfountain")));
    }

    @Test
    void monkeyProblem3Has13StateFormulas() {
        assertEquals(13, problem.getInitialStates().size());
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP1() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p1"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP2() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p2"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP3() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p3"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP4() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p4"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP5() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p5"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationP6() {
        assertTrue(problem.getInitialStates().contains(predicate("location", constant("p6"))));
    }

    @Test
    void monkeyProblem3InitialStateHasAtMonkeyP1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("monkey"), constant("p1"))));
    }

    @Test
    void monkeyProblem3InitialStateHasLocationOnFloor() {
        assertTrue(problem.getInitialStates().contains(predicate("on-floor")));
    }

    @Test
    void monkeyProblem3InitialStateHasAtBoxP2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("box"), constant("p2"))));
    }

    @Test
    void monkeyProblem3InitialStateHasAtBananasP3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bananas"), constant("p3"))));
    }

    @Test
    void monkeyProblem3InitialStateHasAtKnifeP4() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("knife"), constant("p4"))));
    }

    @Test
    void monkeyProblem3InitialStateHasAtWaterFountainP3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("waterfountain"), constant("p5"))));
    }

    @Test
    void monkeyProblem3InitialStateHasAtGlassP6() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("glass"), constant("p6"))));
    }

    @Test
    void monkeyProblem3HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("hasbananas"),
                        predicate("haswater")));
        assertEquals(goal, problem.getGoal());
    }
}
