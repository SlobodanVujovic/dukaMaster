package com.mds.dukamaster.business.boundary;

import com.google.gson.Gson;
import com.mds.dukamaster.business.entity.AppEntity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dell
 */
@Path("app")
public class AppResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findApp() {
        AppEntity appEntity = new AppEntity();
        //Koristis GSON da prebacis AppEntity u JSON. Ili mozes i JSON-P da koristis ali treba vise koda.
        Gson gson = new Gson();
        return gson.toJson(appEntity);
    }

}
