package com.dist.interview.core.infra.model.payload;

import com.dist.interview.core.infra.App;
import lombok.Data;

@Data
public class VersionResponse {
    private String version= App.API_VERSION;
}
