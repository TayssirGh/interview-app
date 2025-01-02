package com.dist.interview.core.model.payload;

import com.dist.interview.core.App;
import lombok.Data;

@Data
public class VersionResponse {
    private String version= App.API_VERSION;
}
