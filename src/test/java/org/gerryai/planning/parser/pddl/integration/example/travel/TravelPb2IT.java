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
public class TravelPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/travel/pb2.pddl";
    }

    @Test
    void travelProblem2HasCorrectName() {
        assertEquals("big-bull2", problem.getName());
    }

    @Test
    void travelProblem2HasCorrectDomain() {
        assertEquals("bulldozer", problem.getDomainName());
    }

    @Test
    void travelProblem2Has16Objects() {
        assertEquals(16, problem.getObjects().size());
    }

    @Test
    void travelProblem2HasObjectA() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("a")));
    }

    @Test
    void travelProblem2HasObjectB() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("b")));
    }

    @Test
    void travelProblem2HasObjectC() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("c")));
    }

    @Test
    void travelProblem2HasObjectD() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("d")));
    }

    @Test
    void travelProblem2HasObjectE() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("e")));
    }

    @Test
    void travelProblem2HasObjectF() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("f")));
    }

    @Test
    void travelProblem2HasObjectG() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("g")));
    }

    @Test
    void travelProblem2HasObjectH() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("h")));
    }

    @Test
    void travelProblem2HasObjectI() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("i")));
    }

    @Test
    void travelProblem2HasObjectJ() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("j")));
    }

    @Test
    void travelProblem2HasObjectK() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("k")));
    }

    @Test
    void travelProblem2HasObjectL() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("l")));
    }

    @Test
    void travelProblem2HasObjectM() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("m")));
    }

    @Test
    void travelProblem2HasObjectN() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("n")));
    }


    @Test
    void travelProblem2HasObjectJack() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("jack")));
    }

    @Test
    void travelProblem2HasObjectBulldozer() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bulldozer")));
    }

    @Test
    void travelProblem2Has37StateFormulas() {
        assertEquals(37, problem.getInitialStates().size());
    }

    @Test
    void travelProblem2InitialStateHasAtJackA() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("jack"), constant("a"))));
    }

    @Test
    void travelProblem2InitialStateHasAtBulldozerE() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bulldozer"), constant("e"))));
    }

    @Test
    void travelProblem2InitialStateHasVehicleBulldozer() {
        assertTrue(problem.getInitialStates().contains(predicate("vehicle", constant("bulldozer"))));
    }

    @Test
    void travelProblem2InitialStateHasMobileJack() {
        assertTrue(problem.getInitialStates().contains(predicate("mobile", constant("jack"))));
    }

    @Test
    void travelProblem2InitialStateHasPersonJack() {
        assertTrue(problem.getInitialStates().contains(predicate("person", constant("jack"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadAB() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("a"), constant("b"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadBA() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("b"), constant("a"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadAC() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("a"), constant("c"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadCA() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("c"), constant("a"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadCD() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("c"), constant("d"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadDC() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("d"), constant("c"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadDE() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("d"), constant("e"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadED() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("e"), constant("d"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadEJ() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("e"), constant("j"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadJE() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("j"), constant("e"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadDF() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("d"), constant("f"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadFD() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("f"), constant("d"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadFJ() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("f"), constant("j"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadJF() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("j"), constant("f"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadFK() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("f"), constant("k"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadKF() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("k"), constant("f"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadJH() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("j"), constant("h"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadHJ() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("h"), constant("j"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadHK() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("h"), constant("k"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadKH() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("k"), constant("h"))));
    }

    @Test
    void travelProblem2InitialStateHasBridgeKL() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("k"), constant("l"))));
    }

    @Test
    void travelProblem2InitialStateHasBridgeLK() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("l"), constant("k"))));
    }

    @Test
    void travelProblem2InitialStateHasBridgeKN() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("k"), constant("n"))));
    }

    @Test
    void travelProblem2InitialStateHasBridgeNK() {
        assertTrue(problem.getInitialStates().contains(predicate("bridge", constant("n"), constant("k"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadLM() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("l"), constant("m"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadML() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("m"), constant("l"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadMN() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("m"), constant("n"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadNM() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("n"), constant("m"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadMG() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("m"), constant("g"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadGM() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("g"), constant("m"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadNG() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("n"), constant("g"))));
    }

    @Test
    void travelProblem2InitialStateHasRoadGN() {
        assertTrue(problem.getInitialStates().contains(predicate("road", constant("g"), constant("n"))));
    }

    @Test
    void travelProblem2HasGoal() {
        Goal goal = new Goal(and(predicate("at", constant("bulldozer"), constant("g"))));
        assertEquals(goal, problem.getGoal());
    }
}
