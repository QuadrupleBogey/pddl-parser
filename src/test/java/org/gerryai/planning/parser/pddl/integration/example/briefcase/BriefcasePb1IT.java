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
package org.gerryai.planning.parser.pddl.integration.example.briefcase;

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
 * Integration test to check that the Briefcase example files are parsed correctly.
 */
public class BriefcasePb1IT extends ProblemSuccessTester {

    protected String getFilePath() {
        return "pddl/example/briefcase/pb1.pddl";
    }

    @Test
    void briefcaseProblem1HasCorrectName() {
        assertEquals("pb1", problem.getName());
    }

    @Test
    void briefcaseProblem1HasCorrectDomain() {
        assertEquals("briefcase", problem.getDomainName());
    }

    @Test
    void briefcaseProblem1HasFourRequirements() {
        assertEquals(4, problem.getRequirements().size());
    }

    @Test
    void briefcaseProblem1HasStripsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.STRIPS));
    }

    @Test
    void briefcaseProblem1HasTypingRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.TYPING));
    }

    @Test
    void briefcaseProblem1HasUniversalPreconditionsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.UNIVERSAL_PRECONDITIONS));
    }

    @Test
    void briefcaseProblem1HasConditionalEffectsRequirement() {
        assertTrue(problem.getRequirements().contains(Requirement.CONDITIONAL_EFFECTS));
    }

    @Test
    void briefcaseProblem1Has3Objects() {
        assertEquals(3, problem.getObjects().size());
    }

    @Test
    void briefcaseProblem1HasObjectHome() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("home", type("location"))));
    }

    @Test
    void briefcaseProblem1HasObjectL1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("l1", type("location"))));
    }

    @Test
    void briefcaseProblem1HasObjectO1() {
        assertTrue(problem.getObjects().contains(new ConstantDefinition("o1", type("portable"))));
    }

    @Test
    void briefcaseProblem1HasTwoStateTerms() {
        assertEquals(2, problem.getInitialStates().size());
    }

    @Test
    void briefcaseProblem1InitialStateHasIsAt() {
        assertTrue(problem.getInitialStates().contains(predicate("is-at", constant("home"))));
    }

    @Test
    void briefcaseProblem1InitialStateHasAt() {
        assertTrue(problem.getInitialStates().contains(predicate("at", constant("o1"), constant("l1"))));
    }

    @Test
    void briefcaseProblem1HasGoal() {
        Goal goal = new Goal(
                and(
                        predicate("is-at", constant("home")),
                        predicate("at", constant("o1"), constant("home"))));
        assertEquals(goal, problem.getGoal());
    }
}
