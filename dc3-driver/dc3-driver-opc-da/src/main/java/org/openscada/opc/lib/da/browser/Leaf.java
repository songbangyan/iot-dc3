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

package org.openscada.opc.lib.da.browser;

public class Leaf {
    private Branch _parent = null;

    private String _name = "";

    private String _itemId = null;

    public Leaf(final Branch parent, final String name) {
        this._parent = parent;
        this._name = name;
    }

    public Leaf(final Branch parent, final String name, final String itemId) {
        this._parent = parent;
        this._name = name;
        this._itemId = itemId;
    }

    public String getItemId() {
        return this._itemId;
    }

    public void setItemId(final String itemId) {
        this._itemId = itemId;
    }

    public String getName() {
        return this._name;
    }

    public void setName(final String name) {
        this._name = name;
    }

    public Branch getParent() {
        return this._parent;
    }

}
