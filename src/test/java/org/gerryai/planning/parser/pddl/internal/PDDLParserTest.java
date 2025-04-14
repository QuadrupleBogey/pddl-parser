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
package org.gerryai.planning.parser.pddl.internal;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gerryai.planning.model.domain.Domain;
import org.gerryai.planning.model.problem.Problem;
import org.gerryai.planning.parser.pddl.antlr.PDDL31Parser;
import org.gerryai.planning.parser.pddl.internal.error.SyntaxErrorCollector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the {@link org.gerryai.planning.parser.pddl.internal.PDDLParser} class.
 */
public class PDDLParserTest {

    
    private static final PDDLParserUtils mockUtils = mock(PDDLParserUtils.class);
    private static final CharStream mockCharStream = mock(CharStream.class);
    private static final Lexer mockLexer = mock(Lexer.class);
    private static final InputStream mockInputStream = mock(InputStream.class);
    private static final TokenStream mockTokenStream = mock(TokenStream.class);
    private static final SyntaxErrorCollector mockSyntaxErrorCollector = mock(SyntaxErrorCollector.class);
    private static final PDDL31Parser mockParser = mock(PDDL31Parser.class);
    private static final ParseTreeWalker mockParseTreeWalker = mock(ParseTreeWalker.class);
    private static final ExtractDomainListener mockExtractDomainListener = mock(ExtractDomainListener.class);
    private static final ExtractProblemListener mockExtractProblemListener = mock(ExtractProblemListener.class);
    private static final PDDL31Parser.DomainContext mockDomainParseTree = mock(PDDL31Parser.DomainContext.class);
    private static final PDDL31Parser.ProblemContext mockProblemParseTree = mock(PDDL31Parser.ProblemContext.class);
    private static final Domain mockDomain = mock(Domain.class);
    private static final Problem mockProblem = mock(Problem.class);

    private static PDDLParser parserService;

    @BeforeAll
    public static void setup() throws Exception {
        when(mockUtils.createInputStream(mockInputStream)).thenReturn(mockCharStream);
        when(mockUtils.createLexer(mockCharStream)).thenReturn(mockLexer);
        when(mockUtils.createTokenStream(mockLexer)).thenReturn(mockTokenStream);
        when(mockUtils.createSyntaxErrorCollector()).thenReturn(mockSyntaxErrorCollector);
        when(mockUtils.createParser(mockTokenStream, mockSyntaxErrorCollector)).thenReturn(mockParser);
        when(mockUtils.createParseTreeWalker()).thenReturn(mockParseTreeWalker);
        when(mockUtils.createExtractDomainListener()).thenReturn(mockExtractDomainListener);
        when(mockUtils.createExtractProblemListener()).thenReturn(mockExtractProblemListener);
        when(mockUtils.getDomainContext(mockParser)).thenReturn(mockDomainParseTree);
        when(mockUtils.getProblemContext(mockParser)).thenReturn(mockProblemParseTree);

        when(mockParser.getEnforceRequirments()).thenReturn(true);
        when(mockExtractDomainListener.extract()).thenReturn(mockDomain);
        when(mockExtractProblemListener.extract()).thenReturn(mockProblem);

        parserService = new PDDLParser(mockUtils);
    }

    @Test
    public void parseDomain() throws Exception {
        assertEquals(mockDomain, parserService.parseDomain(mockInputStream));
        verify(mockParseTreeWalker).walk(mockExtractDomainListener, mockDomainParseTree);
    }

    @Test
    public void parseProblem() throws Exception {
        assertEquals(mockProblem, parserService.parseProblem(mockInputStream));
        verify(mockParseTreeWalker).walk(mockExtractProblemListener, mockProblemParseTree);
    }
}
