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

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@Lock(value = LockType.WRITE)
public class CacheReloader {

    private static final Logger log = Logger.getLogger(CacheReloader.class.getName());


    private @Inject CacheUsingService service;


    @PostConstruct
    protected void init() {
        log.log(Level.INFO, "RRR postconstruct called" );
        reload();
    }


//    @Schedule(hour = "*", minute = "*/1")
    @Schedule(hour = "*", minute = "*", second = "*/10", persistent=false)
    public void reload() {

    	int c = service.toString().indexOf("CacheUsingService");
        String id = service.toString().substring(c + "CacheUsingService".length());
        log.log(Level.INFO, "RRR {0}", id );

        log.log(Level.INFO, "Reloading Cache on instance {0}", service);

        // know lets do some heavy work
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // bad luck
            log.log(Level.WARNING, "Thread {0} interrupted", Thread.currentThread().getName());
        }

        service.setCache(new SimpleCache(new Date()));

        log.log(Level.INFO, "Reloaded Cache");
    }
}
