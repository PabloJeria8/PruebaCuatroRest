package com.example.pablojeria.pruebacuatrorest.views;

/**
 * Created by pablojeria on 12-11-17.
 */

public class Signin {

    private SessionCallback callback;

    public Signin (SessionCallback callback) {
        this.callback = callback;
    }

    public void toServer ()
    {

     callback.success();

    }



}
