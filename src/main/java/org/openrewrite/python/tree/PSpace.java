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
package org.openrewrite.python.tree;

public class PSpace {
    public enum Location {
        OBJECT_PREFIX,
        BINARY_PREFIX,
        BINARY_OPERATOR,
        BINARY_SUFFIX,
        FILE_ANNOTATION_SUFFIX,
        FUNCTION_TYPE_RECEIVER,
        IS_NULLABLE_PREFIX,
        KSTRING_PREFIX,
        LIST_LITERAL_PREFIX,
        LIST_LITERAL_ELEMENTS,
        LIST_LITERAL_ELEMENT_SUFFIX,
        KRETURN_PREFIX,
        TOP_LEVEL_STATEMENT,
        TYPE_REFERENCE_PREFIX,
        WHEN_PREFIX,
        WHEN_BRANCH_EXPRESSION,
        WHEN_BRANCH_PREFIX
    }
}
