/*
 * Copyright 2023 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openrewrite.python.format;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.python.Assertions.python;

class PythonSpacesTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new PythonSpaces());
    }

    @Test
    void emptyParameters() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo() :
                      pass
              """
          )
        );
    }

    @Test
    void singleParameter() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(a):
                      pass
              """
          )
        );
    }

    @Test
    void multipleParameters() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(a, b, c):
                      pass
              """
          )
        );
    }

    @Test
    void newLines() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(
                      a,
                      b,
                      c
                  ):
                      pass
              """
          )
        );
    }

    @Test
    void formatAfterWithNewLines() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(
                      a ,
                      b ,
                      c
                  ):
                      pass
              """,
            """
            class Foo:
                def foo(
                    a,
                    b,
                    c
                ):
                    pass
            """
          )
        );
    }

    @Test
    void formatBeforeParameters() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo ():
                      pass
            """,
            """
              class Foo:
                  def foo():
                      pass
            """
          )
        );
    }

    @Test
    void formatEmptyParameters() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(    ):
                      pass
            """,
            """
              class Foo:
                  def foo():
                      pass
            """
          )
        );
    }

    @Test
    void formatSingleParameter() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo( a ):
                      pass
              """,
            """
              class Foo:
                  def foo(a):
                      pass
              """
          )
        );
    }

    @Test
    void formatParameterPrefix() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo( a,b,c):
                      pass
              """,
            """
              class Foo:
                  def foo(a, b, c):
                      pass
              """
          )
        );
    }

    @Test
    void formatParameterSuffix() {
        rewriteRun(
          python(
            """
              class Foo:
                  def foo(a ,b ,c ):
                      pass
              """,
            """
              class Foo:
                  def foo(a, b, c):
                      pass
              """
          )
        );
    }
}
