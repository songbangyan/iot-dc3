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

import io.github.pnoker.driver.api.S7Type;

public final class TimeConverter extends ByteConverter {

    @Override
    public <T> T extract(final Class<T> targetClass, final byte[] buffer, final int byteOffset, final int bitOffset) {
        final byte b1 = super.extract(Byte.class, buffer, byteOffset + 3, bitOffset);
        final byte b2 = super.extract(Byte.class, buffer, byteOffset + 2, bitOffset);
        final byte b3 = super.extract(Byte.class, buffer, byteOffset + 1, bitOffset);
        final byte b4 = super.extract(Byte.class, buffer, byteOffset, bitOffset);

        final long l = ((long) b1 & 0xFF) | ((long) b2 & 0xFF) << 8 | ((long) b3 & 0xFF) << 16
                | ((long) b4 & 0xFF) << 24;

        return targetClass.cast(l);
    }

    @Override
    public S7Type getS7Type() {
        return S7Type.TIME;
    }

    @Override
    public int getSizeInBytes() {
        return 4;
    }

    @Override
    public void insert(final Object javaType, final byte[] buffer, final int byteOffset, final int bitOffset,
                       final int size) {
        final long l = (Long) javaType;

        final byte b1 = (byte) ((byte) (l) & 0xFF);
        final byte b2 = (byte) ((byte) (l >> 8) & 0xFF);
        final byte b3 = (byte) ((byte) (l >> 16) & 0xFF);
        final byte b4 = (byte) ((byte) (l >> 24) & 0xFF);

        super.insert(b1, buffer, byteOffset + 3, bitOffset, 1);
        super.insert(b2, buffer, byteOffset + 2, bitOffset, 1);
        super.insert(b3, buffer, byteOffset + 1, bitOffset, 1);
        super.insert(b4, buffer, byteOffset, bitOffset, 1);
    }

}
