#
# Copyright 2016-present the IoT DC3 original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# runtime
FROM registry.cn-beijing.aliyuncs.com/dc3/dc3-jre:21 AS runtime
LABEL dc3.author pnokers
LABEL dc3.author.email pnokers.icloud.com

# default env
ENV PARAMS     ''
ENV NODE_ENV   dev
ENV COAP_PORT  5683
ENV COAPS_PORT 5684

# default jvm & gc env
ENV JAVA_OPS -server \
             -Xms256m \
             -Xmx1024m \
             -Djava.security.egd=file:/dev/./urandom \
             -XX:+UseG1GC
ENV GC_LOG   -Xlog:gc*:file=dc3/logs/driver/lwm2m/gc/gc.log:time,uptime,level,tags:filecount=20,filesize=10M

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

WORKDIR /dc3-driver/dc3-driver-lwm2m

ADD ./target/dc3-driver-lwm2m.jar ./

EXPOSE ${COAP_PORT}
EXPOSE ${COAPS_PORT}
VOLUME /dc3-driver/dc3-driver-lwm2m/dc3/logs

CMD mkdir -p /dc3-driver/dc3-driver-lwm2m/dc3/logs/driver/lwm2m/gc \
    && java ${JAVA_OPS} ${GC_LOG} -jar dc3-driver-lwm2m.jar ${PARAMS}
