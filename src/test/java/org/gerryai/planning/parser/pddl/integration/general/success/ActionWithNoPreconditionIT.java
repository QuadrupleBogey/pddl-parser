/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.parser.pddl.integration.general.success;

import org.gerryai.planning.model.domain.Action;
import org.gerryai.planning.model.domain.Effect;
import org.gerryai.planning.model.domain.Precondition;
import org.gerryai.planning.model.logic.Variable;
import org.gerryai.planning.parser.pddl.integration.DomainSuccessTester;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.gerryai.planning.model.logic.FormulaBuilder.predicate;
import static org.gerryai.planning.model.logic.FormulaBuilder.variable;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration test to check that actions with no precondition are parsed correctly.
 */
public class ActionWithNoPreconditionIT extends DomainSuccessTester {

    protected String getFilePath() {
        return "pddl/general/success/action-with-no-precondition.pddl";
    }

    @Test
    public void testDomainHasActionTest() {
        Action testing = Action.builder()
                .name("test")
                .parameter(new Variable("x"))
                .effect(new Effect(Optional.of(
                        predicate("testing", variable("x"))
                )))
                .precondition(new Precondition(Optional.empty()))
                .build();
        assertTrue(domain.getActions().contains(testing), "Domain contains the test action");
    }
}
