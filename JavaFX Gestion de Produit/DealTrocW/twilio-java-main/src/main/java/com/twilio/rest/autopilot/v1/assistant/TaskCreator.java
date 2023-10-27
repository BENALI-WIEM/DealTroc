/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.autopilot.v1.assistant;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.Map;
import com.twilio.converter.Converter;
import java.net.URI;

import java.util.Map;


import java.net.URI;

public class TaskCreator extends Creator<Task>{
    private String pathAssistantSid;
    private String uniqueName;
    private String friendlyName;
    private Map<String, Object> actions;
    private URI actionsUrl;

    public TaskCreator(final String pathAssistantSid, final String uniqueName) {
        this.pathAssistantSid = pathAssistantSid;
        this.uniqueName = uniqueName;
    }

    public TaskCreator setUniqueName(final String uniqueName){
        this.uniqueName = uniqueName;
        return this;
    }
    public TaskCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public TaskCreator setActions(final Map<String, Object> actions){
        this.actions = actions;
        return this;
    }
    public TaskCreator setActionsUrl(final URI actionsUrl){
        this.actionsUrl = actionsUrl;
        return this;
    }

    public TaskCreator setActionsUrl(final String actionsUrl){
        return setActionsUrl(Promoter.uriFromString(actionsUrl));
    }

    @Override
    public Task create(final TwilioRestClient client){
        String path = "/v1/Assistants/{AssistantSid}/Tasks";

        path = path.replace("{"+"AssistantSid"+"}", this.pathAssistantSid.toString());
        path = path.replace("{"+"UniqueName"+"}", this.uniqueName.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Task creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Task.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (actions != null) {
            request.addPostParam("Actions",  Converter.mapToJson(actions));
    
        }
        if (actionsUrl != null) {
            request.addPostParam("ActionsUrl", actionsUrl.toString());
    
        }
    }
}