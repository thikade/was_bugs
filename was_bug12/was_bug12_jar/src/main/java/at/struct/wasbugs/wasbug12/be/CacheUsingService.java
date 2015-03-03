/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package at.struct.wasbugs.wasbug12.be;

import javax.enterprise.context.ApplicationScoped;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

@ApplicationScoped
public class CacheUsingService {

    private static final Logger log = Logger.getLogger(CacheUsingService.class.getName());


    private volatile SimpleCache cache;
    private volatile int reloads;

    public CacheUsingService() {
        setCache(new SimpleCache(new Date()));
        reloads = 0;
    }

    public CacheInfo getCacheInfo() {
        log();
        return new CacheInfo(cache.getLastUpdate(), reloads);
    }


    void setCache(SimpleCache cache) {
        log();

        reloads++;
        this.cache = cache;
    }


    private void log() {
        int c = this.toString().indexOf("CacheUsingService");
        //String id = this.toString().substring(c);
        String id = this.toString().substring(c + "CacheUsingService".length());
        log.log(Level.INFO, "XXX {0} {1} {2}", new Object[]{id,reloads,Thread.currentThread().getName() });
        log.log(Level.INFO, "current thread: {0} - value of reloads: {1}, instance {2}", new Object[] {Thread.currentThread().getName(), reloads, this, id});
    }
}
