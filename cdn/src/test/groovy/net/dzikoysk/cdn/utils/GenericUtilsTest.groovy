/*
 * Copyright (c) 2021 dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dzikoysk.cdn.utils

import groovy.transform.CompileStatic
import net.dzikoysk.cdn.CdnSpec
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertThrows

@CompileStatic
class GenericUtilsTest extends CdnSpec{

    @SuppressWarnings('unused')
    public static final Collection WITHOUT_GENERIC_TYPE = Collections.emptyList()
    @SuppressWarnings('unused')
    public static final Collection<String> WITH_GENERIC_TYPE = Collections.emptyList()

    @Test
    void 'should fetch generic type' () {
        assertEquals String.class, GenericUtils.getGenericClasses(GenericUtilsTest.class.getField('WITH_GENERIC_TYPE'))[0]
    }

    @Test
    void 'should throw missing generic signature' () {
        assertThrows IllegalArgumentException.class, { GenericUtils.getGenericTypes(GenericUtilsTest.class.getField('WITHOUT_GENERIC_TYPE')) }
    }

}
