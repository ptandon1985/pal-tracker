package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String index;
    private String address;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}")  String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String index,
                         @Value("${cf.instance.addr:NOT SET}") String address) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.index = index;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();
        envMap.put("PORT",this.port);
        envMap.put("MEMORY_LIMIT",this.memoryLimit);
        envMap.put("CF_INSTANCE_INDEX",this.index);
        envMap.put("CF_INSTANCE_ADDR",this.address);

        return envMap;
    }
}
