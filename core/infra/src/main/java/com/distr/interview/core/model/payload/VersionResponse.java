package com.distr.interview.core.model.payload;

import com.distr.interview.core.App;
import lombok.Data;

@Data
public class VersionResponse {
    private String version= App.API_VERSION;
}
