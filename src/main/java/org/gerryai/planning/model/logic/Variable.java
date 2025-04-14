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
package org.gerryai.planning.model.logic;

import lombok.Getter;
import org.gerryai.planning.model.logic.impl.Term;
import org.gerryai.planning.model.logic.impl.Type;

import java.util.Objects;
import java.util.Optional;

/**
 * Class representing a logical variable.
 */
@Getter
public class Variable implements Term {

    private final String name;
    private Optional<Type> type = Optional.empty();

    /**
     * Constructor.
     * @param name the name of the variable
     */
    public Variable(final String name) {
        this.name = name;
    }

    /**
     * Constructor.
     * @param name the name of the variable
     * @param type the type of the variable
     */
    public Variable(final String name, final Type type) {
        this.name = name;
        this.type = Optional.ofNullable(type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        return Objects.equals(this.name, other.name) && Objects.equals(this.type, other.type);
    }
}
