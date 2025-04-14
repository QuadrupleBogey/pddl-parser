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
package org.gerryai.planning.parser.pddl.integration.example.travel;

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
 * Integration test to check that the travel example files are parsed correctly.
 */
public class TravelPb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/pb1.pddl";
    }

    @Test
    void travelProblem1HasCorrectName() {
        assertEquals("big-bull1", problem.getName());
    }

    @Test
    void travelProblem1HasCorrectDomain() {
        assertEquals("bulldozer", problem.getDomainName());
    }

    @Test
    void travelProblem1Has9Objects() {
        assertEquals(9, problem.getObjects().size());
    }

    @Test
    void travelProblem1HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void travelProblem1HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void travelProblem1HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void travelProblem1HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void travelProblem1HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void travelProblem1HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void travelProblem1HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void travelProblem1HasObjectJack() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("jack")));
    }

    @Test
    void travelProblem1HasObjectBulldozer() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bulldozer")));
    }

    @Test
    void travelProblem1Has25StateFormulas() {
        assertEquals(25, problem.getInitialStates().size());
    }

    @Test
    void travelProblem1InitialStateHasAtJackA() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("jack"), constant("a"))));
    }

    @Test
    void travelProblem1InitialStateHasAtBulldozerE() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bulldozer"), constant("e"))));
    }

    @Test
    void travelProblem1InitialStateHasVehicleBulldozer() {
        assertTrue(problem.getInitialStates().contains(predicate("vehicle", constant("bulldozer"))));
    }

    @Test
    void travelProblem1InitialStateHasMobileJack() {
        assertTrue(problem.getInitialStates().contains(predicate("mobile", constant("jack"))));
    }

    @Test
    void travelProblem1InitialStateHasPersonJack() {
        assertTrue(problem.getInitialStates().contains(predicate("person", constant("jack"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadAB() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("a"), constant("b"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadBA() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("b"), constant("a"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadAE() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("a"), constant("e"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadEA() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("e"), constant("a"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadEB() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("e"), constant("b"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadBE() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("b"), constant("e"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadAC() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("a"), constant("c"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadCA() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("c"), constant("a"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadCB() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("c"), constant("b"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadBC() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("b"), constant("c"))));
    }

    @Test
    void travelProblem1InitialStateHasBridgeBD() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("b"), constant("d"))));
    }

    @Test
    void travelProblem1InitialStateHasBridgeDB() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("d"), constant("b"))));
    }

    @Test
    void travelProblem1InitialStateHasBridgeCF() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("c"), constant("f"))));
    }

    @Test
    void travelProblem1InitialStateHasBridgeFC() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("f"), constant("c"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadDF() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("d"), constant("f"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadFD() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("f"), constant("d"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadFG() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("f"), constant("g"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadGF() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("g"), constant("f"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadDG() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("d"), constant("g"))));
    }

    @Test
    void travelProblem1InitialStateHasRoadGD() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("g"), constant("d"))));
    }

    @Test
    void travelProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("bulldozer"), constant("g")),
                        predicate("at", constant("jack"), constant("a"))));
        assertEquals(goal, problem.getGoal());
    }
}
