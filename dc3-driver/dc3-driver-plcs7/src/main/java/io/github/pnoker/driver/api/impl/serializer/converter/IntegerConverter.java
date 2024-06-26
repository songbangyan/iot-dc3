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
package io.github.pnoker.driver.api.impl.serializer.converter;

import io.github.pnoker.driver.api.S7Serializable;
import io.github.pnoker.driver.api.S7Type;

public class IntegerConverter implements S7Serializable {

    private static final int OFFSET_HIGH_BYTE = 0;
    private static final int OFFSET_LOW_BYTE = 1;

    @Override
    public <T> T extract(final Class<T> targetClass, final byte[] buffer, final int byteOffset, final int bitOffset) {
        final byte lower = buffer[byteOffset + OFFSET_LOW_BYTE];
        final byte higher = buffer[byteOffset + OFFSET_HIGH_BYTE];

        final Integer i = (lower & 0xFF) | ((higher << 8) & 0xFF00);

        return targetClass.cast(i);
    }

    @Override
    public S7Type getS7Type() {
        return S7Type.WORD;
    }

    @Override
    public int getSizeInBits() {
        return 0;
    }

    @Override
    public int getSizeInBytes() {
        return 2;
    }

    @Override
    public void insert(final Object javaType, final byte[] buffer, final int byteOffset, final int bitOffset,
                       final int size) {
        final Integer value = (Integer) javaType;
        final byte lower = (byte) ((value) & 0xFF);
        final byte higher = (byte) ((value >> 8) & 0xFF);
        buffer[byteOffset + OFFSET_LOW_BYTE] = lower;
        buffer[byteOffset + OFFSET_HIGH_BYTE] = higher;
    }

}
