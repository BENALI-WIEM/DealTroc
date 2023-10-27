/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;


import java.util.List;


public class WebhookUpdater extends Updater<Webhook>{
    private String pathServiceSid;
    private String pathSid;
    private String friendlyName;
    private List<String> eventTypes;
    private String webhookUrl;
    private Webhook.Status status;
    private Webhook.Version version;

    public WebhookUpdater(final String pathServiceSid, final String pathSid){
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    public WebhookUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public WebhookUpdater setEventTypes(final List<String> eventTypes){
        this.eventTypes = eventTypes;
        return this;
    }
    public WebhookUpdater setEventTypes(final String eventTypes){
        return setEventTypes(Promoter.listOfOne(eventTypes));
    }
    public WebhookUpdater setWebhookUrl(final String webhookUrl){
        this.webhookUrl = webhookUrl;
        return this;
    }
    public WebhookUpdater setStatus(final Webhook.Status status){
        this.status = status;
        return this;
    }
    public WebhookUpdater setVersion(final Webhook.Version version){
        this.version = version;
        return this;
    }

    @Override
    public Webhook update(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/Webhooks/{Sid}";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Webhook update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (eventTypes != null) {
            for (String prop : eventTypes) {
                request.addPostParam("EventTypes", prop);
            }
    
        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl);
    
        }
        if (status != null) {
            request.addPostParam("Status", status.toString());
    
        }
        if (version != null) {
            request.addPostParam("Version", version.toString());
    
        }
    }
}