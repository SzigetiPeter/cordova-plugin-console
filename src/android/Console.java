/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova.console;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

/**
 * This class forward javascript console to the logcat. 
 * */
public class Console extends CordovaPlugin{
    public static final String TAG = "Console";

    /**
     * Constructor.
     */
    public Console() {
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
     @Override
    public boolean execute(String action, JSONArray args,
        CallbackContext callbackContext) throws JSONException {
        if (action.equals("logLevel")) {
        this.logLevel(args.getString(0), args.getString(1));
        }
        else {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------------------------
    // LOCAL METHODS
    //--------------------------------------------------------------------------

    /**
     * Forwards the log message to logcat at the specified log level.
     *
     * @param level      Level of the log.
     * @param message    Message of the log.
     */

    public void logLevel(String level, String message) {
        if(level.equals("ERROR"))
            Log.e(TAG, message);
        if(level.equals("WARN"))
            Log.w(TAG, message);
        if(level.equals("INFO"))
            Log.i(TAG, message);
        if(level.equals("DEBUG"))
            Log.d(TAG, message);
        if(level.equals("LOG"))
            Log.wtf(TAG, message);
    }

}
