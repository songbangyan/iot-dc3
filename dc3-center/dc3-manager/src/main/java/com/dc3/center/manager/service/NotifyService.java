/*
 * Copyright 2018-2020 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dc3.center.manager.service;

/**
 * <p>Notify Interface
 *
 * @author pnoker
 */
public interface NotifyService {

    /**
     * 通知驱动 新增模板
     *
     * @param profileId
     */
    boolean notifyDriverAddProfile(Long profileId);

    /**
     * 通知驱动 删除模板
     *
     * @param profileId
     */
    boolean notifyDriverDeleteProfile(Long profileId);

    /**
     * 通知驱动 新增设备
     *
     * @param deviceId
     * @param profileId
     */
    boolean notifyDriverAddDevice(Long deviceId, Long profileId);

    /**
     * 通知驱动 删除设备
     *
     * @param deviceId
     * @param profileId
     */
    boolean notifyDriverDeleteDevice(Long deviceId, Long profileId);

    /**
     * 通知驱动 修改设备
     *
     * @param deviceId
     * @param profileId
     */
    boolean notifyDriverUpdateDevice(Long deviceId, Long profileId);

    /**
     * 通知驱动 新增位号
     *
     * @param pointId
     * @param profileId
     */
    boolean notifyDriverAddPoint(Long pointId, Long profileId);

    /**
     * 通知驱动 删除位号
     *
     * @param pointId
     * @param profileId
     */
    boolean notifyDriverDeletePoint(Long pointId, Long profileId);

    /**
     * 通知驱动 修改位号
     *
     * @param pointId
     * @param profileId
     */
    boolean notifyDriverUpdatePoint(Long pointId, Long profileId);

    /**
     * 通知驱动 新增驱动配置
     *
     * @param driverInfoId
     * @param profileId
     */
    boolean notifyDriverAddDriverInfo(Long driverInfoId, Long profileId);

    /**
     * 通知驱动 删除驱动配置
     *
     * @param driverInfoId
     * @param attributeId
     * @param profileId
     */
    boolean notifyDriverDeleteDriverInfo(Long driverInfoId, Long attributeId, Long profileId);

    /**
     * 通知驱动 更新驱动配置
     *
     * @param driverInfoId
     * @param profileId
     */
    boolean notifyDriverUpdateDriverInfo(Long driverInfoId, Long profileId);

    /**
     * 通知驱动 新增位号配置
     *
     * @param pointInfoId
     * @param deviceId
     */
    boolean notifyDriverAddPointInfo(Long pointInfoId, Long deviceId);

    /**
     * 通知驱动 删除位号配置
     *
     * @param pointId
     * @param attributeId
     * @param deviceId
     */
    boolean notifyDriverDeletePointInfo(Long pointId, Long attributeId, Long deviceId);

    /**
     * 通知驱动 更新位号配置
     *
     * @param pointInfoId
     * @param deviceId
     */
    boolean notifyDriverUpdatePointInfo(Long pointInfoId, Long deviceId);
}
