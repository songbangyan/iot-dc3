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

package org.openscada.opc.lib.list;

public interface Categories {
    /**
     * Category of the OPC DA 1.0 Servers
     */
    public final static Category OPCDAServer10 = new Category(org.openscada.opc.dcom.common.Categories.OPCDAServer10);

    /**
     * Category of the OPC DA 2.0 Servers
     */
    public final static Category OPCDAServer20 = new Category(org.openscada.opc.dcom.common.Categories.OPCDAServer20);

    /**
     * Category of the OPC DA 3.0 Servers
     */
    public final static Category OPCDAServer30 = new Category(org.openscada.opc.dcom.common.Categories.OPCDAServer30);

    /**
     * Category of the XML DA 1.0 Servers
     */
    public final static Category XMLDAServer10 = new Category(org.openscada.opc.dcom.common.Categories.XMLDAServer10);
}
