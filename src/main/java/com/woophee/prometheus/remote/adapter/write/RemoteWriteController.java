package com.woophee.prometheus.remote.adapter.write;

import com.woophee.prometheus.remote.adapter.write.service.RemoteWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RemoteWriteController {

    @Autowired
    private RemoteWriteService remoteWriteService;

    @RequestMapping(value="/write",method= RequestMethod.GET)
    public void write(@RequestBody byte[] data){
        remoteWriteService.write(data);
    }
}
