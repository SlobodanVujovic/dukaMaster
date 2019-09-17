package com.mds.dukamaster.business.boundary;

import com.mds.dukamaster.business.entity.AppEntity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Dell
 */
@Path("app")
public class AppResources {

    @GET
    public AppEntity findApp() {
        return new AppEntity();
    }

}
