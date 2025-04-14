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
package org.gerryai.planning.parser.pddl.integration.example.tasks;

import org.gerryai.planning.model.Requirement;
import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.FunctionDefinition;
import org.gerryai.planning.model.logic.And;
import org.gerryai.planning.model.logic.Operation;
import org.gerryai.planning.model.logic.PrimitiveType;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that the Blocksworld example files are parsed correctly.
 */
public class TasksIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/example/tasks/tasks.pddl";
    }

    @Test
     void tasksDomainHasCorrectName() {
        assertEquals("tasks", domain.getName());
    }


    @Test
     void containsNumericFluentsRequirement() throws Exception {
        assertTrue(domain.getRequirements().contains(Requirement.NUMERIC_FLUENTS));
    }

    @Test
     void containsActionCostsRequirement() throws Exception {
        assertTrue(domain.getRequirements().contains(Requirement.ACTION_COSTS));
    }

    @Test
     void hasTwoFunctionDefs() throws Exception {
        assertTrue(domain.getFunctions().size() == 2);
    }

    @Test
     void containsFunctionRequiresReward() throws Exception {
        FunctionDefinition functionDefinition = FunctionDefinition.builder()
            .name("requires_reward")
            .term(new Variable("p", new PrimitiveType("person")))
            .build();

        Set<FunctionDefinition> functionDefinitions = domain.getFunctions();
        assertTrue(functionDefinitions.contains(functionDefinition));
    }

    @Test
     void containsFunctionTotalCost() throws Exception {
        FunctionDefinition functionDefinition = FunctionDefinition.builder()
            .name("total-cost")
            .build();

        Set<FunctionDefinition> functionDefinitions = domain.getFunctions();
        assertTrue(functionDefinitions.contains(functionDefinition));
    }

    @Test
     void hasIncreaseOperationAsAnEffect() throws Exception {
        Action action = domain.getActions().stream().filter(a -> a.getName().equals("resolve")).findAny().get();
        And effect = (And) action.getEffect().getEffect().get();
        Operation operation = (Operation) effect.asList().get(2);

        String operator = operation.getOperator();
        String antecedentName = operation.getAntecedent().getName();
        Variable antecedentVariable = (Variable) operation.getAntecedent().getTerms().get(0);
        String consequentName = operation.getConsequent().getName();

        assertEquals("increase", operator);
        assertEquals("requires_reward", antecedentName);
        assertEquals("p", antecedentVariable.getName());
        assertEquals("total-cost", consequentName);
    }
}

