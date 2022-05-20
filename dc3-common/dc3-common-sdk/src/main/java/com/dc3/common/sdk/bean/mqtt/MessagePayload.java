/*
 * Copyright (c) 2022. Pnoker. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dc3.common.sdk.bean.mqtt;

import com.dc3.common.utils.JsonUtil;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pnoker
 */
@Data
@Accessors(chain = true)
public class MessagePayload {
    private String payload;
    private MessageType messageType;

    public MessagePayload() {
        this.messageType = MessageType.DEFAULT;
    }

    public MessagePayload(Object payload, MessageType messageType) {
        this.payload = JsonUtil.toJsonString(payload);
        this.messageType = messageType;
    }
}