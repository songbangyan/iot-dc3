/*
 * Copyright 2019 Pnoker. All Rights Reserved.
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

package com.pnoker.center.dbs.rpc;

import com.github.pagehelper.PageInfo;
import com.pnoker.api.dbs.rtmp.feign.RtmpDbsFeignApi;
import com.pnoker.center.dbs.service.RtmpService;
import com.pnoker.common.base.BaseController;
import com.pnoker.common.base.BasePage;
import com.pnoker.common.dto.transfer.RtmpDto;
import com.pnoker.common.model.rtmp.Rtmp;
import com.pnoker.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>rtmp dbs rest client
 *
 * @author : pnoker
 * @email : pnokers@icloud.com
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v3/dbs/rtmp")
public class RtmpDbsRestClient extends BaseController implements RtmpDbsFeignApi {
    @Autowired
    private RtmpService rtmpService;

    @Override
    @PostMapping("/")
    public Response<Long> add(@RequestBody Rtmp rtmp) {
        if (null == rtmp) {
            return Response.fail("body is null");
        }
        rtmpService.add(rtmp);
        return rtmp.getId() > 0 ? Response.ok(rtmp.getId()) : Response.fail();
    }

    @Override
    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@PathVariable Long id) {
        if (null == id) {
            return Response.fail("rtmp id can not be empty");
        }
        return rtmpService.delete(id) ? Response.ok() : Response.fail();
    }

    @Override
    @PutMapping("/")
    public Response<Boolean> update(@RequestBody Rtmp rtmp) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public Response<Rtmp> selectById(@PathVariable Long id) {
        if (null == id) {
            return Response.fail("rtmp id can not be empty");
        }
        Rtmp rtmp = rtmpService.selectById(id);
        return null != rtmp ? Response.ok(rtmp) : Response.fail("id does not exist");
    }

    @Override
    @GetMapping("/")
    public Response<PageInfo<Rtmp>> selectByQueryAndPage(@RequestBody(required = false) RtmpDto rtmpDto) {
        Rtmp rtmp = new Rtmp();
        if (null != rtmpDto) {
            BeanUtils.copyProperties(rtmpDto, rtmp);
        }
        BasePage page = new BasePage();
        if (null != rtmpDto.getPage()) {
            BeanUtils.copyProperties(rtmpDto.getPage(), page);
        }
        return Response.ok(rtmpService.listWithPage(rtmp, page));
    }
}