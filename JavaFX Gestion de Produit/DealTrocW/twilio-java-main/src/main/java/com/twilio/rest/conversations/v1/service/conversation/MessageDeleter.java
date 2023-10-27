/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.conversation;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;



public class MessageDeleter extends Deleter<Message> {
    private String pathChatServiceSid;
    private String pathConversationSid;
    private String pathSid;
    private Message.WebhookEnabledType xTwilioWebhookEnabled;

    public MessageDeleter(final String pathChatServiceSid, final String pathConversationSid, final String pathSid){
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathConversationSid = pathConversationSid;
        this.pathSid = pathSid;
    }

    public MessageDeleter setXTwilioWebhookEnabled(final Message.WebhookEnabledType xTwilioWebhookEnabled){
        this.xTwilioWebhookEnabled = xTwilioWebhookEnabled;
        return this;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Conversations/{ConversationSid}/Messages/{Sid}";

        path = path.replace("{"+"ChatServiceSid"+"}", this.pathChatServiceSid.toString());
        path = path.replace("{"+"ConversationSid"+"}", this.pathConversationSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.DELETE,
            Domains.CONVERSATIONS.toString(),
            path
        );
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Message delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
    private void addHeaderParams(final Request request) {
        if (xTwilioWebhookEnabled != null) {
            request.addHeaderParam("X-Twilio-Webhook-Enabled", xTwilioWebhookEnabled.toString());

        }
    }
}
