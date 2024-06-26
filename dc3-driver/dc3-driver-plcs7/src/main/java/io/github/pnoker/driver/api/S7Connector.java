/*
 * Copyright 2016-present the IoT DC3 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.pnoker.driver.api;

import java.io.Closeable;

/**
 * @author Thomas Rudin
 */
public interface S7Connector extends Closeable {
    /**
     * Reads an area
     *
     * @param area       DaveArea
     * @param areaNumber Area Number
     * @param bytes      Byte Number
     * @param offset     Byte Offset
     * @return Byte Array
     */
    public byte[] read(DaveArea area, int areaNumber, int bytes, int offset);

    /**
     * Writes an area
     *
     * @param area       DaveArea
     * @param areaNumber Area Number
     * @param offset     Byte Offset
     * @param buffer     Write Byte Array
     */
    public void write(DaveArea area, int areaNumber, int offset, byte[] buffer);

}
