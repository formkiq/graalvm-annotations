/**
 * Copyright [2020] FormKiQ Inc. Licensed under the Apache License, ersion 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may obtain a copy of the License
 * at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.formkiq.graalvm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that allows adding a classes to Graalvm's list of Reflection classes to process.
 * Based on https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md
 *
 * @deprecated You can now use multiple {@link ReflectableClass} as it supports {@link Repeatable}.
 */
@Deprecated(forRemoval = true, since = "1.2.0")
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ReflectableClasses {

  /**
   * Sets {@link ReflectableClass}.
   *
   * @return {@link ReflectableClass}.
   */
  ReflectableClass[] value() default {};
}
