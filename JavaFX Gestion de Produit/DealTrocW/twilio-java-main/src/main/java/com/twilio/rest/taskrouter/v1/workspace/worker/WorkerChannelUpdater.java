/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class WorkerChannelUpdater extends Updater<WorkerChannel>{
    private String pathWorkspaceSid;
    private String pathWorkerSid;
    private String pathSid;
    private Integer capacity;
    private Boolean available;

    public WorkerChannelUpdater(final String pathWorkspaceSid, final String pathWorkerSid, final String pathSid){
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.pathWorkerSid = pathWorkerSid;
        this.pathSid = pathSid;
    }

    public WorkerChannelUpdater setCapacity(final Integer capacity){
        this.capacity = capacity;
        return this;
    }
    public WorkerChannelUpdater setAvailable(final Boolean available){
        this.available = available;
        return this;
    }

    @Override
    public WorkerChannel update(final TwilioRestClient client){
        String path = "/v1/Workspaces/{WorkspaceSid}/Workers/{WorkerSid}/Channels/{Sid}";

        path = path.replace("{"+"WorkspaceSid"+"}", this.pathWorkspaceSid.toString());
        path = path.replace("{"+"WorkerSid"+"}", this.pathWorkerSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("WorkerChannel update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return WorkerChannel.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (capacity != null) {
            request.addPostParam("Capacity", capacity.toString());
    
        }
        if (available != null) {
            request.addPostParam("Available", available.toString());
    
        }
    }
}
