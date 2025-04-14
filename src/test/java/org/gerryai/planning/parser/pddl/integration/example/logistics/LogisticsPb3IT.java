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
 class LogisticsPb3IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb3.pddl";
    }

    @Test
     void logisticsProblem3HasCorrectName() {
        assertEquals("pb3", problem.getName());
    }

    @Test
     void logisticsProblem3HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
     void logisticsProblem3Has2Requirements() {
        assertEquals(2, problem.getRequirements().size());
    }

    @Test
     void logisticsProblem3HasStripsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
     void logisticsProblem3HasTypingRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.TYPING));
    }

    @Test
     void logisticsProblem3Has20Objects() {
        assertEquals(20, problem.getObjects().size());
    }

    @Test
     void logisticsProblem3HasObjectPackage1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
     void logisticsProblem3HasObjectPackage2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
     void logisticsProblem3HasObjectPackage3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
     void logisticsProblem3HasObjectAirpplane1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
     void logisticsProblem3HasObjectAirplane2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
     void logisticsProblem3HasObjectPgh() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
     void logisticsProblem3HasObjectBos() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
     void logisticsProblem3HasObjectLa() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
     void logisticsProblem3HasObjectPghTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
     void logisticsProblem3HasObjectBosTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
     void logisticsProblem3HasObjectLaTruck() {
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
     void logisticsProblem2HasObjectPghCentral() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-central", type("location"))));
    }

    @Test
     void logisticsProblem2HasObjectBosCentral() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-central", type("location"))));
    }

    @Test
     void logisticsProblem2HasObjectLaCentral() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-central", type("location"))));
    }

    @Test
     void logisticsProblem3HasObjectPghAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-airport", type("airport", "location"))));
    }

    @Test
     void logisticsProblem3HasObjectBosAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-airport", type("airport", "location"))));
    }

    @Test
     void logisticsProblem3HasObjectLaAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-airport", type("airport", "location"))));
    }

    @Test
     void logisticsProblem3Has17StateTerms() {
        assertEquals(17, problem.getInitialStates().size());
    }

    @Test
     void logisticsProblem3InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityPghCentralPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-central"), constant("pgh"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityBosCentralBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-central"), constant("bos"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
     void logisticsProblem3InitialStateHasInCityLaCentralLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-central"), constant("la"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
     void logisticsProblem3InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
     void logisticsProblem3HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("la-po")),
                        predicate("at", constant("package3"), constant("bos-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
