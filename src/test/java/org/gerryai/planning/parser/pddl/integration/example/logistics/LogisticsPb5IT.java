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

import static org.gerryai.planning.model.logic.FormulaBuilder.and;
import static org.gerryai.planning.model.logic.FormulaBuilder.constant;
import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.type;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Logistics example files are parsed correctly.
 */
public class LogisticsPb5IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/logistics/pb5.pddl";
    }

    @Test
    void logisticsProblem5HasCorrectName() {
        assertEquals("pb5", problem.getName());
    }

    @Test
    void logisticsProblem5HasCorrectDomain() {
        assertEquals("logistics", problem.getDomainName());
    }

    @Test
    void logisticsProblem5Has2Requirements() {
        assertEquals(2, problem.getRequirements().size());
    }

    @Test
    void logisticsProblem5HasStripsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    void logisticsProblem5HasTypingRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.TYPING));
    }

    @Test
    void logisticsProblem5Has23Objects() {
        assertEquals(23, problem.getObjects().size());
    }

    @Test
    void logisticsProblem5HasObjectPackage1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package1", type("package"))));
    }

    @Test
    void logisticsProblem5HasObjectPackage2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package2", type("package"))));
    }

    @Test
    void logisticsProblem5HasObjectPackage3() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package3", type("package"))));
    }

    @Test
    void logisticsProblem5HasObjectPackage5() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package5", type("package"))));
    }

    @Test
    void logisticsProblem5HasObjectPackage7() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("package7", type("package"))));
    }

    @Test
    void logisticsProblem5HasObjectAirplane1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane1", type("airplane"))));
    }

    @Test
    void logisticsProblem5HasObjectAirplane2() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("airplane2", type("airplane"))));
    }

    @Test
    void logisticsProblem5HasObjectPgh() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh", type("city"))));
    }

    @Test
    void logisticsProblem5HasObjectBos() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos", type("city"))));
    }

    @Test
    void logisticsProblem5HasObjectLa() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la", type("city"))));
    }

    @Test
    void logisticsProblem5HasObjectNy() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ny", type("city"))));
    }

    @Test
    void logisticsProblem5HasObjectPghTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-truck", type("truck"))));
    }

    @Test
    void logisticsProblem5HasObjectBosTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-truck", type("truck"))));
    }

    @Test
    void logisticsProblem5HasObjectLaTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-truck", type("truck"))));
    }

    @Test
    void logisticsProblem5HasObjectNyTruck() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ny-truck", type("truck"))));
    }

    @Test
    void logisticsProblem5HasObjectPghPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-po", type("location"))));
    }

    @Test
    void logisticsProblem5HasObjectBosPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-po", type("location"))));
    }

    @Test
    void logisticsProblem5HasObjectLaPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-po", type("location"))));
    }

    @Test
    void logisticsProblem5HasObjectNyPo() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ny-po", type("location"))));
    }

    @Test
    void logisticsProblem5HasObjectPghAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("pgh-airport", type("location", "airport"))));
    }

    @Test
    void logisticsProblem5HasObjectLaAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("la-airport", type("location", "airport"))));
    }

    @Test
    void logisticsProblem5HasObjectBosAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("bos-airport", type("location", "airport"))));
    }

    @Test
    void logisticsProblem5HasObjectNyAirport() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("ny-airport", type("location", "airport"))));
    }

    @Test
    void logisticsProblem5Has19StateTerms() {
        assertEquals(19, problem.getInitialStates().size());
    }

    @Test
    void logisticsProblem5InitialStateHasInCityPghPoPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-po"), constant("pgh"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityPghAirportPgh() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("pgh-airport"), constant("pgh"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityBosPoBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-po"), constant("bos"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityBosAirportBos() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("bos-airport"), constant("bos"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityLaPoLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-po"), constant("la"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityLaAirportLa() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("la-airport"), constant("la"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityNyPoNy() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("ny-po"), constant("ny"))));
    }

    @Test
    void logisticsProblem5InitialStateHasInCityNyAirportNy() {
        assertTrue(problem.getInitialStates().contains(predicate("in-city", constant("ny-airport"), constant("ny"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPackage1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package1"), constant("pgh-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPackage2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package2"), constant("pgh-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPackage3() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package3"), constant("pgh-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPackage5() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package5"), constant("bos-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPackage7() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("package7"), constant("ny-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtAirplane1() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane1"), constant("pgh-airport"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtAirplane2() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("airplane2"), constant("pgh-airport"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtBosTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("bos-truck"), constant("bos-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtPghTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("pgh-truck"), constant("pgh-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtLaTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("la-truck"), constant("la-po"))));
    }

    @Test
    void logisticsProblem5InitialStateHasAtNyTruck() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("ny-truck"), constant("ny-po"))));
    }

    @Test
    void logisticsProblem5HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("at", constant("package1"), constant("bos-po")),
                        predicate("at", constant("package2"), constant("ny-po")),
                        predicate("at", constant("package3"), constant("la-po")),
                        predicate("at", constant("package5"), constant("pgh-po")),
                        predicate("at", constant("package7"), constant("pgh-po"))));
        assertEquals(goal, problem.getGoal());
    }
}
