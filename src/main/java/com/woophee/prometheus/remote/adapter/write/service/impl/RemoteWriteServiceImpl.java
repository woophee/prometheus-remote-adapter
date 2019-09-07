package com.woophee.prometheus.remote.adapter.write.service.impl;

import com.woophee.prometheus.remote.adapter.write.service.RemoteWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xerial.snappy.Snappy;
import java.io.IOException;
import prometheus.Remote;

@Service
public class RemoteWriteServiceImpl implements RemoteWriteService {
    private Logger logger = LoggerFactory.getLogger(RemoteWriteServiceImpl.class);

    @Override
    public void write(byte[] data) {
        try {
            byte[] compressed = Snappy.uncompress(data);
            Remote.WriteRequest writeRequest = Remote.WriteRequest.parseFrom(compressed);
            logger.info("Received data from Prometheus: " + writeRequest);
        } catch (IOException e) {
            logger.info("Receive data from Prometheus error", e);
        }
    }

}
