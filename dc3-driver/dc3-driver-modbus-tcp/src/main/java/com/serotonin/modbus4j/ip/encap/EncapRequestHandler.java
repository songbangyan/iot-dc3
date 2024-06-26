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
package com.serotonin.modbus4j.ip.encap;

import com.serotonin.modbus4j.ModbusSlaveSet;
import com.serotonin.modbus4j.base.BaseRequestHandler;
import com.serotonin.modbus4j.msg.ModbusRequest;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.sero.messaging.IncomingRequestMessage;
import com.serotonin.modbus4j.sero.messaging.OutgoingResponseMessage;

/**
 * <p>EncapRequestHandler class.</p>
 *
 * @author Matthew Lohbihler
 * @version 5.0.0
 */
public class EncapRequestHandler extends BaseRequestHandler {
    /**
     * <p>Constructor for EncapRequestHandler.</p>
     *
     * @param slave a {@link ModbusSlaveSet} object.
     */
    public EncapRequestHandler(ModbusSlaveSet slave) {
        super(slave);
    }


    public OutgoingResponseMessage handleRequest(IncomingRequestMessage req) throws Exception {
        EncapMessageRequest tcpRequest = (EncapMessageRequest) req;
        ModbusRequest request = tcpRequest.getModbusRequest();
        ModbusResponse response = handleRequestImpl(request);
        if (response == null)
            return null;
        return new EncapMessageResponse(response);
    }
}
