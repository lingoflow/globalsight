/**
 *  Copyright 2009 Welocalize, Inc. 
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  
 *  You may obtain a copy of the License at 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */
package com.plug;

import java.io.File;

import org.apache.log4j.Logger;

import com.util.ServerUtil;

public class Plug_8_5_1 implements Plug
{
	private static Logger log = Logger.getLogger(Plug_8_5_1.class);
	
    @Override
    public void run()
    {
		File f = new File(ServerUtil.getPath() + "/jboss/server/standalone/deployments/globalsight.ear/lib/safaba-mtconnect-api.jar");
		if (f.exists()) 
		{
			f.delete();
		}
    }
}
