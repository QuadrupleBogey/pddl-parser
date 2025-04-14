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
package org.gerryai.planning.parser.pddl.integration.example.logistics;

import org.gerryai.planning.model.ConstantDefinition;
import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.problem.Goal;
import org.gerryai.planning.parser.pddl.integration.ProblemSuccessTester;
import org.junit.jupiter.api.Test;

import static org.gerryai.planning.model.logic.FormulaBuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
 class LogisticsPb2IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb2.pddl";
    }

    @Test
     void logisticsProblem2HasCorrectName() {
        assertEquals("pb2", problem.getName());
    }

    @Test
     void logisticsProblem2HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
     void logisticsProblem2Has2Requirements() {
        assertEquals(2, problem.getRequirements().size());
    }

    @Test
     void logisticsProblem2HasStripsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
     void logisticsProblem2HasTypingRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.TYPING));
    }

    @Test
     void logisticsProblem2Has23Objects() {
        assertEquals(23, problem.getObjects().size());
    }

    @Test
     void logisticsProblem2HasObjectPackage1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage4() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package4", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage5() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package5", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage6() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package6", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage7() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package7", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectPackage8() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package8", type("package"))));
    }

    @Test
     void logisticsProblem2HasObjectAirpplane1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
     void logisticsProblem2HasObjectAirplane2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
     void logisticsProblem2HasObjectPgh() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
     void logisticsProblem2HasObjectBos() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
     void logisticsProblem2HasObjectLa() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
     void logisticsProblem2HasObjectPghTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
     void logisticsProblem2HasObjectBosTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
     void logisticsProblem2HasObjectLaTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-truck", type("truck"))));
    }

    @Test
     void logisticsProblem2HasObjectPghPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-po", type("location"))));
    }

    @Test
     void logisticsProblem2HasObjectBosPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-po", type("location"))));
    }

    @Test
     void logisticsProblem2HasObjectLaPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-po", type("location"))));
    }

    @Test
     void logisticsProblem2HasObjectPghAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-airport", type("location", "airport"))));
    }

    @Test
     void logisticsProblem2HasObjectBosAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-airport", type("location", "airport"))));
    }

    @Test
     void logisticsProblem2HasObjectLaAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-airport", type("location", "airport"))));
    }

    @Test
     void logisticsProblem2Has19StateTerms() {
        assertEquals(19, problem.getInitialStates().size());
    }

    @Test
     void logisticsProblem2InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
     void logisticsProblem2InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
     void logisticsProblem2InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
     void logisticsProblem2InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
     void logisticsProblem2InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
     void logisticsProblem2InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage4() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package4"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage5() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package5"), constant("bos-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage6() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package6"), constant("bos-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage7() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package7"), constant("bos-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPackage8() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package8"), constant("la-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem2InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
     void logisticsProblem2HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("bos-airport")),
                        predicate("at", constant("package3"), constant("la-po")),
                        predicate("at", constant("package4"), constant("la-airport")),
                        predicate("at", constant("package5"), constant("pgh-po")),
                        predicate("at", constant("package6"), constant("pgh-airport")),
                        predicate("at", constant("package7"), constant("pgh-po")),
                        predicate("at", constant("package8"), constant("pgh-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
