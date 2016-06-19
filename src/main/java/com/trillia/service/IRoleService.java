package com.trillia.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by mmathew on 05/06/16.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IRoleService {


    @WebMethod
    String[] getRoles(long userID);
}
