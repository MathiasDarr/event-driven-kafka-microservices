package org.mddarr.ui.request.service.mvc;

import lombok.Value;

//tag::class[]
@Value
public class FieldErrorResponse {
    private String fieldName;
    private String errorMessage;
}
//end::class[]